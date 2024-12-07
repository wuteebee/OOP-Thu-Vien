package fine_ticket;

import java.util.Scanner;

public class DieuKhoanViPham {
	private String IDDieuKhoan = "Dieu " + DanhSachDieuKhoanViPham.maDieuKhoan;
	private int tienPhat;
	private String noiDung;
	
	public DieuKhoanViPham()
	{ 
		tienPhat = 0;
		noiDung = "None";
	}
	
	public DieuKhoanViPham(int fine, String content)
	{ 
		tienPhat = fine;
		noiDung = content;
	}
	
	public DieuKhoanViPham(DieuKhoanViPham A)
	{ 
		IDDieuKhoan = A.IDDieuKhoan;
		tienPhat = A.tienPhat;
		noiDung =  A.noiDung;
	}
	
	public int getTienPhat()
	{
		return tienPhat;
	}
	
	public String getNoiDung()
	{ 
		return noiDung;
	}

	public void setTienPhat(int val)
	{
		tienPhat = val;
	}
	
	public void setNoiDung(String content)
	{ 
		noiDung = content;
	}
	
	public String toString()
	{ 
		return String.format("%-15s%-20s%-25s", IDDieuKhoan, String.format("%,d dong", tienPhat), noiDung);
	}
	
	Scanner scan = new Scanner(System.in);
	
	public void themDieuKhoan()
	{ 	
		System.out.println("Neu tien phat bang gia tri cua sach, nhap 0");
		System.out.print("Tien phat: ");
		tienPhat = scan.nextInt();
		System.out.print("Noi dung dieu khoan: ");
		scan.nextLine();
		noiDung = scan.nextLine();
	}
}
