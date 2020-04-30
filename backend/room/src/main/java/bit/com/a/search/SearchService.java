package bit.com.a.search;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dummyData.DongDto;
import bit.com.a.dummyData.GuDto;
import bit.com.a.dummyData.SiDto;

@Service
public class SearchService {

    @Autowired
    SearchDao searchDao;

    //getDong, getGu, getSi, getMarker 4개가 필요함.
    
    public List<DongDto> getDong(Double swLat, Double swLng, Double neLat, Double neLng) { 
        System.out.println("SearchService , getDong 접근 확인");

        return searchDao.getDong(swLat, swLng, neLat, neLng);
    }
    public List<GuDto> getGu(Double swLat, Double swLng, Double neLat, Double neLng) { 
        System.out.println("SearchService , getGu 접근 확인");

        return searchDao.getGu(swLat, swLng, neLat, neLng);
    }
    public List<SiDto> getSi(Double swLat, Double swLng, Double neLat, Double neLng) { 
        System.out.println("SearchService , getSi 접근 확인");

        return searchDao.getSi(swLat, swLng, neLat, neLng);
    }
    public List<SGDDto> getRoomList(String keyword) { 
        System.out.println("SearchService , getRoomList 접근 확인");

        return searchDao.getRoomList(keyword);
    }
    
}