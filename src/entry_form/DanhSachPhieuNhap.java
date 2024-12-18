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


            System.out.print("ID Phieu Nhap: ");
            int idPhieuNhap = scan.nextInt();
            while (!kiemTraIdDuyNhat(idPhieuNhap)) {
                System.out.println("ID Phieu Nhap da ton tai. Vui long nhap lai.");
                System.out.print("ID Phieu Nhap: ");
                idPhieuNhap = scan.nextInt();
            }
            dsPN[soLuong].setIdPhieuNhap(idPhieuNhap);

            System.out.print("Ten Sach: ");
            dsPN[soLuong].setTenSach(scan.next());

            System.out.print("ID Sach: ");
            dsPN[soLuong].setIdSach(scan.next());

            System.out.print("So Luong Sach: ");
            dsPN[soLuong].setSoLuongSach(scan.nextInt());

            System.out.print("ID Nha Cung Cap: ");
            dsPN[soLuong].setTenNCC(scan.next());

            System.out.print("Gia Ban: ");
            dsPN[soLuong].setGiaBan(scan.nextInt());

            
            System.out.print("Ngay Nhap(dd/mm/yyyy): ");
            dsPN[soLuong].setNgayNhap(convertStringToDate(scan.next()));


            // cap nhat ton kho
            String idSach = dsPN[soLuong].getIdSach();
            int soLuongSach = dsPN[soLuong].getSoLuongSach();
            Sach sach = SharedData.timSachTheoId(Integer.parseInt(idSach));
            if (sach != null) {
                sach.setTonKho(sach.getTonKho() + soLuongSach);
            }

            soLuong++;
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
                System.out.print("Ten Sach(khong chua khoang trang): ");
                phieuNhapMoi.setTenSach(scanner.nextLine());
                System.out.print("ID Sach: ");
                phieuNhapMoi.setIdSach(scanner.nextLine());
                System.out.print("So Luong Sach: ");
                phieuNhapMoi.setSoLuongSach(scanner.nextInt());
                System.out.print("ID Nha Cung Cap: ");
                phieuNhapMoi.setTenNCC(scanner.next());
                System.out.print("Gia Ban: ");
                phieuNhapMoi.setGiaBan(scanner.nextInt());
                System.out.print("Ngay Nhap(dd/mm/yyyy): ");
                phieuNhapMoi.setNgayNhap(convertStringToDate(scanner.nextLine())); 
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
                System.out.printf("%-16s %-16s %-16s %-17s %-16s %-16s\n", "ID Phieu Nhap","Ten Sach","ID Sach ","So Luong Sach", "Nha Cung Cap", "Gia Ban", "Ngay Nhap",  "Ngay Nhap");
                System.out.printf("%-16s", "ID Sach");
            	System.out.println("|" + dsPN[i] + "|");
    			System.out.println("--------------------------------------------------------");

    			return dsPN[i];
    		}
    	}
    	
    	System.out.println("Khong tim thay ID can tim");
    	return null;
    }

    public void xuat() {
        if(soLuong == 0)
        {
            System.out.println("Danh sach trong");
            return;
        }
     
        System.out.print(" \t\t\t\t----PHIEU NHAP----\n");
        System.out.printf("%-16s %-16s %-16s %-17s %-18s %-16s %-16s\n", "ID Phieu Nhap", "Ten Sach", "ID Sach", "So Luong Sach", "Nha Cung Cap", "Gia Ban", "Ngay Nhap");
        for (int i = 0; i < soLuong; i++) {
            System.out.printf("|" + dsPN[i] + "|\n");
                 
        }

    }

    public  boolean kiemTraIdDuyNhat(int idPhieuNhap) {
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

    public void readFile() { 
        try { 
            File ds = new File("src\\data\\DanhSachPhieuNhap.txt");
            if (!ds.exists())
                return;
            Scanner fin = new Scanner(new File("src\\data\\DanhSachPhieuNhap.txt"));
            while (fin.hasNextLine()) { 
                dsPN = Arrays.copyOf(dsPN, soLuong + 1);
                dsPN[soLuong] = new PhieuNhap();
                
                dsPN[soLuong].setIdPhieuNhap(fin.nextInt());
                dsPN[soLuong].setTenSach(fin.next());
                dsPN[soLuong].setIdSach(fin.next());
                dsPN[soLuong].setSoLuongSach(fin.nextInt());
                dsPN[soLuong].setTenNCC(fin.next());
                dsPN[soLuong].setGiaBan(fin.nextInt());
                String ngayNhap = fin.next();
                dsPN[soLuong].setNgayNhap(convertStringToDate(ngayNhap));
                fin.nextLine(); 
                soLuong++;
            }
            fin.close();
        } catch (Exception e) { 
            System.out.println("File reading unsuccessful/incomplete due to " + e.toString());
        }
    }

    public void writeFile() { 
        try {
            try (FileWriter fout = new FileWriter("src\\data\\DanhSachPhieuNhap.txt")) {
                for (int i = 0; i < soLuong; i++) {
                    fout.write(dsPN[i].toString() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("File writing unsuccessful/incomplete due to " + e.toString());
        }
    }
}
