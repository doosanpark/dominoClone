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
              <b-form-input placeholder="아이디"></b-form-input>
            </b-input-group>

            <b-input-group>
              <b-form-input placeholder="비밀번호"></b-form-input>
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
              <b-button variant="danger">로그인</b-button>
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
      countDownChanged(dismissCountDown) {
        this.dismissCountDown = dismissCountDown
      },
      showAlert() {
        this.dismissCountDown = this.dismissSecs
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