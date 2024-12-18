package execute;
import data.*;

public class MenuNhap implements ThucHienMenu {
	@Override
    public int xuatMenu() {
        int choice;
        boolean dieuKien;
        do
        {
            System.out.println("0. Thoat MenuNhap");
            System.out.println("1. Tim kiem phieu nhap");
            System.out.println("2. Them phieu nhap");
            System.out.println("3. In danh sach phieu nhap");
            System.out.println("4. Xoa phieu nhap");
            System.out.println("5. Sua phieu nhap");
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

	@Override
      public void xuLyMenu(int choice) {
            switch (choice) {
                case 1:
                    SharedData.dSPN.timPhieuNhap();
                    break;
                case 2:
                   SharedData.dSPN.themPhieuNhap();
                    break;
                case 3:
                    SharedData.dSPN.xuat();
                    break;
                case 4:
                  SharedData.dSPN.xoaPhieuNhap();
                    break;
                case 5:
                    SharedData.dSPN.suaPhieuNhap();
                    break;
                default:
                    break;
            }
    }
}