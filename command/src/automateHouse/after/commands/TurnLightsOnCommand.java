package automateHouse.after.commands;

import automateHouse.after.rooms.GenericRoom;

public class TurnLightsOnCommand implements Command {

    private GenericRoom light;
	
	
	public TurnLightsOnCommand(GenericRoom light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.turnOff();
	}
    
}
