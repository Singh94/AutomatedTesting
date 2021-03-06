package QAConsulting.Autotrader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpreadSheetReader {

    private Workbook workbook;

    public SpreadSheetReader(String fileName){
        FileInputStream excelFile = null;
        try {
            excelFile = new FileInputStream(new File(fileName));
            workbook = new XSSFWorkbook(excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (excelFile != null) {
                    excelFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> readRow(int rowNo, String sheetName){
        List<String> row = new ArrayList<String>();
        Sheet datatypeSheet = workbook.getSheet(sheetName);
        Row currentRow =  datatypeSheet.getRow(rowNo);
        for (Cell currentCell : currentRow) {
            switch (currentCell.getCellTypeEnum()) {
                case STRING:
                    row.add(currentCell.getStringCellValue());
                    break;
                case NUMERIC:
                    row.add(String.valueOf(currentCell.getNumericCellValue()));
                    break;
                case BOOLEAN:
                    row.add(String.valueOf(currentCell.getBooleanCellValue()));
                    break;
                case BLANK:
                    row.add(currentCell.getStringCellValue());
                    break;
                case _NONE:
                    System.out.println("No Value in cell");
                    break;
                case ERROR:
                    System.out.println("Error in cell");
                    break;
                case FORMULA:
                    row.add(currentCell.getCellFormula());
                    break;
            }
        }
        return row;
    }

    public void dd(){
        Sheet sheet = workbook.getSheet("");
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        cell.setCellValue("");
    }
    
    public String input(int row, int column) {
    	String newInput = readRow(row, "Sheet1").get(column);
    	return newInput;
    }

}