package execute;

import data.*;

// public class MenuNhanVien {
//     public int xuatMenuNhanVien() {
//         int luaChon;
//         boolean dieuKien;
//         do {
//             System.out.println("0. Thoat MenuNhanVien.");
//             System.out.println("1. Them NhanVien.");
//             System.out.println("2. Chinh sua NhanVien.");
//             System.out.println("3. Xoa NhanVien.");
//             System.out.println("4. Danh sach NhanVien.");
//             System.out.println("5. Them Sach.");
//             System.out.println("6. Chinh sua Sach.");
//             System.out.println("7. Xoa Sach.");
//             System.out.println("8. Danh sach Sach.");
//             System.out.println("9. Them TacGia.");
//             System.out.println("10. Chinh sua TacGia.");
//             System.out.println("11. Xoa TacGia.");
//             System.out.println("12. Danh sach TacGia.");
//             System.out.println("13. Them NhaXuatBan.");
//             System.out.println("14. Chinh sua NhaXuatBan.");
//             System.out.println("15. Xoa NhaXuatBan.");
//             System.out.println("16. Danh sach NhaXuatBan.");
//             luaChon = Menu.input.nextInt();
//             Menu.input.nextLine();
//             Menu.clearScreen();
//             dieuKien = luaChon >= 0 && luaChon <= 12;
//             if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
//         } while (!dieuKien);

//         return luaChon;
//     }

//     public void xuLyMenuNhanVien(int luaChon) {
//         int chon;
//         switch (luaChon) {
//             case 1:
//                 System.out.println("case 1");
//                 System.out.println("Ban muon them bao nhieu NhanVien:");
//                 int soLuongNhanVien = Menu.input.nextInt();
//                 Menu.input.nextLine();
//                 if (soLuongNhanVien != 0)
//                     do {
//                         chon = xuatMenuThemNhanVien();
//                         xuLyMenuThemNhanVien(chon);
//                     } while (chon != 0 && --soLuongNhanVien != 0);
//                 break;
//             case 2:
//                 System.out.println("case 2");
//                 System.out.println(SharedData.dSNV.chinhSuaNhanVien(SharedData.dSNV.timIDNhanVien()));
//                 break;
//             case 3:
//                 System.out.println("case 3");
//                 SharedData.dSNV.xoaNhanVien();
//                 break;
//             case 4:
//                 System.out.println("case 4");
//                 System.out.println(SharedData.dSNV);
//                 break;
//             case 5:
//                 System.out.println("case 5");
//                 System.out.println(SharedData.dSNV);
//                 int soLuongSach = Menu.input.nextInt();
//                 Menu.input.nextLine();
//                 if (soLuongSach != 0)
//                     do {
//                         chon = xuatMenuThemSach();
//                         xuLyMenuThemSach(chon);
//                     } while (chon != 0 && --soLuongSach != 0);
//                 break;
//             case 6:
//                 System.out.println("case 6");
//                 System.out.println("Chinh sua Sach");
//                 break;
//             case 7:
//                 System.out.println("case 7");
//                 System.out.println("Xu ly xoa Sach");
//                 break;
//             case 8:
//                 System.out.println("case 8");
//                 System.out.println(SharedData.dSS);
//                 break;
//             case 9:
//                 System.out.println("case 9");
//                 System.out.println("Ban muon them bao nhieu TacGia:");
//                 int soLuongTacGia = Menu.input.nextInt();
//                 Menu.input.nextLine();
//                 if (soLuongTacGia != 0)
//                     do {
//                         chon = xuatMenuThemTacGia();
//                         xuLyMenuThemTacGia(chon);
//                     } while (chon != 0 && --soLuongTacGia != 0);
//                 break;
//             case 10:
//                 System.out.println("case 10");
//                 System.out.println("Chinh sua TacGia");
//                 break;
//             case 11:
//                 System.out.println("case 11");
//                 System.out.println("Xoa TacGia");
//                 break;
//             case 12:
//                 System.out.println("case 12");
//                 System.out.println(SharedData.dSTG);
//                 break;
//             case 13:
//                 System.out.println("case 13");
//                 System.out.println("Ban muon them bao nhieu NhaXuatBan:");
//                 int soLuongNhaXuatBan = Menu.input.nextInt();
//                 Menu.input.nextLine();
//                 if (soLuongNhaXuatBan != 0)
//                     do {
//                         chon = xuatMenuThemNhaXuatBan();
//                         xuLyMenuThemNhaXuatBan(chon);
//                     } while (chon != 0 && --soLuongNhaXuatBan != 0);
//                 break;
//             case 14:
//                 System.out.println("case 14");
//                 System.out.println("Chinh sua NhaXuatBan");
//                 break;
//             case 15:
//                 System.out.println("case 15");
//                 System.out.println("Xoa NhaXuatBan");
//                 break;
//             case 16:
//                 System.out.println("case 16");
//                 System.out.println(SharedData.dSNXB);
//                 break;
//             default:
//                 break;
//         }
//     }

//     public int xuatMenuThemNhanVien() {
//         int luaChon;
//         boolean dieuKien;
//         do {
//             System.out.println("0. Thoat MenuThemNhanVien.");
//             System.out.println("1. Tiep tuc them NhanVien.");
//             luaChon = Menu.input.nextInt();
//             Menu.input.nextLine();
//             Menu.clearScreen();
//             dieuKien = luaChon >= 0 && luaChon <= 3;
//             if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
//         } while (!dieuKien);
//         return luaChon;
//     }

//     public void xuLyMenuThemNhanVien(int luaChon) {
//         switch (luaChon) {
//             case 1:
//                 SharedData.dSNV.themNhanVien(new NhanVien().taoNhanVien());
//                 break;
//             default:
//                 break;
//         }
//     }

//     public int xuatMenuThemSach() {
//         int luaChon;
//         boolean dieuKien;
//         do {
//             System.out.println("0. Thoat MenuThemSach.");
//             System.out.println("1. Them Sach.");
//             System.out.println("2. Them SachGiaoKhoa.");
//             System.out.println("3. Them SachThamKhao.");
//             luaChon = Menu.input.nextInt();
//             Menu.input.nextLine();
//             Menu.clearScreen();
//             dieuKien = luaChon >= 0 && luaChon <= 3;
//             if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
//         } while (!dieuKien);
//         return luaChon;
//     }

//     public void xuLyMenuThemSach(int luaChon) {
//         switch (luaChon) {
//             case 1:
//                 SharedData.dSS.themSach(new Sach().taoSach());
//                 break;
//             case 2:
//                 SharedData.dSS.themSach(new SachGiaoKhoa().taoSach());
//                 break;
//             case 3:
//                 SharedData.dSS.themSach(new SachThamKhao().taoSach());
//                 break;
//             default:
//                 break;
//         }
//     }

//     public int xuatMenuThemTacGia() {
//         int luaChon;
//         boolean dieuKien;
//         do {
//             System.out.println("0. Thoat MenuThemTacGia.");
//             System.out.println("1. Tiep tuc them TacGia.");
//             luaChon = Menu.input.nextInt();
//             Menu.input.nextLine();
//             Menu.clearScreen();
//             dieuKien = luaChon >= 0 && luaChon <= 1;
//             if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
//         } while (!dieuKien);
//         return luaChon;
//     }

//     public void xuLyMenuThemTacGia(int luaChon) {
//         switch (luaChon) {
//             case 1:
//                 SharedData.dSTG.themTacGia(new TacGia().taoTacGia());
//                 break;
//             default:
//                 break;
//         }
//     }

//     public int xuatMenuThemNhaXuatBan() {
//         int luaChon;
//         boolean dieuKien;
//         do {
//             System.out.println("0. Thoat MenuThemNhaXuatBan.");
//             System.out.println("1. Tiep tuc them NhaXuatBan.");
//             luaChon = Menu.input.nextInt();
//             Menu.input.nextLine();
//             Menu.clearScreen();
//             dieuKien = luaChon >= 0 && luaChon <= 1;
//             if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
//         } while (!dieuKien);
//         return luaChon;
//     }

//     public void xuLyMenuThemNhaXuatBan(int luaChon) {
//         switch (luaChon) {
//             case 1:
//                 SharedData.dSNXB.themNhaXuatBan(new NhaXuatBan().taoNhaXuatBan());
//                 break;
//             default:
//                 break;
//         }
//     }
// }

public class MenuQuanLyNhanVien {
    public int xuatMenuQuanLyNhanVien() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuNhanVien.");
            System.out.println("1. Them nhan vien.");
            System.out.println("2. Chinh sua nhan vien.");
            System.out.println("3. Khoa nhan vien.");
            System.out.println("4. Mo khoa nhan vien.");
            System.out.println("5. Danh sach nhan vien.");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 5;
            if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while (!dieuKien);

        return luaChon;
    }

    public void xuLyMenuQuanLyNhanVien(int luaChon) {
        int chon;
        switch (luaChon) {
            case 1:
                // System.out.println("case 1");
                // System.out.println("Ban muon them bao nhieu NhanVien:");
                // int soLuongNhanVien = Menu.input.nextInt();
                // Menu.input.nextLine();
                // if (soLuongNhanVien != 0)
                //     do {
                //         chon = xuatMenuThemNhanVien();
                //         xuLyMenuThemNhanVien(chon);
                //     } while (chon != 0 && --soLuongNhanVien != 0);
                break;
            case 2:
                System.out.println("case 2");
                System.out.println(SharedData.dSNV.chinhSuaNhanVien(SharedData.dSNV.timIDNhanVien()));
                break;
            case 3:
                System.out.println("case 3");
                SharedData.dSNV.khoaNhanVien();
                break;
            case 4:
                System.out.println("case 4");
                SharedData.dSNV.moKhoaNhanVien();
                break;
            case 5:
                System.out.println("case 5");
                System.out.println(SharedData.dSNV);
                break;
            default:
                break;
        }
    }

    // public int xuatMenuThemNhanVien() {
    //     int luaChon;
    //     boolean dieuKien;
    //     do {
    //         System.out.println("0. Thoat MenuThemNhanVien.");
    //         System.out.println("1. Tiep tuc them NhanVien.");
    //         luaChon = Menu.input.nextInt();
    //         Menu.input.nextLine();
    //         Menu.clearScreen();
    //         dieuKien = luaChon >= 0 && luaChon <= 3;
    //         if (!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
    //     } while (!dieuKien);
    //     return luaChon;
    // }

    // public void xuLyMenuThemNhanVien(int luaChon) {
    //     switch (luaChon) {
    //         case 1:
    //             SharedData.dSNV.themNhanVien(new NhanVien().taoNhanVien());
    //             break;
    //         default:
    //             break;
    //     }
    // }

}
