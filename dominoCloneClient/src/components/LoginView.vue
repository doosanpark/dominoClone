<!-- eslint-disable -->
<template>
  <div id="view">
    <div id="login_container">
      <h3>로그인</h3>
      <div>
        <b-tabs content-class="mt-3">
          <b-tab title="회원로그인" active>

            <!-- Using props -->
            <b-input-group>
              <b-form-input placeholder="아이디"></b-form-input>
            </b-input-group>
            
            <b-input-group>
              <b-form-input placeholder="비밀번호"></b-form-input>
            </b-input-group>

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
    text-align: left;
    width: 1000px;
  }
</style>