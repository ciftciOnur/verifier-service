package tr.edu.yeditepe.locationverifier.application;

import java.io.IOException;

public interface NtpService {

	long getTime() throws IOException;

}
