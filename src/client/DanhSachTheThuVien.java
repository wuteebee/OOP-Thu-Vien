package client;

import book.TacGia;
import execute.Menu;
import java.time.LocalDate;

public class DanhSachTheThuVien {
    public static int soLuong = 0;
    private TheThuVien[] dSTTV;

    public TheThuVien[] moRongDanhSach(int soLuongTheThuVien) {
        TheThuVien[] newdSTTV = new TheThuVien[soLuong + soLuongTheThuVien];
        if (soLuongTheThuVien > 0) System.arraycopy(this.dSTTV, 0, newdSTTV, 0, soLuong);
        return this.dSTTV = newdSTTV;
    }

    public void themTheThuVien(TheThuVien theThuVien) {
        moRongDanhSach(1);
        ++soLuong;
        this.dSTTV[soLuong - 1] = theThuVien;
    }

    public void themTheThuVien(int soLuongTheThuVien) {
        moRongDanhSach(soLuongTheThuVien);
        for(int n = soLuong + soLuongTheThuVien; soLuong < n; ++soLuong) {
            this.dSTTV[soLuong] = new TheThuVien().taoTheThuVien();
        }
    }

    public TheThuVien timIDTheThuVien() {
        System.out.println("Nhap ID TheThuVien:");
        String idTheThuVien = "none";
        int idDaNhap = 0;
        try {
            idTheThuVien = Menu.input.nextLine();
            idDaNhap = Integer.parseInt(idTheThuVien);
        } catch (NumberFormatException nfe) {
            for (TheThuVien theThuVien : this.dSTTV) {
                if (theThuVien.getIDTheThuVien().equalsIgnoreCase(idTheThuVien))
                    return theThuVien;
            }
        }
        String idCanTim = "TG" + String.format("%03d", idDaNhap);
        for (TheThuVien theThuVien : this.dSTTV) {
            if (theThuVien.getIDTheThuVien().equals(idCanTim)) return theThuVien;
        }
        return new TheThuVien();
    }
}


