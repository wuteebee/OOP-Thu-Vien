package execute;

public class MenuChinh implements ThucHienMenu{
	@Override
    public int xuatMenu() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuChinh.");
            System.out.println("1. Thu vien.");
            // System.out.println("1. Nhan vien.");
            System.out.println("2. Khach hang.");
            // System.out.println("3. Nha cung cap.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            // dieuKien = luaChon >= 0 && luaChon <= 3;
            dieuKien = luaChon >= 0 && luaChon <= 2;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);
        return luaChon;
    }

    // void xuLyMenuChinh(int luaChon) {
    //     int chon;
    //     switch(luaChon) {
    //         case 1:
    //             MenuNhanVien menuNhanVien = new MenuNhanVien();
    //             do {
    //                 chon = menuNhanVien.xuatMenuNhanVien();
    //                 menuNhanVien.xuLyMenuNhanVien(chon);
    //             } while(chon != 0);
    //             break;
    //         case 2:
    //             MenuKhachHang menuKhachHang = new MenuKhachHang();
    //             do {
    //                 chon = menuKhachHang.xuatMenuKhachHang();
    //                 menuKhachHang.xuLyMenuKhachHang(chon);
    //             } while(chon!= 0);
    //             break;
    //         case 3:
    //             MenuNhaCungCap menuNhaCungCap = new MenuNhaCungCap();
    //             do {
    //                 chon = menuNhaCungCap.xuatMenuNhaCungCap();
    //                 menuNhaCungCap.xuLyMenuNhaCungCap(chon);
    //             } while(chon!= 0);
    //             break;
    //         default:
    //             break;
    //     }
    // }
	
	@Override
    public void xuLyMenu(int luaChon) {
        int chon;
        switch(luaChon) {
            case 1:
                MenuThuVien menuThuVien = new MenuThuVien();
                do {
                    chon = menuThuVien.xuatMenu();
                    menuThuVien.xuLyMenu(chon);
                } while(chon != 0);
                break;
            case 2:
                MenuKhachHang menuKhachHang = new MenuKhachHang();
                do {
                    chon = menuKhachHang.xuatMenu();
                    menuKhachHang.xuLyMenu(chon);
                } while(chon!= 0);
                break;
            default:
                break;
        }
    }
}
