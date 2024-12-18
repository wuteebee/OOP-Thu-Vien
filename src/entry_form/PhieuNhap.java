package entry_form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PhieuNhap {

    private int idPhieuNhap;
    private String tenNCC;
    private int giaBan;
    // private int tongTien;
    private LocalDate ngayNhap;
    private int soLuongSach;
    private String IdSach;
    private String tenSach;

    public PhieuNhap() {
        idPhieuNhap = 0;
        tenNCC = null;
        giaBan = 0;
        // tongTien = giaBan * soLuongSach;
        ngayNhap = LocalDate.now();
        soLuongSach = 0;
        tenSach = null;
    }

    public PhieuNhap(int idPhieuNhap, String tenNCC, String IdSach, int giaBan, int tongTien, LocalDate ngayNhap, int soLuongSach, String tenSach) {
        this.idPhieuNhap = idPhieuNhap;
        this.tenNCC = tenNCC;
        this.giaBan = giaBan;
        // this.tongTien = tongTien;
        this.ngayNhap = ngayNhap;
        this.soLuongSach = soLuongSach;
        this.tenSach = tenSach;
        this.IdSach = IdSach;
    }

    public String getIdSach() {
        return IdSach;
    }

    public void setIdSach(String IdSach) {
        this.IdSach = IdSach;
    }

    public int getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(int idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    // public int getTongTien() {
    //     return tongTien;
    // }
    // public void setTongTien(int tongTien) {
    //     this.tongTien = tongTien;
    // }
    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuongSach() {
        return soLuongSach;
    }

    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    // public void them(){
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.print("ID Phieu Nhap: ");
    //     idPhieuNhap = scanner.nextInt();
    //     scanner.nextLine(); // Consume newline
    //     System.out.print("Ten Sach: ");
    //     tenSach = scanner.nextLine();
    //     System.out.print("So Luong Sach: ");
    //     soLuongSach = scanner.nextInt();
    //     System.out.print("Ten Nha Cung Cap: ");
    //     scanner.nextLine(); // Consume newline
    //     tenNCC = scanner.nextLine();
    //     System.out.print("Gia Ban: ");
    //     giaBan = scanner.nextInt();
    //     scanner.nextLine(); // Consume newline
    //     // tongTien = giaBan * soLuongSach;
    //     System.out.print("Ngay Nhap(dd/MM/yyyy): ");
    //     // scanner.nextLine(); // Consume newline
    //     String ngayNhapStr = scanner.nextLine();
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //     ngayNhap = LocalDate.parse(ngayNhapStr, formatter);
    // }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-15d %-17s %-17s %-17d %-17s %-15d %-10s", idPhieuNhap, tenSach, IdSach , soLuongSach, tenNCC, giaBan, ngayNhap.format(formatter));
    }

}
