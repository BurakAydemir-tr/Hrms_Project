package kodlamaio.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.services.FakeMernisService;

@Service
public class MernisServiceAdapter implements ValidationService{

	@Override
	public boolean validateByMernis(long nationalId, String firstName, String lastName) {
		
		FakeMernisService mernisService=new FakeMernisService();
		
		return mernisService.ValidateByPersonTC(nationalId, firstName, lastName);
	}
	
}
