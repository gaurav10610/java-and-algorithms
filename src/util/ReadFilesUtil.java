package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReadFilesUtil {

	public static int[][] read2DIntegerArray(String filePath) throws IOException {
		List<String> rowsList = Files.readAllLines(Paths.get(filePath));
		int[][] array = new int[rowsList.size()][rowsList.get(0).split(" ").length];

		for (int i = 0; i < rowsList.size(); i++) {
			int j = 0;
			for (String element : rowsList.get(i).split(" ")) {
				array[i][j] = Integer.parseInt(element);
				j++;
			}
		}
		return array;
	}

	public static void print2DArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) throws IOException {
		ReadFilesUtil.print2DArray(ReadFilesUtil
				.read2DIntegerArray("E:\\Workspace_Java\\Algorithms\\src\\ocw\\files\\FindPeak2D.txt"));
	}
}
