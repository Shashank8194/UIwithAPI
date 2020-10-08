package controllers;

import org.testng.annotations.DataProvider;
import utilities.ExcelUtility;

import java.io.File;
import java.lang.reflect.Method;

public class ExcelDataProvider extends InitMethod {


        @DataProvider(name="multiSheetExcelRead", parallel=true)
        public static Object[][] multiSheetExcelRead(Method method) throws Exception
        {
            File file = new File("./src/test/resources/ExcelFiles/testNDTV.xlsx");
            String SheetName = method.getName();
            System.out.println(SheetName);
            Object testObjArray[][] = ExcelUtility.getTableArray(file.getAbsolutePath(), SheetName);
            return testObjArray;
        }

        @DataProvider(name="excelSheetNameAsMethodName",parallel=true)
        public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception
        {
            File file = new File("./src/test/resources/ExcelFiles/"+method.getName()+".xlsx");
            Object testObjArray[][] = ExcelUtility.getTableArray(file.getAbsolutePath());
            return testObjArray;
        }

}
