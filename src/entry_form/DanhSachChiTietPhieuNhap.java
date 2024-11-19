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

    public void xoaChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
        if (dSPN == null || soLuong == 0) {
            return;
        }
        ChiTietPhieuNhap[] newDSPN = new ChiTietPhieuNhap[dSPN.length - 1];
        int index = 0;
        for (ChiTietPhieuNhap item : dSPN) {
            if (!item.equals(chiTietPhieuNhap)) {
                if (index < newDSPN.length) {
                    newDSPN[index++] = item;
                }
            }
        }
        dSPN = newDSPN;
        soLuong--;
    }
}




