// file lớp trung tâm không được lưu thành 2 file
// không lưu các đối tượng của lớp trung tâm sang 2 file

package borrow_ticket;

import data.SharedData;
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

    public static ChiTietPhieuMuon[] getdSCTPM() {
        return dSCTPM;
    }

    Scanner sc = new Scanner(System.in);
    public DanhSachChiTietPhieuMuon() {
        soluong = 0;
        dSCTPM = new ChiTietPhieuMuon[soluong];
    }

    public void xuatdsCTPM() {
        System.out.println("      ----------   DANH SACH CHI TIET PHIEU MUON   ----------");
        System.out.println(String.format("| %-20s| %-20s| %-20s|",
                            "ID Phieu muon", "ID sach", "ID ngay thuc tra"));
        for (int i=0; i<soluong; i++)
            System.out.println(dSCTPM[i].toString());
        System.out.println("      ----------   DANH SACH CHI TIET PHIEU MUON   ----------");
    }
    public boolean kiemTraIDPhieuMuon(String id) {
        for (PhieuMuon pm : DanhSachPhieuMuon.getDsPM()) {
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
        ChiTietPhieuMuon search = timKiemCTPMTheoID(idctpm);
        if (search != null) 
            System.out.println(search);
        else System.out.println("Khong tim thay chi tiet phieu muon vua nhap !");
    }

    public void themCTPM() {
        System.out.print("Nhap ID phieu muon can them: ");
        PhieuMuon index1 = SharedData.dSPM.timPM();
        ChiTietPhieuMuon index2 = timKiemCTPMTheoID(index1.getidPhieuMuon());
        if(index1 != null && index2 != null ) {
            System.out.println("CTPM voi ID nay da ton tai !");
            System.out.println("Ban muon nhap lai ID phieu muon hay chinh sua CTPM voi ID: " + index1.getidPhieuMuon() +" ?");
            System.out.println("Chon 'y' den chinh / chon 'n' de nhap lai.");
            char choice = sc.nextLine().charAt(0);

            if (choice == 'Y' || choice == 'y')
                suaCTPM(index1.getidPhieuMuon());
            else if (choice == 'N' || choice == 'n') {
                System.out.println("Nhap lai ID phieu muon.");
                themCTPM();
            } else {
                System.out.println("Lua chon khong hop le.");
            }
        } else  if (index1 != null && index2 == null) { 
                ChiTietPhieuMuon ctpm = new ChiTietPhieuMuon();
                ctpm.setIdPhieuMuon(index1.getidPhieuMuon());
                ctpm.nhapCTPM();
                dSCTPM = Arrays.copyOf(dSCTPM, soluong + 1);
                dSCTPM[soluong] = ctpm;
                soluong++;
                System.out.println("Da them chi tiet phieu muon cua phieu muon: " + index1.getidPhieuMuon());
            } 
        else{
                System.out.println("Khong ton tai phieu muon vua nhap !");
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


    public void readFile (String filename) {
        try (Scanner filesc = new Scanner (new File(filename))) {
            while (filesc.hasNext()) {
                String idPhieuMuon = filesc.next();
                if ( !kiemTraIDPhieuMuon(idPhieuMuon) ) {
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
            System.out.println("Đọc thành công file: " + filename);
            //xuatdsCTPM();

        } catch (FileNotFoundException e) {
            System.out.println("Lỗi đọc file !!! " + e.getMessage());
        } catch (DateTimeParseException e) {
        System.out.println("Lỗi định dạng ngày tháng !!! " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số !!! " + e.getMessage());
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
            System.out.println("Ghi danh sách chi tiết phiếu mượn thành công vào file: " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file !!! " + e.toString());
        }
    }
}
