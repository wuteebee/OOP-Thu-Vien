// package entry_form;

// import java.util.Date;

// public class ChiTietPhieuNhap {
//     final String idPhieuNhap = "PN" + String.format("%03d", danhSachPhieuNhap.);
//     private String idSach;
//     private int soLuong;
//     private int thanhTien;
//     private Date ngayNhap;
//     private String idNhaXuatBan;

//     public ChiTietPhieuNhap() {
//         this.idSach = "non";
//         this.soLuong = 0;
//         this.thanhTien = 0;
//         this.ngayNhap = new Date();
//         this.idNhaXuatBan = "non";
//     }

//     public ChiTietPhieuNhap(String idSach, int soLuong, int thanhTien, Date ngayNhap, String idNhaXuatBan) {
//         this.idSach = idSach;
//         this.soLuong = soLuong;
//         this.thanhTien = thanhTien;
//         this.ngayNhap = ngayNhap;
//         this.idNhaXuatBan = idNhaXuatBan;
//     }

//     public ChiTietPhieuNhap(ChiTietPhieuNhap chiTietPhieuNhap) {
//         this.idSach = chiTietPhieuNhap.idSach;
//         this.soLuong = chiTietPhieuNhap.soLuong;
//         this.thanhTien = chiTietPhieuNhap.thanhTien;
//         this.ngayNhap = chiTietPhieuNhap.ngayNhap;
//         this.idNhaXuatBan = chiTietPhieuNhap.idNhaXuatBan;
//     }

//     public String getIdPhieuNhap() {
//         return idPhieuNhap;
//     }

//     public String getIdSach() {
//         return idSach;
//     }

//     public int getSoLuong() {
//         return soLuong;
//     }

//     public int getThanhTien() {
//         return thanhTien;
//     }

//     public Date getNgayNhap() {
//         return ngayNhap;
//     }

//     public String getIdNhaXuatBan() {
//         return idNhaXuatBan;
//     }

//     public void setIdSach(String idSach) {
//         this.idSach = idSach;
//     }

//     public void setSoLuong(int soLuong) {
//         this.soLuong = soLuong;
//     }

//     public void setThanhTien(int thanhTien) {
//         this.thanhTien = thanhTien;
//     }

//     public void setNgayNhap(Date ngayNhap) {
//         this.ngayNhap = ngayNhap;
//     }

//     public void setIdNhaXuatBan(String idNhaXuatBan) {
//         this.idNhaXuatBan = idNhaXuatBan;
//     }
// }