import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    static void MenuChinh() {
        int vongLap;
        do {
            vongLap = MenuChinh.xuatMenuChinh();
            MenuChinh.xuLyMenuChinh(vongLap);
        } while (vongLap != 0);
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class MenuChinh {
    static int xuatMenuChinh() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuChinh.");
            System.out.println("1. Nhan vien.");
            System.out.println("2. Khach hang.");
            System.out.println("3. Nha cung cap.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 3;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);
        return luaChon;
    }

    static void xuLyMenuChinh(int luaChon) {
        int chon;
        switch(luaChon) {
            case 1:
                do {
                    chon = MenuNhanVien.xuatMenuNhanVien();
                    MenuNhanVien.xuLyMenuNhanVien(chon);
                } while(chon != 0);
                break;
            case 2:
                do {
                    chon = MenuKhachHang.xuatMenuKhachHang();
                    MenuKhachHang.xuLyMenuKhachHang(chon);
                } while(chon!= 0);
                break;
            case 3:
                break;
            default:
                break;
        }
    }
}

class MenuNhanVien {
    static int xuatMenuNhanVien() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuNhanVien.");
            System.out.println("1. Them NhanVien.");
            System.out.println("2. Chinh sua NhanVien.");
            System.out.println("3. Danh sach NhanVien.");
            System.out.println("4. Them Sach.");
            System.out.println("5. Danh sach Sach.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 5;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);

        return luaChon;
    }

    static void xuLyMenuNhanVien(int luaChon) {
        int chon;
        switch(luaChon) {
            case 1:
                System.out.println("Xu ly them NhanVien.");
                break;
            case 2:
                System.out.println("Xu ly chinh sua NhanVien.");
                break;
            case 3:
                System.out.println("Xu ly danh sach NhanVien.");
                break;
            case 4:
                System.out.println("Xu ly Them Sach.");
                break;
            case 5:
                System.out.println("Xu ly Danh sach Sach.");
                break;
            default:
                break;
        }
    }

}

class MenuKhachHang {
    static int xuatMenuKhachHang() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuKhachHang.");
            System.out.println("1. Them KhachHang.");
            System.out.println("2. Chinh sua KhachHang.");
            System.out.println("3. Danh sach KhachHang.");
            System.out.println("4. Muon/Tra/Phat.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 4;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);
        return luaChon;
    }

    static void xuLyMenuKhachHang(int luaChon) {
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

class NhaCungCap {
    static int xuatMenuNhaCungCap() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuNhaCungCap.");
            System.out.println("1. Them NhaCungCap.");
            System.out.println("2. Chinh sua NhaCungCap.");
            System.out.println("3. Danh sach NhaCungCap.");
            System.out.println("4. Cung cap Sach.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 4;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);
        return luaChon;
    }

    static void xuLyMenuNhaCungCap(int luaChon) {
        switch(luaChon) {
            case 1:
                System.out.println("Xu ly them NhaCungCap.");
                break;
            case 2:
                System.out.println("Xu ly chinh sua NhaCungCap.");
                break;
            case 3:
                System.out.println("Xu ly danh sach NhaCungCap.");
                break;
            case 4:
                System.out.println("Xu ly cung cap Sach.");
                break;
            default:
                break;
        }
    }
}