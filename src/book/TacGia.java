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
}
