package entry_form;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class PhieuNhap {
    
    private String idPhieuNhap;
    private String idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;
    private int soLuongSach;
    private String idSach;

    public String getidPhieuNhap() {
        return idPhieuNhap;
    }

    public void setidPhieuNhap(String idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }
    // Getters and Setters
    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(String idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuongSach() {
        return soLuongSach;
    }

    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public void nhapThongTin() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhap ID chi tiet phieu nhap: ");
            this.setidPhieuNhap(scanner.nextLine());
            System.out.print("Nhap ID nha cung cap: ");
            this.setIdNhaCungCap(scanner.nextLine());

            System.out.print("Nhap ID sach: ");
            this.setIdSach(scanner.next());

            System.out.print("Nhap so luong sach: ");
            this.setSoLuongSach(scanner.nextInt());

            System.out.print("Nhap tong tien: ");
            this.setTongTien(scanner.nextInt());

            System.out.print("Nhap ngay nhap (yyyy-mm-dd): ");
            this.setNgayNhap(LocalDate.parse(scanner.next()));
        }

        luuThongTin();
    }

    private void luuThongTin() throws IOException {
        try (FileWriter writer = new FileWriter("src/data/phieu_nhap.txt", true)) {
            writer.write(String.format("%s%n", getidPhieuNhap()));
            writer.write(String.format("ID nha cung cap: %s%n", getIdNhaCungCap()));
            writer.write(String.format("ID sach: %s%n", getIdSach()));
            writer.write(String.format("So luong sach: %d%n", getSoLuongSach()));
            writer.write(String.format("Tong tien: %d%n", getTongTien()));
            writer.write(String.format("Ngay nhap: %s%n", getNgayNhap()));
            writer.write("------------------------------\n");
        } 
        
    }

    public void xuatThongTin() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhap ID phieu nhap can tim: ");
            String idCanTim = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/data/phieu_nhap.txt"))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                if (line.equals(idCanTim)) {
                    found = true;
                    System.out.println("Thong tin phieu nhap:");
                    System.out.println(line);
                    for (int i = 0; i < 6; i++) {
                        System.out.println(reader.readLine());
                    }
                    break;
                }
            }
            if (!found) {
                System.out.println("Khong tim thay phieu nhap voi ID: " + idCanTim);
            }
        }
    }

    }
}
