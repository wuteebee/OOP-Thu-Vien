package entry_form;

import java.time.LocalDate;

public class PhieuNhap {
    final String idPhieuNhap = "PN" + String.format("%03d", DanhSachChiTietPhieuNhap.soLuong);
    private String idNhanVien;
    private String idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;

    public PhieuNhap() {
        this.idNhanVien = "none";
        this.idNhaCungCap = "none";
        this.tongTien = 0;
        this.ngayNhap = LocalDate.now();
    }

    public PhieuNhap(String idNhanVien, String idNhaCungCap, int tongTien, LocalDate ngayNhap) {
        this.idNhanVien = idNhanVien;
        this.idNhaCungCap = idNhaCungCap;
        this.tongTien = tongTien;
        this.ngayNhap = ngayNhap;
    }

    public PhieuNhap(PhieuNhap phieuNhap) {
        this.idNhanVien = phieuNhap.idNhanVien;
        this.idNhaCungCap = phieuNhap.idNhaCungCap;
        this.tongTien = phieuNhap.tongTien;
        this.ngayNhap = phieuNhap.ngayNhap;
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setIdNhaCungCap(String idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}