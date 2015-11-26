import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TripleStore {
	
	
	
	public static void main(String[] args) {
		TripleStore store = new TripleStore();
	}
	
	/**
	 * constructor
	 */
	public TripleStore() {
		createGui();
	}
	
	/**
	 * maakt de GUI
	 */
	public void createGui() {
		JFrame frame = new JFrame();
		frame.setBounds(100, 100, 585, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollpane = new JScrollPane();
		frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
		scrollpane.setViewportView(createTable());
		
		frame.setVisible(true);
	}
	
	
	/**
	 * maakt een lege tabel met de kolomnamen
	 */
	public JTable createTable() {
		String[] columns = {"Subject", "predicate", "object"};
		DefaultTableModel model = new DefaultTableModel(null, columns);
		JTable table = new JTable(model);
		table.setEnabled(false);
		return table;
	}

}
