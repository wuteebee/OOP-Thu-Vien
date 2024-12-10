package execute;

import data.*;
import java.util.Scanner;

public class Menu {
    public static Scanner input = new Scanner(System.in);
    MenuChinh menuChinh = new MenuChinh();

    public void xuatMenu() {
        SharedData.importData();
        int vongLap;
        do {
            vongLap = menuChinh.xuatMenu();
            menuChinh.xuLyMenu(vongLap);
        } while (vongLap != 0);

        // thực thi hàm ghi ở đây
        // đặt tên Scanner ghi file là outputDSS

        input.close();
        SharedData.capNhatDuLieu();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

