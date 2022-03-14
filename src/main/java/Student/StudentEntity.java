
package Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class  StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="student_id")
	private Long id;

	@Column(name="student_first_name")
	private String firstName;

	@Column(name="student_last-name")
	private String lastName;

	@Column(name="student_email_id")
	public String emaillId;

}
