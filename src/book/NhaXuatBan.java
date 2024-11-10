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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getIdNhaXuatBan() {
        return idNhaXuatBan;
    }

    public void setIdNhaXuatBan(String idNhaXuatBan) {
        this.idNhaXuatBan = idNhaXuatBan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
