package bit.com.a.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GalleryController
 */
@RestController
@RequestMapping("/api/gallery")
public class GalleryController {

  @Autowired
  private GalleryService galleryService;

  @PostMapping("/upload")
  public String upload(GalleryDto galleryDto) {
    System.out.println(galleryDto.toString());
    return galleryService.upload(galleryDto) > 0 ? "OK" : "FAIL";
  }

}
