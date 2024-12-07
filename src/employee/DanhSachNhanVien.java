package employee;

import execute.Menu;

public class DanhSachNhanVien {
    public static int soLuong = 0;
    private NhanVien[] dSNV;

    public DanhSachNhanVien() {
        dSNV = new NhanVien[0];
    }

    public NhanVien[] moRongDanhSach(int soLuongNhanVien) {
        NhanVien[] newDSNV = new NhanVien[soLuong + soLuongNhanVien];
        if (soLuongNhanVien > 0) System.arraycopy(this.dSNV, 0, newDSNV, 0, soLuong);
        return this.dSNV = newDSNV;
    }

    public void themNhanVien(NhanVien nhanVien) {
        moRongDanhSach(1);
        ++soLuong;
        this.dSNV[soLuong - 1] = nhanVien;
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

    public void khoaNhanVien() {
        System.out.println(toStringFormatted(true));
        NhanVien nhanVien = timIDNhanVien();
        if(nhanVien == new NhanVien() || nhanVien.getTrangThai() != true) {
            System.out.println("Khong tim thay nhan vien hoac nhan vien da bi khoa!");
        } else {
            nhanVien.setTrangThai(false);
            System.out.println("Da khoa nhan vien");
        }
    }

    public void moKhoaNhanVien() {
        System.out.println(toStringFormatted(false));
        NhanVien nhanVien = timIDNhanVien();
        if(nhanVien == new NhanVien() || nhanVien.getTrangThai() != false) {
            System.out.println("Khong tim thay nhan vien hoac nhan vien da duoc mo khoa!");
        } else {
            nhanVien.setTrangThai(true);
            System.out.println("Da mo khoa nhan vien");
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

    public String toStringFormatted(Boolean trangThai) {
        StringBuilder sb = new StringBuilder();
//                sb.append(DanhSachNhanVien.soLuong).append("\n");
//                sb.append(this.dSNV.length).append("\n");
        for (NhanVien nhanVien : this.dSNV) {
            if(nhanVien.getTrangThai() && trangThai) sb.append(nhanVien).append("\n");
        }
        return sb.toString();
    }

}

