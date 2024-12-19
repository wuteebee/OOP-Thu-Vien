// file lớp trung tâm không được lưu thành 2 file
// không lưu các đối tượng của lớp trung tâm sang 2 file

package borrow_ticket;

import data.SharedData;
import book.Sach;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;


public class DanhSachChiTietPhieuMuon {
    public static ChiTietPhieuMuon []dSCTPM;
    public static int soluong=0;

    public ChiTietPhieuMuon[] getdSCTPM() {
        return dSCTPM;
    }

    Scanner sc = new Scanner(System.in);
    public DanhSachChiTietPhieuMuon() {
        soluong = 0;
        dSCTPM = new ChiTietPhieuMuon[soluong];
    }

    public void xuatdsCTPM() {
        System.out.println("  ------------------------------------ DANH SACH CHI TIET PHIEU MUON ------------------------------------- ");
        System.out.println(String.format("| %-20s| %-10s| %-50s| %-20s|",
                            "ID Phieu muon", "So sach", "ID sach", "ID ngay thuc tra"));
        for (int i=0; i<soluong; i++)
            System.out.println(dSCTPM[i].toString());
        System.out.println("  -------------------------------------------------------------------------------------------------------- ");
    }
    public boolean ktIDpm(String id) {
        for (PhieuMuon pm : SharedData.dSPM.getDsPM()) {
            if (pm.getidPhieuMuon().equals(id)) {
                return true;
            }
        }
        return false;
    }
    public ChiTietPhieuMuon timKiemCTPMTheoID(String id) {
        for (int i = 0; i < soluong; i++) {
            if (dSCTPM[i].getIdPhieuMuon().equals(id)) {
                return dSCTPM[i]; 
            }
        }
        return null; 
    }
    public void timCTPM() {
        System.out.print("Nhap ID chi tiet phieu muon can tim: ");
        String idctpm = sc.nextLine();
        int[] chiSoTimThay = new int[soluong];
        int dem = 0;
        for (int i = 0; i < soluong; i++) {
            if (dSCTPM[i].getIdPhieuMuon().equals(idctpm)) {
                chiSoTimThay[dem] = i;
                dem++;
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong tim thay chi tiet phieu muon voi ID: " + idctpm);
        } else {
            System.out.println("Tim thay " + dem + " chi tiet phieu muon voi ID: " + idctpm);
            for (int i = 0; i < dem; i++) {
                System.out.println((i + 1) + ". " + dSCTPM[chiSoTimThay[i]].toString());
            }
        }
    }

    public void themCTPM(String id) {
        System.out.print("So luong chi tiet phieu muon can them: ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++) {
            System.out.println("Nhap chi tiet phieu muon thu " + (i+1) + ":");
            dSCTPM = Arrays.copyOf(dSCTPM, soluong + 1);
            dSCTPM[soluong] = new ChiTietPhieuMuon();
            dSCTPM[soluong].setIdPhieuMuon(id);
            dSCTPM[soluong].nhapCTPM();
            System.out.println("Da them chi tiet phieu muon thu " + (i+1) + " thanh cong."); 
            System.out.println(dSCTPM[soluong].toString()+"\n");
            ++soluong;
        }
    }

    public void suaCTPM(String idcansua) {
        int[] chiSoTimThay = new int[soluong];
        int dem = 0;
    
        for (int i = 0; i < soluong; i++) {
            if (dSCTPM[i].getIdPhieuMuon().equals(idcansua)) {
                chiSoTimThay[dem] = i;
                dem++;
            }
        }
    
        if (dem == 0) {
            System.out.println("Khong co chi tiet phieu muon voi ID " + idcansua);
            return;
        }
        System.out.println("Tim thay " + dem + " chi tiet phieu muon voi ID " + idcansua + ":");
        for (int i = 0; i < dem; i++) {
            System.out.println((i + 1) + ". " + dSCTPM[chiSoTimThay[i]].toString());
        }
    
        System.out.print("Ban can sua chi tiet phieu muon thu may?\n" + "Nhap stt cua CTPM can sua: ");
        int luaChon = sc.nextInt();
        if (luaChon < 1 || luaChon > dem) {
            System.out.println("Lua chon khong hop le!");
            return;
        }
    
        int index = chiSoTimThay[luaChon - 1];
        ChiTietPhieuMuon ctpm = dSCTPM[index];
        System.out.println("Chi tiet phieu muon duoc chon:");
        System.out.println(ctpm.toString());
        ctpm.nhapCTPM();

        System.out.println("Chi tiet phieu muon da duoc cap nhat.");
        System.out.println(ctpm.toString());
    }

    public int timKiemViTriCTPM(String idPhieuMuon) {
        for (int i = 0; i < soluong; i++) {
            if (dSCTPM[i].getIdPhieuMuon().equals(idPhieuMuon)) {
                return i;
            }
        }
        return -1;
    }
    public void xoaCTPM(String idPhieuMuon) {
        //System.out.print("Nhap ID CTPM can xoa: ");
        //String idPhieuMuon = sc.nextLine();
        int index = timKiemViTriCTPM(idPhieuMuon);
        if (index == -1) {
            System.out.println("Khong tim thay CTPM voi ID phieu muon: " + idPhieuMuon);
            return;
        }
        for (int i = index; i < soluong - 1; i++) {
            dSCTPM[i] = dSCTPM[i + 1];
        }
        dSCTPM[soluong - 1] = null;
        soluong--;
        System.out.println("Da xoa CTPM voi ID phieu muon: " + idPhieuMuon);
    }

    public void xoaCTPM1(String idPhieuMuon) {
        int[] chiSoTimThay = new int[soluong];
        int dem = 0;
        for (int i = 0; i < soluong; i++) {
            if (dSCTPM[i].getIdPhieuMuon().equals(idPhieuMuon)) {
                chiSoTimThay[dem] = i;
                dem++;
            }
        }

        if (dem == 0) {
            System.out.println("Khong tim thay chi tiet phieu muon voi ID phieu muon: " + idPhieuMuon);
            return;
        }
        System.out.println("Tim thay " + dem + " chi tiet phieu muon voi ID " + idPhieuMuon + ":");
        for (int i = 0; i < dem; i++) {
            System.out.println((i + 1) + ". " + dSCTPM[chiSoTimThay[i]].toString());
        }
        System.out.println( (dem+1) + ". Xoa tat ca CTPM voi ID: " + idPhieuMuon);
        System.out.print("Ban can xoa chi tiet phieu muon thu may?\n" + "Nhap stt cua CTPM can xoa: ");
        int luaChon = sc.nextInt();
        if (luaChon < 1 || luaChon > dem+1) {
            System.out.println("Lua chon khong hop le!");
            return;
        }
        if (luaChon == dem + 1) {
            for (int i = 0; i < dem; i++) {
                for (int j = chiSoTimThay[i]; j < soluong - 1; j++) {
                    dSCTPM[j] = dSCTPM[j + 1];
                }
                dSCTPM[soluong - 1] = null;
                soluong--;
            }
            System.out.println("Da xoa tat ca chi tiet phieu muon voi ID phieu muon: " + idPhieuMuon);
        } else {
            int index = chiSoTimThay[luaChon - 1];
            for (int i = index; i < soluong - 1; i++) {
                dSCTPM[i] = dSCTPM[i + 1];
            }
            dSCTPM[soluong - 1] = null;
            soluong--;
    
            System.out.println("Da xoa CTPM thanh cong. ");
        }
    }

    public void readFile (String filename) {
        try (Scanner filesc = new Scanner (new File(filename))) {
            while (filesc.hasNext()) {
                String idPhieuMuon = filesc.next();
                if ( !ktIDpm(idPhieuMuon) ) {
                    System.out.println("Phieu Muon " + idPhieuMuon +" khong ton tai => khong co Chi Tiet Phieu Muon " + idPhieuMuon);
                    filesc.skip(".*"); // tương tự filesc.nextLine(); bo qua phan còn lai cua dònng
                    continue;
                }
                dSCTPM = Arrays.copyOf(dSCTPM, soluong + 1);
                dSCTPM[soluong] = new ChiTietPhieuMuon();
                dSCTPM[soluong].setIdPhieuMuon(idPhieuMuon);

                int soSach = filesc.nextInt();
                dSCTPM[soluong].setSoSach(soSach);
            
                String[] ids = new String[soSach];
                boolean valid = true;
                for (int i = 0; i < soSach; i++) {
                    ids[i] = filesc.next();
                    Sach sach = dSCTPM[soluong].timIDSach(ids[i]);
                    if ( sach != null )
                        sach.setTonKho(sach.getTonKho() - 1);
                    else {
                        System.out.println("Sach co ID " + ids[i] + 
                                            " khong ton tai hoac bi loi => bo qua chi tiet phieu muon nay.");
                        valid = false;
                        break;
                    }
                }
                if (!valid) {
                    filesc.skip(".*");
                    continue;
                }
                dSCTPM[soluong].setIdSach(ids);

                String ngay = filesc.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dSCTPM[soluong].setNgayThucTra(LocalDate.parse(ngay, formatter));
                soluong++;
            }
            //System.out.println("Doc thanh cong file: " + filename);
            //xuatdsCTPM();

        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file!!! " + e.getMessage());
        } catch (DateTimeParseException e) {
        System.out.println("Loi dinh dang ngay thang!!! " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so!!! " + e.getMessage());
        }
    }
    
    public void writeFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(String.format("%-20s| %-20s| %-20s|",
                    "ID Phieu muon", "ID sach", "ID ngay thuc tra"));
            writer.newLine();

            for (int i = 0; i < soluong; i++) {
                writer.write(dSCTPM[i].toString());
                writer.newLine();
            }
            System.out.println("Ghi danh sach chi tiet phieu muon thanh cong vao file: " + filename);
        } catch (IOException e) {
            System.out.println("Loi ghi file!!! " + e.toString());
        }
    }
}
