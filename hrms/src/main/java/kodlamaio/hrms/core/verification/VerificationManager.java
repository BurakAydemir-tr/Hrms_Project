package kodlamaio.hrms.core.verification;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class VerificationManager implements VerificationService{

	@Override
	public String sendCode() {
		UUID uuid=UUID.randomUUID();
		String code=uuid.toString();
		return code;
	}

	@Override
	public boolean emailVerification() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
		System.out.println("Doğrulama linki gönderildi. " + email );
		System.out.println("Hesabınız doğrulamak için lütfen tıklayın:  " + verificationLink );
	}

}
