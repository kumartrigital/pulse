package com.gss.pulseworkflow.utility;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gss.pulseworkflow.model.Employee;
import com.gss.pulseworkflow.model.EmployeeValidation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExcelWriter {

	



    //public static void main(String[] args) throws IOException, InvalidFormatException {
    public void writeDataToExcel(List<EmployeeValidation> empValidationObj) throws IOException, InvalidFormatException{
    	try {
    	String[] columns = { "Validation Comments", "Total Validations failed", "EMPLOYEE ID", "FIRST NAME",
    			"MIDDLE NAME", "LAST NAME", "EMAIL ID", "ADDRESS 1", "ADDRESS 2", "ZIP CODE", "CITY", "STATE", "COUNTRY",
    			"ADDRESS TYPE", "CONTACT NUMBER 1", "CONTACT NUMBER 2", "HIRE DATE", "POSITION", "POSITION LEVEL",
    			"COST TO COMPANY","MANAGER ID", "MANAGER EMAIL"};

        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances for various things like DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("failed users");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
       
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Cell Style for formatting Date
		/*
		 * CellStyle dateCellStyle = workbook.createCellStyle();
		 * dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat(
		 * "dd-MM-yyyy"));
		 */

        // Create Other rows and cells with employees data
        
        int rowNum = 1;
        for(EmployeeValidation employeeValidation: empValidationObj) {
            Row row = sheet.createRow(rowNum++);

            Cell validCOmmentCell=row.createCell(0);
            validCOmmentCell.setCellValue(employeeValidation.getValidationComments());
            System.out.println("comments: "+employeeValidation.getValidationComments());
            CellStyle cs = workbook.createCellStyle();
            cs.setWrapText(true);
            validCOmmentCell.setCellStyle(cs);

            row.createCell(1)
                    .setCellValue(employeeValidation.getNumberOfValidationsFailed());
            row.createCell(2)
            .setCellValue(employeeValidation.getEmployeeDetails().getEmployeeId());
            row.createCell(3)
            .setCellValue(employeeValidation.getEmployeeDetails().getFirstName());
            row.createCell(4)
            .setCellValue(employeeValidation.getEmployeeDetails().getMiddleName());
            row.createCell(5)
            .setCellValue(employeeValidation.getEmployeeDetails().getLastName());
            row.createCell(6)
            .setCellValue(employeeValidation.getEmployeeDetails().getEmailId());
            row.createCell(7)
            .setCellValue(employeeValidation.getEmployeeDetails().getAddress1());
            row.createCell(8)
            .setCellValue(employeeValidation.getEmployeeDetails().getAddress2());
            row.createCell(9)
            .setCellValue(employeeValidation.getEmployeeDetails().getZipcode());
            row.createCell(10)
            .setCellValue(employeeValidation.getEmployeeDetails().getCity());
            row.createCell(11)
            .setCellValue(employeeValidation.getEmployeeDetails().getState());
            row.createCell(12)
            .setCellValue(employeeValidation.getEmployeeDetails().getCountry());
            row.createCell(13)
            .setCellValue(employeeValidation.getEmployeeDetails().getAddressType());
            row.createCell(14)
            .setCellValue(employeeValidation.getEmployeeDetails().getContactNumber1());
            row.createCell(15)
            .setCellValue(employeeValidation.getEmployeeDetails().getContactNumber2());
            row.createCell(16)
            .setCellValue(employeeValidation.getEmployeeDetails().getHireDate());
            row.createCell(17)
            .setCellValue(employeeValidation.getEmployeeDetails().getPosition());
            row.createCell(18)
            .setCellValue(employeeValidation.getEmployeeDetails().getPositionLevel());
            row.createCell(19)
            .setCellValue(employeeValidation.getEmployeeDetails().getCostTOCompany());
            row.createCell(20)
            .setCellValue(employeeValidation.getEmployeeDetails().getManagerId());
            row.createCell(21)
            .setCellValue(employeeValidation.getEmployeeDetails().getManagerEmail());
            

			/*
			 * Cell dateOfBirthCell = row.createCell(36);
			 * dateOfBirthCell.setCellValue(employee.getDateOfBirth());
			 * dateOfBirthCell.setCellStyle(dateCellStyle);
			 */

            
        }

        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("src/main/webapp/WEB-INF/download/Bulkupload_Error_Report.xlsx");
        System.out.println("before");
        workbook.write(fileOut);
        System.out.println("after");
        fileOut.close();

        workbook.close();
    	}catch(Exception e){
    		//System.err.println(e.printStackTrace());	
    	}
    }


    // Example to modify an existing excel file
    private static void modifyExistingWorkbook() throws InvalidFormatException, IOException {
        // Obtain a workbook from the excel file
        Workbook workbook = WorkbookFactory.create(new File("existing-spreadsheet.xlsx"));

        // Get Sheet at index 0
        Sheet sheet = workbook.getSheetAt(0);

        // Get Row at index 1
        Row row = sheet.getRow(1);

        // Get the Cell at index 2 from the above row
        Cell cell = row.getCell(2);

        // Create the cell if it doesn't exist
        if (cell == null)
            cell = row.createCell(2);

        // Update the cell's value
        cell.setCellType(CellType.STRING);
        cell.setCellValue("Updated Value");

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("existing-spreadsheet.xlsx");
        System.out.println("before");
        workbook.write(fileOut);
        System.out.println("after");
        fileOut.close();

        // Closing the workbook
        workbook.close();
    }
}

