package entry_form;
import book.Sach;
import data.SharedData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


    public void themPhieuNhap() {
        System.out.print("So luong phieu nhap: ");
        int n = scan.nextInt();
        while (n-- > 0)
        {
            dsPN = Arrays.copyOf(dsPN, soLuong + 1);
            dsPN[soLuong] = new PhieuNhap();
            dsPN[soLuong].them();

            // Update tonkho of the book
            int idSach = dsPN[soLuong].getIdSach();
            int soLuongSach = dsPN[soLuong].getSoLuongSach();
            Sach sach = SharedData.timSachTheoId(idSach);
            if (sach != null) {
                sach.setTonKho(sach.getTonKho() + soLuongSach);
            }

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
        int idPhieuNhap = new Scanner(System.in).nextInt();
        Scanner scanner = new Scanner(System.in);

        boolean found = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap() == idPhieuNhap) {
                found = true;
                PhieuNhap phieuNhapMoi = new PhieuNhap();
                System.out.print("ID Phieu Nhap: ");
                phieuNhapMoi.setIdPhieuNhap(scanner.nextInt());
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
    	for (int i = 0; i < soLuong; i++)
    	{
            if (dsPN[i].getIdPhieuNhap() == ID)
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
        // SharedData.importData();
     
        System.out.print(" \t\t\t\t----PHIEU NHAP----\n");
        System.out.printf("%-15s %-17s %-15s %-15s %-15s %-15s\n", "ID Phieu Nhap", "ID Nha Cung Cap", "Tong Tien", "Ngay Nhap", "So Luong Sach", "ID Sach");
        for (int i = 0; i < soLuong; i++) {
            System.out.printf("|  " + dsPN[i] + "  |\n");
                 
        }
// Dấu -: Căn lề trái.
// Số 15: Độ rộng tối thiểu của cột là 15 ký tự. Nếu dữ liệu ngắn hơn 15 ký tự, khoảng trống sẽ được thêm vào bên phải.
// s: Định dạng kiểu chuỗi (String).

// d: Định dạng kiểu số nguyên (Integer).
// \n: Xuống dòng sau khi in.
    }

    public boolean kiemTraIdDuyNhat(int idPhieuNhap) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap() == idPhieuNhap) {
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
            File ds = new File("src\\data\\DanhSachPhieuNhap.txt");
            if (!ds.exists())
                return;
            Scanner fin = new Scanner(new File("src\\data\\DanhSachPhieuNhap.txt"));
            while (fin.hasNextLine())
            {
                dsPN = Arrays.copyOf(dsPN, soLuong + 1);
                dsPN[soLuong] = new PhieuNhap();
                dsPN[soLuong].setIdPhieuNhap(fin.nextInt());
                dsPN[soLuong].setIdNhaCungCap(fin.nextInt());
                dsPN[soLuong].setTongTien(fin.nextInt());
                dsPN[soLuong].setNgayNhap(convertStringToDate(fin.next()));
                dsPN[soLuong].setSoLuongSach(fin.nextInt());
                dsPN[soLuong].setIdSach(fin.nextInt());
                fin.nextLine();
                soLuong++;
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
                
                try (FileWriter fout = new FileWriter("src\\data\\DanhSachPhieuNhap.txt")) {
                  
                    for (int i = 0; i < soLuong; i++) {
                        fout.write(dsPN[i].toString() + "\n");
                    }
                  }
    	}
    	catch (IOException e)
    	{
    		System.out.println("File writing unsuccessful/incomplete due to " + e.toString());
    	}
    }

}
