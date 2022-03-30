package tr.edu.yeditepe.locationverifier.application.impl;

import org.springframework.stereotype.Component;

import tr.edu.yeditepe.locationverifier.application.LocationVerifierService;

@Component
public class LocationVerifierServiceImpl implements LocationVerifierService{
	
	
	@Override
	public void requestHandler(String crypedMessage) {
		String[] crypedMessages = crypedMessage.split("###");
		
		//do something with them
		
	}

}
