package book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import execute.*;

public class TacGia {
    final String idTacGia = "TG" + String.format("%03d", DanhSachTacGia.soLuong + 1);
    private String ten;
    private LocalDate ngaySinh;
    private String queQuan;

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

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    @Override
    public String toString() {
        return String.format("%-10s%-30s%-15s%-20s", idTacGia, ten, ngaySinh.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), queQuan);
    }


}
