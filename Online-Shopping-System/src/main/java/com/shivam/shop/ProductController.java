package com.shivam.shop;
import org.springframework.web.bind.annotation.*;import org.springframework.http.HttpStatus;import org.springframework.web.server.ResponseStatusException;import java.util.List;
@RestController @RequestMapping("/api/products") @CrossOrigin
public class ProductController{
 private final ProductRepository repo;public ProductController(ProductRepository r){repo=r;}
 @GetMapping public List<Product> all(@RequestParam(required=false)String q){return q==null||q.isBlank()?repo.findAll():repo.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(q,q);}
 @GetMapping("/{id}")public Product one(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Product not found"));}
 @PostMapping @ResponseStatus(HttpStatus.CREATED)public Product create(@RequestBody Product p){return repo.save(p);}
 @PutMapping("/{id}")public Product update(@PathVariable Long id,@RequestBody Product x){Product p=one(id);p.setName(x.getName());p.setDescription(x.getDescription());p.setPrice(x.getPrice());p.setCategory(x.getCategory());p.setImageUrl(x.getImageUrl());p.setStock(x.getStock());return repo.save(p);}
 @DeleteMapping("/{id}")@ResponseStatus(HttpStatus.NO_CONTENT)public void delete(@PathVariable Long id){repo.delete(one(id));}
}
