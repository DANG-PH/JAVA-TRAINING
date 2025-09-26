package BaiTapTrenLop.QuanLyNhanVien_2;
import java.util.*;
//Bài 2 - interface + đa kế thừa hành vi + đa hình qua interface.
/*
📌 Diagram (Interface + Class UML):
        +-----------------+
        |    GuiEmail     |<<interface>>
        +-----------------+
        | + guiEmail()    |
        +-----------------+

        +-----------------+
        |  LapTrinhVien   |<<interface>>
        +-----------------+
        | + lapTrinh()    |
        +-----------------+

        +-----------------+
        | NhanVienBanHang |<<interface>>
        +-----------------+
        | + banHang()     |
        +-----------------+

        +--------------------+   +---------------------+   +----------------------+
        | NhanVienVanPhong   |   | NhanVienKyThuat     |   | NhanVienKinhDoanh    |
        +--------------------+   +---------------------+   +----------------------+
        | implements         |   | implements          |   | implements           |
        | GuiEmail           |   | GuiEmail, LapTrinhVien| | GuiEmail, NhanVienBanHang|
        +--------------------+   +---------------------+   +----------------------+

*/

// Interface gửi email
interface GuiEmail {
    void guiEmail();
}

// Interface lập trình
interface LapTrinhVien {
    void lapTrinh();
}

// Interface bán hàng
interface NhanVienBanHang {
    void banHang();
}

// Nhân viên văn phòng: chỉ gửi email
class NhanVienVanPhong implements GuiEmail {
    @Override
    public void guiEmail() {
        System.out.println("Nhân viên văn phòng đang gửi email...");
    }
}

// Nhân viên kỹ thuật: lập trình + gửi email
class NhanVienKyThuat implements GuiEmail, LapTrinhVien {
    @Override
    public void guiEmail() {
        System.out.println("Nhân viên kỹ thuật đang gửi email...");
    }

    @Override
    public void lapTrinh() {
        System.out.println("Nhân viên kỹ thuật đang lập trình...");
    }
}

// Nhân viên bán hàng: bán hàng + gửi email
class NhanVienKinhDoanh implements GuiEmail, NhanVienBanHang {
    @Override
    public void guiEmail() {
        System.out.println("Nhân viên kinh doanh đang gửi email cho khách hàng...");
    }

    @Override
    public void banHang() {
        System.out.println("Nhân viên kinh doanh đang bán hàng...");
    }
}

public class QuanLyNhanVien {
    public static void main(String[] args) {
        List<Object> danhSachNhanVien = new ArrayList<>();
        danhSachNhanVien.add(new NhanVienVanPhong());
        danhSachNhanVien.add(new NhanVienKyThuat());
        danhSachNhanVien.add(new NhanVienKinhDoanh());

        for (Object nv : danhSachNhanVien) {
            if (nv instanceof GuiEmail) {
                ((GuiEmail) nv).guiEmail();
            }
            if (nv instanceof LapTrinhVien) {
                ((LapTrinhVien) nv).lapTrinh();
            }
            if (nv instanceof NhanVienBanHang) {
                ((NhanVienBanHang) nv).banHang();
            }
        }
    }
}

