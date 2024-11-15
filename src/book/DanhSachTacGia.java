package book;

import execute.*;
import java.util.InputMismatchException;

public class DanhSachTacGia {
    public static int soLuong = 0;
    private TacGia[] dSTG;

    public DanhSachTacGia() {
        dSTG = new TacGia[0];
    }

    public TacGia[] moRongDanhSach(int soLuongTacGia) {
        TacGia[] newDSTG = new TacGia[soLuong + soLuongTacGia];
        if (soLuongTacGia > 0) System.arraycopy(this.dSTG, 0, newDSTG, 0, soLuong);
        return this.dSTG = newDSTG;
    }

    public void themTacGia(TacGia tacGia) {
        moRongDanhSach(1);
        ++soLuong;
        this.dSTG[soLuong - 1] = tacGia;
    }

    public void themTacGia(int soLuongTacGia) {
        moRongDanhSach(soLuongTacGia);
        for(int n = soLuong + soLuongTacGia; soLuong < n; ++soLuong) {
            this.dSTG[soLuong] = new TacGia().taoTacGia();
        }
    }

    public TacGia timIDTacGia() {
        System.out.println("Nhap ID tac gia:");
        String idTacGia = "none";
        int idDaNhap = 0;
        try {
            idTacGia = Menu.input.nextLine();
            idDaNhap = Integer.parseInt(idTacGia);
        } catch (NumberFormatException nfe) {
            for (TacGia tacGia : this.dSTG) {
                if (tacGia.getIDTacGia().equalsIgnoreCase(idTacGia))
                    return tacGia;
            }
        }
        String idCanTim = "TG" + String.format("%03d", idDaNhap);
        for (TacGia tacGia : this.dSTG) {
            if (tacGia.getIDTacGia().equals(idCanTim)) return tacGia;
        }
        return new TacGia();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(TacGia tacGia : this.dSTG) {
            output.append("\n").append(tacGia);
        }
        return output.toString();
    }
}
