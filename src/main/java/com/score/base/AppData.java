package com.score.base;

public class AppData {
    public static String platform = System.getProperty("platform", "android");
 // Android Application capabilities 
    public static String  androidAppPackage = "com.fivemobile.thescore";
    public static String  androidPlatformName = "Android";
    public static String  androidPlatformVersion = "11.0";
    public static String  androidAppActivity = "com.fivemobile.thescore.ui.MainActivity";
    public static boolean  noReset = true;
    public static String testDataSheetPath = "testdata/TestData.xlsx"; 
    
    // IOS Application capabilities
    public static String  IOSBundleID = "com.fivemobile.thescore";
    public static String  IOSPlatformName = "IOS";
    public static String  IOSPlatformVersion = "16.0";

}