package tradeshift;

public class InputMatrix implements Input {
	
	@Override
	public char[][] parse(String[] ip) {
		char[][] matrix = new char[ip.length][ip[0].length()];

		for (int i = 0; i < ip.length; i++) {
			char[] entryAsArr = ip[i].toCharArray();
			for (int j = 0; j < entryAsArr.length; j++) {
				matrix[i][j] = entryAsArr[j];
			}
		}

		return matrix;

	}

}
