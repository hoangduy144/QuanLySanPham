package hcmus.edu.vn.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import hcmus.edu.vn.model.SanPham;

public class SanPhamService extends SQLServerService{
	public boolean kiemTraMaTonTai(SanPham sp)
	{
		try
		{
			String sql= "select * from SanPham where MaSP=? and isDeleted=0";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, sp.getMaSP());
			ResultSet result=preStatement.executeQuery();
			return result.next();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	public int removeSanPham(SanPham sp)
	{
		try
		{
			String sql="delete SanPham where MaSP=? and isDeleted=0";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, sp.getMaSP());
			int x=preStatement.executeUpdate();
			return x;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
	public int updateSanPham(SanPham sp)
	{
		try
		{
			String sql="update SanPham set TenSP=?, SoLuong=?, DonGia=?, MaDM=?, isDeleted=? where MaSP=? and isDeleted=0";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, sp.getTenSP());
			preStatement.setInt(2, sp.getSoLuong());
			preStatement.setInt(3, sp.getDonGia());
			preStatement.setString(4, sp.getMaDM());
			preStatement.setInt(5, 0);
			preStatement.setString(6, sp.getMaSP());
			int x=preStatement.executeUpdate();
			return x;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
	public int luuSanPham(SanPham sp)
	{
		try
		{
			String sql="insert into SanPham values (?,?,?,?,?,?)";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, sp.getMaSP());
			preStatement.setString(2, sp.getTenSP());
			preStatement.setInt(3, sp.getSoLuong());
			preStatement.setInt(4, sp.getDonGia());
			preStatement.setString(5, sp.getMaDM());
			preStatement.setInt(6, 0);
			int x=preStatement.executeUpdate();
			return x;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
	
	public Vector<SanPham> docSanPhamTheoDanhMuc(String maDM)
	{
		Vector<SanPham>vec=new Vector<SanPham>();
		try
		{
			String sql= "select * from SanPham where MaDM=? and isDeleted=0";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, maDM);
			ResultSet result = preStatement.executeQuery();
			while(result.next())
			{
				SanPham sp = new SanPham();
				sp.setMaSP(result.getString(1));
				sp.setTenSP(result.getString(2));
				sp.setSoLuong(result.getInt(3));
				sp.setDonGia(result.getInt(4));
				sp.setMaDM(result.getString(5));
				sp.setIsDeleted(0);
				vec.add(sp);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return vec;
	}
}
