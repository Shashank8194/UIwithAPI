package controllers;

public class InitMethod {

public static ApplicationConfigReader applicationConfigReader=new ApplicationConfigReader();

public static String Browser=applicationConfigReader.getBrowser();
public static String Base_URI=applicationConfigReader.getBase_URI();
public  static String WebSite=applicationConfigReader.getURL();
public static  int ImpicitTime=applicationConfigReader.getImplicitlyWait();
public static  String End_Point=applicationConfigReader.getEndpoint();
public static String apikey=applicationConfigReader.getApikey();
public static String city=applicationConfigReader.getCity();

public static String ExcelFile="./src/test/resources/ExcelFiles/";
}
