package book;

public class SachGiaoKhoa extends Sach{
    private String trinhDo;
    private String linhVuc;

    public SachGiaoKhoa() {
        super();
        trinhDo = "none";
        linhVuc = "none";
    }

    public SachGiaoKhoa(String idSach, String ten, int soLuong, int gia, TacGia tacGia, NhaXuatBan nhaXuatBan, String linhVuc, String trinhDo) {
        super(idSach, ten, soLuong, gia, tacGia, nhaXuatBan);
        this.linhVuc = linhVuc;
        this.trinhDo = trinhDo;
    }
}
