package mileStone_4;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReqresApitests {
@BeforeClass
	
	public void setUp() {
		baseURI = "https://reqres.in";
	}
		
  @Test (priority = 1)
  public void testGetUsers() {
	  given()
	  .log().all()
	  .when()
	  .get("/api/users?page=2")
	  .then()
	  .statusCode(200)
	  .body("page",equalTo(2))
	  .body("data",notNullValue())
	  .log().all();
  }
  @Test(priority = 2)
  
  public void testGetUserByid() {
	  given()
	  .when()
	  .get("/api/users/2")
	  .then()
	  .statusCode(200)
	  .body("data.id",equalTo(2))
	  .body("data.email",equalTo("janet.weaver@reqres.in"))
	  .body("data.first_name",equalTo("Janet"))
	  .body("data.last_name",equalTo("Weaver"));  
  }
  @Test(priority = 3)
  
  public void testPostUser() {
	  String requestBody ="{\"name\":\"morpheus\",\"job\":\"leader\"}";
	  
	    given()
	    .body(requestBody)
	    .when()
	    .post("/api/users")
	    .then()
	    .statusCode(201);
  }
  @Test(priority = 4)
  public void testUpdateUser() {
	  String requestBody ="{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
	  
	    given()
	    .body(requestBody)
	    .when()
	    .put("/api/users/2")
	    .then()
	    .statusCode(200);
  }
  @Test(priority = 5)
  public void testDeleteUser() {
	  
	    given()
	    .when()
	    .delete("/api/users/2")
	    .then()
	    .statusCode(204);
  }
  @Test(priority = 6)
  public void testPatchUser() {
	  String requestBody ="{\"name\":\"morpheus\",\"job\":\"zion resident\"}";
	  
	    given()
	    .body(requestBody)
	    .when()
	    .put("/api/users/2")
	    .then()
	    .statusCode(200);
  } 
}
