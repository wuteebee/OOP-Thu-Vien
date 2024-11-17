package data;
import book.*;
import employee.*;

public class SharedData {
    public static DanhSachSach dSS = new DanhSachSach();
    public static DanhSachTacGia dSTG = TestData.dataDSTG();
    public static DanhSachNhaXuatBan dSNXB = TestData.dataDSNXB();
    public static DanhSachNhanVien dSNV = TestData.dataDSNV();
}
