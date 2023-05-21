package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;


public class ReqresApi {

    public static String GET_LIST_USER = Constants.BASE_URL + "/api/users?page={page}";

    public static String POST_CREATE_USER = Constants.BASE_URL + "/api/users";

    public static String PUT_UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";

    public static String DELETE_USER = Constants.BASE_URL + "/api/users/{id}";

    //tugas

    public static String GET_SINGLE_USER = Constants.BASE_URL + "/api/users/{id}";

    public static String POST_REGISTER_USER = Constants.BASE_URL + "/api/register";

    public static String POST_LOGIN_USER = Constants.BASE_URL + "/api/login";


    //tugas

    @Step("Get list users with valid parameter page")
    public void getListUsersValidParamPage(int page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("post create new user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON);
    }

    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    //tugas
    @Step("Get Single User Not Found")
    public void getSingleUserNotFound(int id) {
        SerenityRest.given().pathParam("id", id);
    }
    @Step("Post Register User with valid body json")
    public void postRegisterUserWithValidBodyJson(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Post Login User with valid body json")
    public void postLoginUserWithValidBodyJson(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete Exceed user")
    public void deleteExceedUser(int id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Put update user with valid json and invalid id")
    public void putUpdateUserWithValidJsonAndInvalidId(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON);
    }

    @Step("Post Login Unsuccessful with body json")
    public void postLoginUnsuccessfulWithBodyJson(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //tugas


}