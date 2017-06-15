package tradeshift;

import java.util.HashSet;
import java.util.Set;

public class Finder {

	private char[][] ip;
	private Dictionary dt;
	private int ROWS;
	private int COLS;

	public Finder(char[][] ip, Dictionary dt) {
		this.ip = ip;
		this.dt = dt;
		this.ROWS = ip.length;
		this.COLS = ip[0].length;
	}

	public Set<String> getValidWords() {
		Set<String> result = new HashSet<String>();
		boolean[][] done = new boolean[ROWS][COLS];
		
		for (int r = 0 ; r < ip.length; r++) {
			for (int c = 0 ; c < ip[r].length; c++) {
				// for each cell perform dfs
				crawl(ip, r, c, Character.toString(ip[r][c]), result, done);
			}
		}
		
		return result;
	}

	private void crawl(char[][] ipMatrix, int r, int c, String temp, Set<String> result, boolean[][] done) {

		int[] rows = { -1, 1, 0, 0 };
		int[] cols = { 0, 0, -1, 1 };

		done[r][c] = true;
		
		for (int i = 0; i < rows.length; i++) {
			if (isLegal(r + rows[i], c + cols[i], done)) {
				temp += ipMatrix[r + rows[i]][c + cols[i]];
				if (dt.isValidWord(temp)) {
					result.add(temp);
				}
				crawl(ipMatrix, r + rows[i], c + cols[i], temp, result, done);
			}
		}
		done[r][c] = false;

	}

	private boolean isLegal(int i, int j, boolean[][] done) {
		if ((i<ROWS && i>=0) && (j<COLS && j>=0) && !done[i][j]) {
			return true;
		}
		return false;
	}

}
