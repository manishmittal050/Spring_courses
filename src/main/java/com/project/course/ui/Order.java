package com.project.course.ui;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.project.course.controller.LogInController;
import com.project.course.controller.ProductController;
import com.project.course.entity.User;

@Component
public class Order {

	JFrame orderframe;
	public void prepareAndOpenFrame()
	{
		orderframe = new JFrame("Products");


		//		String data[][]={ {"101","Amit","670000"},    
		//				{"102","Jai","780000"},    
		//				{"101","Sachin","700000"}};    
		String column[]={"ID","NAME","PASSWORD"};      

		//		JTable jt=new JTable(data,column);    
		//		jt.setBounds(30,40,200,300);       

		DefaultTableModel model = new DefaultTableModel();

		model.setColumnIdentifiers(column);
		JTable table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);

		ProductController pc = new ProductController();
		
		LogInController logInController = new LogInController();
		
//		List<Iterable<User>> li= pc.fetchAllProducts();
		String ss = logInController.fetchAllProducts();

		JScrollPane sp=new JScrollPane(table); 

		sp.setHorizontalScrollBarPolicy(

				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		sp.setVerticalScrollBarPolicy(

				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		

		//		jt.setEnabled(false);
		orderframe.getContentPane().add(sp);

		orderframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		orderframe.setSize(400,500);


		orderframe.setVisible(true);



	}

//	public static void main(String[] arg)
//	{
//		Order order =new Order();
//		order.prepareAndOpenFrame();
//	}

}
