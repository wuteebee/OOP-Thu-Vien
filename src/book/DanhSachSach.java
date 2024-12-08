// package book;

// public class DanhSachSach {
//     public static int soLuong = 0;
//     private Sach[] dSS;

//     public DanhSachSach() {
//         this.dSS = new Sach[0];
//     }

//     public void themSach (Sach sach) {
//         Sach[] newDSS = new Sach[++soLuong];
//         if (soLuong - 1 >= 0) System.arraycopy(this.dSS, 0, newDSS, 0, soLuong - 1);
//         newDSS[soLuong - 1] = sach;
//         this.dSS = newDSS;
//     }

//     @Override
//     public String toString() {
//         StringBuilder output = new StringBuilder();
//         for(Sach sach : this.dSS) {
//             output.append(sach).append("\n");
//         }
//         return output.toString();
//     }
// }

package book;

import execute.Menu;

public class DanhSachSach {
    public static int soLuong = 0;
    private Sach[] dSSach;

    public DanhSachSach() {
        System.out.println("TAO MOI");
        dSSach = new Sach[0];
    }

    public Sach[] moRongDanhSach(int soLuongSach) {
        System.out.println("DA MO RONG");
        Sach[] newDSSach = new Sach[soLuong + soLuongSach];
        if (soLuong > 0) {
            System.arraycopy(this.dSSach, 0, newDSSach, 0, soLuong);
        }
        return this.dSSach = newDSSach;
    }

    public void themSach(Sach sach) {
        moRongDanhSach(1);
        this.dSSach[soLuong] = sach;
        soLuong++;
    }

    public void themSach(int soLuongSach) {
        moRongDanhSach(soLuongSach);
        for (int n = soLuong + soLuongSach; soLuong < n; ++soLuong) {
            System.out.println("Chon loai sach (1: Sach giao khoa / 2. Sach tham khao):");
            int loaiSach = Menu.input.nextInt();
            Menu.input.nextLine(); 
            Sach sach;
            if (loaiSach == 1) {
                sach = new SachGiaoKhoa().taoSach();
            } else {
                sach = new SachThamKhao().taoSach();
            }
            this.dSSach[soLuong] = sach;
        }
    }

    public Sach timIDSach() {
        System.out.println(toString());
        System.out.println("Nhập ID Sách:");
        String idSach = Menu.input.nextLine();
        for (Sach sach : this.dSSach) {
            if (sach instanceof SachGiaoKhoa && ((SachGiaoKhoa) sach).idSach.equals(idSach)) {
                return sach;
            } else if (sach instanceof SachThamKhao && ((SachThamKhao) sach).idSach.equals(idSach)) {
                return sach;
            }
        }
        return new Sach(); 
    }

    public Sach chinhSuaSach(Sach sach) {
        System.out.println(sach);
        System.out.println("Chỉnh sửa thông tin sách");
        
        sach.suaThongTin(); 

        if (sach instanceof SachGiaoKhoa) {
            ((SachGiaoKhoa) sach).suaThongTin();
        }
        if (sach instanceof SachThamKhao) {
            ((SachThamKhao) sach).suaThongTin();
        }
        return sach;
    }



    public void khoaSach() {
        System.out.println(toString());
        Sach sach = timIDSach();
        if (sach == new Sach() || !sach.getTrangThai()) {
            System.out.println("Khong tim thay sach hoac sach da bi khoa!");
        } else {
            sach.setTrangThai(false);
            System.out.println("Da khoa sach!");
        }
    }

    public void moKhoaSach() {
        System.out.println(toString());
        Sach sach = timIDSach();
        if (sach == new Sach() || sach.getTrangThai()) {
            System.out.println("Không tìm thấy sách hoặc sách đã được mở khóa!");
        } else {
            sach.setTrangThai(true);
            System.out.println("Đã mở khóa sách");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sach sach : this.dSSach) {
            if (sach != null) sb.append(sach).append("\n");
        }
        return sb.toString();
    }

    public String toStringFormatted(Boolean trangThai) {
        StringBuilder sb = new StringBuilder();
        for (Sach sach : this.dSSach) {
            if (sach.getTrangThai() && trangThai) sb.append(sach).append("\n");
        }
        return sb.toString();
    }
}