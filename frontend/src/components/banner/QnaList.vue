<template>
  <div>
    <div class="qna-list-container">
      <div class="qna-write-header-title qna-write-margin">
        <span class="qna-main-title">구해방</span>에 문의해주신 질문에 대한 답변입니다
      </div>
      <el-pagination
        class="profile-payment-table-page qna-list-page"
        background
        layout="prev, pager, next"
        :page-size="3"
        :total="qnaCount"
        :current-page.sync="currentPage"
        @current-change="getList"
      ></el-pagination>
      <div class="qna-list-wrapper" style="border:none; font-weight:bold; ">
        <div class="qna-list-title">문의 유형</div>
        <div class="qna-list-content">제목</div>
        <div class="qna-list-writer">작성자</div>
        <div class="qna-list-date">날짜</div>
      </div>
      <div class="qna-list-wrapper" v-for="(test, index) in tests" :key="index">
        <div class="qna-list-title">{{test.type ? test.type : "내용없음"}}</div>
        <div class="qna-list-content">
          <span class="qna-list-depth" v-for=" n in test.depth " :key="n">
            <!-- 댓글의 여백 -->
          </span>
          <img v-if="test.depth > 0" src="../../assets/arrow.png" width="20px" height="20px" />
          {{test.title}}
        </div>
        <div v-if="test.user_id" class="qna-list-writer">{{test.user_id}}</div>
        <div v-if="test.broker_id" class="qna-list-writer">{{test.broker_id}}</div>
        <div v-if="test.admin_id" class="qna-list-writer">관리자</div>
        <div class="qna-list-date">{{test.wdate}}</div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { requestParams } from "../../util/axios";
import { mapState } from "vuex";
export default {
  data() {
    return {
      // auth: login.auth,
      dataList: [],
      s_category: "sel",
      s_keyword: "",
      currentPage: 1,
      qnaCount: 10,

      options: [
        { text: "선택", value: "sel" },
        { text: "제목", value: "title" },
        { text: "내용", value: "content" },
        { text: "작성자", value: "writer" }
      ],
      tests: []
    };
  },
  computed: {
    ...mapState(["loginData"])
  },
  mounted() {
    //무조건 실행 mounted
    //			alert('mounted');
    this.getList();
  },
  methods: {
    getList: function() {
      if (this.loginData.user_id) {
        requestParams("get", "qna/getQnaUserList", {
          userId: this.loginData.user_id,
          start: (this.currentPage - 1) * 3
        }).then(res => {
          // console.log(res);
          // console.log(res[0].user_cnt);
          // data에 qna_list만 담기
          this.tests = [];
          res.map(data => {
            this.tests = this.tests.concat(data.qna_list);
            // console.log(data.qna_list);
          });
          this.qnaCount = res[0].user_cnt;
          // console.log(this.tests);
        });
      } else {
        requestParams("get", "qna/getQnaBrokerList", {
          brokerId: this.loginData.broker_id,
          start: (this.currentPage - 1) * 3
        }).then(res => {
          // console.log(res[0].broker_cnt);
          // data에 qna_list만 담기
          res.map(data => {
            this.tests = this.tests.concat(data.qna_list);
          });
          this.qnaCount = res[0].broker_cnt;
          // console.log(this.tests);
        });
      }
    }
    // 글쓰기
  }
};
</script>

<style>
.qna-list-container {
  color: #222222;
}
.qna-write-margin {
  margin-bottom: 40px;
}

.qna-list-wrapper {
  display: flex;
  height: 60px;
  align-items: center;
}

.qna-list-wrapper:not(:first-child):hover {
  opacity: 0.5;
  cursor: pointer;
}

.qna-list-title {
  flex: 2;
  font-size: 15px;
  text-align: center;
}
.qna-list-content {
  flex: 5;
  font-size: 18px;
}
.qna-list-writer {
  flex: 1;
  font-size: 15px;
}

.qna-list-date {
  font-size: 15px;
  flex: 2;
  text-align: center;
}
.qna-list-depth {
  margin-left: 15px;
}

.qna-list-wrapper {
  border-top: 1px solid #dddddd;
}
.qna-list-page {
  margin-bottom: 30px;
}
</style>