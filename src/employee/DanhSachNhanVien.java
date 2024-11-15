package employee;

import book.TacGia;
import execute.Menu;

import java.time.LocalDate;

public class DanhSachNhanVien {
    public static int soLuong = 0;
    private NhanVien[] dSNV;

    public NhanVien[] moRongDanhSach(int soLuongNhanVien) {
        NhanVien[] newDSNV = new NhanVien[soLuong + soLuongNhanVien];
        if (soLuongNhanVien > 0) System.arraycopy(this.dSNV, 0, newDSNV, 0, soLuong);
        return this.dSNV = newDSNV;
    }

    public void themNhanVien(NhanVien NhanVien) {
        moRongDanhSach(1);
        ++soLuong;
        this.dSNV[soLuong - 1] = NhanVien;
    }

    public void themNhanVien(int soLuongNhanVien) {
        moRongDanhSach(soLuongNhanVien);
        for(int n = soLuong + soLuongNhanVien; soLuong < n; ++soLuong) {
            this.dSNV[soLuong] = new NhanVien().taoNhanVien();
        }
    }

    public NhanVien timIDNhanVien() {
        System.out.println("Nhap ID NhanVien:");
        String idNhanVien = "none";
        int idDaNhap = 0;
        try {
            idNhanVien = Menu.input.nextLine();
            idDaNhap = Integer.parseInt(idNhanVien);
        } catch (NumberFormatException nfe) {
            for (NhanVien NhanVien : this.dSNV) {
                if (NhanVien.getIDNhanVien().equalsIgnoreCase(idNhanVien))
                    return NhanVien;
            }
        }
        String idCanTim = "TG" + String.format("%03d", idDaNhap);
        for (NhanVien NhanVien : this.dSNV) {
            if (NhanVien.getIDNhanVien().equals(idCanTim)) return NhanVien;
        }
        return new NhanVien();
    }
}


