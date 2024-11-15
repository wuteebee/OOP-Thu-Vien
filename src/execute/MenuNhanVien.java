package execute;

import book.*;
import test_data.*;

public class MenuNhanVien {
    static public DanhSachSach dSS = new DanhSachSach();
    static public DanhSachTacGia dSTG = Data.dataDSTG();
    static public DanhSachNhaXuatBan dSNXB = Data.dataDSXB();

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

    void xuLyMenuNhanVien(int luaChon) {
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
                System.out.println("Ban muon them bao nhieu sach ");
                int soLuongSach = Menu.input.nextInt();
                Menu.input.nextLine();
                do {
                    chon = xuatMenuThemSach();
                    System.out.println("soLuongSach: " + soLuongSach + "\nchon: " + chon);
                    xuLyMenuThemSach(chon);
                } while (chon != 0 && --soLuongSach != 0);
                System.out.println(MenuNhanVien.dSS);

                break;
            case 5:
                System.out.println("Xu ly Danh sach Sach.");
                break;
            case 6:
                break;
            case 7:

                break;
            case 8:
                break;
            case 9:
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
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 3;
            if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while (!dieuKien);
        return luaChon;
    }

    void xuLyMenuThemSach(int luaChon) {
        int chon;
        switch (luaChon) {
            case 1:
                dSS.themSach(new Sach().taoSach());
                break;
            case 2:
                dSS.themSach(new SachGiaoKhoa().taoSach());
                break;
            case 3:
                dSS.themSach(new SachThamKhao().taoSach());
                break;
            default:
                break;
        }
    }
}
