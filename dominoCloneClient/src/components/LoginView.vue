<!-- eslint-disable -->
<template>
  <div id="view">
    <div id="login_container">
      <div class="header" style="width:100%">
        <h3>로그인</h3>
        <hr/>
      </div>
      <div class="login_form">
        <b-tabs content-class="mt-3">
          <b-tab title="회원로그인" active>

            <!-- Using props -->
            <b-input-group>
              <b-form-input id="accnt" ref="accnt" placeholder="아이디"></b-form-input>
            </b-input-group>

            <b-input-group>
              <b-form-input id="pass" ref="pass" placeholder="비밀번호"></b-form-input>
            </b-input-group>

            <div class="chk_item">
              <span>
                <input type="checkbox" aria-label="Checkbox for following text input">
                아이디 저장
              </span>
              <span>
                <span>아이디 찾기</span>
                <span>|</span>
                <span>비밀번호 찾기</span>
              </span>
              
            </div>
            <div>
              <b-button v-on:click="postData" variant="danger">로그인</b-button>
            </div>
            <div>
              <b-button variant="outline-primary">회원가입</b-button>
            </div>
          </b-tab>
          <b-tab title="비회원 주문"><p>I'm the second tab</p></b-tab>
        </b-tabs>
      </div>
       
    </div>
  </div>
</template>

<script>
/* eslint-disable */
import axios from "axios"
import $ from 'jquery';

export default {
  name: 'LoginView',
  data() {
    return {
      dismissSecs: 10,
      dismissCountDown: 0,
      showDismissibleAlert: false
    }
  },
  methods: {
    postData() {
      // let paramMap = {}; 
      // paramMap.acnnt = $("#accnt").val(); 
      // paramMap.pass = $("#pass").val(); 

      // console.log("accnt click evnt", this.$refs.accnt);
      // console.log("pass click evnt", this.$refs.pass);

      // axios를 이용하여 post 방식으로 보낼 경우 FormData()형식으로 보내야 함
      // 그렇지 않으면 spring에서 빈 데이터를 받음
      const formData = new FormData();
      formData.append('accnt', $("#accnt").val());
      formData.append('pass', $("#pass").val());

      axios.post(
        "http://localhost:8080/checkaccnt"
        , formData
      )
      .then(response => {
        this.resp = response;
        console.log(response);
      })
      .catch(e => {
        console.error(e);
      });
    }
  }
}
</script>
<style>
  #view {
    display: flex;
    justify-content: center;
    margin: 50px;
  }
  #login_container{
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 1000px;
  }
  .login_form{
    width: 500px;
  }
  .header{
    text-align: left;
  }
  .input-group{
    margin: 20px 0;
  }
  .chk_item{
    display: flex;
    justify-content: space-between;
  }
  div{
    margin: 20px 0;
  }
  button{
    width: 100%;
  }
  
</style>