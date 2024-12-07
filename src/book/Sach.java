package book;

import data.*;
import execute.*;

public class Sach {
    final String idSach = "S" + String.format("%03d", DanhSachSach.soLuong + 1);
    protected String ten;
    protected int tonKho;
    protected int gia;
    protected TacGia tacGia;
    protected NhaXuatBan nhaXuatBan;

    public Sach() {
        ten = "none";
        tonKho = 0;
        gia = 0;
        tacGia = new TacGia();
        nhaXuatBan = new NhaXuatBan();
    }

    public Sach(String ten, int tonKho, int gia, TacGia tacGia, NhaXuatBan nhaXuatBan) {
        this.ten = ten;
        this.tonKho = tonKho;
        this.gia = gia;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
    }

    public Sach(Sach sach) {
        this.ten = sach.ten;
        this.tonKho = sach.tonKho;
        this.gia = sach.gia;
        this.tacGia = sach.tacGia;
        this.nhaXuatBan = sach.nhaXuatBan;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNhaXuatBan(NhaXuatBan nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public Sach taoSach() {
        Sach sach = new Sach();
        System.out.println("Nhap ten cua Sach:");
        sach.setTen(Menu.input.nextLine());

        System.out.println("Nhap so luong cua Sach:");
        sach.setTonKho(Menu.input.nextInt());
        Menu.input.nextLine();

        System.out.println("Nhap gia cua Sach:");
        sach.setGia(Menu.input.nextInt());
        Menu.input.nextLine();

        System.out.println(SharedData.dSTG);
        TacGia tacGia = SharedData.dSTG.timIDTacGia();
        sach.setTacGia(tacGia);

        System.out.println(SharedData.dSNXB);
        NhaXuatBan nhaXuatBan = SharedData.dSNXB.timIDNhaXuatBan();
        sach.setNhaXuatBan(nhaXuatBan);
        return sach;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%-10s%-10d%-20s%-20s", idSach, ten, tonKho, gia, tacGia.getTen(), nhaXuatBan.getTen());
    }
}