import book.*;
import execute.*;
import employee.*;
import data.*;

import javax.swing.text.html.MinimalHTMLWriter;
import java.time.LocalDate;
import java.util.InputMismatchException;

public class Main {

    static int haha = 0;
    public static void main(String[] args) {
//        System.out.println("Nhap ID tac gia");
//        String idTacGia = "0";
//        int idDaNhap = 0;
//        try {
//            idTacGia = Menu.input.nextLine();
//            idDaNhap = Integer.parseInt(idTacGia);
//        } catch (NumberFormatException nfe) {
//            System.out.println(idTacGia);
//            return;
//        }
//        System.out.println(idDaNhap);
//        DanhSachTacGia a = new DanhSachTacGia();
//        a.themTacGia(new TacGia("Ngo Thuong Bao", LocalDate.of(2005, 7, 16), "Vinh Long"));
//        a.themTacGia(new TacGia("Tran Bao Nhi", LocalDate.of(2005, 12, 2), "Ho Chi Minh"));
//        a.themTacGia(new TacGia("Phan Le Phuc Nguyen", LocalDate.of(2005, 2, 18), "Long An"));
//        a.themTacGia(2);
//
//        System.out.println(a);
//        System.out.println(DanhSachTacGia.soLuong);
//
//        DanhSachNhaXuatBan b = new DanhSachNhaXuatBan();
//        b.themNhaXuatBan(new NhaXuatBan("Tre", "0123456789", "abcxyz"));
//        b.themNhaXuatBan(2);
//        System.out.println(b);
//
//        while(true) {
//            System.out.println(a.timIDTacGia());
//        }
//

        Menu menu = new Menu();
        menu.xuatMenu();
        System.out.println(SharedData.dSS);

    }


}
