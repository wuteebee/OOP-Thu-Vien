package client;

import java.time.LocalDate;

public class TheThuVien {
//    -String:idTheThuVien
//    -String:ten
//    -String:ho
//    -Date:ngaySinh
//    -Boolean:gioiTinh
//    -String:soDienThoai

    private String idTheThuVien;
    private String ten;
    private String ho;
    private LocalDate ngaySinh;
    private Boolean gioiTinh;
    private String soDienThoai;

    public TheThuVien() {
        ten = "none";
        ho = "none";
        ngaySinh = LocalDate.now();
        gioiTinh = false;
        soDienThoai = "none";
    }

    public TheThuVien(String ten, String ho, Boolean gioiTinh, String soDienThoai) {
        this.ten = ten;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
    }

    public TheThuVien(TheThuVien theThuVien) {
        this.ten = theThuVien.ten;
        this.ho = theThuVien.ho;
        this.ngaySinh = theThuVien.ngaySinh;
        this.gioiTinh = theThuVien.gioiTinh;
        this.soDienThoai = theThuVien.soDienThoai;
    }
}