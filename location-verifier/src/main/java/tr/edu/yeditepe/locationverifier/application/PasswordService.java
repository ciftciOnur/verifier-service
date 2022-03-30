package tr.edu.yeditepe.locationverifier.application;

public interface PasswordService {

	byte[] getNextSalt();

	byte[] hash(char[] password, byte[] salt);

	boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash);

	String generateRandomPassword(int length);

}
