package bit.com.a.gallery;

import java.io.IOException;
<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
>>>>>>> 3d021aaa15637090eaa745c486f815a17cc7f7b5
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
<<<<<<< HEAD
    galleryDto.setFilePath("https://" + "dixo0q5vi6g16.cloudfront.net" + "/" + imgPath);
=======
    galleryDto.setFilePath(imgPath);
>>>>>>> 3d021aaa15637090eaa745c486f815a17cc7f7b5

    return galleryService.upload(galleryDto) > 0 ? "OK" : "FAIL";
  }

<<<<<<< HEAD
  @GetMapping("/getImageList")
  public List<GalleryDto> getImageList() {
    return galleryService.getImageList();
  }

=======
>>>>>>> 3d021aaa15637090eaa745c486f815a17cc7f7b5
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
