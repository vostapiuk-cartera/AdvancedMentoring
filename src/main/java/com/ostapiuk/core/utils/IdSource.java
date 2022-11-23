package com.ostapiuk.core.utils;

import java.io.*;
import java.util.Scanner;

public class IdSource {

    public void writeIdToFile(Integer dashboardId, String filePath) {
        try (Writer wr = new FileWriter(filePath)) {
            wr.write(String.valueOf(dashboardId));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer readIdFromFile(String filePath) {
        try (Reader rd = new FileReader(filePath)) {
            Scanner scan = new Scanner(rd);
            return Integer.parseInt(scan.nextLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFile(String filePath) {
        try (Writer wr = new FileWriter(filePath)) {
            wr.write("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
