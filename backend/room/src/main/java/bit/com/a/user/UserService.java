package bit.com.a.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDao userDao;

	public int register(UserDto user) {
		System.out.println("user service");
		System.out.println(user.toString());
		return userDao.register(user);
	}

	public List<UserDto> getMemberList() {
		return userDao.getMemberList();
	}

	public UserDto login(UserDto user) {
		return userDao.login(user);
	}

	public UserDto getInformation(UserDto user) {
		return userDao.getInformation(user);
	}
}
