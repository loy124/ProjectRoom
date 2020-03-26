package bit.com.a.broker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrokerService {

	@Autowired
	BrokerDao brokerDao;

	public int register(BrokerDto user) {
		System.out.println("user service");
		System.out.println(user.toString());
		return brokerDao.register(user);
	}

	public List<BrokerDto> getMemberList() {
		return brokerDao.getMemberList();
	}

	public BrokerDto login(BrokerDto user) {
		return brokerDao.login(user);
	}

	public BrokerDto getInformation(BrokerDto user) {
		return brokerDao.getInformation(user);
	}
}
