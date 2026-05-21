package adstack.components;

import adstack.models.IComponent;

public class QuattroporteDBWAdapter implements IComponent {

	/* Singleton pattern */
	private static QuattroporteDBWAdapter _Instance = null;

	public static QuattroporteDBWAdapter GetInstance() {
		if(_Instance == null) _Instance = new QuattroporteDBWAdapter();
		return _Instance;
	}
	
	private QuattroporteDBWAdapter() {
		
	}
	
	/* As IComponent */
	
	@Override
	public void start() {
        System.out.println("[QuattroporteDBWAdapter] Starting.");
	}

	@Override
	public void stop() {
        System.out.println("[QuattroporteDBWAdapter] Stopping.");
	}

}
