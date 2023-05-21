package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;

public class GetSingleUserStepDef {
    @Steps
    ReqresApi reqresApi;

    @Given("Get single user with invalid parameter id {int}")
    public void getSingleUserWithInvalidParameterId(int id){
        reqresApi.getSingleUserNotFound(id);
    }

    @When("Send get single user")
    public void sendGetSingleUser() {
        SerenityRest.when().get(ReqresApi.GET_SINGLE_USER);
    }

    @Then("Response code should be {int} Not Found")
    public void responseCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
