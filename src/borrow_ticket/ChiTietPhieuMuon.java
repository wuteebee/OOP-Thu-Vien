package borrow_ticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ChiTietPhieuMuon {
    private String idPhieuMuon, idSach;
    private LocalDate ngayThucTra;

    public ChiTietPhieuMuon() {
        idPhieuMuon = "none";
        idSach = "none";
        ngayThucTra = LocalDate.now();
    }

    public ChiTietPhieuMuon(String idPhieuMuon, String idSach, LocalDate ngayThucTra) {
        this.idPhieuMuon = idPhieuMuon;
        this.idSach = idSach;
        this.ngayThucTra = ngayThucTra;
    }

    Scanner sc = new Scanner(System.in);

    public void nhapCTPM() {
        System.out.print("ID phieu muon: ");
        idPhieuMuon = sc.nextLine();
        System.out.print("ID sach: ");
        idSach = sc.nextLine();
        System.out.print("Ngay thuc tra(dd-mm-yyyy): ");
        String ngay = sc.nextLine();
        ngayThucTra = LocalDate.parse(ngay);
    }

    public String xuatCTPM() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return String.format("-10%s| -10%s| -10%s|", idPhieuMuon, idSach,
                ngayThucTra.format(formatter));
    }
}
