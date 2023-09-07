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
import java.util.Arrays;

/**
 *
 * @author Ideapad
 */
public class DanhSachSanPham {

    // C1: ngắn gọn
    private List<SanPham> danhSachSanPham = new ArrayList<>();

//    public List<SanPham> danhSachSanPham;
//
//    public DanhSachSanPham() {
//        this.danhSachSanPham = new ArrayList<>();
//    }
//
//    public DanhSachSanPham(ArrayList<SanPham> danhSachSanPham) {
//        this.danhSachSanPham = danhSachSanPham;
//    }
    public List<SanPham> getDanhSachSanPham() {
        return danhSachSanPham;
    }

    public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
        this.danhSachSanPham = danhSachSanPham;
    }

    ///////////
    public boolean kiemTraDanhSachRong() {
        return this.danhSachSanPham.isEmpty();
    }

    ///////////
    public void xemDanhSachSanPham() {
        for (SanPham sanPham : danhSachSanPham) {
            System.out.println(sanPham.toString());
        }
    }

    /////////////
    public void timKiemSanPham(String ma) {
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getMa().equals(ma)) {
                System.out.println("Tìm thấy sản phẩm:");
                System.out.println(sanPham);
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã " + ma);
    }

    ////////
    public boolean kiemTraTrungMa(String ma) {
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getMa().equals(ma)) {
                System.out.println("Mã đã tồn tại.");
                return true;
            }
        }
        System.out.println("Thêm mã thành công");
        return false;
    }

    //////
    public void themSanPham(SanPham sanPham) {
        danhSachSanPham.add(sanPham);
    }

    public static boolean kiemTraSoLuong(int soLuong) {
        return soLuong > 0;
    }

    public static boolean kiemTraDonGia(double DonGia) {
        return DonGia > 0;
    }

    /////////
    public boolean xoaSanPham(String ma) {
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getMa().equals(ma)) {
                danhSachSanPham.remove(sanPham);
                return true;
            }
        }
        return false;
    }
    //////

    public boolean capNhatThongTinSanPham(String ma, int soLuongMoi, double donGiaMoi) {
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getMa().equals(ma)) {
                sanPham.setSoLuong(soLuongMoi);
                sanPham.setDonGia(donGiaMoi);
                return true;
            }
        }
        System.out.println("Xit");
        return false;
    }

    //////////
    public void luuSanPham() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sanpham.txt"))) {
            for (SanPham sanPham : danhSachSanPham) {
                writer.write(sanPham.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(DanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ///////////
    public void docSanPhamTuFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    try {
                        String ma = parts[0].split("=")[1];
                        String ten = parts[1].split("=")[1];
                        int soLuong = Integer.parseInt(parts[2].split("=")[1]);
                        double donGia = Double.parseDouble(parts[3].split("=")[1]);
                        SanPham sanPham = new SanPham(ma, ten, soLuong, donGia);
                        danhSachSanPham.add(sanPham);

                    } catch (NumberFormatException e) {
                        System.out.println(e);
                        System.out.println("Dòng không đúng định dạng số: " + line);
                    }
                } else {
                    System.out.println("Dòng không đúng định dạng: " + line);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void xemSanPhamSapHetHang() {
//        boolean coSanPhamCanNhapThem = false; // để ko in trùng KQ
//        for (SanPham sanPham : danhSachSanPham) {
//            if (sanPham.getSoLuong() < 10) {
//                coSanPhamCanNhapThem = true;
//                System.out.println("Danh sách các sản phẩm sắp hết hàng(ít hơn 10 sản phẩm):");
//                System.out.println("Mã sản phẩm: " + sanPham.getMa());
//                System.out.println("Tên sản phẩm: " + sanPham.getTen());
//                System.out.println("Số lượng còn lại: " + sanPham.getSoLuong());
//                System.out.println("---------------");
//            }
//        }
//        if (!coSanPhamCanNhapThem) {
//            System.out.println("Không có sản phẩm cần nhập thêm hàng.");
//        }
//    }
    public void xemSanPhamSapHetHang() {
        // Tạo một danh sách để lưu trữ các sản phẩm cần nhập thêm hàng để ko in trùng KQ
        ArrayList<SanPham> sanPhamCanNhap = new ArrayList<>();

        // Nếu số lượng ít hơn 10, thêm sản phẩm vào danh sách cần nhập thêm hàng
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getSoLuong() < 10) {
                sanPhamCanNhap.add(sanPham);
            }
        }

        if (sanPhamCanNhap.isEmpty()) {
            System.out.println("Không có sản phẩm cần nhập thêm hàng.");
        } else {
            System.out.println("Danh sách sản phẩm cần nhập thêm hàng:");
            for (SanPham sanPham : sanPhamCanNhap) {
                System.out.println("Mã sản phẩm: " + sanPham.getMa() + ", Tên sản phẩm: " + sanPham.getTen() + ", Số lượng: " + sanPham.getSoLuong());
            }
        }
    }
    
    public void xemSanPhamTonHang() {
        boolean coSanPhamCanNhapThem = false; // để ko in trùng KQ
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getSoLuong() >100) {
                coSanPhamCanNhapThem = true;
                System.out.println("Danh sách các sản phẩm tồn hàng(nhiều hơn 100 sản phẩm):");
                System.out.println("Mã sản phẩm: " + sanPham.getMa());
                System.out.println("Tên sản phẩm: " + sanPham.getTen());
                System.out.println("Số lượng còn lại: " + sanPham.getSoLuong());
                System.out.println("---------------");
            }
        }
        if (!coSanPhamCanNhapThem) {
            System.out.println("Không có sản phẩm cần nhập thêm hàng.");
        }
    }
    
}
