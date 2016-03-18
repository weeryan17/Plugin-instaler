package com.weeryan17.plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class InstallButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<String> installedList = new ArrayList<String>();
		String message;
		Main main = new Main();
		Main.window.setVisible(false);
		String text = main.getText();
		String text2 = text.replaceAll("\\\\", "/");
		if(main.getVillages()){
			installedList.add("villages");
			try {
				URL villages = new URL("https://www.dropbox.com/s/g35ogdp93v95ilp/Villages.jar?dl=1");
				InputStream in = villages.openStream();
				String villagesText = text2 + "/Villages.jar";
				Path villagesTarget = Paths.get(villagesText);
				Files.copy(in, villagesTarget, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(main.getChat()){
			
		}
		if(main.getSlabs()){
			installedList.add("slabs");
			try {
				URL slabs = new URL("https://www.dropbox.com/s/gwflh7tly744ze1/Slabs.txt?dl=1");
				InputStream in = slabs.openStream();
				String slabsText = text2 + "/Slabs.txt";
				Path slabsTarget = Paths.get(slabsText);
				Files.copy(in, slabsTarget, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		message = "You instaled ";
		if(installedList.isEmpty()){
			message = message + "nothing. :(";
		} else {
			int size = installedList.size();
			if(size == 1){
				message = message + installedList.get(0) + ".";
			} else if(size == 2){
				message = message + installedList.get(0) + ", and " + installedList.get(1) + ".";
			}
		}
		JOptionPane.showMessageDialog(null, message);
		System.exit(0);
	}
}
