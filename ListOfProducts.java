package com.forms;

import java.awt.BorderLayout;

import java.awt.DefaultFocusTraversalPolicy;
import java.awt.Scrollbar;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import com.dbs.DBService;
import com.pojo.Product;

public class ListOfProducts extends JDialog{
	DefaultTableModel model;
	JTable jt;

	public ListOfProducts() {
		Vector v=new Vector<>();
		v.addElement("s.No");
		v.addElement("product-Id");
		v.addElement("product-Name");
		v.addElement("product-Price");
	model=new DefaultTableModel(new Vector(),v);
	jt=new JTable(model);
	DBService db= new DBService();
	ArrayList<Product>lst=db.getAllProduct();
	for(int i=0; i<lst.size(); i++) {
		Product p=lst.get(i);
		Vector v1=new Vector<>();
		v1.addElement(i+1);
		v1.addElement(p.getpId());
		v1.addElement(p.getpName());
		v1.addElement(p.getPrice());
		model.addRow(v1);
	}
	setLayout(new BorderLayout());
	setSize(400, 300);
	JPanel pn=new JPanel();
	JScrollPane scroll=new JScrollPane(jt,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	pn.add(scroll);
	add(pn,BorderLayout.CENTER);
		// TODO Auto-generated constructor stub
	}

	

}
