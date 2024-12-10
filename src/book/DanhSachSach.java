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

import data.SharedData;
import execute.Menu;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DanhSachSach {

    public static int soLuong = 0;
    public Sach[] dSSach;

    public DanhSachSach() {
        dSSach = new Sach[0];
    }

    public Sach[] moRongDanhSach(int soLuongSach) {
        Sach[] newDSSach = new Sach[soLuong + soLuongSach];
        if (soLuong > 0) {
            System.arraycopy(this.dSSach, 0, newDSSach, 0, soLuong);
        }
        return this.dSSach = newDSSach;
    }

    public Sach[] getDSSach() {
        return this.dSSach;
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
        System.out.println("Chinh sua thong tin sach");

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
            System.out.println("Khon tim thay sach hoac sach da duoc mo khoa!");
        } else {
            sach.setTrangThai(true);
            System.out.println("Da mo khoa sach!");
        }
    }

    public Map<String, Integer> kiemTraTrinhDo() {
        int count = 0;
        Map<String, Integer> stringMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachGiaoKhoa) {
                if (!stringMap.containsKey(((SachGiaoKhoa) sach).getTrinhDo())) {
                    stringMap.put(((SachGiaoKhoa) sach).getTrinhDo(), 0);
                }
            }
        }
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            mapElement.setValue(++count);
        }
        return stringMap;
    }

    public String xuatTrinhDo(Map<String, Integer> stringMap) {
        String trinhDo = "";
        System.out.println("Lua chon trinh do: ");
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            System.out.println(mapElement.getValue() + ". " + mapElement.getKey());
        }
        int luaChon = Menu.input.nextInt();
        Menu.input.nextLine();
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            if (mapElement.getValue() == luaChon) {
                trinhDo = mapElement.getKey();
                break;
            }
        }
        return trinhDo;
    }

    public Map<String, Integer> timLinhVucTheoTrinhDo(String trinhDo) {
        int count = 0;
        Map<String, Integer> stringMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachGiaoKhoa) {
                if (((SachGiaoKhoa) sach).getTrinhDo().equals(trinhDo)) {
                    stringMap.put(((SachGiaoKhoa) sach).getLinhVuc(), 0);
                }
            }
        }
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            mapElement.setValue(++count);
        }
        return stringMap;
    }

    public String xuatLinhVuc(Map<String, Integer> stringMap) {
        String linhVuc = "";
        System.out.println("Lua chon linh vuc: ");
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            System.out.println(mapElement.getValue() + ". " + mapElement.getKey());
        }
        int luaChon = Menu.input.nextInt();
        Menu.input.nextLine();
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            if (mapElement.getValue() == luaChon) {
                linhVuc = mapElement.getKey();
                break;
            }
        }
        return linhVuc;
    }

    public SachGiaoKhoa timSachTheoTrinhDoVaLinhVuc() {
        String trinhDo = xuatTrinhDo(kiemTraTrinhDo());
        String linhVuc = xuatLinhVuc(timLinhVucTheoTrinhDo(trinhDo));
        SachGiaoKhoa sachGiaoKhoa = new SachGiaoKhoa();
        Map<SachGiaoKhoa, String> sachMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachGiaoKhoa) {
                if (((SachGiaoKhoa) sach).getTrinhDo().equals(trinhDo) && ((SachGiaoKhoa) sach).getLinhVuc().equals(linhVuc)) {
                    sachMap.put((SachGiaoKhoa) sach, ((SachGiaoKhoa) sach).getIDSach());
                }
            }
        }
        for (Map.Entry<SachGiaoKhoa, String> mapElement : sachMap.entrySet()) {
            System.out.println(String.format("%-10s%-30s", mapElement.getValue(), mapElement.getKey().getTen()));
        }
        System.out.println("Nhap ID sach:");
        String idSach = Menu.input.nextLine();
        for (Map.Entry<SachGiaoKhoa, String> mapElement : sachMap.entrySet()) {
            if (mapElement.getValue().equals(idSach)) {
                sachGiaoKhoa = mapElement.getKey();
                break;
            }
        }
        return sachGiaoKhoa;
    }

    public Map<String, Integer> kiemTraChuyenNganh() {
        int count = 0;
        Map<String, Integer> stringMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachThamKhao) {
                if (!stringMap.containsKey(((SachThamKhao) sach).getChuyenNganh())) {
                    stringMap.put(((SachThamKhao) sach).getChuyenNganh(), 0);
                }
            }
        }
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            mapElement.setValue(++count);
        }
        return stringMap;
    }

    public String xuatChuyenNganh(Map<String, Integer> stringMap) {
        String chuyenNganh = "";
        System.out.println("Lua chon chuyen nganh: ");
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            System.out.println(mapElement.getValue() + ". " + mapElement.getKey());
        }
        int luaChon = Menu.input.nextInt();
        Menu.input.nextLine();
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            if (mapElement.getValue() == luaChon) {
                chuyenNganh = mapElement.getKey();
                break;
            }
        }
        return chuyenNganh;
    }

    public Map<String, Integer> timDeTaiTheoChuyenNganh(String chuyenNganh) {
        int count = 0;
        Map<String, Integer> stringMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachThamKhao) {
                if (((SachThamKhao) sach).getChuyenNganh().equals(chuyenNganh)) {
                    stringMap.put(((SachThamKhao) sach).getDeTai(), 0);
                }
            }
        }
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            mapElement.setValue(++count);
        }
        return stringMap;
    }

    public String xuatDeTai(Map<String, Integer> stringMap) {
        String deTai = "";
        System.out.println("Lua chon de tai: ");
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            System.out.println(mapElement.getValue() + ". " + mapElement.getKey());
        }
        int luaChon = Menu.input.nextInt();
        Menu.input.nextLine();
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            if (mapElement.getValue() == luaChon) {
                deTai = mapElement.getKey();
                break;
            }
        }
        return deTai;
    }

    public SachThamKhao timSachTheoChuyenNganhVaDeTai() {
        System.out.println("Chay");
        String chuyenNganh = xuatChuyenNganh(kiemTraChuyenNganh());
        String deTai = xuatDeTai(timDeTaiTheoChuyenNganh(chuyenNganh));
        SachThamKhao sachThamKhao = new SachThamKhao();
        Map<SachThamKhao, String> sachMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachThamKhao) {
                if (((SachThamKhao) sach).getChuyenNganh().equals(chuyenNganh) && ((SachThamKhao) sach).getDeTai().equals(deTai)) {
                    sachMap.put((SachThamKhao) sach, ((SachThamKhao) sach).getIDSach());
                }
            }
        }
        for (Map.Entry<SachThamKhao, String> mapElement : sachMap.entrySet()) {
            System.out.println(String.format("%-10s%-30s", mapElement.getValue(), mapElement.getKey().getTen()));
        }
        System.out.println("Nhap ID sach:");
        String idSach = Menu.input.nextLine();
        for (Map.Entry<SachThamKhao, String> mapElement : sachMap.entrySet()) {
            if (mapElement.getValue().equals(idSach)) {
                sachThamKhao = mapElement.getKey();
                break;
            }
        }
        return sachThamKhao;
    }

    public Map<String, Integer> tatCaTrinhDo() {
        int count = 0;
        Map<String, Integer> stringMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachGiaoKhoa) {
                stringMap.put(((SachGiaoKhoa) sach).getTrinhDo(), 0);
            }
        }
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            mapElement.setValue(count++);
        }
        return stringMap;
    }

    public Map<String, Integer> tatCaLinhVuc() {
        int count = 0;
        Map<String, Integer> stringMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachGiaoKhoa) {
                stringMap.put(((SachGiaoKhoa) sach).getLinhVuc(), 0);
            }
        }
        for (Map.Entry<String, Integer> mapElement : stringMap.entrySet()) {
            mapElement.setValue(count++);
        }
        return stringMap;
    }

    public void thongKeTrinhDoLinhVuc() {
        Map<String, Integer> trinhDoMap = tatCaTrinhDo();
        Map<String, Integer> linhVucMap = tatCaLinhVuc();
        int soTrinhDo = 0;
        int soLinhVuc = 0;

        for (Map.Entry<String, Integer> mapElement : trinhDoMap.entrySet()) {
            soTrinhDo = mapElement.getValue();
        }
        ++soTrinhDo;

        for (Map.Entry<String, Integer> mapElement : linhVucMap.entrySet()) {
            soLinhVuc = mapElement.getValue();
        }
        ++soLinhVuc;
        // System.out.println(soTrinhDo + " " + soLinhVuc);
        int viTriTrinhDo;
        int viTriLinhVuc;
        // System.out.println(toString());
        int[][] thongKe = new int[soTrinhDo][soLinhVuc];
        for (Sach sach : dSSach) {
            if (sach instanceof SachGiaoKhoa) {
                System.out.println("CHAY");
                viTriTrinhDo = trinhDoMap.get(((SachGiaoKhoa) sach).getTrinhDo());
                viTriLinhVuc = linhVucMap.get(((SachGiaoKhoa) sach).getLinhVuc());
                thongKe[viTriTrinhDo][viTriLinhVuc]++;
            }
        }
        // System.out.println(trinhDoMap);
        // System.out.println(linhVucMap);
        System.out.print(String.format("%-20s", ""));
        for (Map.Entry<String, Integer> mapElement : trinhDoMap.entrySet()) {
            System.out.print(String.format("%-20s", mapElement.getKey()));
        }
        viTriTrinhDo = 0; // tang 
        viTriLinhVuc = 0;
        System.out.println();
        for (Map.Entry<String, Integer> mapElement : linhVucMap.entrySet()) {
            System.out.print(String.format("%-20s", mapElement.getKey()));
            for (viTriTrinhDo = 0; viTriTrinhDo < soTrinhDo; ++viTriTrinhDo) {
                System.out.print(String.format("%-20d", thongKe[viTriTrinhDo][viTriLinhVuc]));
            }
            viTriLinhVuc++;
            System.out.println();
        }
    }

    public void thongKeChuyenNganhDeTai() {
        Map<String, Integer> chuyenNganhMap = new HashMap<>();
        Map<String, Integer> deTaiMap = new HashMap<>();
        for (Sach sach : dSSach) {
            if (sach instanceof SachThamKhao) {
                chuyenNganhMap.put(((SachThamKhao) sach).getChuyenNganh(), 0);
                deTaiMap.put(((SachThamKhao) sach).getDeTai(), 0);
            }
        }

        int soChuyenNganh = 0;
        int soDeTai = 0;

        for (Map.Entry<String, Integer> mapElement : chuyenNganhMap.entrySet()) {
            mapElement.setValue(soChuyenNganh++);
        }
        for (Map.Entry<String, Integer> mapElement : deTaiMap.entrySet()) {
            mapElement.setValue(soDeTai++);
        }
        

        int viTriChuyenNganh = 0;
        int viTriDeTai = 0;
        int[][] thongKe = new int[soChuyenNganh][soDeTai];
        for (Sach sach : dSSach) {
            if (sach instanceof SachThamKhao) {
                viTriChuyenNganh = chuyenNganhMap.get(((SachThamKhao) sach).getChuyenNganh());
                viTriDeTai = deTaiMap.get(((SachThamKhao) sach).getDeTai());
                ++thongKe[viTriChuyenNganh][viTriDeTai];
            }
        }

        System.out.print(String.format("|%-20s", ""));
        for (Map.Entry<String, Integer> mapElement : chuyenNganhMap.entrySet()) {
            System.out.print(String.format("|%-20s", mapElement.getKey()));
        }
        System.out.print("|\n");
        // System.out.println(soChuyenNganh + " " + soDeTai);
        viTriChuyenNganh = 0;
        viTriDeTai = 0;
        for (Map.Entry<String, Integer> mapElement : deTaiMap.entrySet()) {
            System.out.print(String.format("|%-20s", mapElement.getKey()));
            for(viTriChuyenNganh = 0; viTriChuyenNganh < soChuyenNganh; ++viTriChuyenNganh) {
                System.out.print(String.format("|%-20d", thongKe[viTriChuyenNganh][viTriDeTai]));
            }
            ++viTriDeTai;
            System.out.print("|\n");
        }

    }

    @Override
    public String toString() {


        StringBuilder giaoKhoa = new StringBuilder();
        StringBuilder thamKhao = new StringBuilder();

        giaoKhoa.append(String.format("%-139s\n", "").replace(' ', '-'))
                .append(String.format("|%-57s", ""))
                .append("Danh Sach Sach Giao Khoa")
                .append(String.format("%-56s|\n", ""))
                .append(String.format("%-139s\n", "").replace(' ', '-'))
                .append(String.format("|%-10s|%-30s|%-10s|%-10s|%-20s|%-20s|%-15s|%-15s|", "id", "ten", "tonKho", "gia", "tacGia", "nhaXuatBan" , "trinhDo", "linhVuc"))
                .append("\n");
        thamKhao.append(String.format("%-139s\n", "").replace(' ', '-'))
                .append(String.format("|%-57s", ""))
                .append("Danh Sach Sach Tham Khao")
                .append(String.format("%-56s|\n", ""))
                .append(String.format("%-139s\n", "").replace(' ', '-'))
                .append(String.format("|%-10s|%-30s|%-10s|%-10s|%-20s|%-20s|%-15s|%-15s|", "id", "ten", "tonKho", "gia", "tacGia", "nhaXuatBan" , "trinhDo", "linhVuc"))
                .append("\n");

        for (Sach sach : this.dSSach) {
            if(sach instanceof SachGiaoKhoa) giaoKhoa.append(((SachGiaoKhoa) sach)).append("\n");
            else if(sach instanceof SachThamKhao) thamKhao.append(((SachThamKhao) sach)).append("\n");
        }
        giaoKhoa.append(String.format("%-139s\n", "").replace(' ', '-'));
        thamKhao.append(String.format("%-139s\n", "").replace(' ', '-'));
        return giaoKhoa.toString() + thamKhao.toString();
    }

    public String toStringFormatted(Boolean trangThai) {
        StringBuilder sb = new StringBuilder();
        for (Sach sach : this.dSSach) {
            if (sach.getTrangThai() && trangThai) {
                sb.append(sach).append("\n");
            }
        }
        return sb.toString();
    }

    public String toStringToFile() {
        StringBuilder sb = new StringBuilder();
        for (Sach sach : dSSach) {
            if (sach instanceof SachGiaoKhoa) {
                sb.append(((SachGiaoKhoa) sach).toStringToFile()).append("\n");
            } else if (sach instanceof SachThamKhao) {
                sb.append(((SachThamKhao) sach).toStringToFile()).append("\n");
            }
        }
        return sb.toString();
    }

    public void writeFile() {
        try {
            FileWriter outputDSS = new FileWriter("src\\data\\DanhSachSach.txt", false);
            outputDSS.write(toStringToFile());
            outputDSS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        SachGiaoKhoa sachGiaoKhoa;
        SachThamKhao sachThamKhao;
        try {
            Scanner inputDSS = new Scanner(new File("src\\data\\DanhSachSach.txt"));
            inputDSS.useDelimiter(",");
            while (inputDSS.hasNextLine() && inputDSS.hasNext()) {
                String[] thuocTinh = inputDSS.nextLine().split(",");
                if (thuocTinh[0].equals("GK")) {
                    sachGiaoKhoa = new SachGiaoKhoa();
                    sachGiaoKhoa.setTrinhDo(thuocTinh[7]);
                    sachGiaoKhoa.setLinhVuc(thuocTinh[8]);
                    sachGiaoKhoa.setTen(thuocTinh[1]);
                    sachGiaoKhoa.setTonKho(Integer.parseInt(thuocTinh[2]));
                    sachGiaoKhoa.setGia(Integer.parseInt(thuocTinh[3]));
                    sachGiaoKhoa.setTacGia(SharedData.dSTG.timIDTacGia(thuocTinh[4]));
                    sachGiaoKhoa.setNhaXuatBan(SharedData.dSNXB.timIDNhaXuatBan(thuocTinh[5]));
                    sachGiaoKhoa.setTrangThai(Integer.parseInt(thuocTinh[6]) == 1);
                    SharedData.dSS.themSach(sachGiaoKhoa);
                } else if (thuocTinh[0].equals("TK")) {
                    sachThamKhao = new SachThamKhao();
                    sachThamKhao.setChuyenNganh(thuocTinh[7]);
                    sachThamKhao.setDeTai(thuocTinh[8]);
                    sachThamKhao.setTen(thuocTinh[1]);
                    sachThamKhao.setTonKho(Integer.parseInt(thuocTinh[2]));
                    sachThamKhao.setGia(Integer.parseInt(thuocTinh[3]));
                    sachThamKhao.setTacGia(SharedData.dSTG.timIDTacGia(thuocTinh[4]));
                    sachThamKhao.setNhaXuatBan(SharedData.dSNXB.timIDNhaXuatBan(thuocTinh[5]));
                    sachThamKhao.setTrangThai(Integer.parseInt(thuocTinh[6]) == 1);
                    SharedData.dSS.themSach(sachThamKhao);
                }
            }
            inputDSS.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
