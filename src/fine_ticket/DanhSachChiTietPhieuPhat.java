package fine_ticket;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class DanhSachChiTietPhieuPhat {
	public static int soLuong = 0;
	public static ChiTietPhieuPhat[] dSCTPP;

	public DanhSachChiTietPhieuPhat() {
		dSCTPP = new ChiTietPhieuPhat[0];
	}

	Scanner scan = new Scanner(System.in);

	public void boSungChiTietPhieuPhat() {
		ChiTietPhieuPhat A = new ChiTietPhieuPhat();
		if (A.boSung())
		{
			dSCTPP = Arrays.copyOf(dSCTPP, soLuong + 1);
			dSCTPP[soLuong++] = A;
			//Cap nhat lai tong tien cho phieu phat;
			for (PhieuPhat i : DanhSachPhieuPhat.dSPP)
			{ 
				if (i.getIDPhieuPhat().equals(A.getIDChiTietPhieuPhat()))
				{
					i.setTienPhat(i.getTongTienPhat() + A.getTienPhat());
				}
			}	
		}
		sortCTPP(); 
		xuat();
	}
	
	public int themChiTietPhieuPhat(int n) {
		int tongTien = 0;
		dSCTPP = Arrays.copyOf(dSCTPP, soLuong + n);
		while (n-- > 0) {
			dSCTPP[soLuong] = new ChiTietPhieuPhat();
			dSCTPP[soLuong].them();
			tongTien += dSCTPP[soLuong].getTienPhat();
			soLuong++;
		}
		return tongTien;
	}

	public void xuat() {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("|                      Danh Sach Chi Tiet Phieu Phat                     |");
		System.out.println("--------------------------------------------------------------------------");
		System.out.format("|  %-20s%-15s%-15s%s  |\n", "ID Phieu Phat", "ID Sach", "Tien Phat", "Dieu Khoan Vi Pham");
		for (int i = 0; i < soLuong; i++) 
		{
			System.out.println("|  " + dSCTPP[i] + "              |");
		}
		System.out.println("--------------------------------------------------------------------------");
	}

	public ChiTietPhieuPhat[] timChiTietPhieuPhat() {
		System.out.print("Nhap ID Phieu Phat: ");
		int ID = scan.nextInt();
		String search = String.format("PP%03d", ID);
		ChiTietPhieuPhat[] res = new ChiTietPhieuPhat[0];
		int sl = 0;
		for (int i = 0; i < soLuong; i++) {
			if (search.equals(dSCTPP[i].getIDChiTietPhieuPhat()))
			{
				res = Arrays.copyOf(res, sl + 1);
				res[sl++] = dSCTPP[i];
			}
		}

		if (sl == 0)
		{ 
			System.out.println("Khong tim thay Phieu Phat nao voi ma " + search + ", ket thuc chuc nang");
			return null;
		}
		// In ra cac phieu tim thay
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("|                     Danh Sach Chi Tiet Phieu Tim Thay                           |");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.format("|  %-9s%-20s%-15s%-15s%s  |\n", "STT", "ID Phieu Phat", "ID Sach", "Tien Phat", "Dieu Khoan Vi Pham");
		for (int i = 0; i < sl; i++) {
			System.out.println("|  " + (i + 1) + "        " + res[i] + "              |");
		}
		System.out.println("-----------------------------------------------------------------------------------");

		return res;
	}

	public void suaChiTietPhieuPhat() 
	 { 
		xuat();
		ChiTietPhieuPhat[] res = timChiTietPhieuPhat();
		int sl_res = 0;
		for (ChiTietPhieuPhat i : res)
		{ 
			++sl_res;
		}
		int choice;
		char ind1 = 'N';
		do
		{
			if (ind1 == 'Y' || ind1 == 'y')
			{ 
				//In cac chi tiet phieu tim thay
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.println("|                     Danh Sach Chi Tiet Phieu Tim Thay                           |");
				System.out.println("-----------------------------------------------------------------------------------");
				System.out.format("|  %-9s%-20s%-15s%-15s%s  |\n", "STT", "ID Phieu Phat", "ID Sach", "Tien Phat", "Dieu Khoan Vi Pham");
				for (int i = 0; i < sl_res; i++) {
					System.out.println("|  " + (i + 1) + "        " + res[i] + "              |");
				}
				System.out.println("-----------------------------------------------------------------------------------");
			}
			
			if (sl_res != 1)
			{
			System.out.print("Chon phieu muon sua theo so thu tu: ");
			choice = scan.nextInt() - 1;
			}
			else
			choice = 0;
			if  (choice < 0 || choice > sl_res - 1)
				System.out.println("Phieu phai nam trong pham vi STT");
			else
			{
				char ind;
				do
				{
				int a = menuChinhSua();
				switch (a)
				{
				case 1:
					System.out.print("ID Phieu Phat: ");
					res[choice].setIDChiTietPhieuPhat(String.format("PP%03d", scan.nextInt()));
					break;
				case 2:
					System.out.print("ID Sach: ");
					res[choice].setIDSach(String.format("SA%03d", scan.nextInt()));
					break;
				case 4:
					System.out.print("Dieu Khoan Vi Pham: ");
					res[choice].setidDieuKhoan(scan.nextInt());
					//Cap nhat lai tong tien trong phieu phat
					for (PhieuPhat i : DanhSachPhieuPhat.dSPP)
					{ 
						if (i.getIDPhieuPhat().equals(res[choice].getIDChiTietPhieuPhat()))
						{
							i.setTienPhat(tinhTongTien(i.getIDPhieuPhat()));
						}
					}
					break;
				default:
					System.out.println("Lua chon phai nam trong pham vi chuc nang menu");
				}
				System.out.print("Tiep tuc sua phieu nay(Y/N)? ");
				ind = scan.next().charAt(0);
				}
				while (ind == 'Y' || ind == 'y');
				if (sl_res == 1)
					return;
			}
			if  (!(choice < 0 || choice > sl_res - 1))
			{
			System.out.print("Tiep tuc sua cac phieu khac(Y/N)? ");
			ind1 = scan.next().charAt(0);
			}
		} while (choice < 0 || choice > sl_res - 1 || ind1 == 'Y' || ind1 == 'y');
		sortCTPP();
		xuat();
	 }
	
	private int menuChinhSua()
	{
		System.out.println("----------------------------");
		System.out.println("|      Menu chinh sua      |");
		System.out.println("----------------------------");
		System.out.println("|  1 - ID Phieu Phat       |");
		System.out.println("|  2 - ID Sach             |");
		System.out.println("|  3 - Tinh Trang          |");
		System.out.println("|  4 - Dieu Khoan Vi Pham  |");
		System.out.println("----------------------------");
		System.out.print("Chon chuc nang: ");
		int select = scan.nextInt();
		return select;
	}
	
	public void xoaChiTietPhieuPhat()
	{
		ChiTietPhieuPhat[] res = timChiTietPhieuPhat();
		int sl = 0;
		for (ChiTietPhieuPhat i : res)
		{ 
			sl++;
		}
		
		int choice;
		if (sl != 1)
		{
		do 
		{
			System.out.println("Chon phieu muon xoa trong bang tren: ");
			choice = scan.nextInt() - 1;
		} while (choice < 0 || choice > sl - 1);
		}
		else
		{
			choice = 0;
			System.out.println("CHI CO 1 CHI TIET PHIEU, TIEN HANH XOA");
		}
					for (int i = 0; i < soLuong; i++)
		{
			if (dSCTPP[i] == res[choice])
			{
				for (int j = i; j < soLuong - 1; j++)
				{
					dSCTPP[j] = dSCTPP[j + 1];
				}
				soLuong--;
				return;
			}
		}
		
		xuat();
	}
	
	public void xoaTatCaCTPP(String ID)
	{ 
		int i = 0;
		while (i < soLuong)
		{ 
			if (dSCTPP[i].getIDChiTietPhieuPhat().equals(ID))
			{ 
				for (int j = i; j < soLuong - 1; j++)
				{ 
					dSCTPP[j] = dSCTPP[j + 1];
				}
				--soLuong;
				i = 0;
			}
			else
				++i;
		}
	}
	
	public int tinhTongTien(String IDPhieuPhat)
	{ 
		int tong = 0;
		for (int i = 0; i < soLuong; ++i)
		{ 
			if (dSCTPP[i].getIDChiTietPhieuPhat().equals(IDPhieuPhat))
			{
			tong += dSCTPP[i].getTienPhat();
			}
		}
		return tong;
	 }
	 
	public void sortCTPP()
	{
		for (int i = 0; i < soLuong - 1; i++)
		{ 
			for (int j = i + 1; j < soLuong; j++)
			{ 
				if (dSCTPP[i].getIDChiTietPhieuPhat().compareTo(dSCTPP[j].getIDChiTietPhieuPhat()) > 0)
				{
					ChiTietPhieuPhat temp = dSCTPP[i];
					dSCTPP[i] = dSCTPP[j];
					dSCTPP[j] = temp;
					temp = null;
				}
			}
		}
	}
	
	 public void writeFile()
	 {
		 try
		 {
		 FileWriter fout = new FileWriter("DanhSachChiTietPhieuPhat.txt");
		 for (ChiTietPhieuPhat i : dSCTPP)
		 {
			 fout.write(i.toString() + "\n");
		 }
		 fout.close();
		 System.out.println("LUU DU LIEU CHI TIET PHIEU PHAT THANH CONG");
		 }
		 catch (Exception e)
		 { 
			 System.out.println("File writing failed due to " + e.toString());
		 }
	 }
	
	public void readFile()
	{ 
		try
		{
			Scanner fin = new Scanner(new File("DanhSachChiTietPhieuPhat.txt"));
			while (fin.hasNextLine() && fin.hasNext())
			{
				dSCTPP = Arrays.copyOf(dSCTPP, soLuong + 1);
				dSCTPP[soLuong] = new ChiTietPhieuPhat();
				dSCTPP[soLuong].setIDChiTietPhieuPhat(fin.next());
				dSCTPP[soLuong].setIDSach(fin.next());
				dSCTPP[soLuong].setTienPhat(fin.nextInt());
				fin.next(); //Skip "dong" trong file txt
				fin.next(); //Skip "Dieu" trong file txt
				dSCTPP[soLuong].setidDieuKhoan(fin.nextInt());
				++soLuong;
			}
			fin.close();	
			 System.out.println("LAY DU LIEU CHI TIET PHIEU PHAT THANH CONG");
		}
		catch (Exception e)
		{ 
			System.out.println("File reading failed due to " + e.toString());
		}
	}
}
