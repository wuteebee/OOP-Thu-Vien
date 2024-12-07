package book;

import execute.*;
import java.util.InputMismatchException;

public class NhaXuatBan {
    final String idNhaXuatBan = "NXB" + String.format("%03d", DanhSachNhaXuatBan.soLuong + 1);
    private String ten;
    private String soDienThoai;
    private String diaChi;
    private Boolean trangThai = true;

    public NhaXuatBan() {
        this.ten = "none";
        this.soDienThoai = "none";
        this.diaChi = "none";
    }

    public NhaXuatBan(String ten, String soDienThoai, String diaChi) {
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getIDNhaXuatBan() {
        return idNhaXuatBan;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public NhaXuatBan taoNhaXuatBan() {
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        System.out.println("Nhap ten cua NhaXuatBan:");
        nhaXuatBan.setTen(Menu.input.nextLine());
        System.out.println("Nhap so dien thoai cua NhaXuatBan:");
        nhaXuatBan.setSoDienThoai(Menu.input.nextLine());
        System.out.println("Nhap dia chi cua NhaXuatBan:");
        nhaXuatBan.setDiaChi(Menu.input.nextLine());
        return nhaXuatBan;
    }

    public void suaThongTin() {
        boolean validInput = false; 

        while (!validInput) { 
            try {
                System.out.println("Nhap ten cua Nha Xuat Ban:");
                ten = Menu.input.nextLine();
                
                System.out.println("Nhap so dien thoai cua Nha Xuat Ban:");
                soDienThoai = Menu.input.nextLine();
                
                System.out.println("Nhap dia chi cua Nha Xuat Ban:");
                diaChi = Menu.input.nextLine();
                
                validInput = true; 
            } catch (InputMismatchException ime) {
                System.out.println("Nhap sai! Vui long nhap lai.");
                Menu.input.nextLine(); 
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%-15s%-50s", idNhaXuatBan, ten, soDienThoai, diaChi);
    }
}
