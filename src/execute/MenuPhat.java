package execute;

import data.SharedData;

public class MenuPhat {
	public int xuatMenuPhat()
	{
        int luaChon;
        boolean dieuKien;
        do {
            System.out.println("0.  Thoat MenuPhat.");
            System.out.println("1.  Danh sach Phieu Phat.");
            System.out.println("2.  Them Phieu Phat.");
            System.out.println("3.  Chinh sua Phieu Phat.");
            System.out.println("4.  Xoa Phieu Phat.");
            System.out.println("5.  Tim Phieu Phat.");
            System.out.println("6.  Danh sach Chi Tiet Phieu Phat.");
            System.out.println("7.  Them Chi Tiet Phieu Phat.");
            System.out.println("8.  Chinh Sua Chi Tiet Phieu Phat.");
            System.out.println("9.  Xoa Chi Tiet Phieu Phat.");
            System.out.println("10. Tim Chi Tiet Phieu Phat.");
            System.out.println("11. Quy dinh dieu khoan vi pham.");
            luaChon = Menu.input.nextInt();
            Menu.clearScreen();
            dieuKien = luaChon >= 0 && luaChon <= 11;
            if(!dieuKien) System.out.println("Lua chon khong hop le, vui long nhap lai!");
        } while(!dieuKien);
        return luaChon;
	}
	
	public void xuLyMenuPhat(int luaChon)
	{
		switch (luaChon)
		{ 
		case 1:
			SharedData.dSPP.xuat();
			break;
		case 2:
			SharedData.dSPP.themPhieuPhat();
			break;
		case 3:
			SharedData.dSPP.suaPhieuPhat();
			break;
		case 4:
			SharedData.dSPP.xoaPhieuPhat();
			break;
		case 5:
			SharedData.dSPP.timPhieuPhat();
			break;
		case 6:
			SharedData.dSCTPP.xuat();
			break;
		case 7:
			SharedData.dSCTPP.boSungChiTietPhieuPhat();
			break;
		case 8:
			SharedData.dSCTPP.suaChiTietPhieuPhat();
			break;
		case 9:
			SharedData.dSCTPP.xoaChiTietPhieuPhat();
			break;
		case 10:
			SharedData.dSCTPP.timChiTietPhieuPhat();
			break;	
		case 11:
			SharedData.dSDK.xuat();
		default:
			break;
		}
	}
}
