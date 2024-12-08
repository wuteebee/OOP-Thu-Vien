package entry_form;
import java.util.Scanner;


public class DanhSachChiTietPhieuNhap {
    static int soLuong;
    private ChiTietPhieuNhap[] dSPN;

    public void timKiemChiTietPhieuNhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ID phieu nhap: ");
        String id = scanner.nextLine();
        boolean found = false;

        if (dSPN != null) {
            for (ChiTietPhieuNhap chiTiet : dSPN) {
                if (chiTiet.getId_CTPhieuNhap().equals(id)) {
                    System.out.println(chiTiet);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("Khong tim thay chi tiet phieu nhap voi ID: " + id);
        }
    }

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
    public void xoaChiTietPhieuNhap(int index) {
        if (dSPN != null && index >= 0 && index < dSPN.length) {
            ChiTietPhieuNhap[] newDSPN = new ChiTietPhieuNhap[dSPN.length - 1];
            for (int i = 0, j = 0; i < dSPN.length; i++) {
                if (i != index) {
                    newDSPN[j++] = dSPN[i];
                }
            }
            dSPN = newDSPN;
            soLuong--;
        }
    }
   
}




