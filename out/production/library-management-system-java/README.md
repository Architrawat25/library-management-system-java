# library-management-system-java
This project is a simple Library Management System made using Java. Features: Add, search, issue, return, list, and delete books. File handling for persistent data storage. User-friendly command-line interface for interaction.Technologies Used: Java, file handling, object-oriented programming.

Library Management System

Project Overview

This project implements a simple Library Management System. It allows librarians to manage books by performing operations such as adding new books, searching for books by title or ID, issuing and returning books, listing all books, and deleting books from the system. Data is stored persistently in a file (library_data.txt), ensuring that information is retained between sessions.

Features

Add new books with ID, title, and author.
Search for books by title or ID.
Issue books to mark them as issued.
Return books to mark them as available.
List all books in the library.
Delete books from the system.
Requirements

Functional Requirements

JDK installed on your system.
Ability to compile and run Java programs from the command line.
Non-Functional Requirements

Basic understanding of Java programming.
Terminal or command prompt for executing the program.
Instructions to Run

Clone the repository:
Navigate to the project directory:
Compile the program:
Run the executable:
Follow the on-screen instructions to interact with the Library Management System.
Source Code

The source code contains three classes contains the implementation of the entire Library Management System. It includes classes for Book, Library and Main having functions for managing books, and file handling for data persistence.

Functions and Their Explanation

addBook(Book book): Adds a new book to the library.
searchBookByTitle(string title): Searches for a book by its title.
searchBookById(int id): Searches for a book by its ID.
issueBook(int id): Issues a book to mark it as issued.
returnBook(int id): Returns a book to mark it as available.
listAllBooks(): Lists all books currently in the library.
deleteBook(int id): Deletes a book from the library.
loadFromFile(const string& filename): Loads book data from a file for persistent storage.
saveToFile(const string& filename): Saves book data to a file for persistent storage.
Contributing

Contributions are welcome! If you have suggestions or improvements, please fork the repository, create a new branch, and submit a pull request.
