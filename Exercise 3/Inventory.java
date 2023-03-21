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
}