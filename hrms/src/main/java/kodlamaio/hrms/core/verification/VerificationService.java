package kodlamaio.hrms.core.verification;

public interface VerificationService {
	String sendCode();
	boolean emailVerification();
	void sendLink(String email);
}
