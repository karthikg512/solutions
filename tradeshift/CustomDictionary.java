package tradeshift;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomDictionary implements Dictionary {
	
	private Set<String> dict;
	
	public CustomDictionary() {
		dict = new HashSet<>();
		buildDict();
	}

	private void buildDict() {
		BufferedReader in = null;
		try {
			// default words in linux system
			in = new BufferedReader(new FileReader("/usr/share/dict/web2"));
			String str;
			while ((str = in.readLine()) != null) {
				dict.add(str);
			}

		} catch (IOException e) {
			e.printStackTrace(); // use proper file
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
					// silent
				}
		}
	}

	@Override
	public boolean isValidWord(String word) {
		if (dict.contains(word))
			return true;
		else return false;
	}

}
