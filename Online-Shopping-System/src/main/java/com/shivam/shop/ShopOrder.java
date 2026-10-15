package com.shivam.shop;
import jakarta.persistence.*;import java.math.BigDecimal;import java.time.LocalDateTime;
@Entity @Table(name="shop_orders") public class ShopOrder{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY)private Long id;private String customerName,email,address,status;@Column(length=5000)private String itemsJson;private BigDecimal total;private LocalDateTime createdAt=LocalDateTime.now();
 public ShopOrder(){}public ShopOrder(String n,String e,String a,String items,BigDecimal t){customerName=n;email=e;address=a;itemsJson=items;total=t;status="PLACED";createdAt=LocalDateTime.now();}
 public Long getId(){return id;}public String getCustomerName(){return customerName;}public String getEmail(){return email;}public String getAddress(){return address;}public String getItemsJson(){return itemsJson;}public BigDecimal getTotal(){return total;}public String getStatus(){return status;}public LocalDateTime getCreatedAt(){return createdAt;}public void setStatus(String s){status=s;}
}
