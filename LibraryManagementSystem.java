import java.util.ArrayList;
import java.util.Scanner;

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " (Issued)" : " (Available)");
    }
}

// User Class
class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}

// Library Class
class Library {
    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("✅ User added: " + user.toString());
    }

    public void displayBooks() {
        System.out.println("\n📚 Books in Library:");
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void displayUsers() {
        System.out.println("\n👥 Registered Users:");
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isIssued()) {
                    book.issue();
                    System.out.println("✅ Book issued: " + book.getTitle());
                    return;
                } else {
                    System.out.println("❌ Book is already issued.");
                    return;
                }
            }
        }
        System.out.println("❌ Book not found.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.isIssued()) {
                    book.returnBook();
                    System.out.println("✅ Book returned: " + book.getTitle());
                    return;
                } else {
                    System.out.println("❌ Book was not issued.");
                    return;
                }
            }
        }
        System.out.println("❌ Book not found.");
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All Users");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    break;

                case 2:
                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter User ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();  // consume newline
                    library.addUser(new User(name, id));
                    break;

                case 3:
                    System.out.print("Enter Book Title to Issue: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueTitle);
                    break;

                case 4:
                    System.out.print("Enter Book Title to Return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle);
                    break;

                case 5:
                    library.displayBooks();
                    break;

                case 6:
                    library.displayUsers();
                    break;

                case 0:
                    System.out.println("👋 Exiting Library Management System.");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
            }

        } while (choice != 0);

        sc.close();
    }
}
