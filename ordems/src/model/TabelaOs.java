package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dao.OsDAO;

public class TabelaOs extends AbstractTableModel{

	private ArrayList<Os> listaOs = new ArrayList<Os>();
	private String [] colunas = {
			
			"Os", "Data", "Cliente", "Marca", "Modelo"
	};
	
	
	///construtor
	public TabelaOs() {
		addTodos();
	}

	public String getColumnName(int column) {

		return colunas[column];
	}
	
	public int getColumnCount() {

		return colunas.length;
	}

	public int getRowCount() {
		
		return listaOs.size();
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
			case 0: return listaOs.get(rowIndex).getId();
			case 1: return listaOs.get(rowIndex).getData_os();
			case 2: return listaOs.get(rowIndex).getCliente().getId();
			case 3: return listaOs.get(rowIndex).getMarca();
			case 4: return listaOs.get(rowIndex).getModelo();
		
		}
		return null;
	}
	
	
	public void addTodos() {
		this.listaOs.clear();
		OsDAO od = new OsDAO();
		try {
			this.listaOs.addAll(od.consultar());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Tam" + listaOs.size());
		
	}

	public Os getOs(int linha) {
		// TODO Auto-generated method stub
		return listaOs.get(linha);
	}

}

//
