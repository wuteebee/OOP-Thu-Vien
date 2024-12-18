package book;

import data.SharedData;
import execute.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        System.out.println(toString());
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

    public NhaXuatBan timIDNhaXuatBan(String idNhaXuatBan) {
        int idDaNhap = 0;
        try {
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

    public NhaXuatBan timTenNhaXuatBan(String tenNhaXuatBan) {
        for (NhaXuatBan nhaXuatBan : this.dSNXB) {
            if (nhaXuatBan.getTen().equalsIgnoreCase(tenNhaXuatBan)) {
                return nhaXuatBan;
            }
        }
        return new NhaXuatBan();
    }

    public NhaXuatBan chinhSuaNhaXuatBan(NhaXuatBan nhaXuatBan) {
        System.out.println(nhaXuatBan);
        System.out.println("Chinh sua thong tin NhanVien");
        nhaXuatBan.suaThongTin();
        return nhaXuatBan;
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
        StringBuilder sb = new StringBuilder();
        System.out.println(String.format("%-110s","").replace(' ', '-'));
        System.out.print(String.format("|%-43s",""));
        System.out.print("Danh Sach Nha Xuat Ban");
        System.out.println(String.format("%-43s|",""));
        System.out.println(String.format("%-110s","").replace(' ', '-'));
        System.out.print(String.format("|%-10s|%-30s|%-15s|%-50s|  ", "id", "ten", "soDienThoai", "diaChi"));
        for (NhaXuatBan nhaXuatBan : this.dSNXB) {
            sb.append("\n").append(nhaXuatBan);
        }
        return sb.append("\n").append(String.format("%-110s","").replace(' ', '-')).toString();
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

    public String toStringToFile() {
        StringBuilder sb = new StringBuilder();
        for (NhaXuatBan nhaXuatBan : dSNXB) {
            sb.append(nhaXuatBan.toStringToFile()).append("\n");
        }
        return sb.toString();
    }

     public void writeFile() {
        try {
            FileWriter outputDSNXB = new FileWriter("src\\data\\DanhSachNhaXuatBan.txt", false);
            outputDSNXB.write(toStringToFile());
            outputDSNXB.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        NhaXuatBan nhaXuatBan;
        try {
            Scanner inputDSNXB = new Scanner(new File("src\\data\\DanhSachNhaXuatBan.txt"));
            inputDSNXB.useDelimiter(",");
            while(inputDSNXB.hasNextLine() && inputDSNXB.hasNext()) {
                nhaXuatBan = new NhaXuatBan();
                String[] thuocTinh = inputDSNXB.nextLine().split(",");
                nhaXuatBan.setTen(thuocTinh[0]);
                nhaXuatBan.setSoDienThoai(thuocTinh[1]);
                nhaXuatBan.setDiaChi(thuocTinh[2]);
                nhaXuatBan.setTrangThai(Integer.parseInt(thuocTinh[3]) == 1);
                SharedData.dSNXB.themNhaXuatBan(nhaXuatBan);
            }
            inputDSNXB.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
