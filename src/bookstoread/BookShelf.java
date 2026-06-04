package bookstoread;

import java.util.*;
import java.util.stream.Collectors;

public class BookShelf {
    private final List<Book> books = new ArrayList<>();

    public List<Book> books() {
        return Collections.unmodifiableList(
                books.stream()
                        .sorted(Comparator.comparing(Book::getTitle))
                        .collect(Collectors.toList())
        );
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