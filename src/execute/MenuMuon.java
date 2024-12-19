package execute;
import borrow_ticket.PhieuMuon;
import data.SharedData;

public class MenuMuon implements ThucHienMenu {
	@Override
    public int xuatMenu() {
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0. Thoat MenuMuon.");
            System.out.println("1. Danh sach phieu muon.");
            System.out.println("2. Them phieu muon.");
            System.out.println("3. Chinh sua phieu muon.");
            System.out.println("4. Xoa phieu muon");
            System.out.println("5. Tim phieu muon.");
            System.out.println("6. Danh sach chi tiet phieu muon.");
            System.out.println("7. Them chi tiet phieu muon.");
            System.out.println("8. Chinh sua chi tiet phieu muon.");
            System.out.println("9. Xoa chi tiet phieu muon");
            System.out.println("10. Tim chi tiet phieu muon.");
            System.out.println("11. Danh sach phieu muon va Danh sach chi tiet phieu muon.");
            System.out.print("Vui lòng chọn: ");
            luaChon = Menu.input.nextInt();
            Menu.input.nextLine();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 11;
            if (!dieuKien) {
                System.out.println("Lua chon khong hop le, vui long nhap lai!");
            }
        } while (!dieuKien);

        return luaChon;
    }

	@Override
    public void xuLyMenu(int luaChon) {
        switch (luaChon) {
            case 1: 
                SharedData.dSPM.xuatds();
                break;
            case 2:
                SharedData.dSPM.themPM();
                break;
            case 3:
                SharedData.dSPM.suaPhieuMuon();
                break;
            case 4:
                System.out.print("Nhap ID phieu muon can xoa: ");
                SharedData.dSPM.xoaPhieuMuon();
                break;
            case 5:
                System.out.print("Nhap ID phieu muon can tim: ");
                PhieuMuon search = SharedData.dSPM.timPM();
                if (search != null)
                    System.out.println(search);
                else System.out.println("Khong tim thay phieu muon vua nhap !");
                break;
            case 6:
                SharedData.dSCTPM.xuatdsCTPM();
                break;
            case 7:
                System.out.print("Nhap ID phieu muon: ");
                String id = Menu.input.nextLine();
                if (SharedData.dSPM.timkiemViTriPM(id) != -1) 
                    SharedData.dSCTPM.themCTPM(id);
                else System.out.println("Khong ton tai phieu muon: " + id);
                break;
            case 8:
                System.out.print("Nhap ID phieu muon can sua: ");
                String sua = Menu.input.nextLine();
                SharedData.dSCTPM.suaCTPM(sua);
                break;
            case 9:
                System.out.print("Nhap ID CTPM can xoa: ");
                String xoa = Menu.input.nextLine();
                SharedData.dSCTPM.xoaCTPM1(xoa);
                break;
            case 10:
                SharedData.dSCTPM.timCTPM();
                break;
            case 11:
                SharedData.dSPM.xuatds();
                SharedData.dSCTPM.xuatdsCTPM();
            default:
                break;
        }
    }
}
