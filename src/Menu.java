import book.DanhSachSach;
import book.NhaXuatBan;
import book.TacGia;

import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);
    MenuChinh menuChinh = new MenuChinh();

    public void xuatMenu() {
        int vongLap;
        do {
            vongLap = menuChinh.xuatMenuChinh();
            menuChinh.xuLyMenuChinh(vongLap);
        } while (vongLap != 0);

        input.close();
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

class MenuChinh {
    int xuatMenuChinh() {
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

    void xuLyMenuChinh(int luaChon) {
        int chon;
        switch(luaChon) {
            case 1:
                MenuNhanVien menuNhanVien = new MenuNhanVien();
                do {
                    chon = menuNhanVien.xuatMenuNhanVien();
                    menuNhanVien.xuLyMenuNhanVien(chon);
                } while(chon != 0);
                break;
            case 2:
                MenuKhachHang menuKhachHang = new MenuKhachHang();
                do {
                    chon = menuKhachHang.xuatMenuKhachHang();
                    menuKhachHang.xuLyMenuKhachHang(chon);
                } while(chon!= 0);
                break;
            case 3:
                MenuNhaCungCap menuNhaCungCap = new MenuNhaCungCap();
                do {
                    chon = menuNhaCungCap.xuatMenuNhaCungCap();
                    menuNhaCungCap.xuLyMenuNhaCungCap(chon);
                } while(chon!= 0);
                break;
            default:
                break;
        }
    }
}

class MenuNhanVien {
    int xuatMenuNhanVien() {
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

    void xuLyMenuNhanVien(int luaChon) {
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
                do {
                    chon = xuatMenuThemSach();
                    xuLyMenuThemSach(chon);
                } while(chon != 0);
                break;
            case 5:
                System.out.println("Xu ly Danh sach Sach.");
                break;
            default:
                break;
        }
    }

    int xuatMenuThemSach() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuNhanVien.");
            System.out.println("1. Them Sach.");
            System.out.println("2. Them SachGiaoKhoa.");
            System.out.println("3. Them SachThamKhao.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 3;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);
        return luaChon;
    }

    void xuLyMenuThemSach(int luaChon) {
        int chon;
        String ten;
        int soLuong;
        int gia;
        TacGia tacGia;
        NhaXuatBan nhaXuatBan;
        switch(luaChon) {
            case 1:
                MenuNhanVien menuNhanVien = new MenuNhanVien();
                do {
                    chon = menuNhanVien.xuatMenuNhanVien();
                    menuNhanVien.xuLyMenuNhanVien(chon);
                } while(chon != 0);
                break;
            case 2:
                MenuKhachHang menuKhachHang = new MenuKhachHang();
                do {
                    chon = menuKhachHang.xuatMenuKhachHang();
                    menuKhachHang.xuLyMenuKhachHang(chon);
                } while(chon!= 0);
                break;
            case 3:
                MenuNhaCungCap menuNhaCungCap = new MenuNhaCungCap();
                do {
                    chon = menuNhaCungCap.xuatMenuNhaCungCap();
                    menuNhaCungCap.xuLyMenuNhaCungCap(chon);
                } while(chon!= 0);
                break;
            default:
                break;
        }
    }


}

class MenuKhachHang {
    int xuatMenuKhachHang() {
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

class MenuNhaCungCap {
    int xuatMenuNhaCungCap() {
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

    void xuLyMenuNhaCungCap(int luaChon) {
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