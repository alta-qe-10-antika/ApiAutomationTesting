package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;
import starter.Reqres.ReqresApi;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class ReqresStepDef {

    @Steps
    ReqresApi reqresApi;

    //    TEST CASE POSITIVE
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresApi.getListUsersValidParamPage(page);
    }

    @When("Send get list users")
    public void sendGetListUsers() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USER);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body page should be page {int}")
    public void responseBodyPageShouldBePage(int page) {
        SerenityRest.and().body("page",equalTo(page));
    }
    @And("Validate get list user JSON Schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ListUserJSONSchema.json");
        SerenityRest.and().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //    TEST CASE NEGATIVE
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson() {
        File json = new File(Constants.REQ_BODY_DIR + "UserReqBody.json");
        reqresApi.postCreateUser(json);
    }

    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(ReqresApi.POST_CREATE_USER);
    }

    @Then("Status code should be {int} Created")
    public void statusCodeShouldBeCreated(int Created) {
        SerenityRest.then().statusCode(Created);
    }
    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name)).body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate create list user JSON Schema")
    public void validateCreateListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"CreateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    // Put
    @Given("Put update user with valid json and id {int}")
    public void  putUpdateUserWithValidJsonAndId(int id){
        File json = new File(Constants.REQ_BODY_DIR+"UserReqBody.json");
      reqresApi.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser(){
        SerenityRest.when().put(ReqresApi.PUT_UPDATE_USER);
    }
    @And("Response body name was updated to {string} and job was updated to {string}")
    public void responseBodyNameWasUpdatedToAndJobWasUpdatedTo(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME,equalTo(name)).body(ReqresResponses.JOB,equalTo(job));
    }
    @And("Validate update list user JSON Schema")
    public void validateUpdateListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"UpdateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Delete
    @Given("Delete user with valid id {int}")
    public void deleteUserWithValidId(int id) {
        reqresApi.deleteUser(id);
    }

    @When("Send delete user")
    public void sendDeleteUser(){
        SerenityRest.when().delete(ReqresApi.DELETE_USER);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent){
        SerenityRest.then().statusCode(noContent);
    }


}