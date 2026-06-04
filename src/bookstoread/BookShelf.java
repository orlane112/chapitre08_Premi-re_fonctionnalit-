package bookstoread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookShelf {

    private final List<Book> books = new ArrayList<>();

    public List<Book> books() {
        return Collections.unmodifiableList(books);
    }

    public void add(String... booksToAdd) {
        for (String title : booksToAdd) {
            books.add(new Book(title, "unknown", null));
        }
    }

    public List<Book> arrange() {
        return books.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}