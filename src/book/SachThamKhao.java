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

    @Override
    public String getIDSach() {
        return idSach;
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
    public void suaThongTin() {
        super.suaThongTin(); 

        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Nhập chuyên ngành của Sách Tham Khảo:");
                setChuyenNganh(Menu.input.nextLine());

                System.out.println("Nhập đề tài của Sách Tham Khảo:");
                setDeTai(Menu.input.nextLine());

                validInput = true; 
            } catch (Exception e) {
                System.out.println("Nhập sai thông tin! Vui lòng nhập lại.");
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%-10s", getIDSach()) + String.format("%-30s%-10s%-10d%-20s%-20s", ten, tonKho, gia, tacGia.getTen(), nhaXuatBan.getTen()) + String.format("%-15s%-15s", this.chuyenNganh, this.deTai);
    
    }

    public String toStringToFile() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", "TK", ten, tonKho, gia, tacGia.getIDTacGia(), nhaXuatBan.getIDNhaXuatBan(), (trangThai ? "1" : "0"), chuyenNganh, deTai);
    }
}
