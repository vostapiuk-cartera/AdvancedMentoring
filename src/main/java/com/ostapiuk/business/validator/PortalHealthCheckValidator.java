package com.ostapiuk.business.validator;

import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.logger.Log;
import com.ostapiuk.core.properties.DataProperties;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class PortalHealthCheckValidator {

    public void verifyReportPortalIsUp() {
        Response portalResponse = new ReportPortalAPIClient().getReportPortalStatus();
        Log.log("Verify Report portal API returns OK status code");
        portalResponse.then().assertThat().statusCode(HttpStatus.SC_OK);
        Log.log("Verify Report portal API return correct version of Report portal");
        String expectedVersion = portalResponse.then().extract().path("ui.build.version");
        Assert.assertEquals(expectedVersion, DataProperties.getPortalVersion(), "Report portal version is wrong");
    }
}
