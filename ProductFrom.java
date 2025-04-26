package com.forms;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dbs.DBService;
import com.pojo.Product;

public class ProductFrom extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3, b4, b5, b6, b7;

    public ProductFrom() {
        l1 = new JLabel("Product ID");
        l2 = new JLabel("Product Name");
        l3 = new JLabel("Product Price");

        t1 = new JTextField(15);
        t2 = new JTextField(15);
        t3 = new JTextField(15);

        b1 = new JButton("Add");
        b2 = new JButton("Update");
        b3 = new JButton("Delete");
        b4 = new JButton("Search");
        b5 = new JButton("List of Products");
        b6 = new JButton("Reset");
        b7 = new JButton("Close");

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);

        setSize(400, 300);
        setTitle("Product Form");
        setLayout(new FlowLayout());

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        Product pd = new Product();
        try {
            pd.setpId(Integer.parseInt(t1.getText()));
        } catch (Exception e2) {
            pd.setpName(t2.getText());
        }
        pd.setpName(t2.getText());
        try {
            pd.setPrice(Double.parseDouble(t3.getText()));
        } catch (Exception e2) {}

        DBService db = new DBService();

        if (e.getSource() == b1) {
            if (db.addProduct(pd)) {
                t2.setText("Record Inserted");
            } else {
                t2.setText("Record not Inserted");
            }
        }

        if (e.getSource() == b2) {
            if (db.UpdateProduct(pd)) {
                t2.setText("Record Updated");
            } else {
                t2.setText("Record not Updated");
            }
        }

        if (e.getSource() == b3) {
            if (db.DeleteProduct(pd)) {
                t2.setText("Record Deleted");
            } else {
                t2.setText("Record not Deleted");
            }
        }

        if (e.getSource() == b4) {
            Product p = db.getProduct(pd);
            if (p != null) {
                t1.setText(String.valueOf(p.getpId()));
                t2.setText(p.getpName());
                t3.setText(String.valueOf(p.getPrice()));
            } else {
                t2.setText("Record not found");
            }
        }

        if (e.getSource() == b5) {
            ListOfProducts lsp = new ListOfProducts();
            lsp.setVisible(true);
        }

        if (e.getSource() == b6) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        }

        if (e.getSource() == b7) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ProductFrom pf = new ProductFrom();
        pf.setLocation(300, 300);
        pf.setVisible(true);
    }
}