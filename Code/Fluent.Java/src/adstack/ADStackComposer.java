package adstack;

import java.util.ArrayList;

import adstack.models.IComponent;
import adstack.models.IFusion;
import adstack.models.IMap;

/**
 * This class builds and starts an AD stack
 */
public class ADStackComposer {
	
	private ArrayList<IComponent> _perception = new ArrayList<IComponent>();
    private ArrayList<IComponent> _fusion = new ArrayList<IComponent>();
    private ArrayList<IMap> _maps = new ArrayList<IMap>();
    private ArrayList<IComponent> _planners = new ArrayList<IComponent>();
    private IComponent _controller = null;
    private IComponent _vehiclebackend = null;
    
    /**
     * Insert a perception module
     * @param component
     * @return
     */
    public ADStackComposer addPerception(IComponent component) {
        _perception.add(component);
        return this;
    }
    
    /**
     * Insert a fusion module that aggregates all perception previously added.
     * @param component
     * @return
     * @throws IncoherentStackException 
     */
    public ADStackComposer addFusion(IFusion component) throws IncoherentStackException {
        if (_perception.size() < 2) throw new IncoherentStackException();

        _fusion.add(component);
        return this;
    }

    /**
     * Register a map for loc
     * @param get
     */
	public ADStackComposer registerMap(IMap map) {
		_maps.add(map);
		return this;		
	}

	/**
	 * Add a planner (local or global) to the stack.
	 * @param component
	 * @return
	 */
	public ADStackComposer addPlanner(IComponent component) {
		_planners.add(component);
		return this;		
	}
	
	/**
	 * Add a vehicle controller. We can have exactly once.
	 * @param component
	 * @return
	 * @throws IncoherentStackException 
	 */
	public ADStackComposer addController(IComponent component) throws IncoherentStackException {
		 if (_controller != null) throw new IncoherentStackException("Attempting to register multiple controllers");
         _controller = component;
         return this;
	}
	
	/**
	 * Add interface to vehicle Drive-by-wire. We can have exactly once.
	 * @param component
	 * @return
	 * @throws IncoherentStackException
	 */
	public ADStackComposer addActuation(IComponent component) throws IncoherentStackException {
	     if (_vehiclebackend != null) throw new IncoherentStackException("Attempting to register multiple vehicle backends");
	     _vehiclebackend = component;
	     return this;
     }
	
	public void run() throws IncoherentStackException {
        if (_perception.size() == 0) throw new IncoherentStackException("No perception module(s) are registered");
        // We might not have sensor fusion, maps, nor planners. Soo no need to check for them
        if (_controller == null) throw new IncoherentStackException("No controller registered");


        System.out.println("Starting ADStack components...");
        for (IComponent c : _perception) c.start();
        for (IComponent c : _fusion) c.start();
        for (IComponent c : _planners) c.start();
        _controller.start();
        _vehiclebackend.start();

        System.out.println("ADStack up and running. Now you can let me drive and relax.");
    }
}
