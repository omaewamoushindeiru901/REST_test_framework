package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import configs.PropertyConfig;
import consts.FileNames;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class JsonReader {
        private static JsonElement json;

        @Step("Reading from {0} file")
        @Attachment()
        public static JsonElement JsonSamplesReader(String fileName) {
            String path = PropertyConfig.getProps("jsonPath") + fileName;
            try  {
                FileReader input = new FileReader(path);
                json = new JsonParser().parse(input);
                return json;
            } catch(Exception e) {
                e.printStackTrace();
            }finally {
                return json;
            }
        }

        public static String writeToVerifyFile(Object obj){
            ObjectMapper mapper=new ObjectMapper();
            try {
                mapper.writeValue(new File(PropertyConfig.getProps("jsonPath") + FileNames.VERIFY.getName()), obj);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String jsonInString=null;
            try {
                jsonInString= mapper.writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return jsonInString;
        }

        public JsonElement get() {
            return this.json;
        }
}
