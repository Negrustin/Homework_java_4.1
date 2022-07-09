package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.*;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {
    Product book1 = new Book(1, "book1", 200, "author1");
    Product smartphone1 = new Smartphone(2, "Phone2", 600, "producer2");

    Product book2 = new Book(3, "book3", 150, "author3");

    @Test
void emptyProductRepository(){
        ProductRepository repository = new ProductRepository();

        Product[] excepted = {};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(excepted,actual);
    }

    @Test
    void save() {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(book2);

        Product[] excepted = {book1, smartphone1, book2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void removeById() {
        ProductRepository repository = new ProductRepository();
        repository.save(book1);
        repository.save(smartphone1);
        repository.save(book2);

        repository.removeProductById(1);

        Product[] expected = {smartphone1, book2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }


}
