package execute;

public class MenuQuanLySach {

    public int xuatMenuQuanLySach() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuQuanLySach.");
            System.out.println("1. Them Sach.");
            System.out.println("2. Chinh sua Sach.");
            System.out.println("3. Khoa Sach.");
            System.out.println("4. Mo khoa sach");
            System.out.println("5. Tim kiem Sach.");
            System.out.print("Chon chuc nang: ");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 5;
        } while (!dieuKien);
        return luaChon;
    }

    public void xuLyMenuQuanLySach(int luaChon) {
        switch (luaChon) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
    }
}
