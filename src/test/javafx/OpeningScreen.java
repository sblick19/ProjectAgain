package test.javafx;

import java.util.Scanner;

public class OpeningScreen {
	private UserManager userManager;
	private BookInventory bookInventory;
	private OrderManager orderManager;
	private Scanner scanner;

	 public OpeningScreen(UserManager userManager, BookInventory bookInventory, OrderManager orderManager) {
	        this.userManager = userManager;
	        this.bookInventory = bookInventory;
	        this.orderManager = orderManager;
	        this.scanner = new Scanner(System.in);
	    }
	 
    public OpeningScreen() {
        userManager = UserManager.getInstance();
       
        orderManager = OrderManager.getInstance();
        scanner = new Scanner(System.in);
    }

    public void display() {
    	 System.out.println("Welcome to the Book Store!");
         System.out.println("1) Create user");
         System.out.println("2) Login");

         System.out.print("Please enter your choice (1 or 2): ");
         int choice = scanner.nextInt();

         if (choice == 1) {
             createUser(scanner);
         } else if (choice == 2) {
             login(scanner);
         } else {
             System.out.println("Invalid choice. Please select 1 or 2.");
         }

         scanner.close();
    }

    public void createUser(Scanner scanner) {
        System.out.println("\nCreate a new user account:");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        int userId = generateUserId(); // You can implement this method as needed

        if (userManager.createUser(userId, username, password, email)) {
            System.out.println("User created: " + username);
            System.out.println("User created successfully!");

            // Redirect to the main shop page
            User currentUser = userManager.getUserByUsername(username);
            MainStorePage mainStorePage = new MainStorePage(userManager, currentUser);
            mainStorePage.display(scanner); // Pass the scanner object to the display method
        } else {
            System.out.println("Failed to create user. Please try again.");
        }
    }


    private void login(Scanner scanner) {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("\nLogin to your account:");
            System.out.println("1) Customer Login");
            System.out.println("2) Admin Login");
            System.out.println("3) Back to Main Menu");

            try {
                System.out.print("Please enter your choice (1, 2, or 3): ");
                int choice = Integer.parseInt(scanner.nextLine());  // Read input as String and then parse

                switch (choice) {
                    case 1:
                        System.out.print("Enter your username: ");
                        String username = scanner.nextLine();

                        System.out.print("Enter your password: ");
                        String password = scanner.nextLine();

                        if (customerLogin(username, password)) {
                            // Customer login successful, move to MainStorePage
                            User currentUser = userManager.getUserByUsername(username);
                            MainStorePage mainStorePage = new MainStorePage(userManager, currentUser, bookInventory);
                            mainStorePage.display(scanner);
                            loggedIn = true; // Set loggedIn to true to exit the loop
                        }
                        break;
                    case 2:
                        if (adminLogin(scanner)) {
                            // Admin login successful, move to AdminPage
                            AdminPage adminPage = new AdminPage(userManager, bookInventory, orderManager);
                            adminPage.display();
                            loggedIn = true; // Set loggedIn to true to exit the loop
                        }
                        break;
                    case 3:
                        display(); // Go back to the main menu (OpeningScreen)
                        loggedIn = true; // Set loggedIn to true to exit the loop
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }



    public boolean customerLogin(String username, String password) {
        if (userManager.authenticateUser(username, password)) {
            System.out.println("Customer Login successful!");
            return true; // Login successful
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false; // Login unsuccessful
        }
    }


    public boolean adminLogin(Scanner scanner) {
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter admin username (or type 'back' to go back): ");
            String adminUsername = scanner.next();

            if (adminUsername.equalsIgnoreCase("back")) {
                return false; // Go back to the previous menu
            }

            System.out.print("Enter admin password: ");
            String adminPassword = scanner.next();

            if (userManager.authenticateAdmin(adminUsername, adminPassword)) {
                System.out.println("Admin Login successful!");
                AdminPage adminPage = new AdminPage(userManager, bookInventory, orderManager);
                adminPage.display(); // Redirect to admin page
                loggedIn = true;
                return true; // Admin login successful
            } else {
                System.out.println("Invalid admin credentials. Access denied.");
                System.out.println("Would you like to try again? (yes/no)");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("yes")) {
                    loggedIn = true; // Exit loop if not retrying
                }
            }
        }
        return false; // Admin login unsuccessful
    }

    

    // You can add other methods as needed

    private int generateUserId() {
        // Generate a unique user ID, you can implement this method based on your requirements
        return (int) (Math.random() * 1000) + 1;
    }

   
}
