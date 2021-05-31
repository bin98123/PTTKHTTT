package model;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class View extends JFrame {
	public View() {
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenu source = new JMenu("Source");
		JMenuItem jNew = new JMenuItem("New");
		menubar.add(file);
		menubar.add(edit);
		menubar.add(source);
		file.add(jNew);
		setJMenuBar(menubar);
//		v.setDefaultCloseOperation(3);

	}

	public static void main(String[] args) {

		View v = new View();
		v.setVisible(true);
//		JTabbedPane d = new JTabbedPane("Trang chủ");
		v.setSize(480, 360);
		v.setLocationRelativeTo(null);
//		v.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
