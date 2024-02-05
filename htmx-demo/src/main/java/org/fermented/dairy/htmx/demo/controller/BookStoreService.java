package org.fermented.dairy.htmx.demo.controller;

import jakarta.enterprise.context.ApplicationScoped;
import org.fermented.dairy.htmx.demo.entity.BookStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class BookStoreService {

    private static List<BookStore> bookStores = new ArrayList<>();

    public void addBookStore(final BookStore bookStore) {
        bookStores.add(bookStore);
        System.out.println(bookStores);
    }

    public List<BookStore> getBooksters() {
        System.out.println(bookStores);
        return Collections.unmodifiableList(bookStores);
    }

}
