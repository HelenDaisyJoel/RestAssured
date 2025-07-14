package students;

import org.testng.annotations.Test;
import org.json.JSONObject;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class createStudent {
	String StudentID;
	
//	@Test(priority=1)
//	void CreateStudent() {
//		StudentID = given().body("\r\n"
//				+ "  {\r\n"
//				+ "    \"name\": \"Joel\",\r\n"
//				+ "    \"id\": \"106\",\r\n"
//				+ "    \"location\": \"Pune\",\r\n"
//				+ "    \"phone_number\": 1234567890,\r\n"
//				+ "    \"Courses\": [\r\n"
//				+ "      \"Java\",\r\n"
//				+ "      \"Selenium\"\r\n"
//				+ "    ]\r\n"
//				+ "  }").when().post("http://localhost:3000/Student")
//		.then().statusCode(201).log().all().extract().jsonPath().get("id").toString();
//		System.out.println("Student ID is:" +StudentID);
//		
//	}
//	@Test(priority=2, dependsOnMethods="CreateStudent")
//	void updateStudent() {
//		given().log().all().
//		when().get("http://localhost:3000/Student/"+StudentID)
//		.then().statusCode(200).log().all();
//		
//	}
//	@Test(priority=3, dependsOnMethods="CreateStudent")
//	void getStudent() {
//		given().log().all().body("\r\n"
//				+ "  {\r\n"
//				+ "    \"name\": \"Arun\",\r\n"
//				+ "    \"id\": \"103\",\r\n"
//				+ "    \"location\": \"Madurai\",\r\n"
//				+ "    \"phone_number\": 8904567890,\r\n"
//				+ "    \"Courses\": [\r\n"
//				+ "      \"c\",\r\n"
//				+ "      \"c++\"\r\n"
//				+ "    ]\r\n"
//				+ "  }").
//		when().get("http://localhost:3000/Student/"+StudentID)
//		.then().statusCode(200).log().all();
//		
//	}
//	@Test(priority=4, dependsOnMethods="CreateStudent")
//	void deleteStudent() {
//		given().log().all().
//		when().delete("http://localhost:3000/Student/"+StudentID)
//		.then().statusCode(200).log().all();		
//	}
	
	@Test(priority=5)
	void CreateBook() {
		


// Approach 1 using HashMap

HashMap<String, Object> book1 = new HashMap<>();
 book1.put("title", "Java");
 book1.put("schema", "John Doe");
 book1.put("price", 12.24);
book1.put("categories", Arrays.asList("c", "c++"));

// Book 2
 HashMap<String, Object> book2 = new HashMap<>();
 book2.put("title", "Python");
 book2.put("schema", "Paul");
book2.put("price", 30.9);
 book2.put("categories", Arrays.asList("java", "c++"));

// List of books
 List<Map<String, Object>> books = new ArrayList<>();
 books.add(book1);
books.add(book2);

// Bicycle
 Map<String, Object> bicycle = new HashMap<>();
 bicycle.put("type", "Mountain");
 bicycle.put("price", 32.8);

 // Final JSON structure
 Map<String, Object> finalMap = new HashMap<>();
 finalMap.put("book", books);
finalMap.put("bicycle", bicycle);

 System.out.println(finalMap);

//		JSONObject requestBody=new JSONObject();
//		requestBody.put("title", "Java");
//		requestBody.put("schema", "John Doe");
//		requestBody.put("price", "12.3");
//		String Categories[]= {"C","C++"};
//		requestBody.put("categories", Categories);
		
//		StudentID = 
//				given().body(requestBody.toString()).log().all()
		
//				given().body(hashmap).log().all()
//				.when()
////				.body("title", equalTo("Java"))
//				.post("http://localhost:3000/store")
//		.then().statusCode(200).log().all().extract();
////		.jsonPath().get("id").toString();
//		System.out.println("Student ID is:" +StudentID);
//		

// Send POST request and extract ID
// String studentID = 
 given()
 .body(finalMap)
 .header("Content-Type", "application/json")
.log().all()
 .when()
 .post("http://localhost:3000/store")
.then()
.statusCode(200)
.log().all();
//.extract()
//.jsonPath()
// .getString("title"); // Adjust based on actual response structure

System.out.println("Student ID is: " );
		
	}
	

}
