package bit.com.a.user;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter 자동생성
@AllArgsConstructor // 모든 생성자(전체 포함, 일부생성자는 만들어줘야함)
@NoArgsConstructor // 기본 생성자 UserDto(){}
// @Entity
public class UserDto {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userId;

	private String userPassword;

	private String name;

	private String email;

	private int age;

	private String phoneNumber;

	private String address;

	private String auth;

	private String registeredAt;

	private String registeredBy;

	private String updatedAt;

	private String updatedBy;

	private String profileImage;

	private String unRegisteredAt;

	private String unRegisteredBy;

}
