package automateHouse.after.arduinoLight;

import java.util.HashMap;
import java.util.Map;

import automateHouse.after.commands.Command;


public class ArduinoLight {

	private Map<String, Command> integrations;
	private ArduinoLightAI ai;
	
	public ArduinoLight() {
		integrations = new HashMap<String, Command>();
		ai = new ArduinoLightAI();
	}
	
	public void addIntegration(String key, Command command, String... keywords) {
		integrations.put(key, command);
		ai.addAssociation(key, keywords);
	}

	public void sendRequest(String request) {
		Command command = integrations.get(request);
		if(command == null) {
			String key = ai.getFindAssociations(request);
			command = integrations.get(key);
			if(command == null) {
				System.out.println("Sorry, I can't perform your request!");
				return;
			}
		}
		System.out.println("Send a generic command as you saved in my configurations");
		command.execute();			 
	}
    
}