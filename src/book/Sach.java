package book;

import data.*;
import execute.*;
import java.util.InputMismatchException;

public class Sach {
    protected String id = String.format("%03d", DanhSachSach.soLuong + 1);
    protected String ten;
    protected int tonKho;
    protected int gia;
    protected TacGia tacGia;
    protected NhaXuatBan nhaXuatBan;
    protected Boolean trangThai = true;

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

    public String getID() {
        return id;
    }
    public String getTen() {
        return ten;
    }

    public int getGia()
    {
    	return gia;
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

    public String getIDSach() {
        return id;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public int getTonKho() {
        return tonKho;
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
        TacGia TacGia = SharedData.dSTG.timIDTacGia();
        sach.setTacGia(TacGia);

        System.out.println(SharedData.dSNXB);
        NhaXuatBan NhaXuatBan = SharedData.dSNXB.timIDNhaXuatBan();
        sach.setNhaXuatBan(NhaXuatBan);
        return sach;
    }

    public void suaThongTin() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Nhap ten cua sach:");
                setTen(Menu.input.nextLine());

                System.out.println("Nhap so luong cua sach:");
                setTonKho(Menu.input.nextInt());
                Menu.input.nextLine(); 

                System.out.println("Nhap gia cua sach:");
                setGia(Menu.input.nextInt());
                Menu.input.nextLine();

                System.out.println("Nhap tac gia cua sach:");
                TacGia tacGia = SharedData.dSTG.timIDTacGia();
                setTacGia(tacGia);

                System.out.println("Nhap nha xuat ban cua sach:");
                NhaXuatBan nhaXuatBan = SharedData.dSNXB.timIDNhaXuatBan();
                setNhaXuatBan(nhaXuatBan);

                validInput = true; 
            } catch (InputMismatchException ime) {
                System.out.println("Nhap sai thong tin vui long nhap lai!.");
                Menu.input.nextLine(); 
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s", getIDSach()) + String.format("%-30s%-10s%-10d%-20s%-20s", ten, tonKho, gia, tacGia.getTen(), nhaXuatBan.getTen());
    }
}