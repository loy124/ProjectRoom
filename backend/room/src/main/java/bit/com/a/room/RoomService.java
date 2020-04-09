package bit.com.a.room;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoomService {

    @Autowired
    RoomDao roomDao;

    public int addroom(RoomDto dto, RoomOptionDto optionDto) {
        System.out.println(dto.toString());
        int room = roomDao.addroom(dto);
        optionDto.setRoomId(dto.getId()); // 아이디 지정
        int option = roomDao.addRoomOption(optionDto);

        if (room != 0 && option != 0) {
            return 1;
        }
        // 실패
        if (room != 0 && option == 0) { // addRoom만 실행
            return 2;
        }
        // 실패
        if (room == 0 && option != 0) { // addRoomOption만 실행
            return 3;
        }

        return -1;
    }

    public int uploadFile(RoomPictureDto roomPictureDto) {
        return roomDao.addRoomPicture(roomPictureDto);
    }

    public RoomDto getRoomMap(RoomDto dto) {
        return roomDao.getRoomMap(dto);
    }

    // 방 등록 방 + 옵션
    /*
     * public int addRoom(RoomDto dto, RoomOptionDto optionDto) { int room =
     * roomDao.addRoom(dto); int option = roomDao.addRoomOption(optionDto);
     * 
     * if(room != 0 && option != 0) { return 1; } if(room != 0 && option == 0) {
     * //addRoom만 실행 return 2; } if(room == 0 && option != 0) { //addRoomOption만 실행
     * return 3; }
     * 
     * return -1; }
     * 
     * /* 기존 public int addRoom(RoomDto room) {
     * System.out.println("room addroom service");
     * System.out.println(room.toString()); return roomDao.addRoom(room); } public
     * int addRoomOption(RoomOptionDto optionDto) { return
     * roomDao.addRoomOption(optionDto); }
     */

    /*
     * public List<RoomDto> getRoomList() { return roomDao.getRoomList(); }
     */

}
