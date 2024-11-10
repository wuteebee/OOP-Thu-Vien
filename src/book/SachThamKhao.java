package book;

public class SachThamKhao extends Sach {
    private String chuyenNganh;
    private String deTai;

    public SachThamKhao() {
        super();
        chuyenNganh = "none";
        deTai = "none";
    }

    public SachThamKhao(String idSach, String ten, int soLuong, int gia, TacGia tacGia, NhaXuatBan nhaXuatBan, String chuyenNganh, String deTai) {
        super(idSach, ten, soLuong, gia, tacGia, nhaXuatBan);
        this.chuyenNganh = chuyenNganh;
        this.deTai = deTai;
    }
}
