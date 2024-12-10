package fine_ticket;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import data.SharedData;

public class DanhSachPhieuPhat {
	public static int maID = 1; 
	public int soLuong = 0;
    public PhieuPhat[] dSPP;

    public DanhSachPhieuPhat() {
        dSPP = new PhieuPhat[0];
    }
    
    Scanner scan = new Scanner(System.in);
    public void themPhieuPhat1(PhieuPhat phieuPhat) { //Bằng tham số
    	dSPP = Arrays.copyOf(dSPP, soLuong + 1);
    	dSPP[soLuong] = phieuPhat;
        ++soLuong;
        ++maID;
    }

    public void themPhieuPhat() { //Bằng bàn phím
    	System.out.print("So luong phieu phat: ");
    	int n = scan.nextInt();
    	while (n-- > 0)
    	{
    		dSPP = Arrays.copyOf(dSPP, soLuong + 1);
    		dSPP[soLuong] = new PhieuPhat();
    		dSPP[soLuong].them();
    		
    		++soLuong;
    		++maID;
    	}
    	xuat();
    }
    
    public PhieuPhat timPhieuPhat()
    { 
    	if (soLuong == 0)
    	{ 
    		System.out.println("Danh sach phieu phat rong");
    		return null;
    	}
    	xuat();
    	System.out.print("Tim ID Phieu Phat: ");
    	int ID = scan.nextInt();
    	String search = String.format("PP%03d",ID);
    	for (int i = 0; i < soLuong; i++)
    	{
    		if (search.equals(dSPP[i].getIDPhieuPhat()))
    		{
    			System.out.println("--------------------------------------------------------");
    	        System.out.format("|  %-20s%-15s%-15s  |\n", "ID Phieu Phat", "ID Phieu Muon" , "Tien phat");
            	System.out.println("|  " + dSPP[i] + "  |");
    			System.out.println("--------------------------------------------------------");

    			return dSPP[i];
    		}
    	}
    	System.out.println("Khong tim thay ID can tim");
    	return null;
    }
    
    public void suaPhieuPhat()
    { 
    	//Chỉ sửa được ID phiếu mượn
    	PhieuPhat search = timPhieuPhat();
    	if (search == null)
    	{ 
    		return;
    	}
    	System.out.print("ID Phieu Muon moi: ");
    	int pm = scan.nextInt();
    	String ID = String.format("PM%03d", pm);
    	if (search.tonTaiPM(ID) && search.laPMDuyNhat(ID))
    	search.setIDPhieuMuon(ID);
    	else
    	{
    		System.out.println("Ma Phieu Muon khong hop le, ket thuc chuong trinh");
    		return;
    	}
    	xuat();
    }

    public void xoaPhieuPhat()
    { 
    	PhieuPhat search = timPhieuPhat();
    	if (search == null) return;
    	for (int i = 0; i < soLuong; i++)
    	{
    		if (dSPP[i] == search)
    		{ 
    			for (int j = i; j < soLuong - 1; j++)
    			{ 
    				dSPP[j] = dSPP[j + 1];
    			}
    			soLuong--;
    			SharedData.dSCTPP.xoaTatCaCTPP(search.getIDPhieuPhat());
    			return;
    		}
    	}
}
    
    public void xuat()
    { 
    	if (soLuong == 0)
    	{ 
    		System.out.println("Danh sach phieu phat rong");
    		return;
    	}
    	System.out.println("--------------------------------------------------------");
		System.out.println("|                 Danh Sach Phieu Phat                 |");
		System.out.println("--------------------------------------------------------");
        System.out.format("|  %-20s%-15s%-15s  |\n", "ID Phieu Phat", "ID Phieu Muon" , "Tien phat");
		for (int i = 0; i < soLuong; i++) 
		{
        	System.out.println("|  " + dSPP[i] + "  |");
		}
		System.out.println("--------------------------------------------------------");
    }
    
    public void writeFile()
    { 
    	try
    	{
    	FileWriter fout = new FileWriter("src/data/DanhSachPhieuPhat.txt");
    	for (PhieuPhat i : dSPP)
    	{ 
    		fout.write(i.toString() + "\n");
    	}
    	fout.close();
    	}
    	catch (Exception e)
    	{
    		System.out.println("File writing unsuccessful/incomplete due to " + e.toString());
    	}
    }
    
    public void readFile()
    { 
    	try
    	{ 
    		File ds = new File("src/data/DanhSachPhieuPhat.txt");
			if (!ds.exists())
				return;
    		Scanner fin = new Scanner(new File("src/data/DanhSachPhieuPhat.txt"));
    		while (fin.hasNextLine() && fin.hasNext())
    		{ 
    			dSPP = Arrays.copyOf(dSPP, soLuong + 1);
    			dSPP[soLuong] = new PhieuPhat();
    			dSPP[soLuong].setIDPhieuPhat(fin.next());
    			dSPP[soLuong].setIDPhieuMuon(fin.next());
    			dSPP[soLuong].setTienPhat(fin.nextInt());
    			fin.next();
    			++soLuong;
    			++maID;
    		}
    		fin.close();
    	}
    	catch (Exception e)
    	{ 
    		System.out.println("File reading unsuccessful/incomplete due to " + e.toString());
    	}
    }
}
