package bit.com.a.search;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import bit.com.a.dummyData.DongDto;
import bit.com.a.dummyData.GuDto;
import bit.com.a.dummyData.SiDto;

@Mapper
@Repository
public interface SearchDao {
    public List<DongDto> getDong(@Param("swLat") Double swLat, @Param("swLng") Double swLng, @Param("neLat") Double neLat, @Param("neLng") Double neLng);

    public List<GuDto> getGu(@Param("swLat") Double swLat, @Param("swLng") Double swLng, @Param("neLat") Double neLat, @Param("neLng") Double neLng);

    public List<SiDto> getSi(@Param("swLat") Double swLat, @Param("swLng") Double swLng, @Param("neLat") Double neLat, @Param("neLng") Double neLng);

    public List<SGDDto> getRoomList(@Param("keyword") String keyword);
}