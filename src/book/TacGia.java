package book;

import java.time.LocalDate;

public class TacGia {
    private String idTacGia;
    private String ten;
    private LocalDate ngaySinh;
    private String queQuan;

    public TacGia() {
        this.idTacGia = "none";
        this.ten = "none";
        this.ngaySinh = LocalDate.now();
        this.queQuan = "none";
    }

    public TacGia(String idTacGia, String ten, LocalDate ngaySinh, String queQuan) {
        this.idTacGia = idTacGia;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.queQuan = "none";
    }

    public String getIdTacGia() {
        return idTacGia;
    }

    public void setIdTacGia(String idTacGia) {
        this.idTacGia = idTacGia;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
