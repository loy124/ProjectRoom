<template>
  <div class="profile-container">
    <div class="image-upload-wrapper">
      <div class="filebox">
        <div class="image-profile">
          <img src="../../assets/clock.png" />
        </div>
        <label for="file">프로필 사진 변경</label>
        <input type="file" id="file" ref="profile" @change="profileUpload" />
      </div>
    </div>

    <div class="profile-information-wrapper">
      <div class="profile-wrapper">
        <div class="profile-title">본인성명</div>
        <div>
          <input class="profile-input" />
        </div>
      </div>
      <div class="profile-wrapper">
        <div class="profile-title">이메일 주소</div>
        <div>
          <input class="profile-input" />
        </div>
      </div>
      <div class="profile-wrapper">
        <div class="profile-title">휴대폰 번호</div>
        <div>
          <input class="profile-input-phone" />
          <span class="profile-phone-divider">-</span>
          <input class="profile-input-phone" />
          <span class="profile-phone-divider">-</span>
          <input class="profile-input-phone" />
        </div>
      </div>
    </div>
    <div class="profile-button-container">
      <div class="profile-button-wrapper">
        <button class="profile-cancel-button">취소</button>
        <button class="profile-apply-button">확인</button>
      </div>
      <button class="secession-button">회원탈퇴</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      profile: ""
    };
  },
  methods: {
    profileUpload() {
      console.log(this.$refs.profile.files[0]);
      this.profile = this.$refs.profile.files[0];
    }
  }
};
</script>

<style>
.profile-container {
  margin: 0 auto;
  width: 850px;
}

.image-profile {
  margin: 0 auto 12px auto;
  width: 76px;
  height: 76px;
  border-radius: 50%;
  background-color: beige;
  border: 1px solid #dddddd;
}

.image-profile > img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
}

.profile-information-wrapper {
  margin-top: 20px;
  padding: 50px 0;
  border-top: 1px solid #dddddd;
  border-bottom: 1px solid #dddddd;
}
.profile-wrapper:not(:last-child) {
  margin-bottom: 30px;
}

.profile-title {
  margin-left: 200px;
  margin-bottom: 8px;
  color: #222222;
  text-align: left;
  font-size: 14px;
}
.profile-input {
  padding-left: 15px;
  margin-left: 200px;
  width: 450px;
  height: 44px;
}
.profile-input-phone:first-child {
  margin-left: 200px;
}

.profile-input-phone {
  width: 140px;
  height: 44px;
  padding: 10px;
  text-align: center;
}
.profile-phone-divider {
  display: inline-block;
  color: #666666;
  font-size: 14px;
  margin: 0 5px;
}
.profile-button-container {
  margin-top: 50px;
  text-align: center;
  color: #222222;
}

.profile-button-wrapper {
  display: flex;
  justify-content: center;
}

.profile-cancel-button {
  border: none;
  border: 1px solid #dddddd;
  width: 218px;
  height: 50px;
  font-size: 15px;
}
.profile-apply-button {
  margin-left: 20px;
  border: none;
  border: 1px solid #dddddd;
  width: 218px;
  height: 50px;
  color: #fff;
  background-color: #1564f9;
  font-size: 15px;
}

.secession-button {
  border: none;
  margin-top: 50px;
  font-size: 14px;
  color: #666666;
  text-decoration: underline;
  padding-bottom: 80px;
}

.filebox {
  margin-top: 60px;
  padding-bottom: 20px;
  text-align: center;
}

.filebox input[type="file"] {
  position: absolute;
  width: 0;
  height: 0;
  padding: 0;
  overflow: hidden;
  border: 0;
}

.filebox label {
  display: inline-block;
  padding: 10px 20px;
  color: #1564f9;
  vertical-align: middle;
  font-size: 15px;
  cursor: pointer;
  border-radius: 5px;
}
</style>