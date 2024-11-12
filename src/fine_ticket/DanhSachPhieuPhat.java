package fine_ticket;

public class DanhSachPhieuPhat {

    static int soLuong = 0;
    private PhieuPhat[] dSPP;

    public DanhSachPhieuPhat() {
        this.dSPP = new PhieuPhat[1];
    }

    public void themPhieuPhat(PhieuPhat phieuPhat) {
        PhieuPhat[] temp = new PhieuPhat[soLuong + 1];
        System.arraycopy(dSPP, 1, temp, 1, soLuong);
        temp[soLuong] = phieuPhat;
        ++soLuong;
        this.dSPP = temp;
    }

    public void themPhieuPhat() {

    }

    public void themPhieuPhat(int n) {
        while(n-- != 0) {
            themPhieuPhat();
        }
    }

//    public DanhSachPhieuPhat() {        // sau khi suy nghĩ lại thì t nghĩ nên sửa lại khúc này một chút
//        dSPP = null;
//    }
//
//    public DanhSachPhieuPhat(int soLuong, PhieuPhat[] dSPP) {
//        DanhSachPhieuPhat.soLuong += soLuong;
//        this.dSPP = dSPP;
//    }   //  chưa chắc => cái này t nghĩ là nếu truyền vào phiếu phạt thì nó sẽ thêm phiếu phạt vào danh sách?
//        // hoặc là danh sách cũng được, kiểu nó sẽ có hai phương thức ấy
//
//    public DanhSachPhieuPhat(DanhSachPhieuPhat A) {
//        dSPP = A.dSPP;
//    }
//
//    public  int getSoLuong() {
//        return DanhSachPhieuPhat.soLuong;
//    }
//
//    public void setDSPP(int n, PhieuPhat phieuPhat) {
//
//    }
//
//    public PhieuPhat[] getDSPP() {
//        return dSPP;
//    }
}
