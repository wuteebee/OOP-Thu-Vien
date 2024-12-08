package execute;

import data.SharedData;

public class MenuQuanLySach {

    public int xuatMenuQuanLySach() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuQuanLySach.");
            System.out.println("1. Them sach.");
            System.out.println("2. Chinh sua sach.");
            System.out.println("3. Khoa sach.");
            System.out.println("4. Mo khoa sach");
            System.out.println("5. Danh sach sach.");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 5;
        } while (!dieuKien);
        return luaChon;
    }

    public void xuLyMenuQuanLySach(int luaChon) {
        switch (luaChon) {
            case 1:
                System.out.println("Ban muon them bao nhieu sach:");
                int soLuongSach = Menu.input.nextInt();
                Menu.input.nextLine();
                while (soLuongSach-- > 0) {
                    SharedData.dSS.themSach(1);
                }
                break;
            case 2:
                System.out.println(SharedData.dSS.chinhSuaSach(SharedData.dSS.timIDSach()));
                break;
            case 3:
                SharedData.dSS.khoaSach();
                break;
            case 4:
                SharedData.dSS.moKhoaSach();
                break;
            case 5:
                System.out.println(SharedData.dSS);
                break;
            default:
                break;
        }
    }
}
