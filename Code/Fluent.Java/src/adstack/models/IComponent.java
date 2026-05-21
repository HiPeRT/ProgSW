package adstack.models;

/**
 * Generic AD component
 */
public interface IComponent {
	
	/**
	 * Each component has its own internal thread. We start it.
	 */
	void start();
	
	/**
	 * Stop and dispose.
	 */
    void stop();
}
