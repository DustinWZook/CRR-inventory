package com.crr.inventory.services;

import com.crr.inventory.bean.Product;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

import static org.apache.poi.ss.util.CellUtil.createCell;

public class ProductExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Product> listProducts;

    public ProductExcelExporter(List<Product> listProducts) {
        this.listProducts = listProducts;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
//        CellStyle style2 = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Product ID", style);
        createCell(row, 1, "Name", style);
        createCell(row, 2, "Brand", style);
        createCell(row, 3, "Description", style);
        createCell(row, 4, "Category", style);
        createCell(row, 5, "Location", style);
        createCell(row, 6, "Quantity", style);
        createCell(row, 7, "Wholesale Price", style);
        createCell(row, 8, "Wholesale Total", style);
        createCell(row, 9, "Store Price", style);
        createCell(row, 10, "Store Price Total", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Product user : listProducts) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, user.getId(), style);
            createCell(row, columnCount++, user.getProductName(), style);
            createCell(row, columnCount++, user.getBrandName(), style);
            createCell(row, columnCount++, user.getDescription(), style);
            createCell(row, columnCount++, user.getProductCategory(), style);
            createCell(row, columnCount++, user.getProductLocation(), style);
            createCell(row, columnCount++, user.getQuantity(), style);
            createCell(row, columnCount++, user.getWholesalePrice(), style);
            createCell(row, columnCount++, user.getTotalWholesalePrice(), style);
            createCell(row, columnCount++, user.getStorePrice(), style);
            createCell(row, columnCount++, user.getTotalStorePrice(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }

}
