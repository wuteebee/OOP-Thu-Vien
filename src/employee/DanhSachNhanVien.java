package employee;

import java.time.LocalDate;

public class DanhSachNhanVien {
    int soLuong = 0;
    NhanVien[] dSNV;
}

class NhanVien {
    String idNhanVien;
    String ten;
    String ho;
    LocalDate ngaySinh;
    Boolean gioiTinh;
    String soDienThoai;

    public void NhanVien() {
        idNhanVien = "none";
        ten = "none";
        ho = "none";
        ngaySinh = LocalDate.now();
        gioiTinh = false;
        soDienThoai = "none";
    }

    public void NhanVien(String idNhanVien, String ten, Boolean gioiTinh, LocalDate ngaySinh, String soDienThoai) {
        this.idNhanVien = idNhanVien;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.soDienThoai = soDienThoai;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
