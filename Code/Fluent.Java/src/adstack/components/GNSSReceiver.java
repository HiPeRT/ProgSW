package adstack.components;

import adstack.models.IComponent;

public class GNSSReceiver implements IComponent {

	@Override
	public void start() {
        System.out.println("[GNSSReceiver] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[GNSSReceiver] Stopping.");
	}

}
