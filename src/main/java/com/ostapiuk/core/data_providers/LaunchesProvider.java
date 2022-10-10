package com.ostapiuk.core.data_providers;

import com.ostapiuk.business.model.LaunchEntity;
import com.ostapiuk.core.utils.JsonParser;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LaunchesProvider {

    private static final List<LaunchEntity> LAUNCHES = Objects.requireNonNull(JsonParser.getJsonEntity()).getLaunches();

    public static Object[][] getLaunches() {
        int launchesAmount = LAUNCHES.size();
        Object[][] launches = new Object[launchesAmount][];
        for (int i = 0; i < launchesAmount; i++) {
            launches[i] = new Object[]{
                    LAUNCHES.get(i).getLaunchName()
            };
        }
        return launches;
    }

    @DataProvider(name = "providePortalLaunches", parallel = true)
    public Iterator<Object[]> providePortalLaunches() {
        return Stream.of(LaunchesProvider.getLaunches()).iterator();
    }
}
