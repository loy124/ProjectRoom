package bit.com.a.broker;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BrokerDao {
	public int register(BrokerDto broker);

	public List<BrokerDto> getMemberList();

	public BrokerDto login(BrokerDto broker);

	public BrokerDto getInformation(BrokerDto broker);
}
