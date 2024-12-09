package entry_form;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class DanhSachPhieuNhap {
    private  PhieuNhap[] dsPN;
    private int soLuong=0;


    public DanhSachPhieuNhap() {
        dsPN= new PhieuNhap[0];
    }


    public void moRongDanhSach(int soLuongPhieuNhap) {
        PhieuNhap[] newdsPN = new PhieuNhap[soLuong + soLuongPhieuNhap];
        if (soLuongPhieuNhap > 0) System.arraycopy(this.dsPN, 0, newdsPN, 0, soLuong);
        this.dsPN = newdsPN;
    }

    public void themPhieuNhap(PhieuNhap phieuNhap) {
        moRongDanhSach(1);
        ++soLuong;
        this.dsPN[soLuong - 1] = phieuNhap;
    }

    public void xoaPhieuNhap(String idPhieuNhap) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                PhieuNhap[] newdsPN = new PhieuNhap[soLuong - 1];
                for (int j = 0, k = 0; j < soLuong; j++) {
                    if (j != i) {
                        newdsPN[k++] = dsPN[j];
                    }
                }
                dsPN = newdsPN;
                soLuong--;
                break;
            }
        }
    }

    public PhieuNhap timPhieuNhap(String idPhieuNhap) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                return dsPN[i];
            }
        }
        return null;
    }

    public PhieuNhap suaPhieuNhap(PhieuNhap phieuNhap){
        System.out.println(phieuNhap);
        System.out.println("Chinh sua thong tin phieu nhap");
        phieuNhap.suaPhieuNhap();
        return phieuNhap;
    }

    public void xuat(PhieuNhap[] dsPN) {
        for (int i = 0; i < soLuong; i++) {
            System.out.println(dsPN[i]);
        }
    }

    public String convertDateToString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    public Date convertStringToDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void readFile()
    {
        try
        {
            Scanner fin = new Scanner(new File("src/data/DanhSachPhieuNhap.txt"));
            while (fin.hasNextLine() && fin.hasNext())
            {
                dsPN = Arrays.copyOf(dsPN, soLuong + 1);
                dsPN[soLuong] = new PhieuNhap();
                dsPN[soLuong].setIdPhieuNhap(fin.next());
                dsPN[soLuong].setIdNhaCungCap(fin.next());
                dsPN[soLuong].setTongTien(fin.nextInt());
                dsPN[soLuong].setNgayNhap(convertStringToDate(fin.next()));
                dsPN[soLuong].setSoLuongSach(fin.nextInt());
                dsPN[soLuong].setIdSach(fin.next());
                fin.next();
                ++soLuong;
            }
            fin.close();
            System.out.println("LAY DU LIEU THANH CONG");
        }
        catch (Exception e)
        {
            System.out.println("File reading unsuccessful/incomplete due to " + e.toString());
        }
    }

    public void writeFile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phieu nhap: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (FileWriter writer = new FileWriter("src/data/DanhSachPhieuNhap.txt", true)) {
            for (int i = 0; i < n; i++) {
                PhieuNhap phieuNhap = new PhieuNhap();
                System.out.println("Nhap thong tin phieu nhap thu " + (i + 1) + ":");
                System.out.print("ID Phieu Nhap: ");
                phieuNhap.setIdPhieuNhap(scanner.nextLine());
                System.out.print("ID Nha Cung Cap: ");
                phieuNhap.setIdNhaCungCap(scanner.nextLine());
                System.out.print("Tong Tien: ");
                phieuNhap.setTongTien(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Ngay Nhap (dd/MM/yyyy): ");
                phieuNhap.setNgayNhap(convertStringToDate(scanner.nextLine()));
                System.out.print("So Luong Sach: ");
                phieuNhap.setSoLuongSach(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("ID Sach: ");
                phieuNhap.setIdSach(scanner.nextLine());

                themPhieuNhap(phieuNhap);

                writer.write(phieuNhap.getIdPhieuNhap() + " ");
                writer.write(phieuNhap.getIdNhaCungCap() + " ");
                writer.write(phieuNhap.getTongTien() + " ");
                writer.write(convertDateToString(phieuNhap.getNgayNhap()) + " ");
                writer.write(phieuNhap.getSoLuongSach() + " ");
                writer.write(phieuNhap.getIdSach() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(){
        for (int i = 0; i < soLuong; i++) {
            System.out.println(dsPN[i]);
        }
    }


}
