package users;

import data.SharedData;
import execute.Menu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
            this.dSTTV[soLuong] = new TheThuVien();
            this.dSTTV[soLuong].tao();
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
        System.out.println(String.format("%-103s","").replace(' ', '-'));
        System.out.print(String.format("|%-40s",""));
        System.out.print("Danh Sach The Thu Vien");
        System.out.println(String.format("%-39s|",""));
        System.out.println(String.format("%-103s","").replace(' ', '-'));
        System.out.println(String.format("|%-10s|%-15s|%-15s|%-10s|%-15s|%-15s|%-15s|", "id", "ho", "ten", "gioiTinh", "ngaySinh", "soDienThoai", "trangThai"));
        StringBuilder sb = new StringBuilder();
        for (TheThuVien the : this.dSTTV) {
            if (the != null) sb.append(the).append("\n");
        }
        return sb.append(String.format("%-103s","").replace(' ', '-')).toString();
    }

    public String toStringFormatted(Boolean trangThai) {
        StringBuilder sb = new StringBuilder();
        for (TheThuVien the : this.dSTTV) {
            if (the.getTrangThai() && trangThai) sb.append(the).append("\n");
        }
        return sb.toString();
    }

    public String toStringToFile() {
        StringBuilder sb = new StringBuilder();
        for (TheThuVien theThuVien : dSTTV) {
            sb.append(theThuVien.toStringToFile()).append("\n");
        }
        return sb.toString();
    }

    public void writeFile() {
        try {
            FileWriter outputDSTTV = new FileWriter("src\\data\\DanhSachTheThuVien.txt", false);
            outputDSTTV.write(toStringToFile());
            outputDSTTV.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        TheThuVien theThuVien;
        try {
            Scanner inputDSTTV = new Scanner(new File("src\\data\\DanhSachTheThuVien.txt"));
            inputDSTTV.useDelimiter(",");
            while(inputDSTTV.hasNextLine() && inputDSTTV.hasNext()) {
                theThuVien = new TheThuVien();
                String[] thuocTinh = inputDSTTV.nextLine().split(",");
                theThuVien.setHo(thuocTinh[0]);
                theThuVien.setTen(thuocTinh[1]);
                theThuVien.setGioiTinh(Integer.parseInt(thuocTinh[2]) == 1);
                theThuVien.setNgaySinh(thuocTinh[3]);
                theThuVien.setSoDienThoai(thuocTinh[4]);
                theThuVien.setTrangThai(Integer.parseInt(thuocTinh[5]) == 1);
                SharedData.dSTTV.themTheThuVien(theThuVien);
            }
            inputDSTTV.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


