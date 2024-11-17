package data;

import jdk.internal.access.JavaNetUriAccess;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ImportData {
    public String readExcel(String sheetName, int cNum, int sNUm) {
        String data = "";
        try {
            FileInputStream fis = new FileInputStream("data\\NhanVien.xlsx");

            WorkbookFactory.create(fis);
        } catch (Exception e) {
            System.out.println("ReadExcel catch block");
            e.printStackTrace();
        }

        return data;
    }
}
