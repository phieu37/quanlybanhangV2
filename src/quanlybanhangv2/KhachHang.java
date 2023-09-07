/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhangv2;

/**
 *
 * @author Ideapad
 */
public class KhachHang {

    private String ma;
    private String ten;
    private String soDienThoai;
    private String email;
    private String diaChi;
    
    public KhachHang(String ma, String ten, String soDienThoai, String email, String diaChi) {
        this.ma = ma;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
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

    @Override
    public String toString() {
        return "ma=" + ma + ", ten=" + ten + ", soDienThoai=" + soDienThoai + ", email=" + email + ", diaChi=" + diaChi;
    }
    

}
