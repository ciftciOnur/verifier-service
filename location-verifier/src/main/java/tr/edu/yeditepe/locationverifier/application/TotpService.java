package tr.edu.yeditepe.locationverifier.application;

public interface TotpService {

	String GenerateTotpWithTime(long time, String algorithm, long precision);

	String generateTotpKey();

}
