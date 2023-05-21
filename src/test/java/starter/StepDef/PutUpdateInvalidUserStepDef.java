package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;
import starter.Utils.Constants;

import java.io.File;

public class PutUpdateInvalidUserStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Put update user with valid json and invalid id {int}")
    public void  putUpdateUserWithValidJsonAndInvalidId(int id){
        File json = new File(Constants.REQ_BODY_DIR+"PutUpdateInvalidBody.json");
        reqresApi.putUpdateUserWithValidJsonAndInvalidId(id, json);
    }
    @When("Send put update user invalid id")
    public void sendPutUpdateUserInvalidId() {
        SerenityRest.when().put(ReqresApi.PUT_UPDATE_USER);
    }
}
