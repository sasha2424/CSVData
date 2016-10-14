import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/***
 * \A Class to read/write numerical CSV files and allow easy access of data
 * 
 * @author sasha
 *
 */
public class CSVData {

	private double[][] data;
	private String[] columnNames;
	private String filePath;

	public CSVData(String filepath, String[] columnNames, int startRow,String lineSeparator) {
		this.filePath = filepath;

		String dataString = readFileAsString(filepath);
		String[] lines = dataString.split(lineSeparator);

		// number of data points
		int n = lines.length - startRow;
		int numRows = n;
		int numColumns = columnNames.length;

		// create storage for column names
		this.columnNames = columnNames;

		// create storage for data
		this.data = new double[n][numColumns];
		for (int i = 0; i < lines.length - startRow; i++) {
			String line = lines[startRow + i];
			String[] coords = line.split(",");
			for (int j = 0; j < numColumns; j++) {
				if (coords[j].endsWith(lineSeparator))
					coords[j] = coords[j].substring(0, coords[j].length() - 1);
				double val = Double.parseDouble(coords[j]);
				data[i][j] = val;
			}
		}
	}
	/***
	 * Gets number of columns for data in CSV file
	 * @param filepath
	 * @param ignore number of lines to ignore before data starts
	 * @param lineSeparator the character that separates lines
	 * @return the number of columns for data in CSV file
	 */
	private static int getNumberOfColumns(String filepath,int ignore, String lineSeparator){
		String dataString = readFileAsString(filepath);
		String[] lines = dataString.split(lineSeparator);
		String[] terms = lines[ignore].split(",");
		return terms.length;
		
	}

	/***
	 * Returns a new CSVData object for a file ignoring lines at top. Data is
	 * stored as doubles.
	 * 
	 * @param filename
	 *            Where data is located
	 * @param columnNames
	 *            Names of columns.
	 * @param ignore
	 *            The number of lines to ignore at the top of the file.
	 */
	public static CSVData readCSVFile(String filePath, String[] columnNames, int ignore, String lineSep) {
		return new CSVData(filePath,columnNames,ignore,lineSep);
	}

	/***
	 * Returns a new CSVData object for a file ignoring lines at top. Data is
	 * stored as doubles.
	 * 
	 * @param filename
	 *            Where data is located
	 * @param ignore
	 *            The number of lines to ignore at the top of the file.
	 */
	public static CSVData readCSVFile(String filename, int ignore, String lineSep) {
		String[] names = new String[getNumberOfColumns(filename,ignore,lineSep)];
		for(int i = 0; i < names.length; i++){
			names[i] = "Column" + i;
		}
		return new CSVData(filename,names,ignore,lineSep);
	}

	/***
	 * Reads data from a file and returns it all as a String
	 * 
	 * @param filePath
	 *            Where the data is
	 * @return
	 */
	private static String readFileAsString(String filePath) {
		StringBuilder output = new StringBuilder();
		try (Scanner scanner = new Scanner(new File(filePath))) {
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				output.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output.toString();
	}

	/***
	 * Returns a certain row of the data .
	 * 
	 * @param row
	 *            Row number to be extracted.
	 * @return Double array with the data.
	 */
	public double[] getRow(int row) {
		return data[row];
	}

	/***
	 * Returns a certain column of the data.
	 * 
	 * @param column
	 *            Column index with the data
	 * @return Double array with the data.
	 */
	public double[] getColumn(int column) {
		double[] r = new double[data[0].length];
		for (int i = 0; i < data.length; i++) {
			r[i] = data[i][column];
		}
		return r;
	}

	/***
	 * Returns a certain column of the data.
	 * 
	 * @param column
	 *            Column name with the data
	 * @return Double array with the data.
	 */
	public double[] getColumn(String column) {
		int c = 0;
		for (int i = 0; i < columnNames.length; i++) {
			if (columnNames[i].equals(column)) {
				c = i;
				break;
			}
		}
		double[] r = new double[data[0].length];
		for (int i = 0; i < data.length; i++) {
			r[i] = data[i][c];
		}
		return r;
	}

	/***
	 * Returns a 2d array of data from specific rows
	 * 
	 * @param min
	 *            smallest row
	 * @param max
	 *            largest row
	 * @return 2d double array with data from
	 */
	public double[][] getRows(int min, int max) {
		double[][] r = new double[data.length][data[0].length];
		for (int i = min; i <= max; i++) {
			r[i] = data[i];
		}
		return r;
	}

	/***
	 * This method returns a 2d array of data
	 * 
	 * @param rows
	 *            this is an array of the data that is to be extracted
	 * 
	 * @return
	 */
	public double[][] getRows(int[] rows) {
		double[][] r = new double[rows.length][data[0].length];
		for (int i = 0; i <= rows.length; i++) {
			r[i] = data[rows[i]];
		}
		return r;
	}

	/***
	 * Gets columns and returns as 2d array. Gets columns between inclusive the
	 * given numbers.
	 * 
	 * @param min
	 *            smallest column to get
	 * @param max
	 *            largest column to get
	 * @return 2d array of data from designated columns
	 */
	public double[][] getColumns(int min, int max) {
		double[][] r = new double[max - min + 1][data[0].length];
		for (int i = min; i <= max; i++) {
			r[i] = this.getColumn(i);
		}
		return r;

	}

	/***
	 * Gets columns and returns as 2d array. Gets columns listed in integer
	 * array.
	 * 
	 * @param columns
	 *            columns to be extracted
	 * @return 2d array of data from designated columns
	 */
	public double[][] getColumns(int[] columns) {
		double[][] r = new double[columns.length][data[0].length];
		for (int i = 0; i <= columns.length; i++) {
			r[i] = this.getColumn(columns[i]);
		}
		return r;
	}

	/***
	 * Gets columns given in list and returns data from them as a 2d array.
	 * 
	 * @param columns
	 *            columns from list of columns
	 * @return 2d array of data from designated columns
	 */
	public double[][] getColumns(String[] columns) {
		double[][] r = new double[columns.length][data[0].length];
		for (int i = 0; i <= columns.length; i++) {
			r[i] = this.getColumn(columns[i]);
		}
		return r;
	}
	/***
	 * Returns Column Names for data
	 * @return Returns Column Names
	 */
	public String[] getColumnNames(){
		return columnNames;
	}

}
