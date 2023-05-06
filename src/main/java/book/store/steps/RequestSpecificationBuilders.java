package book.store.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static book.store.steps.GlobalActions.sendBodyCreatingUser;

public class RequestSpecificationBuilders {
    private static RequestSpecification reqSpec;

    private RequestSpecBuilder reqSpecBuilder;

    public static RequestSpecification postDemoQaCreateUser(String userName, String password) {
        reqSpec = new RequestSpecBuilder().setBaseUri(EndpointsUtils.CREATE_USER).build();
        reqSpec.body(sendBodyCreatingUser(userName, password));
        return reqSpec.contentType(ContentType.JSON);
    }
}
