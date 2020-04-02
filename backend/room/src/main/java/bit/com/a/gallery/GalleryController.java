package bit.com.a.gallery;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.s3.S3Service;

/**
 * GalleryController
 */

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {

  //
  @Autowired
  private GalleryService galleryService;

  @Autowired
  private S3Service s3Service;

  @PostMapping("/upload")
  public String execWrite(GalleryDto galleryDto, MultipartFile file) throws IOException {
    String imgPath = s3Service.upload(file);
    galleryDto.setFilePath(imgPath);

    return galleryService.upload(galleryDto) > 0 ? "OK" : "FAIL";
  }

  // @PostMapping("/upload")
  // public String upload(MultipartFile file) throws IOException {
  // GalleryDto galleryDto = new GalleryDto();
  // galleryDto.setFilePath(file.getOriginalFilename());
  // System.out.println("들어왔나?");
  // System.out.println(galleryDto.toString());
  // String imgPath = s3Service.upload(galleryDto.getFilePath(), file);
  // galleryDto.setFilePath(imgPath);

  // return galleryService.upload(galleryDto) > 0 ? "OK" : "FAIL";
  // }

}
