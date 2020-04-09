package bit.com.a.room;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoomDao {

	public int addroom(RoomDto dto);

	public int addRoomOption(RoomOptionDto optionDto);

	public int addRoomPicture(RoomPictureDto roomPictureDto);

	public RoomDto getRoomMap(RoomDto dto);

	// 방 등록
	// public int addRoom(RoomDto dto);
	// public int addRoomOption(RoomOptionDto optionDto);

	// 방 등록 결과값
	/* public List<RoomDto> getRoomList(); */

}
