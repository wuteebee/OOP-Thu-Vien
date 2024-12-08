package execute;

import data.SharedData;

public class MenuQuanLyNhaCungCap {

    int xuatMenuQuanLyNhaCungCap() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuNhaCungCap.");
            System.out.println("1. Them nha cung cap.");
            System.out.println("2. Chinh sua nha cung cap.");
            System.out.println("3. Khoa nha cung cap.");
            System.out.println("4. Mo khoa sua nha cung cap.");
            System.out.println("5. Danh sach nha cung cap.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 4;
            if (!dieuKien) {
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (!dieuKien);
        return luaChon;
    }

    void xuLyMenuQuanLyNhaCungCap(int luaChon) {
        switch (luaChon) {
            case 1:
                System.out.println("Ban muon them bao nhieu nha xuat ban:");
                int soLuongNhaXuatBan = Menu.input.nextInt();
                Menu.input.nextLine();
                while (soLuongNhaXuatBan-- > 0) {
                    SharedData.dSNXB.themNhaXuatBan(1);
                }
                break;
            case 2:
                System.out.println(SharedData.dSNXB.chinhSuaNhaXuatBan(SharedData.dSNXB.timIDNhaXuatBan()));
                break;
            case 3:
                SharedData.dSNXB.khoaNhaXuatBan();
                break;
            case 4:
                SharedData.dSNXB.khoaNhaXuatBan();
                break;
            case 5:
                System.out.println(SharedData.dSNXB);
                break;
            default:
                break;
        }
    }
}
