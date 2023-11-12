package nk;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadMatrix {
	private int top;
	private int[][] matrix;

	public LoadMatrix(String path) {
		loadGraph(path);
	}

	/**
	 * Doc ma tran tu file
	 * 
	 * @param pathFile
	 */
	public void loadGraph(String pathFile) {
		try {
			BufferedReader read = Files.newBufferedReader(Paths.get(pathFile));
			int row = -1;
			String line = null;
			while ((line = read.readLine()) != null) {
				String[] str = line.split(" ");
				if (row == -1) {
					this.top = Integer.parseInt(str[0]);
					this.matrix = new int[top][top];
				} else {
					int len = str.length;
					if (len != top) {
						// Truong hop nhap thieu moi quan he giua cac dinh
						System.out.println("Please check matrix");
						matrix = null;
						return;
					} else {
						for (int i = 0; i < len; i++) {
							matrix[row][i] = Integer.parseInt(str[i]);
						}
					}
				}
				++row;
			}
			// Truong hop nhap thieu dinh
			if (row != top) {
				System.out.println("Pleses check matrix");
				matrix = null;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Please check path file");
		}
	}

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

}
