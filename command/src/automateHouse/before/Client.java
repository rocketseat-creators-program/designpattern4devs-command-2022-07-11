package automateHouse.before;

import automateHouse.before.arduinoLight.ArduinoLight;

	public class Client {

		public static void main(String[] args) {
			ArduinoLight arduinoLight = new ArduinoLight();
			arduinoLight.sendRequest("Turn on the Living room light");
			arduinoLight.sendRequest("Turn off the Kitchen light");
		}
	}
