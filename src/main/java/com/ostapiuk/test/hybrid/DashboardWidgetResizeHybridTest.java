package com.ostapiuk.test.hybrid;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.ScreenShooter;
import com.ostapiuk.business.bo.LogInBO;
import com.ostapiuk.business.bo.NavigationBO;
import com.ostapiuk.business.bo.ResizeBO;
import com.ostapiuk.business.model.api.dashboard.DashboardCreationResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardDeletionResponse;
import com.ostapiuk.business.model.api.dashboard.DashboardEntity;
import com.ostapiuk.business.model.api.widget.WidgetCreationResponse;
import com.ostapiuk.business.model.api.widget.WidgetDeletionResponse;
import com.ostapiuk.business.model.api.widget.WidgetEntity;
import com.ostapiuk.business.validator.DashboardResponsesValidator;
import com.ostapiuk.business.validator.WidgetResizeValidator;
import com.ostapiuk.business.validator.WidgetResponsesValidator;
import com.ostapiuk.core.client.ReportPortalAPIClient;
import com.ostapiuk.core.data_providers.DashboardsProvider;
import com.ostapiuk.core.data_providers.UsersProvider;
import com.ostapiuk.core.data_providers.WidgetIdProvider;
import com.ostapiuk.core.data_providers.WidgetsProvider;
import com.ostapiuk.core.driver.DriverManager;
import com.ostapiuk.core.properties.DataProperties;
import com.ostapiuk.core.utils.FilePath;
import com.ostapiuk.core.utils.IdFile;
import org.openqa.selenium.Point;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Listeners({ScreenShooter.class})
public class DashboardWidgetResizeHybridTest {

    private ResizeBO resizeBO;
    private LogInBO logInBO;
    private WidgetResizeValidator resizeValidator;
    private DashboardResponsesValidator dashboardResponsesValidator;
    private IdFile idFile;
    private String projectName;
    private WidgetResponsesValidator widgetResponsesValidator;
    private Integer widgetId;
    private Integer dashboardId;

    @BeforeTest
    public void beforeTest() {
        DriverManager.setUpDriver();
        open("/");
    }

    @BeforeClass
    public void initializeFields() {
        resizeBO = new ResizeBO();
        logInBO = new LogInBO();
        resizeValidator = new WidgetResizeValidator();
        dashboardResponsesValidator = new DashboardResponsesValidator();
        widgetResponsesValidator = new WidgetResponsesValidator();
        idFile = new IdFile();
        projectName = UsersProvider.getSingleUser().getEmail() + "_personal";
        widgetId = WidgetIdProvider.getExistingWidgetId(projectName);
    }

    @BeforeClass
    public void login() {
        logInBO.logIn(UsersProvider.getSingleUser());
    }

    @Test(dataProvider = "provideDashboard",
            dataProviderClass = DashboardsProvider.class,
            priority = 1)
    public void verifyDashboardCreation(DashboardEntity dashboard) {
        DashboardCreationResponse dashboardCreationResponse = new ReportPortalAPIClient()
                .createDashboard(dashboard, projectName);
        dashboardResponsesValidator.verifyDashboardCreationResponse(dashboardCreationResponse);
        idFile.writeIdToFile(dashboardCreationResponse.getId(), FilePath.DASHBOARD_FILE);
    }

    @Test(dataProvider = "provideWidget",
            dataProviderClass = WidgetsProvider.class,
            priority = 2)
    public void verifyWidgetCreation(WidgetEntity widget) {
        dashboardId = idFile.readIdFromFile(FilePath.DASHBOARD_FILE);
        WidgetCreationResponse widgetCreationResponse = new ReportPortalAPIClient()
                .createWidgetForDashboard(widget, projectName, dashboardId);
        widgetResponsesValidator.verifyWidgetCreationResponse(widgetCreationResponse, widgetId, dashboardId);
    }

    @Test(priority = 3)
    public void verifyResizeIsSaved() {
        int widgetNumber = 0;
        Selenide.refresh();
        dashboardId = idFile.readIdFromFile(FilePath.DASHBOARD_FILE);
        new NavigationBO().openDashboardByName(DataProperties.getDashboardName());
        Point sizeBefore = resizeBO.getWidgetPosition(widgetNumber);
        resizeBO.resizeWidget(widgetNumber);
        Point sizeAfter = resizeBO.getWidgetPosition(widgetNumber);
        resizeValidator.verifyWidgetIsResized(sizeBefore, sizeAfter);
    }

    @Test(priority = 4)
    public void verifyWidgetDeletion() {
        WidgetDeletionResponse widgetDeletionResponse = new ReportPortalAPIClient()
                .deleteWidgetById(projectName, dashboardId, widgetId);
        widgetResponsesValidator.verifyWidgetDeletionResponse(widgetDeletionResponse, widgetId, dashboardId);
    }

    @Test(priority = 5)
    public void verifyDashboardDeletion() {
        DashboardDeletionResponse dashboardDeletionResponse = new ReportPortalAPIClient()
                .deleteDashboardById(projectName, dashboardId);
        dashboardResponsesValidator.verifyDashboardDeletionResponse(dashboardDeletionResponse, dashboardId);
    }

    @AfterClass
    public void logOut() {
        logInBO.logOut();
    }

    @AfterClass
    public void tearDown() {
        closeWebDriver();
    }
}