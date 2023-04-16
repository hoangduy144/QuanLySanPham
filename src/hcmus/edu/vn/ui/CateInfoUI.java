package hcmus.edu.vn.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import hcmus.edu.vn.ui.*;
import hcmus.edu.vn.model.DanhMuc;
import hcmus.edu.vn.model.SanPham;
import hcmus.edu.vn.service.DanhMucService;

public class CateInfoUI extends JFrame{
	JTextField txtMaDM, txtTenDM;
	JButton btnNew;
	
	public CateInfoUI(String tieude)
	{
		super(tieude);
		addControl();
		addEvent();
		
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		btnNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuuDanhMuc();
			}
		});
	}

	protected void xuLyLuuDanhMuc() {
		DanhMuc dm= new DanhMuc();
		dm.setMaDM(txtMaDM.getText());
		
		
	}

	private void addControl() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		
		JPanel pnMaDM=new JPanel();
		pnMaDM.setLayout(new FlowLayout());
		con.add(pnMaDM);
		JLabel lblMaDM=new JLabel("Cate ID");
		txtMaDM=new JTextField(15);
		pnMaDM.add(lblMaDM);
		pnMaDM.add(txtMaDM);
		
		JPanel pnTenDM=new JPanel();
		pnTenDM.setLayout(new FlowLayout());
		con.add(pnTenDM);
		JLabel lblTenDM=new JLabel("Cate Name");
		txtTenDM=new JTextField(15);
		pnTenDM.add(lblTenDM);
		pnTenDM.add(txtTenDM);
		
		btnNew=new JButton("Add");
		con.add(btnNew);
		
		lblMaDM.setPreferredSize(lblTenDM.getPreferredSize());
		
	}
	public void showWindow() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
