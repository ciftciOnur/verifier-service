package tr.edu.yeditepe.locationverifier.application;

public interface TotpService {

	String GenerateTotpAlgorithm();

	String GenerateTotpWithTime(long time, String algorithm, long precision);

}
