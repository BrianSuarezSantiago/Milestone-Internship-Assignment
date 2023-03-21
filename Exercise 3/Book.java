package exercise3;

public class Book {
    private String ISBN, title, author;
    private int roomNumber, rowNumber, shelfNumber;

    public Book(String ISBN, String title, String author, int roomNumber, int rowNumber, int shelfNumber) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.roomNumber = roomNumber;
        this.rowNumber = rowNumber;
        this.shelfNumber = shelfNumber;
    }

    // Getters and setters
    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getShelfNumber() {
        return this.shelfNumber;
    }

    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }
}