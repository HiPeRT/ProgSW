package adstack.components;

import adstack.models.IComponent;
import adstack.models.IFusion;

/**
 * Loc with Extended Kalman filter
 */
public class EKFLocalization implements IFusion {

	@Override
	public void bind(IComponent component) {
        System.out.println("[EKFLocalization] Binding component: " + component.getClass().getName());
	}

	@Override
	public void start() {
        System.out.println("[EKFLocalization] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[EKFLocalization] Stopping.");
	}

}
