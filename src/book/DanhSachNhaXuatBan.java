package book;

import execute.*;

public class DanhSachNhaXuatBan {

    static int soLuong = 0;
    private NhaXuatBan[] dSNXB;

    public DanhSachNhaXuatBan() {
        this.dSNXB = new NhaXuatBan[0];
    }

    public NhaXuatBan[] moRongDanhSach(int soLuongNhaXuatBan) {
        NhaXuatBan[] newDSNXB = new NhaXuatBan[soLuong + soLuongNhaXuatBan];
        if (soLuongNhaXuatBan >= 0) {
            System.arraycopy(this.dSNXB, 0, newDSNXB, 0, soLuong);
        }
        return this.dSNXB = newDSNXB;
    }

    public void themNhaXuatBan(NhaXuatBan nhaXuatBan) {
        moRongDanhSach(1);
        ++soLuong;
        this.dSNXB[soLuong - 1] = nhaXuatBan;
    }

    public void themNhaXuatBan(int soLuongNhaXuatBan) {
        moRongDanhSach(soLuongNhaXuatBan);
        for (int n = soLuong + soLuongNhaXuatBan; soLuong < n; ++soLuong) {
            this.dSNXB[soLuong++] = new NhaXuatBan().taoNhaXuatBan();
        }
    }

    public NhaXuatBan timIDNhaXuatBan() {
        System.out.println("Nhap ID NhaXuatBan:");
        String idNhaXuatBan = "none";
        int idDaNhap = 0;
        try {
            idNhaXuatBan = Menu.input.nextLine();
            idDaNhap = Integer.parseInt(idNhaXuatBan);
        } catch (NumberFormatException nfe) {
            for (NhaXuatBan nhaXuatBan : this.dSNXB) {
                if (nhaXuatBan.getIDNhaXuatBan().equalsIgnoreCase(idNhaXuatBan)) {
                    return nhaXuatBan;
                }
            }
        }
        String idCanTim = "NXB" + String.format("%03d", idDaNhap);
        for (NhaXuatBan nhaXuatBan : this.dSNXB) {
            if (nhaXuatBan.getIDNhaXuatBan().equals(idCanTim)) {
                return nhaXuatBan;
            }
        }
        return new NhaXuatBan();
    }

    public void khoaNhaXuatBan() {
        System.out.println(toStringFormatted(true));
        NhaXuatBan nhaXuatBan = timIDNhaXuatBan();
        if (nhaXuatBan == new NhaXuatBan() || nhaXuatBan.getTrangThai() != true) {
            System.out.println("Khong tim thay nha xuat ban hoac nha xuat ban da bi khoa!");
        } else {
            nhaXuatBan.setTrangThai(false);
            System.out.println("Da khoa nha xuat ban");
        }
    }

    public void moKhoaNhaXuatBan() {
        System.out.println(toStringFormatted(false));
        NhaXuatBan nhaXuatBan = timIDNhaXuatBan();
        if (nhaXuatBan == new NhaXuatBan() || nhaXuatBan.getTrangThai() != false) {
            System.out.println("Khong tim thay nha xuat ban hoac nha xuat ban da duoc mo khoa!");
        } else {
            nhaXuatBan.setTrangThai(false);
            System.out.println("Da mo khoa nha xuat ban");
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (NhaXuatBan nhaXuatBan : this.dSNXB) {
            output.append("\n").append(nhaXuatBan);
        }
        return output.toString();
    }

    public String toStringFormatted(Boolean trangThai) {
        StringBuilder output = new StringBuilder();
        for (NhaXuatBan nhaXuatBan : this.dSNXB) {
            if (nhaXuatBan.getTrangThai() && trangThai) {
                output.append("\n").append(nhaXuatBan);
            }
        }
        return output.toString();
    }
}
