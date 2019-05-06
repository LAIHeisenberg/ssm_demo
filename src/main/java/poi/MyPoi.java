package poi;

import org.apache.poi.hssf.record.ExtendedFormatRecord;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import sun.jvm.hotspot.oops.CellTypeState;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class MyPoi {


    public static void main(String[] args) throws IOException {

        Workbook workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("sheet1");
        Font font = workbook.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);

        CellStyle style = workbook.createCellStyle();
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        style.setFont(font);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 左右居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 上下居中
        style.setLocked(true);

        Row row = sheet.createRow(0);

        String[] head = new String[]{"储区编码","储位编码","通道","隔","层"};

        for (int i=0; i<head.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(head[i]);
            cell.setCellStyle(style);
        }

//        Cell cell0 = row.createCell(0);
//        cell0.setCellValue("储区编码");
//        CellStyle cellStyle = cell0.getCellStyle();
//        cellStyle.setLocked(true);
//        Cell cell1 = row.createCell(1);
//        cell1.setCellValue("储位编码");
//        cellStyle = cell1.getCellStyle();
//        cellStyle.setLocked(true);
//        Cell cell3 = row.createCell(2);
//        cell3.setCellValue("通道");
//        cellStyle = cell3.getCellStyle();
//        cellStyle.setLocked(true);
//        Cell cell4 = row.createCell(3);
//        cell4.setCellValue("隔");
//        cellStyle = cell4.getCellStyle();
//        cellStyle.setLocked(true);
//        Cell cell5 = row.createCell(4);
//        cell5.setCellValue("层");
//        cellStyle = cell5.getCellStyle();
//        cellStyle.setLocked(true);

        FileOutputStream fos = new FileOutputStream("储位导入模板.xlsx");
        workbook.write(fos);
    }

}
