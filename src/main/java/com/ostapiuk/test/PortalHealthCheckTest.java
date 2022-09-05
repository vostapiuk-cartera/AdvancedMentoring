package com.ostapiuk.test;

import com.ostapiuk.business.validator.PortalHealthCheckValidator;
import org.testng.annotations.Test;

public class PortalHealthCheckTest extends BaseTest {

    @Test
    public void verifyReportPortalIsUp() {
        PortalHealthCheckValidator healthCheckValidator = new PortalHealthCheckValidator();
        healthCheckValidator.verifyReportPortalIsUp();
    }
}
