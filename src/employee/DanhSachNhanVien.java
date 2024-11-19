package employee;

import book.TacGia;
import execute.Menu;

import java.time.LocalDate;

public class DanhSachNhanVien {
    public static int soLuong = 0;
    private NhanVien[] dSNV;
    private int[] idXoa;

    public DanhSachNhanVien() {
        dSNV = new NhanVien[0];
        idXoa = new int[0];
    }

    public NhanVien[] moRongDanhSach(int soLuongNhanVien) {
        NhanVien[] newDSNV = new NhanVien[soLuong + soLuongNhanVien];
        if (soLuongNhanVien > 0) System.arraycopy(this.dSNV, 0, newDSNV, 0, soLuong);
        return this.dSNV = newDSNV;
    }

    public boolean coNhanVien() {
        for(NhanVien nhanVien : dSNV) {
            if(nhanVien != null) return true;
        }
        return false;
    }

    public int[] tangDanhSachXoa(int idNhanVien) {
        int soLuongXoa = idXoa.length;
        int[] newIDXoa = new int[soLuongXoa + 1];
        System.arraycopy(this.idXoa, 0, newIDXoa, 0, soLuongXoa);
        newIDXoa[soLuongXoa] = idNhanVien;
        return this.idXoa = newIDXoa;
    }

    public int giamDanhSachXoa() {
        int soLuongXoa = idXoa.length;
        int idNhanVien = idXoa[0];
        int[] newIDXoa = new int[soLuongXoa - 1];
        System.arraycopy(idXoa, 1, newIDXoa, 0, soLuongXoa - 1);
        this.idXoa = newIDXoa;
        return idNhanVien;
    }

    public void themNhanVien(NhanVien nhanVien) {
        if(this.idXoa.length > 0) {
            int id = giamDanhSachXoa();
            this.dSNV[id - 1] = nhanVien;
            nhanVien.setID(id);
        } else {
            moRongDanhSach(1);
            ++soLuong;
            this.dSNV[soLuong - 1] = nhanVien;
        }

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
            String format = idNhanVien.substring(0, 2);
            int id = Integer.parseInt(idNhanVien.substring(2));
            String exactID = format.toUpperCase() + String.format("%03d", id);
            for (NhanVien nhanVien : this.dSNV) {
                if (nhanVien.getIDNhanVien().equals(exactID))
                    return nhanVien;
            }
        }
        String idCanTim = "NV" + String.format("%03d", idDaNhap);
        for (NhanVien NhanVien : this.dSNV) {
            if (NhanVien.getIDNhanVien().equals(idCanTim)) return NhanVien;
        }
        return new NhanVien();
    }

    public NhanVien chinhSuaNhanVien(NhanVien nhanVien) {
        System.out.println(nhanVien);
        System.out.println("Chinh sua thong tin NhanVien");
        nhanVien.suaThongTin();
        return nhanVien;
    }

    public String xoaNhanVien(NhanVien nhanVien) {
        if(coNhanVien()) {
            String chuoiIDNhanVien = nhanVien.getIDNhanVien();
            int idNhanVien = Integer.parseInt(chuoiIDNhanVien.substring(chuoiIDNhanVien.length() - 3));
            this.idXoa = tangDanhSachXoa(idNhanVien);
            dSNV[idNhanVien - 1] = null;
            return "Da xoa NhanVien";
        } else {
            return "Khong co NhanVien de xoa";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//                sb.append(DanhSachNhanVien.soLuong).append("\n");
//                sb.append(this.dSNV.length).append("\n");
        for (NhanVien nhanVien : this.dSNV) {
            if(nhanVien != null) sb.append(nhanVien).append("\n");
        }
        return sb.toString();
    }
}

