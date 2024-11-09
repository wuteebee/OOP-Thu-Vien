package book;

public class NhaXuatBan {
    private String idNhaXuatBan;
    private String ten;
    private String soDienThoai;
    private String diaChi;

    public NhaXuatBan() {
        this.idNhaXuatBan = "none";
        this.ten = "none";
        this.soDienThoai = "none";
        this.diaChi = "none";
    }

    public NhaXuatBan(String idNhaXuatBan, String ten, String soDienThoai, String diaChi) {
        this.idNhaXuatBan = idNhaXuatBan;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }
}
