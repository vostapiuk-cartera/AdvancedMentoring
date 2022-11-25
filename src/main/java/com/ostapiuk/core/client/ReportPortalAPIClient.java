package com.ostapiuk.core.client;

import com.ostapiuk.business.model.api.dashboard.DashboardCreationResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardDeletionResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardEntity;
import com.ostapiuk.business.model.api.dashboard.DashboardModificationResponse;
import com.ostapiuk.business.model.api.widget.*;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.properties.TokenProperty;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;

public class ReportPortalAPIClient {

    public RequestSpecification initSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(ConfigProperties.getBaseApiUrlProperty())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .build();
    }

    public RequestSpecification initAuthorize() {
        return given().spec(initSpec())
                .auth().oauth2(TokenProperty.readTokenFromFile());
    }

    public Response getReportPortalStatus() {
        return (Response) given().spec(initSpec())
                .when().get()
                .then().statusCode(SC_OK);
    }

    public DashboardCreationResponse createDashboard(DashboardEntity dashboard, String projectName) {
        return initAuthorize()
                .with().body(dashboard)
                .when().pathParam("projectName", projectName)
                .post(EndPoint.CREATE_DASHBOARD)
                .then().statusCode(SC_CREATED)
                .extract().as(DashboardCreationResponse.class);
    }

    public DashboardDeletionResponse deleteDashboardById(String projectName, Integer id) {
        return initAuthorize()
                .when().pathParam("projectName", projectName)
                .when().pathParam("id", id)
                .delete(EndPoint.DELETE_DASHBOARD)
                .then().statusCode(SC_OK)
                .extract().as(DashboardDeletionResponse.class);
    }

    public DashboardModificationResponse modifyDashboardById(DashboardEntity dashboard, String projectName, Integer id) {
        return initAuthorize()
                .with().body(dashboard)
                .when().pathParam("projectName", projectName)
                .when().pathParam("id", id)
                .put(EndPoint.UPDATE_DASHBOARD)
                .then().statusCode(SC_OK)
                .extract().as(DashboardModificationResponse.class);
    }

    public WidgetCreationResponse createWidgetForDashboard(WidgetEntity widget, String projectName, Integer dashboardId) {
        return initAuthorize()
                .with().body(widget)
                .when().pathParam("projectName", projectName)
                .when().pathParam("id", dashboardId)
                .put(EndPoint.CREATE_WIDGET)
                .then().statusCode(SC_OK)
                .extract().as(WidgetCreationResponse.class);
    }

    public WidgetLoadResponse getWidgetForProject(String projectName) {
        return initAuthorize()
                .when().pathParam("projectName", projectName)
                .get(EndPoint.GET_WIDGET)
                .then().statusCode(SC_OK)
                .extract().as(WidgetLoadResponse.class);
    }

    public WidgetDeletionResponse deleteWidgetById(String projectName, Integer dashboardId, Integer widgetId) {
        return initAuthorize()
                .when().pathParam("projectName", projectName)
                .when().pathParam("dashboardId", dashboardId)
                .when().pathParam("widgetId", widgetId)
                .delete(EndPoint.DELETE_WIDGET)
                .then().statusCode(SC_OK)
                .extract().as(WidgetDeletionResponse.class);
    }

    public WidgetModificationResponse modifyWidgetById(UpdatedWidgetEntity widget, String projectName, Integer id) {
        return initAuthorize()
                .with().body(widget)
                .when().pathParam("projectName", projectName)
                .when().pathParam("id", id)
                .put(EndPoint.UPDATE_WIDGET)
                .then().statusCode(SC_OK)
                .extract().as(WidgetModificationResponse.class);
    }
}
