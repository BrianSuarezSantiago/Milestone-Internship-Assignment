package exercise2;

import java.util.List;

public class Book {
    List <String> Authors;
    String Title;
    String Publisher;
    int PublicationYear;

    public Book(List<String> authors, String title, String publisher, int publicationYear) {
        this.Authors = aut;
        this.Title = tit;
        this.Publisher = pub;
        this.PublicationYear = año;
    }

    public List<String> getAuthors() {
        return this.Authors;
    }

    public String getTitle() {
        return this.Title;
    }

    public String getPublisher() {
        return this.Publisher;
    }

    public int getPublicationYear() {
        return this.PublicationYear;
    }   
}