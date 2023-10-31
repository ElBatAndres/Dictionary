package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;

import co.edu.uptc.model.Dictionary;
import co.edu.uptc.model.Translation;
import co.edu.uptc.persistence.JsonFile;
import co.edu.uptc.view.FrameGUI;
import co.edu.uptc.view.PanelGUI;

public class Presenter implements ActionListener,WindowListener{
	private Dictionary dictionary;
	private FrameGUI frameManager;
	private JsonFile persistence;
	
	public Presenter() throws JsonParseException, IOException {
		frameManager = new FrameGUI(this, this);
		persistence = new JsonFile("data/translation.json");
	}
	
	public void readData() throws IOException {
		dictionary = new Dictionary(persistence.parseJSON());
	}
	
	public void writeData() throws FileNotFoundException, IOException {
		persistence.writeTranslations(dictionary.getDictionary());
	}
	
	public int getEnglishWordsNumber() {
		int count = 0;
		for (int i = 0; i < dictionary.getDictionary().size(); i++) {
			if(dictionary.getDictionary().get(i).getEnglish() != null && !(dictionary.getDictionary().get(i).getEnglish().equals(""))) {
				count++;
			}
		}
		return count;
	}
	
	public int getFrenchWordsNumber() {
		int count = 0;
		for (int i = 0; i < dictionary.getDictionary().size(); i++) {
			if(dictionary.getDictionary().get(i).getFrench() != null && !(dictionary.getDictionary().get(i).getFrench().equals(""))) {
				count++;
			}
		}
		return count;
	}
	
	public void obtainEnglishTranslation() {
		String userChoice = frameManager.getUserChoice();
		Translation translations = dictionary.getTranslations(userChoice);
		frameManager.setEnglishTxt(translations.getEnglish());
	}
	
	public void setEnglishWordsNumber() {
		int count = getEnglishWordsNumber();
		frameManager.setTotalEnglishTxt("" + count);
	}
	
	public void setFrenchWordsNumber() {
		int count = getFrenchWordsNumber();
		frameManager.setTotalFrenchTxt("" + count);
	}
	
	public void setWordsNumbers() {
		setEnglishWordsNumber();
		setFrenchWordsNumber();
	}
	
	public void obtainFrenchTranslation() {
		String userChoice = frameManager.getUserChoice();
		Translation translations = dictionary.getTranslations(userChoice);
		frameManager.setFrenchTxt(translations.getFrench());
	}
	
	public void addEnglishTranslation() {
		if (dictionary.getTranslationPosition(frameManager.getAddWordTxt()) == -1) {
			Translation newTranslation = new Translation();
			newTranslation.setSpanish(frameManager.getAddWordTxt());
			newTranslation.setEnglish(frameManager.getAddTranslateTxt());
			newTranslation.setFrench("");
			dictionary.addTranslation(newTranslation);
			frameManager.setAddWordTxt("");
			frameManager.setAddTranslateTxt("");
		} else {
			dictionary.getDictionary().get(dictionary.getTranslationPosition(frameManager.getAddWordTxt())).setEnglish(frameManager.getAddTranslateTxt());
			frameManager.setAddWordTxt("");
			frameManager.setAddTranslateTxt("");
		}
	}
	
	public void addFrenchTranslation() {
		if (dictionary.getTranslationPosition(frameManager.getAddWordTxt()) == -1) {
			Translation newTranslation = new Translation();
			newTranslation.setSpanish(frameManager.getAddWordTxt());
			newTranslation.setFrench(frameManager.getAddTranslateTxt());
			newTranslation.setEnglish("");
			dictionary.addTranslation(newTranslation);
			frameManager.setAddWordTxt("");
			frameManager.setAddTranslateTxt("");
		} else {
			dictionary.getDictionary().get(dictionary.getTranslationPosition(frameManager.getAddWordTxt())).setFrench(frameManager.getAddTranslateTxt());
			frameManager.setAddWordTxt("");
			frameManager.setAddTranslateTxt("");
		}
	}

	public void run() throws IOException {
		readData();
		setWordsNumbers();
	}

	public static void main(String[] args) throws IOException {
		Presenter presenter = new Presenter();
		presenter.run();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		switch (source) {
		case PanelGUI.SEARCH_ENGLISH_COM:
			obtainEnglishTranslation();
			break;
		case PanelGUI.SEARCH_FRENCH_COM:
			obtainFrenchTranslation();
			break;
		case PanelGUI.ADD_ENGLISH_COM:
			addEnglishTranslation();
			setEnglishWordsNumber();
			break;
		case PanelGUI.ADD_FRENCH_COM:
			addFrenchTranslation();
			setFrenchWordsNumber();
			break;
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			writeData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
