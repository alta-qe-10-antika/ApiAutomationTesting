package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;
import starter.Utils.Constants;

import java.io.File;

public class DeleteUserStepDef {

    @Steps
    ReqresApi reqresApi;

    @Given("Delete user with exceed id {int}")
    public void deleteUserWithInvalidId(int id) {
        reqresApi.deleteExceedUser(id);

    }

    @When("Send delete Exceed user")
    public void sendExceedUser() {
        SerenityRest.when().delete(ReqresApi.DELETE_USER);
    }



}
