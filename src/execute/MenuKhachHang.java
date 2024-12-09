package execute;

public class MenuKhachHang {

    int xuatMenuKhachHang() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuKhachHang.");
            System.out.println("1. Them khach hang.");
            System.out.println("2. Chinh sua khach hang.");
            System.out.println("3. Danh sach khach hang.");
            System.out.println("4. Menu xu ly vi pham.");
            System.out.println("5. Muon sach.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 5;
            if (!dieuKien) {
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (!dieuKien);
        return luaChon;
    }

    void xuLyMenuKhachHang(int luaChon) {
        int chon;
        switch (luaChon) {
            case 1:
                System.out.println("Xu ly them KhachHang.");
                break;
            case 2:
                System.out.println("Xu ly chinh sua KhachHang.");
                break;
            case 3:
                System.out.println("Xu ly danh sach KhachHang.");
                break;
            case 4:
                System.out.println("Xu ly vi pham.");
                MenuPhat menuPhat = new MenuPhat();
                do {
                    chon = menuPhat.xuatMenuPhat();
                    menuPhat.xuLyMenuPhat(chon);
                } while (chon != 0);
                break;
            case 5:
                // goi menu muon sach
                // new MenuMuon();
                break;
            default:
                break;
        }
    }
}
