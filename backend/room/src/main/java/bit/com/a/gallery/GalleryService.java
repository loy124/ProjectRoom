package bit.com.a.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * GalleryService
 */
@Service
@Transactional
public class GalleryService {

  @Autowired
  GalleryDao galleryDao;

  public int upload(GalleryDto galleryDto) {
    System.out.println("dao");
    System.out.println(galleryDto.toString());
    return galleryDao.upload(galleryDto);
  }

}