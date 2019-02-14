package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;



public class GetPostSteps {
    @Test
    @Given("^I perform GET operation$")
    public void iPerformGETOperation() {
        given().contentType(ContentType.JSON);
    }

    @Test
    @When("^I perform GET for the post number (\\d+)$")
    public void i_perform_GET_for_the_post_number(int idNumber) {
        when().get(String.format("http://api-build-and-testing-project-flask-demo.192.168.99.100.nip.io/results/%s", idNumber))
                .then();//.body(containsString("Jerry"));
    }
    @Test
    @Then("^Response code should be \"([^\"]*)\"$")
    public void responseCodeShouldBe(int code) {
        given().contentType(ContentType.JSON).
                when().
                then().statusCode(code);
    }
    @Test
    @Given("^I perform a POST operation$")
    public void iPerformAPOSTOperation() {
        given().contentType(ContentType.JSON);
    }

    @Test
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
                .post("http://api-build-and-testing-project-flask-demo.192.168.99.100.nip.io/results").
                then();
    }

    @Test
    @Given("^I perform Delete operation$")
    public void i_perform_Delete_operation()  {
        given().contentType(ContentType.JSON);
    }
    @Test
    @When("^I delete \"([^\"]*)\"$")
    public void i_delete(String idNum)  {
        given().contentType(ContentType.JSON);

        when().delete("http://api-build-and-testing-project-flask-demo.192.168.99.100.nip.io/results/{%s}", idNum).then();
    }
    @Test
    @Given("^I perform a Update operation$")
    public void i_perform_a_Update_operation() {
        given().contentType(ContentType.JSON);
    }
    @Test
    @When("^I change name$")
    public void i_change_name()  {
        String name = "Bonga";
        HashMap<String, Object > postContent = new HashMap<String, Object >();
        postContent.put("chemistry", 78);
        postContent.put("maths", 80);
//        postContent.put("name", name);
        postContent.put("physics", 90);





        given()
                .contentType(ContentType.JSON).

                with()
                .body(postContent).
                when()
                .put("http://api-build-and-testing-project-flask-demo.192.168.99.100.nip.io/results/3").
                then();

    }

}






