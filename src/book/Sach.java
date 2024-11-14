package book;

public class Sach {
    final String idSach = "S" + String.format("%03d", DanhSachSach.soLuong + 1);
    protected String ten;
    protected int soLuong;
    protected int gia;
    protected TacGia tacGia;
    protected NhaXuatBan nhaXuatBan;

    public Sach() {
        ten = "none";
        soLuong = 0;
        gia = 0;
        tacGia = new TacGia();
        nhaXuatBan = new NhaXuatBan();
    }

    public Sach(String ten, int soLuong, int gia, TacGia tacGia, NhaXuatBan nhaXuatBan) {
        this.ten = ten;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
    }

    @Override
    public String toString() {
//        return idSach + " " + ten + " " + soLuong + " " + gia + " " + tacGia.getTen() + " " + nhaXuatBan.getTen();
        return String.format("%-10s%-20s%-10s%-10d%-20s%-20s", idSach, ten, soLuong, gia, tacGia.getTen(), nhaXuatBan.getTen());
    }
}