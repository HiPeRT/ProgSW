package adstack.models;

/**
 * Interface to fusion components
 */
public interface IFusion extends IComponent {
	/**
	 * Register this component as a source
	 * @param component
	 */
    void bind(IComponent component);

}
