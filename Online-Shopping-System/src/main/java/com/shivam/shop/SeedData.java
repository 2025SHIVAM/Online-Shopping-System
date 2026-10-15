package com.shivam.shop;
import org.springframework.boot.CommandLineRunner;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import java.math.BigDecimal;
@Configuration public class SeedData{
 @Bean CommandLineRunner seed(ProductRepository r){return args->{if(r.count()==0){
 r.save(new Product("Wireless Headphones","Comfortable wireless headphones.",new BigDecimal("1499"),"Electronics","https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=700",25));
 r.save(new Product("Everyday Backpack","Lightweight backpack with laptop compartment.",new BigDecimal("999"),"Accessories","https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=700",18));
 r.save(new Product("Classic Watch","Minimal everyday watch.",new BigDecimal("1799"),"Accessories","https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=700",12));
 r.save(new Product("Running Shoes","Lightweight running and walking trainers.",new BigDecimal("2299"),"Fashion","https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=700",20));
 r.save(new Product("Desk Lamp","Adjustable lamp for your study desk.",new BigDecimal("799"),"Home","https://images.unsplash.com/photo-1507473885765-e6ed057f782c?w=700",14));
 r.save(new Product("Water Bottle","Reusable bottle for work and travel.",new BigDecimal("399"),"Lifestyle","https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=700",30));
 }};}
}
