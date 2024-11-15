package entry_form;

import java.time.LocalDate;

public class PhieuNhap {
    final String idPhieuNhap = "PN" + String.format("%03d", DanhSachChiTietPhieuNhap.soLuong);
    private String idTheThuVien;
    private String idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;

    public PhieuNhap() {
        this.idTheThuVien = "none";
        this.idNhaCungCap = "none";
        this.tongTien = 0;
        this.ngayNhap = LocalDate.now();
    }

    public PhieuNhap(String idTheThuVien, String idNhaCungCap, int tongTien, LocalDate ngayNhap) {
        this.idTheThuVien = idTheThuVien;
        this.idNhaCungCap = idNhaCungCap;
        this.tongTien = tongTien;
        this.ngayNhap = ngayNhap;
    }

    public PhieuNhap(PhieuNhap phieuNhap) {
        this.idTheThuVien = phieuNhap.idTheThuVien;
        this.idNhaCungCap = phieuNhap.idNhaCungCap;
        this.tongTien = phieuNhap.tongTien;
        this.ngayNhap = phieuNhap.ngayNhap;
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public String getIdTheThuVien() {
        return idTheThuVien;
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

    public void setIdTheThuVien(String idTheThuVien) {
        this.idTheThuVien = idTheThuVien;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
}