package execute;
import java.util.Scanner;
import data.*;

public class MenuNhap {
    public int xuly(String[] args) {
        int choice;
        Boolean dieuKien;
        do
        {
            System.out.println("0. Thoat MenuNhap");
            System.out.println("1. Tim kiem phieu nhap");
            System.out.println("2. Them phieu nhap");
            System.out.println("3. In danh sach phieu nhap");
            System.out.println("4. Xoa phieu nhap");
            System.out.println("5. Sua phieu nhap");
            System.out.print("Nhap lua chon cua ban: ");
            choice = Menu.input.nextInt();
            Menu.input.nextLine(); 
            Menu.clearScreen();
            dieuKien = choice >= 0 && choice <= 5;
            if (!dieuKien)
            { 
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (!dieuKien);
        return choice;
    }

      public void xuLyMenuQuanLyKhachHang(int choice) {
            switch (choice) {
                case 1:
                    danhSach.timPhieuNhap();
                    break;
                case 2:
                    danhSach.writeFile();
                    break;
                case 3:
                    danhSach.xuat();
                    break;
                case 4:
                    danhSach.xoaPhieuNhap();
                    break;
                case 5:
                    danhSach.suaPhieuNhap();
                    break;
                default:
                    break;
            }
    }
}
