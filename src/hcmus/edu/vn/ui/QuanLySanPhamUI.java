package hcmus.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import hcmus.edu.vn.model.DanhMuc;
import hcmus.edu.vn.model.SanPham;
import hcmus.edu.vn.service.DanhMucService;
import hcmus.edu.vn.service.SanPhamService;

public class QuanLySanPhamUI extends JFrame {
	
	JList<DanhMuc>listDM;
	
	JButton btnNewDM, btnUpdateDM, btnRemoveDM, btnNewSP, btnSaveSP, btnRemoveSP,button;
	
	DefaultTableModel dtmSP;
	JTable tblSP;
	
	JTextField txtMaSP, txtTenSP, txtSoLuong, txtDonGia, txtMaDM, txtTenDM;
	JComboBox<DanhMuc>cboDM;
	
	DanhMuc dmSelected=null;
	
	Vector<SanPham>tableSP;
	
	public QuanLySanPhamUI(String tieude)
	{
		super(tieude);
		addControl();
		addEvent();
		hienThiDanhMucLenList();
	}

	private void hienThiDanhMucLenList() {
		DanhMucService dmService = new DanhMucService();
		Vector<DanhMuc>vec= dmService.docToanBoDanhMuc();
		listDM.setListData(vec);
		for(DanhMuc dm:vec)
		{
			cboDM.addItem(dm);
		}
	}

	private void addEvent() {
		// TODO Auto-generated method stub
		listDM.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				dmSelected=listDM.getSelectedValue();
				if(dmSelected==null)return;
				
				SanPhamService spService = new SanPhamService();
				tableSP=spService.docSanPhamTheoDanhMuc(dmSelected.getMaDM());
				dtmSP.setRowCount(0);
				for(SanPham sp:tableSP)
				{
					Vector<Object>vec=new Vector<Object>();
					vec.add(sp.getMaSP());
					vec.add(sp.getTenSP());
					vec.add(sp.getSoLuong());
					vec.add(sp.getDonGia());
					dtmSP.addRow(vec);
				}
			}
		});
		tblSP.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=tblSP.getSelectedRow();
				if(row==-1)return;
				
				SanPham sp=tableSP.get(row);
				txtMaSP.setText(sp.getMaSP());
				txtTenSP.setText(sp.getTenSP());
				txtSoLuong.setText(sp.getSoLuong()+"");
				txtDonGia.setText(sp.getDonGia()+"");
			}
		});
		btnNewSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaSP.setText("");
				txtTenSP.setText("");
				txtSoLuong.setText("");
				txtDonGia.setText("");
			}
		});
		btnSaveSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyLuuSanPham();
			}
		});
		btnRemoveSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoaSanPham();
			}
		});
		btnNewDM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dialog = new JDialog();
				dialog.setTitle("Them Danh Muc moi");
				dialog.setSize(300, 200);
				dialog.setLocationRelativeTo(null);

				JLabel lblMaDM = new JLabel("Cate ID:");
				txtMaDM = new JTextField(15);
				JLabel lblTenDM = new JLabel("Cate Name:");
				txtTenDM = new JTextField(15);
				button = new JButton("OK");

				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
				JPanel pnMaDM=new JPanel();
				pnMaDM.setLayout(new FlowLayout());
				pnMaDM.add(lblMaDM);
				pnMaDM.add(txtMaDM);
				panel.add(pnMaDM);
				JPanel pnTenDM=new JPanel();
				pnTenDM.setLayout(new FlowLayout());
				pnTenDM.add(lblTenDM);
				pnTenDM.add(txtTenDM);
				panel.add(pnTenDM);
				panel.add(button);

				dialog.add(panel);
				lblMaDM.setPreferredSize(lblTenDM.getPreferredSize());
				
				button.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        DanhMuc dm = new DanhMuc();
				        dm.setMaDM(txtMaDM.getText());
				        dm.setTenDM(txtTenDM.getText());
				        DanhMucService dmService=new DanhMucService();
				        if(dmService.luuDanhMuc(dm)>0)
				        {
				        	JOptionPane.showMessageDialog(null, "Luu danh muc thanh cong");
							Vector<DanhMuc>vecDM=dmService.docToanBoDanhMuc();
							listDM.setListData(vecDM);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Luu danh muc that bai");
				        }
				        dialog.dispose();
				    }
				});

				dialog.setVisible(true);

			}
		});
		btnUpdateDM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnRemoveDM.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoaDanhMuc();
			}
		});
	}

	protected void xuLyXoaDanhMuc() {
		DanhMuc dm=new DanhMuc();
		dm.setTenDM(listDM.getSelectedValue()+"");
		DanhMucService dmService=new DanhMucService();
		if(dmService.removeDanhMuc(dm)>0)
		{
			JOptionPane.showMessageDialog(null, "Xoa Danh Muc thanh cong");
			Vector<DanhMuc>vecDM= dmService.docToanBoDanhMuc();
			listDM.setListData(vecDM);
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Xoa Danh Muc that bai");
		}
	}

	protected void xuLyXoaSanPham() {
		// TODO Auto-generated method stub
		SanPham sp = new SanPham();
		sp.setMaSP(tblSP.getValueAt(tblSP.getSelectedRow(), 0)+"");
		SanPhamService spService=new SanPhamService();
		if(spService.removeSanPham(sp)>0)
		{
			JOptionPane.showMessageDialog(null, "Xoa san pham thanh cong");
			Vector<SanPham>vecSP= spService.docSanPhamTheoDanhMuc(dmSelected.getMaDM());
			dtmSP.setRowCount(0);
			for(SanPham sanpham : vecSP)
			{
				Vector<Object>vec=new Vector<Object>();
				vec.add(sanpham.getMaSP());
				vec.add(sanpham.getTenSP());
				vec.add(sanpham.getSoLuong());
				vec.add(sanpham.getDonGia());
				dtmSP.addRow(vec);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Xoa san pham that bai");
		}
		
	}

	protected void xuLyLuuSanPham() {
		SanPham sp=new SanPham();
		sp.setMaDM(dmSelected.getMaDM());
		sp.setMaSP(txtMaSP.getText());
		sp.setTenSP(txtTenSP.getText());
		sp.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
		sp.setDonGia(Integer.parseInt(txtDonGia.getText()));
		
		SanPhamService spService=new SanPhamService();
		if(spService.kiemTraMaTonTai(sp))
		{
			int ret=JOptionPane.showConfirmDialog(null, "Ma ["+sp.getMaSP()+"] da ton, ban muon cap nhat khong?","Thong bao trung ma san pham",JOptionPane.YES_NO_OPTION);
			if(ret==JOptionPane.NO_OPTION) return;
			try
			{
				if(spService.updateSanPham(sp)>0)
				{
					JOptionPane.showMessageDialog(null, "Cap nhat san pham thanh cong");
					Vector<SanPham>vecSP=spService.docSanPhamTheoDanhMuc(dmSelected.getMaDM());
					dtmSP.setRowCount(0);
					for(SanPham sanpham:vecSP)
					{
						Vector<Object>vec=new Vector<Object>();
						vec.add(sanpham.getMaSP());
						vec.add(sanpham.getTenSP());
						vec.add(sanpham.getSoLuong());
						vec.add(sanpham.getDonGia());
						dtmSP.addRow(vec);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Cap nhat san pham that bai");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		else
		{
			try
			{
				if(spService.luuSanPham(sp)>0)
				{
					JOptionPane.showMessageDialog(null, "Luu san pham thanh cong");
					Vector<SanPham>vecSP=spService.docSanPhamTheoDanhMuc(dmSelected.getMaDM());
					dtmSP.setRowCount(0);
					for(SanPham sanpham:vecSP)
					{
						Vector<Object>vec=new Vector<Object>();
						vec.add(sanpham.getMaSP());
						vec.add(sanpham.getTenSP());
						vec.add(sanpham.getSoLuong());
						vec.add(sanpham.getDonGia());
						dtmSP.addRow(vec);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Luu san pham that bai");
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	private void addControl() {
		// TODO Auto-generated method stub
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(300, 0));
		JPanel pnRight = new JPanel();
		JSplitPane spMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
				pnLeft,pnRight);
		con.add(spMain,BorderLayout.CENTER);
		
		pnLeft.setLayout(new BorderLayout());
		listDM = new JList<DanhMuc>();
		JScrollPane scLeft= new JScrollPane(listDM, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(scLeft, BorderLayout.CENTER);
		
		TitledBorder borderListDM = new TitledBorder(BorderFactory.createLineBorder(Color.RED),"Danh muc san pham"); 
		listDM.setBorder(borderListDM);
		
		JPanel pnBtnDM = new JPanel();
		pnBtnDM.setLayout(new FlowLayout());
		btnNewDM =new JButton("New");
		btnUpdateDM =new JButton("Update");
		btnRemoveDM =new JButton("Remove");
		pnBtnDM.add(btnNewDM);
		pnBtnDM.add(btnUpdateDM);
		pnBtnDM.add(btnRemoveDM);
		pnLeft.add(pnBtnDM, BorderLayout.SOUTH);
		
		pnRight.setLayout(new BorderLayout());
		dtmSP=new DefaultTableModel();
		dtmSP.addColumn("Product ID");
		dtmSP.addColumn("Product Name");
		dtmSP.addColumn("Quantity");
		dtmSP.addColumn("Unit Price");
		
		tblSP=new JTable(dtmSP);
		JScrollPane scTop= new JScrollPane(tblSP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnRight.add(scTop, BorderLayout.CENTER);
		
		JPanel pnBottom = new JPanel();
		pnBottom.setLayout(new BoxLayout(pnBottom, BoxLayout.Y_AXIS));
		pnRight.add(pnBottom, BorderLayout.SOUTH);
		
		JPanel pnCbo= new JPanel();
		pnCbo.setLayout(new FlowLayout());
		JLabel lblCbo = new JLabel("Danh muc");
		cboDM=new JComboBox<DanhMuc>();
		cboDM.setPreferredSize(new Dimension(170, 20));
		pnCbo.add(lblCbo);
		pnCbo.add(cboDM);
		pnBottom.add(pnCbo);
		
		JPanel pnMa= new JPanel();
		pnMa.setLayout(new FlowLayout());
		JLabel lblMaSP = new JLabel("Product ID");
		txtMaSP= new JTextField(15);
		pnMa.add(lblMaSP);
		pnMa.add(txtMaSP);
		pnBottom.add(pnMa);
		
		JPanel pnTen= new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTenSP = new JLabel("Product Name");
		txtTenSP= new JTextField(15);
		pnTen.add(lblTenSP);
		pnTen.add(txtTenSP);
		pnBottom.add(pnTen);
		
		JPanel pnSoLuong= new JPanel();
		pnSoLuong.setLayout(new FlowLayout());
		JLabel lblSoLuong = new JLabel("Unit Price");
		txtSoLuong= new JTextField(15);
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		pnBottom.add(pnSoLuong);
		
		JPanel pnDonGia= new JPanel();
		pnDonGia.setLayout(new FlowLayout());
		JLabel lblDonGia = new JLabel("Quantity");
		txtDonGia= new JTextField(15);
		pnDonGia.add(lblDonGia);
		pnDonGia.add(txtDonGia);
		pnBottom.add(pnDonGia);
		
		JPanel pnBtnSP = new JPanel();
		pnBtnSP.setLayout(new FlowLayout());
		btnNewSP =new JButton("New");
		btnSaveSP =new JButton("Save");
		btnRemoveSP =new JButton("Remove");
		pnBtnSP.add(btnNewSP);
		pnBtnSP.add(btnSaveSP);
		pnBtnSP.add(btnRemoveSP);
		pnBottom.add(pnBtnSP, BorderLayout.SOUTH);
		
		lblMaSP.setPreferredSize(lblTenSP.getPreferredSize());
		lblCbo.setPreferredSize(lblTenSP.getPreferredSize());
		lblSoLuong.setPreferredSize(lblTenSP.getPreferredSize());
		lblDonGia.setPreferredSize(lblTenSP.getPreferredSize());
		
		
	}
	public void showWindow()
	{
		this.setSize(750, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
