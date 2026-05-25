import adstack.ADStackComposer;
import adstack.IncoherentStackException;
import adstack.components.*;
import person.PersonFluent;

public class MainClass {

	public static void main(String[] args) {
		
		// The java.lang.StringBuilder class uses fluent 
		String str = new StringBuilder()
				.append("Hello")
	            .append(" ")
	            .append("World")
	            .append("!\n")
	            .toString();
		
		System.out.println(str);
		
		 // This is my own implementation of a possible Autonomous Driving stack builder,
        //  where you can add components to the stack and then run it.

		FileMapRepository mapsrepo = new FileMapRepository("\\resources\\maps\\");

        try {
			new ADStackComposer()
			    // Set up the perception stack
	            .addPerception(new YoloV8PedestrianDetector())
	            .addPerception(new LidarClusteringForPedestrian())
	            .addFusion(new PedestrianDetector())

			    // Set up the loc
			    .addPerception(new GNSSReceiver())
			    .addFusion(new EKFLocalization())

			    // Add maps
	            .registerMap(mapsrepo.get("Modena"))
	            .registerMap(mapsrepo.get("Reggio Emilia"))
	            .registerMap(mapsrepo.get("Mantova"))


			    // Register planner, controller and vehicle backend
	            .addPlanner(new PathPlanner())
	            .addController(new ModelPredictiveControl())
	            .addActuation(QuattroporteDBWAdapter.GetInstance()) // Singleton. I think we only have a single access to car control, right?
	
			    // Ok, we can go...and hopefylly don't crash. And If we crash, it's not Fluent's fault!!!
			    .run();
			
		} catch (IncoherentStackException e) {
			e.printStackTrace();
		}
        
        // This is the Persona exercise
		try {
			PersonFluent p = new PersonFluent()
				// This is the version where every configuration is passed as param
				//.config(true)
				// This is the version where we have a dedicated PersonCfg object
				.config((cfg) -> { cfg.Immutable = true; })
				.withName("Paolo")
				.persist();
	        System.out.println(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
