package borrow_ticket;

import data.SharedData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Scanner;

//import data.SharedData;

public class DanhSachPhieuMuon {
    public PhieuMuon []dsPM;
    public static int maID = 1;
    public static int soluong = 0;

    public PhieuMuon[] getDsPM() {
        return dsPM;
    }

    Scanner sc = new Scanner(System.in);

    public DanhSachPhieuMuon() {
        soluong = 0;
        dsPM = new PhieuMuon[soluong];
    }

    public void xuatds() {
        System.out.println("  -----------------------------------------  DANH SACH PHIEU MUON  -----------------------------------------");
        System.out.println(String.format("| %-20s| %-20s| %-20s| %-20s| %-20s|", "ID Phieu Muon", "ID The Thu Vien", "ID Nhan Vien",
                "Ngay muon", "Ngay tra"));
        for (int i = 0; i < soluong; i++)
            System.out.println(dsPM[i].toString());
        System.out.println("  ----------------------------------------------------------------------------------------------------------");
    }

    public void themPM() {
        System.out.print("So luong phieu muon can them: ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            System.out.println("Nhap phieu muon thu " + (i+1) );
            dsPM = Arrays.copyOf(dsPM, soluong + 1);
            dsPM[soluong] = new PhieuMuon();
            dsPM[soluong].nhapPM();
            System.out.println("Da them thanh cong phieu muon: " + dsPM[soluong].toString());
            ++soluong;
            ++maID;
        }
    }

    public PhieuMuon timPM() {
        String id = sc.nextLine();
        for (PhieuMuon phieuMuon : SharedData.dSPM.getDsPM()) {
            if (phieuMuon.getidPhieuMuon().equals(id))
                return phieuMuon;
        }
        return null;
    }

    public int timkiemViTriPM(String id) {
        for (int i = 0; i < soluong; i++) {
            if (dsPM[i].getidPhieuMuon().equals(id))
                return i;
        }
        return -1;
    }

    public void xoaPhieuMuon() {
        PhieuMuon pm = timPM();
        if (pm == null) {
            System.out.println("Khong tim thay phieu muon vua nhap ! ");
            return;
        }
        for (PhieuMuon i : dsPM) {
            if ( i == pm ) {
                SharedData.dSCTPM.xoaCTPM(i.getidPhieuMuon());
                for (int j=0; j < soluong-1; j++) {
                    dsPM[j] = dsPM[j + 1];
                }
                dsPM[soluong - 1] = null;
                soluong--;
            }
        }
        System.out.println("Da xoa phieu muon va chi tiet phieu muon ");
    }

    public void suaPhieuMuon() {
        System.out.print("Nhap ID phieu muon ban can chinh sua: ");
        PhieuMuon pm = timPM();
        if (pm == null) {
            System.out.println("Khong co phieu muon vua nhap !");
            return;
        }
        System.out.println("Phieu muon voi ID: " + pm);
        pm.nhapPM();

        System.out.println("Phieu muon da duoc cap nhap ! ");
        System.out.println(pm.toString());
    }

    public void readFile(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            while (sc.hasNextLine()) {
                dsPM = Arrays.copyOf(dsPM, soluong + 1);
                dsPM[soluong] = new PhieuMuon();

                String id = sc.next();
                dsPM[soluong].setidPhieuMuon(id);

                dsPM[soluong].setIDTheThuVien(sc.next());
                dsPM[soluong].setIDNhanVien(sc.next());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String ngay = sc.next();
                dsPM[soluong].setngayMuon(LocalDate.parse(ngay, formatter));
                ngay = sc.next();
                dsPM[soluong].setngayTra(LocalDate.parse(ngay, formatter));
                soluong++;
                maID++;
            }
            System.out.println("Doc thanh cong file: "+ filename);
            //xuatds();
        } catch (FileNotFoundException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.out.println("Loi dinh dang ngay thang: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Loi dinh dang so: " + e.getMessage());
        }
    }
    public void writeFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(String.format("%-20s| %-20s| %-20s| %-20s| %-20s|", "ID Phieu Muon", "ID The Thu Vien", "ID Nhan Vien",
                    "Ngay muon", "Ngay tra"));
            writer.newLine();

            for (PhieuMuon pm : dsPM) {
                writer.write(pm.toString());
                writer.newLine();
            }
            System.out.println("Ghi danh sach thanh cong vao file: " + filename);
        } catch (Exception e) {
            System.out.println("Loi ghi file: " + e.toString());
        }
    }

    // toString 
}
