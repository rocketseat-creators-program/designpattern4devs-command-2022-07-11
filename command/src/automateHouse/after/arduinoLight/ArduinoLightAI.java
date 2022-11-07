package automateHouse.after.arduinoLight;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
/**
 * ArduinoLightAI
 */
public class ArduinoLightAI {

    private Map<String, String[]> associations;
	
	public ArduinoLightAI() {
		associations = new HashMap<String, String[]>();
	}
	
	public void addAssociation(String key, String[] association) {
		associations.put(key, association);
	}
	
	public String getFindAssociations(String request) {
		for(String[] association: associations.values()) {
			if (Stream.of(association).allMatch(request::contains)) {
				return getKeyFromAssociations(association);
			}
		}
		return null;
	}

	private String getKeyFromAssociations(String... keywords) {
		return associations
			      .entrySet()
			      .stream()
			      .filter(entry -> keywords.equals(entry.getValue()))
			      .map(Map.Entry::getKey)
			      .findFirst().get();
	}
    
}