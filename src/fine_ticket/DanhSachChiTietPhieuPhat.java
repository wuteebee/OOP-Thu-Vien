package fine_ticket;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import data.SharedData;

public class DanhSachChiTietPhieuPhat {
	public int soLuong = 0;
	public ChiTietPhieuPhat[] dSCTPP;
	public DanhSachChiTietPhieuPhat() {
		dSCTPP = new ChiTietPhieuPhat[0];
	}

	Scanner scan = new Scanner(System.in);

	public void boSungChiTietPhieuPhat() {
		if (SharedData.dSPP.soLuong == 0)
		{
			System.out.println("Danh sach Chi Tiet Phieu Phat rong");
			return;
		}
		xuat();
		ChiTietPhieuPhat A = new ChiTietPhieuPhat();
		if (A.boSung())
		{
			dSCTPP = Arrays.copyOf(dSCTPP, soLuong + 1);
			dSCTPP[soLuong++] = A;
			//Cap nhat lai tong tien cho phieu phat;
			for (PhieuPhat i : SharedData.dSPP.dSPP)
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
		if (soLuong == 0)
		{ 
			System.out.println("Danh sach Chi Tiet Phieu Phat rong");
			return;
		}
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
		if (soLuong == 0)
		{
			System.out.println("Danh sach chi tiet phieu phat rong");
			return null;
		}
		xuat();
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
		ChiTietPhieuPhat[] res = timChiTietPhieuPhat();
		if (res == null)
		{
			return;
		}
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
					String ID = String.format("PP%03d", scan.nextInt());
					Boolean exist = false;
					for (PhieuPhat i : SharedData.dSPP.dSPP)
					{ 
						if (i.getIDPhieuPhat().equals(ID))
						{
							res[choice].setIDChiTietPhieuPhat(ID);
							exist = true;
							break;
						}
					}
					if (exist == false)
					{ 
						System.out.println("ID Phieu Phat muon sua thanh khong ton tai");
					}
					break;
				case 2:
					System.out.print("ID Sach: ");
					if (res[choice].tonTaiIDSach(scan.nextLine()) == -1)
					{
						System.out.println("ID Sach khong ton tai trong he thong, nhap Y va chon lai chuc nang 2 de nhap lai ID Sach");
					}
					break;
				case 3:
					System.out.print("Dieu Khoan Vi Pham: ");
					res[choice].setidDieuKhoan(scan.nextInt());
					//Cap nhat lai tong tien trong phieu phat
					for (PhieuPhat i : SharedData.dSPP.dSPP)
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
		System.out.println("|  3 - Dieu Khoan Vi Pham  |");
		System.out.println("----------------------------");
		System.out.print("Chon chuc nang: ");
		int select = scan.nextInt();
		scan.nextLine();
		return select;
	}
	
	public void xoaChiTietPhieuPhat()
	{
		ChiTietPhieuPhat[] res = timChiTietPhieuPhat();
		if (res == null)
			return;
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
		String ID = res[choice].getIDChiTietPhieuPhat();
		int val = res[choice].getTienPhat();
		for (int i = 0; i < soLuong; i++)
		{
			if (dSCTPP[i] == res[choice])
			{
				for (int j = i; j < soLuong - 1; j++)
				{
					dSCTPP[j] = dSCTPP[j + 1];
				}
				soLuong--;
				break;
			}
		}
		
		//Cap nhat lai tien
		for (PhieuPhat i : SharedData.dSPP.dSPP)
		{
			if (i.getIDPhieuPhat().equals(ID))
			{
				i.setTienPhat(i.getTongTienPhat() - val);
			}
		}
		xuat();
	}
	
	public void xoaTatCaCTPP(String ID)
	{ 
		if (soLuong == 0) return;
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
		if (soLuong == 0) return 0;
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
		if (soLuong == 0)
			return;
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
	
	public void thongKe() // Thong ke tong tien phat them ma sach
	{ 
		String[] maSach = new String[0];
		int n = 0;
		if (soLuong == 0) 
			return;
		System.out.println("Thong ke tong tien phat theo ma sach");
		System.out.format("%-10s|%s\n", "ID Sach", "Tong tien");
		for (ChiTietPhieuPhat i : dSCTPP)
		{
			Boolean tontai = false;
			int sum = 0;
			for (String s : maSach)
			{ 
				if (i.getIDSach().equals(s))
				{
					tontai = true;
					break;
				}
			}
			if (tontai == true)
			{ 
				continue;
			}
			else
			{
				maSach = Arrays.copyOf(maSach, n + 1);
				maSach[n] = i.getIDSach();
			}
			for (ChiTietPhieuPhat j : dSCTPP)
			{ 
				if (j.getIDSach().equals(maSach[n]))
				{
					sum += j.getTienPhat();
				}
			}
			System.out.format("%-10s|%s\n" ,maSach[n], String.format("%,d dong", sum));
			++n;
		}
	}
	
	public void timKiemNangCao()
	{ 
		if (soLuong == 0)
			return;
		System.out.println("In chi tiet phieu phat vi pham dieu khoan 1 va co loai sach la sach giao khoa");
		for (ChiTietPhieuPhat i : dSCTPP)
		{ 
			if (i.getIDDieuKhoan() == (1)  && i.getIDSach().substring(0, 3).equals("SGK"))
			{ 
				System.out.println(i);
			}
		}
		
		System.out.println("In chi tiet phieu phat vi pham dieu 2 hoac 3");
		for (ChiTietPhieuPhat i: dSCTPP)
		{ 
			if (i.getIDDieuKhoan() == (2) || i.getIDDieuKhoan() == (3))
			{
				System.out.println(i);
			}
		}
	}
	
	public void writeFile()
	 {
		 try
		 {
		 FileWriter fout = new FileWriter("src/data/DanhSachChiTietPhieuPhat.txt");
		 for (ChiTietPhieuPhat i : dSCTPP)
		 {
			 fout.write(i.toString() + "\n");
		 }
		 fout.close();
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
			File ds = new File("src/data/DanhSachChiTietPhieuPhat.txt");
			if (!ds.exists())
				return;
			dSCTPP = new ChiTietPhieuPhat[0];
			Scanner fin = new Scanner(new File("src/data/DanhSachChiTietPhieuPhat.txt"));
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
		}
		catch (Exception e)
		{ 
			System.out.println("File reading failed due to " + e.toString());
		}
	}
}
