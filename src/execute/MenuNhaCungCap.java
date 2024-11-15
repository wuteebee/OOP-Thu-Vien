package execute;

public class MenuNhaCungCap {
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
