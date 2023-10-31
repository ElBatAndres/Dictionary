package co.edu.uptc.persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import co.edu.uptc.model.Translation;

public class JsonFile {
	private JsonParser jsonParser;
	private JsonGenerator jsonGenerator;
	private String path;

	public JsonFile(String path) throws JsonParseException, IOException {
		this.path = path;
	}

	public ArrayList<Translation> parseJSON() throws JsonParseException, IOException {
		jsonParser = new JsonFactory().createParser(new File(path));
		ArrayList<Translation> translations = new ArrayList<>();
		while (jsonParser.nextToken() != null) {
			if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
				Translation trs = new Translation();
				while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
					if (jsonParser.getCurrentName() != null) {
						switch (jsonParser.getCurrentName()) {
						case "Spanish":
							jsonParser.nextToken();
							trs.setSpanish(jsonParser.getText());
							break;
						case "English":
							jsonParser.nextToken();
							trs.setEnglish(jsonParser.getText());
							break;
						case "French":
							jsonParser.nextToken();
							trs.setFrench(jsonParser.getText());
							break;
						}
					}
				}
				translations.add(trs);
			}
		}
		jsonParser.close();
		return translations;
	}

	public void writeTranslations(ArrayList<Translation> translations) throws FileNotFoundException, IOException {
		jsonGenerator = new JsonFactory().createGenerator(new FileOutputStream(path));
		jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
		jsonGenerator.writeStartArray();
		for (Translation trs : translations) {
			jsonGenerator.writeStartObject();
			jsonGenerator.writeStringField("Spanish", trs.getSpanish());
			jsonGenerator.writeStringField("English", trs.getEnglish());
			jsonGenerator.writeStringField("French", trs.getFrench());
			jsonGenerator.writeEndObject();
		}
		jsonGenerator.writeEndArray();
		jsonGenerator.flush();
		jsonGenerator.close();

	}

}
