package data;
import book.*;
import client.*;
import employee.*;
import fine_ticket.*;

public class SharedData {
    // public static DanhSachTacGia dSTG = TestData.dataDSTG();
    public static DanhSachTacGia dSTG = new DanhSachTacGia();
    // public static DanhSachNhaXuatBan dSNXB = TestData.dataDSNXB();
    public static DanhSachNhaXuatBan dSNXB = new DanhSachNhaXuatBan();
    // public static DanhSachNhanVien dSNV = TestData.dataDSNV();
    public static DanhSachNhanVien dSNV = new DanhSachNhanVien();
    // public static DanhSachTheThuVien dSTTV = TestData.dataDSTTV();
    public static DanhSachTheThuVien dSTTV = new DanhSachTheThuVien();
    public static DanhSachSach dSS = new DanhSachSach();

    public static DanhSachPhieuPhat dSPP = new DanhSachPhieuPhat();
    public static DanhSachChiTietPhieuPhat dSCTPP = new DanhSachChiTietPhieuPhat();
    public static DanhSachDieuKhoanViPham dSDK = new DanhSachDieuKhoanViPham();

    public static void importData() {
        dSNV.readFile();
        dSTTV.readFile();
        dSNXB.readFile();
        dSTG.readFile();
        dSS.readFile();
        dSPP.readFile();
        dSCTPP.readFile();
        dSDK.readFile();
    }

    public static void capNhatDuLieu() {
        dSNV.writeFile();
        dSTTV.writeFile();
        dSNXB.writeFile();
        dSTG.writeFile();
        dSS.writeFile();
        dSPP.writeFile();
        dSCTPP.writeFile();
    }
}

// Nguyen,Pham Tuan Khoi,1,01012005,0123456789,1
// Nguyen,Gia Hung,1,25082005,0987654321,1
// Ngo,My Tue,0,29102002,0987654321,1

// a,a,1,08122024,0123456789,1
// b,b,0,08122024,0123456789,1
// c,c,1,08122024,0123456789,1

// Tre,0123456789,Ho Chi Minh,1,
// Kim Dong,0987654321,Ha Noi,1,
// Giao Duc Viet Nam,0135792468,Ha Noi,1,

// GK,b,200,800000,TG001,NXB001,1,bb,bb
// TK,c,400,1200000,TG001,NXB001,1,cc,cc
// TK,e,250,900000,TG001,NXB001,1,ee,ee
// GK,f,350,1100000,TG001,NXB001,1,ff,ff