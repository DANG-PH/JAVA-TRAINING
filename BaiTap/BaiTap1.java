import java.util.*;
class HinhChuNhat {
    private float chieuDai;
    private float chieuRong;
    public HinhChuNhat(float chieuDai, float chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public float tinhChuVi() {
        return (chieuDai+chieuRong)*2;
    }

    public float tinhDienTich() {
        return chieuRong*chieuDai;
    }

    public void hienThiThongTin() {
        System.out.println(tinhChuVi()+" ,"+tinhDienTich());
    }
}

public class BaiTap1 {
    public static void main(String[] args) {
        List<HinhChuNhat> listHcn = new ArrayList<>();
        listHcn.add(new HinhChuNhat(6.5f,7f));
        listHcn.add(new HinhChuNhat(6f,6.5f));
        listHcn.add(new HinhChuNhat(5.5f,6f));

        for (HinhChuNhat hcn : listHcn) {
            hcn.hienThiThongTin();
        }
    }
}
