package automateHouse.before.arduinoLight;

import java.util.HashMap;
import java.util.Map;

import automateHouse.before.rooms.KitchenRoom;
import automateHouse.before.rooms.GirlLivinRoom;



public class ArduinoLight {

	private Map<String, Object> integrations;
	
	public ArduinoLight() {
		integrations = new HashMap<String, Object>();
		integrations.put("LivingRoomLight", new GirlLivinRoom());
		integrations.put("KitchenLight", new KitchenRoom());
	}

	public void sendRequest(String request) {
		if(request.equals("Turn on the Living room light")) {
			System.out.println("Turnning on the Living room light");
			GirlLivinRoom light = (GirlLivinRoom) integrations.get("LivingRoomLight");
			light.turnOn();
		} else if(request.equals("Turn off the Living room light")) {
			System.out.println("Turnning off the Living room light");
			GirlLivinRoom light = (GirlLivinRoom) integrations.get("LivingRoomLight");
			light.turnOff();
		} else if(request.equals("Turn on the Kitchen light")) {
			System.out.println("Turnning on the Kitchen light");
			KitchenRoom light = (KitchenRoom) integrations.get("KitchenLight");
			light.turnOn();
		} else if(request.equals("Turn off the Kitchen light")) {
			System.out.println("Turnning off the Kitchen light");
			KitchenRoom light = (KitchenRoom) integrations.get("KitchenLight");
			light.turnOff();
		} else {
			System.out.println("Sorry, I can't perform your request!");
		}
			 
	}
    
}