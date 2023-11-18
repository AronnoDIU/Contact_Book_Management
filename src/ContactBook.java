import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ContactBook {
    private final ArrayList<Contact> contacts; // List of contacts in the book
    private final Scanner userInput; // User input scanner

    public ContactBook() {
        contacts = new ArrayList<>(); // Initialize the list
        userInput = new Scanner(System.in); // Initialize the scanner
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook(); // Create a new ContactBook
        contactBook.run(); // Start the program
    }

    public void run() {
        int choice;
        do {
            displayMenu(); // Display the menu
            System.out.print("Enter your choice: ");
            choice = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character

            // Perform the selected action based on the user's choice
            switch (choice) {
                case 1: // For Add contact
                    addContact();
                    break;
                case 2: // For View contacts
                    viewContacts();
                    break;
                case 3: // For Search contact
                    searchContact();
                    break;
                case 4: // For Update contact
                    updateContact();
                    break;
                case 5: // For Delete contact
                    deleteContact();
                    break;
                case 6: // For Sort contacts
                    sortContacts();
                    break;
                case 7: // For Export contacts
                    // Export contacts (not implemented in this example because it will be extended later)
                    System.out.println("Export functionality not implemented.");
                    break;
                case 8: // For Import contacts
                    // Import contacts (not implemented in this example because it will be extended later)
                    System.out.println("Import functionality not implemented.");
                    break;
                case 9: // For Exit
                    System.out.println("Exiting the Contact Book. Goodbye!");
                    break;
                default: // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }

    private void displayMenu() {
        System.out.println("\n===== Contact Book Menu =====");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Search Contact");
        System.out.println("4. Update Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Sort Contacts");
        System.out.println("7. Export Contacts");
        System.out.println("8. Import Contacts");
        System.out.println("9. Exit");
    }

    // Add a new contact to the list
    private void addContact() {
        System.out.print("Enter name: ");
        String name = userInput.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = userInput.nextLine();

        System.out.print("Enter email: ");
        String email = userInput.nextLine();

        // Add the new contact to the list
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact); // Add the contact to the list
        System.out.println("Contact added successfully!");
    }

    // View all contacts in the list
    private void viewContacts() {

        // If the list is empty, print a message to the user
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else { // If the list is not empty, print all the contacts
            System.out.println("===== Contacts =====");

            // Iterate through the list and print each contact in the list
            for (Contact contact : contacts) {
                System.out.println(contact);
                System.out.println("------------");
            }
        }
    }

    // Search for a contact by name
    private void searchContact() {
        System.out.print("Enter name to search: ");
        String searchName = userInput.nextLine();

        boolean found = false; // Flag to indicate if a contact was found

        // Iterate through the list and search for the contact
        for (Contact contact : contacts) {

            // Convert the search name to lowercase for case-insensitive comparison
            if (contact.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println("Contact found:\n" + contact);
                found = true; // Set the flag to true if a contact is found
                break;
            }
        }

        // If no contact is found, print a message to the user
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Update a contact in the list
    private void updateContact() {
        System.out.print("Enter ID of the contact to update: ");
        int updateId = userInput.nextInt();
        userInput.nextLine(); // Consume the newline character

        boolean found = false; // Flag to indicate if a contact was found

        // Iterate through the list and update the contact
        for (Contact contact : contacts) {

            // Check if the contact ID matches the update ID
            if (contact.getId() == updateId) {
                System.out.println("Enter new details:");

                System.out.print("Enter name: ");
                String name = userInput.nextLine();

                System.out.print("Enter phone number: ");
                String phoneNumber = userInput.nextLine();

                System.out.print("Enter email: ");
                String email = userInput.nextLine();

                // Update the contact in the list with the new details
                contact = new Contact(name, phoneNumber, email);
                System.out.println("Contact updated successfully!" + contact);
                found = true; // Set the flag to true if a contact is found
                break;
            }
        }

        // If no contact is found, print a message to the user
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    // Delete a contact from the list
    private void deleteContact() {
        System.out.print("Enter ID of the contact to delete: ");
        int deleteId = userInput.nextInt();
        userInput.nextLine(); // Consume the newline character

        Contact contactToRemove = null; // Variable to store the contact to be removed

        // Iterate through the list and delete the contact
        for (Contact contact : contacts) {

            // Check if the contact ID matches the deleted ID
            if (contact.getId() == deleteId) {
                contactToRemove = contact; // Set the contact to be removed
                break;
            }
        }

        // If a contact is found, remove it from the list
        if (contactToRemove != null) {
            contacts.remove(contactToRemove); // Remove the contact from the list
            System.out.println("Contact deleted successfully!");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Sort the contacts in the list by name or ID
    private void sortContacts() {
        System.out.println("Sort contacts by:");
        System.out.println("1. Name");
        System.out.println("2. ID");
        int sortChoice = userInput.nextInt();
        userInput.nextLine(); // Consume the newline character

        // Sort the contacts in the list based on the user's choice
        switch (sortChoice) {
            case 1: // For Sort by name
                contacts.sort(Comparator.comparing(Contact::getName));
                System.out.println("Contacts sorted by name.");
                break;
            case 2: // For Sort by ID
                contacts.sort(Comparator.comparingInt(Contact::getId));
                System.out.println("Contacts sorted by ID.");
                break;
            default: // Invalid choice
                System.out.println("Invalid choice. Contacts remain unsorted.");
        }
    }
}