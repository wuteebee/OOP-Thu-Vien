package execute;

import book.*;
import data.*;

public class MenuNhanVien {
    public int xuatMenuNhanVien() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuNhanVien.");
            System.out.println("1. Them NhanVien.");
            System.out.println("2. Chinh sua NhanVien.");
            System.out.println("3. Danh sach NhanVien.");
            System.out.println("4. Them Sach.");
            System.out.println("5. Danh sach Sach.");
            System.out.println("6. Them TacGia.");
            System.out.println("7. Danh sach TacGia.");
            System.out.println("8. Them NhaXuatBan.");
            System.out.println("9. Danh sach NhaXuatBan.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 9;
            if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while (!dieuKien);

        return luaChon;
    }

    public void xuLyMenuNhanVien(int luaChon) {
        int chon;
        switch (luaChon) {
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
                System.out.println("Ban muon them bao nhieu Sach:");
                int soLuongSach = Menu.input.nextInt();
                Menu.input.nextLine();
                if (soLuongSach != 0)
                    do {
                        chon = xuatMenuThemSach();
                        xuLyMenuThemSach(chon);
                    } while (chon != 0 && --soLuongSach != 0);
                break;
            case 5:
                System.out.println(SharedData.dSS);
                break;
            case 6:
                System.out.println("Ban muon them bao nhieu TacGia:");
                int soLuongTacGia = Menu.input.nextInt();
                Menu.input.nextLine();
                if (soLuongTacGia != 0)
                    do {
                        chon = xuatMenuThemTacGia();
                        xuLyMenuThemTacGia(chon);
                    } while (chon != 0 && --soLuongTacGia != 0);
                break;
            case 7:
                System.out.println(SharedData.dSTG);
                break;
            case 8:
                System.out.println("Ban muon them bao nhieu NhaXuatBan:");
                int soLuongNhaXuatBan = Menu.input.nextInt();
                Menu.input.nextLine();
                if (soLuongNhaXuatBan != 0)
                    do {
                        chon = xuatMenuThemNhaXuatBan();
                        xuLyMenuThemNhaXuatBan(chon);
                    } while (chon != 0 && --soLuongNhaXuatBan != 0);
                break;
            case 9:
                System.out.println(SharedData.dSNXB);
                break;
            default:
                break;
        }
    }

    public int xuatMenuThemSach() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuThemSach.");
            System.out.println("1. Them Sach.");
            System.out.println("2. Them SachGiaoKhoa.");
            System.out.println("3. Them SachThamKhao.");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 3;
            if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while (!dieuKien);
        return luaChon;
    }

    public void xuLyMenuThemSach(int luaChon) {
        switch (luaChon) {
            case 1:
                SharedData.dSS.themSach(new Sach().taoSach());
                break;
            case 2:
                SharedData.dSS.themSach(new SachGiaoKhoa().taoSach());
                break;
            case 3:
                SharedData.dSS.themSach(new SachThamKhao().taoSach());
                break;
            default:
                break;
        }
    }

    public int xuatMenuThemTacGia() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuThemTacGia.");
            System.out.println("1. Tiep tuc them TacGia.");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 1;
            if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while (!dieuKien);
        return luaChon;
    }

    public void xuLyMenuThemTacGia(int luaChon) {
        switch (luaChon) {
            case 1:
                SharedData.dSTG.themTacGia(new TacGia().taoTacGia());
                break;
            default:
                break;
        }
    }

    public int xuatMenuThemNhaXuatBan() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuThemNhaXuatBan.");
            System.out.println("1. Tiep tuc them NhaXuatBan.");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 1;
            if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while (!dieuKien);
        return luaChon;
    }

    public void xuLyMenuThemNhaXuatBan(int luaChon) {
        switch (luaChon) {
            case 1:
                SharedData.dSNXB.themNhaXuatBan(new NhaXuatBan().taoNhaXuatBan());
                break;
            default:
                break;
        }
    }
}
