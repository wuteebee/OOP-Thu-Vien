package entry_form;

import java.time.LocalDate;

public class PhieuNhap {
    
    private String idPhieuNhap;
    private String idNhaCungCap;
    private int tongTien;
    private LocalDate ngayNhap;
    private int soLuongSach;
    private String idSach;
    
    public PhieuNhap() {
        idPhieuNhap = "PN" + String.format("%03d", 1);
        idNhaCungCap =  String.format("%03d", 1);
        tongTien = 0;
        ngayNhap = LocalDate.now();
        soLuongSach = 0;
        idSach = String.format("%03d", 1);
    }

    public String getIdPhieuNhap() {
        return idPhieuNhap;
    }

    public void setIdPhieuNhap(String idPhieuNhap) {
        this.idPhieuNhap = idPhieuNhap;
    }

    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(String idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getSoLuongSach() {
        return soLuongSach;
    }

    public void setSoLuongSach(int soLuongSach) {
        this.soLuongSach = soLuongSach;
    }

    public String getIdSach() {
        return idSach;
    }

    public void setIdSach(String idSach) {
        this.idSach = idSach;
    }

    

    @Override
    public String toString() {
        return  idPhieuNhap  +"|"+ idNhaCungCap + "|" + tongTien + "|" + ngayNhap + " |" + soLuongSach + "|" + idSach + '|';
    }
}


