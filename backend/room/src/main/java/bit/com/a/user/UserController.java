package bit.com.a.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user") // 해당 컨트롤러의 기본 주소 매핑 따라서 /api/user/register 식으로 호출해야함
public class UserController {
	@Autowired
	UserService userService;

	// 회원가입
	localhost/api/user/resgister @PostMapping("/register")

	public String register(UserDto user) {
		System.out.println("컨트롤러");
		int number = 0;
		System.out.println(user.toString());

		number = userService.register(user);
		System.out.println(number);

		return number > 0 ? "ok" : "false";
	}

	// 관리자 단에서 멤버관리를 위한 용도
	@GetMapping("/getMemberList")
	public List<UserDto> getMemberList() {
		return userService.getMemberList();
	}

	// 로그인
	@PostMapping("/login")
	public UserDto login(UserDto user) {
		return userService.login(user);
	}

	// 유저의 정보를 가져오기 위한용도
	// 마이페이지 정보 가져오기등
	@PostMapping("/getInformation")
	public UserDto getInformation(UserDto user) {
		return userService.login(user);
	}

}
