package bit.com.a.room;

import java.io.Serializable;
import java.time.LocalDateTime;


public class RoomDto  implements Serializable {

    private int id;

    private String title;

    private String content;

    private String addressDetail;       // 상세주소 기본주소는 DONG_ID

    private String roomType;

    private String roomCount;

	private String deposit;
	
	private String lease;
    
    private String supplySpace;

    private String roomSpace;

    private String moveDay;			// private Timestamp moveDay;  <- DB에서 타입 DATETIME일 때

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

    
   //디폴트 생성자 
	public RoomDto() {

	}

	
																				// Timestamp
	public RoomDto(int id, String title, String content, String addressDetail, String roomType, String roomCount,
			String deposit, String lease, String supplySpace, String roomSpace, String moveDay, String paymentType, String floor,
			String monthRent, int readcount, int wishcount, int del, int dONGId, int bROKERId, String createdAt,
			String createdBy, String updatedAt, String updatedBy, String deletedAt, String deletedBy) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.addressDetail = addressDetail;
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
		DONGId = dONGId;
		BROKERId = bROKERId;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.deletedAt = deletedAt;
		this.deletedBy = deletedBy;
	}



	@Override
	public String toString() {
		return "RoomDto [id=" + id + ", title=" + title + ", content=" + content + ", addressDetail=" + addressDetail
				+ ", roomType=" + roomType + ", roomCount=" + roomCount + ", deposit=" + deposit + ", lease=" + lease + ", supplySpace="
				+ supplySpace + ", roomSpace=" + roomSpace + ", moveDay=" + moveDay + ", paymentType=" + paymentType
				+ ", floor=" + floor + ", monthRent=" + monthRent + ", readcount=" + readcount + ", wishcount="
				+ wishcount + ", del=" + del + ", DONGId=" + DONGId + ", BROKERId=" + BROKERId + ", createdAt="
				+ createdAt + ", createdBy=" + createdBy + ", updatedAt=" + updatedAt + ", updatedBy=" + updatedBy
				+ ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy + "]";
	}



	public String getSupplySpace() {
		return supplySpace;
	}



	public void setSupplySpace(String supplySpace) {
		this.supplySpace = supplySpace;
	}



	public RoomDto(String deposit) {
		super();
		this.deposit = deposit;
	}

	public RoomDto(int id, String deposit) {
		super();
		this.id = id;
		this.deposit = deposit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomCount() {
		return roomCount;
	}

	public void setRoomCount(String roomCount) {
		this.roomCount = roomCount;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getRoomSpace() {
		return roomSpace;
	}

	public void setRoomSpace(String roomSpace) {
		this.roomSpace = roomSpace;
	}

			// Timestamp
	public String getMoveDay() {
		return moveDay;
	}

						// Timestamp
	public void setMoveDay(String moveDay) {
		this.moveDay = moveDay;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getMonthRent() {
		return monthRent;
	}

	public void setMonthRent(String monthRent) {
		this.monthRent = monthRent;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getWishcount() {
		return wishcount;
	}

	public void setWishcount(int wishcount) {
		this.wishcount = wishcount;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getDONGId() {
		return DONGId;
	}

	public void setDONGId(int dONGId) {
		DONGId = dONGId;
	}

	public int getBROKERId() {
		return BROKERId;
	}

	public void setBROKERId(int bROKERId) {
		BROKERId = bROKERId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(String deletedBy) {
		this.deletedBy = deletedBy;
	}

	public String getLease() {
		return lease;
	}

	public void setLease(String lease) {
		this.lease = lease;
	}

}
