//package data;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import employee.NhanVien; // Đảm bảo import đúng lớp NhanVien
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ImportData {
//    static String[] column = {"ho", "ten", "gioiTinh", "ngaySinh", "soDienThoai"};
//    static List<NhanVien> employees = new ArrayList<>();
//
//    static {
//        employees.add(new NhanVien("John", "Doe", true, LocalDate.of(1990, 1, 1), "1234567890"));
//        employees.add(new NhanVien("Jane", "Smith", false, LocalDate.of(1991, 12, 31), "9876543210"));
//    }
//
//    public void writeExcel() throws IOException {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("employees");
//        Row headerRow = sheet.createRow(0);
//
//        // Ghi tiêu đề cột
//        for (int index = 0; index < column.length; index++) {
//            Cell cell = headerRow.createCell(index);
//            cell.setCellValue(column[index]);
//        }
//
//        // Ghi dữ liệu nhân viên
//        int rowNum = 1;
//        for (NhanVien employee : employees) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(employee.getHo());
//            row.createCell(1).setCellValue(employee.getTen());
//            row.createCell(2).setCellValue(employee.getGioiTinh() ? "Nam" : "Nu");
//            row.createCell(3).setCellValue(employee.getNgaySinh().toString()); // Chuyển đổi LocalDate thành String
//            row.createCell(4).setCellValue(employee.getSoDienThoai());
//        }
//
//        // Ghi vào file
//        try (FileOutputStream fileOut = new FileOutputStream("NhanVien.xlsx")) {
//            workbook.write(fileOut);
//        } catch (IOException e) {
//            e.printStackTrace(); // Xử lý ngoại lệ nếu có lỗi xảy ra
//        } finally {
//            workbook.close(); // Đảm bảo đóng workbook
//        }
//    }
//}