package exercise2;

import java.util.List;
import java.util.ArrayList;

public class Principal() {
    List<String> Authors;
    private List<Book> books = new ArrayList<>();

    List<Book> ReadBooks( String input ) {
        this.Authors = new ArrayList<>();
        String Title = "";
        String Publisher = "";
        int PublicationYear = 0;
        String[] fieldSeparator = input.split("\n");

        for(int i = 1; i < fieldSeparator.length; i++) {
            String[] separator = fieldSeparator[i].split(":");
            String key = separator[0].trim();
            String value = separator[1].trim();

            switch( key ) {
                case "Author":
                Authors.add( value );
                break;

                case "Title":
                Title = value;
                break;

                case "Publisher":
                Publisher = value;
                break;

                case "Published":
                PublicationYear = Integer.parseInt(value);
                break;
            }
        }
        Book book = new Book(Authors, Title, Publisher, PublicationYear);
        books.add(book);
        return books;
    }

    List<Book> FindBooks(String query) {
        List<Book> results = new ArrayList<>();

        String[] queries = query.split("&");
        
        for(String q : queries) {
            q = q.trim();
            
            List<Book> temp = new ArrayList<>();

            if(q.startsWith("*") && q.endsWith("*")) {
                String keyword = q.substring(1, q.length() - 1).toLowerCase();

                for(Book book : books) {
                    if(book.getTitle().contains(keyword) ||
                        book.getPublisher().contains(keyword) ||
                        String.valueOf(book.getPublicationYear()).contains(keyword)) {
                        temp.add(book);
                    }
                
                    for(int i = 0; i < Authors.size(); i++) {
                        if(book.getAuthors().get(i).contains(keyword)) {
                            temp.add(book);
                        }                  
                    }
                }
            } else {
                for(Book book : books) {
                    if(book.getTitle().matches(q) ||
                        book.getPublisher().matches(q) ||
                        String.valueOf(book.getPublicationYear()).matches(q)) {
                        temp.add(book);
                    }
                    
                    for(int i = 0; i < Authors.size(); i++) {
                        if(book.getAuthors().get(i).matches(q)) {
                            temp.add(book);
                        }                  
                    }
                }
            }
            if(results.isEmpty()) {
                results.addAll(temp);
            } else {
                results.retainAll(temp);
            }
        }
        return results;
    }    
}