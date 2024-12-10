package execute;

public class MenuThuVien implements ThucHienMenu {

	@Override
    public int xuatMenu() {
        int luaChon;
        Boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuThuVien.");
            System.out.println("1. Quan ly nhan vien.");
            System.out.println("2. Quan ly khach hang.");
            System.out.println("3. Quan ly sach.");
            System.out.println("4. Quan ly nha xuat ban.");
            System.out.println("5. Quan ly tac gia");
            System.out.println("6. Nhap sach.");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 6;
            if (!dieuKien) {
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (!dieuKien);
        return luaChon;
    }

	@Override
    public void xuLyMenu(int luaChon) {
        int chon = 0;
        switch (luaChon) {
            case 1:
                MenuQuanLyNhanVien menuQuanLyNhanVien = new MenuQuanLyNhanVien();
                do {
                    chon = menuQuanLyNhanVien.xuatMenu();
                    menuQuanLyNhanVien.xuLyMenu(chon);
                } while (chon != 0);
                break;
            case 2:
                MenuQuanLyKhachHang menuQuanLyKhachHang = new MenuQuanLyKhachHang();
                do {
                    chon = menuQuanLyKhachHang.xuatMenu();
                    menuQuanLyKhachHang.xuLyMenu(chon);
                } while (chon != 0);
                break;
            case 3:
                MenuQuanLySach menuQuanLySach = new MenuQuanLySach();
                do {
                    chon = menuQuanLySach.xuatMenu();
                    menuQuanLySach.xuLyMenu(chon);
                } while (chon != 0);
                break;
            case 4:
                MenuQuanLyNhaCungCap menuQuanLyNhaCungCap = new MenuQuanLyNhaCungCap();
                do {
                    chon = menuQuanLyNhaCungCap.xuatMenu();
                    menuQuanLyNhaCungCap.xuLyMenu(chon);
                } while (chon != 0);
            case 5:
                MenuQuanLyTacGia menuQuanLyTacGia = new MenuQuanLyTacGia();
                do {
                    chon = menuQuanLyTacGia.xuatMenu();
                    menuQuanLyTacGia.xuLyMenu(chon);
                } while (chon != 0);
                break;
            case 6:
            MenuNhap menuNhap = new MenuNhap();
            do {
                chon = menuNhap.xuatMenu();
                menuNhap.xuLyMenu(chon);
            } while (chon != 0);
                break;
            default:
                break;

        }
    }
}
