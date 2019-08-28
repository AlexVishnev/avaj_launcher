package com.avaj_launcher.Loging;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Logger {
    private static Writer writer = null;

    public static void setFileToWrite(String path) throws IOException {
        if (Logger.writer != null)
            Logger.writer.close();
        Logger.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
    }

    public static void log(String logMessage) {
        try {
            Logger.writer.write(logMessage + '\n');
            Logger.writer.flush();
        } catch (IOException e) {
            System.err.println("Error: can`t write to file");
            System.exit(-1);
        }
    }

}
