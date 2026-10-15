package com.shivam.shop;
import com.fasterxml.jackson.databind.ObjectMapper;import org.springframework.web.bind.annotation.*;import org.springframework.http.HttpStatus;import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;import java.util.*;
@RestController @RequestMapping("/api/orders") @CrossOrigin
public class OrderController{
 private final ProductRepository products;private final OrderRepository orders;private final ObjectMapper mapper;
 public OrderController(ProductRepository p,OrderRepository o,ObjectMapper m){products=p;orders=o;mapper=m;}
 public static class Item{public Long productId;public Integer quantity;}
 public static class Checkout{public String customerName,email,address;public List<Item> items;}
 @PostMapping @ResponseStatus(HttpStatus.CREATED)public ShopOrder checkout(@RequestBody Checkout c){
  if(blank(c.customerName)||blank(c.email)||blank(c.address)||c.items==null||c.items.isEmpty())throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name, email, address and cart items are required");
  BigDecimal total=BigDecimal.ZERO;List<Map<String,Object>> snapshot=new ArrayList<>();
  for(Item i:c.items){if(i.productId==null||i.quantity==null||i.quantity<1)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid cart item");
   Product p=products.findById(i.productId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));
   if(p.getStock()==null||p.getStock()<i.quantity)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Insufficient stock for "+p.getName());
   total=total.add(p.getPrice().multiply(BigDecimal.valueOf(i.quantity)));Map<String,Object> row=new LinkedHashMap<>();row.put("productId",p.getId());row.put("name",p.getName());row.put("price",p.getPrice());row.put("quantity",i.quantity);snapshot.add(row);
  }
  for(Item i:c.items){Product p=products.findById(i.productId).orElseThrow();p.setStock(p.getStock()-i.quantity);products.save(p);}
  try{return orders.save(new ShopOrder(c.customerName,c.email,c.address,mapper.writeValueAsString(snapshot),total));}
  catch(Exception ex){throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Could not save order");}
 }
 private boolean blank(String s){return s==null||s.isBlank();}
 @GetMapping public List<ShopOrder> all(){return orders.findAll();}
 @PatchMapping("/{id}/status")public ShopOrder status(@PathVariable Long id,@RequestParam String status){
  ShopOrder o=orders.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Order not found"));
  String s=status.toUpperCase(Locale.ROOT);if(!Set.of("PLACED","PROCESSING","SHIPPED","DELIVERED","CANCELLED").contains(s))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid status");
  o.setStatus(s);return orders.save(o);
 }
}
