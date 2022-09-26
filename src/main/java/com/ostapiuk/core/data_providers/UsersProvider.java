package com.ostapiuk.core.data_providers;

import com.ostapiuk.business.model.UserEntity;
import com.ostapiuk.core.utils.JsonParser;
import org.testng.annotations.DataProvider;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class UsersProvider {

    private static final List<UserEntity> USERS = Objects.requireNonNull(JsonParser.getJsonEntity()).getUsers();

    @DataProvider(name = "providePortalUsers")
    public Iterator<Object[]> provideUsers() {
        return Stream.of(UsersProvider.getUsers()).iterator();
    }

    public static Object[][] getUsers() {
        int usersAmount = USERS.size();
        Object[][] users = new Object[usersAmount][];
        for (int i = 0; i < usersAmount; i++) {
            users[i] = new Object[]{
                    USERS.get(i).getEmail(),
                    USERS.get(i).getPassword(),
                    USERS.get(i).isExpected()
            };
        }
        return users;
    }

    public static UserEntity getSingleUser() {
        return USERS.get(1);
    }
}
