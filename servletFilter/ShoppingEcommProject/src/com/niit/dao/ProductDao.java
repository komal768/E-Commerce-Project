
package com.niit.dao;

import java.util.List;

import com.niit.domain.Product;

public interface ProductDao {
     void save(Product u);
    void delete(Product u);
    List<Product> list();
    void update();
    Product get(int id);
    List<Product> byCategory(int id);
}
