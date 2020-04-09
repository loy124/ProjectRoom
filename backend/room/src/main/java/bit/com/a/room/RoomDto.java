package bit.com.a.room;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class RoomDto implements Serializable {

	private int id;

	private String title;

	private String content;

	private String addressDetail; // 상세주소 기본주소는 DONG_ID

	private String addressDetailZibun;

	private String roomType;

	private String roomCount;

	private String deposit;

	private String lease;

	private String supplySpace;

	private String roomSpace;

	private String moveDay; // private Timestamp moveDay; <- DB에서 타입 DATETIME일 때

	private String paymentType;

	private String floor;

	private String monthRent;

	private int readcount;

	private int wishcount;

	private int del;

	private int DONGId;

	private int BROKERId;

	private String createdAt;

	private String createdBy;

	private String updatedAt;

	private String updatedBy;

	private String deletedAt;

	private String deletedBy;

	private RoomOptionDto roomOptionDto;

	private List<RoomPictureDto> roomPictureDtoList;

	// 디폴트 생성자
	public RoomDto() {

	}

	@Override
	public String toString() {
		return "{" + " id='" + id + "'" + ", title='" + title + "'" + ", content='" + content + "'" + ", addressDetail='"
				+ addressDetail + "'" + ", addressDetailZibun='" + addressDetailZibun + "'" + ", roomType='" + roomType + "'"
				+ ", roomCount='" + roomCount + "'" + ", deposit='" + deposit + "'" + ", lease='" + lease + "'"
				+ ", supplySpace='" + supplySpace + "'" + ", roomSpace='" + roomSpace + "'" + ", moveDay='" + moveDay + "'"
				+ ", paymentType='" + paymentType + "'" + ", floor='" + floor + "'" + ", monthRent='" + monthRent + "'"
				+ ", readcount='" + readcount + "'" + ", wishcount='" + wishcount + "'" + ", del='" + del + "'" + ", DONGId='"
				+ DONGId + "'" + ", BROKERId='" + BROKERId + "'" + ", createdAt='" + createdAt + "'" + ", createdBy='"
				+ createdBy + "'" + ", updatedAt='" + updatedAt + "'" + ", updatedBy='" + updatedBy + "'" + ", deletedAt='"
				+ deletedAt + "'" + ", deletedBy='" + deletedBy + "'" + "}";
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getAddressDetailZibun() {
		return this.addressDetailZibun;
	}

	public void setAddressDetailZibun(String addressDetailZibun) {
		this.addressDetailZibun = addressDetailZibun;
	}

	public String getRoomType() {
		return this.roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomCount() {
		return this.roomCount;
	}

	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}

	public String getDeposit() {
		return this.deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getLease() {
		return this.lease;
	}

	public void setLease(String lease) {
		this.lease = lease;
	}

	public String getSupplySpace() {
		return this.supplySpace;
	}

	public void setSupplySpace(String supplySpace) {
		this.supplySpace = supplySpace;
	}

	public String getRoomSpace() {
		return this.roomSpace;
	}

	public void setRoomSpace(String roomSpace) {
		this.roomSpace = roomSpace;
	}

	public String getMoveDay() {
		return this.moveDay;
	}

	public void setMoveDay(String moveDay) {
		this.moveDay = moveDay;
	}

	public String getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getFloor() {
		return this.floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getMonthRent() {
		return this.monthRent;
	}

	public void setMonthRent(String monthRent) {
		this.monthRent = monthRent;
	}

	public int getReadcount() {
		return this.readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getWishcount() {
		return this.wishcount;
	}

	public void setWishcount(int wishcount) {
		this.wishcount = wishcount;
	}

	public int getDel() {
		return this.del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getDONGId() {
		return this.DONGId;
	}

	public void setDONGId(int DONGId) {
		this.DONGId = DONGId;
	}

	public int getBROKERId() {
		return this.BROKERId;
	}

	public void setBROKERId(int BROKERId) {
		this.BROKERId = BROKERId;
	}

	public String getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeletedBy() {
		return this.deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public RoomOptionDto getRoomOptionDto() {
		return this.roomOptionDto;
	}

	public void setRoomOptionDto(RoomOptionDto roomOptionDto) {
		this.roomOptionDto = roomOptionDto;
	}

	public List<RoomPictureDto> getRoomPictureDtoList() {
		return this.roomPictureDtoList;
	}

	public void setRoomPictureDtoList(List<RoomPictureDto> roomPictureDtoList) {
		this.roomPictureDtoList = roomPictureDtoList;
	}

	public RoomDto(int id, String title, String content, String addressDetail, String addressDetailZibun, String roomType,
			String roomCount, String deposit, String lease, String supplySpace, String roomSpace, String moveDay,
			String paymentType, String floor, String monthRent, int readcount, int wishcount, int del, int DONGId,
			int BROKERId, String createdAt, String createdBy, String updatedAt, String updatedBy, String deletedAt,
			String deletedBy) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.addressDetail = addressDetail;
		this.addressDetailZibun = addressDetailZibun;
		this.roomType = roomType;
		this.roomCount = roomCount;
		this.deposit = deposit;
		this.lease = lease;
		this.supplySpace = supplySpace;
		this.roomSpace = roomSpace;
		this.moveDay = moveDay;
		this.paymentType = paymentType;
		this.floor = floor;
		this.monthRent = monthRent;
		this.readcount = readcount;
		this.wishcount = wishcount;
		this.del = del;
		this.DONGId = DONGId;
		this.BROKERId = BROKERId;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.deletedAt = deletedAt;
		this.deletedBy = deletedBy;
	}

	// Timestamp

}
