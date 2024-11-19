package entry_form;

public class DanhSachChiTietPhieuNhap {
    static int soLuong;
    private ChiTietPhieuNhap[] dSPN;

     public void themChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
        if (dSPN == null) {
            dSPN = new ChiTietPhieuNhap[1];
            dSPN[0] = chiTietPhieuNhap;
        } else {
            ChiTietPhieuNhap[] newDSPN = new ChiTietPhieuNhap[dSPN.length + 1];
            System.arraycopy(dSPN, 0, newDSPN, 0, dSPN.length);
            newDSPN[dSPN.length] = chiTietPhieuNhap;
            dSPN = newDSPN;
        }
        soLuong++;
    }





    
}




