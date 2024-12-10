package book;

import execute.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TacGia {

    final String idTacGia = "TG" + String.format("%03d", DanhSachTacGia.soLuong + 1);
    private String ten;
    private LocalDate ngaySinh;
    private String queQuan;
    private Boolean trangThai = true;

    public TacGia() {
        this.ten = "none";
        this.ngaySinh = LocalDate.now();
        this.queQuan = "none";
    }

    public TacGia(String ten, LocalDate ngaySinh, String queQuan) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
    }

    public String getIDTacGia() {
        return idTacGia;
    }

    public String getTen() {
        return ten;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void setNgaySinh(String chuoiNgaySinh) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate NgaySinh = LocalDate.parse(chuoiNgaySinh, formatter);
        this.ngaySinh = NgaySinh;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public TacGia taoTacGia() {
        TacGia tacGia = new TacGia();
        LocalDate ngaySinh = null;

        System.out.println("Nhap ten TacGia:");
        tacGia.setTen(Menu.input.nextLine());

        System.out.println("Nhap vao ngay thang nam sinh (ddMMyyyy) cua TacGia:");
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

        System.out.println("Nhap vao que quan cua TacGia:");
        tacGia.setQueQuan(Menu.input.nextLine());
        tacGia.setNgaySinh(ngaySinh);
        return tacGia;
    }

    public void suaThongTin() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Nhap ten Tac Gia:");
                ten = Menu.input.nextLine();
                System.out.println("Nhap vao ngay thang nam sinh (ddMMyyyy):");
                String chuoiNgaySinh = Menu.input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                ngaySinh = LocalDate.parse(chuoiNgaySinh, formatter);
                System.out.println("Nhap vao que quan cua Tac Gia:");
                queQuan = Menu.input.nextLine();
                validInput = true;
            } catch (DateTimeParseException dpe) {
                System.out.println("Nhap sai dinh dang ngay sinh! Vui long nhap lai.");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("|%-10s|%-30s|%-15s|%-20s|%-15s|", idTacGia, ten, ngaySinh, queQuan, (trangThai ? "hoat dong" : "khoa"));
    }

    public String toStringToFile() {
        return String.format("%s,%s,%s,%s,", ten, ngaySinh.format(DateTimeFormatter.ofPattern("ddMMyyyy")), queQuan, trangThai ? "1" : "0");
    }

}
