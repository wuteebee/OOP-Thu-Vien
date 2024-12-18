package entry_form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PhieuNhap {
    
    private int idPhieuNhap;
    private int idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;
    private int soLuongSach;
    private int idSach;
    
    public PhieuNhap() {
        idPhieuNhap = 0;
        idNhaCungCap = 0;
        tongTien = 0;
        ngayNhap = LocalDate.now();
        soLuongSach = 0;
        idSach = 0;
    }

    public int getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(int idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public int getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(int idNhaCungCap) {
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

    public int getSoLuongSach() {
        return soLuongSach;
    }

    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public void them(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Phieu Nhap: ");
        idPhieuNhap = scanner.nextInt();
        System.out.print("ID Nha Cung Cap: ");
        idNhaCungCap = scanner.nextInt();
        System.out.print("Tong Tien: ");
        tongTien = scanner.nextInt();
        System.out.print("Ngay Nhap (dd/MM/yyyy): ");
        scanner.nextLine(); // Consume newline
        String ngayNhapStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ngayNhap = LocalDate.parse(ngayNhapStr, formatter);
        System.out.print("So Luong Sach: ");
        soLuongSach = scanner.nextInt();
        System.out.print("ID Sach: ");
        idSach = scanner.nextInt();
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-15d %-15d %-15d %-15s %-15d %-15d", 
                             idPhieuNhap, idNhaCungCap, tongTien, ngayNhap.format(formatter), soLuongSach, idSach);
    }
}


