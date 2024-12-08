package entry_form;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class PhieuNhap {
    private String idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;

    // Getters and Setters
    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(String idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ID nha cung cap: ");
        this.setIdNhaCungCap(scanner.nextLine());

        System.out.print("Nhap tong tien: ");
        this.setTongTien(scanner.nextInt());

        System.out.print("Nhap ngay nhap (yyyy-mm-dd): ");
        this.setNgayNhap(LocalDate.parse(scanner.next()));

        scanner.close();

        luuThongTin();
    }

    private void luuThongTin() {
        try (FileWriter writer = new FileWriter("phieu_nhap.txt", true)) {
            writer.write("ID nha cung cap: " + getIdNhaCungCap() + "\n");
            writer.write("Tong tien: " + getTongTien() + "\n");
            writer.write("Ngay nhap: " + getNgayNhap() + "\n");
            writer.write("------------------------------\n");
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi luu thong tin: " + e.getMessage());
        }
    }

}