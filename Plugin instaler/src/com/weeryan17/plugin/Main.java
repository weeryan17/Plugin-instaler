package com.weeryan17.plugin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Main {
	public static class Dissplay extends JPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public Dissplay(){
			super();
			this.setPreferredSize(new Dimension(50, 50));
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawString("Please enter you plugin folder location and what you want to install.", 20, 20);
		}
		
	}
	static JTextField input;
	static JCheckBox villagesBox;
	static JCheckBox slabsBox;
	static JFrame window;
	static boolean clicked;
	public static void main(String[] args) {
		clicked = false;
		input = new JTextField("Enter plugin folder location here");
		input.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if(clicked){
					
				} else {
					input.setText("");
					clicked = true;
				}
			}
		});
		JPanel content1 = new JPanel();
		JPanel content2 = new JPanel();
		JPanel content3 = new JPanel();
		content3.setLayout(new BorderLayout());
		content1.setLayout(new BorderLayout());
		content2.setLayout(new GridLayout(0,2));
		content3.add(input, BorderLayout.SOUTH);
		content3.add(new Dissplay(), BorderLayout.CENTER);
		villagesBox = new JCheckBox("Villages");
		content1.add(content3, BorderLayout.NORTH);
		villagesBox.setSelected(false);
		slabsBox = new JCheckBox("Slabs");
		slabsBox.setSelected(false);
		content2.add(villagesBox);
		content2.add(slabsBox);
		JButton button = new JButton("Go");
		ActionListener buttonLisener = new InstallButton();
		button.addActionListener(buttonLisener);
		content1.add(button, BorderLayout.SOUTH);
		window = new JFrame();
		window.setContentPane(content1);
		window.add(content2, 0);
		window.setSize(450, 160);
		window.setLocation(100, 100);
		window.setVisible(true);
		
	}
	public String getText(){
		return input.getText();
	}
	public boolean getVillages(){
		return villagesBox.isSelected();
	}
	public boolean getSlabs(){
		return slabsBox.isSelected();
	}
	public JTextField getTextFeild(){
		return input;
	}

}
