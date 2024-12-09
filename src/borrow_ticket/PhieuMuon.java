package borrow_ticket;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PhieuMuon {
    private String idPhieuMuon = "PM" + String.format("%03d", DanhSachPhieuMuon.maID);
    private String IDTheThuVien;
    private String  IDNhanVien;
    private LocalDate ngayMuon, ngayTra;

    public PhieuMuon() {
        IDTheThuVien = "none";
        IDNhanVien = "none";
        ngayMuon = LocalDate.now();
        ngayTra = LocalDate.now();
    }

    public PhieuMuon(String IDTheThuVien, String IDNhanVien, LocalDate ngayMuon, LocalDate ngayTra) {
        this.IDTheThuVien = IDTheThuVien;
        this.IDNhanVien = IDNhanVien;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public String getidPhieuMuon() {
        return idPhieuMuon;
    }
    public void setidPhieuMuon(String idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public String getIDTheThuVien() {
        return IDTheThuVien;
    }

    public void setIDTheThuVien(String IDTheThuVien) {
        this.IDTheThuVien = IDTheThuVien;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public LocalDate getngayMuon() {
        return ngayMuon;
    }

    public void setngayMuon(LocalDate ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public LocalDate getngayTra() {
        return ngayTra;
    }

    public void setngayTra(LocalDate ngayTra) {
        this.ngayTra = ngayTra;
    }

    Scanner sc = new Scanner(System.in);

    public void nhapPM() {
        System.out.print("ID The Thu Vien: ");
        IDTheThuVien = sc.nextLine();
        System.out.print("ID Nhan Vien: ");
        IDNhanVien = sc.nextLine();
        System.out.print("Ngay Muon (dd-mm-yyyy): ");
        String ngay = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        ngayMuon = LocalDate.parse(ngay, formatter);
        ngayTra = ngayMuon.plusDays(7);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("%-20s| %-20s| %-20s| %-20s| %-20s|", idPhieuMuon, IDTheThuVien, IDNhanVien,
                ngayMuon.format(formatter), ngayTra.format(formatter));
    }
}