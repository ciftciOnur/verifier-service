package tr.edu.yeditepe.locationverifier.application;

import java.io.IOException;

public interface LocationVerifierService {

	boolean requestHandler(String crypedMessage) throws IOException;

}
