package bit.com.a.broker;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data // getter setter 자동생성
@AllArgsConstructor // 모든 생성자(전체 포함, 일부생성자는 만들어줘야함)
@NoArgsConstructor // 기본 생성자 UserDto(){}
@ToString
// @Entity
public class BrokerDto {

	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String brokerId;

	private String brokerPassword;

	private String name;

	private String email;

	private int age;

	private String phoneNumber;

	private String address;

	private String auth;

	private String certification;

	private String originalCertification;

	private LocalDateTime registeredAt;

	private String registeredBy;

	private LocalDateTime updatedAt;

	private String updatedBy;

	private String profileImage;

	private String originalProfileImage;

	private LocalDateTime unRegisteredAt;

	private String unRegisteredBy;

	private int writeCount;

}
