// package entry_form;

// public class DanhSachChiTietPhieuNhap {
//     static int soLuong;
//     private ChiTietPhieuNhap[] dSPN;

//     public void themChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
//         if (dSPN == null) {
//             dSPN = new ChiTietPhieuNhap[1];
//             dSPN[0] = chiTietPhieuNhap;
//         } else {
//             ChiTietPhieuNhap[] newDSPN = new ChiTietPhieuNhap[dSPN.length + 1];
//             System.arraycopy(dSPN, 0, newDSPN, 0, dSPN.length);
//             newDSPN[dSPN.length] = chiTietPhieuNhap;
//             dSPN = newDSPN;
//         }
//         soLuong++;
//     }
//     public void xoaChiTietPhieuNhap(int index) {
//         if (dSPN != null && index >= 0 && index < dSPN.length) {
//             ChiTietPhieuNhap[] newDSPN = new ChiTietPhieuNhap[dSPN.length - 1];
//             for (int i = 0, j = 0; i < dSPN.length; i++) {
//                 if (i != index) {
//                     newDSPN[j++] = dSPN[i];
//                 }
//             }
//             dSPN = newDSPN;
//             soLuong--;
//         }
//     }
    
// }




