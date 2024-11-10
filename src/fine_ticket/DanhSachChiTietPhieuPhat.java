package OOP;

public class DanhSachChiTietPhieuPhat {
	static int soLuong = 0;
	ChiTietPhieuPhat[] dSCTPP;
	
	DanhSachChiTietPhieuPhat()
	{ 
		dSCTPP = null;
	}
	
	DanhSachChiTietPhieuPhat(int soLuong, ChiTietPhieuPhat[] dSCTPP)
	{ 
		DanhSachChiTietPhieuPhat.soLuong += soLuong;
		this.dSCTPP = dSCTPP;
	}//chưa chắc
	
	DanhSachChiTietPhieuPhat(DanhSachChiTietPhieuPhat A)
	{ 
		dSCTPP = A.dSCTPP;
	}
	
	ChiTietPhieuPhat[] getDSCTPP()
	{ 
		return dSCTPP;
	}
}
