package data;
import book.*;
import client.*;
import employee.*;
import fine_ticket.*;

public class SharedData {
    
    // public static DanhSachSach dSS = new DanhSachSach();
    public static DanhSachTacGia dSTG = TestData.dataDSTG();
    public static DanhSachNhaXuatBan dSNXB = TestData.dataDSNXB();
    // public static DanhSachNhanVien dSNV = TestData.dataDSNV();
    public static DanhSachNhanVien dSNV = new DanhSachNhanVien();
    public static DanhSachTheThuVien dSTTV = TestData.dataDSTTV();
    public static DanhSachSach dSS = TestData.dataDSS();

    public static DanhSachPhieuPhat dSPP = new DanhSachPhieuPhat();
    public static DanhSachChiTietPhieuPhat dSCTPP = new DanhSachChiTietPhieuPhat();
    public static DanhSachDieuKhoanViPham dSDK = new DanhSachDieuKhoanViPham();

    public static void importData() {
        dSNV.fromFile();
    }
}

// Nguyen,Pham Tuan Khoi,1,01012005,0123456789,1
// Nguyen,Gia Hung,1,25082005,0987654321,1
// Ngo,My Tue,0,29102002,0987654321,1
