import consts.FileNames;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import org.testng.Assert;
import org.testng.annotations.*;
import response.BaseResponse;
import service.AuthorService;
import service.BookService;
import service.EntityService;
import service.GenreService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static service.AuthorService.author;
import static service.GenreService.genre;
import static service.BookService.book;


public class BaseTest {
    protected Logger LOG = Logger.getLogger(BaseTest.class.getName());
    protected GenreService genreService=new GenreService();
    protected AuthorService authorService= new AuthorService();
    protected BookService bookService=new BookService();
    protected EntityService entityService= new EntityService();

    protected BaseResponse createAuthorResponse;
    protected BaseResponse createBookResponse;
    protected BaseResponse createGenreResponse;


   @BeforeMethod(onlyForGroups = "require_prep")
    public void beforeTest(){
       RestAssured.filters(new RequestLoggingFilter(),new RequestLoggingFilter());
       createAuthorResponse=authorService.createAuthor();
       createGenreResponse=genreService.createGenre();
       createBookResponse=bookService.createBook(author.getAuthorId(), genre.getGenreId());
    }

    @AfterMethod(onlyForGroups = "require_prep")
    public void afterTest(){
        entityService.removeEntity(FileNames.BOOK.getFindOne(), book.getBookId());
        entityService.removeEntity(FileNames.AUTHOR.getFindOne(), author.getAuthorId());
        entityService.removeEntity(FileNames.GENRE.getFindOne(), genre.getGenreId());
    }



    @Step("Verify response")
    public void verifyResponse(BaseResponse response,int codeToVerify){
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode, codeToVerify,String.format("\nStatus code is: '%s'\nResponse: '%s'",statusCode,
                response.getBody()));
        LOG.info(String.format("Status code is: %s",statusCode));
        LOG.info(String.format("Response: %s",response.getBody()));
    }

    @Attachment
    public String attachResponse(BaseResponse response){
       return "Status code: "+response.getStatusCode()+"\nBody:\n"+response.getBody();
    }


}
