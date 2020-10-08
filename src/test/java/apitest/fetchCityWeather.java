package apitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.RestAssuredCommons;

public class fetchCityWeather extends RestAssuredCommons {


    Response response;

    public  Response getRequest()
    {
        RequestSpecification request= RestAssured.given();

        request.baseUri(Base_URI+End_Point).
        queryParam("q",city)
                .queryParam("appid",apikey);

        response=createRequest().get();
return  response;
    }

    public Response getrequestResponse()
    {
        String resString= response.asString();
        System.out.println(resString);
        return  response;
    }


}
