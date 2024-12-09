package execute;
import java.util.Scanner;
import data.*;

public class MenuNhap {
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("0. Thoat MenuNhap");
            System.out.println("1. Tim kiem phieu nhap");
            System.out.println("2. Them phieu nhap");
            System.out.println("3. In danh sach phieu nhap");
            System.out.println("4. Xoa phieu nhap");
            System.out.println("5. Sua phieu nhap");
            System.out.print("Nhap lua chon cua ban: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

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
                case 0:
                    break;
                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
