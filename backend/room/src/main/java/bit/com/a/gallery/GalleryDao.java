package bit.com.a.gallery;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface GalleryDao {
  public int upload(GalleryDto galleryDto);

}