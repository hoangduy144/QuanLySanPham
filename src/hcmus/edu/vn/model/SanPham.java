package hcmus.edu.vn.model;

import java.io.Serializable;

public class SanPham implements Serializable{
	private String maSP;
	private String tenSP;
	private int soLuong;
	private int donGia;
	private String maDM;
	private int isDeleted;
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public SanPham(String maSP, String tenSP, int soLuong, int donGia, String maDM, int isDeleted) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.maDM = maDM;
		this.isDeleted = isDeleted;
	}
	public SanPham() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenSP;
	}
}
