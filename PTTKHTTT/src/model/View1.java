package model;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class View1 extends Frame {
	public static void main(String[] args) {
		View v = new View();
		MenuBar menubar = new MenuBar();
		String fileS = "File";
		Integer d = new Integer(3);
		Menu file = new Menu(fileS);
		Menu edit = new Menu("Edit");
		Menu source = new Menu("Source");
		MenuItem jNew = new MenuItem("New");
		menubar.add(file);
		menubar.add(edit);
		menubar.add(source);
		file.add(jNew);
		v.setVisible(true);
		v.setSize(480, 360);
		v.setMenuBar(menubar);
		v.setLocationRelativeTo(null);
		v.setDefaultCloseOperation(3);
	}
}
