// file lớp trung tâm không được lưu thành 2 file
// không lưu các đối tượng của lớp trung tâm sang 2 file

package borrow_ticket;

import java.util.Scanner;

public class DanhSachChiTietPhieuMuon {
    private ChiTietPhieuMuon [] dSCTPM;
    private int soluong;

    Scanner sc = new Scanner(System.in);
    public DanhSachChiTietPhieuMuon() {
        dSCTPM = null;
        soluong =0;
    }
    public DanhSachChiTietPhieuMuon(ChiTietPhieuMuon dsCTPM[], int soluong) {
        this.dSCTPM = dsCTPM;
        this.soluong = soluong;
    }
    public void nhapdsCTPM() {
        System.out.print("Nhap so luong so phieu muon: ");
        soluong = sc.nextInt();
        ChiTietPhieuMuon[] dSCTPM = new ChiTietPhieuMuon[soluong];
        for(int i=0; i<soluong; i++) {
            dSCTPM[i] = new ChiTietPhieuMuon();
            dSCTPM[i].nhapCTPM();
        }
    }
    public void xuatdsCTPM() {
        for (int i=0; i<soluong; i++)
            dSCTPM[i].xuatCTPM();
    }

}
