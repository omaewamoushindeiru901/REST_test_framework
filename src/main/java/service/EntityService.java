package service;

import client.HTTPClient;
import consts.FileNames;
import io.qameta.allure.Step;
import org.testng.Assert;
import response.BaseResponse;
import utils.EndpointBuilder;
import utils.JsonReader;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class EntityService {
    protected Logger LOG=Logger.getLogger(EntityService.class.getName());

    @Step
    public BaseResponse createEntity(Object entity,String path) {
        String endpoint = new EndpointBuilder().pathParameter(path).get();
        LOG.info(String.format("Endpoint is: %s",endpoint));
        return HTTPClient.post(endpoint, entity.toString());
    }

    @Step
    public BaseResponse getAllEntities(String entity) {
        String endpoint = new EndpointBuilder().addEntityType(entity).get();
        LOG.info(String.format("Endpoint is: %s",endpoint));
        return HTTPClient.get(endpoint);
    }

    @Step
    public BaseResponse getEntityById(String entity, int entityId) {
        String endpoint = new EndpointBuilder().addEntityType(entity).addEntityId(entityId).get();
        LOG.info(String.format("Endpoint is: %s",endpoint));
        return HTTPClient.get(endpoint);
    }


    @Step
    public BaseResponse removeEntity(String entity, int entityId) {
        String endpoint = new EndpointBuilder().addEntityType(entity).addEntityId(entityId).get();
        LOG.info(String.format("Endpoint is: %s",endpoint));
        return HTTPClient.delete(endpoint);
    }

     @Step
     public BaseResponse updateEntity(BaseResponse response, String path) {
         String endpoint = new EndpointBuilder().pathParameter(path).get();
         String entity=response.getBody();
         return HTTPClient.put(endpoint,entity);
     }

    @Step
    public BaseResponse getEntityByNameSearch(String entity, String search) {
        Assert.assertTrue(search.length()>=3);
        String endpoint = new EndpointBuilder().addEntityType(entity).addEntityType("search")
                .queryParam("query",search).get();
        return HTTPClient.get(endpoint);
    }

    @Step
    public BaseResponse getEntityOfAnotherSpecialEntity(String entity,String specEntity,int specEntityId){
        String endpoint=new EndpointBuilder().addEntityType(specEntity).addEntityId(specEntityId)
                .addEntityType(entity).get();
        System.out.println(endpoint);
        return HTTPClient.get(endpoint);
    }

}
