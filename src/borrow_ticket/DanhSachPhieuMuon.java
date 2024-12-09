package borrow_ticket;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DanhSachPhieuMuon {
    private PhieuMuon []dsPM;
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
        System.out.println(String.format("%-20s| %-20s| %-20s| %-20s| %-20s|", "ID Phieu Muon", "ID The Thu Vien", "ID Nhan Vien",
                "Ngay muon", "Ngay tra"));
        for (int i = 0; i < soluong; i++)
            System.out.println(dsPM[i].toString());
    }
    
    public void themPM(PhieuMuon pm) {
        if (dsPM == null) 
            dsPM = new PhieuMuon[1];  
        else 
            dsPM = Arrays.copyOf(dsPM, soluong + 1);
        dsPM[soluong] = pm;
        soluong++;
        maID++;
    }

    public PhieuMuon timKiemPhieuMuon(String id) {
        for (PhieuMuon phieuMuon : dsPM) {
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

    public boolean xoaPhieuMuon(String idPhieuMuon) {
        int viTri = timkiemViTriPM(idPhieuMuon);
        if (viTri == -1) {
            return false;
        }
        
        for (int i = viTri; i < soluong - 1; i++) {
            dsPM[i] = dsPM[i + 1];
        }
        dsPM[soluong - 1] = null; 
        soluong--;
        return true;
    }

    public void suaPhieuMuon() {
        System.out.print("Nhap ID phieu muon ban muon chinh sua: ");
        String idcansua = sc.nextLine();
        
        PhieuMuon pm = timKiemPhieuMuon(idcansua);
        if (pm == null) {
            System.out.println("Khong co phieu muon voi ID " + idcansua);
            return;
        }
        System.out.println("Phieu muon voi ID = " + idcansua);
        System.out.println(pm.toString());
        pm.nhapPM(); 

        System.out.println("Phieu muon da duoc cap nhap: ");
        System.out.println(pm.toString());
    }

    public void readFile() {
        try (Scanner sc = new Scanner(new File(
            "/Users/daosongloc/Documents/OOP-Thu-Vien/src/borrow_ticket/DanhSachPhieuMuon.txt"))) {
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
            xuatds();
        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai: " + e);
        }
    }
    
}
