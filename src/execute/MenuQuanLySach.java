package execute;

import data.SharedData;

public class MenuQuanLySach implements ThucHienMenu {
	
	@Override
    public int xuatMenu() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuQuanLySach.");
            System.out.println("1. Them sach.");
            System.out.println("2. Chinh sua sach.");
            System.out.println("3. Khoa sach.");
            System.out.println("4. Mo khoa sach");
            System.out.println("5. Danh sach sach.");
            System.out.println("6. Tim sach theo trinh do va linh vuc.");
            System.out.println("7. Tim sach theo chuyen nganh va de tai");
            System.out.println("8. Thong ke so luong sach theo trinh do va linh vuc");
            System.out.println("9. Thong ke so luong sach theo chuyen nganh va de tai");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 9;
        } while (!dieuKien);
        return luaChon;
    }

	@Override
    public void xuLyMenu(int luaChon) {
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
            case 6:
                System.out.println(SharedData.dSS.timSachTheoTrinhDoVaLinhVuc());
                break;
            case 7:
                System.out.println(SharedData.dSS.timSachTheoChuyenNganhVaDeTai());
                break;
            case 8:
                SharedData.dSS.thongKeTrinhDoLinhVuc();
                break;
            case 9:
                SharedData.dSS.thongKeChuyenNganhDeTai();
                break;
            default:
                break;
        }
    }
}
