import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TripleStore {
	
	private JTable table;
	
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
		table = new JTable(model);
		table.setEnabled(false);
		return table;
	}
	
	/**
	 * voegt tekst toe aan de tabel
	 * @param s subject
	 * @param p predicate
	 * @param o object
	 */
	public void addTriple(String s, String p, String o) {
		String[] columns = {s, p, o};
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(columns);
	}

}
