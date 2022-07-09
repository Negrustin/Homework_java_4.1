package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] productItem = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[productItem.length + 1];
        for (int i = 0; i < productItem.length; i++) {
            tmp[i] = productItem[i];
        }
        tmp[tmp.length - 1] = product;
        productItem = tmp;
    }

    public void removeProductById(int id) {
        Product[] tmp = new Product[productItem.length - 1];
        int copyToIndex = 0;
        for (Product item : productItem) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        productItem = tmp;

    }


    public Product[] findAll() {
        return productItem;
    }
}
