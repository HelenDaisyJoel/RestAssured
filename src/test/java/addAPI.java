import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.addAPIPayload;
import payload.updateAPIPayload;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import base.ReusableMethods;

public class addAPI {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		RestAssured.useRelaxedHTTPSValidation(); // Disable SSL verification
		String Response=given().log().all().queryParams("key", "qaclick123").header("Content-Type", "application/json")
		.body(addAPIPayload.addPlace())
		.when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("server","Apache/2.4.52 (Ubuntu)").log().all().extract().response().asString();
		
	System.out.println(Response);
	JsonPath js= new JsonPath(Response);
	String placeID=js.getString("place_id");
	System.out.println(placeID);
	
//	Update API
	String updatedAddress="70 Summer walk, USA111";
	String UpdateResponse= given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
			.body(updateAPIPayload.updatePlace(placeID, updatedAddress))
			.when().put("/maps/api/place/update/json").then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
			.log().all().extract().response().asString();
	System.out.println(UpdateResponse);
	
	
//	Get API
	String GetResponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
	.when().get("/maps/api/place/get/json").then().assertThat().statusCode(200)
	.log().all().extract().response().asString();
	System.out.println(GetResponse);
	JsonPath js1=ReusableMethods.rawToJson(GetResponse);
	String address=js1.getString("address");
	System.out.println("The address is "+address);
	Assert.assertEquals(updatedAddress, address);
	
			
	
		

	}

}
