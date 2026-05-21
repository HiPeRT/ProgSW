package adstack.components;

import adstack.models.IComponent;

public class LidarClusteringForPedestrian implements IComponent {

	@Override
	public void start() {
        System.out.println("[LidarClusteringForPedestrian] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[LidarClusteringForPedestrian] Stopping.");
	}

}
