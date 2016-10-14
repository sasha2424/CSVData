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
	public static CSVData readCSVFile(String filename, String[] columnNames, int ignore, String lineSep) {
		return null;
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
		return null;
	}
	
	/***
	 * Reads data from a file and returns it all as a String
	 * @param filePath Where the data is 
	 * @return
	 */
	private static String readFileAsString(String filePath){
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
	
	/***
	 * Returns a certain row of the data .
	 * @param row Row number to be extracted.
	 * @return Double array with the data.
	 */
	public double[] getRow(int row){
		return data[row];
	}
	
	/***
	 * Returns a certain column of the data.
	 * @param column Column index with the data
	 * @return Double array with the data.
	 */
	public double[] getColumn(int column){
		double[] r = new double[data[0].length];
		for(int i = 0; i < data.length;i++){
			r[i] = data[i][column];
		}
		return r;
	}
	
	/***
	 * Returns a certain column of the data.
	 * @param column Column name with the data
	 * @return Double array with the data.
	 */
	public double[] getColumn(String column){
		int c = 0;
		for(int i = 0; i < columnNames.length;i++){
			if(columnNames[i].equals(column)){
				c = i;
				break;
			}
		}
		double[] r = new double[data[0].length];
		for(int i = 0; i < data.length;i++){
			r[i] = data[i][c];
		}
		return r;
	}
	/***
	 * Returns a 2d array of data from specific rows
	 * @param min smallest row
	 * @param max largest row
	 * @return 2d double array with data from 
	 */
	public double[][] getRows(int min, int max){
		double[][] r = new double[data.length][data[0].length];
		for(int i = min; i <= max; i++){
			r[i] = data[i];
		}
		return r;
	}
	/***
	 * This method returns a 2d array of data 
	 * @param rows this is an array of the data that is to be extracted
	 * 
	 * @return
	 */
	public double[][] getRows(int[] rows){
		double[][] r = new double[data.length][data[0].length];
		for(int i = 0; i <= rows.length; i++){
			r[i] = data[rows[i]];
		}
		return r;
	}
	

}
