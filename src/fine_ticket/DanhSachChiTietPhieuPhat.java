// xem xét lại phương thức

package fine_ticket;

public class DanhSachChiTietPhieuPhat {

    static int soLuong = 0;
    private ChiTietPhieuPhat[] dSCTPP;

//    public DanhSachChiTietPhieuPhat() {
//        dSCTPP = null;
//    }
//
//    public DanhSachChiTietPhieuPhat(int soLuong, ChiTietPhieuPhat[] dSCTPP) {
//        DanhSachChiTietPhieuPhat.soLuong += soLuong;
//        this.dSCTPP = dSCTPP;
//    }//chưa chắc
//
//    public DanhSachChiTietPhieuPhat(DanhSachChiTietPhieuPhat A) {
//        dSCTPP = A.dSCTPP;
//    }
//
//    public ChiTietPhieuPhat[] getDSCTPP() {
//        return dSCTPP;
//    }
    public DanhSachChiTietPhieuPhat() {
        dSCTPP = new ChiTietPhieuPhat[1];
    }

    public void themChiTietPhieuPhat(int soLuongPhieuPhat) {
        ChiTietPhieuPhat[] temp = new ChiTietPhieuPhat[soLuong + dSCTPP.length];
        System.arraycopy(dSCTPP, 1, temp, 1, dSCTPP.length);
        dSCTPP = temp;
        soLuong += soLuongPhieuPhat;
    }
}
