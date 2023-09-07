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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ideapad
 */
public class DanhSachKhachHang {
    // C1: ngắn gọn
     private List<KhachHang> danhSachKhachHang = new ArrayList<>();

    public List<KhachHang> getDanhSachKhachHang() {
        return danhSachKhachHang;
    }

    // C2: dài ko cần thiết
//    public ArrayList<KhachHang> danhSachKhachHang;
//
//    public DanhSachKhachHang() {
//        this.danhSachKhachHang = new ArrayList<>();
//    }
//
//    public DanhSachKhachHang(ArrayList<KhachHang> danhSachKhachHang) {
//        this.danhSachKhachHang = danhSachKhachHang;
//    }
    public void setDanhSachKhachHang(List<KhachHang> danhSachKhachHang) {
        this.danhSachKhachHang = danhSachKhachHang;
    }

    public void xemDanhSach() {
        for (KhachHang khachHang : danhSachKhachHang) {
            System.out.println(khachHang.toString());
        }
    }

    ////////
    public boolean kiemTraTrungMa(String ma) {
        for (KhachHang khachHang : danhSachKhachHang) {
            if (khachHang.getMa().equals(ma)) {
                System.out.println("Mã đã tồn tại.");
                return true;
            }
        }
        System.out.println("Mã không tồn tại.");
        return false;
    }

    // cách này kiểm tra tổng thể nhưng pải nhập 1 đống input
//    public boolean kiemTraThongTin(KhachHang nguoi) {
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
    //    public void themNguoi(KhachHang nguoi) {
//        if (kiemTraThongTin(nguoi) && !kiemTraTrungMa(nguoi.getMa())) {
//            danhSachNguoi.add(nguoi);
//            System.out.println("Thêm người mới thành công.");
//        } else {
//            System.out.println("Vui lòng nhập lại.");
//        }
//    }
    public boolean kiemTraTen(String ten) {
        return !ten.matches(".*\\d.*");
    }

    public boolean kiemTraSoDienThoai(String soDienThoai) {
        return soDienThoai.length() >= 10 && soDienThoai.length() <= 11;
    }

    public boolean kiemTraEmail(String email) {
//        return email.matches("[a-zA-Z0-9._%+-]+@abc\\.com");
        return email.contains("@abc.com");
    }

    public void themKhachHang(KhachHang khachHang) {
        danhSachKhachHang.add(khachHang);
    }

//////
    public boolean kiemTraDanhSachRong() {
        return this.danhSachKhachHang.isEmpty();
    }

    public void timKiem(String search) {
        for (KhachHang khachHang : danhSachKhachHang) {
            if (khachHang.getMa().equals(search)
                    || khachHang.getSoDienThoai().equals(search)
                    || khachHang.getEmail().equals(search)) {
                System.out.println(khachHang);
            }
        }
    }

    ///////////
    public boolean xoaKhachHang(String maKhachHangXoa) {
        for (KhachHang khachHang : danhSachKhachHang) {
            if (khachHang.getMa().equals(maKhachHangXoa)) {
                danhSachKhachHang.remove(khachHang);
                return true;
            }
        }
        return false;
    }

    /////////////
    public boolean capNhatThongTinKhachHang(String ma, String tenMoi, String soDienThoaiMoi, String emailMoi, String diaChiMoi) {
        for (KhachHang khachHang : danhSachKhachHang) {
            if (khachHang.getMa().equals(ma)) {
                khachHang.setTen(tenMoi);
                khachHang.setSoDienThoai(soDienThoaiMoi);
                khachHang.setEmail(emailMoi);
                khachHang.setDiaChi(diaChiMoi);
                return true; // Cập nhật thành công
            }
        }
        return false; // Không tìm thấy người cần cập nhật
    }

    //////////
    public void luuKhachHang() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("khachhang.txt"))) {
            for (KhachHang khachHang : danhSachKhachHang) {
                writer.write(khachHang.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(DanhSachKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /////////
    public void docKhachHangTuFile(String tenTep) {
        try (BufferedReader reader = new BufferedReader(new FileReader(tenTep))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 5) {
                    try {
                        String ma = parts[0].trim().split("=")[1];
                        String ten = parts[1].trim().split("=")[1];
                        String soDienThoai = parts[2].trim().split("=")[1];
                        String email = parts[3].trim().split("=")[1];
                        String diaChi = parts[4].trim().split("=")[1];

                        KhachHang khachHang = new KhachHang(ma, ten, soDienThoai, email, diaChi);
                        danhSachKhachHang.add(khachHang);
                    } catch (NumberFormatException e) {
                        System.out.println("Dòng không đúng định dạng: " + line);
                    }
                } else {
                    System.out.println("Dòng không đúng định dạng: " + line);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachKhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
