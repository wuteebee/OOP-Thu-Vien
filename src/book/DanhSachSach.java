package book;

public class DanhSachSach {
    public static int soLuong = 0;
    private Sach[] dSS;

    public DanhSachSach() {
        this.dSS = new Sach[0];
    }

    public void themSach (Sach sach) {
        Sach[] newDSS = new Sach[++soLuong];
        if (soLuong - 1 >= 0) System.arraycopy(this.dSS, 0, newDSS, 0, soLuong - 1);
        newDSS[soLuong - 1] = sach;
        this.dSS = newDSS;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(Sach sach : this.dSS) {
            output.append(sach).append("\n");
        }
        return output.toString();
    }
}

