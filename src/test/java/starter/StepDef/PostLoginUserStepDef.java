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

public class PostLoginUserStepDef {
    @Steps
    ReqresApi reqresApi;
    @Given("Post Login User with valid body json")
    public void postLoginUserWithValidBodyJson() {
        File json = new File(Constants.REQ_BODY_DIR + "LoginValidBody.json");
        reqresApi.postLoginUserWithValidBodyJson(json);
    }
    @When("Send Post Login User")
    public void sendPostLoginUser() {
        SerenityRest.when().post(ReqresApi.POST_LOGIN_USER);
    }
    @And("Validate Post Login User JSON Schema")
    public void validatePostUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"PostLoginUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
