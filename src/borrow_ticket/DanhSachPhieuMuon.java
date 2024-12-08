package borrow_ticket;

import java.util.Scanner;
import java.util.Arrays;

public class DanhSachPhieuMuon {
    public PhieuMuon[] dsPM;
    private int soluong;

    Scanner sc = new Scanner(System.in);

    public DanhSachPhieuMuon() {
        dsPM = null;
        soluong = 0;
    }

    public DanhSachPhieuMuon(PhieuMuon dsPM[], int soluong) {
        this.dsPM = dsPM;
        this.soluong = soluong;
    }

    public void nhapds() {
        System.out.print("Nhap so luong so phieu muon: ");
        soluong = sc.nextInt();
        dsPM = new PhieuMuon[soluong];
        for (int i = 0; i < soluong; i++) {
            dsPM[i] = new PhieuMuon();
            dsPM[i].nhapPM();
        }
    }

    public void xuatds() {
        for (int i = 0; i < soluong; i++)
            dsPM[i].xuatPM();
    }
}
