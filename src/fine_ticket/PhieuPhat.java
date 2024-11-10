package OOP;

public class PhieuPhat {
	String stt = String.format("%03d", DanhSachPhieuPhat.soLuong);
	String iDPhieuPhat = "PP" + stt;
	String iDPhieuMuon;
	int tongTienPhat;
	
	PhieuPhat()
	{ 
		iDPhieuMuon = "None";
		tongTienPhat = 0;
	}
	
	PhieuPhat(String iDPhieuMuon, int tongTienPhat)
	{
		this.iDPhieuMuon = iDPhieuMuon;
		this.tongTienPhat = tongTienPhat;
		DanhSachPhieuPhat.soLuong++;
	}
	
	PhieuPhat(PhieuPhat A)
	{ 
		iDPhieuMuon = A.iDPhieuMuon;
		tongTienPhat = A.tongTienPhat;
	}

	String getIDPhieuPhat()
	{ 
		return iDPhieuPhat;
	}
	
	String getIDPhieuMuon()
	{
		return iDPhieuMuon;	
	}
	
	int getTongTienPhat()
	{
		return tongTienPhat;
	}
	
	void setIDPhieuMuon(String ID)
	{
		iDPhieuMuon = ID;
	}
	
	void setTienPhat(int tienPhat)
	{ 
		tongTienPhat = tienPhat;
	}
	
	public String toString()
	{ 
		return String.format("%-15s%-15s%,d dong\n",iDPhieuPhat, iDPhieuMuon, tongTienPhat);
	}
}
