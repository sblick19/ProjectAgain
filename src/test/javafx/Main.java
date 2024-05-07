package test.javafx;

import java.util.List;

public class Main {
    // Declare bookInventory as a class-level variable
    private static BookInventory bookInventory;

    public static void main(String[] args) {
        // Create an instance of BookInventory
        bookInventory = new BookInventory();
        
        // Create an instance of AddBooks and pass the BookInventory instance
        AddBooks addBooks = new AddBooks(bookInventory);

        // Call the method to add example books
        addBooks.addExampleBooks();

        /*System.out.println("All books (before sorting):");
        List<Book> allBooks = bookInventory.getAllBooksList();
        displayBooks(allBooks);
        // Sort by Title A-Z
        List<Book> sortedByTitleAZ = bookInventory.sortByTitleAZ();
        System.out.println("\nBooks sorted by Title A-Z:");
        displayBooks(sortedByTitleAZ);

        // Sort by Title Z-A
        List<Book> sortedByTitleZA = bookInventory.sortByTitleZA();
        System.out.println("\nBooks sorted by Title Z-A:");
        displayBooks(sortedByTitleZA);

        // Sort by Author A-Z
        List<Book> sortedByAuthorAZ = bookInventory.sortByAuthorLastNameAZ();
        System.out.println("\nBooks sorted by Author A-Z:");
        displayBooks(sortedByAuthorAZ);

        // Sort by Author Z-A
        List<Book> sortedByAuthorZA = bookInventory.sortByAuthorLastNameZA();
        System.out.println("\nBooks sorted by Author Z-A:");
        displayBooks(sortedByAuthorZA);

        // Sort by Genre (e.g., Fiction)
        List<Book> sortedByGenre = bookInventory.sortByGenre("Fiction");
        System.out.println("\nBooks sorted by Genre (Fiction):");
        displayBooks(sortedByGenre); */

        // Other code to initialize UserManager, OrderManager, and display the opening screen
        UserManager userManager = new UserManager(); // Example, instantiate UserManager as needed
        OrderManager orderManager = new OrderManager(); // Example, instantiate OrderManager as needed

        OpeningScreen openingScreen = new OpeningScreen(userManager, bookInventory, orderManager);
        openingScreen.display(); // Start the application by displaying the opening screen
    }

   /* private static void displayBooks(List<Book> books) {
        for (Book book : books) {
            System.out.println(book.getTitle() + " | " + book.getAuthorFirstName() + " " + book.getAuthorLastName()
                    + " | $" + book.getPrice() + " | " + book.getGenre() + " | Quantity: " + book.getQuantity());
        }
    }*/
}


