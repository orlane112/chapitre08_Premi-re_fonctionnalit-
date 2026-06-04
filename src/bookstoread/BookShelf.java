package bookstoread;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {
    private final List<Book> books = new ArrayList<>();

    public List<String> books() {
        return Collections.unmodifiableList(
                books.stream()
                        .sorted()
                        .map(Book::getTitle)
                        .collect(Collectors.toList())
        );
    }

    public void add(String... booksToAdd) {
        for (String title : booksToAdd) {
            books.add(new Book(title, "unknown", null));
        }
    }

    public List<String> arrange() {
        return books.stream()
                .map(Book::getTitle)
                .sorted()
                .collect(Collectors.toList());
    }

}