package com.avaj_launcher.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private static final List<String> data = new ArrayList<>();

    private Parser() {

    }

    public static List<String> getData() {
        return data;
    }

    public static void openFile(String path) {
        readFile(path);
    }

    private static void readFile(String path) {

        String line;

        try {
            BufferedReader Reader = new BufferedReader(new FileReader(path));

            while ((line = Reader.readLine()) != null) {
                data.add(line);
            }

            Reader.close();


        } catch (FileNotFoundException e) {
            System.err.format("Exception occurred trying to read '%s'.", path);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
