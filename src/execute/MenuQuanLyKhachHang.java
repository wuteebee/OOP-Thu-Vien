package execute;

import data.*;

public class MenuQuanLyKhachHang {

    public int xuatMenuQuanLyKhachHang() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuQuanLyKhachHang.");
            System.out.println("1. Them khach hang.");
            System.out.println("2. Chinh sua khach hang.");
            System.out.println("3. Khoa khach hang.");
            System.out.println("4. Mo khoa khach hang.");
            System.out.println("5. Danh sach khach hang.");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 5;
            if (!dieuKien) {
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (!dieuKien);

        return luaChon;
    }

    public void xuLyMenuQuanLyKhachHang(int luaChon) {
        switch (luaChon) {
            case 1:
                System.out.println("Ban muon them bao nhieu khach hang:");
                int soLuongKhachHang = Menu.input.nextInt();
                Menu.input.nextLine();
                while(soLuongKhachHang-- > 0) {
                    SharedData.dSTTV.themTheThuVien(1);
                }
                break;
            case 2:
                System.out.println(SharedData.dSTTV.chinhSuaTheThuVien(SharedData.dSTTV.timIDTheThuVien()));
                break;
            case 3:
                SharedData.dSTTV.khoaTheThuVien();
                break;
            case 4:
                SharedData.dSTTV.moKhoaTheThuVien();
                break;
            case 5:
                System.out.println(SharedData.dSTTV);
                break;
            default:
                break;
        }
    }

}
