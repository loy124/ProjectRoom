<template>
  <div>
    <notifications group="notifyApp" position="right right" style="margin-right: 30vh;"></notifications>
    <md-table v-model="users" :table-header-color="tableHeaderColor" style="height: 360px;">
      <md-table-row
        @click="modalClick(item.id, item.del)"
        slot="md-table-row"
        slot-scope="{ item }"
      >
        <md-table-cell md-label="타입">{{item.type}}</md-table-cell>
        <!-- <md-table-cell md-label>{{ item.payment }}</md-table-cell> -->
        <md-table-cell md-label="제목 ">
          <span class="qna-list-depth" v-for=" n in item.depth " :key="n"></span>
          <img v-if="item.depth > 0" src="../../assets/arrow.png" style="width:20px; height:20px;" />
          {{ item.title }}
        </md-table-cell>
        <md-table-cell v-if="item.broker_id" md-label="제목 ">{{ item.broker_id }}</md-table-cell>
        <md-table-cell v-if="item.user_id" md-label="제목 ">{{ item.user_id }}</md-table-cell>
        <md-table-cell v-if="item.admin_id" md-label="제목 ">관리자</md-table-cell>
        <md-table-cell v-if="item.wdate" md-label="작성한 시각">{{ (item.wdate).split(" ")[0] }}</md-table-cell>
      </md-table-row>
    </md-table>

    <b-modal v-model="modalShow" id="modal-1" title>
      <div slot="modal-header" class="modal-header-wrapper">
        <div class="modal-header-title">
          <b-form-input
            style="background-color:#fff;"
            v-model="title"
            disabled="!modalUpdate"
            placeholder="Enter your name"
          ></b-form-input>
        </div>

        <div class="modal-header-body">
          <b-form-textarea
            style="background-color:#fff;"
            id="textarea"
            v-model="content"
            placeholder="내용을 입력하세요"
            rows="14"
            no-resize
            disabled="!modalUpdate"
          ></b-form-textarea>
        </div>
      </div>
      <!-- <div slot="modal-title" class="modal-title-wrapper">{{title}}</div> -->
      <!-- <p class="my-4">Hello from modal!</p> -->
      <div slot="modal-footer" style="display:flex; aligin-item:center;">
        <div class="modal-footer-button-wrapper">
          <b-button variant="outline-success">수정하기</b-button>
        </div>
        <div class="modal-footer-button-wrapper">
          <b-button variant="success">답글달기</b-button>
        </div>
        <div class="modal-footer-button-wrapper">
          <b-button variant="danger">삭제하기</b-button>
        </div>
      </div>
    </b-modal>
    <!-- per page 보여주는 갯수 -->
    <div class="user-search-container">
      <b-pagination v-model="currentPage" :per-page="5" :total-rows="userCount" @input="pageClick"></b-pagination>
      <div class="user-search-input-wrapper">
        <b-form-input
          v-model="s_keyword"
          placeholder="Enter your name"
          style="width:200px;"
          @input="getUserList"
        ></b-form-input>
        <b-button variant="success" @click="getUserList">검색</b-button>
      </div>
    </div>
  </div>
</template>

<script>
import { request, requestParams } from "../../util/axios";
import { error } from "../../util/notification";
export default {
  name: "simple-table",
  props: {
    tableHeaderColor: {
      type: String,
      default: ""
    }
  },
  data() {
    return {
      modalShow: false,
      selected: [],
      perPage: 3,
      currentPage: 1,
      search: "",
      s_category: "",
      s_keyword: "",
      userCount: "",
      detailData: "",
      title: "",
      content: "",
      type: "",
      modalUpdate: false,
      users: [
        {
          name: "Dakota Rice",
          salary: "$36,738",
          country: "Niger",
          city: "Oud-Turnhout"
        },
        {
          name: "Minerva Hooper",
          salary: "$23,738",
          country: "Curaçao",
          city: "Sinaai-Waas"
        },
        {
          name: "Sage Rodriguez",
          salary: "$56,142",
          country: "Netherlands",
          city: "Overland Park"
        },
        {
          name: "Philip Chaney",
          salary: "$38,735",
          country: "Korea, South",
          city: "Gloucester"
        },
        {
          name: "Doris Greene",
          salary: "$63,542",
          country: "Malawi",
          city: "Feldkirchen in Kārnten"
        },
        {
          name: "Mason Porter",
          salary: "$78,615",
          country: "Chile",
          city: "Gloucester"
        }
      ]
    };
  },
  mounted() {
    this.getUserList();
  },
  computed: {
    // rows() {
    //   return this.items.length;
    // },
  },
  methods: {
    getUserList() {
      requestParams("get", "qna/getQnACount/", {
        s_category: "name",
        s_keyword: this.s_keyword
      }).then(res => {
        //유저의 수가 리턴된다
        this.userCount = res;
        console.log(res);
        let params = new URLSearchParams();
        params.append("s_category", "user");
        requestParams("get", "qna/getQnAList/", {
          s_category: "name",
          s_keyword: this.s_keyword,
          start: (this.currentPage - 1) * 5
        }).then(res => {
          console.log(res);
          this.users = res;
        });
      });
    },
    pageClick() {
      this.getUserList();
    },
    deleteUser(id, userId) {
      console.log(id);
      let confirmId = confirm(`${userId} 해당 회원을 탈퇴처리 하시겠습니까?`);
      console.log(confirmId);
      if (confirmId) {
        requestParams("get", "admin/userForcedDeletion", {
          id: id
        });
        this.getUserList();
      }
      // error("비밀번호를 입력해주세요", this);
    },
    modalClick(id, del) {
      console.log(id);
      if (del > 0) return;

      requestParams("get", "qna/getQnA", {
        id: id
      }).then(res => {
        this.detailData = res;
        this.title = res.title;
        this.content = res.content;
        this.type = res.type;
        console.log(res);
        this.modalShow = !this.modalShow;
      });
    }
  }
};
</script>
<style>
.page-item.active .page-link {
  background-color: #4da851 !important;
  border-color: #4da851 !important;
  color: #fff !important;
}
.page-link {
  color: #4da851 !important;
}
.user-search-container {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.user-search-input-wrapper {
  display: flex;
}
.user-search-input-wrapper > * {
  margin-left: 10px;
}
.user-delete-button {
}

.qna-list-depth {
  margin-left: 15px;
}
.modal-footer-button-wrapper {
  margin-left: 10px;
}
.modal-header-title {
  width: 100%;
  text-align: center;
  margin-top: 20px;
}
.modal-header-wrapper {
  width: 100%;
  font-size: 20px;
}
.modal-header-body {
  margin-top: 40px;
  font-size: 24px;
}
</style>
