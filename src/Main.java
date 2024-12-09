import borrow_ticket.DanhSachPhieuMuon;
import borrow_ticket.PhieuMuon;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Menu menu = new Menu();
        // menu.xuatMenu();
        Scanner sc = new Scanner(System.in);

        
        DanhSachPhieuMuon dspm = new DanhSachPhieuMuon();
        dspm.readFile();
        System.out.print("Nhap ID phieu muon: ");
        String idpm = sc.nextLine();
        PhieuMuon index1 = dspm.timKiemPhieuMuon(idpm);
        System.out.println(index1);
        // System.out.println(DanhSachPhieuMuon.soLuong);
    }
}
