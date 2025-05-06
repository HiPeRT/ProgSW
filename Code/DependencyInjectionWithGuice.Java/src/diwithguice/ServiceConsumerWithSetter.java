package diwithguice;

import com.google.inject.Inject;

public class ServiceConsumerWithSetter implements IServiceConsumer {
private IWriter _writer = null;
	
	@Inject
	public void setWriter(IWriter service) {
		this._writer = service;
	}
	
	public void run() {
	    String s = "This is my test";
	    this._writer.writer(s);
	}
}
