// Code by Krishtika Anjali
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int bookId;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.bookId == bookId);
        System.out.println("Book removed successfully.");
    }

    public void searchBook(int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                book.display();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                book.display();
            }
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;
                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    int removeId = scanner.nextInt();
                    library.removeBook(removeId);
                    break;
                case 3:
                    System.out.print("Enter Book ID to search: ");
                    int searchId = scanner.nextInt();
                    library.searchBook(searchId);
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
