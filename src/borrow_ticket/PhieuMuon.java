package borrow_ticket;

import employee.*;
import client.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PhieuMuon {
    private String idPhieuMuon;
    private String idNhanVien;
    private String  idTheThuVien;
    private LocalDate ngayMuon, ngayTra;

    public PhieuMuon() {
        idPhieuMuon = "none";
        idNhanVien = "none";
        idTheThuVien = "none";
        ngayMuon = LocalDate.now();
        ngayTra = LocalDate.now();
    }

    public PhieuMuon(String idPhieuMuon, String idNhanVien, String idTheThuVien, LocalDate ngayMuon, LocalDate ngayTra) {
        this.idPhieuMuon = idPhieuMuon;
        this.idNhanVien = idNhanVien;
        this.idTheThuVien = idTheThuVien;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
    }

    public String getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(String idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public NhanVien getidNhanVien() {
        return idNhanVien;
    }

    public void setidNhanVien(NhanVien idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public TheThuVien getidTheThuVien() {
        return idTheThuVien;
    }

    public void setidTheThuVien(TheThuVien idTheThuVien) {
        this.idTheThuVien = idTheThuVien;
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
        System.out.print("ID phieu muon: ");
        idPhieuMuon = sc.nextLine();
        System.out.print("ID nhan vien: ");
        idNhanVien = sc.nextLine();
        System.out.print("ID the thu vien: ");
        idTheThuVien = sc.nextLine();
        System.out.print("Ngay muon(dd-mm-yyyy): ");
        String ngay = sc.nextLine();
        ngayMuon = LocalDate.parse(ngay);
        System.out.print("Ngay tra(dd-mm-yyyy): ");
        ngay = sc.nextLine();
        ngayTra = LocalDate.parse(ngay);
    }

    public String xuatPM() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("-10%s| -10%s| -10%s| -10%s| -10%s|", idPhieuMuon, idNhanVien, idTheThuVien,
                ngayMuon.format(formatter), ngayTra.format(formatter));
    }
}