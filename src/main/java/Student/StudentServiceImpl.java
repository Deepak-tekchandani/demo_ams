package Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repo;

	@Override
	public StudentEntity addStudent(StudentEntity std) {
		StudentEntity e=repo.save(std);
		return e;
	}

}
