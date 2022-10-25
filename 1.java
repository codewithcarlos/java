// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

// Solution1: Without StringBuilder
// Notes: 
// - when initalizing to empty string have to use double quotations. can't use single quotes or you get empty character literal error
// - after concatenating strings, can't use == to compare strings. have to use the equals method

class Solution1 {
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		String w1 = "";
		String w2 = "";
		for (String s : word1) {
			w1 += s;
		}
		for (String s : word2) {
			w2 += s;
		}
		return w1.equals(w2);
	}
}

// Solution2: With StringBuilder
// Notes:
// - use append to add letters
// - use compareTo == 0 OR use toString() and equals()
class Solution2 {
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder w1 = new StringBuilder();
		StringBuilder w2 = new StringBuilder();
		for (String s : word1) {
			w1.append(s);
		}
		for (String s : word2) {
			w2.append(s);
		}
		return w1.compareTo(w2) == 0;
		// return w1.toString().equals(w2.toString());
	}
}
