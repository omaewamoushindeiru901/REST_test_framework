import consts.FileNames;
import dataProvider.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import response.BaseResponse;

import static service.BookService.book;
import static service.GenreService.genre;

import service.EntityService;
import utils.JsonReader;


@Feature("Genre tests")
public class GenreTests extends BaseTest {


    @Test(groups = {"require_prep"})
    @Description("Verify genre created correctly with valid data")
    public void verifyPostGenre(){
        genreService.verifyGenreBodies(createGenreResponse.getAsGenreClass());
        verifyResponse(createGenreResponse,HttpStatus.SC_CREATED);
        attachResponse(createGenreResponse);
    }

    @Test
    @Description("Verify genre not created with invalid data")
    public void verifyPostGenreWrong(){
        BaseResponse response= entityService.createEntity(JsonReader.JsonSamplesReader(
                FileNames.GENRE_WRONG.getName()),FileNames.GENRE.getFindOne());
        attachResponse(response);
        verifyResponse(response,HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    @Description("Verify getting all genres")
    public void verifyGetAllGenres(){
        BaseResponse response= entityService.getAllEntities(FileNames.GENRE.getFindAll());
        verifyResponse(response,HttpStatus.SC_OK);
        attachResponse(response);
    }

    @Test(groups = {"require_prep"})
    @Description("Verify getting one genre by id")
    public void verifyGetGenreById(){
        BaseResponse getResponse= entityService.getEntityById(FileNames.GENRE.getFindOne(),genre.getGenreId());
        verifyResponse(getResponse,HttpStatus.SC_OK);
        attachResponse(getResponse);
    }


    @Test(groups = {"require_prep"})
    @Description("Check if genre updated correctly")
    public void verifyUpdateGenre(){
        BaseResponse updateResponse=entityService.updateEntity(createGenreResponse,FileNames.GENRE.getFindOne());
        verifyResponse(updateResponse,HttpStatus.SC_OK);
        attachResponse(updateResponse);
    }

    @Test
    @Description("Check if genre deleted correctly")
    public void VerifyDeleteGenre(){
        genreService.createGenre();
        BaseResponse deleteResponse=entityService.removeEntity(FileNames.GENRE.getFindOne(),
                genre.getGenreId());
        verifyResponse(deleteResponse,HttpStatus.SC_NO_CONTENT);
        attachResponse(deleteResponse);
    }

    @Test(dataProvider = "genreNames", dataProviderClass = DataProviders.class)
    @Description("Check if genre searched by name correctly")
    public void verifySearchGenreByName(String value){
        BaseResponse response=new EntityService().getEntityByNameSearch(FileNames.GENRE.getFindAll(),value);
        verifyResponse(response,HttpStatus.SC_OK);
        attachResponse(response);
    }

}
