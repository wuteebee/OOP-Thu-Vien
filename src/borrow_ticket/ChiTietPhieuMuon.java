package borrow_ticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChiTietPhieuMuon {
    private String idPhieuMuon = "PM" + String.format("%03d", DanhSachPhieuMuon.maID);
    private int soSach = 0; 
    private String[] idSach;
    private LocalDate ngayThucTra;

    

    public ChiTietPhieuMuon() {
        this.soSach = 0;            
        this.idSach = new String[soSach]; 
        this.ngayThucTra = LocalDate.now(); 
    }

    public ChiTietPhieuMuon(int soSach, String[] idSach, LocalDate ngayThucTra) {
        this.soSach = soSach;
        this.idSach = new String[soSach];
        this.ngayThucTra = ngayThucTra;
    }

    public int getSoSach() {
        return soSach;
    }

    public void setSoSach(int soSach) {
        this.soSach = soSach;
    }

    public String getIDCTPM() {
        return idPhieuMuon;
    }
    public String getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(String idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public String getIdSach() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < idSach.length; i++) {
            sb.append(idSach[i]);
            if (i < idSach.length - 1) {
                sb.append(", "); // them dau phẩy nếu ko phải ptu cuối
            }
        }
        return sb.toString();
    }
    

    public void setIdSach(String[] idSach) {
        this.idSach = new String[soSach];
        int count = 0;
    
        for (int i = 0; i < idSach.length && count < soSach; i++) {
                this.idSach[count++] = idSach[i];
        }
        this.soSach = count;
    }

    public LocalDate getNgayThucTra() {
        return ngayThucTra;
    }

    public void setNgayThucTra(LocalDate ngayThucTra) {
        this.ngayThucTra = ngayThucTra;
    }

    Scanner sc = new Scanner(System.in);

    public void nhapCTPM() {
        System.out.print("Nhap so luong sach: ");
        soSach = sc.nextInt();
        sc.nextLine();

        String[] ids = new String[soSach];
        for (int i = 0; i < soSach; i++) {
            System.out.print("Nhập ID sách thứ " + (i + 1) + ": ");
            ids[i] = sc.nextLine();
        }
        setIdSach(ids);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.print("Ngay thuc tra(dd-mm-yyyy): ");
        String ngay = sc.nextLine();
        ngayThucTra = LocalDate.parse(ngay, formatter);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("| %-20s| %-20s| %-20s|", idPhieuMuon, getIdSach(), ngayThucTra.format(formatter));
    }
}
