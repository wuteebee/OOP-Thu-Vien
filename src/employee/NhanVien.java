package employee;

import book.TacGia;
import execute.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class NhanVien {
    private String idNhanVien = "NV" + String.format("%03d", DanhSachNhanVien.soLuong + 1);
    private String ho;
    private String ten;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private String soDienThoai;

    public NhanVien() {
        ho = "none";
        ten = "none";
        ngaySinh = LocalDate.now();
        gioiTinh = false;
        soDienThoai = "none";
    }

    public NhanVien(String ho, String ten, Boolean gioiTinh, LocalDate ngaySinh, String soDienThoai) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
    }

    public LocalDate getNgaySinh() {
        return this.ngaySinh;
    }

    public String getIDNhanVien() {
        return idNhanVien;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public String getHo() {
        return ho;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getTen() {
        return ten;
    }

    public void setID(int id) {
        this.idNhanVien = "NV" + String.format("%03d", id);
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }


    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public NhanVien taoNhanVien() {
        NhanVien NhanVien = new NhanVien();
        try {
            LocalDate ngaySinh = null;

            System.out.println("Nhap ho cua NhanVien:");
            NhanVien.setHo(Menu.input.nextLine());

            System.out.println("Nhap ten cua NhanVien:");
            NhanVien.setTen(Menu.input.nextLine());

            System.out.println("Nhap gioiTinh cua NhanVien (1: nam/0: nu):");
            NhanVien.setGioiTinh(Menu.input.nextInt() == 1);
            Menu.input.nextLine();

            System.out.println("Nhap vao ngay thang nam sinh (ddMMyyyy) cua NhanVien:");
            DateTimeFormatter formatter;
            String chuoiNgaySinh;
            boolean vongLap;
            do {
                try {
                    vongLap = false;
                    chuoiNgaySinh = Menu.input.nextLine();
                    formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                    ngaySinh = LocalDate.parse(chuoiNgaySinh, formatter);
                } catch (Exception e) {
                    System.out.println("Dinh dang khong hop le, vui long nhap lai!");
                    vongLap = true;
                }
            } while (vongLap);

            System.out.println("Nhap vao so dien thoai cua NhanVien:");
            NhanVien.setSoDienThoai(Menu.input.nextLine());
            NhanVien.setNgaySinh(ngaySinh);
        } catch (InputMismatchException ime) {
            return taoNhanVien();
        }
        return NhanVien;
    }

    public void suaThongTin() {
        try {
            System.out.println("Nhap ho cua NhanVien:");
            ho = Menu.input.nextLine();
            System.out.println("Nhap ten cua NhanVien:");
            ten = Menu.input.nextLine();
            System.out.println("Nhap gioiTinh cua NhanVien (1: nam/0: nu):");
            gioiTinh = Menu.input.nextInt() == 1;
            Menu.input.nextLine();
            System.out.println("Nhap vao ngay thang nam sinh (ddMMyyyy) cua NhanVien:");
            String chuoiNgaySinh = Menu.input.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
            ngaySinh = LocalDate.parse(chuoiNgaySinh, formatter);
            System.out.println("Nhap vao so dien thoai cua NhanVien:");
            soDienThoai = Menu.input.nextLine();
        } catch (InputMismatchException | DateTimeParseException ime) {
            suaThongTin();
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s%-15s%-25s%-10s%-15s%-15s", idNhanVien, ho, ten, gioiTinh ? "nam" : "nu", ngaySinh, soDienThoai);
    }
}