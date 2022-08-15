package com.ostapiuk.core.utils;

import org.openqa.selenium.io.FileHandler;

import java.io.*;

public class FileUtils {

    private FileUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void unzipFile(File output, InputStream zipStream, String name, boolean isWindows) throws IOException {
        File toWrite = new File(output, name);
        toWrite.setExecutable(true);
        if (!FileHandler.createDir(toWrite.getParentFile())) {
            throw new IOException("Cannot create parent director for: " + name);
        }
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(toWrite), 16384)) {
            byte[] buffer = new byte[16384];
            int read;
            while ((read = zipStream.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        } finally {
            //Setting 777 permissions to just created file in unix systems for further work with a file
            if (!isWindows) {
                Runtime.getRuntime().exec("chmod 777 " + toWrite.getPath());
            }
        }
    }
}
