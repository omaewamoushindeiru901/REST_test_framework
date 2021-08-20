package service;

import client.HTTPClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import consts.FileNames;
import entity.book.Book;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import response.BaseResponse;
import utils.EndpointBuilder;
import utils.JsonReader;

public class BookService {
    public static Book book;


    @Step("Compare expected book and created book")
    public void verifyBookBodies(Book createdBook){
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(book.getBookId(),createdBook.getBookId(),"Id is not equal");
        softAssert.assertEquals(book.getBookName(),createdBook.getBookName(),"Name is not equal");
        softAssert.assertEquals(book.getBookLanguage(),createdBook.getBookLanguage(),
                "Language is not equal");
        softAssert.assertEquals(book.getBookDescription(),createdBook.getBookDescription(),
                "Description is not equal");
        softAssert.assertEquals(book.getAdditional().getPageCount(),createdBook.getAdditional().getPageCount(),
                "Page count is not equal");
        softAssert.assertEquals(book.getAdditional().getSize().getHeight(),createdBook.getAdditional().getSize().getHeight(),
                "Height is not equal");
        softAssert.assertEquals(book.getAdditional().getSize().getWidth(),createdBook.getAdditional().getSize().getWidth(),
                "Width is not equal");
        softAssert.assertEquals(book.getAdditional().getSize().getLength(),createdBook.getAdditional().getSize().getLength(),
                "Length is not equal");
        softAssert.assertEquals(book.getPublicationYear(),createdBook.getPublicationYear(),"Language is not equal");
        softAssert.assertAll();
    }

    @Step
    public BaseResponse createBook(int authorId, int genreId) {
        String endpoint = new EndpointBuilder().pathParameter(FileNames.BOOK.getFindOne()).addEntityId(authorId)
                .addEntityId(genreId).get();
        try {
            book = new ObjectMapper().readValue(JsonReader.JsonSamplesReader(FileNames.BOOK.getName()).toString(),
                    Book.class);

        } catch (JsonProcessingException e ) {
            e.printStackTrace();
        }

        return HTTPClient.post(endpoint, book);
    }

    @Step
    public BaseResponse createBookWrong(String entity,int authorId, int genreId) {
        String endpoint = new EndpointBuilder().pathParameter(FileNames.BOOK_WRONG.getFindOne()).addEntityId(authorId)
                .addEntityId(genreId).get();

        return HTTPClient.post(endpoint, entity);
    }

 /*   @Step
    public BaseResponse updateBook(BaseResponse response,String paramToChange, Object valueToChange){
        String endpoint = new EndpointBuilder().pathParameter(FileNames.BOOK.getFindOne()).get();
        book =  response.getAsBookClass();
        return new EntityService().updateEntity(book, endpoint, paramToChange, valueToChange);
    }*/
}
