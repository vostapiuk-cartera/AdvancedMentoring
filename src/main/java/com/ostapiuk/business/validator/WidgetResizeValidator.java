package com.ostapiuk.business.validator;

import org.openqa.selenium.Point;
import org.testng.Assert;

public class WidgetResizeValidator {

    public WidgetResizeValidator() {
    }

    public void verifyWidgetIsResized(Point beforeResize, Point afterResize) {
        Assert.assertTrue((beforeResize.getX() != afterResize.getX()) || (beforeResize.getY() != afterResize.getY()), "Widget is not resized, size is not saved");
    }
}
