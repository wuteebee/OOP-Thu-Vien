package execute;

import book.NhaXuatBan;
import book.TacGia;

import java.util.Scanner;

public class Menu {
    public static Scanner input = new Scanner(System.in);
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

