/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangv2;

/**
 *
 * @author Ideapad
 */
public class SanPham {

    private String ma;
    private String ten;
    private int soLuong;
    private double donGia;

    public SanPham(String ma, String ten, int soLuong, double donGia) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "maSanPham=" + ma + ", tenSanPham=" + ten + ", soLuong=" + soLuong + ", donGia=" + donGia;
    }

    public String getFileLine() {
        return ma + "-" + ten + "-" + soLuong + "-" + donGia;
    }

    public void parse(String line) {
        String[] param = line.split("-");

        try {
            ma = param[0];
            ten = param[1];
            soLuong = Integer.parseInt(param[2]);
            donGia = Double.parseDouble(param[3]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Lỗi khi đọc dữ liệu từ file CN: " + ex.getMessage());
        } finally {
        }
    }



}
