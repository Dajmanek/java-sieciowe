package kolokwium1.gr1;

import java.io.Serializable;

public class Book extends Publisher implements Serializable {

    private String author;
    private String title;
    private int page;

    public Book(String name, String city, String author, String title, int page) {
        super(name, city);
        this.author = author;
        this.title = title;
        this.page = page;
    }


    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", page=" + page +
                "} " + super.toString();
    }
}
