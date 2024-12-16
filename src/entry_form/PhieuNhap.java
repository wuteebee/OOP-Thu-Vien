package entry_form;

import java.time.LocalDate;
import java.util.Scanner;

public class PhieuNhap {
    
    private String idPhieuNhap;
    private int idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;
    private int soLuongSach;
    private int idSach;
    
    public PhieuNhap() {
        idPhieuNhap = "PN" + String.format("%03d", 1);
        idNhaCungCap = 0;
        tongTien = 0;
        ngayNhap = LocalDate.now();
        soLuongSach = 0;
        idSach = 0;
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(String idPhieuNhap) {
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
        System.out.print("ID Phieu Nhap: ");
        idPhieuNhap = new Scanner(System.in).nextLine();
        System.out.print("ID Nha Cung Cap: ");
        idNhaCungCap = new Scanner(System.in).nextInt();
        System.out.print("Tong Tien: ");
        tongTien = new Scanner(System.in).nextInt();
        System.out.print("Ngay Nhap (dd/mm/yyyy): ");
        ngayNhap = LocalDate.parse(new Scanner(System.in).nextLine());
        System.out.print("So Luong Sach: ");
        soLuongSach = new Scanner(System.in).nextInt();
        System.out.print("ID Sach: ");
        idSach = new Scanner(System.in).nextInt();
        
    }
    

    @Override
    public String toString() {
        return  idPhieuNhap  +"|"+ idNhaCungCap + "|" + tongTien + "|" + ngayNhap + " |" + soLuongSach + "|" + idSach + '|';
    }
}


