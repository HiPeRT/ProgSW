package diwithguice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainClass {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new ConfiguratorModule());
		IServiceConsumer svcConsumer = injector.getInstance(ServiceConsumerWithSetter.class);

		//IServiceConsumer svcConsumer = injector.getInstance(ServiceConsumerWithCtor.class);
		
		svcConsumer.run();

	}

}
