package service;

import client.HTTPClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import consts.FileNames;
import entity.author.Author;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import response.BaseResponse;
import utils.EndpointBuilder;
import utils.JsonReader;

public class AuthorService {
    public static Author author;

    @Step("Compare expected author and created author")
    public void verifyAuthorBodies(Author createdAuthor){
        SoftAssert softAssert= new SoftAssert();
        softAssert.assertEquals(author.getAuthorId(),createdAuthor.getAuthorId(),"Id is not equal");
        softAssert.assertEquals(author.getAuthorName().getFirst(),createdAuthor.getAuthorName().getFirst(),
                "Name is not equal");
        softAssert.assertEquals(author.getAuthorName().getSecond(), createdAuthor.getAuthorName().getSecond(),
                "Second Name is not equal");
        softAssert.assertEquals(author.getNationality(), createdAuthor.getNationality(),
                "Nationality is not equal");
        softAssert.assertEquals(author.getBirth().getDate(), createdAuthor.getBirth().getDate(),
                "Date is not equal");
        softAssert.assertEquals(author.getBirth().getCountry(), createdAuthor.getBirth().getCountry(),
                "Country is not equal");
        softAssert.assertEquals(author.getBirth().getCity(), createdAuthor.getBirth().getCity(),
                "City is not equal");
        softAssert.assertEquals(author.getAuthorDescription(), createdAuthor.getAuthorDescription(),
                "Description is not equal");
        softAssert.assertAll();
    }


    @Step("Create author")
    public BaseResponse createAuthor() {
        String endpoint = new EndpointBuilder().pathParameter(FileNames.AUTHOR.getFindOne()).get();
        try {
            author = new ObjectMapper().readValue(JsonReader.JsonSamplesReader(FileNames.AUTHOR.getName()).toString(),
                    Author.class);

        } catch (JsonProcessingException e ) {
            e.printStackTrace();
        }
        return HTTPClient.post(endpoint, author);
    }


}
