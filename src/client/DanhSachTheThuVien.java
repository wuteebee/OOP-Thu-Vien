package client;

import execute.Menu;

public class DanhSachTheThuVien {
    public static int soLuong = 0;
    private TheThuVien[] dSTTV;

    public DanhSachTheThuVien() {
        dSTTV = new TheThuVien[0];

    }

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

    public TheThuVien chinhSuaTheThuVien(TheThuVien the) {
        System.out.println(the);
        System.out.println("Chinh sua thong tin The Thu Vien");
        the.suaThongTin(); 
        return the;
    }

    public void khoaTheThuVien() {
        System.out.println(toStringFormatted(true));
        TheThuVien the = timIDTheThuVien();
        if (the == new TheThuVien() || !the.getTrangThai()) { 
            System.out.println("Khong tim thay the hoac the da bi khoa!");
        } else {
            the.setTrangThai(false); 
            System.out.println("Da khoa the thu vien");
        }
    }

    public void moKhoaTheThuVien() {
        System.out.println(toStringFormatted(false));
        TheThuVien the = timIDTheThuVien();
        if (the == new TheThuVien() || the.getTrangThai()) { 
            System.out.println("Khong tim thay the hoac the da duoc mo khoa!");
        } else {
            the.setTrangThai(true);
            System.out.println("Da mo khoa the thu vien");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TheThuVien the : this.dSTTV) {
            if (the != null) sb.append(the).append("\n");
        }
        return sb.toString();
    }

    public String toStringFormatted(Boolean trangThai) {
        StringBuilder sb = new StringBuilder();
        for (TheThuVien the : this.dSTTV) {
            if (the.getTrangThai() && trangThai) sb.append(the).append("\n");
        }
        return sb.toString();
    }
}


