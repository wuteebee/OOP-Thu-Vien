package data;

import book.*;
import client.*;
import employee.*;
import java.time.LocalDate;

public class TestData {
    static public DanhSachTacGia dataDSTG() {
        DanhSachTacGia dSTG = new DanhSachTacGia();
        dSTG.themTacGia(new TacGia("Ngo Thuong Bao", LocalDate.of(2005, 7, 16), "Vinh Long"));
        dSTG.themTacGia(new TacGia("Ngo My Linh", LocalDate.of(2008, 2 ,25), "Vinh Long"));
        dSTG.themTacGia(new TacGia("Phung Thuong Dat", LocalDate.of(2005, 7, 24), "Long An"));
        dSTG.themTacGia(new TacGia("Tran Bao Nhi", LocalDate.of(2005, 12, 2), "Ho Chi Minh"));
        dSTG.themTacGia(new TacGia("Phan Le Phuc Nguyen", LocalDate.of(2005, 2, 18), "Long An"));
        dSTG.themTacGia(new TacGia("Nguy Ai Thanh", LocalDate.of(2005, 10, 5), "Tien Giang"));
        return dSTG;
    }

    static public DanhSachNhaXuatBan dataDSNXB() {
        DanhSachNhaXuatBan dSNXB = new DanhSachNhaXuatBan();
        dSNXB.themNhaXuatBan(new NhaXuatBan("Tre", "0123456789", "Ho Chi Minh"));
        dSNXB.themNhaXuatBan(new NhaXuatBan("Kim Dong", "0987654321", "Ha Noi"));
        dSNXB.themNhaXuatBan(new NhaXuatBan("Giao Duc Viet Nam", "0135792468", "Ha Noi"));
        return dSNXB;
    }

    static public DanhSachNhanVien dataDSNV() {
        DanhSachNhanVien dSNV = new DanhSachNhanVien();
        dSNV.themNhanVien(new NhanVien("Nguyen", "Pham Tuan Khoi", true, LocalDate.of(2005, 1, 1), "0123456789"));
        dSNV.themNhanVien(new NhanVien("Nguyen", "Gia Hung", true, LocalDate.of(2005, 8, 25), "0987654321"));
        dSNV.themNhanVien(new NhanVien("Ngo", "My Tue", false, LocalDate.of(2002, 10, 29), "0987654321"));
        return dSNV;
    }

    static public DanhSachTheThuVien dataDSTTV() {
        DanhSachTheThuVien dSTTV = new DanhSachTheThuVien();
        dSTTV.themTheThuVien(new TheThuVien("a", "a", true, LocalDate.now(), "0123456789"));
        dSTTV.themTheThuVien(new TheThuVien("b", "b", false, LocalDate.now(), "0123456789"));
        dSTTV.themTheThuVien(new TheThuVien("c", "c", true, LocalDate.now(), "0123456789"));
        return dSTTV;
    }

    static public DanhSachSach dataDSS() {
        DanhSachSach dSS = new DanhSachSach();
        dSS.themSach(new Sach("a", 300, 1000000, SharedData.dSTG.timIDTacGia("1"), SharedData.dSNXB.timIDNhaXuatBan("1")));
        dSS.themSach(new SachGiaoKhoa("b", 200, 800000, SharedData.dSTG.timIDTacGia("1"), SharedData.dSNXB.timIDNhaXuatBan("1"), "bb", "bb"));
        dSS.themSach(new SachThamKhao("c", 400, 1200000, SharedData.dSTG.timIDTacGia("1"), SharedData.dSNXB.timIDNhaXuatBan("1"), "cc", "cc"));
        dSS.themSach(new Sach("d", 150, 600000, SharedData.dSTG.timIDTacGia("1"), SharedData.dSNXB.timIDNhaXuatBan("1")));
        dSS.themSach(new SachThamKhao("e", 250, 900000, SharedData.dSTG.timIDTacGia("1"), SharedData.dSNXB.timIDNhaXuatBan("1"), "ee", "ee"));
        dSS.themSach(new SachGiaoKhoa("f", 350, 1100000, SharedData.dSTG.timIDTacGia("1"), SharedData.dSNXB.timIDNhaXuatBan("1"), "ff", "ff"));


        return dSS;
    }
}
