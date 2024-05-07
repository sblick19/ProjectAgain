package test.javafx;
import java.util.Scanner;

public class MainStorePage {
	
    private UserManager userManager;
    private User currentUser;
    private BookInventory bookInventory;
    
    public MainStorePage(UserManager userManager, User currentUser) {
        this.userManager = userManager;
        this.currentUser = currentUser;
        
    }
    public MainStorePage(UserManager userManager, User currentUser, BookInventory bookInventory) {
        this.userManager = userManager;
        this.currentUser = currentUser;
        this.bookInventory = bookInventory;
    }


    public void display(Scanner scanner) { // Update the method signature to accept Scanner
        boolean exit = false;  // Declare exit variable outside the loop

        while (!exit) {
            System.out.println("Welcome to the Main Store Page, " + currentUser.getUsername() + "!");
            System.out.println("1) User Info Page");
            System.out.println("2) Shop Page");
            System.out.println("3) Order Page");
            System.out.println("4) Logout");

            System.out.print("Please enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int

            switch (choice) {
                case 1:
                    displayUserInfoPage(scanner);
                    break;
                case 2:
                    displayShopPage(scanner);  // Call displayShopPage with the scanner
                    break;
                case 3:
                    displayOrderPage();
                    break;
                case 4:
                    System.out.println("Logging out...\n");
                    // Handle any additional logout logic here

                    // No need to close the scanner here since it's passed from outside

                    // Go back to the OpeningScreen
                    OpeningScreen openingScreen = new OpeningScreen(); // Instantiate OpeningScreen as needed
                    openingScreen.display(); // Display the opening screen with the same scanner
                    exit = true; // Set exit to true to exit the loop
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }

        // No need to close the scanner here since it's passed from outside
    }

    private void displayUserInfoPage(Scanner scanner) {
        System.out.println("\nUser Info Page");
        System.out.println("Current Username: " + currentUser.getUsername());
        System.out.println("1) Update Email");
        System.out.println("2) Update Password");
        System.out.println("3) Back");

        System.out.print("Please enter your choice (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                updateEmail(scanner);
                break;
            case 2:
                updatePassword(scanner);
                break;
            case 3:
                System.out.println("Going back to main store page...");
                display(scanner); // Pass the scanner to display method
                break;

            default:
                System.out.println("Invalid choice. Please select 1-3.");
        }
    }

    private void updateEmail(Scanner scanner) {
        System.out.print("Enter new email: ");
        String newEmail = scanner.next();
        currentUser.setEmail(newEmail);
        userManager.updateUserProfile(currentUser.getUsername(), newEmail);
        System.out.println("Email updated successfully.");
        displayUserInfoPage(scanner); // Return to user info page
    }

    private void updatePassword(Scanner scanner) {
        System.out.print("Enter current password: ");
        String oldPassword = scanner.next();
        if (currentUser.getPassword().equals(oldPassword)) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.next();
            currentUser.setPassword(newPassword);
            userManager.changeUserPassword(currentUser.getUsername(), oldPassword, newPassword);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Incorrect password. Password not updated.");
        }
        displayUserInfoPage(scanner); // Return to user info page
    }

    private void displayShopPage(Scanner scanner) {
         // Instantiate bookInventory locally
        ShoppingCart shoppingCart = new ShoppingCart(currentUser, bookInventory, userManager, this);  // Instantiate shoppingCart locally

        System.out.println("Opening Shop Page...");
        ShopPage shopPage = new ShopPage(bookInventory, shoppingCart, currentUser);
        shopPage.display();  // Display the shop page
    }

    private void displayOrderPage() {
        System.out.println("Order Page");

        // Instantiate orderManager locally
        OrderManager orderManager = OrderManager.getInstance();  // Example instantiation if it's a singleton

        // Initialize OrderPage and display
        OrderPage orderPage = new OrderPage(userManager, currentUser, orderManager, this);
        orderPage.display();
    }

}
