package book;

class Sach {
    protected String idSach;
    protected String ten;
    protected int soLuong;
    protected int gia;
    protected TacGia tacGia;
    protected NhaXuatBan nhaXuatBan;

    Sach() {
        idSach = "none";
        ten = "none";
        soLuong = 0;
        gia = 0;
        tacGia = new TacGia();
        nhaXuatBan = new NhaXuatBan();
    }

    Sach(String idSach, String ten, int soLuong, int gia, TacGia tacGia, NhaXuatBan nhaXuatBan) {
        this.idSach = idSach;
        this.ten = ten;
        this.soLuong = soLuong;
        this.gia = gia;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
    }

    @Override
    public String toString() {
        return idSach + " " + ten + " " + soLuong + " " + gia + " " + tacGia.getTen() + " " + nhaXuatBan.getTen();
    }
}

class DanhSachSach {
    static int soLuong = 0;
    Sach[] dSS;
}

