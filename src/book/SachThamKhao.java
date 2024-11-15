package book;


import execute.Menu;

public class SachThamKhao extends Sach {
    final String idSach = "STK" + String.format("%03d", DanhSachSach.soLuong + 1);;
    private String chuyenNganh;
    private String deTai;

    public SachThamKhao() {
        super();
        chuyenNganh = "none";
        deTai = "none";
    }

    public SachThamKhao(String ten, int soLuong, int gia, TacGia tacGia, NhaXuatBan nhaXuatBan, String chuyenNganh, String deTai) {
        super(ten, soLuong, gia, tacGia, nhaXuatBan);
        this.chuyenNganh = chuyenNganh;
        this.deTai = deTai;
    }

    public SachThamKhao(SachThamKhao sachThamKhao) {
        super(sachThamKhao);
        this.chuyenNganh = sachThamKhao.chuyenNganh;
        this.deTai = sachThamKhao.deTai;
    }

    public SachThamKhao(Sach sach) {
        super(sach);
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public void setDeTai(String deTai) {
        this.deTai = deTai;
    }

    @Override
    public SachThamKhao taoSach() {
        SachThamKhao sachThamKhao = new SachThamKhao(super.taoSach());
        System.out.println("Nhap vao chuyen nganh cua SachThamKhao:");
        sachThamKhao.setChuyenNganh(Menu.input.nextLine());
        System.out.println("Nhap vao de tai cua SachThamKhao:");
        sachThamKhao.setDeTai(Menu.input.nextLine());
        return sachThamKhao;
    }

    @Override
    public String toString() {
        return super.toString().replaceAll(String.format("%-10s", super.idSach), String.format("%-10s", this.idSach)) + String.format("%-20s%-15s%-15s", "Sach tham khao", this.chuyenNganh, this.deTai);
    }
}
