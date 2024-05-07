package test.javafx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class BookInventory implements BookSorter {
    private List<Book> books;
    

    public BookInventory() {
        this.books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }
    public boolean removeBook(Book book) {
        // Logic to remove book from inventory
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book currentBook = iterator.next();
            if (currentBook.getBookId() == book.getBookId()) {
                iterator.remove();
                return true;
            }
        }
        return false; // Book not found in inventory
    }
    public List<Book> getAllBooksList() {
        return new ArrayList<>(books); // Return a copy of the books list
    }

    @Override
    public List<Book> sortByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthorFirstName().equalsIgnoreCase(author) || book.getAuthorLastName().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByTitleAZ() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByTitleZA() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getTitle).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByAuthorLastNameAZ() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getAuthorLastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortByAuthorLastNameZA() {
        return books.stream()
                .sorted(Comparator.comparing(Book::getAuthorLastName).reversed())
                .collect(Collectors.toList());
    }

    // Additional methods for book inventory management

    public void increaseStock(Book book, int quantity) {
        // Increase the stock of a book by the given quantity
        for (int i = 0; i < quantity; i++) {
            books.add(book);
        }
    }

    public void decreaseStock(Book book, int quantity) {
        // Decrease the stock of a book by the given quantity
        for (int i = 0; i < quantity; i++) {
            books.remove(book);
        }
    }
    public List<Book> getBooksByGenre(String genre) {
        List<Book> booksByGenre = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                booksByGenre.add(book);
            }
        }
        return booksByGenre;
    }
}
