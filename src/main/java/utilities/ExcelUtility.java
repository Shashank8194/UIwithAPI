package utilities;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtility {

private static XSSFSheet xlsxworksheet;
private static XSSFWorkbook xlsxworkbook;
private static XSSFCell xlsxcell;
private static XSSFRow xlsxrow;

private static HSSFSheet xlsworksheet;
private static HSSFWorkbook xlsworkbook;
private static HSSFCell xlscell;
private static HSSFRow xlsrow;

/**To get the  Excel -XLSX file path and name*/
public static void getExcelFile(String Path,String SheetName) throws IOException {

    File file= new File(Path);
    if (file.getAbsolutePath().endsWith(".xlsx"))
    {
        FileInputStream fileInputStream = new FileInputStream(file);
        xlsxworkbook = new XSSFWorkbook(fileInputStream);
        xlsxworksheet = xlsxworkbook.getSheet(SheetName);
    }
    else if (file.getAbsolutePath().endsWith(".xls"))
    {
        FileInputStream fileInputStream= new FileInputStream(file);
        xlsworkbook=new HSSFWorkbook(fileInputStream);
        xlsworksheet=xlsworkbook.getSheet(SheetName);
    }
}

    /** To Return the Excel-XLSX Values given Path to the File and Sheet Name */
    public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception
    {
        Object[][] tabArray = null;
        try
        {
            File file = new File(FilePath);
            if(file.getAbsolutePath().endsWith(".xlsx"))
            {
                FileInputStream ExcelFile = new FileInputStream(file);
                xlsxworkbook = new XSSFWorkbook(ExcelFile);
                xlsxworksheet = xlsxworkbook.getSheet(SheetName);

                int startRow = 1;
                int startCol = 0;
                int ci,cj;
                int totalRows = ExcelUtility.xlsxRowCount();
                int totalCols = ExcelUtility.xlsxColumnCount();
                tabArray=new Object[totalRows-1][totalCols];
                ci=0;
                for (int i=startRow;i<totalRows;i++)
                {
                    cj=0;
                    for (int j=startCol;j<totalCols;j++)
                    {
                        tabArray[ci][cj]=getCellData_XLSX(i,j);
                        cj++;
                    }
                    ci++;
                }
            }
            else if(file.getAbsolutePath().endsWith(".xls"))
            {
                FileInputStream ExcelFile = new FileInputStream(file);
                xlsworkbook = new HSSFWorkbook(ExcelFile);
                xlsworksheet = xlsworkbook.getSheet(SheetName);

                int startRow = 1;
                int startCol = 0;
                int ci,cj;
                int totalRows = ExcelUtility.xlsRowCount();
                int totalCols = ExcelUtility.xlsColumnCount();
                tabArray=new Object[totalRows-1][totalCols];
                ci=0;
                for (int i=startRow;i<totalRows;i++)
                {
                    cj=0;
                    for (int j=startCol;j<totalCols;j++)
                    {
                        tabArray[ci][cj]=getCellData_XLS(i,j);
                        cj++;
                    }
                    ci++;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            throw new Exception("Could not Find the Excel File/Sheet");
        }
        catch (Exception e)
        {
            throw new Exception("Could not Open the Excel File");
        }
        return(tabArray);
    }


    /** To Return the Excel-XLSX Values given Path to the File */
    public static Object[][] getTableArray(String FilePath) throws Exception
    {
        Object[][] tabArray = null;
        try
        {
            File file = new File(FilePath);
            if(file.getAbsolutePath().endsWith(".xlsx"))
            {
                FileInputStream ExcelFile = new FileInputStream(file);
                xlsxworkbook= new XSSFWorkbook(ExcelFile);
                xlsxworksheet = xlsxworkbook.getSheetAt(0);

                int startRow = 1;
                int startCol = 0;
                int ci,cj;
                int totalRows = ExcelUtility.xlsxRowCount();
                int totalCols = ExcelUtility.xlsxColumnCount();
                tabArray=new Object[totalRows-1][totalCols];
                ci=0;
                for (int i=startRow;i<totalRows;i++)
                {
                    cj=0;
                    for (int j=startCol;j<totalCols;j++)
                    {
                        tabArray[ci][cj]=getCellData_XLSX(i,j);
                        cj++;
                    }
                    ci++;
                }
            }
            else if(file.getAbsolutePath().endsWith(".xls"))
            {
                FileInputStream ExcelFile = new FileInputStream(file);
                xlsworkbook = new HSSFWorkbook(ExcelFile);
                xlsworksheet = xlsworkbook.getSheetAt(0);

                int startRow = 1;
                int startCol = 0;
                int ci,cj;
                int totalRows = ExcelUtility.xlsRowCount();
                int totalCols = ExcelUtility.xlsColumnCount();
                tabArray=new Object[totalRows-1][totalCols];
                ci=0;
                for (int i=startRow;i<totalRows;i++)
                {
                    cj=0;
                    for (int j=startCol;j<totalCols;j++)
                    {
                        tabArray[ci][cj]=getCellData_XLS(i,j);
                        cj++;
                    }
                    ci++;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            throw new Exception("Could not Find the Excel File/Sheet");
        }
        catch (Exception e)
        {
            throw new Exception("Could not Open the Excel File");
        }
        return(tabArray);
    }


    /** To get cell data from Excel-XLSX */
    public static Object getCellData_XLSX(int RowNum, int ColNum) throws Exception
    {
        Object CellData = null;
        try
        {
            xlsxcell = xlsxworksheet.getRow(RowNum).getCell(ColNum);
            if(xlsxcell.getCellType() == CellType.STRING)
            {
                String stringCellData = xlsxcell.getStringCellValue();
                CellData = stringCellData;
            }
				else if(xlscell.getCellType() == CellType.NUMERIC)
			{
				double numericCellData =  xlsxcell.getNumericCellValue();
				CellData = numericCellData;
			}
			else if(xlsxcell.getCellType() == CellType.BOOLEAN)
			{
				boolean booleanCellData =  xlsxcell.getBooleanCellValue();
				CellData = booleanCellData;
			}
            return CellData;
        }
        catch (Exception e)
        {
            return"";
        }
    }

    /** To get cell data from Excel-XLS */
    public static Object getCellData_XLS(int RowNum, int ColNum) throws Exception
    {
        Object CellData = null;
        try
        {
            xlscell = xlsworksheet.getRow(RowNum).getCell(ColNum);
            if(xlscell.getCellType() == CellType.STRING )
            {
                String stringCellData = xlscell.getStringCellValue();
                CellData = stringCellData;
            }
					else if(xlscell.getCellType() == CellType.NUMERIC)
			{
				double numericCellData =  xlscell.getNumericCellValue();
				CellData = numericCellData;
			}
			else if(xlscell.getCellType() == CellType.BOOLEAN)
			{
				boolean booleanCellData =  xlscell.getBooleanCellValue();
				CellData = booleanCellData;
			}
            return CellData;
        }
        catch (Exception e)
        {
            return"";
        }
    }
    /** To get Excel-XLSX Row Count */
    public static int xlsxRowCount()
    {
        int rowNum = xlsxworksheet.getLastRowNum()+1;
        return rowNum;
    }

    /** To get Excel-XLS Row Count */
    public static int xlsRowCount()
    {
        int rowNum = xlsworksheet.getLastRowNum()+1;
        return rowNum;
    }

    /** To get Excel-XLSX Column Count */
    public static int xlsxColumnCount()
    {
        int rowNum = xlsxworksheet.getRow(0).getLastCellNum();
        return rowNum;
    }

    /** To get Excel-XLS Column Count */
    public static int xlsColumnCount()
    {
        int rowNum = xlsworksheet.getRow(0).getLastCellNum();
        return rowNum;
    }
}
