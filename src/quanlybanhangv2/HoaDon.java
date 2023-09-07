/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangv2;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Ideapad
 */
public class HoaDon {

    private KhachHang maKhachHang;
    private NhanVien maNhanVien;
    private SanPham maSanPham;
    private int soLuongMua;
    private double donGia;
    private double thanhTien;
//    private LocalDate ngayBan;
    private LocalDateTime ngayBan;

    public HoaDon(KhachHang maKhachHang, NhanVien maNhanVien, SanPham maSanPham, int soLuongMua, double donGia, double thanhTien, LocalDateTime ngayBan) {
        this.maKhachHang = maKhachHang;
        this.maNhanVien = maNhanVien;
        this.maSanPham = maSanPham;
        this.soLuongMua = soLuongMua;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.ngayBan = ngayBan;
    }

    public KhachHang getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(KhachHang maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public NhanVien getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(NhanVien maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public SanPham getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(SanPham maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuongMua() {
        return soLuongMua;
    }

    public void setSoLuongMua(int soLuongMua) {
        this.soLuongMua = soLuongMua;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public LocalDateTime getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(LocalDateTime ngayBan) {
        this.ngayBan = ngayBan;
    }

    @Override
    public String toString() {
        return "maKhachHang=" + maKhachHang.getMa() + ", maNhanVien=" + maNhanVien.getMa() + ", maSanPham=" + maSanPham.getMa() + ", soLuongMua=" + soLuongMua + ", donGia=" + donGia + ", thanhTien=" + thanhTien + ", ngayBan=" + ngayBan;
    }

}
