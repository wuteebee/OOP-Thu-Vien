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

    @Override
    public String getIDSach() {
        return idSach;
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
    public void suaThongTin() {
        super.suaThongTin();

       
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("NHap trinh do cua sach giao khoa:");
                setTrinhDo(Menu.input.nextLine());

                System.out.println("Nhap linh vuc cua sach giao khoa:");
                setLinhVuc(Menu.input.nextLine());

                validInput = true; 
            } catch (Exception e) {
                System.out.println("Nhap sai thong tin vui long nhap la!.");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s", getIDSach()) + String.format("%-30s%-10s%-10d%-20s%-20s", ten, tonKho, gia, tacGia.getTen(), nhaXuatBan.getTen()) + String.format("%-15s%-15s", this.trinhDo, this.linhVuc);
    }
}
