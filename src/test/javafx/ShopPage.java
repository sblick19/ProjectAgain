package test.javafx;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShopPage {
	private BookInventory bookInventory;
    private ShoppingCart shoppingCart;
    private User currentUser;
    private Scanner scanner; 
    private MainStorePage mainStorePage;

    public ShopPage(BookInventory bookInventory, ShoppingCart shoppingCart, User currentUser) {
        this.bookInventory = bookInventory;
        this.shoppingCart = shoppingCart;
        this.currentUser = currentUser;
        this.scanner = new Scanner(System.in);
        this.mainStorePage = mainStorePage;
    }

    public void display() {
    	
        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("\nShop Page");
                System.out.println("1) Search");
                System.out.println("2) Sort By");
                System.out.println("3) View Shopping Cart (" + shoppingCart.getTotalItems() + " items)");
                System.out.println("4) Back");
                System.out.print("Please enter your choice (1-4): ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        searchOptions();
                        break;
                    case 2:
                        sortByOptions();
                        break;
                    case 3:
                        shoppingCart.display();
                        break;
                    case 4:
                        exit = true;  // Set exit to true to exit the loop
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (NoSuchElementException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }

        scanner.close(); // Close the scanner when done
        List<Book> allBooks = bookInventory.getAllBooksList();  // Get all books from inventory
        addToCartOption(allBooks);
        mainStorePage.display(scanner);  // Display the main store page after exiting the shop page
    }






    private void sortByOptions() {
        System.out.println("\nSort By Options:");
        System.out.println("1) Sort by Title A-Z");
        System.out.println("2) Sort by Title Z-A");
        System.out.println("3) Sort by Author A-Z");
        System.out.println("4) Sort by Author Z-A");
        System.out.println("5) Sort by Genre");
        System.out.println("6) Back");

        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Please enter your choice (1-6): ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 6) {
                    validInput = true;
                } else {
                    System.out.println("Invalid choice. Please select 1-6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        switch (choice) {
            case 1:
                sortByTitleAZ();
                break;
            case 2:
                sortByTitleZA();
                break;
            case 3:
                sortByAuthorAZ();
                break;
            case 4:
                sortByAuthorZA();
                break;
            case 5:
                sortByGenreOption();
                break;
            case 6:
                // Back to main shop page
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void searchOptions() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nSearch Options:");
        System.out.println("1) Search by Genre");
        System.out.println("2) Search by Title");
        System.out.println("3) Search by Author");
        System.out.print("Please enter your choice (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();

        switch (choice) {
            case 1:
                searchByGenre(searchTerm);
                break;
            case 2:
                searchByTitle(searchTerm);
                break;
            case 3:
                searchByAuthor(searchTerm);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    private void searchByGenre(String genre) {
        List<Book> books = bookInventory.getAllBooksList();
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
        displaySearchResults(filteredBooks);
        addToCartOption(filteredBooks);
    }

    private void searchByTitle(String title) {
        List<Book> books = bookInventory.getAllBooksList();
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
        displaySearchResults(filteredBooks);
        addToCartOption(filteredBooks);
    }

    private void searchByAuthor(String author) {
        List<Book> books = bookInventory.getAllBooksList();
        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getAuthorFirstName().equalsIgnoreCase(author)
                        || book.getAuthorLastName().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        displaySearchResults(filteredBooks);
        addToCartOption(filteredBooks);
    }

    private void displaySearchResults(List<Book> books) {
        if (!books.isEmpty()) {
            System.out.println("\nSearch Results:");
            for (Book book : books) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found matching the search criteria.");
        }
    }
   
    private void sortByTitleAZ() {
        List<Book> sortedBooks = bookInventory.sortByTitleAZ();
        displayBooks(sortedBooks);
        addToCartOption(sortedBooks);
    }

    private void sortByTitleZA() {
        List<Book> sortedBooks = bookInventory.sortByTitleZA();
        displayBooks(sortedBooks);
        addToCartOption(sortedBooks);
    }

    private void sortByAuthorAZ() {
        List<Book> sortedBooks = bookInventory.sortByAuthorLastNameAZ();
        displayBooks(sortedBooks);
        addToCartOption(sortedBooks);
    }

    private void sortByAuthorZA() {
        List<Book> sortedBooks = bookInventory.sortByAuthorLastNameZA();
        displayBooks(sortedBooks);
        addToCartOption(sortedBooks);
    }
    
    private void sortByGenreOption() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nGenre Options:");
        System.out.println("1) Fiction");
        System.out.println("2) Non-Fiction");
        System.out.println("3) Mystery");
        System.out.println("4) Science Fiction");
        System.out.println("5) Fantasy");
        System.out.println("6) Romance");
        System.out.println("7) Horror");
        System.out.println("8) Thriller");
        System.out.println("9) Biography");
        System.out.println("10) History");
        System.out.println("11) Self-Help");
        System.out.println("12) Poetry");
        System.out.println("13) Children");

        System.out.print("Enter the number of the genre to sort by: ");
        int genreChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Perform sorting based on genre choice
        switch (genreChoice) {
            case 1:
                sortByGenre("Fiction");
                break;
            case 2:
                sortByGenre("Non-Fiction");
                break;
            case 3:
                sortByGenre("Mystery");
                break;
            case 4:
                sortByGenre("Science Fiction");
                break;
            case 5:
                sortByGenre("Fantasy");
                break;
            case 6:
                sortByGenre("Romance");
                break;
            case 7:
                sortByGenre("Horror");
                break;
            case 8:
                sortByGenre("Thriller");
                break;
            case 9:
                sortByGenre("Biography");
                break;
            case 10:
                sortByGenre("History");
                break;
            case 11:
                sortByGenre("Self-Help");
                break;
            case 12:
                sortByGenre("Poetry");
                break;
            case 13:
                sortByGenre("Children");
                break;
            default:
                System.out.println("Invalid genre choice.");
                break;
        }

        scanner.close();
    }

    private void sortByGenre(String genre) {
        List<Book> genreBooks = bookInventory.sortByGenre(genre);

        if (genreBooks.isEmpty()) {
            System.out.println("No books found in the " + genre + " genre.");
        } else {
            displayBooks(genreBooks);
            addToCartOption(genreBooks);
        }
    }


    private void displayBooks(List<Book> books) {
        int index = 1;
        for (Book book : books) {
            System.out.println(index + ") " + book.getTitle() + " | " + book.getAuthorFirstName() + " " +
                    book.getAuthorLastName() + " | $" + book.getPrice() + " | " + book.getGenre() +
                    " | Stock: " + book.getStock());
            index++;
        }
    }



    private void addToCartOption(List<Book> books) {
        boolean addToCart = true;

        while (addToCart) {
            // Display books and get user input for choice
        	  System.out.print("Enter book number to add to cart (0 to go back): ");

            int choice = scanner.nextInt();  // Get user choice
            scanner.nextLine(); // Consume newline

            if (choice > 0 && choice <= books.size()) {
                Book selectedBook = books.get(choice - 1);
                System.out.print("Enter quantity to add to cart: ");
                int quantityToAdd = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                shoppingCart.addItem(selectedBook, quantityToAdd);
                System.out.println(quantityToAdd + " copies of " + selectedBook.getTitle() + " added to cart.");
                
                // Update cart count display after adding item
               
                System.out.println("Items in cart: " + shoppingCart.getTotalItems());
            } else if (choice == 0) {
                addToCart = false; // Exit the loop and go back
            } else {
                System.out.println("Invalid book number.");
            }
        }
    }
  }
    

