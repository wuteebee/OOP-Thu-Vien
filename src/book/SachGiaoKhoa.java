package book;

public class SachGiaoKhoa extends Sach {
    final String idSach = "SGK" + String.format("%03d", DanhSachSach.soLuong + 1);
    private String trinhDo;
    private String linhVuc;

    public SachGiaoKhoa() {
        super();
        trinhDo = "none";
        linhVuc = "none";
    }

    public SachGiaoKhoa(String ten, int soLuong, int gia, TacGia tacGia, NhaXuatBan nhaXuatBan, String linhVuc, String trinhDo) {
        super(ten, soLuong, gia, tacGia, nhaXuatBan);
        this.linhVuc = linhVuc;
        this.trinhDo = trinhDo;
    }

    @Override
    public String toString() {
        return super.toString().replaceAll(String.format("%-10s", super.idSach), String.format("%-10s", this.idSach)) + String.format("%-20s%-15s%-15s", "Sach giao khoa", this.trinhDo, this.linhVuc);
    }
}
