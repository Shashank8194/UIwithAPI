package utilities;

import controllers.InitMethod;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredCommons extends InitMethod {

   public static Response response;


   public RequestSpecification createRequest()
   {
       return RestAssured.given()
               .baseUri(Base_URI+End_Point)
               .queryParam("q",city)
               .queryParam("appid",apikey);
   }

}
