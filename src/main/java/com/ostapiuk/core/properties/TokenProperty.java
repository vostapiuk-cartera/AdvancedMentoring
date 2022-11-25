package com.ostapiuk.core.properties;

import com.ostapiuk.core.utils.FilePath;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class TokenProperty {

    public static String readTokenFromFile() {
        try (Reader rd = new FileReader(FilePath.TOKEN_FILE)) {
            Scanner scan = new Scanner(rd);
            return scan.nextLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
