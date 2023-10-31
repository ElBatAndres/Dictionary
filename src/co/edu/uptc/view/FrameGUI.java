package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class FrameGUI extends JFrame {
	private PanelGUI panel;

	public FrameGUI(ActionListener event, WindowListener windowEvent) {
		super("Diccionario de sinonimos");
		this.setSize(500,500);
		initComponents(event);
		this.addWindowListener(windowEvent);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void initComponents(ActionListener event) {
		panel = new PanelGUI(event);
		this.getContentPane().add(panel);
	}
	
	public void setTotalEnglishTxt(String number) {
		panel.getTotalEnglishTxt().setText(number);
	}
	
	public String getAddWordTxt() {
		return panel.getAddWordTxt().getText();
	}
	
	public void setAddWordTxt(String text) {
		panel.getAddWordTxt().setText(text);
	}
	
	public String getAddTranslateTxt() {
		return panel.getAddTranslateTxt().getText();
	}
	
	public void setAddTranslateTxt(String text) {
		panel.getAddTranslateTxt().setText(text);
	}
	
	public void setTotalFrenchTxt(String number) {
		panel.getTotalFrenchTxt().setText(number);
	}
		
	public String getUserChoice() {
		return panel.getOptionSelectTxt().getText();
	}
	
	public void setEnglishTxt(String translation) {
		panel.getEnglishTxt().setText(translation);
	}
	
	public void setFrenchTxt(String translation) {
		panel.getFrenchTxt().setText(translation);
	}
	
}
