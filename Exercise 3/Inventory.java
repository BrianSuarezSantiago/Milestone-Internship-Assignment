package exercise3;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Inventory {
    private List<Book> books;
    private Map<Integer, List<Book>> booksByRoom;
    private Map<Integer, Map<Integer, List<Book>>> booksByRoomAndRow;
    private Map<Integer, Map<Integer, Map<Integer, Book>>> booksByRoomAndRowAndShelf;

    public Inventory() {
        books = new ArrayList<>();
        booksByRoom = new HashMap<>();
        booksByRoomAndRow = new HashMap<>();
        booksByRoomAndRowAndShelf = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);

        // Add book to booksByRoom
        if (!booksByRoom.containsKey(book.getRoomNumber())) {
            booksByRoom.put(book.getRoomNumber(), new ArrayList<>());
        }
        booksByRoom.get(book.getRoomNumber()).add(book);

        // Add book to booksByRoomAndRow
        if (!booksByRoomAndRow.containsKey(book.getRoomNumber())) {
            booksByRoomAndRow.put(book.getRoomNumber(), new HashMap<>());
        }
        Map<Integer, List<Book>> booksByRow = booksByRoomAndRow.get(book.getRoomNumber());
        if (!booksByRow.containsKey(book.getRowNumber())) {
            booksByRow.put(book.getRowNumber(), new ArrayList<>());
        }
        booksByRow.get(book.getRowNumber()).add(book);

        // Add book to booksByRoomAndRowAndShelf
        if (!booksByRoomAndRowAndShelf.containsKey(book.getRoomNumber())) {
            booksByRoomAndRowAndShelf.put(book.getRoomNumber(), new HashMap<>());
        }
        Map<Integer, Map<Integer, Book>> booksByRowAndShelf = booksByRoomAndRowAndShelf.get(book.getRoomNumber());
        if (!booksByRowAndShelf.containsKey(book.getRowNumber())) {
            booksByRowAndShelf.put(book.getRowNumber(), new HashMap<>());
        }
        booksByRowAndShelf.get(book.getRowNumber()).put(book.getShelfNumber(), book);
    }

    public List<Book> getBooksByRoom(int roomNumber) {
        return booksByRoom.get(roomNumber);
    }

    public List<Book> getBooksByRoomAndRow(int roomNumber, int rowNumber) {
        if (!booksByRoomAndRow.containsKey(roomNumber)) {
            return null;
        }
        return booksByRoomAndRow.get(roomNumber).get(rowNumber);
    }

    public Book getBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Add books to inventory
        inventory.addBook(new Book("9780061124952", "To Kill a Mockingbird", "Harper Lee", 1, 1, 1));
        inventory.addBook(new Book("9780486478061", "Adventures of Huckleberry Finn", "Mark Twain", 1, 1, 2));
        inventory.addBook(new Book("9780140449266", "The Odyssey", "Homer", 1, 2, 1));
        inventory.addBook(new Book("9780486280615", "Pride and Prejudice", "Jane Austen", 1, 2, 2));
        inventory.addBook(new Book("9781593275990", "Eloquent JavaScript", "Marijn Haverbeke", 2, 1, 1));
        inventory.addBook(new Book("9780596007126", "Head First Java", "Kathy Sierra and Bert Bates", 2, 1, 2));
        inventory.addBook(new Book("9781118717059", "Beginning Programming with Java For Dummies", "Barry Burd", 2, 2, 1));
        inventory.addBook(new Book("9780596009205", "Head First Design Patterns", "Eric Freeman and Elisabeth Robson", 2, 2, 2));

        // Get list of books in room 1
        List<Book> booksInRoom1 = inventory.getBooksByRoom(1);
        System.out.println("Books in room 1:");
        for (Book book : booksInRoom1) {
            System.out.println(book.getTitle());
        }
        System.out.println();

        // Get list of books in room 1, row 1
        List<Book> booksInRoom1Row1 = inventory.getBooksByRoomAndRow(1, 1);
        System.out.println("Books in room 1, row 1:");
        for (Book book : booksInRoom1Row1) {
            System.out.println(book.getTitle());
        }
        System.out.println();

        // Get book with ISBN "9780486478061"
        Book bookByISBN = inventory.getBookByISBN("9780486478061");
        System.out.println("Book with ISBN \"9780486478061\":");
        System.out.println(bookByISBN.getTitle());
    }
}