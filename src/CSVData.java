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
	
	/***
	 * Reads data from a file and returns it all as a String
	 * @param filePath Where the data is 
	 * @return
	 */
	public static String readFileAsString(String filePath){
		StringBuilder output = new StringBuilder();
		try(Scanner scanner = new Scanner(new File(filePath))){
			while(scanner.hasNext()){
				String line = scanner.nextLine();
				output.append(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		return output.toString();
	}

}
