package OOP;

public class ChiTietPhieuPhat {
	String iDPhieuPhat;
	String iDSach;
	int tinhTrangSach;
	int tienPhat;
	int iDDieuKhoan;
	
	ChiTietPhieuPhat()
	{ 
		iDPhieuPhat = "None";
		iDSach = "None";
		tinhTrangSach = 0;
		tienPhat = 0;
		iDDieuKhoan = 0;
	}
	
	ChiTietPhieuPhat(String iDPhieuPhat, String iDSach, int tinhTrangSach, int tienPhat, int iDDieuKhoan)
	{
		this.iDPhieuPhat = iDPhieuPhat;
		this.iDSach = iDSach;
		this.tinhTrangSach = tinhTrangSach;
		this.tienPhat = tienPhat;
		this.iDDieuKhoan = iDDieuKhoan;
		DanhSachChiTietPhieuPhat.soLuong++;
	}
	
	ChiTietPhieuPhat(ChiTietPhieuPhat A)
	{ 
		iDPhieuPhat = A.iDPhieuPhat;
		iDSach = A.iDSach;
		tinhTrangSach = A.tinhTrangSach;
		tienPhat = A.tienPhat;
		iDDieuKhoan = A.iDDieuKhoan;
	}
	
	String getIDPhieuPhat()
	{
		return iDPhieuPhat;
	}
	
	String getIDSach()
	{ 
		return iDSach;
	}
	int getTinhTrangSach()
	{ 
		return tinhTrangSach;
	}
	
	int getTienPhat()
	{ 
		return tienPhat;
	}
	
	int getIDDieuKhoan()
	{ 
		return iDDieuKhoan;
	}
	
	void setIDPhieuPhat(String ID)
	{ 
		iDPhieuPhat = ID;
	}
	
	void setIDSach(String ID)
	{ 
		iDSach = ID;
	}
	
	void setTinhTrangSach(int x)
	{ 
		tinhTrangSach = x;
	}
	
	void setTienPhat(int x)
	{ 
		tienPhat = x;
	}
	
	void setIDDieuKhoan(int x)
	{ 
		iDDieuKhoan = x;
	}
	
	public String toString()
	{
		return String.format("%-10s%-9s%,-5d%-15s%s\n", iDPhieuPhat, iDSach, tinhTrangSach, String.format("%,d", tienPhat) + " dong","Dieu " + iDDieuKhoan);
	}
}
