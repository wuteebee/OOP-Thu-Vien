package entry_form;

import java.time.LocalDate;

public class DanhSachPhieuNhap {
    static int soLuong;
    private DanhSachPhieuNhap[] dSPN;

public void themPhieuNhap(DanhSachPhieuNhap phieuNhap) {
        if (soLuong == dSPN.length) {//kiểm tra mảng đầy chưa
            DanhSachPhieuNhap[] newDSPN = new DanhSachPhieuNhap[dSPN.length * 2];
            System.arraycopy(dSPN, 0, newDSPN, 0, dSPN.length);
            dSPN = newDSPN;
        }
        dSPN[soLuong++] = phieuNhap;
    }

    public void xoaPhieuNhap(int index) {
        if (index < 0 || index >= soLuong) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < soLuong - 1; i++) {
            dSPN[i] = dSPN[i + 1];
        }
        dSPN[--soLuong] = null;
    }


}
