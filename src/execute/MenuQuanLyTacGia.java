package execute;

import data.SharedData;

public class MenuQuanLyTacGia implements ThucHienMenu {
	@Override
    public int xuatMenu() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuTacGia.");
            System.out.println("1. Them tac gia.");
            System.out.println("2. Chinh sua tac gia.");
            System.out.println("3. Khoa tac gia.");
            System.out.println("4. Mo khoa tac gia.");
            System.out.println("5. Danh sach tac gia.");
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
                System.out.println("Ban muon them bao nhieu tac gia:");
                int soLuongTacGia = Menu.input.nextInt();
                Menu.input.nextLine();
                while (soLuongTacGia-- > 0) {
                    SharedData.dSTG.themTacGia(1);
                }
                break;
            case 2:
                System.out.println(SharedData.dSTG.chinhSuaTacGia(SharedData.dSTG.timIDTacGia()));
                break;
            case 3:
                SharedData.dSTG.khoaTacGia();
                break;
            case 4:
                SharedData.dSTG.moKhoaTacGia();
                break;
            case 5:
                System.out.println(SharedData.dSTG);
                break;
            default:
                break;
        }
    }
}
