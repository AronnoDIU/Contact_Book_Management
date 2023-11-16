class Contact {
    private static int nextId = 1; // Start with ID 1 for the first contact
    private final int id; // ID of the contact in the book (1, 2, 3, etc.)
    private final String name; // Name of the contact in the book (John Doe, Jane Doe, etc.)
    private final String phoneNumber; // Phone number of the contact in the book (123-456-7890, etc.)
    private final String email; // Email address of the contact in the book (jdoe@my.com, etc.)

    public Contact(String name, String phoneNumber, String email) {
        this.id = nextId++; // Increment the ID for the next contact in the list
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id; // Return the ID of the contact in the book (1, 2, 3, etc.)
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email;
    }
}