package tr.edu.yeditepe.locationverifier.application;

public interface TotpService {

	String GenerateTotp();

	String GenerateTotpWithTime(long time, String algorithm, int precision);

}
