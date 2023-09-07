/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangv2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Ideapad
 */
public class NhanVien {

    private String ma;
    private String ten;
    private String soDienThoai;
    private String email;
    private String diaChi;
    private String matKhau;
    private String gioiTinh;
    private String nhom;
    private String trangThai;

    public NhanVien(String ma, String ten, String soDienThoai, String email, String diaChi, String matKhau, String gioiTinh, String nhom, String trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
        this.nhom = nhom;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ma=" + ma + ", ten=" + ten + ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi + ", matKhau=" + matKhau + ", gioiTinh=" + gioiTinh + ", nhom=" + nhom + ", trangThai=" + trangThai;
    }
    
    public String toStringMa() {
        return ma;
    }

    public static String encodeMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            // Chuyển đổi byte array thành dạng hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

}
