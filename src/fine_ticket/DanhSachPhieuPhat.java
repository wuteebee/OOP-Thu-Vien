package OOP;

public class DanhSachPhieuPhat {
	static int soLuong = 0;
	PhieuPhat[] dSPP;
	
	DanhSachPhieuPhat()
	{ 
		dSPP = null;
	}
	
	DanhSachPhieuPhat(int soLuong, PhieuPhat[] dSPP)
	{
		DanhSachPhieuPhat.soLuong += soLuong;
		this.dSPP = dSPP;
	} //chưa chắc
	
	DanhSachPhieuPhat(DanhSachPhieuPhat A)
	{ 
		dSPP = A.dSPP;
	}
	
	PhieuPhat[] getDSPP()
	{
		return dSPP;
	}
}
