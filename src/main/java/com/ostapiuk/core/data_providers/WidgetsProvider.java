package com.ostapiuk.core.data_providers;

import com.ostapiuk.business.model.api.widget.*;
import com.ostapiuk.core.properties.ConfigProperties;
import com.ostapiuk.core.properties.DataProperties;
import org.testng.annotations.DataProvider;

public class WidgetsProvider {

    @DataProvider(name = "provideWidget")
    public static Object[][] getNewWidgetData() {
        return new Object[][]{
                {getWidget(DataProperties.getWidgetType())}
        };
    }

    @DataProvider(name = "provideUpdatedWidget")
    public static Object[][] getUpdatedWidgetData() {
        return new Object[][]{
                {getUpdatedWidget(DataProperties.getWidgetNewType())}
        };
    }

    public static WidgetEntity getWidget(String widgetType) {
        return WidgetEntity.builder()
                .addWidget(
                        AddWidgetEntity.builder()
                                .widgetId(Integer.parseInt(ConfigProperties.getWidgetIdProperty()))
                                .share(DataProperties.getDashboardShareValue())
                                .widgetPosition(
                                        WidgetPositionEntity.builder()
                                                .positionX(0)
                                                .positionY(0)
                                                .build()
                                )
                                .widgetSize(
                                        WidgetSizeEntity.builder()
                                                .height(10)
                                                .width(30)
                                                .build()
                                )
                                .build())
                .widgetType(widgetType)
                .build();
    }

    public static UpdatedWidgetEntity getUpdatedWidget(String widgetType) {
        return UpdatedWidgetEntity.builder()
                .description(DataProperties.getDashboardDescription())
                .name(DataProperties.getDashboardName())
                .share(DataProperties.getDashboardShareValue())
                .updateWidgets(new UpdateWidgetEntity[]{
                                UpdateWidgetEntity.builder()
                                        .widgetId(Integer.parseInt(ConfigProperties.getWidgetIdProperty()))
                                        .share(DataProperties.getDashboardShareValue())
                                        .widgetPosition(
                                                WidgetPositionEntity.builder()
                                                        .positionX(0)
                                                        .positionY(0)
                                                        .build()
                                        )
                                        .widgetSize(
                                                WidgetSizeEntity.builder()
                                                        .height(10)
                                                        .width(25)
                                                        .build()
                                        )
                                        .widgetType(widgetType)
                                        .build(),
                        }
                )
                .build();
    }
}
