import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    private int findBookIndexById(int id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int id = Integer.parseInt(line);
                boolean isIssued = Boolean.parseBoolean(reader.readLine());
                String title = reader.readLine();
                String author = reader.readLine();
                books.add(new Book(id, title, author, isIssued));
            }
        } catch (IOException e) {
            System.err.println("Could not open file for reading: " + filename);
        }
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.println(book.id);
                writer.println(book.isIssued);
                writer.println(book.title);
                writer.println(book.author);
            }
        } catch (IOException e) {
            System.err.println("Could not open file for writing: " + filename);
        }
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                System.out.println("Book found: ID: " + book.id + ", Author: " + book.author + ", Status: " + (book.isIssued ? "Issued" : "Available"));
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchBookById(int id) {
        int index = findBookIndexById(id);
        if (index != -1) {
            Book book = books.get(index);
            System.out.println("Book found: Title: " + book.title + ", Author: " + book.author + ", Status: " + (book.isIssued ? "Issued" : "Available"));
        } else {
            System.out.println("Book not found.");
        }
    }

    public void issueBook(int id) {
        int index = findBookIndexById(id);
        if (index != -1) {
            if (!books.get(index).isIssued) {
                books.get(index).isIssued = true;
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book is already issued.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void returnBook(int id) {
        int index = findBookIndexById(id);
        if (index != -1) {
            if (books.get(index).isIssued) {
                books.get(index).isIssued = false;
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Book was not issued.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    public void listAllBooks() {
        books.sort(Comparator.comparingInt(book -> book.id));

        System.out.println("\nListing All Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author + ", Status: " + (book.isIssued ? "Issued" : "Available"));
        }
        System.out.println();
    }

    public void deleteBook(int id) {
        int index = findBookIndexById(id);
        if (index != -1) {
            books.remove(index);
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }
}
