import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame{
	//Connection
	PreparedStatement state=null;
	Connection conn=null;
	ResultSet result=null;
	JTable S_PAddTable=new JTable();
	JScrollPane S_PAddscroller=new JScrollPane(S_PAddTable);
	JTable SuppliersAddtable=new JTable();
	JScrollPane S_Addscroller=new JScrollPane(SuppliersAddtable);
	JTable PartsAddTable=new JTable();
	JScrollPane P_Addscroller= new JScrollPane(PartsAddTable);
	int id=-1;
//Tabs	Suppliers
JTabbedPane tabbedPane=new JTabbedPane();
JPanel tab1=new JPanel();
JPanel tab2=new JPanel();
JPanel tab3=new JPanel();
//Combos
JComboBox<String> supplierscombo=new JComboBox<String>();
JComboBox<String> partscombo=new JComboBox<String>();
//Labels Suppliers
JLabel NameLabel=new JLabel("Name:");
JLabel CityLabel=new JLabel("City:");
//Second Search
JTextField PNameTField=new JTextField();
JLabel PNameLabel=new JLabel("Search by part name:");
//Search by Name
JButton SearSuppname=new JButton("Search by Name");
JTextField SearSuppTField=new JTextField();
//Search by Color
JButton SearPartColor=new JButton("Search by Part");
JTextField searPartTField=new JTextField();
JLabel QuantityLabel=new JLabel("Quantity");
JTextField QuantityTField=new JTextField();
//Labels Parts
JLabel PartNameLabel=new JLabel("Part Name:");
JLabel ColorLabel=new JLabel("Color:");
JLabel WeightLabel=new JLabel("Weight:");
//TFields Suppliers
JTextField NameTField=new JTextField();
JTextField CityTField=new JTextField();
//TFields Parts
JTextField PartNameTField=new JTextField();
JTextField ColorTField=new JTextField();
JTextField WeightTField=new JTextField();
JTextField QuantSearch=new JTextField();
//Panels Parts
JPanel P_UpPanel=new JPanel();
JPanel P_MidPanel=new JPanel();
JPanel P_SearPanel=new JPanel();
JPanel P_DownPanel=new JPanel();
//Panels SParts
JPanel SP_UpPanel=new JPanel();
JPanel SP_MidPanel=new JPanel();
JPanel SP_SearPanel=new JPanel();
JPanel SP_DownPanel=new JPanel();

//Panels Suppliers
JPanel S_UpPanel=new JPanel();
JPanel S_MidPanel=new JPanel();
JPanel S_DownPanel=new JPanel();
JPanel S_SearPanel=new JPanel();
//Buttons Parts
JButton P_AddBtn=new JButton("Add Part");
JButton P_EditBtn=new JButton("Edit Part");
JButton P_DeleteBtn=new JButton("Delete Part");
JButton RefreshSuppBtn=new JButton("Refresh Table");
JButton ReffreshPartBtn=new JButton("Refresh Table");
JButton ReffreshSPBtn=new JButton("Refresh Table");
//JButton P_Delett
//Buttons Suppliers
JButton S_AddBtn=new JButton("Add Supplier");
JButton S_EditBtn=new JButton("Edit Supplier");
JButton S_DeleteBtn=new JButton("Delete Supplier");
//Buttons SParts
JButton SP_AddBtn=new JButton("Add SPart");
JButton SP_EditBtn=new JButton("Edit SPart");
JButton SP_DeleteBtn=new JButton("Delete SPart");
JButton SearQuantityBtn=new JButton("SearQuantity");
public MyFrame() {
	
this.setSize(800, 800);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.add(tabbedPane);
tabbedPane.add(tab1,"Suppliers");
tabbedPane.add(tab2,"Parts");
tabbedPane.add(tab3,"Suppliers_Parts");
//Suppliers tab
tab1.setLayout(new GridLayout(3, 1));
tab1.add(S_UpPanel);
tab1.add(S_MidPanel);
//tab1.add(S_SearPanel);
tab1.add(S_DownPanel);
//Parts tab
tab2.setLayout(new GridLayout(3,1));
tab2.add(P_UpPanel);
tab2.add(P_MidPanel);
//tab2.add(P_SearPanel);
tab2.add(P_DownPanel);
//SParts tab
tab3.setLayout(new GridLayout(3,1));
tab3.add(SP_UpPanel);
tab3.add(SP_MidPanel);
//tab3.add(SP_SearPanel);
tab3.add(SP_DownPanel);
//SP_UpPanel
SP_UpPanel.setLayout(new GridLayout(4, 1));
SP_UpPanel.add(QuantityLabel);
SP_UpPanel.add(QuantityTField);
SP_UpPanel.add(PNameLabel);
SP_UpPanel.add(PNameTField);
fullSupliersCombo();
SP_UpPanel.add(supplierscombo);
fullPartsCombo();
SP_UpPanel.add(partscombo);
//SP_MidPanel
SP_MidPanel.add(SP_AddBtn);
SP_AddBtn.addActionListener(new AddSP());
SP_MidPanel.add(SP_EditBtn);
SP_EditBtn.addActionListener(new EditSP());
SP_MidPanel.add(SP_DeleteBtn);
SP_DeleteBtn.addActionListener(new DeleteSP());
//SP_MidPanel.add(InnerJoinBtn);
//InnerJoinBtn.addActionListener(new InnerClass());
//SP_SearPanel.add(QuantSearch);
SP_MidPanel.add(SearQuantityBtn);
SearQuantityBtn.addActionListener(new SearQuant());
SP_MidPanel.add(ReffreshSPBtn);
ReffreshSPBtn.addActionListener(new ReffAll3());
//SP_DownPanel
S_PAddTable.setModel(DBConnector.SelectAll("suppliers_parts"));
S_PAddscroller.setPreferredSize(new Dimension(600, 200));
SP_DownPanel.add(S_PAddscroller);
S_PAddTable.addMouseListener(new TableMouseClick3());
//P_UpPanel
P_UpPanel.setLayout(new GridLayout(3, 1));
P_UpPanel.add(PartNameLabel);
P_UpPanel.add(PartNameTField);
P_UpPanel.add(ColorLabel);
P_UpPanel.add(ColorTField);
P_UpPanel.add(WeightLabel);
P_UpPanel.add(WeightTField);
//P_MidPanel
P_MidPanel.add(P_AddBtn);
P_AddBtn.addActionListener(new AddPart());
P_MidPanel.add(P_EditBtn);
P_EditBtn.addActionListener(new EditPart());
P_MidPanel.add(P_DeleteBtn);
P_DeleteBtn.addActionListener(new DeletePart());
P_MidPanel.add(SearPartColor);
SearPartColor.addActionListener(new SearchC());
P_MidPanel.add(ReffreshPartBtn);
ReffreshPartBtn.addActionListener(new ReffAll2());
//P_DownPanel
PartsAddTable.setModel(DBConnector.SelectAll("parts"));
P_Addscroller.setPreferredSize(new Dimension(600, 200));
P_DownPanel.add(P_Addscroller);
PartsAddTable.addMouseListener(new TableMouseClick2());
//S_UpPanel
S_UpPanel.setLayout(new GridLayout(2, 1));
S_UpPanel.add(NameLabel);
S_UpPanel.add(NameTField);
S_UpPanel.add(CityLabel);
S_UpPanel.add(CityTField);
//S_MidPanel
S_MidPanel.add(S_AddBtn);
S_AddBtn.addActionListener(new AddSupp());
S_MidPanel.add(S_EditBtn);
S_EditBtn.addActionListener(new EditSupp());
S_MidPanel.add(S_DeleteBtn);
S_DeleteBtn.addActionListener(new DeleteSupp());
S_MidPanel.add(SearSuppname);
SearSuppname.addActionListener(new SearchN());
S_MidPanel.add(RefreshSuppBtn);
RefreshSuppBtn.addActionListener(new ReffAll1());
//S_DownPanel
SuppliersAddtable.setModel(DBConnector.SelectAll("suppliers"));
refreshTableSuppliersParts();
S_Addscroller.setPreferredSize(new Dimension(600, 200));
S_DownPanel.add(S_Addscroller);
SuppliersAddtable.addMouseListener(new TableMouseClick1());
this.setVisible(true);

}
class ReffAll2 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		PartsAddTable.setModel(DBConnector.SelectAll("parts"));
	}
	
}
class ReffAll1 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SuppliersAddtable.setModel(DBConnector.SelectAll("suppliers"));
	}
	
	
}
class ReffAll3 implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		refreshTableSuppliersParts();
	}
	
}
class SearchC implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		conn=DBConnector.getConnection();
		String str="select * from Parts where part_name=?";
		try {
			state=conn.prepareStatement(str);
			state.setString(1, PartNameTField.getText());
			result=state.executeQuery();
			PartsAddTable.setModel(new MyModel(result));
		} catch (SQLException e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		//PartsAddTable.setModel(DBConnector.Search2(searPartTField.getText()));
	}
	
}

 class SearchN implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		conn=DBConnector.getConnection();
		String str="select * from Suppliers where name=?";
		
		try {
			state=conn.prepareStatement(str);
			state.setString(1,NameTField.getText());
			result=state.executeQuery();
			SuppliersAddtable.setModel(new MyModel(result));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//SuppliersAddtable.setModel(DBConnector.Search1(SearSuppTField.getText()));
		
	}

}




public void refreshTableSuppliersParts() {
	conn=DBConnector.getConnection();
	String str="SELECT R.ID, Part_Name, Name, quantity\n" + 
			"FROM Suppliers_parts  R JOIN Parts P\n" + 
			"ON R.Part_id = P.Part_id\n" + 
			"JOIN Suppliers C\n" + 
			"ON R.SID = C.SID;\n" + 
			"";
	
	try {
		state=conn.prepareStatement(str);
		result=state.executeQuery();
		S_PAddTable.setModel(new MyModel(result));
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


	class SearQuant implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			S_PAddTable.setModel(DBConnector.Search(QuantityTField.getText(),PNameTField.getText()));
			QuantSearch.setText(" ");
			
		}
		
		
	}

public void fullSupliersCombo(){
	ResultSet res=DBConnector.getAllFromTable("suppliers");
	supplierscombo.removeAllItems();
	try {
		while (res.next()) {
			String suppElement=res.getObject(1).toString()
			+ "." + res.getObject(2).toString()
			+ " " + res.getObject(3);
			supplierscombo.addItem(suppElement);
		}
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}
public void fullPartsCombo() {
	ResultSet res=DBConnector.getAllFromTable("parts");
	partscombo.removeAllItems();
	try {
		while (res.next()) {
		String partElement=res.getObject(1).toString()
				+ "."  + res.getObject(2).toString()
				+ " " + res.getObject(3);
		partscombo.addItem(partElement);
			
		}
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
class EditSP implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String member=(String)supplierscombo.getSelectedItem();
		String submember=member.substring(0,member.indexOf("."));
		int suppcomboid=Integer.parseInt(submember);
		String partmember=(String)partscombo.getSelectedItem();
		String partsubmember=partmember.substring(0,partmember.indexOf("."));
		int partcomboid=Integer.parseInt(partsubmember);
			int sprow=S_PAddTable.getSelectedRow();
			Object val=S_PAddTable.getValueAt(sprow, 0);
			int id=Integer.parseInt(val.toString());
			String quant=QuantityTField.getText();
			int quantint=Integer.parseInt(quant);
			String EditSPSql="update suppliers_parts set sid=?, part_id=?, quantity=?  where id=?;";
			conn=DBConnector.getConnection();
			try {
				state=conn.prepareStatement(EditSPSql);
				state.setInt(1, suppcomboid);
				state.setInt(2, partcomboid);
				state.setInt(3, quantint);
				state.setInt(4, id);
				state.execute();
				//S_PAddTable.setModel(DBConnector.SelectAll("suppliers_parts"));
				refreshTableSuppliersParts();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	}
	
}
class DeleteSP implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			int sprow=S_PAddTable.getSelectedRow();
			Object val=S_PAddTable.getValueAt(sprow, 0);
			int id=Integer.parseInt(val.toString());
			String DeleteSPSql="delete from suppliers_parts wherе id=?";
			conn=DBConnector.getConnection();
			try {
				state=conn.prepareStatement(DeleteSPSql);
				state.setInt(1, id);
				state.execute();
				id=-1;
				refreshTableSuppliersParts();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
	}
	
}
class TableMouseClick3 extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		int sprow=S_PAddTable.getSelectedRow();
		Object val=S_PAddTable.getValueAt(sprow, 0);
		int id=Integer.parseInt(val.toString());
		if(e.getClickCount()>1) {
		QuantityTField.setText(S_PAddTable.getValueAt(sprow, 3).toString());}
	}
	
}
class AddSP implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String member=(String)supplierscombo.getSelectedItem();
		String submember=member.substring(0,member.indexOf("."));
		int suppcomboid=Integer.parseInt(submember);
		String partmember=(String)partscombo.getSelectedItem();
		String partsubmember=partmember.substring(0,partmember.indexOf("."));
		int partcomboid=Integer.parseInt(partsubmember);
		String quant=QuantityTField.getText();
		int quantint=Integer.parseInt(quant);
		String SPAddSql="insert into suppliers_parts values(null,?,?,?);";
		conn=DBConnector.getConnection();
		if(QuantityTField.getText().isEmpty()) { return;}
		else {
		
		try {
		
			state=conn.prepareStatement(SPAddSql);
			state.setInt(1, suppcomboid);
			state.setInt(2, partcomboid);
			state.setInt(3, quantint);
			state.execute();
			//S_PAddTable.setModel(DBConnector.SelectAll("suppliers_parts"));
			refreshTableSuppliersParts();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		}
	}
	
	
}


class TableMouseClick2 extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
		int partRow=PartsAddTable.getSelectedRow();
		Object val=PartsAddTable.getValueAt(partRow, 0);
	int id=Integer.parseInt(val.toString());
		if(e.getClickCount()>1) {
			PartNameTField.setText(PartsAddTable.getValueAt(partRow, 1).toString());
			ColorTField.setText(PartsAddTable.getValueAt(partRow, 2).toString());
			WeightTField.setText(PartsAddTable.getValueAt(partRow, 3).toString());
		}
	}
}
class DeleteSupp implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rowSupp=SuppliersAddtable.getSelectedRow();
		Object val=SuppliersAddtable.getValueAt(rowSupp, 0);
		int id=Integer.parseInt(val.toString());
		String DeleteSuppSql="delete from suppliers where sid=?;";
		conn=DBConnector.getConnection();
		try {
			state=conn.prepareStatement(DeleteSuppSql);
			state.setInt(1, id);
			state.execute();
			SuppliersAddtable.setModel(DBConnector.SelectAll("suppliers"));
			SupplierClear();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	
}
class EditSupp implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rowSupp=SuppliersAddtable.getSelectedRow();
		Object val=SuppliersAddtable.getValueAt(rowSupp, 0);
		int id=Integer.parseInt(val.toString());
		String NameEdit=NameTField.getText();
		String CityEdit=CityTField.getText();
		String SuppEditSql="update suppliers set name=?, city=? where sid=?;";
		conn=DBConnector.getConnection();
		try {
			state=conn.prepareStatement(SuppEditSql);
			state.setString(1, NameEdit);
			state.setString(2, CityEdit);
			state.setInt(3, id);
			state.execute();
			SuppliersAddtable.setModel(DBConnector.SelectAll("suppliers"));
			fullPartsCombo();
			SupplierClear();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
			
	}
	
	
}
class TableMouseClick1 extends MouseAdapter{
	@Override
	public void mouseClicked(MouseEvent e) {
	int rowSupp=SuppliersAddtable.getSelectedRow();
	Object val=SuppliersAddtable.getValueAt(rowSupp, 0);
	int id=Integer.parseInt(val.toString());
	if(e.getClickCount()>1) {
		NameTField.setText(SuppliersAddtable.getValueAt(rowSupp, 1).toString());
		CityTField.setText(SuppliersAddtable.getValueAt(rowSupp, 2).toString());
		
	}	
	}
	
}
class AddPart implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String part_name=PartNameTField.getText();
		String color=ColorTField.getText();
		Double weight=Double.parseDouble(WeightTField.getText());
		String addpartsql="insert into parts values(null,?,?,?);";
		conn=DBConnector.getConnection();
		if(PartNameTField.getText().isEmpty()||ColorTField.getText().isEmpty()||WeightTField.getText().isEmpty() ) { return;}
		else {
		try {
			state=conn.prepareStatement(addpartsql);
			state.setString(1, part_name);
			state.setString(2, color);
			state.setDouble(3, weight);
			state.execute();
			PartsAddTable.setModel(DBConnector.SelectAll("parts"));
			fullPartsCombo();
			PartsClear();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		} }
	}
	
}
class EditPart implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int rowPart=PartsAddTable.getSelectedRow();
		Object val=PartsAddTable.getValueAt(rowPart, 0);
		int id=Integer.parseInt(val.toString());
		String PNameEdit=PartNameTField.getText();
		String ColorEdit=ColorTField.getText();
		String weightEdit=WeightTField.getText();
		Double weightdouble=Double.parseDouble(weightEdit);
		String EditPartSql="update parts set part_name=?,color=?,weight=? where part_id=?;";
		conn=DBConnector.getConnection();
		try {
			state=conn.prepareStatement(EditPartSql);
			state.setString(1, PNameEdit);
			state.setString(2, ColorEdit);
			state.setDouble(3, weightdouble);
			state.setInt(4, id);
			state.execute();
			PartsAddTable.setModel(DBConnector.SelectAll("parts"));
			fullPartsCombo();
			PartsClear();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		
	}
	
}
class DeletePart implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int rowPart=PartsAddTable.getSelectedRow();
		Object val=PartsAddTable.getValueAt(rowPart, 0);
		int id=Integer.parseInt(val.toString());
		conn=DBConnector.getConnection();
		String PartDelSql="delete from parts where part_id=?;";
		try {
			state=conn.prepareStatement(PartDelSql);
			state.setInt(1, id);
			state.execute();
			PartsAddTable.setModel(DBConnector.SelectAll("parts"));
			fullPartsCombo();
			PartsClear();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
	
	
}
class AddSupp implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name=NameTField.getText();
	   String city=CityTField.getText();
	   String addsuppsql="insert into suppliers values(null,?,?);";
	   conn=DBConnector.getConnection();
	   if(NameTField.getText().isEmpty()||CityTField.getText().isEmpty() ) { return;}
	   else {
	   try {
		state=conn.prepareStatement(addsuppsql);
		state.setString(1, name);
		state.setString(2, city);
		state.execute();
		SuppliersAddtable.setModel(DBConnector.SelectAll("suppliers"));
		fullSupliersCombo();
		SupplierClear();
	} catch (Exception e2) {
		// TODO: handle exception
		e2.printStackTrace();
	}}
	   
	   
	}
	
	
}
public void SupplierClear() {
	NameTField.setText("");
	CityTField.setText("");
}
public void PartsClear() {
	PartNameTField.setText("");
	ColorTField.setText("");
	WeightTField.setText("");
}




















}
