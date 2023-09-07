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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ideapad
 */
public class DanhSachNhanVien {

    private List<NhanVien> danhSachNhanVien = new ArrayList<>();

    // tạo biến danhSachNhanVien kiểu ArrayList truyền class NhanVien vào
//    public ArrayList<NhanVien> danhSachNhanVien;
//
//    public DanhSachNhanVien() {
//        this.danhSachNhanVien = new ArrayList<>();
//    }
//
//    public DanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
//        this.danhSachNhanVien = danhSachNhanVien;
//    }    
    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }

    public void setDanhSachNhanVien(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    public void nhanVienDangNhap(NhanVien nhanVien) {
        danhSachNhanVien.add(nhanVien);
    }

    public NhanVien dangNhap(String ma, String matKhau) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMa().equals(ma) && nhanVien.getMatKhau().equals(matKhau)) {
                return nhanVien;
            }
        }
        return null;
    }

    ////////////////////
    public void xemDanhSachNhanVien() {
        for (NhanVien nhanVien : danhSachNhanVien) {
            System.out.println(nhanVien.toString());
        }
    }

    ////////
    public boolean kiemTraTrungMaNhanVien(String ma) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMa().equals(ma)) {
                System.out.println("Mã đã tồn tại.");
                return true;
            }
        }
        System.out.println("Mã không tồn tại");
        return false;
    }

    // cách này kiểm tra tổng thể nhưng mất công gõ 
//    public boolean kiemTraThongTin(Nguoi nguoi) {
//        if (nguoi.getTen().matches(".*\\d.*")) {
//            System.out.println("tên không được chứa số");
//            return false;
//        }
//        if (nguoi.getSoDienThoai().length() < 10 || nguoi.getSoDienThoai().length() > 11) {
//            System.out.println("sđt phải 10-11 ký tự");
//            return false;
//        }
//        if (!nguoi.getEmail().matches("[a-zA-Z0-9._%+-]+@abc\\.com")) {
//            System.out.println("email ko đúng định dạng");
//            return false;
//        }
//        System.out.println("thông qua kiểm tra");
//        return true;
//    }
    //    public void themNguoi(Nguoi nguoi) {
//        if (kiemTraThongTin(nguoi) && !kiemTraTrungMa(nguoi.getMa())) {
//            danhSachNguoi.add(nguoi);
//            System.out.println("Thêm người mới thành công.");
//        } else {
//            System.out.println("Vui lòng nhập lại.");
//        }
//    }
    public boolean kiemTraTenNhanVien(String ten) {
        return !ten.matches(".*\\d.*");
    }

    public boolean kiemTraSoDienThoaiNhanVien(String soDienThoai) {
        return soDienThoai.length() >= 10 && soDienThoai.length() <= 11;
    }

    public boolean kiemTraEmailNhanVien(String email) {
//        return email.matches("[a-zA-Z0-9._%+-]+@abc\\.com");
        return email.contains("@abc.com");
    }

//    public void themNhanVien(NhanVien nhanVien) {
//        danhSachNhanVien.add(nhanVien);
//    }
//////
    public boolean kiemTraDanhSachRongNhanVien() {
        return this.danhSachNhanVien.isEmpty();
    }

    public void timKiem(String search) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMa().equals(search)
                    || nhanVien.getSoDienThoai().equals(search)
                    || nhanVien.getEmail().equals(search)) {
                System.out.println(nhanVien);
            }
        }
    }

    public boolean xoaNhanVien(String ma) {
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMa().equals(ma)) {
                danhSachNhanVien.remove(nhanVien);
                return true;
            }
        }
        return false;
    }

    //////////////////
    public boolean capNhatThongTinNhanVien(String ma, String tenMoi, String soDienThoaiMoi, String emailMoi, String diaChiMoi, String matKhauMoi, String gioiTinhMoi, String nhomMoi, String trangThaiMoi) {
        matKhauMoi = NhanVien.encodeMD5(matKhauMoi); // Mã hóa mật khẩu mới
        for (NhanVien nhanVien : danhSachNhanVien) {
            if (nhanVien.getMa().equals(ma)) {
                nhanVien.setTen(tenMoi);
                nhanVien.setSoDienThoai(soDienThoaiMoi);
                nhanVien.setEmail(emailMoi);
                nhanVien.setDiaChi(diaChiMoi);

                nhanVien.setMatKhau(matKhauMoi);
                nhanVien.setGioiTinh(gioiTinhMoi);
                nhanVien.setNhom(nhomMoi);
                nhanVien.setTrangThai(trangThaiMoi);
                return true;
            }
        }
        System.out.println("Xit");
        return false;
    }

    //////////
    public void luuNhanVien() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nhanVien.txt"))) {
            for (NhanVien nhanVien : danhSachNhanVien) {
                writer.write(nhanVien.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(DanhSachNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void luuNhanVien() {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("nhanVien.txt"));
//            for (NhanVien nhanVien : danhSachNhanVien) {
//                writer.write(nhanVien.toString());
//                writer.newLine();
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(DanhSachNhanVien.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    ///////////
    public void docNhanVienTuFile(String tenTep) {
        try (BufferedReader reader = new BufferedReader(new FileReader(tenTep))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
//                System.err.println(Arrays.toString(parts) + " File nv");
//                    System.err.println(parts.length + " File nv");
                String splitKey = "=";
                if (parts.length == 9) {
                    String ma = splitString(parts[0].trim(), splitKey);
                    String ten = splitString(parts[1].trim(), splitKey);
                    String soDienThoai = splitString(parts[2].trim(), splitKey);
                    String email = splitString(parts[3].trim(), splitKey);
                    String diaChi = splitString(parts[4].trim(), splitKey);
                    String matKhau = splitString(parts[5].trim(), splitKey);
                    String gioiTinh = splitString(parts[6].trim(), splitKey);
                    String nhom = splitString(parts[7].trim(), splitKey);
                    String trangThai = splitString(parts[8].trim(), splitKey);

                    NhanVien nhanVien = new NhanVien(ma, ten, soDienThoai, email, diaChi, matKhau, gioiTinh, nhom, trangThai);
                    danhSachNhanVien.add(nhanVien);

                }
            }
        } catch (IOException e) {
            System.err.println("load Error");
        }
    }

    public String splitString(String string, String splitKey) {
        return string.split(splitKey)[1];
    }
}
