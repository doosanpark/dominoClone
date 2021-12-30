<template>
  <div class="col-md-12">
    <div class="card card-container">
      <img
        id="profile-img"
        src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
        class="profile-img-card"
      />
      <form name="form" @submit.prevent="handleRegister">
        <div v-if="!successful">
          <div class="form-group">
            <label for="userid">사용자 ID</label>
            <input
              type="text"
              class="form-control"
              name="userid"
              id="userid"
              v-model="user.id.userId"
            />
            <div
              class="alert-danger"
              v-if="submitted"
            >{{errors.first('userid')}}</div>
          </div>
          <div class="form-group">
            <label for="email">이메일</label>
            <input
              type="email"
              class="form-control"
              name="email"
              id="email"
              v-model="user.id.userEmail"
            />
            <div
              class="alert-danger"
              v-if="submitted"
            >{{errors.first('email')}}</div>
          </div>
          <div class="form-group">
            <label for="password">비밀번호</label>
            <input
              type="password"
              class="form-control"
              name="password"
              id="password"
              v-model="user.userPassword"
            />
            <div
              class="alert-danger"
              v-if="submitted"
            >{{errors.first('password')}}</div>
          </div>
          <div class="form-group">
            <label for="phone">전화번호</label>
            <input
              type="text"
              class="form-control"
              name="phone"
              id="phone"
              v-model="user.phoneNumber"
            />
            <div
              class="alert-danger"
              v-if="submitted"
            >{{errors.first('phone')}}</div>
          </div>
          <div class="form-group mt-3">
            <button class="btn btn-primary btn-block">회원가입</button>
          </div>
        </div>
      </form>

      <div
        class="alert"
        :class="successful ? 'alert-success' : 'alert-danger'"
        v-if="message"
      >{{message}}</div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'TestSY',
  computed: {
    // loggedIn () {
    //   return this.$store.state.auth.status.loggedIn
    // }
  },
  data () {
    return {
      user: {
        'id': {
          'userId': '',
          'userEmail': ''
        },
        'userPassword': '',
        'phoneNumber': '',
        'address': '서울시',
        'zipCode': '04026',
        'accntCertiYn': '',
        'accntAvailPriod': '3',
        'birthInfo': '',
        'agreeCllctPrivtInfoYn': '',
        'userLevel': '',
        'exPwd': null,
        'lastChgdDtm': null,
        'modId': null,
        'regId': null,
        'cashRcptYn': 'Y',
        'cashRcpt': null,
        'cashRcptInfo': null
      },
      submitted: false,
      successful: false,
      message: ''
    }
  },
  mounted () {
    // if (this.loggedIn) {
    //   this.$router.push('/')
    // }
  },
  methods: {
    handleRegister () {
      this.message = ''
      this.submitted = true
      console.log(this.user)
      axios.post(
        'http://localhost:8080/api/v1/join/insert'
        , this.user
      )
        .then(response => {
          this.resp = response
          console.log(response)
        })
        .catch(e => {
          console.error(e)
        })
    }
  }
}
</script>

<style scoped>
label {
  display: block;
  margin-top: 10px;
}

.card-container.card {
  max-width: 350px !important;
  padding: 40px 40px;
}

.card {
  background-color: #f7f7f7;
  padding: 20px 25px 30px;
  margin: 0 auto 25px;
  margin-top: 50px;
  -moz-border-radius: 2px;
  -webkit-border-radius: 2px;
  border-radius: 2px;
  -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
  width: 96px;
  height: 96px;
  margin: 0 auto 10px;
  display: block;
  -moz-border-radius: 50%;
  -webkit-border-radius: 50%;
  border-radius: 50%;
}
</style>
