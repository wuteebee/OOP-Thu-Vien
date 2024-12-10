package execute;

import data.SharedData;

public class MenuQuanLyNhaCungCap implements ThucHienMenu {

	@Override
    public int xuatMenu() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuNhaXuatBan.");
            System.out.println("1. Them Xuat Ban.");
            System.out.println("2. Chinh sua Nha Xuat Ban.");
            System.out.println("3. Khoa Nha Xuat Ban.");
            System.out.println("4. Mo khoa Nha Xuat Ban.");
            System.out.println("5. Danh sach Nha Xuat Ban.");
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

	@Override
    public void xuLyMenu(int luaChon) {
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
