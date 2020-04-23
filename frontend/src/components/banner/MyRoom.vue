<template>
  <div>
    <KeepRoom v-if="roomLists" :roomLists="roomLists" />
  </div>
</template>

<script>
import KeepRoom from "./KeepRoom";
import { mapState } from "vuex";
import { request } from "../../util/axios";
export default {
  components: {
    KeepRoom
  },
  data() {
    return {
      roomLists: ""
    };
  },
  computed: {
    ...mapState(["loginData"])
  },
  mounted() {
    this.getBrokerInformation();
  },
  methods: {
    getBrokerInformation() {
      let params = new URLSearchParams();
      params.append("id", this.loginData.id);
      request("post", "broker/getInformation", params).then(res => {
        console.log(res);
        // this.brokerData = res;
        // console.log(res.room_list);
        this.roomLists = res.room_list;
        console.log(this.roomLists);
        // this.reviewLists = res.review_list;
        // console.log(this.reviewLists);
      });
    }
  }
};
</script>

<style>
</style>