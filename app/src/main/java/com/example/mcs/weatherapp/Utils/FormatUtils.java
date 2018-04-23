package com.example.mcs.weatherapp.Utils;

public class FormatUtils {

    private static final String zipRegex = "\\d{5}";

    public static boolean isValidZip(String zip){

        return zip.matches(zipRegex);

    }
}
