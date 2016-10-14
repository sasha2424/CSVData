
public class CSVTester {
	public static void main(String[] args) {
		CSVData a = CSVData.readCSVFile("C://Users/sasha/Desktop/HIMU-2016-10-13_22-45-45.txt", 1, "#");
		print(a.getColumn(3));
		System.out.println();
		print(a.getRow(4));
	}

	public static void print(double[] a) {
		for (int i = 0; i < a.length -1; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println(a[a.length -1]);
	}
}
