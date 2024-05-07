package test.javafx;

import java.util.List;

public interface BookSorter {
    List<Book> sortByGenre(String genre);

    List<Book> sortByTitle(String title);

    List<Book> sortByAuthor(String author);

    List<Book> sortByTitleAZ();

    List<Book> sortByTitleZA();

    List<Book> sortByAuthorLastNameAZ();

    List<Book> sortByAuthorLastNameZA();
}
