package entry_form;

public class ChiTietPhieuNhap {
    final String idPhieuNhap = "PN" + String.format("%03d", DanhSachChiTietPhieuNhap.soLuong);
    private String idSach;
    private int soLuong;
    private int thanhTien;

    public ChiTietPhieuNhap() {
        this.idSach = "non";
        this.soLuong = 0;
        this.thanhTien = 0;
    }

    public ChiTietPhieuNhap(String idSach, int soLuong, int thanhTien) {
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public ChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
        this.idSach = chiTietPhieuNhap.idSach;
        this.soLuong = chiTietPhieuNhap.soLuong;
        this.thanhTien = chiTietPhieuNhap.thanhTien;
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public String getIdSach() {
        return idSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }
}