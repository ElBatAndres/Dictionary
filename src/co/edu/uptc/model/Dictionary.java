package co.edu.uptc.model;

import java.util.ArrayList;

public class Dictionary {
private ArrayList<Translation> dictionary;
	
	public Dictionary() {
		dictionary = new ArrayList<Translation>();
	}
	
	public Dictionary(ArrayList<Translation> dictionary) {
		this.dictionary = dictionary;
	}
	
	public Translation getTranslations(String word) {
		Translation translations = new Translation();
		for (int i = 0; i < dictionary.size(); i++) {
			if(word.equals(dictionary.get(i).getSpanish())) {
				translations = dictionary.get(i);
			}
		}
		return translations;
	}
	
	public int getTranslationPosition(String word) {
		int pos = -1;
		for (int i = 0; i < dictionary.size(); i++) {
			if(word.equals(dictionary.get(i).getSpanish())) {
				pos = i;
			}
		}
		return pos;
	}
	
	public void addTranslation(Translation newTranslation) {
		dictionary.add(newTranslation);
	}
	
	@Override
	public String toString() {
		return "Dictionary [dictionary=" + dictionary + "]";
	}

	public ArrayList<Translation> getDictionary() {
		return dictionary;
	}
	
}
