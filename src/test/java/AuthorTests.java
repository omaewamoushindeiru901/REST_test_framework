import consts.FileNames;
import dataProvider.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import response.BaseResponse;
import service.EntityService;
import utils.JsonReader;

import static service.AuthorService.author;
import static service.BookService.book;

@Feature("Author tests")
public class AuthorTests extends BaseTest {

    @Test(groups = {"require_prep"})
    @Description("Verify author created correctly with valid data")
    public void verifyPostAuthor(){
        authorService.verifyAuthorBodies(createAuthorResponse.getAsAuthorClass());
        verifyResponse(createAuthorResponse,HttpStatus.SC_CREATED);
        attachResponse(createAuthorResponse);
    }

    @Test
    @Description("Verify author not created with invalid data")
    public void verifyPostAuthorWrong(){
        BaseResponse response= entityService.createEntity(JsonReader.JsonSamplesReader(
                FileNames.AUTHOR_WRONG.getName()),FileNames.AUTHOR.getFindOne());
        verifyResponse(response,HttpStatus.SC_BAD_REQUEST);
        attachResponse(response);
    }

    @Test
    @Description("Verify getting all authors")
    public void verifyGetAllAuthors(){
        BaseResponse response= entityService.getAllEntities(FileNames.AUTHOR.getFindAll());
        verifyResponse(response,HttpStatus.SC_OK);
        attachResponse(response);
    }

    @Test(groups = {"require_prep"})
    @Description("Verify getting one author by id")
    public void verifyGetAuthorById(){
        BaseResponse getResponse= entityService.getEntityById(FileNames.AUTHOR.getFindOne(),author.getAuthorId());
        authorService.verifyAuthorBodies(getResponse.getAsAuthorClass());
        verifyResponse(getResponse,HttpStatus.SC_OK);
        attachResponse(getResponse);

    }

    @Test(groups = {"require_prep"})
    @Description("Check if author updated correctly")
    public void verifyUpdateAuthor(){
        BaseResponse updateResponse=entityService.updateEntity(createAuthorResponse,FileNames.AUTHOR.getFindOne());
        verifyResponse(updateResponse,HttpStatus.SC_OK);
        attachResponse(updateResponse);
    }


    @Test//(enabled = false)
    @Description("Check if author deleted correctly")
    public void verifyDeleteAuthor(){
        authorService.createAuthor();
        BaseResponse deleteResponse=entityService.removeEntity(FileNames.AUTHOR.getFindOne(),
                author.getAuthorId());
        verifyResponse(deleteResponse,HttpStatus.SC_NO_CONTENT);
        attachResponse(deleteResponse);
    }

    @Test(dataProvider = "authorNames", dataProviderClass = DataProviders.class)
    @Description("Check if author searched by name correctly")
    public void verifySearchAuthorsByName(String value){
         BaseResponse response=new EntityService().getEntityByNameSearch(FileNames.AUTHOR.getFindAll(),value);
        verifyResponse(response,HttpStatus.SC_OK);
        attachResponse(response);
    }

    @Test(groups = {"require_prep"})
    @Description("Check if book author searched correctly")
    public void verifySearchBookAuthor(){
        BaseResponse response=new EntityService().getEntityOfAnotherSpecialEntity(FileNames.AUTHOR.getFindOne(),
                FileNames.BOOK.getFindOne(),book.getBookId());
        verifyResponse(response,HttpStatus.SC_OK);
        attachResponse(response);
    }
}
