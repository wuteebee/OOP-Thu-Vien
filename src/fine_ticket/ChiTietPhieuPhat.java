package fine_ticket;

public class ChiTietPhieuPhat {
    // ý tưởng:
    final String idPhieuPhat = "PP" + String.format("%3d", DanhSachPhieuPhat.soLuong);
    private String idSach;
    private int tinhTrangSach;
    private int tienPhat;
    private int idDieuKhoan;

    public ChiTietPhieuPhat() {
        idSach = "none";
        tinhTrangSach = 0;
        tienPhat = 0;
        idDieuKhoan = 0;
    }

    public ChiTietPhieuPhat(String idSach, int tinhTrangSach, int tienPhat, int idDieuKhoan) {
        this.idSach = idSach;
        this.tinhTrangSach = tinhTrangSach;
        this.tienPhat = tienPhat;
        this.idDieuKhoan = idDieuKhoan;
    }

    public ChiTietPhieuPhat(ChiTietPhieuPhat A) {
        idSach = A.idSach;
        tinhTrangSach = A.tinhTrangSach;
        tienPhat = A.tienPhat;
        idDieuKhoan = A.idDieuKhoan;
    }

    public String getIDChiTietPhieuPhat() {
        return idPhieuPhat;
    }

    public String getIDSach() {
        return idSach;
    }

    public int getTinhTrangSach() {
        return tinhTrangSach;
    }

    public int getTienPhat() {
        return tienPhat;
    }

    public int getIDDieuKhoan() {
        return idDieuKhoan;
    }

    public void setIDSach(String id) {
        idSach = id;
    }

    public void setTinhTrangSach(int x) {
        tinhTrangSach = x;
    }

    public void setTienPhat(int x) {
        tienPhat = x;
    }

    public void setidDieuKhoan(int x) {
        idDieuKhoan = x;
    }

	@Override 
    public String toString() {
        return String.format("%-10s%-9s%,-5d%-15s%s\n", idPhieuPhat, idSach, tinhTrangSach, String.format("%,d", tienPhat) + " dong", "Dieu " + idDieuKhoan);
    }
}
