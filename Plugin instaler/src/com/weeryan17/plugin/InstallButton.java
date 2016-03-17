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

import javax.swing.JOptionPane;

public class InstallButton implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Main main = new Main();
		Main.window.setVisible(false);
		String text = main.getText();
		String text2 = text.replaceAll("\\\\", "/");
		if(main.getVillages()){
			
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
		if(main.getSlabs()){
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
		if(main.getVillages() && main.getSlabs()){
			JOptionPane.showMessageDialog(null, "You installed villages and slabs!");
			System.exit(0);
		} else if(main.getVillages()){
			JOptionPane.showMessageDialog(null, "You installed villages!");
			System.exit(0);
		} else if(main.getSlabs()){
			JOptionPane.showMessageDialog(null, "You installed slabs!");
			System.exit(0);
		} else {
			JOptionPane.showMessageDialog(null, "You didn't install anything. :(");
			System.exit(0);
		}
		
	}
}
