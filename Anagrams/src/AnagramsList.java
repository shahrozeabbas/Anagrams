import java.util.ArrayList;

public class AnagramsList {
	private String rep;
	private ArrayList<String> anagrams = new ArrayList<String>();
	
	public AnagramsList(String rep, ArrayList<String> anagrams) {
		rep = this.rep;
		anagrams = this.anagrams;
	}

	public AnagramsList() {
		rep = "";
		anagrams = new ArrayList<String>();
	}
	
	@SuppressWarnings("null")
	public void setRep(String rep) {
		if (rep != null || !rep.isEmpty()) {
			this.rep = rep;
		}
	}
	
	public String getRep() {
		return this.rep;
	}
	
	public String getAnagram() {
		String anagramString = "";
		for (int i = 0; i < anagrams.size(); i++) {
			anagramString += anagrams.get(i) + ", ";
		}
		anagramString = anagramString.replaceAll(", $", "");
		return anagramString;
	}
	
	
	public void addAnagram(String a) {
		anagrams.add(a);
	}
	
	public int getAnagramCount() {
		return anagrams.size();
	}

	@Override
	public String toString() {
		return getRep() + " : " + getAnagram();
	}
}
