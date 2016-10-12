/***
 * \A Class to read/write numerical CSV files and allow easy access of data
 * 
 * @author sasha
 *
 */
public class CSVData {

	private double[][] data;
	private String[] columnNames;

	public CSVData() {

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
	public static void readCSVFile(String filename, String[] columnNames, int ignore) {

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
	public static void readCSVFile(String filename, int ignore) {

	}

}
