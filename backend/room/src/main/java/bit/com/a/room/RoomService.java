package bit.com.a.room;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dummyData.DongDto;
import bit.com.a.dummyData.SiDto;
import bit.com.a.dummyData.GuDto;

@Service
@Transactional
public class RoomService {

    @Autowired
    RoomDao roomDao;

    public int addroom(RoomDto dto, RoomOptionDto optionDto) {
        System.out.println(dto.toString());

        String[] addressSplit = dto.getAddressDetailZibun().split(" ");
        String dongTemp = addressSplit[2];    //3번째 단어를 담는다.
        System.out.println(dongTemp);
        System.out.println(dto.getDONGId());
        
        List<DongDto> dongList = roomDao.getDongByName(dongTemp);
        if(dongList.size() == 0) {
            System.out.println("검색 결과가 없음. 단 3번째 단어가 동이아닐 수 있으므로 재검색.");
            dongTemp = addressSplit[3];    //4번째 단어를 담는다.
            System.out.println(dongTemp);
        
            List<DongDto> dongList2 = roomDao.getDongByName(dongTemp);
            if(dongList2.size() == 0) {
                System.out.println("검색 결과가 없음.");
            }else if(dongList2.size() == 1) {
                System.out.println("검색 결과가 1개 존재함");
                dto.setDONGId(dongList2.get(0).getId());
            }else if(dongList2.size() >= 2) {
                System.out.println("중복된 검색결과가 존재함. ");
            }else {
                System.out.println("?????????????? 여길 왜와????? 음수가 출력될리가 없는데??");
            }
        }else if(dongList.size() == 1) {
            System.out.println("검색 결과가 1개 존재함");
            dto.setDONGId(dongList.get(0).getId());
        }else if(dongList.size() >= 2) {
            System.out.println("중복된 검색결과가 존재함. ");
        }else {
            System.out.println("?????????????? 여길 왜와????? 음수가 출력될리가 없는데??");
        }
        
        if(dto.getDONGId() != 0) {  //무언가 값이 저장되었다는 것.
            System.out.println("카운터 증가 구간 접근");
            System.out.println(dto.getDONGId());

            roomDao.updateDongCount(dto.getDONGId());
            System.out.println("동 완료");
            roomDao.updateGuCount(roomDao.getGu(roomDao.getDong(dto.getDONGId()).getGuId()).getId());
            System.out.println("구 완료");
            roomDao.updateSiCount(roomDao.getSi((roomDao.getGu(roomDao.getDong(dto.getDONGId()).getGuId()).getSiId())).getId());
            System.out.println("시 완료");
        }

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

    public int updateRoom(RoomDto dto, RoomOptionDto optionDto, RoomPictureDto roomPictureDto) {
        int room = roomDao.updateRoom(dto);
        optionDto.setRoomId(dto.getId());
        int option = roomDao.updateRoomOption(optionDto);
        roomPictureDto.setRoomId(dto.getId());
        int del = roomDao.deletePictures(roomPictureDto);
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

    public List<RoomDto> getRoomMapList() {
        return roomDao.getRoomMapList();
    }

    public RoomDto getRoomDetail(RoomDto dto) {
        return roomDao.getRoomDetail(dto);
    }

    public List<RoomDto> getRoomBrokerList(RoomDto dto) {
        return roomDao.getRoomBrokerList(dto);
    }

    public int deleteRoom(RoomDto dto) {
        return roomDao.deleteRoom(dto);
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
