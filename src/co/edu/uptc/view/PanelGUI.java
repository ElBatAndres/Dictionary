package co.edu.uptc.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelGUI extends JPanel{
	public static final String SEARCH_ENGLISH_COM = "searchEnglish";
	public static final String SEARCH_FRENCH_COM = "searchFrench";
	public static final String ADD_ENGLISH_COM = "addEnglish";
	public static final String ADD_FRENCH_COM = "addFrench";
	private JLabel wordLbl, totalEnglishLbl, totalFrenchLbl, addWordLbl, addTranslateLbl;
	private JTextField optionSelectTxt, englishTxt, frenchTxt, totalEnglishTxt, totalFrenchTxt, addWordTxt, addTranslateTxt;
	private JButton searchEnglishBtn, searchFrenchBtn, addEnglishBtn, addFrenchBtn;
	
	public PanelGUI(ActionListener event) {
		initComponents(event);
	}
	
	public void initComponents(ActionListener event) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		this.add(createTop(event),gbc);
		
		gbc.gridy = 1;
		gbc.insets = new Insets(0,0,30,0);
		this.add(createMiddle(),gbc);
		
		gbc.gridy = 3;
		this.add(createFoot(event),gbc);
	}

	public void setOptionSelectTxt(JTextField optionSelectTxt) {
		this.optionSelectTxt = optionSelectTxt;
	}

	public JPanel createFoot(ActionListener event) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		addWordLbl = new JLabel("Palabra: ");
		addWordTxt = new JTextField(10);
		addTranslateLbl = new JLabel("Traduccion: ");
		addTranslateTxt = new JTextField(10);
		addEnglishBtn = new JButton("Agregar a ingles");
		addEnglishBtn.setActionCommand(ADD_ENGLISH_COM);
		addEnglishBtn.addActionListener(event);
		addFrenchBtn = new JButton("Agregar a frances");
		addFrenchBtn.setActionCommand(ADD_FRENCH_COM);
		addFrenchBtn.addActionListener(event);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(addWordLbl,gbc);
		panel.add(addWordTxt,gbc);
		panel.add(addTranslateLbl,gbc);
		panel.add(addTranslateTxt,gbc);
	
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		panel.add(addEnglishBtn,gbc);
		panel.add(addFrenchBtn,gbc);
		
		return panel;
	}
	
	public JPanel createMiddle() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		totalEnglishLbl = new JLabel("Total ingles");
		totalFrenchLbl = new JLabel("Total frances");
		totalEnglishTxt = new JTextField(5);
		totalEnglishTxt.setEditable(false);
		totalFrenchTxt = new JTextField(5);
		totalFrenchTxt.setEditable(false);
		
		panel.add(totalEnglishLbl);
		panel.add(totalEnglishTxt);
		panel.add(totalFrenchLbl);
		panel.add(totalFrenchTxt);
		
		return panel;
	}
	
	public JPanel createTop(ActionListener event) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		wordLbl = new JLabel("Palabra:");
		searchEnglishBtn = new JButton("Traducir a ingles");
		searchEnglishBtn.setActionCommand(SEARCH_ENGLISH_COM);
		searchEnglishBtn.addActionListener(event);
		searchFrenchBtn = new JButton("Traducir a frances");
		searchFrenchBtn.setActionCommand(SEARCH_FRENCH_COM);
		searchFrenchBtn.addActionListener(event);
		optionSelectTxt = new JTextField(20);
		englishTxt = new JTextField(20);
		englishTxt.setEditable(false);
		frenchTxt = new JTextField(20);
		frenchTxt.setEditable(false);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.fill = GridBagConstraints.BOTH;
		panel.add(wordLbl,gbc);
		panel.add(optionSelectTxt,gbc);
		
		gbc.gridy = 1;
		panel.add(searchEnglishBtn,gbc);
		panel.add(englishTxt,gbc);
		
		gbc.gridy = 2;
		panel.add(searchFrenchBtn,gbc);
		panel.add(frenchTxt,gbc);
		
		return panel;
	}
	
	public JTextField getOptionSelectTxt() {
		return optionSelectTxt;
	}

	public JTextField getEnglishTxt() {
		return englishTxt;
	}

	public JTextField getAddWordTxt() {
		return addWordTxt;
	}

	public void setAddWordTxt(JTextField addWordTxt) {
		this.addWordTxt = addWordTxt;
	}

	public JTextField getAddTranslateTxt() {
		return addTranslateTxt;
	}

	public void setAddTranslateTxt(JTextField addTranslateTxt) {
		this.addTranslateTxt = addTranslateTxt;
	}

	public JTextField getTotalFrenchTxt() {
		return totalFrenchTxt;
	}

	public void setTotalFrenchTxt(JTextField totalFrenchTxt) {
		this.totalFrenchTxt = totalFrenchTxt;
	}

	public JTextField getTotalEnglishTxt() {
		return totalEnglishTxt;
	}

	public void setTotalEnglishTxt(JTextField totalEnglishTxt) {
		this.totalEnglishTxt = totalEnglishTxt;
	}

	public JTextField getFrenchTxt() {
		return frenchTxt;
	}

	public void setFrenchTxt(JTextField frenchTxt) {
		this.frenchTxt = frenchTxt;
	}

	public void setEnglishTxt(JTextField englishTxt) {
		this.englishTxt = englishTxt;
	}
	
}
