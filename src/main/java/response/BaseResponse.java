package response;

import entity.Genre;
import entity.author.Author;
import entity.book.Book;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

public class BaseResponse {
    private final Response response;

    public BaseResponse(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return this.response.getStatusCode();
    }

    public String getHeader(String header) {
        return this.response.getHeader(header);
    }

    public String getBody() {
        return this.response.body().asString();
    }

    public Author getAsAuthorClass() {
        return this.response.body().as(Author.class);
    }

    public Genre getAsGenreClass(){
        return this.response.body().as(Genre.class);
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "response=" + response +
                '}';
    }

    public Book getAsBookClass(){
        return this.response.body().as(Book.class);
    }

    public List<Author> getAsAuthorClassArray() {
        return Arrays.asList(response.getBody().as(Author.class));
    }

    public List<Genre> getAsGenreClassArray() {
        return Arrays.asList(response.getBody().as(Genre.class));
    }

    public List<Book> getAsBookClassArray() {
        return Arrays.asList(response.getBody().as(Book.class));
    }
}
