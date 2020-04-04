package bit.com.a.room;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api/room") 
@RestController
public class RoomController {
	
	@Autowired
	RoomService roomService;
	
    @PostMapping("/addroom")  // 다중 mapping
    public String addroom(RoomDto dto, RoomOptionDto optionDto) {
    	
        System.out.println("addroom 컨트롤러 도착");
        int number = 0;
        System.out.println(dto.toString());
        System.out.println(optionDto.toString());
        number = roomService.addroom(dto, optionDto);
        
        System.out.println(number);

        return number > 0 ? "YES" : "NO";
    }
	
/*	
	  // 방 내놓기
    @PostMapping("/addroom")  // 다중 mapping
    public String addroom(RoomDto dto, RoomOptionDto optionDto) {
    	
        System.out.println("addroom 컨트롤러 도착");
        int number = 0;
        System.out.println(dto.toString());

        number = roomService.addRoom(dto, optionDto);
        System.out.println(number);

        return number == 1 ? "YES" : "NO";
    }

    @GetMapping("/getRoomList")
    public List<RoomDto> getRoomList() {
        return roomService.getRoomList();
    }
*/

}
