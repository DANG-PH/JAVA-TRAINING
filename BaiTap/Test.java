import java.util.*;

public class Test {
    private Map<String, List<String[]>> danhSach = new HashMap<>();

    public void themSach(String tenSach, String tenTacGia,String namXuatBan) {
        if (danhSach.containsKey(tenTacGia)) {
            danhSach.get(tenTacGia).add(new String[]{tenSach,namXuatBan});
        } else {
            List<String[]> sachMoi = new ArrayList<>();
            sachMoi.add(new String[]{tenSach,namXuatBan});
            danhSach.put(tenTacGia, sachMoi);
        }
    }

    public void inDanhSach() {
        for (String tacGia : danhSach.keySet()) {
            System.out.println("Tác giả: " + tacGia);
            List<String[]> sachList = danhSach.get(tacGia);
            System.out.print("Sách, Năm xuất bản: ");
            for (int i = 0; i < sachList.size(); i++) {
                System.out.print(sachList.get(i)[0]);
                System.out.print(" ("+sachList.get(i)[1]+")");
                if (i < sachList.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.themSach("Lập trình Java cơ bản", "Nguyễn Văn A","1965");
        test.themSach("Lập trình nâng cao", "Nguyễn Văn A","1965");
        test.themSach("Kiến thức mạng", "Trần Thị B","1965");
        test.inDanhSach();
    }
}
