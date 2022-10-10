package com.ostapiuk.business.model.enums;

public enum TestData {
    TOTAL("total-col", "total", true),
    PASSED("passed-col", "passed", true),
    FAILED("failed-col", "failed", true),
    SKIPPED("skipped-col", "skipped", false),
    PRODUCT_BUG("pb-col", "product bug", false),
    AUTO_BUG("ab-col", "auto bug", false),
    SYSTEM_ISSUE("si-col", "system issue", false),
    TO_INVESTIGATE("ti-col", "to investigate", false);

    public final String locator;
    public final String name;
    public final boolean isRequired;

    TestData(String locator, String name, boolean isRequired) {
        this.locator = locator;
        this.name = name;
        this.isRequired = isRequired;
    }
}
