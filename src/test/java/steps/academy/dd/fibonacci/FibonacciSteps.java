package steps.academy.dd.fibonacci;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class FibonacciSteps {
    private Response response;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 7003;
    }

    @Then("^the user should be displayed with the fibonacci sequence for first ten numbers$")
    public void theUserShouldBeDisplayedWithTheFibonacciSequenceForFirstNumbers() {
        response.then().statusCode(200)
                .body("size()", is(10))
                .body("$", hasItems("0", "1", "1", "2", "3", "5", "8", "13", "21", "34"));
    }

    @Given("^the user in the homepage$")
    public void theUserInTheHomepage()  {
        response = get("/fib");
    }

    @Then("^the user should be displayed with the appropriate fibonacci (.*)$")
    public void theUserShouldBeDisplayedWithTheAppropriateFibonacciValue(String value) throws Throwable {
        response.then().statusCode(200)
                .body(equalTo(value));
    }

    @Given("^the user set the (.*) for fibonacci in the url$")
    public void theUserSetTheIndexForFibonacciInTheUrl(String index) throws Throwable {
        response = get("/fib/"+index+"");
    }

    @Given("^the user set the (.*) and (.*) as a range for fibonacci$")
    public void the_user_set_the_and_for_fibonacci(String startIndex, String finalIndex) throws Exception {
        response = get("/fib/range?startIndex="+startIndex+"&finishIndex="+finalIndex+"");
    }

    @Then("^the user should be displayed with the appropriate range of fibonacci values$")
    public void the_user_should_be_displayed_with_the_appropriate_of_fibonacci_values(DataTable table) throws Exception {
        for (int i = 0; i < table.raw().size(); i++) {
            response.then()
                    .body("$", hasItems(table.raw().get(i).get(0)));
        }
    }
}
