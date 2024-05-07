package test.javafx;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private static UserManager instance = null;
    private Map<Integer, User> usersById; // Map userId to User object
    private Map<String, User> usersByUsername; // Map username to User object
    private static final String FILE_PATH = "userdata.txt";
    private int lastUserId; // To track the last assigned user ID
    private List<String> admins; // List of admin usernames

    public UserManager() {
        // Initialize the maps and admin list
        usersById = new HashMap<>();
        usersByUsername = new HashMap<>();
        admins = new ArrayList<>();
        loadUserDataFromFile();
        admins.add("sblick19"); // Add default admin username
    }

    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }

    
    public int generateUserId() {
        return ++lastUserId; // Increment lastUserId and return the new ID
    }

    public boolean createUser(int userId, String username, String password, String email) {
        if (!usersByUsername.containsKey(username)) {
            User newUser = new User(userId, username, password, email);
            usersById.put(userId, newUser);
            usersByUsername.put(username, newUser);
            saveUserDataToFile(); // Save user data to file after creating a new user
            System.out.println("User created: " + username);
            return true;
        } else {
            System.out.println("Username already exists.");
            return false;
        }
    }

    public boolean authenticateUser(String username, String password) {
        if (usersByUsername.containsKey(username)) {
            User user = usersByUsername.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }

    public boolean authenticateAdmin(String username, String password) {
        return admins.contains(username) && password.equals("1234");
    }

    public void updateUserProfile(String username, String newEmail) {
        if (usersByUsername.containsKey(username)) {
            User user = usersByUsername.get(username);
            user.setEmail(newEmail);
            usersByUsername.put(username, user); // Update user in the map
            saveUserDataToFile(); // Save updated user data to file
            System.out.println("User profile updated for: " + username);
        } else {
            System.out.println("User not found.");
        }
    }

    public User getUserByUsername(String username) {
        if (usersByUsername.containsKey(username)) {
            return usersByUsername.get(username);
        } else {
            System.out.println("User not found with the given username: " + username);
            return null; // User not found with the given username
        }
    }
    
    public boolean changeUserPassword(String username, String oldPassword, String newPassword) {
        if (usersByUsername.containsKey(username)) {
            User user = usersByUsername.get(username);
            if (user.getPassword().equals(oldPassword)) {
                user.setPassword(newPassword);
                usersByUsername.put(username, user); // Update user in the map
                saveUserDataToFile(); // Save updated user data to file
                System.out.println("Password changed for user: " + username);
                return true;
            } else {
                System.out.println("Incorrect old password.");
                return false;
            }
        } else {
            System.out.println("User not found.");
            return false;
        }
    }

    public Map<Integer, User> getAllUsers() {
        return new HashMap<>(usersById); // Return a copy of the user map to prevent direct modification
    }


    private void loadUserDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                int userId = Integer.parseInt(userData[0]);
                String username = userData[1];
                String password = userData[2];
                String email = userData[3];
                User user = new User(userId, username, password, email);
                usersById.put(userId, user);
                usersByUsername.put(username, user);
                lastUserId = Math.max(lastUserId, userId); // Update lastUserId if needed
            }
        } catch (IOException e) {
            System.err.println("Error loading user data from file: " + e.getMessage());
        }
    }

    private void saveUserDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User user : usersById.values()) {
                writer.write(user.getUserId() + "," + user.getUsername() + "," + user.getPassword() + "," + user.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving user data to file: " + e.getMessage());
        }
    }
}
