package data;
import book.*;
import employee.*;
import fine_ticket.*;

public class SharedData {
    public static DanhSachSach dSS = new DanhSachSach();
    public static DanhSachTacGia dSTG = TestData.dataDSTG();
    public static DanhSachNhaXuatBan dSNXB = TestData.dataDSNXB();
    public static DanhSachNhanVien dSNV = TestData.dataDSNV();

    public static DanhSachPhieuPhat dSPP = new DanhSachPhieuPhat();
    public static DanhSachChiTietPhieuPhat dSCTPP = new DanhSachChiTietPhieuPhat();
    public static DanhSachDieuKhoanViPham dSDK = new DanhSachDieuKhoanViPham();
}
