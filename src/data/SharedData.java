package data;
import book.*;
import borrow_ticket.*;
import entry_form.*;
import fine_ticket.*;
import users.*;

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

    public static DanhSachPhieuNhap dSPN = new DanhSachPhieuNhap();

    public static DanhSachPhieuMuon dSPM = new DanhSachPhieuMuon();
    public static DanhSachChiTietPhieuMuon dSCTM = new DanhSachChiTietPhieuMuon();

    public static void importData() {
        // nhân viên khách hàng sách
        dSNV.readFile();
        dSTTV.readFile();
        dSNXB.readFile();
        dSTG.readFile();
        dSS.readFile();
        // phiéu mượn 
        dSPM.readFile();
        // phiếu phạt 
        dSDK.readFile();
        dSPP.readFile();
        dSCTPP.readFile();
        // phiếu nhập
        dSPN.readFile();


    }

    public static void capNhatDuLieu() {
        // nhân viên khách hàng sách
        dSNV.writeFile();
        dSTTV.writeFile();
        dSNXB.writeFile();
        dSTG.writeFile();
        dSS.writeFile();
        // phiếu mượn 
        // dSPM.writeFile();
        // phiếu phạt
        dSPP.writeFile();
        dSCTPP.writeFile();
        // phiếu nhập
        dSPN.writeFile();
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

// GK,Sach Giao Khoa Toan 1,100,50000,TG001,NXB001,1,Cao Dang,Toan
// GK,Sach Giao Khoa Van 1,150,60000,TG002,NXB004,1,Cao Dang,Văn
// TK,Sach Tham Khao Toan Cao Cap,50,150000,TG001,NXB002,1,Khoa Hoc,Xac Suat
// TK,Sach Tham Khao Van Hoc Nang Cao,30,200000,TG002,NXB004,1,Khoa Hoc,Viet Van
// GK,Sach Giao Khoa Ly 1,200,55000,TG003,NXB003,1,Cao Dang,Lý
// TK,Sach Tham Khao Ly Thuyet,25,250000,TG003,NXB001,1,Khoa Hoc,Ly Thuyet
// GK,Sach Giao Khoa Hoa 1,120,58000,TG004,NXB001,1,Cao Dang,Hoa
// TK,Sach Tham Khao Hoa Hoc Nang Cao,60,180000,TG004,NXB004,1,Khoa Hoc,Hoa Hoc
// GK,Sach Giao Khoa Su 1,80,62000,TG005,NXB001,1,Cao Dang,Su
// TK,Sach Tham Khao Su Hoc Nang Cao,40,220000,TG005,NXB002,1,Khoa Hoc,Lich Su
// GK,Sach Giao Khoa Toan 2,120,55000,TG001,NXB003,1,Cao Dang,Toan

// GK,Sach Giao Khoa Van 2,130,58000,TG002,NXB005,1,Cao Dang,Văn
// TK,Sach Tham Khao Toan Nang Cao,70,200000,TG001,NXB003,1,Khoa Hoc,Xac Suat
// TK,Sach Tham Khao Van Hoc Nang Cao 2,40,250000,TG002,NXB004,1,Khoa Hoc,Viet Van
// GK,Sach Giao Khoa Ly 2,90,60000,TG003,NXB002,1,Cao Dang,Ly
// TK,Sach Tham Khao Ly Nang Cao,60,220000,TG003,NXB005,1,Khoa Hoc,Ly Thuyet
// GK,Sach Giao Khoa Hoa 2,110,62000,TG004,NXB005,1,Cao Dang,Hoa
// TK,Sach Tham Khao Hoa Hoc Nang Cao 2,80,210000,TG004,NXB002 Hoi Nha Van ,1,Khoa Hoc,Hoa Hoc
// GK,Sach Giao Khoa Su 2,75,64000,TG005,NXB003,Cao Dang,Sử
// TK,Sach Tham Khao Su Hoc Nang Cao 2,50,230000,TG005,NXB001,1,Khoa Hoc,Lich Su

// GK,Toan 1,100,50000,TG001,NXB001,1,Cap 1,Toan
// GK,Van 1,150,60000,TG002,NXB004,1,Cao Dang,Van
// TK,Toan Cao Cap,50,150000,TG001,NXB002,1,Khoa Hoc,Xac Suat
// TK,Van Hoc Nang Cao,30,200000,TG002,NXB004,1,Khoa Hoc,Viet Van
// GK,Ly 1,200,55000,TG003,NXB003,1,Cap 1,Ly
// TK,Ly Thuyet,25,250000,TG003,NXB001,1,Khoa Hoc,Ly Thuyet
// GK,Hoa 1,120,58000,TG004,NXB001,1,Cap 3,Hoa
// TK,Hoa Hoc Nang Cao,60,180000,TG004,NXB004,1,Khoa Hoc,Hoa Hoc
// GK,Su 1,80,62000,TG005,NXB001,1,Cap 2,Su
// TK,Su Hoc Nang Cao,40,220000,TG005,NXB002,1,Khoa Hoc,Lich Su
// GK,Toan 2,120,55000,TG001,NXB003,1,Cap 3,Toan
// GK,Van 2,130,58000,TG002,NXB005,1,Cao Dang,Van
// TK,Toan Nang Cao,70,200000,TG001,NXB003,1,Khoa Hoc,Xac Suat
// TK,Van Hoc Nang Cao 2,40,250000,TG002,NXB004,1,Khoa Hoc,Viet Van
// GK,Ly 2,90,60000,TG003,NXB002,1,Cap 3,Ly
// TK,Ly Nang Cao,60,220000,TG003,NXB005,1,Khoa Hoc,Ly Thuyet
// GK,Hoa 2,110,62000,TG004,NXB005,1,Cap 3,Hoa
// TK,Hoa Hoc Nang Cao 2,80,210000,TG004,NXB002,1,Khoa Hoc,Hoa Hoc
// TK,Sach Tham Khao Toan Nang Cao,50,180000,TG001,NXB001,1,Xa Hoi,Xac Suat
// TK,Sach Tham Khao Van Hoc Nang Cao,60,200000,TG002,NXB002,1,Xa Hoi,Viet Van
// TK,Sach Tham Khao Ly Thuyet Cao,70,190000,TG003,NXB003,1,Xa Hoi,Ly Thuyet
// TK,Sach Tham Khao Hoa Hoc Nang Cao 2,80,210000,TG004,NXB004,1,Xa Hoi,Hoa Hoc
// TK,Sach Tham Khao Su Hoc Nang Cao,90,220000,TG005,NXB005,1,Xa Hoi,Lich Su
// TK,Sach Tham Khao Dia Ly Nang Cao,40,240000,TG006,NXB001,1,Xa Hoi,Dia Ly
// TK,Sach Tham Khao Toan 12,30,250000,TG007,NXB002,1,Xa Hoi,Xac Suat
// TK,Sach Tham Khao Van 12,20,260000,TG008,NXB003,1,Xa Hoi,Viet Van
// TK,Sach Tham Khao Ly 12,10,270000,TG009,NXB004,1,Xa Hoi,Ly Thuyet
// TK,Sach Tham Khao Hoa 12,15,280000,TG010,NXB005,1,Xa Hoi,Hoa Hoc


// GK,Toan 1,100,50000,TG001,NXB001,1,Cap 1,Toan
// TK,Hoa Hoc Nang Cao 2,80,210000,TG004,NXB004,1,Xa Hoi,Hoa Hoc
// TK,Su Hoc Nang Cao,90,220000,TG005,NXB005,1,Xa Hoi,Lich Su
// GK,Van 1,150,60000,TG008,NXB004,1,Cao Dang,Van
// TK,Toan Cao Cap,50,150000,TG001,NXB002,1,Khoa Hoc,Xac Suat
// TK,Van Hoc Nang Cao,30,200000,TG002,NXB004,1,Khoa Hoc,Viet Van
// GK,Ly 1,200,55000,TG008,NXB003,1,Cap 1,Ly
// TK,Ly Thuyet,25,250000,TG003,NXB001,1,Khoa Hoc,Ly Thuyet
// GK,Hoa 1,120,58000,TG004,NXB001,1,Cap 3,Hoa
// TK,Hoa Hoc Nang Cao,60,180000,TG004,NXB004,1,Khoa Hoc,Hoa Hoc
// GK,Su 1,80,62000,TG005,NXB001,1,Cap 2,Su
// TK,Su Hoc Nang Cao,40,220000,TG005,NXB002,1,Khoa Hoc,Lich Su
// GK,Toan 2,120,55000,TG010,NXB003,1,Cap 3,Toan
// TK,Dia Ly Nang Cao,40,240000,TG006,NXB001,1,Xa Hoi,Dia Ly
// TK,Toan 12,30,250000,TG007,NXB002,1,Xa Hoi,Xac Suat
// TK,Van 12,20,260000,TG008,NXB003,1,Xa Hoi,Viet Van
// TK,Ly 12,10,270000,TG009,NXB004,1,Xa Hoi,Ly Thuyet
// TK,Van Hoc Nang Cao,60,200000,TG006,NXB002,1,Xa Hoi,Viet Van
// TK,Ly Thuyet Cao,70,190000,TG009,NXB003,1,Xa Hoi,Ly Thuyet
// GK,Van 2,130,58000,TG002,NXB005,1,Cao Dang,Van
// TK,Toan Nang Cao,70,200000,TG001,NXB003,1,Khoa Hoc,Xac Suat
// TK,Van Hoc Nang Cao 2,40,250000,TG007,NXB004,1,Khoa Hoc,Viet Van
// GK,Ly 2,90,60000,TG003,NXB007,1,Cap 3,Ly
// TK,Ly Nang Cao,60,220000,TG003,NXB005,1,Khoa Hoc,Ly Thuyet
// GK,Hoa 2,110,62000,TG004,NXB005,1,Cap 3,Hoa
// TK,Hoa Hoc Nang Cao 2,80,210000,TG004,NXB002,1,Khoa Hoc,Hoa Hoc
// TK,Toan Nang Cao,50,180000,TG006,NXB001,1,Xa Hoi,Xac Suat
// TK,Hoa 12,15,280000,TG010,NXB005,1,Xa Hoi,Hoa Hoc