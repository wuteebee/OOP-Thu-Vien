package book;

import execute.Menu;

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

    public SachGiaoKhoa(SachGiaoKhoa sachGiaoKhoa) {
        super(sachGiaoKhoa);
        this.trinhDo = sachGiaoKhoa.trinhDo;
        this.linhVuc = sachGiaoKhoa.linhVuc;
    }

    public SachGiaoKhoa(Sach sach) {
        super(sach);
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    @Override
    public SachGiaoKhoa taoSach() {
        SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa(super.taoSach());
        System.out.println("Nhap vao trinh do cua SachGiaoKhoa:");
        sachGiaoKhoa.setTrinhDo(Menu.input.nextLine());
        System.out.println("Nhap vao linh vuc cua SachGiaoKhoa:");
        sachGiaoKhoa.setLinhVuc(Menu.input.nextLine());
        return sachGiaoKhoa;
    }

    @Override
    public String toString() {
        return super.toString().replaceAll(String.format("%-10s", super.idSach), String.format("%-10s", this.idSach)) + String.format("%-20s%-15s%-15s", "Sach giao khoa", this.trinhDo, this.linhVuc);
    }
}
