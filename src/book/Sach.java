package book;

import data.*;
import execute.*;
import java.util.InputMismatchException;

public class Sach {
    protected String idSach; // = "S" + String.format("%03d", DanhSachSach.soLuong + 1);
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
        return idSach;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Boolean getTrangThai() {
        return trangThai;
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
                System.out.println("Nhập tên của Sách:");
                setTen(Menu.input.nextLine());

                System.out.println("Nhập số lượng của Sách:");
                setTonKho(Menu.input.nextInt());
                Menu.input.nextLine(); 

                System.out.println("Nhập giá của Sách:");
                setGia(Menu.input.nextInt());
                Menu.input.nextLine();

                System.out.println("Nhập tác giả của Sách:");
                TacGia TacGia = SharedData.dSTG.timIDTacGia();
                setTacGia(TacGia);

                System.out.println("Nhập nhà xuất bản của Sách:");
                NhaXuatBan NhaXuatBan = SharedData.dSNXB.timIDNhaXuatBan();
                setNhaXuatBan(NhaXuatBan);

                validInput = true; 
            } catch (InputMismatchException ime) {
                System.out.println("Nhập sai thông tin! Vui lòng nhập lại.");
                Menu.input.nextLine(); 
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s", getIDSach()) + String.format("%-30s%-10s%-10d%-20s%-20s", ten, tonKho, gia, tacGia.getTen(), nhaXuatBan.getTen());
    }
}