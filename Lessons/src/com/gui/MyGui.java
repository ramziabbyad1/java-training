
package com.gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyGui extends Frame implements ActionListener, WindowListener{
	private static final long serialVersionUID = 1L;
	private Label label;
	private TextField textfield;
	private Button forward;
	private Panel panel;
	private Button reverse;
	private int i;
	
	public MyGui(){
		//default Panel constructor uses flow layout
		//constructor two lets u choose layout
		//example: gridlayout (rows, columns)
		//cardlayout
		//borderlayout
		panel = new Panel();
		label = new Label("Counter : ");
		panel.add(label);
		add(panel);
		textfield = new TextField("0", 25);
		panel.add(textfield);
		add(panel);
		forward = new Button("Forward");
		forward.addActionListener(this);
		panel.add(forward);
		add(panel);
		reverse = new Button("Reverse");
		reverse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				i--;
				textfield.setText(i+"");
				
			}
		});
		panel.add(reverse);
		add(panel);
		addWindowListener(this);
		setSize(400, 300);
		setTitle("MyGui");
		setVisible(true);
	}
	public static void main(String[] args){
		MyGui gui = new MyGui();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		i++;
		textfield.setText(i+"");
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
