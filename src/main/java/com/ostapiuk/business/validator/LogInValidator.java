package com.ostapiuk.business.validator;

import com.ostapiuk.business.po.NotificationPage;
import com.ostapiuk.core.logger.Log;
import com.ostapiuk.core.properties.DataProperties;
import org.testng.Assert;

public class LogInValidator {
    NotificationPage notificationPage;

    public LogInValidator() {
        notificationPage = new NotificationPage();
    }

    public void verifyLogin(boolean expectedResult) {
        Log.log("Verify notification displayed after success login");
        Assert.assertEquals(notificationPage.isNotificationDisplayed(), expectedResult, "Notification about login is not displayed");
        Assert.assertEquals(notificationPage.getNotificationText(), DataProperties.getSuccessLogin(), "Notification has not success message");
    }
}
