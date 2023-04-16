package hcmus.edu.vn.model;

import java.io.Serializable;

public class DanhMuc implements Serializable{
	private String maDM;
	private String tenDM;
	private int isDeleted;
	public String getMaDM() {
		return maDM;
	}
	public void setMaDM(String maDM) {
		this.maDM = maDM;
	}
	public String getTenDM() {
		return tenDM;
	}
	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}
	public int getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	public DanhMuc(String maDM, String tenDM, int isDeleted) {
		super();
		this.maDM = maDM;
		this.tenDM = tenDM;
		this.isDeleted = isDeleted;
	}
	public DanhMuc() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenDM;
	}
}
