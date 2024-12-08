package fine_ticket;

import data.SharedData;
import java.util.Scanner;

public class PhieuPhat {
    private String idPhieuPhat = "PP" + String.format("%03d", DanhSachPhieuPhat.maID);
    private String idPhieuMuon;
    private int tongTienPhat;

    public PhieuPhat() {
        idPhieuMuon = "none";
        tongTienPhat = 0;
    }

    public PhieuPhat(String idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
        tongTienPhat = SharedData.dSCTPP.tinhTongTien(idPhieuPhat);
    }

    public PhieuPhat(PhieuPhat A) {     
        this.idPhieuMuon = A.getIDPhieuMuon();
        this.tongTienPhat = A.getTongTienPhat();
    }

    public String getIDPhieuPhat() {
        return idPhieuPhat;
    }

    public String getIDPhieuMuon() {
        return idPhieuMuon;
    }

    public int getTongTienPhat() {
        return tongTienPhat;
    }

    public void setIDPhieuPhat(String id)
    { 
    	idPhieuPhat = id;
    }
    public void setIDPhieuMuon(String id) {
        idPhieuMuon = id;
    }

    public void setTienPhat(int tienPhat) {
        tongTienPhat = tienPhat;
    }

	@Override 
    public String toString() {
        return String.format("%-20s%-15s%20s", idPhieuPhat, idPhieuMuon, String.format("%,d dong",tongTienPhat));
    }
	
	Scanner scan = new Scanner(System.in);
	public void them() //Bằng bàn phím
	{
		System.out.print("ID Phieu Muon: ");
		int ID = scan.nextInt();
		
		while (!tonTaiPM(String.format("PM%03d", ID)))
		{ 
			System.out.print("Khong ton tai Phieu Muon da nhap trong Danh Sach Phieu Muon, nhap lai (Y/N)? ");
			char ind = scan.next().charAt(0);
			if (!(ind == 'Y' || ind == 'y'))
				return;
			else
			System.out.print("ID Phieu Muon: ");
			ID = scan.nextInt();
		}
		
		while (!laPMDuyNhat(String.format("PM%03d", ID)))
		{ 
			System.out.print("Trung lap ID Phieu Muon, nhap lai (Y/N)? ");
			char ind = scan.next().charAt(0);
			if (!(ind == 'Y' || ind == 'y'))
				return;
			else
			System.out.print("ID Phieu Muon: ");
			ID = scan.nextInt();
		}
		idPhieuMuon = String.format("PM%03d", ID);
		System.out.format("So luong chi tiet phieu phat cua phieu %s: ", idPhieuPhat);
    	int n = scan.nextInt();
    	tongTienPhat = SharedData.dSCTPP.themChiTietPhieuPhat(n);
	}
	
	private Boolean tonTaiPM(String ID)
	{
		//Neu danh sach phieu muon rong thi return false
		//Chua co package phieu muon
		// for (PhieuMuon i : SharedData.dSPM)
		// { 
		// 	if(i.getidPhieuMuon().equals(ID))
		// 	{ 
		// 		return true;
		// 	}
		// }
		return false;
	}
	
	private Boolean laPMDuyNhat(String idPM)
	{
		for (PhieuPhat i : SharedData.dSPP.dSPP)
		{
			if (idPM.equals(i.getIDPhieuMuon()))
				return false;
		}
		return true;
	}
}
