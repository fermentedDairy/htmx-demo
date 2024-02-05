package org.fermented.dairy.htmx.demo.controller;

import jakarta.enterprise.context.ApplicationScoped;
import org.fermented.dairy.htmx.demo.entity.BookStore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class BookStoreService {

    private static List<BookStore> bookStores = new ArrayList<>();

    public BookStore addBookStore(final BookStore bookStore) {
        final BookStore toBeAdded = new BookStore(bookStore);
        toBeAdded.setId(
                bookStores.stream()
                        .map(BookStore::getId)
                        .mapToLong(l -> l)
                        .max().orElse(0) + 1
        );
        bookStores.add(toBeAdded);
        return toBeAdded;
    }

    public List<BookStore> getBooksters() {
        return Collections.unmodifiableList(bookStores);
    }

}
