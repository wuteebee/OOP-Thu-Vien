package users;

import execute.Menu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class TheThuVien extends NguoiDung {
    final String idTheThuVien = "TTV" + String.format("%03d", DanhSachTheThuVien.soLuong + 1);
    private String ho;
    private String ten;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private String soDienThoai;
    private Boolean trangThai = true;

    public TheThuVien() {
        ho = "non";
        ten = "none";
        ngaySinh = LocalDate.now();
        gioiTinh = false;
        soDienThoai = "none";
    }

    public TheThuVien(String ho, String ten, Boolean gioiTinh, LocalDate ngaySinh, String soDienThoai) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
    }

    public String getIDTheThuVien() {
        return idTheThuVien;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setNgaySinh(String chuoiNgaySinh) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDate NgaySinh = LocalDate.parse(chuoiNgaySinh, formatter);
        
        this.ngaySinh = NgaySinh;
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

    public void setTrangThai(Boolean trangThai){
        this.trangThai = trangThai;
    }

    @Override
    public void tao() {
        TheThuVien TheThuVien = new TheThuVien();
        LocalDate ngaySinh = null;

        System.out.println("Nhap ho cua TheThuVien:");
        TheThuVien.setHo(Menu.input.nextLine());

        System.out.println("Nhap ten cua TheThuVien:");
        TheThuVien.setTen(Menu.input.nextLine());

        System.out.println("Nhap gioiTinh cua TheThuVien (1: nam/0: nu):");
        TheThuVien.setGioiTinh(Menu.input.nextInt() == 1);

        System.out.println("Nhap vao ngay thang nam sinh (ddMMyyyy) cua TheThuVien:");
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

        System.out.println("Nhap vao so dien thoai cua TheThuVien:");
        TheThuVien.setSoDienThoai(Menu.input.nextLine());
        TheThuVien.setNgaySinh(ngaySinh);
    }

    @Override
    public void suaThongTin() {
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Nhap ho cua The Thu Vien:");
                ho = Menu.input.nextLine();

                System.out.println("Nhap ten cua The Thu Vien:");
                ten = Menu.input.nextLine();

                System.out.println("Nhap gioiTinh cua The Thu Vien (1: nam/0: nu):");
                gioiTinh = Menu.input.nextInt() == 1;
                Menu.input.nextLine();

                System.out.println("Nhap vao ngay thang nam sinh (ddMMyyyy) cua The Thu Vien:");
                String chuoiNgaySinh = Menu.input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
                ngaySinh = LocalDate.parse(chuoiNgaySinh, formatter);

                System.out.println("Nhap vao so dien thoai cua The Thu Vien:");
                soDienThoai = Menu.input.nextLine();

                validInput = true;
                trangThai = true;
            } catch (InputMismatchException ime) {
                System.out.println("Nhap sai gioi tinh! Vui long nhap lai.");
                Menu.input.nextLine();
            } catch (DateTimeParseException dpe) {
                System.out.println("Nhap sai dinh dang ngay sinh! Vui long nhap lai.");
            }
        }
    }

    

    @Override
    public String toString() {
        return String.format("|%-10s|%-15s|%-15s|%-10s|%-15s|%-15s|%-15s|", idTheThuVien, ho, ten, gioiTinh ? "nam" : "nu", ngaySinh, soDienThoai, trangThai? "hoat dong" : "khoa");
    }

    public String toStringToFile() {
        return String.format("%s,%s,%s,%s,%s,%s", ho, ten, gioiTinh? "1" : "0", ngaySinh.format(DateTimeFormatter.ofPattern("ddMMyyyy")), soDienThoai, trangThai? "1" : "0");
    }
}
