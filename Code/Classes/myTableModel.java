import javax.swing.table.AbstractTableModel;

class myTableModel extends AbstractTableModel
{
	private inventory i = new inventory();
	private String[] columnNames;
	private String[][] data;
	
	public myTableModel(String[] colNames, String[][] d)
	{
		columnNames = colNames;
		data = d;
	}
	
	public int getColumnCount()
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount()
	{
		return data.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex)
	{
		 return data[rowIndex][columnIndex];
	}
	
	public String getColumnName(int col)
	{
        return columnNames[col];
    }
}