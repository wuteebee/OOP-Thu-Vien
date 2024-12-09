package entry_form;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachPhieuNhap {

    private PhieuNhap[] dsPN;
    private int soLuong = 0;

    public DanhSachPhieuNhap() {
        dsPN = new PhieuNhap[0];
    }

    public void moRongDanhSach(int soLuongPhieuNhap) {
        PhieuNhap[] newdsPN = new PhieuNhap[soLuong + soLuongPhieuNhap];
        if (soLuongPhieuNhap > 0) {
            System.arraycopy(this.dsPN, 0, newdsPN, 0, soLuong);
        }
        this.dsPN = newdsPN;
    }

    public void themPhieuNhap(PhieuNhap phieuNhap) {
        moRongDanhSach(1);
        ++soLuong;
        this.dsPN[soLuong - 1] = phieuNhap;
    }

    public void xoaPhieuNhap() {
        System.out.println("\t\t\tXOA PHIEU NHAP");
        System.out.print("Nhap ID Phieu Nhap can xoa: ");
        String idPhieuNhap = new Scanner(System.in).nextLine();
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                PhieuNhap[] newdsPN = new PhieuNhap[soLuong - 1];
                for (int j = 0, k = 0; j < soLuong; j++) {
                    if (j != i) {
                        newdsPN[k++] = dsPN[j];
                    }
                }
                dsPN = newdsPN;
                soLuong--;
                System.out.println("Xoa phieu nhap thanh cong.");
                break;
            }
        }
        //cập nhật file sau khi xóa
        try (FileWriter writer = new FileWriter("src/data/DanhSachPhieuNhap.txt")) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(dsPN[i].getIdPhieuNhap() + " ");
                writer.write(dsPN[i].getIdNhaCungCap() + " ");
                writer.write(dsPN[i].getTongTien() + " ");
                writer.write(dsPN[i].getNgayNhap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " ");
                writer.write(dsPN[i].getSoLuongSach() + " ");
                writer.write(dsPN[i].getIdSach() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void suaPhieuNhap() {
        System.out.println("\t\t\tSUA PHIEU NHAP");
        System.out.print("Nhap ID Phieu Nhap can sua: ");
        String idPhieuNhap = new Scanner(System.in).nextLine();
        Scanner scanner = new Scanner(System.in);

        boolean found = false;
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                found = true;
                PhieuNhap phieuNhapMoi = new PhieuNhap();
                System.out.print("ID Phieu Nhap: ");
                phieuNhapMoi.setIdPhieuNhap(scanner.nextLine());
                System.out.print("ID Nha Cung Cap: ");
                phieuNhapMoi.setIdNhaCungCap(scanner.nextLine());
                System.out.print("Tong Tien: ");
                phieuNhapMoi.setTongTien(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Ngay Nhap (dd/mm/yyyy): ");
                phieuNhapMoi.setNgayNhap(convertStringToDate(scanner.nextLine()));
                System.out.print("So Luong Sach: ");
                phieuNhapMoi.setSoLuongSach(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("ID Sach: ");
                phieuNhapMoi.setIdSach(scanner.nextLine());
                dsPN[i] = phieuNhapMoi;
                break;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay ID Phieu Nhap.");
            return;
        }
        // Update the file after modification
        try (FileWriter writer = new FileWriter("src/data/DanhSachPhieuNhap.txt")) {
            for (int i = 0; i < soLuong; i++) {
                writer.write(dsPN[i].getIdPhieuNhap() + " ");
                writer.write(dsPN[i].getIdNhaCungCap() + " ");
                writer.write(dsPN[i].getTongTien() + " ");
                writer.write(dsPN[i].getNgayNhap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " ");
                writer.write(dsPN[i].getSoLuongSach() + " ");
                writer.write(dsPN[i].getIdSach() + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sua phieu nhap thanh cong.");
    }

    public void timPhieuNhap() {
        System.out.println(" \t\t TIM KIEM PHIEU NHAP"); 
        boolean found = false;
        System.out.print("Nhap ID Phieu Nhap can tim: ");
        String idPhieuNhap = new Scanner(System.in).nextLine();
        System.out.printf("%-15s %-17s %-15s %-15s %-15s %-15s\n", "ID Phieu Nhap", "ID Nha Cung Cap", "Tong Tien", "Ngay Nhap", "So Luong Sach", "ID Sach");
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                found = true;
                System.out.printf("%-15s %-17s %-15d %-15s %-15d %-15s\n",
                        dsPN[i].getIdPhieuNhap(),
                        dsPN[i].getIdNhaCungCap(),
                        dsPN[i].getTongTien(),
                        dsPN[i].getNgayNhap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        dsPN[i].getSoLuongSach(),
                        dsPN[i].getIdSach());
                return;
            }

        }
        if (!found) {
            System.out.println("Khong tim thay ID Phieu Nhap.");
        }
    }

    public void xuat() {
        System.out.print(" \t\t\t\t----PHIEU NHAP----\n");
        System.out.printf("%-15s %-17s %-15s %-15s %-15s %-15s\n", "ID Phieu Nhap", "ID Nha Cung Cap", "Tong Tien", "Ngay Nhap", "So Luong Sach", "ID Sach");
        for (int i = 0; i < soLuong; i++) {
            System.out.printf("%-15s %-17s %-15d %-15s %-15d %-15s\n",
                    dsPN[i].getIdPhieuNhap(),
                    dsPN[i].getIdNhaCungCap(),
                    dsPN[i].getTongTien(),
                    dsPN[i].getNgayNhap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    dsPN[i].getSoLuongSach(),
                    dsPN[i].getIdSach());
        }
// Dấu -: Căn lề trái.
// Số 15: Độ rộng tối thiểu của cột là 15 ký tự. Nếu dữ liệu ngắn hơn 15 ký tự, khoảng trống sẽ được thêm vào bên phải.
// s: Định dạng kiểu chuỗi (String).

// d: Định dạng kiểu số nguyên (Integer).
// \n: Xuống dòng sau khi in.
    }

    public boolean kiemTraIdDuyNhat(String idPhieuNhap) {
        for (int i = 0; i < soLuong; i++) {
            if (dsPN[i].getIdPhieuNhap().equals(idPhieuNhap)) {
                return false;
            }
        }
        return true;
    }

    public LocalDate convertStringToDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void readFile() {
        boolean hasData = false;
        try {
            Scanner fin = new Scanner(new File("src/data/DanhSachPhieuNhap.txt"));
            while (fin.hasNextLine() && fin.hasNext()) {
                hasData = true;
                dsPN = Arrays.copyOf(dsPN, soLuong + 1);
                dsPN[soLuong] = new PhieuNhap();
                dsPN[soLuong].setIdPhieuNhap(fin.next());
                dsPN[soLuong].setIdNhaCungCap(fin.next());
                dsPN[soLuong].setTongTien(fin.nextInt());
                dsPN[soLuong].setNgayNhap(convertStringToDate(fin.next()));

                dsPN[soLuong].setSoLuongSach(fin.nextInt());
                dsPN[soLuong].setIdSach(fin.next());
                ++soLuong;
            }
            fin.close();
            if (hasData) {
                System.out.println("LAY DU LIEU THANH CONG");
            } else {
                System.out.println("KHONG CO DU LIEU");
            }
        } catch (Exception e) {
            System.out.println("File reading unsuccessful/incomplete due to " + e.toString());
        }
    }

    public void writeFile() {
        System.out.println("\t\t\tTHEM PHIEU NHAP");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phieu nhap: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (FileWriter writer = new FileWriter("src/data/DanhSachPhieuNhap.txt", true)) {
            for (int i = 0; i < n; i++) {
                PhieuNhap phieuNhap = new PhieuNhap();
                System.out.println("Nhap thong tin phieu nhap thu " + (i + 1) + ":");
                //id phieu nhap
                System.out.print("ID Phieu Nhap: ");
                String idPhieuNhap = scanner.nextLine();
                while (!kiemTraIdDuyNhat(idPhieuNhap)) {
                    System.out.println("ID da ton tai. Vui long nhap lai: ");
                    idPhieuNhap = scanner.nextLine();
                }
                phieuNhap.setIdPhieuNhap(idPhieuNhap);
                //id nha cung cap
                System.out.print("ID Nha Cung Cap: ");
                phieuNhap.setIdNhaCungCap(scanner.nextLine());
                //tong tien
                System.out.print("Tong Tien: ");
                phieuNhap.setTongTien(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Ngay Nhap (dd/mm/yyyy): ");
                phieuNhap.setNgayNhap(convertStringToDate(scanner.nextLine()));
                System.out.print("So Luong Sach: ");
                phieuNhap.setSoLuongSach(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("ID Sach: ");
                phieuNhap.setIdSach(scanner.nextLine());

                themPhieuNhap(phieuNhap);

                writer.write(phieuNhap.getIdPhieuNhap() + " ");
                writer.write(phieuNhap.getIdNhaCungCap() + " ");
                writer.write(phieuNhap.getTongTien() + " ");
                writer.write(phieuNhap.getNgayNhap().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " ");
                writer.write(phieuNhap.getSoLuongSach() + " ");
                writer.write(phieuNhap.getIdSach() + "\n");
                System.out.println("Them phieu nhap thanh cong.");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
