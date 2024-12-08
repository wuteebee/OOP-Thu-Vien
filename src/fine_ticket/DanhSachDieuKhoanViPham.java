package fine_ticket;

import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class DanhSachDieuKhoanViPham {
	public static int maDieuKhoan = 1;
	public DieuKhoanViPham[] dSDK;
	
	public DanhSachDieuKhoanViPham()
	{ 
		dSDK = new DieuKhoanViPham[1];
	}
	
	Scanner scan = new Scanner(System.in);
	
	public void themNDieuKhoan()
	{ 
		int n;
		do
		{
			System.out.print("So luong dieu khoan muon nhap: ");
			n = scan.nextInt();
			if (n < 1)
				System.out.println("So luong phai la so nguyen lon hon 0");
		} while (n < 1);
		
		for (int i = 0; i < n; i++)
		{ 
			dSDK = Arrays.copyOf(dSDK, maDieuKhoan + 1);
			dSDK[maDieuKhoan] = new DieuKhoanViPham();
			dSDK[maDieuKhoan].themDieuKhoan();
			++maDieuKhoan;
		}
		xuat();
	}
	
	public void suaDieuKhoan()
	{ 
		int search;
		do
		{ 
			System.out.print("Sua dieu khoan: ");
			search = scan.nextInt();
			if (search < 1 || search > maDieuKhoan - 1)
			{ 
				System.out.print("Khong tim thay dieu khoan, nhap lai (Y/N)? ");
				char ind = scan.next().charAt(0);
				if (!(ind == 'Y' || ind == 'y'))
					return;
			}
		} while (search < 1 || search > maDieuKhoan - 1);
		
		switch (menuSua())
		{
			case 1:
				System.out.println("Nhap 0 neu tien phat la gia tri cua cuon sach vi pham dieu khoan");
				int val;
				do
				{
					System.out.print("Tien Phat: ");
					val = scan.nextInt();
					if (val < 0)
					{ 
						System.out.print("So tien khong hop le, nhap lai (Y/N)? ");
						char ind = scan.next().charAt(0);
						if (!(ind == 'Y' || ind == 'y'))
							return;
					}
				} while (val < 0);
				dSDK[search].setTienPhat(val);
				break;
			case 2:
				System.out.print("Noi Dung: ");
				dSDK[search].setNoiDung(scan.nextLine());
				break;
			default:
				System.out.println("Lua chon phai nam trong pham vi chuc nang menu");
				break;
		}
	}
	
	public void xoaDieuKhoan()
	{ 
		System.out.print("Xoa dieu khoan: ");
		int search = scan.nextInt();
		if (search < 1 || search > maDieuKhoan - 1)
		{ 
			System.out.println("Khong tim thay dieu khoan");
		}
		
		for (int i = search; i < maDieuKhoan - 1; i++)
		{ 
			dSDK[i].setTienPhat(dSDK[i + 1].getTienPhat());
			dSDK[i].setNoiDung(dSDK[i + 1].getNoiDung());
		}
		maDieuKhoan--;
		xuat();
	}
	
	private int menuSua()
	{ 
		System.out.println("-------------------------------");
		System.out.println("   Menu Chinh Sua Dieu Khoan   ");
		System.out.println("-------------------------------");
		System.out.println("|  1 - Tien Phat              |");
		System.out.println("|  2 - Noi Dung               |");
		System.out.println("-------------------------------");
		System.out.print("Chon chuc nang: ");
		return scan.nextInt();
	}
	public void xuat()
	{ 
		if (maDieuKhoan == 1)
		{
			System.out.println("Danh sach dieu khoan vi pham chua duoc them");
			return;
		}
		for (int i = 0; i < 67; i++)
		{ 
			System.out.print("-");
		}
		System.out.println("\n|                  Danh Sach Quy Dinh Dieu Khoan                  |");
		for (int i = 0; i < 67; i++)
		{ 
			System.out.print("-");
		}
		System.out.format("\n|   %-15s%-20s%-25s  |", "Dieu Khoan", "Muc Phat", "Noi dung");
		System.out.println();
		for (int i = 1; i < maDieuKhoan; i++)
		{ 
			System.out.println("|   " + dSDK[i] + "  |");
		}
		for (int i = 0; i < 67; i++)
		{ 
			System.out.print("-");
		}
		System.out.println("\nNhung dieu khoan co tien phat bang 0 se su dung gia tri cua cuon sach vi pham dieu khoan lam tien phat");
	}
	
	public void writeFile()
	{ 
		try
		{
			FileWriter fout = new FileWriter("DanhSachDieuKhoanViPham.txt");
			for (int i = 1; i < maDieuKhoan; i++)
			{ 
				fout.write(dSDK[i] + "\n");
			}
			fout.close();
			System.out.println("LUU DU LIEU THANH CONG");
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
			File ds = new File ("DanhSachDieuKhoanViPham.txt");
			if (!ds.exists())
			{ 
				return;
			}
			Scanner fin = new Scanner(new File("DanhSachDieuKhoanViPham.txt"));
			while (fin.hasNext() && fin.hasNextLine())
			{
				dSDK = Arrays.copyOf(dSDK, maDieuKhoan + 1);
				dSDK[maDieuKhoan] = new DieuKhoanViPham();
				fin.next();
				fin.next();
				dSDK[maDieuKhoan].setTienPhat(fin.nextInt());
				fin.next();
				dSDK[maDieuKhoan].setNoiDung(fin.nextLine().trim());
				++maDieuKhoan;
			}
			fin.close();
			System.out.println("LAY DU LIEU DIEU KHOAN VI PHAM THANH CONG");
		}
		catch (Exception e) 
		{ 
			System.out.println("File reading failed due to " + e.toString());
		}
	}
}
