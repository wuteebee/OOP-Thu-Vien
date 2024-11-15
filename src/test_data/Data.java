package test_data;

import book.DanhSachTacGia;
import book.DanhSachNhaXuatBan;
import book.NhaXuatBan;
import book.TacGia;

import java.time.LocalDate;

public class Data {
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

    static public DanhSachNhaXuatBan dataDSXB() {
        DanhSachNhaXuatBan dSNXB = new DanhSachNhaXuatBan();
        dSNXB.themNhaXuatBan(new NhaXuatBan("Tre", "0123456789", "Ho Chi Minh"));
        dSNXB.themNhaXuatBan(new NhaXuatBan("Kim Dong", "0987654321", "Ha Noi"));
        dSNXB.themNhaXuatBan(new NhaXuatBan("Giao Duc Viet Nam", "0135792468", "Ha Noi"));
        return dSNXB;
    }
}
