package diwithguice;

import com.google.inject.AbstractModule;

public class ConfiguratorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IWriter.class).to(MyWriter.class);
	}
}
