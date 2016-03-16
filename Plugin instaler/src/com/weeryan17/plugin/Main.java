package com.weeryan17.plugin;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	static JTextField input;
	static JCheckBox villagesBox;
	static JCheckBox slabsBox;
	static JFrame window;
	public static void main(String[] args) {
		input = new JTextField("Enter plugin folder location here");;
		JPanel content1 = new JPanel();
		JPanel content2 = new JPanel();
		content1.setLayout(new BorderLayout());
		content2.setLayout(new GridLayout(0,1));
		content2.add(input);
		villagesBox = new JCheckBox("Villages");
		villagesBox.setSelected(false);
		slabsBox = new JCheckBox("Slabs");
		slabsBox.setSelected(false);
		content2.add(villagesBox);
		content2.add(slabsBox);
		JButton button = new JButton("Go");
		ActionListener buttonLisiner = new Button();
		button.addActionListener(buttonLisiner);
		content1.add(button, BorderLayout.SOUTH);
		window = new JFrame();
		window.setContentPane(content1);
		window.add(content2, 0);
		window.setSize(200, 150);
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

}
