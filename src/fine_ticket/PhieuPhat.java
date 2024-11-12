// tạo phiếu mượn => tạo chi tiết phiếu mượn => tạo phiếu phạt => tạo chi tiết phiếu phạt

package fine_ticket;

public class PhieuPhat {
    final String idPhieuPhat = "PP" + String.format("%03d", DanhSachPhieuPhat.soLuong);
    private String idPhieuMuon;
    private int tongTienPhat;

    public PhieuPhat() {
        idPhieuMuon = "none";
        tongTienPhat = 0;
    }

    public PhieuPhat(String idPhieuMuon, int tongTienPhat) {
        this.idPhieuMuon = idPhieuMuon;
        this.tongTienPhat = tongTienPhat;
    }

    public PhieuPhat(PhieuPhat A) {     
        this.idPhieuMuon = A.getIDPhieuMuon();
        this.tongTienPhat = A.getTongTienPhat();
    }

    public String getIDPhieuPhat() {
        return idPhieuPhat;
    }

    public String getIDPhieuMuon() {
        return idPhieuMuon;
    }

    public int getTongTienPhat() {
        return tongTienPhat;
    }

    public void setIDPhieuMuon(String id) {
        idPhieuMuon = id;
    }

    public void setTienPhat(int tienPhat) {
        tongTienPhat = tienPhat;
    }

	@Override 
    public String toString() {
        return String.format("%-15s%-15s%,d dong\n", idPhieuPhat, idPhieuMuon, tongTienPhat);
    }
}
