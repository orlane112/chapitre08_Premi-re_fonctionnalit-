package bookstoread;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class BookShelfSpec {

    private BookShelf shelf;

    @BeforeEach
    void init() {
        shelf = new BookShelf();
    }

    @Test
    void shelfEmptyWhenNoBookAdded() {
        List<Book> books = shelf.books();
        assertTrue(books.isEmpty(), "BookShelf should be empty.");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add("Effective Java", "Code Complete");

        List<Book> books = shelf.books();

        assertEquals(2, books.size(), "BookShelf should have two books.");
    }

    @Test
    void emptyBookShelfWhenAddIsCalledWithoutBooks() {
        shelf.add();

        List<Book> books = shelf.books();

        assertTrue(books.isEmpty(), "BookShelf should be empty.");
    }

    @Test
    void booksReturnedFromBookShelfIsImmutableForClient() {
        shelf.add("Effective Java", "Code Complete");

        List<Book> books = shelf.books();

        try {
            books.add(new Book("The Mythical Man-Month", "unknown", null));
            fail("Should not be able to add book to books");
        } catch (Exception e) {
            assertTrue(
                    e instanceof UnsupportedOperationException,
                    "Should throw UnsupportedOperationException."
            );
        }
    }

    @Test
    void bookshelfArrangedByBookTitle() {
        shelf.add(
                "Effective Java",
                "Code Complete",
                "The Mythical Man-Month"
        );

        List<Book> books = shelf.arrange();

        assertEquals(
                Arrays.asList(
                        new Book("Code Complete", "unknown", null),
                        new Book("Effective Java", "unknown", null),
                        new Book("The Mythical Man-Month", "unknown", null)
                ),
                books,
                "Books in a bookshelf should be arranged lexicographically by book title"
        );
    }

    @Test
    void booksInBookShelfAreInInsertionOrderAfterCallingArrange() {
        shelf.add(
                "Effective Java",
                "Code Complete",
                "The Mythical Man-Month"
        );

        try {
            shelf.arrange();
        } catch (ClassCastException ignored) {
            // attendu si Book n'implémente pas Comparable
        }

        List<Book> books = shelf.books();

        assertEquals(
                Arrays.asList(
                        new Book("Effective Java", "unknown", null),
                        new Book("Code Complete", "unknown", null),
                        new Book("The Mythical Man-Month", "unknown", null)
                ),
                books,
                "Books in bookshelf are in insertion order"
        );
    }
}