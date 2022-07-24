package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    Product book1 = new Book(1, "Lord of the rings", 250, "John Ronald Reuel Tolkien");
    Product smartphone1 = new Smartphone(2, "IphoneX", 24000, "Apple");
    Product smartphone2 = new Smartphone(4, "Iphone8", 1500, "Apple");
    Product book2 = new Book(3, "book3", 150, "author3");
    Product smartphone3 = new Smartphone(12, "mi 8 lite", 3455, "Xiaomi");
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    public void showAllProducts() {

        Product[] excepted = {book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void searchByNameProduct() {
        Product[] excepted = {book1};
        Product[] actual = manager.searchBy("Lord");

        Assertions.assertArrayEquals(excepted, actual);

    }

    @Test
    public void severalNamesContain() {
        Product[] excepted = {smartphone1, smartphone2};
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void searchBookByAuthor() {

        Product[] excepted = {book1};
        Product[] actual = manager.searchBy("Tolkien");

        Assertions.assertArrayEquals(excepted, actual);
    }

    @Test
    public void searchSmartphoneByProducer() {
        Product[] excepted = {smartphone3};
        Product[] actual = manager.searchBy("Xiaomi");

        Assertions.assertArrayEquals(excepted, actual);
    }


}
