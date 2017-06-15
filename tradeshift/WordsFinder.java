package tradeshift;

import java.util.Set;

public class WordsFinder {
	
	private static final String[] DEFAULT_PUZZLE = new String[] {
					"akjbvaijdsbv_d_dbv",
			    	"fjslkdfadsna_T_lfa",
			    	"asdfasdfsdfa_r_ads",
			    	"ckvsadfgfgjava_ajd",
			        "akjbvaijdsbv_d_dbv",
			        "cbvqiejdbfqi_e_qib",
			        "asdjnaquekjdwdfabd",
			        "asdk_word_kgrtuabd",
			        "asdjnaquekjfghbdbd",
			        "asewdfldfjdsfewrkf",
			        "as_Shift_ejdccgabd",
	};
	
	public static void main(String[] args) {
		
		Input matrix = new InputMatrix();
		char[][] ip = matrix.parse(DEFAULT_PUZZLE);
		
		Dictionary dt = new CustomDictionary();
		
		Finder finder = new Finder(ip, dt);
		Set<String> validWords = finder.getValidWords();
		
		System.out.println(validWords);
		
	}

}
