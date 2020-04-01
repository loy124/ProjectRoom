package bit.com.a.gallery;

public class GalleryDto {
  private Long id;
  private String title;
  private String filePath;
  private String imgFullPath;

  public GalleryDto() {

  }

  public GalleryDto(Long id, String title, String filePath, String imgFullPath) {
    this.id = id;
    this.title = title;
    this.filePath = filePath;
    this.imgFullPath = imgFullPath;
  }

  @Override
  public String toString() {
    return "{" + " id='" + id + "'" + ", title='" + title + "'" + ", filePath='" + filePath + "'" + ", imgFullPath='"
        + imgFullPath + "'" + "}";
  }

}