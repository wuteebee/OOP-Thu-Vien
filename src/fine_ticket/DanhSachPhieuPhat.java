package fine_ticket;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import data.SharedData;

public class DanhSachPhieuPhat {
	public static int maID = 1; 
    private int soLuong = 0;
    public PhieuPhat[] dSPP;

    public DanhSachPhieuPhat() {
        dSPP = new PhieuPhat[0];
    }
    
    Scanner scan = new Scanner(System.in);
    public void themPhieuPhat(PhieuPhat phieuPhat) { //Bằng tham số
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
    	System.out.print("Tim ID Phieu Phat: ");
    	int ID = scan.nextInt();
    	String search = String.format("PP%03d",ID);
    	for (int i = 0; i < soLuong; i++)
    	{
    		if (search.equals(dSPP[i].getIDPhieuPhat()))
    		{
    	        System.out.format("|  %-20s%-15s%s    |\n", "ID Phieu Phat", "ID Phieu Muon" , "Tien phat");
            	System.out.println("|  " + dSPP[i] + "  |");
    			return dSPP[i];
    		}
    	}
    	System.out.println("Khong tim thay ID can tim");
    	return null;
    }
    
    public void suaPhieuPhat()
    { 
    	xuat();
    	//Chỉ sửa được ID phiếu mượn
    	PhieuPhat search = timPhieuPhat();
    	System.out.print("ID Phieu Muon moi: ");
    	int pm = scan.nextInt();
    	String ID = String.format("PM%03d", pm);
    	search.setIDPhieuMuon(ID);
    	xuat();
    }

    public void xoaPhieuPhat()
    { 
    	PhieuPhat search = timPhieuPhat();
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
    	xuat();
    	SharedData.dSPP.xuat();
    }
    public void xuat()
    { 
    	
    	System.out.println("----------------------------------------------------");
		System.out.println("|               Danh Sach Phieu Phat               |");
		System.out.println("----------------------------------------------------");
        System.out.format("|  %-20s%-15s%s    |\n", "ID Phieu Phat", "ID Phieu Muon" , "Tien phat");
		for (int i = 0; i < soLuong; i++) 
		{
        	System.out.println("|  " + dSPP[i] + "  |");
		}
		System.out.println("----------------------------------------------------");
    }
    
    public void writeFile()
    { 
    	try
    	{
    	FileWriter fout = new FileWriter("DanhSachPhieuPhat.txt");
    	for (PhieuPhat i : dSPP)
    	{ 
    		fout.write(i.toString() + "\n");
    	}
    	fout.close();
		System.out.println("LUU DU LIEU PHIEU PHAT THANH CONG");
    	}
    	catch (Exception e)
    	{
    		System.out.println("File writing unsuccessful");
    	}
    }
    
    public void readFile()
    { 
    	try
    	{ 
    		Scanner fin = new Scanner(new File("DanhSachPhieuPhat.txt"));
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
    		System.out.println("LAY DU LIEU PHIEU PHAT THANH CONG");
    	}
    	catch (Exception e)
    	{ 
    		System.out.println("File reading unsuccessful/incomplete due to " + e.toString());
    	}
    }
}
