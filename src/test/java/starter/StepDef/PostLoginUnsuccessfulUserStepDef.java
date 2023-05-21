package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.eclipse.jetty.util.security.Password;
import starter.Reqres.ReqresApi;
import starter.Utils.Constants;

import java.io.File;

public class PostLoginUnsuccessfulUserStepDef {

    @Steps
    ReqresApi reqresApi;
    @Given("Post Login Unsuccessful with body json")
    public void postLoginUnsuccessfulWithBodyJson() {
        File json = new File(Constants.REQ_BODY_DIR + "LoginUnsuccessfulBody.json");
        reqresApi.postLoginUnsuccessfulWithBodyJson(json);
    }

    @When("Send Post Login Unsuccessful")
    public void sendPostLoginUnsuccessful() {
        SerenityRest.when().post(ReqresApi.POST_LOGIN_USER);
    }

    @Then("Status code should be {int} Missing Password")
    public void statusCodeShouldBeMissingPassword(int MissingPassword) {
        SerenityRest.then().statusCode(MissingPassword);
    }
}
