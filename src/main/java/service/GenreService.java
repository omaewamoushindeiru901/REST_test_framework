package service;

import client.HTTPClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import consts.FileNames;
import entity.Genre;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import response.BaseResponse;
import utils.EndpointBuilder;
import utils.JsonReader;


public class GenreService {
    public static Genre genre;

    @Step("Compare expected genre and created genre")
    public void verifyGenreBodies(Genre createdGenre){
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(genre.getGenreId(),createdGenre.getGenreId(),"Id is not equal");
        softAssert.assertEquals(genre.getGenreName(),createdGenre.getGenreName(),"Name is not equal");
        softAssert.assertEquals(genre.getGenreDescription(),createdGenre.getGenreDescription(),
                "Description is not equal");
        softAssert.assertAll();
    }

    @Step
    public BaseResponse createGenre() {
        String endpoint = new EndpointBuilder().pathParameter(FileNames.GENRE.getFindOne()).get();
        try {
            genre = new ObjectMapper().readValue(JsonReader.JsonSamplesReader(FileNames.GENRE.getName()).toString(),
                    Genre.class);

        } catch (JsonProcessingException e ) {
            e.printStackTrace();
        }

        return HTTPClient.post(endpoint, genre);
    }

}
