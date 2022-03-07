package Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping("/ii")
	public StudentDTO add(StudentDTO dto) {
		StudentEntity e=StudentTransformer.getStudentEntity(dto);
		StudentEntity added=service.addStudent(e);
		return StudentTransformer.getStudentDTO(added);
	}

}
