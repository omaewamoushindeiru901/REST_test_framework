package entity.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {
    @JsonProperty("bookId")
    private int bookId;
    @JsonProperty("bookName")
    private String bookName;
    @JsonProperty("bookLanguage")
    private String bookLanguage;
    @JsonProperty("bookDescription")
    private String bookDescription;
    @JsonProperty("additional")
    private Additional additional;
    @JsonProperty("publicationYear")
    private int publicationYear;

    public Book(){}

    public Book(int bookId, String bookName, String bookLanguage, String bookDescription, Additional additional, int publicationYear) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookLanguage = bookLanguage;
        this.bookDescription = bookDescription;
        this.additional = additional;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookLanguage='" + bookLanguage + '\'' +
                ", bookDescription='" + bookDescription + '\'' +
                ", additional=" + additional +
                ", publicationYear=" + publicationYear +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(String bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public Additional getAdditional() {
        return additional;
    }

    public void setAdditional(Additional additional) {
        this.additional = additional;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}
