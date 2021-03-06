package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;

public interface ResumeService {
	Result add(Resume resume);
	Result update(Resume resume);
	DataResult<List<Resume>> getAll();
	
	Result saveImage(MultipartFile file,int resumeId);
	DataResult<Resume> getById(int id);
	DataResult<Resume> getByCandidateId(int id);
}
