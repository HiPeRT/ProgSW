using ConsoleApp.ADStack.Models;

namespace ConsoleApp.ADStack
{
    /// <summary>
    /// This class builds and starts an AD stack
    /// </summary>
    internal class ADStackComposer
    {
        private readonly List<IComponent> _perception = new List<IComponent>();
        private readonly List<IComponent> _fusion = new List<IComponent>();
        private readonly List<IMap> _maps = new List<IMap>();
        private readonly List<IComponent> _planners = new List<IComponent>();
        private IComponent _controller = null;
        private IComponent _vehiclebackend = null;

        /// <summary>
        /// Insert a perception module
        /// </summary>
        /// <param name="component"></param>
        /// <returns></returns>
        public ADStackComposer AddPerception(IComponent component)
        {
            _perception.Add(component);
            return this;
        }

        /// <summary>
        /// Insert a fusion module that aggregates all perception previously added.
        /// </summary>
        /// <returns></returns>
        /// <exception cref="IncoherentStackException"></exception>
        public ADStackComposer AddFusion(IFusion component)
        {
            if (_perception.Count < 2) throw new IncoherentStackException();

            _fusion.Add(component);
            return this;
        }

        /// <summary>
        /// Register a map for loc
        /// </summary>
        /// <param name="map"></param>
        /// <returns></returns>
        /// <exception cref="NotImplementedException"></exception>
        internal ADStackComposer RegisterMap(IMap map)
        {
            _maps.Add(map);
            return this;
        }

        /// <summary>
        /// Add a planner (local or global) to the stack.
        /// </summary>
        /// <param name="component"></param>
        /// <returns></returns>
        public ADStackComposer AddPlanner(IComponent component)
        {
            _planners.Add(component);
            return this;
        }

        /// <summary>
        /// Add a vehicle controller. We can have exactly once.
        /// </summary>
        /// <param name="component"></param>
        /// <returns></returns>
        public ADStackComposer AddController(IComponent component)
        {
            if (_controller != null) throw new IncoherentStackException("Attempting to register multiple controllers");
            _controller = component;
            return this;
        }
        
        /// <summary>
        /// Add interface to vehicle Drive-by-wire. We can have exactly once.
        /// </summary>
        /// <param name="component"></param>
        /// <returns></returns>
        public ADStackComposer AddActuation(IComponent component)
        {
            if (_vehiclebackend != null) throw new IncoherentStackException("Attempting to register multiple vehicle backends");
            _vehiclebackend = component;
            return this;
        }

        /// <summary>
        /// Run the stack
        /// </summary>
        /// <exception cref="IncoherentStackException"></exception>
        public void Run()
        {
            if (_perception.Count == 0) throw new IncoherentStackException("No perception module(s) are registered");
            // We might not have sensor fusion, maps, nor planners. Soo no need to check for them
            if (_controller == null) throw new IncoherentStackException("No controller registered");


            Console.WriteLine($"Starting ADStack components...");
            foreach (var c in _perception) c.Start();
            foreach (var c in _fusion) c.Start();
            foreach (var c in _planners) c.Start();
            _controller.Start();
            _vehiclebackend.Start();

            Console.WriteLine($"ADStack up and running. Now you can let me drive and relax.");
        }
    }
}
