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
            System.out.println("4. Muon/Tra/Phat.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 4;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);
        return luaChon;
    }

    void xuLyMenuKhachHang(int luaChon) {
        switch(luaChon) {
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
                System.out.println("Xu ly Muon/Tra/Phat.");
                break;
            default:
                break;
        }
    }
}
