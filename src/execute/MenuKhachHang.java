package execute;

public class MenuKhachHang implements ThucHienMenu {

	@Override
    public int xuatMenu() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuKhachHang.");
            System.out.println("1. Menu xu ly vi pham.");
            System.out.println("2. Muon sach.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 2;
            if (!dieuKien) {
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (!dieuKien);
        return luaChon;
    }

    @Override
    public void xuLyMenu(int luaChon) {
        int chon;
        switch (luaChon) {
            case 1:
                System.out.println("Xu ly vi pham.");
                MenuPhat menuPhat = new MenuPhat();
                do {
                    chon = menuPhat.xuatMenu();
                    menuPhat.xuLyMenu(chon);
                } while (chon != 0);
                break;
            case 2:
                System.out.println("Xu ly phieu muon.");
                MenuMuon menuMuon = new MenuMuon();
                do {
                    chon = menuMuon.xuatMenu();
                    menuMuon.xuLyMenu(chon);
                } while (chon != 0);
                break;
            default:
                break;
        }
    }
}
