package hcmus.edu.vn.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import hcmus.edu.vn.model.DanhMuc;
import hcmus.edu.vn.model.SanPham;

public class DanhMucService extends SQLServerService {
	public Vector<DanhMuc> docToanBoDanhMuc()
	{
		Vector<DanhMuc>vec=new Vector<DanhMuc>();
		try
		{
			String sql="select * from DanhMuc where isDeleted=0";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				DanhMuc dm = new DanhMuc();
				dm.setMaDM(result.getString(1));
				dm.setTenDM(result.getString(2));
				dm.setIsDeleted(0);
				vec.add(dm);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return vec;
		
	}
	public int removeDanhMuc(DanhMuc dm)
	{
		try
		{
			String sql="delete DanhMuc where TenDM=? and isDeleted=0";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, dm.getTenDM());
			int x=preStatement.executeUpdate();
			return x;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
	public int luuDanhMuc(DanhMuc dm)
	{
		try
		{
			String sql="insert into DanhMuc values (?,?,?)";
			PreparedStatement preStatement=conn.prepareStatement(sql);
			preStatement.setString(1, dm.getMaDM());
			preStatement.setString(2, dm.getTenDM());
			preStatement.setInt(3, 0);
			int x=preStatement.executeUpdate();
			return x;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return -1;
	}
}
