import consts.FileNames;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import response.BaseResponse;
import service.EntityService;
import java.util.List;
import static service.GenreService.genre;
import static service.AuthorService.author;
import static service.BookService.book;

@Feature("Book tests")
public class BookTests extends BaseTest {

    @Test(groups = {"require_prep"})
    @Description("Verify book created correctly with valid data")
    public void verifyPostBook(){
        bookService.verifyBookBodies(createBookResponse.getAsBookClass());
       verifyResponse(createBookResponse, HttpStatus.SC_CREATED);
        attachResponse(createBookResponse);
    }

    @Test
    @Description("Verify book not created with invalid data")
    public void verifyPostBookWrong(){
        BaseResponse response = bookService.createBookWrong(FileNames.BOOK_WRONG.getName(),
                author.getAuthorId(),genre.getGenreId());
        verifyResponse(response,HttpStatus.SC_BAD_REQUEST);
        attachResponse(response);

    }

    @Test
    @Description("Verify getting all books")
    public void verifyGetAllBooks(){
        BaseResponse response=new EntityService().getAllEntities(FileNames.BOOK.getFindAll());
        verifyResponse(response,HttpStatus.SC_OK);
        attachResponse(response);
    }

    @Test(groups = {"require_prep"})
    @Description("Verify getting one book by id")
    public void verifyGetBookById(){
        BaseResponse getResponse=entityService.getEntityById(FileNames.BOOK.getFindOne(),
                book.getBookId());
        verifyResponse(getResponse,HttpStatus.SC_OK);
        attachResponse(getResponse);
        bookService.verifyBookBodies(getResponse.getAsBookClass());
    }


    @Test(groups = {"require_prep"})
    @Description("Check if book updated correctly")
    public void verifyUpdateBook(){
        BaseResponse updateResponse=entityService.updateEntity(createBookResponse,FileNames.BOOK.getFindOne());
        verifyResponse(updateResponse,HttpStatus.SC_OK);
        attachResponse(updateResponse);
    }

    @Test
    @Description("Check if book deleted correctly")
    public void VerifyDeleteBook(){
        authorService.createAuthor();
        genreService.createGenre();
        bookService.createBook(author.getAuthorId(),genre.getGenreId());
        BaseResponse deleteResponse= entityService.removeEntity(FileNames.BOOK.getFindOne(),
                book.getBookId());
        verifyResponse(deleteResponse, HttpStatus.SC_NO_CONTENT);
        attachResponse(deleteResponse);
        entityService.removeEntity(FileNames.AUTHOR.getFindOne(), author.getAuthorId());
        entityService.removeEntity(FileNames.GENRE.getFindOne(),genre.getGenreId());
    }

    @Test(groups = {"require_prep"})
    @Description("Check if authors book searched correctly")
    public void verifyBooksOfSpecialAuthor(){
        BaseResponse response=entityService.getEntityOfAnotherSpecialEntity(FileNames.BOOK.getFindAll(),
                FileNames.AUTHOR.getFindOne(),author.getAuthorId());
        verifyResponse(response, HttpStatus.SC_OK);
        attachResponse(response);
    }

}
