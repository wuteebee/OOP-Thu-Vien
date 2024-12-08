package entry_form;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ChiTietPhieuNhap {
    private String id_CTPhieuNhap;
    private String idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;
    private int soLuong;
    private String idSach;

    public ChiTietPhieuNhap() {
        this.idSach = "non";
        this.soLuong = 0;
        this.tongTien = 0;
    }

    public ChiTietPhieuNhap(String idSach, int soLuong, int tongTien) {
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.tongTien = tongTien;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
        this.idSach = chiTietPhieuNhap.idSach;
        this.soLuong = chiTietPhieuNhap.soLuong;
        this.tongTien = chiTietPhieuNhap.tongTien;
    }

    public String getid_CTPhieuNhap() {
        return id_CTPhieuNhap;
    }

    public String getId_CTPhieuNhap() {
        return id_CTPhieuNhap;
    }

    public void setId_CTPhieuNhap(String id_CTPhieuNhap) {
        this.id_CTPhieuNhap = id_CTPhieuNhap;
    }

    public String getIdSach() {
        return idSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int gettongTien() {
        return tongTien;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void settongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void inChiTietPhieuNhap(String id_CTPhieuNhap) {
        try (Scanner scanner = new Scanner(new File("src/data/phieu_nhap.txt"))) {
            boolean found = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split(",");
                if (details[0].trim().equals(id_CTPhieuNhap)) {
                    found = true;
                }
                if (found) {
                    if (!details[0].trim().equals(id_CTPhieuNhap) && details[0].trim().matches("ID\\d+")) {
                        break;
                    }
                    this.id_CTPhieuNhap = details[0].trim();
                    this.idNhaCungCap = details[1].trim();
                    this.tongTien = Integer.parseInt(details[2].trim());
                    this.ngayNhap = LocalDate.parse(details[3].trim());
                    this.soLuong = Integer.parseInt(details[4].trim());
                    this.idSach = details[5].trim();
                    System.out.println("ID Phieu Nhap: " + this.id_CTPhieuNhap);
                    System.out.println("ID Nha Cung Cap: " + this.idNhaCungCap);
                    System.out.println("Tong Tien: " + this.tongTien);
                    System.out.println("Ngay Nhap: " + this.ngayNhap);
                    System.out.println("So Luong: " + this.soLuong);
                    System.out.println("ID Sach: " + this.idSach);
                }
            }
            if (!found) {
                System.out.println("Khong tim thay chi tiet phieu nhap voi ID: " + id_CTPhieuNhap);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}