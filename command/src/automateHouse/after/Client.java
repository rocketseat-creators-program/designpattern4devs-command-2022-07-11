package automateHouse.after;

import automateHouse.after.arduinoLight.ArduinoLight;
import automateHouse.after.commands.TurnLightsOnCommand;
import automateHouse.after.rooms.GirlLivinRoom;
import automateHouse.after.rooms.KitchenRoom;

public class Client {
    public static void configureArduino(ArduinoLight arduino) {
		GirlLivinRoom livingRoom = new GirlLivinRoom();
		KitchenRoom kitchen = new KitchenRoom();
		
		arduino.addIntegration("Turn on the Living room light", new TurnLightsOnCommand(livingRoom), "on", "Living room", "light");
		arduino.addIntegration("Turn off the Living room light", new TurnLightsOnCommand(livingRoom), "off", "Living room", "light");
		arduino.addIntegration("Turn on the Kitchen light", new TurnLightsOnCommand(kitchen), "on", "Kitchen", "light");
		arduino.addIntegration("Turn off the Kitchen light", new TurnLightsOnCommand(kitchen), "off", "Kitchen", "light");
	}
	
	public static void main(String[] args) {
		ArduinoLight arduinoLight = new ArduinoLight();
		configureArduino(arduinoLight);
		
		arduinoLight.sendRequest("Turn on the Living room light");
		arduinoLight.sendRequest("Turn off the Kitchen light");
		
		arduinoLight.sendRequest("Please, could you Turn off the Living room light?");
	}
}
