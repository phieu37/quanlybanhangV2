/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlybanhangv2;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Ideapad
 */
public class Main {

    // phải khai báo static mới dùng được bên trong phương thức
    static Scanner scanner = new Scanner(System.in);
    public static DanhSachSanPham danhSachSanPham = new DanhSachSanPham();
    public static DanhSachNhanVien danhSachNhanVien = new DanhSachNhanVien();
    public static DanhSachKhachHang danhSachKhachHang = new DanhSachKhachHang();
    public static GioHang gioHang = new GioHang(danhSachKhachHang, danhSachNhanVien, danhSachSanPham);

    public static void main(String[] args) {

//        danhSachNhanVien.nhanVienDangNhap(new NhanVien("admin", "admin", "1234567890", "admin@abc.com", "vn", "admin", "Nam", "it", "ok"));
        danhSachNhanVien.docNhanVienTuFile("nhanvien.txt");
        danhSachKhachHang.docKhachHangTuFile("khachhang.txt");
        danhSachSanPham.docSanPhamTuFile("sanpham.txt");
        gioHang.docHoaDonTuFile("hoadon.txt");
        System.out.println("Dữ liệu đã được tải lên!!!");

        boolean dangNhap = false;
        NhanVien nhanVienDangNhap = null;

        while (!dangNhap) {
            System.out.println("---------- Đăng nhập ----------");
            System.out.print("Mã nhân viên: ");
            String maNhanVien = scanner.nextLine().trim();
            System.out.print("Mật khẩu: ");
            String matKhau = scanner.nextLine().trim();

            // Thực hiện đăng nhập
            nhanVienDangNhap = danhSachNhanVien.dangNhap(maNhanVien, matKhau);
//            danhSachNhanVien.xemDanhSachNhanVien();
            if (nhanVienDangNhap != null) {
                dangNhap = true;
                System.out.println("\nĐăng nhập thành công! " + maNhanVien);
                showMainMenu(danhSachNhanVien);
            } else {
                System.out.println("\nĐăng nhập không thành công. Vui lòng đăng nhập lại.");
            }
        }
    }

    public static void showMainMenu(DanhSachNhanVien danhSachNhanVien) {
        while (true) {
            System.out.println("-------- MENU CHÍNH --------");
            System.out.println("1. Menu khách hàng");
            System.out.println("2. Menu nhân viên");
            System.out.println("3. Menu sản phẩm");
            System.out.println("4. Menu bán hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());
                System.out.println();
                switch (choice) {
                    case 1:
                        showMenuKhachHang();
                        break;
                    case 2:
                        showMenuNhanVien();
                        break;
                    case 3:
                        showMemuSanPham();
                        break;
                    case 4:
                        showMemuBanHang();
                        break;
                    case 0:
                        System.out.println("Đã thoát khỏi chương trình.");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ 1.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ 2.");
            }
        }
    }

    ////////////////////////// showMenuKhachHang //////////////////////////
    public static void showMenuKhachHang() {

        while (true) {
            System.out.println("========== MENU KHÁCH HÀNG ==========");
            System.out.println("1. Xem danh sách toàn bộ khách hàng");
            System.out.println("2. Tìm kiếm khách hàng theo mã khách hàng/số điện thoại/email");
            System.out.println("3. Thêm mới một khách hàng");
            System.out.println("4. Sửa thông tin khách hàng");
            System.out.println("5. Xóa thông tin khách hàng");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            System.out.println();

            switch (choice) {
                case 1:
                    if (danhSachKhachHang.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng");
                    }

                    System.out.println("Danh sách khách hàng.");
                    danhSachKhachHang.xemDanhSach();
                    break;
                case 2:
                    if (danhSachKhachHang.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập mã khách hàng/số điện thoại/email: ");
                    String search = scanner.nextLine().trim();

                    danhSachKhachHang.timKiem(search);
                    break;
                case 3:
                    if (danhSachKhachHang.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.println("Thêm mới một khách hàng.");
                    String ma = "";
                    while (true) {
                        System.out.print("Mã khách hàng: ");
                        ma = scanner.nextLine().trim();
                        if (!danhSachKhachHang.kiemTraTrungMa(ma)) {
                            break;
                        }
                        System.out.println("Mã khách hàng đã tồn tại. Vui lòng nhập mã khác.");
                    }

                    String ten = "";
                    while (true) {
                        System.out.print("Tên khách hàng: ");
                        ten = scanner.nextLine().trim();
                        if (danhSachKhachHang.kiemTraTen(ten)) {
                            break;
                        }
                        System.out.println("Tên không được chứa số. Vui lòng nhập lại.");
                    }

                    String soDienThoai = "";
                    while (true) {
                        System.out.print("Số điện thoại: ");
                        soDienThoai = scanner.nextLine().trim();
                        if (danhSachKhachHang.kiemTraSoDienThoai(soDienThoai)) {
                            break;
                        }
                        System.out.println("Số điện thoại phải có từ 10 đến 11 chữ số. Vui lòng nhập lại.");
                    }

                    String email = "";
                    while (true) {
                        System.out.print("Email: ");
                        email = scanner.nextLine().trim();
                        if (danhSachKhachHang.kiemTraEmail(email)) {
                            break;
                        }
                        System.out.println("Email phải có định dạng xxx@abc.com. Vui lòng nhập lại.");
                    }

                    System.out.print("Địa chỉ: ");
                    String diaChi = scanner.nextLine().trim();

                    KhachHang khachHang = new KhachHang(ma, ten, soDienThoai, email, diaChi);
                    danhSachKhachHang.themKhachHang(khachHang);
                    System.out.println("\nThêm khách hàng mới thành công.");

                    //luu data
                    danhSachKhachHang.luuKhachHang();
                    System.out.println("Lưu khách hàng thành công.");
                    break;
                case 4:
                    if (danhSachKhachHang.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập mã khách hàng cần sửa: ");
                    String maCanSua = scanner.nextLine();

                    if (danhSachKhachHang.kiemTraTrungMa(maCanSua)) {
                        System.out.println("Nhập thông tin khách hàng mới, mã không thể sửa: ");

                        // Nhập và kiểm tra thông tin mới
                        String tenMoi = "";
                        while (true) {
                            System.out.print("Tên khách hàng mới: ");
                            tenMoi = scanner.nextLine().trim();
                            if (danhSachKhachHang.kiemTraTen(tenMoi)) {
                                break;
                            }
                            System.out.println("Tên không được chứa số. Vui lòng nhập lại.");
                        }

                        String soDienThoaiMoi = "";
                        while (true) {
                            System.out.print("Số điện thoại mới: ");
                            soDienThoaiMoi = scanner.nextLine().trim();
                            if (danhSachKhachHang.kiemTraSoDienThoai(soDienThoaiMoi)) {
                                break;
                            }
                            System.out.println("Số điện thoại phải có từ 10 đến 11 chữ số. Vui lòng nhập lại.");
                        }

                        String emailMoi = "";
                        while (true) {
                            System.out.print("Email mới: ");
                            emailMoi = scanner.nextLine().trim();
                            if (danhSachKhachHang.kiemTraEmail(emailMoi)) {
                                break;
                            }
                            System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
                        }

                        String diaChiMoi = "";
                        System.out.print("Địa chỉ mới: ");
                        diaChiMoi = scanner.nextLine().trim();

                        danhSachKhachHang.capNhatThongTinKhachHang(maCanSua, tenMoi, soDienThoaiMoi, emailMoi, diaChiMoi);
                        System.out.println("\nCập nhật thông tin thành công.");

                        // luu data
                        danhSachKhachHang.luuKhachHang();
                        System.out.println("Lưu khách hàng thành công.");
                    } else {
                        System.out.println("Không tìm thấy khách hàng có mã " + maCanSua);
                    }
                    break;

                case 5:
                    if (danhSachKhachHang.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng");
                    } else {
                        System.out.print("Nhập mã khách hàng cần xóa: ");
                        String maKhachHangXoa = scanner.nextLine().trim();

                        danhSachKhachHang.xoaKhachHang(maKhachHangXoa);
                        System.out.println("Xóa khách hàng thành công.");

                        danhSachKhachHang.luuKhachHang();
                        System.out.println("Lưu khách hàng thành công.");
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi menu khách hàng.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    ////////////////////////// showMenuNhanVien //////////////////////////
    public static void showMenuNhanVien() {
        while (true) {
            System.out.println("========== MENU NHÂN VIÊN ==========");
            System.out.println("1. Xem danh sách toàn bộ nhân viên");
            System.out.println("2. Tìm kiếm nhân viên theo mã nhân viên/số điện thoại/email");
            System.out.println("3. Thêm mới một nhân viên");
            System.out.println("4. Sửa thông tin nhân viên");
            System.out.println("5. Xóa thông tin nhân viên");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            System.out.println();

            switch (choice) {
                case 1:
                    if (danhSachNhanVien.kiemTraDanhSachRongNhanVien()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.println("Danh sách nhân viên.");
                    danhSachNhanVien.xemDanhSachNhanVien();
                    break;
                case 2:
                    if (danhSachNhanVien.kiemTraDanhSachRongNhanVien()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập mã nhân viên/số điện thoại/email: ");
                    String search = scanner.nextLine().trim();

                    danhSachNhanVien.timKiem(search);
                    break;
                case 3:
                    if (danhSachNhanVien.kiemTraDanhSachRongNhanVien()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.println("Thêm mới một nhân viên.");
                    String ma = "";
                    while (true) {
                        System.out.print("Mã nhân viên: ");
                        ma = scanner.nextLine().trim();
                        if (!danhSachNhanVien.kiemTraTrungMaNhanVien(ma)) {
                            break;
                        }
                        System.out.println("Mã nhân viên đã tồn tại. Vui lòng nhập mã khác.");
                    }

                    String ten = "";
                    while (true) {
                        System.out.print("Tên nhân viên: ");
                        ten = scanner.nextLine().trim();
                        if (danhSachNhanVien.kiemTraTenNhanVien(ten)) {
                            break;
                        }
                        System.out.println("Tên không được chứa số. Vui lòng nhập lại.");
                    }

                    String soDienThoai = "";
                    while (true) {
                        System.out.print("Số điện thoại: ");
                        soDienThoai = scanner.nextLine().trim();
                        if (danhSachNhanVien.kiemTraSoDienThoaiNhanVien(soDienThoai)) {
                            break;
                        }
                        System.out.println("Số điện thoại phải có từ 10 đến 11 chữ số. Vui lòng nhập lại.");
                    }

                    String email = "";
                    while (true) {
                        System.out.print("Email: ");
                        email = scanner.nextLine().trim();
                        if (danhSachNhanVien.kiemTraEmailNhanVien(email)) {
                            break;
                        }
                        System.out.println("Email phải có định dạng xxx@abc.com. Vui lòng nhập lại.");
                    }

                    System.out.print("Địa chỉ: ");
                    String diaChi = scanner.nextLine().trim();
                    System.out.print("Mật khẩu: ");
                    String matKhau = scanner.nextLine().trim();
                    System.out.print("Giới tính: ");
                    String gioiTinh = scanner.nextLine().trim();
                    System.out.print("Nhóm: ");
                    String nhom = scanner.nextLine().trim();
                    System.out.print("Trạng thái: ");
                    String trangThai = scanner.nextLine().trim();

                    NhanVien nhanVienMoi = new NhanVien(ma, ten, soDienThoai, email, diaChi, matKhau, gioiTinh, nhom, trangThai);
                    danhSachNhanVien.nhanVienDangNhap(nhanVienMoi);
                    System.out.println("\nThêm nhân viên mới thành công.");

                    // luu data
                    danhSachNhanVien.luuNhanVien();
                    System.out.println("Lưu nhân viên thành công.");
                    break;
                case 4:
                    if (danhSachNhanVien.kiemTraDanhSachRongNhanVien()) {
                        System.out.println("Danh sách trống.");
                    } else {
                        System.out.print("Nhập mã nhân viên cần sửa: ");
                        String maCanSua = scanner.nextLine();

                        if (danhSachNhanVien.kiemTraTrungMaNhanVien(maCanSua)) {
                            System.out.println("Nhập thông tin mới, mã nhân viên không thể sửa: ");

                            String tenMoi = "";
                            while (true) {
                                System.out.print("Tên nhân viên mới: ");
                                tenMoi = scanner.nextLine().trim();
                                if (danhSachNhanVien.kiemTraTenNhanVien(tenMoi)) {
                                    break;
                                }
                                System.out.println("Tên không được chứa số. Vui lòng nhập lại.");
                            }

                            String soDienThoaiMoi = "";
                            while (true) {
                                System.out.print("Số điện thoại mới: ");
                                soDienThoaiMoi = scanner.nextLine().trim();
                                if (danhSachNhanVien.kiemTraSoDienThoaiNhanVien(soDienThoaiMoi)) {
                                    break;
                                }
                                System.out.println("Số điện thoại phải có từ 10 đến 11 chữ số. Vui lòng nhập lại.");
                            }

                            String emailMoi = "";
                            while (true) {
                                System.out.print("Email mới: ");
                                emailMoi = scanner.nextLine().trim();
                                if (danhSachNhanVien.kiemTraEmailNhanVien(emailMoi)) {
                                    break;
                                }
                                System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
                            }

                            String diaChiMoi = "";
                            System.out.print("Địa chỉ mới: ");
                            diaChiMoi = scanner.nextLine().trim();

                            String matKhauMoi = "";
                            System.out.print("Mật khẩu mới(được mã hóa): ");
                            matKhauMoi = scanner.nextLine().trim();

                            String gioiTinhMoi = "";
                            System.out.print("Giới tính mới: ");
                            gioiTinhMoi = scanner.nextLine().trim();

                            String nhomMoi = "";
                            System.out.print("Nhóm mới: ");
                            nhomMoi = scanner.nextLine().trim();

                            String trangThaiMoi = "";
                            System.out.print("trạng thái mới: ");
                            trangThaiMoi = scanner.nextLine().trim();

                            danhSachNhanVien.capNhatThongTinNhanVien(maCanSua, tenMoi, soDienThoaiMoi, emailMoi, diaChiMoi, matKhauMoi, gioiTinhMoi, nhomMoi, trangThaiMoi);
                            System.out.println("\nCập nhật thông tin thành công.");

                            // luu data
                            danhSachNhanVien.luuNhanVien();
                            System.out.println("Lưu nhân viên thành công.");
                        } else {
                            System.out.println("Không tìm thấy nhân viên có mã: " + maCanSua);
                        }
                    }
                    break;
                case 5:
                    if (danhSachNhanVien.kiemTraDanhSachRongNhanVien()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập mã nhân viên cần xóa: ");
                    String maCanXoa = scanner.nextLine();

                    if (danhSachNhanVien.kiemTraTrungMaNhanVien(maCanXoa)) {
                        danhSachNhanVien.xoaNhanVien(maCanXoa);
                        System.out.println("Xóa nhân viên thành công.");

                        // luu data
                        danhSachNhanVien.luuNhanVien();
                        System.out.println("Lưu nhân viên thành công.");
                    } else {
                        System.out.println("Mã không tồn tại xóa không thành công. Vui lòng chọn lại.");
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi menu nhân viên.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        }
    }

    ////////////////////////// showMenSanPham //////////////////////////
    public static void showMemuSanPham() {
        while (true) {
            System.out.println("========== MENU SẢN PHẨM ==========");
            System.out.println("1. Xem danh sách toàn bộ sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm theo mã sản phẩm");
            System.out.println("3. Thêm mới một sản phẩm");
            System.out.println("4. Sửa thông tin sản phẩm");
            System.out.println("5. Xóa thông tin sản phẩm");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            System.out.println();

            switch (choice) {
                case 1:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.println("Danh sách sản phẩm:");
                    danhSachSanPham.xemDanhSachSanPham();
                    break;
                case 2:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập mã sản phẩm cần tìm kiếm: ");
                    String maTimKiem = scanner.nextLine();
                    danhSachSanPham.timKiemSanPham(maTimKiem);
                    break;
                case 3:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.println("Nhập mã sản phẩm mới.");
                    String ma = "";
                    while (true) {
                        System.out.print("Mã sản phẩm: ");
                        ma = scanner.nextLine().trim();
                        if (!danhSachSanPham.kiemTraTrungMa(ma)) {
                            break;
                        }
                        System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập mã khác.");
                    }

                    String ten = "";
                    System.out.print("Tên sản phảm: ");
                    ten = scanner.nextLine().trim();

                    int soLuong;
                    while (true) {
                        System.out.print("Số lượng: ");
                        soLuong = Integer.parseInt(scanner.nextLine().trim());
                        if (danhSachSanPham.kiemTraSoLuong(soLuong)) {
                            break;
                        }
                        System.out.println("Số lượng sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
                    }

                    double donGia;
                    while (true) {
                        System.out.print("Đơn giá: ");
                        donGia = Double.parseDouble(scanner.nextLine().trim());
                        if (danhSachSanPham.kiemTraDonGia(donGia)) {
                            break;
                        }
                        System.out.println("Đơn giá sản phẩm phải lướn hơn 0. Vui lòng nhập lại.");
                    }

                    SanPham sanPhamMoi = new SanPham(ma, ten, soLuong, donGia);
                    danhSachSanPham.themSanPham(sanPhamMoi);
                    System.out.println("\nThêm sản phẩm thành công.");

                    // luu data
                    danhSachSanPham.luuSanPham();
                    System.out.println("Lưu sản phẩm thành công.");
                    break;
                case 4:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    } else {
                        System.out.print("Nhập mã sản phẩm cần sửa: ");
                        String maCanSua = scanner.nextLine();

                        if (danhSachSanPham.kiemTraTrungMa(maCanSua)) {
                            System.out.println("Nhập thông tin mới, mã sản phẩm không thể sửa: ");

                            int soLuongMoi;
                            while (true) {
                                System.out.print("Số lượng: ");
                                soLuongMoi = Integer.parseInt(scanner.nextLine().trim());
                                if (danhSachSanPham.kiemTraSoLuong(soLuongMoi)) {
                                    break;
                                }
                                System.out.println("Số lượng sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
                            }

                            double donGiaMoi;
                            while (true) {
                                System.out.print("Đơn giá: ");
                                donGiaMoi = Double.parseDouble(scanner.nextLine().trim());
                                if (danhSachSanPham.kiemTraDonGia(donGiaMoi)) {
                                    break;
                                }
                                System.out.println("Đơn giá sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
                            }

                            danhSachSanPham.capNhatThongTinSanPham(maCanSua, soLuongMoi, donGiaMoi);
                            System.out.println("\nCập nhật thông tin thành công.");

                            // luu data
                            danhSachSanPham.luuSanPham();
                            System.out.println("Lưu sản phẩm thành công.");
                        } else {
                            System.out.println("Không tìm thấy nhân viên có mã " + maCanSua);
                        }
                    }
                    break;
                case 5:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng");
                    } else {
                        System.out.print("Nhập mã sản phẩm cần xóa: ");
                        String maSanPhamXoa = scanner.nextLine().trim();

                        danhSachSanPham.xoaSanPham(maSanPhamXoa);
                        System.out.println("Xóa sản phẩm thành công.");

                        danhSachSanPham.luuSanPham();
                        System.out.println("Lưu sản phẩm thành công.");
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi menu sản phẩm.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    ////////////////////////// showMemuBanHang //////////////////////////
    public static void showMemuBanHang() {

        while (true) {
            System.out.println("========== MENU BÁN HÀNG ==========");
            System.out.println("1. Thêm mới hóa đơn bán hàng.");
            System.out.println("2. Báo cáo thống kê");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            System.out.println();

            switch (choice) {
                case 1:
                    if (gioHang.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }
                    System.out.println("Thêm mới hóa đơn bán hàng");
                    // Bước 1: Khởi tạo giỏ hàng
                    gioHang.clear();

                    while (true) {
                        // Bước 2: Nhập mã khách hàng
                        System.out.print("Nhập mã khách hàng: ");
                        String maKhachHang = scanner.nextLine();
                        KhachHang khachHang = gioHang.timKhachHangTheoMa(maKhachHang);

                        if (khachHang == null) {
                            System.out.println("Khách hàng không tồn tại.");

                            // tiến hành thêm mới
                            System.out.println("Thêm mới một khách hàng.");
                            String ma = "";
                            while (true) {
                                System.out.print("Mã khách hàng: ");
                                ma = scanner.nextLine().trim();
                                if (!danhSachNhanVien.kiemTraTrungMaNhanVien(ma)) {
                                    break;
                                }
                                System.out.println("Mã khách hàng đã tồn tại. Vui lòng nhập mã khác.");
                            }

                            String ten = "";
                            while (true) {
                                System.out.print("Tên khách hàng: ");
                                ten = scanner.nextLine().trim();
                                if (danhSachNhanVien.kiemTraTenNhanVien(ten)) {
                                    break;
                                }
                                System.out.println("Tên không được chứa số. Vui lòng nhập lại.");
                            }

                            String soDienThoai = "";
                            while (true) {
                                System.out.print("Số điện thoại: ");
                                soDienThoai = scanner.nextLine().trim();
                                if (danhSachNhanVien.kiemTraSoDienThoaiNhanVien(soDienThoai)) {
                                    break;
                                }
                                System.out.println("Số điện thoại phải có từ 10 đến 11 chữ số. Vui lòng nhập lại.");
                            }

                            String email = "";
                            while (true) {
                                System.out.print("Email: ");
                                email = scanner.nextLine().trim();
                                if (danhSachNhanVien.kiemTraEmailNhanVien(email)) {
                                    break;
                                }
                                System.out.println("Email phải có định dạng xxx@abc.com. Vui lòng nhập lại.");
                            }

                            System.out.print("Địa chỉ: ");
                            String diaChi = scanner.nextLine().trim();

                            KhachHang khachHangMoi = new KhachHang(ma, ten, soDienThoai, email, diaChi);
                            danhSachKhachHang.themKhachHang(khachHangMoi);
                            System.out.println("\nThêm khách hàng mới thành công.");

                        } else {
                            System.out.println("Thông tin khách hàng: " + khachHang.toString());
                        }

                        // Bước 3: Nhập mã sản phẩm
                        System.out.print("Nhập mã sản phẩm: ");
                        String maSanPham = scanner.nextLine();
                        SanPham sanPham = gioHang.timSanPhamTheoMa(maSanPham);

                        if (sanPham == null) {
                            System.out.println("Sản phẩm không tồn tại.");
                            continue; // Quay lại Bước 3
                        } else {
                            // Hiển thị thông tin sản phẩm và nhập số lượng mua
                            System.out.println("Thông tin sản phẩm: " + sanPham.toString());

                            System.out.print("Nhập số lượng mua: ");
                            int soLuongMua = Integer.parseInt(scanner.nextLine());

                            // Bước 4: Kiểm tra số lượng và thêm vào giỏ hàng
                            if (soLuongMua > 0 && soLuongMua <= sanPham.getSoLuong()) {
                                double thanhTien = soLuongMua * sanPham.getDonGia();
                                LocalDateTime ngayBan = LocalDateTime.now(); // Lấy ngày hiện tại

                                System.out.print("Nhập mã nhân viên: ");
                                String maNhanVien = scanner.nextLine();
                                // Tìm đối tượng NhanVien tương ứng với mã nhân viên
                                NhanVien nhanVien = gioHang.timNhanVienTheoMa(maNhanVien);

                                if (nhanVien != null) {
                                    HoaDon hoaDon = new HoaDon(khachHang, nhanVien, sanPham, soLuongMua, sanPham.getDonGia(), thanhTien, ngayBan);
                                    gioHang.add(hoaDon);
                                    System.out.println("Đã thêm sản phẩm vào giỏ hàng.");
                                } else {
                                    System.out.println("Không tìm thấy nhân viên với mã " + maNhanVien);
                                }
                            } else {
                                System.out.println("Số lượng mua không hợp lệ hoặc không đủ trong kho.");
                            }
                        }

//                         Bước 5: Chọn tiếp tục mua hàng hoặc thanh toán
//                        System.out.print("Tiếp tục mua hàng (1) hoặc thanh toán (2): ");
//                        int luaChon = Integer.parseInt(scanner.nextLine());
//
//                        if (luaChon != 1) {
//                            break; // Kết thúc quá trình mua sắm
//                        }
                        boolean tiepTucMuaHang = true;
                        while (tiepTucMuaHang) {
                            System.out.print("Tiếp tục mua hàng chọn Y(YES) hoặc thanh toán chọn N(NO): ");
                            String luaChon = scanner.nextLine().trim();
                            if (luaChon.equalsIgnoreCase("Y")) {

                                // Bước 3: Nhập mã sản phẩm
                                System.out.print("Nhập mã sản phẩm: ");
                                String maSanPhamMoi = scanner.nextLine();
                                SanPham sanPhamMoi = gioHang.timSanPhamTheoMa(maSanPhamMoi);

                                if (sanPhamMoi == null) {
                                    System.out.println("Sản phẩm không tồn tại.");
//                                    continue; // Quay lại Bước 3
                                } else {
                                    // Hiển thị thông tin sản phẩm và nhập số lượng mua
                                    System.out.println("Thông tin sản phẩm: " + sanPham.toString());

                                    System.out.print("Nhập số lượng mua: ");
                                    int soLuongMua = Integer.parseInt(scanner.nextLine());

                                    // Bước 4: Kiểm tra số lượng và thêm vào giỏ hàng
                                    if (soLuongMua > 0 && soLuongMua <= sanPham.getSoLuong()) {
                                        double thanhTien = soLuongMua * sanPham.getDonGia();
//                                        LocalDate ngayBan = LocalDate.now(); // Lấy ngày hiện tại
                                        LocalDateTime ngayBan = LocalDateTime.now(); // Lấy ngày hiện tại

                                        System.out.print("Nhập mã nhân viên: ");
                                        String maNhanVien = scanner.nextLine();
                                        // Tìm đối tượng NhanVien tương ứng với mã nhân viên
                                        NhanVien nhanVien = gioHang.timNhanVienTheoMa(maNhanVien);

                                        if (nhanVien != null) {
                                            HoaDon hoaDon = new HoaDon(khachHang, nhanVien, sanPhamMoi, soLuongMua, sanPham.getDonGia(), thanhTien, ngayBan);
                                            gioHang.add(hoaDon);
                                            System.out.println("Đã thêm sản phẩm vào giỏ hàng.");
                                        } else {
                                            System.out.println("Không tìm thấy nhân viên với mã " + maNhanVien);
                                        }
                                    } else {
                                        System.out.println("Số lượng mua không hợp lệ hoặc không đủ trong kho.");
                                    }
                                }

                            } else if (luaChon.equalsIgnoreCase("N")) {
                                tiepTucMuaHang = false; // Đặt biến là false để thoát khỏi vòng lặp và tiến hành thanh toán
                                // luu data
                                gioHang.LuuHoaDon();
                                System.out.println("Lưu hóa đơn thành công.");
                            } else {
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn Y(YES) hoặc N(NO).");
                            }
                        }

                        // Bước 5.2: Thanh toán và hiển thị thông tin hóa đơn
                        double tongTien = gioHang.tinhTongTien();
                        gioHang.hienThiHoaDon(tongTien);
                        break;
                    }
                case 2:
                    showMemuThongKe();
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi menu bán hàng.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    /////////////////////////////
    public static void showMemuThongKe() {
        while (true) {
            System.out.println("========== MENU THỐNG KÊ ==========");
            System.out.println("1. Xem danh sách hóa đơn đã bán trong trong 1 ngày.");
            System.out.println("2. Xem danh sách hóa đơn đã bán trong tháng.");
            System.out.println("3. Xem doanh thu theo nhân viên trong tháng.");
            System.out.println("4. Xem Danh sách các sản phẩm có số lượng < 10(sắp hết hàng).");
            System.out.println("5. Xem Danh sách các sản phẩm có số lượng > 100(tồn nhiều hàng).");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine().trim());
            System.out.println();

            switch (choice) {
                case 1:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập ngày (yyyy-MM-dd): ");
                    String ngayNhap = scanner.nextLine().trim();
                    try {
                        LocalDate ngayCanXem = LocalDate.parse(ngayNhap, DateTimeFormatter.ISO_LOCAL_DATE);
                        gioHang.xemHoaDonTrongNgay(ngayCanXem);
                    } catch (Exception e) {
                        System.out.println("Ngày không hợp lệ.");
                    }
                    break;
                case 2:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập năm: ");
                    int nam = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nhập tháng: ");
                    int thang = Integer.parseInt(scanner.nextLine().trim());

                    try {
                        gioHang.xemHoaDonTrongThang(nam, thang);

                    } catch (DateTimeException e) {
                        System.out.println("Lỗi: Ngày hoặc tháng không hợp lệ.");
                    }
                    // xuất hóa đơn tháng
                    gioHang.LuuHoaDonTrongThang();
                    break;
                case 3:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    System.out.print("Nhập tháng: ");
                    int thangDoanhThuNhanVien = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Nhập năm: ");
                    int namDoanhThuNhanVien = Integer.parseInt(scanner.nextLine().trim());

                    try {
                        // Gọi phương thức xemDoanhThuTheoNhanVienTrongThang với thông tin từ người dùng
//                        gioHang.xemDoanhThuTheoNhanVienTrongThang(thangDoanhThuNhanVien, namDoanhThuNhanVien);
                        gioHang.xemDoanhThuTheoNhanVienTrongThang(thangDoanhThuNhanVien, namDoanhThuNhanVien);
                    } catch (DateTimeException e) {
                        System.out.println("Lỗi về ngày tháng: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Lỗi không xác định: " + e.getMessage());
                    }

                    break;
                case 4:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    danhSachSanPham.xemSanPhamSapHetHang();
                    break;
                case 5:
                    if (danhSachSanPham.kiemTraDanhSachRong()) {
                        System.out.println("Danh sách rỗng.");
                    }

                    danhSachSanPham.xemSanPhamTonHang();
                    break;
                case 0:
                    System.out.println("Đã thoát khỏi menu thống kê.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }

        }
    }

}
