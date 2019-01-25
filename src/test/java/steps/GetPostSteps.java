package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;



public class GetPostSteps {

    @Given("^I perform GET operation$")
    public void iPerformGETOperation() {
        given().contentType(ContentType.JSON);
    }


    @When("^I perform GET for the post number (\\d+)$")
    public void i_perform_GET_for_the_post_number(int idNumber) {
        when().get(String.format("http://127.0.0.1:5000/results/%s", idNumber))
                .then();//.body(containsString("Jerry"));
    }

    @Then("^Response code should be \"([^\"]*)\"$")
    public void responseCodeShouldBe(int code) {
        given().contentType(ContentType.JSON).
                when().
                then().statusCode(code);
    }

    @Given("^I perform a POST operation$")
    public void iPerformAPOSTOperation() {
        given().contentType(ContentType.JSON);
    }


    @When("^I post a new \"([^\"]*)\" , \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_post_a_new_and(String name, String physics, String maths, String chemistry) {
        HashMap<String, String> postContent = new HashMap<String, String>();
        postContent.put("name", name);
        postContent.put("physics", physics);
        postContent.put("maths", maths);
        postContent.put("chemistry", chemistry);

        given()
                .contentType(ContentType.JSON).

                with()
                .body(postContent).
                when()
                .post("http://0.0.0.0:5000/results").
                then();
    }


    @Given("^I perform Delete operation$")
    public void i_perform_Delete_operation()  {
        given().contentType(ContentType.JSON);
    }

    @When("^I delete \"([^\"]*)\"$")
    public void i_delete(String idNum)  {
        given().contentType(ContentType.JSON);

        when().delete("http://0.0.0.0:5000/results/{%s}", idNum).then();
    }

    @Given("^I perform a Update operation$")
    public void i_perform_a_Update_operation() {
        given().contentType(ContentType.JSON);
    }

    @When("^I change name$")
    public void i_change_name()  {
        String name = "Bonga";
        HashMap<String, Object > postContent = new HashMap<String, Object >();
        postContent.put("chemistry", 78);
        postContent.put("maths", 80);
        postContent.put("name", name);
        postContent.put("physics", 90);





        given()
                .contentType(ContentType.JSON).

                with()
                .body(postContent).
                when()
                .put("http://0.0.0.0:5000/results/1").
                then();

    }

}






