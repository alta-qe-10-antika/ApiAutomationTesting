package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresApi;
import starter.Utils.Constants;

import java.io.File;

public class PostRegisterUserStepDef {
    @Steps
    ReqresApi reqresApi;
    @Given("Post Register User with valid json")
    public void postRegisterUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR + "RegisterValidBody.json");
        reqresApi.postRegisterUserWithValidBodyJson(json);
    }

    @When("Send Post Register User")
    public void sendPostRegisterUser() {
        SerenityRest.when().post(ReqresApi.POST_REGISTER_USER);
    }

    @And("Validate Post User JSON Schema")
    public void validatePostUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"PostRegisterUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
