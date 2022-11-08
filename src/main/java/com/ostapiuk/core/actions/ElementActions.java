package com.ostapiuk.core.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Point;

import java.security.SecureRandom;

public class ElementActions {

    public static void dragAndDrop(SelenideElement element, SelenideElement targetElement) {
        Selenide.actions()
                .dragAndDrop(element, targetElement)
                .perform();
    }

    public static void resize(SelenideElement element) {
        element.should(Condition.exist);
        SecureRandom random = new SecureRandom();
        int min = 0;
        int max = 50;
        int offset = random.nextInt(max - min + 1) + min;
        Selenide.actions()
                .moveToElement(element)
                .clickAndHold()
                .moveByOffset(offset, offset)
                .release()
                .perform();
    }

    public static void scrollByJS(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].scrollIntoView(true);", element);
    }

    public static long getPositionByJS() {
        Object obj = Selenide.executeJavaScript("return window.pageYOffset;");
        if (obj instanceof Double) {
            return Math.round((double) obj);
        }
        return (long) obj;
    }

    public static boolean isScrolledIntoView(SelenideElement element) {
        Point p = element.getCoordinates().onPage();
        long currentOffset = getPositionByJS();
        return currentOffset >= p.getY();
    }

    public static void clickByJS(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].click();", element);
    }

    public static Point getSize(SelenideElement element) {
        return element.getCoordinates().onPage();
    }
}
