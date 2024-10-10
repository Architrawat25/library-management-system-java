import java.util.Scanner;

public class Main {
    public static void displayMenu() {
        System.out.println("Library Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Search Book by Title");
        System.out.println("3. Search Book by ID");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. List All Books");
        System.out.println("7. Delete Book");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Library library = new Library();
        String filename = "libraryData.txt";

        library.loadFromFile(filename);

        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            int id;
            String title, author;

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Book Title: ");
                    title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    author = scanner.nextLine();
                    library.addBook(new Book(id, title, author, false));
                    break;
                case 2:
                    System.out.print("Enter Book Title: ");
                    title = scanner.nextLine();
                    library.searchBookByTitle(title);
                    break;
                case 3:
                    System.out.print("Enter Book ID: ");
                    id = scanner.nextInt();
                    library.searchBookById(id);
                    break;
                case 4:
                    System.out.print("Enter Book ID: ");
                    id = scanner.nextInt();
                    library.issueBook(id);
                    break;
                case 5:
                    System.out.print("Enter Book ID: ");
                    id = scanner.nextInt();
                    library.returnBook(id);
                    break;
                case 6:
                    library.listAllBooks();
                    break;
                case 7:
                    System.out.print("Enter Book ID: ");
                    id = scanner.nextInt();
                    library.deleteBook(id);
                    break;
                case 8:
                    library.saveToFile(filename);
                    System.out.println("Exiting and saving data...");
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (!exitProgram) {
                System.out.print("Do you want to perform another operation? (yes/no): ");
                String response = scanner.nextLine();
                if (!response.equalsIgnoreCase("yes")) {
                    library.saveToFile(filename);
                    System.out.println("Exiting and saving data...");
                    exitProgram = true;
                }
            }
        }

        scanner.close();
    }
}
