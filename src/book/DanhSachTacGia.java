package book;

import execute.*;

public class DanhSachTacGia {

    public static int soLuong = 0;
    private TacGia[] dSTG;

    public DanhSachTacGia() {
        dSTG = new TacGia[0];
    }

    public TacGia[] moRongDanhSach(int soLuongTacGia) {
        TacGia[] newDSTG = new TacGia[soLuong + soLuongTacGia];
        if (soLuongTacGia > 0) {
            System.arraycopy(this.dSTG, 0, newDSTG, 0, soLuong);
        }
        return this.dSTG = newDSTG;
    }

    public void themTacGia(TacGia tacGia) {
        moRongDanhSach(1);
        ++soLuong;
        this.dSTG[soLuong - 1] = tacGia;
    }

    public void themTacGia(int soLuongTacGia) {
        moRongDanhSach(soLuongTacGia);
        for (int n = soLuong + soLuongTacGia; soLuong < n; ++soLuong) {
            this.dSTG[soLuong] = new TacGia().taoTacGia();
        }
    }

    public TacGia timIDTacGia() {
        System.out.println("Nhap ID TacGia:");
        String idTacGia = "none";
        int idDaNhap = 0;
        try {
            idTacGia = Menu.input.nextLine();
            idDaNhap = Integer.parseInt(idTacGia);
        } catch (NumberFormatException nfe) {
            for (TacGia tacGia : this.dSTG) {
                if (tacGia.getIDTacGia().equalsIgnoreCase(idTacGia)) {
                    return tacGia;
                }
            }
        }
        String idCanTim = "TG" + String.format("%03d", idDaNhap);
        for (TacGia tacGia : this.dSTG) {
            if (tacGia.getIDTacGia().equals(idCanTim)) {
                return tacGia;
            }
        }
        return new TacGia();
    }
    public TacGia timIDTacGia(String idTacGia) {
        int idDaNhap = 0;
        try {
            idDaNhap = Integer.parseInt(idTacGia);
        } catch (NumberFormatException nfe) {
            for (TacGia tacGia : this.dSTG) {
                if (tacGia.getIDTacGia().equalsIgnoreCase(idTacGia)) {
                    return tacGia;
                }
            }
        }
        String idCanTim = "TG" + String.format("%03d", idDaNhap);
        for (TacGia tacGia : this.dSTG) {
            if (tacGia.getIDTacGia().equals(idCanTim)) {
                return tacGia;
            }
        }
        return new TacGia();
    }

    public TacGia chinhSuaTacGia(TacGia tacGia) {
        System.out.println(tacGia);
        System.out.println("Chinh sua thong tin NhanVien");
        tacGia.suaThongTin();
        return tacGia;
    }

    public void khoaTacGia() {
        System.out.println(toStringFormatted(true));
        TacGia tacGia = timIDTacGia();
        if (tacGia == null || !tacGia.getTrangThai()) {
            System.out.println("Khong tim thay Tac Gia hoac da bi khoa.");
            return;
        }

        tacGia.setTrangThai(false);
        System.out.println("Da khoa Tac Gia: " + tacGia.getTen());
    }

    public void moKhoaTacGia() {
        System.out.println(toStringFormatted(false));
        TacGia tacGia = timIDTacGia();
        if (tacGia == null || tacGia.getTrangThai()) {
            System.out.println("Khong tim thay Tac Gia hoac da duoc mo khoa.");
            return;
        }

        tacGia.setTrangThai(true);
        System.out.println("Da mo khoa Tac Gia: " + tacGia.getTen());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (TacGia tacGia : this.dSTG) {
            output.append("\n").append(tacGia);
        }
        return output.toString();
    }

    public String toStringFormatted(Boolean trangThai) {
        StringBuilder output = new StringBuilder();
        for (TacGia tacGia : this.dSTG) {
            if (tacGia.getTrangThai() && trangThai) {
                output.append("\n").append(tacGia);
            }
        }
        return output.toString();
    }
}
