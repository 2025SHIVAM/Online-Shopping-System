package com.shivam.shop;
import jakarta.persistence.*;import java.math.BigDecimal;
@Entity public class Product{
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;private String name,category,imageUrl;@Column(length=1500)private String description;private BigDecimal price;private Integer stock;
 public Product(){}public Product(String n,String d,BigDecimal p,String c,String image,Integer s){name=n;description=d;price=p;category=c;imageUrl=image;stock=s;}
 public Long getId(){return id;}public String getName(){return name;}public String getDescription(){return description;}public BigDecimal getPrice(){return price;}public String getCategory(){return category;}public String getImageUrl(){return imageUrl;}public Integer getStock(){return stock;}
 public void setName(String v){name=v;}public void setDescription(String v){description=v;}public void setPrice(BigDecimal v){price=v;}public void setCategory(String v){category=v;}public void setImageUrl(String v){imageUrl=v;}public void setStock(Integer v){stock=v;}
}
