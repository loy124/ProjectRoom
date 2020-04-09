package bit.com.a.room;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.s3.S3Service;

@RequestMapping("/api/room")
@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    private S3Service s3Service;

    @PostMapping("/addroom") // 다중 mapping
    public String addroom(RoomDto dto, RoomOptionDto optionDto) {

        System.out.println("addroom 컨트롤러 도착");
        int number = 0;
        // System.out.println(dto.toString());
        // System.out.println(optionDto.toString());
        number = roomService.addroom(dto, optionDto);
        // 아이디 값 받아오기
        System.out.println("아이디 들어오나요?");
        // dto에 id가 담겨있다.(마이바티스에서 매핑해준다)
        System.out.println(dto.getId());

        // System.out.println(number);

        // 성공시 res에 dto의 id가 담긴다 (파일업로드에서 사용하기위해서 id값을 리턴한다 )
        return number > 0 ? (dto.getId() + "") : "NO";
    }

    @PostMapping("/upload")
    public String execWrite(RoomPictureDto roomPictureDto, MultipartFile file) throws IOException {
        System.out.println(file);
        // for (int i = 0; i < files.length; i++) {
        String imgPath = s3Service.upload(roomPictureDto.getFileName(), file);
        roomPictureDto.setFileName("https://" + "dixo0q5vi6g16.cloudfront.net" + "/" + imgPath);
        // }
        return roomService.uploadFile(roomPictureDto) > 0 ? "OK" : "FAIL";
    }

    @PostMapping("/getRoomMap")
    public RoomDto getRoomMap(RoomDto dto) {
        return roomService.getRoomMap(dto);
    }

    @PostMapping("/getRoomMapList")
    public List<RoomDto> getRoomMapList() {
        return roomService.getRoomMapList();
    }

    // @PostMapping("/addroom") // 다중 mapping
    // public String addroom(RoomDto dto, RoomOptionDto optionDto) {

    // System.out.println("addroom 컨트롤러 도착");
    // int number = 0;
    // System.out.println(dto.toString());
    // System.out.println(optionDto.toString());
    // number = roomService.addroom(dto, optionDto);

    // System.out.println(number);

    // return number > 0 ? "YES" : "NO";
    // }

    /*
     * // 방 내놓기
     * 
     * @PostMapping("/addroom") // 다중 mapping public String addroom(RoomDto dto,
     * RoomOptionDto optionDto) {
     * 
     * System.out.println("addroom 컨트롤러 도착"); int number = 0;
     * System.out.println(dto.toString());
     * 
     * number = roomService.addRoom(dto, optionDto); System.out.println(number);
     * 
     * return number == 1 ? "YES" : "NO"; }
     * 
     * @GetMapping("/getRoomList") public List<RoomDto> getRoomList() { return
     * roomService.getRoomList(); }
     */

}
