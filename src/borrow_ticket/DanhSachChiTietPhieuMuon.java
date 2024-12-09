// file lớp trung tâm không được lưu thành 2 file
// không lưu các đối tượng của lớp trung tâm sang 2 file

package borrow_ticket;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;


public class DanhSachChiTietPhieuMuon {
    private ChiTietPhieuMuon []dSCTPM;
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
        System.out.println(String.format("%-20s| %-20s| %-20s|",
                            "ID Phieu muon", "ID sach", "ID ngay thuc tra"));
        for (int i=0; i<soluong; i++)
            System.out.println(dSCTPM[i].toString());
    }
    public boolean kiemTraIDPhieuMuon(String id) {
        DanhSachPhieuMuon danhSach = new DanhSachPhieuMuon();
        for (PhieuMuon pm : danhSach.getDsPM()) {
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

    public void themCTPM(DanhSachPhieuMuon dspm) {
        System.out.print("Nhap ID phieu muon: ");
        String idpm = sc.nextLine();

        PhieuMuon index1 = dspm.timKiemPhieuMuon(idpm);
        ChiTietPhieuMuon index2 = timKiemCTPMTheoID(idpm);
        //System.out.println("index1: " + index1); 
        //System.out.println("index2: " + index2);
        if(index1 != null && index2 != null ) {
            System.out.println("CTPM voi ID nay da ton tai !");
            System.out.println("Ban muon nhap lai ID phieu muon hay chinh sua CTPM voi ID: " + idpm +" ?");
            System.out.println("Chon 'y' den chinh / chon 'n' de nhap lai.");
            char choice = sc.nextLine().charAt(0);

            if (choice == 'Y' || choice == 'y')
                suaCTPM(idpm);
            else if (choice == 'N' || choice == 'n') {
                System.out.println("Nhap lai ID phieu muon.");
                themCTPM(dspm);
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        } else  if (index1 != null && index2 == null) { 
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
                ctpm.setIdPhieuMuon(idpm);
                ctpm.nhapCTPM();
                dSCTPM = Arrays.copyOf(dSCTPM, soluong + 1);
                dSCTPM[soluong] = ctpm;
                soluong++;
                System.out.println("Da them chi tiet phieu muon cua phieu muon: " + idpm);
            } 
        else{
                System.out.println("Khong ton tai ID phieu muon: " + idpm);
            }
        return;
    }

    public void suaCTPM(String idcansua) {
        ChiTietPhieuMuon ctpm = timKiemCTPMTheoID(idcansua);
        if (ctpm == null) {
            System.out.println("Khong co phieu muon voi ID " + idcansua);
            return;
        }
        System.out.println("Phieu muon voi ID = " + idcansua);
        System.out.println(ctpm.toString());
        ctpm.nhapCTPM(); 

        System.out.println("Chi tiet phieu muon da duoc cap nhap. ");
        System.out.println(ctpm.toString());
    }
    public void xoaCTPM(String idPhieuMuon) {
        int index = -1;
        for (int i = 0; i < soluong; i++) {
            if (dSCTPM[i].getIdPhieuMuon().equals(idPhieuMuon)) {
                index = i;
                break;
            }
        }
    
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
    

    public void readfile () {
        try (Scanner filesc = new Scanner (new File(
            "/Users/daosongloc/Documents/OOP-Thu-Vien/src/borrow_ticket/DanhSachCTPM.txt"))) {
            while (filesc.hasNext()) {
                String idPhieuMuon = filesc.next();
                if (!kiemTraIDPhieuMuon(idPhieuMuon)) {
                    System.out.println("Khong ton tai ID PhieuMuon: " + idPhieuMuon);
                    filesc.skip(".*"); // tương tự filesc.nextLine(); bo qua phan còn lai cua dònng
                    continue;
                }
                dSCTPM = Arrays.copyOf(dSCTPM, soluong + 1);
                dSCTPM[soluong] = new ChiTietPhieuMuon();
                dSCTPM[soluong].setIdPhieuMuon(idPhieuMuon);

                int soSach = filesc.nextInt();
                dSCTPM[soluong].setSoSach(soSach);
            
                // doc id sach vào mảng
                String[] ids = new String[soSach];
                for (int i = 0; i < soSach; i++) {
                    ids[i] = filesc.next();
                }
                dSCTPM[soluong].setIdSach(ids);

                String ngay = filesc.next();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                dSCTPM[soluong].setNgayThucTra(LocalDate.parse(ngay, formatter));
                soluong++;
            }
            xuatdsCTPM();

        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai ! " + e);
        } catch (DateTimeParseException e) {
        System.out.println("Lỗi định dạng ngày tháng: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số: " + e.getMessage());
        }
    }
    

}
