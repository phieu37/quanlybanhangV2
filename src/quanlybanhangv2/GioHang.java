/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangv2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ideapad
 */
public class GioHang {

    private List<HoaDon> gioHang = new ArrayList<>();
    private DanhSachKhachHang danhSachKhachHang;
    private DanhSachSanPham danhSachSanPham;
    private DanhSachNhanVien danhSachNhanVien;

//     private ArrayList<HoaDon> gioHang; 
//    public GioHang() {
//        this.gioHang = new ArrayList<>();
//    }
    public GioHang(DanhSachKhachHang danhSachKhachHang, DanhSachNhanVien danhSachNhanVien, DanhSachSanPham danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
        this.danhSachKhachHang = danhSachKhachHang;
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public boolean kiemTraDanhSachRong() {
        return this.gioHang.isEmpty();
    }

    public void clear() {
        gioHang.clear();
    }

    public KhachHang timKhachHangTheoMa(String maKhachHang) {
        for (KhachHang khachHang : danhSachKhachHang.getDanhSachKhachHang()) {
            if (khachHang.getMa().equals(maKhachHang)) {
                return khachHang;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public SanPham timSanPhamTheoMa(String maSanPham) {
        for (SanPham sanPham : danhSachSanPham.getDanhSachSanPham()) {
            if (sanPham.getMa().equals(maSanPham)) {
                return sanPham;
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }

    public NhanVien timNhanVienTheoMa(String maNhanVien) {
        for (NhanVien nhanVien : danhSachNhanVien.getDanhSachNhanVien()) {
            if (nhanVien.getMa().equals(maNhanVien)) {
//                System.out.println("Mã đã tồn tại.");
                return nhanVien;
            }
        }
//        System.out.println("Mã không tồn tại");
        return null;
    }

    public void add(HoaDon hoaDon) {
        gioHang.add(hoaDon);
    }

    public double tinhTongTien() {
        double tongTien = 0;
        for (HoaDon hoaDon : gioHang) {
            tongTien += hoaDon.getThanhTien();
        }
        return tongTien;
    }

//    C1: in KQ nhiều lần
//    public void hienThiHoaDon(double tongTien) {
//        System.out.println("Thông tin hóa đơn:");
//        System.out.println("|  STT  |  Mã sản phẩm  |  Tên sản phẩm  |  Số lượng mua  |  Đơn giá  |  Thành tiền  |  Tổng tiền  |");
//        int stt = 1;
//        for (HoaDon hoaDon : gioHang) {
//            System.out.println(String.format("|   %d   |  %11s  |  %12s  |  %12d  |  %7.2f  |  %10.2f  |  %9.2f  |", stt, hoaDon.getMaSanPham().getMa(), hoaDon.getMaSanPham().getTen(), hoaDon.getSoLuongMua(), hoaDon.getDonGia(), hoaDon.getThanhTien(), tongTien));
//            stt++;
//        }
//    }
//    C2: in KG 1 lần
    public void hienThiHoaDon(double tongTien) {
        System.out.println("Thông tin hóa đơn:");
        System.out.println("|  STT  |  Mã sản phẩm  |  Tên sản phẩm  |  Số lượng mua  |  Đơn giá  |  Thành tiền  |  Tổng tiền  |");
        int stt = 1;
        boolean daInTongTien = false; // Biến để kiểm tra đã in tổng tiền hay chưa
        for (HoaDon hoaDon : gioHang) {
            System.out.println(String.format("|   %d   |  %11s  |  %12s  |  %12d  |  %7.2f  |  %10.2f  |  %9s  |",
                    stt, hoaDon.getMaSanPham().getMa(), hoaDon.getMaSanPham().getTen(),
                    hoaDon.getSoLuongMua(), hoaDon.getDonGia(), hoaDon.getThanhTien(),
                    daInTongTien ? "" : String.format("%9.2f", tongTien)));
            stt++;
            daInTongTien = true; // Đặt biến daInTongTien thành true sau khi in tổng tiền lần đầu
        }
    }

    public void LuuHoaDon() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hoadon.txt", true))) {
            for (HoaDon hoaDon : gioHang) {
                writer.write(hoaDon.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void docKhachHangTuFile(String tenTep) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(tenTep))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(", ");
//                if (parts.length == 5) {
//                    try {
//                        String ma = parts[0].trim().split("=")[1];
//                        String ten = parts[1].trim().split("=")[1];
//                        String soDienThoai = parts[2].trim().split("=")[1];
//                        String email = parts[3].trim().split("=")[1];
//                        String diaChi = parts[4].trim().split("=")[1];
//
//                        KhachHang khachHang = new KhachHang(ma, ten, soDienThoai, email, diaChi);
//                        danhSachKhachHang.add(khachHang);
//                    } catch (NumberFormatException e) {
//                        System.out.println("Dòng không đúng định dạng: " + line);
//                    }
//                } else {
//                    System.out.println("Dòng không đúng định dạng: " + line);
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(DanhSachKhachHang.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(DanhSachKhachHang.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    public void docHoaDonTuFile(String tenTep) {
        try (BufferedReader reader = new BufferedReader(new FileReader(tenTep))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 7) {
                    try {
                        // Tách thông tin từ chuỗi và tạo các đối tượng
                        // đọc và tạo các đối tượng KhachHang, NhanVien, SanPham trước khi tạo đối tượng HoaDon
                        String maKhachHangStr = parts[0].split("=")[1].trim();
                        KhachHang maKhachHang = timKhachHangTheoMa(maKhachHangStr);

                        String maNhanVienStr = parts[1].split("=")[1].trim();
                        NhanVien maNhanVien = timNhanVienTheoMa(maNhanVienStr);

                        String maSanPhamStr = parts[2].split("=")[1].trim();
                        SanPham maSanPham = timSanPhamTheoMa(maSanPhamStr);

                        int soLuongMua = Integer.parseInt(parts[3].split("=")[1].trim());
                        double donGia = Double.parseDouble(parts[4].split("=")[1].trim());
                        double thanhTien = Double.parseDouble(parts[5].split("=")[1].trim());
                        LocalDateTime ngayBan = LocalDateTime.parse(parts[6].split("=")[1].trim(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

                        HoaDon hoaDon = new HoaDon(maKhachHang, maNhanVien, maSanPham, soLuongMua, donGia, thanhTien, ngayBan);
                        gioHang.add(hoaDon);
                    } catch (NumberFormatException | DateTimeParseException e) {
                        System.out.println("Dòng không đúng định dạng hoặc có lỗi: " + line);
                    }
                } else {
                    System.out.println("Dòng không đúng định dạng: " + line);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Phương thức để xem danh sách hóa đơn trong 1 ngày và tính tổng số tiền
    public void xemHoaDonTrongNgay(LocalDate ngay) {
        double tongTien = 0;
        LocalDateTime batDauNgay = ngay.atStartOfDay(); // Chuyển ngày thành LocalDateTime với giờ, phút, giây là 00:00:00
        LocalDateTime ketThucNgay = ngay.atTime(23, 59, 59); // Chuyển ngày thành LocalDateTime với giờ, phút, giây là 23:59:59

        for (HoaDon hoaDon : gioHang) {
            LocalDateTime ngayBan = hoaDon.getNgayBan();
            if (ngayBan.isEqual(batDauNgay) || (ngayBan.isAfter(batDauNgay) && ngayBan.isBefore(ketThucNgay))) {
                System.out.println(hoaDon);         // In thông tin hóa đơn
                tongTien += hoaDon.getThanhTien();
            }
        }
        System.out.println("Tổng số tiền bán trong ngày: " + tongTien);
    }

    // Phương thức để xem danh sách hóa đơn trong 1 tháng và tính tổng số tiền
    public void xemHoaDonTrongThang(int nam, int thang) {
        double tongTien = 0;
        LocalDateTime batDauThang = LocalDateTime.of(nam, thang, 1, 0, 0); // Bắt đầu tháng
        LocalDateTime ketThucThang = batDauThang.plusMonths(1); // Kết thúc tháng tiếp theo

        for (HoaDon hoaDon : gioHang) {
            LocalDateTime ngayBan = hoaDon.getNgayBan();
            if ((ngayBan.isEqual(batDauThang) || (ngayBan.isAfter(batDauThang) && ngayBan.isBefore(ketThucThang)))) {
                System.out.println(hoaDon); // In thông tin hóa đơn
                tongTien += hoaDon.getThanhTien();
            }
        }
        System.out.println("Tổng số tiền bán trong tháng: " + tongTien);
    }

    public void LuuHoaDonTrongThang() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("hoadonthang.txt"))) {
            for (HoaDon hoaDon : gioHang) {
                writer.write(hoaDon.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(GioHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    C1: dùng Map
//    public void xemDoanhThuTheoNhanVienTrongThang(int thang, int nam) {
//        // Tạo một bản đồ để lưu trữ tổng doanh thu của từng nhân viên
//        Map<String, Double> doanhThuTheoNhanVien = new HashMap<>();
//
//        // Lặp qua danh sách hóa đơn
//        for (HoaDon hoaDon : gioHang) {
//            LocalDate ngayBan = hoaDon.getNgayBan().toLocalDate(); // Lấy phần ngày của hóa đơn
//
//            // Kiểm tra xem hóa đơn có trong tháng không
//            if (ngayBan.getMonthValue() == thang && ngayBan.getYear() == nam) {
//                String maNhanVien = hoaDon.getMaNhanVien().getMa();
//
//                // Kiểm tra mã nhân viên không phải là null hoặc trống  
//                if (maNhanVien != null && !maNhanVien.isEmpty()) {
//                    double doanhThu = hoaDon.getThanhTien();
//
//                    // Cộng tổng doanh thu của nhân viên
//                    if (doanhThuTheoNhanVien.containsKey(maNhanVien)) {
//                        double tongDoanhThu = doanhThuTheoNhanVien.get(maNhanVien);
//                        tongDoanhThu += doanhThu;
//                        doanhThuTheoNhanVien.put(maNhanVien, tongDoanhThu);
//                    } else {
//                        doanhThuTheoNhanVien.put(maNhanVien, doanhThu);
//                    }
//                }
//            }
//        }
//
//        // In tổng doanh thu của từng nhân viên
//        for (Map.Entry<String, Double> entry : doanhThuTheoNhanVien.entrySet()) {
//            String maNhanVien = entry.getKey();
//            double doanhThu = entry.getValue();
//            System.out.println("Nhân viên " + maNhanVien + ": " + doanhThu);
//        }
//    }

//    C2: dùng ArrayList để theo dõi những nhân viên đã được xử lý
//    public void xemDoanhThuTheoNhanVienTrongThang(int thang, int nam) {
//        // hiển thị mỗi nhân viên một lần khi tính toán tổng doanh thu để ko in trùng KQ
//        ArrayList<String> daXuLy = new ArrayList<>();
//
//        // duyệt qua danh sách hóa đơn trong gioHang
//        for (HoaDon hoaDon : gioHang) {
//            LocalDateTime ngayBan = hoaDon.getNgayBan();
//
//            // đúng tháng năm thì lấy mã nhân viên trong hóa đơn
//            if (ngayBan.getYear() == nam && ngayBan.getMonthValue() == thang) {
//                NhanVien maNhanVien = hoaDon.getMaNhanVien();
//
//                // Kiểm tra xem mã nhân viên đã xử lý chưa -> chưa thì thêm vào 
//                if (!daXuLy.contains(maNhanVien.getMa())) {
//                    daXuLy.add(maNhanVien.getMa());
//                    // Tính tổng doanh thu cho nhân viên này
//                    double tongDoanhThu = 0;
//                    // duyệt qua danh sách hóa đơn trong gioHang để tính tổng doanh thu của nhân viên 
//                    for (HoaDon hoaDon1 : gioHang) {
//                        if (hoaDon1.getMaNhanVien().equals(maNhanVien)) {
//                            tongDoanhThu += hoaDon1.getThanhTien();
//                        }
//                    }
//                    System.out.println("Nhân viên " + maNhanVien.getMa() + " có tổng doanh thu trong tháng " + thang + "/" + nam + ": " + tongDoanhThu);
//                }
//            }
//        }
//    }
    
//    C3: tạo biến rỗng để lưu trạng thái xử lý của từng nhân viên
    public void xemDoanhThuTheoNhanVienTrongThang(int thang, int nam) {
        String nhanVienDaXuLy = "";

        for (HoaDon hoaDon : gioHang) {
            LocalDateTime ngayBan = hoaDon.getNgayBan();

            if (ngayBan.getYear() == nam && ngayBan.getMonthValue() == thang) {
                NhanVien maNhanVien = hoaDon.getMaNhanVien();
                String maNhanVienStr = maNhanVien.getMa();

                // Nếu nhân viên đã được xử lý chưa thì xử lý , xử lý rồi gán = rỗng
                if (!maNhanVienStr.equals(nhanVienDaXuLy)) {
                    nhanVienDaXuLy = maNhanVienStr; // Đánh dấu rằng nhân viên đã được xử lý
                    double tongDoanhThu = 0;

                    // Tính tổng doanh thu cho nhân viên này
                    for (HoaDon hoaDon1 : gioHang) {
                        if (hoaDon1.getMaNhanVien().equals(maNhanVien)) {
                            tongDoanhThu += hoaDon1.getThanhTien();
                        }
                    }

                    System.out.println("Nhân viên " + maNhanVien.getMa() + " có tổng doanh thu trong tháng " + thang + "/" + nam + ": " + tongDoanhThu);
                }
            }
        }
    }
    
//    C4: Cách này hiện cả KQ trùng 
//    public void xemDoanhThuTheoNhanVienTrongThang(int thang, int nam) {
//        for (HoaDon hoaDon : gioHang) {
//            LocalDateTime ngayBan = hoaDon.getNgayBan();
//
//            if (ngayBan.getYear() == nam && ngayBan.getMonthValue() == thang) {
//                NhanVien maNhanVien = hoaDon.getMaNhanVien();
//
//                // Kiểm tra xem nhân viên đã được xử lý chưa
//                boolean daXuLy = false;
//
//                // Duyệt qua danh sách hóa đơn một lần nữa để kiểm tra
//                // và tính tổng doanh thu của từng nhân viên
//                double tongDoanhThu = 0;
//                for (HoaDon hoaDon1 : gioHang) {
//                    if (hoaDon1.getMaNhanVien().equals(maNhanVien)) {
//                        if (!daXuLy) {
//                            daXuLy = true; // Đánh dấu rằng mã nhân viên đã được xử lý
//                            // Tính tổng doanh thu cho nhân viên này
//                            for (HoaDon hoaDon2 : gioHang) {
//                                if (hoaDon2.getMaNhanVien().equals(maNhanVien)) {
//                                    tongDoanhThu += hoaDon2.getThanhTien();
//                                }
//                            }
//                            System.out.println("Nhân viên " + maNhanVien.getMa() + " có tổng doanh thu trong tháng " + thang + "/" + nam + ": " + tongDoanhThu);
//                        }
//                    }
//                }
//            }
//        }
//    }

}
