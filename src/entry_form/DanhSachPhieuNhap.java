package entry_form;

import data.SharedData;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachPhieuNhap {

    private PhieuNhap[] dsPN;
    private int soLuong = 0;

    public DanhSachPhieuNhap() {
        dsPN = new PhieuNhap[0];
    }
    Scanner scan = new Scanner(System.in);

    public void moRongDanhSach(int soLuongPhieuNhap) {
        PhieuNhap[] newdsPN = new PhieuNhap[soLuong + soLuongPhieuNhap];
        if (soLuongPhieuNhap > 0) {
            System.arraycopy(this.dsPN, 0, newdsPN, 0, soLuong);
        }
        this.dsPN = newdsPN;
    }

  
    public void themPhieuNhap() { //Bằng bàn phím
    	System.out.print("So luong phieu nhap: ");
    	int n = scan.nextInt();
    	while (n-- > 0)
    	{
    		dsPN = Arrays.copyOf(dsPN, soLuong + 1);
    		dsPN[soLuong] = new PhieuNhap();
    		dsPN[soLuong].them();
    		
    		++soLuong;
            SharedData.capNhatDuLieu();
    	
    	}
    	xuat();
    }

    public void xoaPhieuNhap()
    { 
    	PhieuNhap search = timPhieuNhap();
    	if (search == null) return;
    	for (int i = 0; i < soLuong; i++)
    	{
    		if (dsPN[i] == search)
    		{ 
    			for (int j = i; j < soLuong - 1; j++)
    			{ 
    				dsPN[j] = dsPN[j + 1];
    			}
    			soLuong--;
                SharedData.capNhatDuLieu();
                System.out.println("Xoa phieu nhap thanh cong.");
    			return;
    		}
    	}
	}

    public void suaPhieuNhap() {
        System.out.println("\t\t\tSUA PHIEU NHAP");
        System.out.print("Nhap ID Phieu Nhap can sua: ");
        String idPhieuNhap = new Scanner(System.in).nextLine();
        Scanner scanner = new Scanner(System.in);

        boolean found = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                found = true;
                PhieuNhap phieuNhapMoi = new PhieuNhap();
                System.out.print("ID Phieu Nhap: ");
                phieuNhapMoi.setIdPhieuNhap(scanner.nextLine());
                System.out.print("ID Nha Cung Cap: ");
                phieuNhapMoi.setIdNhaCungCap(scanner.nextInt());
                System.out.print("Tong Tien: ");
                phieuNhapMoi.setTongTien(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Ngay Nhap (dd/mm/yyyy): ");
                phieuNhapMoi.setNgayNhap(convertStringToDate(scanner.nextLine()));
                System.out.print("So Luong Sach: ");
                phieuNhapMoi.setSoLuongSach(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("ID Sach: ");
                phieuNhapMoi.setIdSach(scanner.nextInt());
                dsPN[i] = phieuNhapMoi;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay ID Phieu Nhap.");
            return;
        }
    }
    public PhieuNhap timPhieuNhap()
    { 
    	if (soLuong == 0)
    	{ 
    		System.out.println("Khong co phieu phat nao trong danh sach");
    		return null;
    	}
    	xuat();
    	System.out.print("Tim ID Phieu Nhap: ");
    	int ID = scan.nextInt();
    	String search = String.format("PP%03d",ID);
    	for (int i = 0; i < soLuong; i++)
    	{
    		if (search.equals(dsPN[i].getIdPhieuNhap()))
    		{
    			System.out.println("--------------------------------------------------------");
                System.out.printf("%-15s %-17s %-15s %-15s %-15s %-15s\n", "ID Phieu Nhap", "ID Nha Cung Cap", "Tong Tien", "Ngay Nhap", "So Luong Sach", "ID Sach");
            	System.out.println("|  " + dsPN[i] + "  |");
    			System.out.println("--------------------------------------------------------");

    			return dsPN[i];
    		}
    	}
    	System.out.println("Khong tim thay ID can tim");
    	return null;
    }

    public void xuat() {
        System.out.print(" \t\t\t\t----PHIEU NHAP----\n");
        System.out.printf("%-15s %-17s %-15s %-15s %-15s %-15s\n", "ID Phieu Nhap", "ID Nha Cung Cap", "Tong Tien", "Ngay Nhap", "So Luong Sach", "ID Sach");
        for (int i = 0; i < soLuong; i++) {
            System.out.printf("%-15s %-17s %-15d %-15s %-15d %-15s\n",
                    dsPN[i].getIdPhieuNhap(),
                    dsPN[i].getIdNhaCungCap(),
                    dsPN[i].getTongTien(),
                    dsPN[i].getNgayNhap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    dsPN[i].getSoLuongSach(),
                    dsPN[i].getIdSach());
        }
// Dấu -: Căn lề trái.
// Số 15: Độ rộng tối thiểu của cột là 15 ký tự. Nếu dữ liệu ngắn hơn 15 ký tự, khoảng trống sẽ được thêm vào bên phải.
// s: Định dạng kiểu chuỗi (String).

// d: Định dạng kiểu số nguyên (Integer).
// \n: Xuống dòng sau khi in.
    }

    public boolean kiemTraIdDuyNhat(String idPhieuNhap) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                return false;
            }
        }
        return true;
    }

    public LocalDate convertStringToDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void readFile()
    { 
    	try
    	{ 
    		File ds = new File("src/data/DanhSachPhieuNhap.txt");
			if (!ds.exists())
				return;
    		Scanner fin = new Scanner(new File("src/data/DanhSachPhieuNhap.txt"));
    		while (fin.hasNextLine() && fin.hasNext())
    		{ 
    			dsPN = Arrays.copyOf(dsPN, soLuong + 1);
    			dsPN[soLuong] = new PhieuNhap();
    			dsPN[soLuong].setIdPhieuNhap(fin.next());
    			dsPN[soLuong].setIdNhaCungCap(fin.nextInt());
    			dsPN[soLuong].setTongTien(fin.nextInt());
                dsPN[soLuong].setNgayNhap(convertStringToDate(fin.next()));
                dsPN[soLuong].setSoLuongSach(fin.nextInt());
                dsPN[soLuong].setIdSach(fin.nextInt());
    			fin.next();
    			++soLuong;
    		}
    		fin.close();
    	}
    	catch (Exception e)
    	{ 
    		System.out.println("File reading unsuccessful/incomplete due to " + e.toString());
    	}
    }

    public void writeFile()
    { 
    	try
    	{
    	FileWriter fout = new FileWriter("src/data/DanhSachPhieuNhap.txt");
    	for (PhieuNhap i : dsPN)
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

}
