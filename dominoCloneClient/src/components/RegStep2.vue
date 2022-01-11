<template>
  <div class="container myInfo">
    <form name="form" @submit.prevent="handleRegister">
      <dl>
        <dt class="center">이름</dt>
        <dd>
          <div class="form-item name">
            <input type="text" placeholder="" id="name" name="name">
          </div>
        </dd>
      </dl>
      <dl>
        <dt class="top">아이디</dt>
        <dd>
          <div class="form-item name">
            <input type="text" name="id" id="id" maxlength="16" v-model="user.userId">
            <a href="javascript:idCheck($('#id'));" class="btn btn-dark">중복확인</a>
          </div>
          <div class="text-type4" id="id_alert" style="display:none;"></div>
        </dd>

      </dl>
      <dl>
        <dt class="top">비밀번호</dt>
        <dd class="mb">
          <div class="form-item number">
            <input type="password" name="passwd" id="passwd" maxlength="16" placeholder="8~16자 영문대소문자,숫자, 특수문자 사용가능" ref="passwd">
          </div>
          <div class="text-type4" id="passwd_alert" style="display:none;"></div>
        </dd>
        <dt class="top">비밀번호 확인</dt>
        <dd>
          <div class="form-item number">
            <input type="password" name="confirmpw" id="confirmpw" maxlength="16" v-model="user.userPassword" ref="confirmpw">
          </div>
          <div class="text-type4" id="confirmpw_alert" style="display:none;"></div>
        </dd>
      </dl>
      <dl>
        <dt class="center">생년월일</dt>
        <dd>
          <div class="form-group v2">
            <div class="form-item birth">
              <input type="radio" name="birth_fl" id="birth_s" value="S" checked="checked" class="form-check-input">
              <label class="checkbox" for="birth_s"></label>
              <label for="birth_s">양력</label>
              <input type="radio" name="birth_fl" id="birth_m" value="M" class="form-check-input">
              <label class="checkbox" for="birth_m"></label>
              <label for="birth_m">음력</label>
              <select name="byear" id="byear" class="selected" ref="byear">
                <option value="">년</option>
                <option value="2022">2022</option>
                <option value="2021">2021</option>
                <option value="2020">2020</option>
                <option value="2019">2019</option>
                <option value="2018">2018</option>
                <option value="2017">2017</option>
                <option value="2016">2016</option>
                <option value="2015">2015</option>
                <option value="2014">2014</option>
                <option value="2013">2013</option>
                <option value="2012">2012</option>
                <option value="2011">2011</option>
                <option value="2010">2010</option>
                <option value="2009">2009</option>
                <option value="2008">2008</option>
                <option value="2007">2007</option>
                <option value="2006">2006</option>
                <option value="2005">2005</option>
                <option value="2004">2004</option>
                <option value="2003">2003</option>
                <option value="2002">2002</option>
                <option value="2001">2001</option>
                <option value="2000">2000</option>
                <option value="1999">1999</option>
                <option value="1998">1998</option>
                <option value="1997">1997</option>
                <option value="1996">1996</option>
                <option value="1995">1995</option>
                <option value="1994">1994</option>
                <option value="1993">1993</option>
                <option value="1992">1992</option>
                <option value="1991">1991</option>
                <option value="1990">1990</option>
                <option value="1989">1989</option>
                <option value="1988">1988</option>
                <option value="1987">1987</option>
                <option value="1986">1986</option>
                <option value="1985">1985</option>
                <option value="1984">1984</option>
                <option value="1983">1983</option>
                <option value="1982">1982</option>
                <option value="1981">1981</option>
                <option value="1980">1980</option>
                <option value="1979">1979</option>
                <option value="1978">1978</option>
                <option value="1977">1977</option>
                <option value="1976">1976</option>
                <option value="1975">1975</option>
                <option value="1974">1974</option>
                <option value="1973">1973</option>
                <option value="1972">1972</option>
                <option value="1971">1971</option>
                <option value="1970">1970</option>
                <option value="1969">1969</option>
                <option value="1968">1968</option>
                <option value="1967">1967</option>
                <option value="1966">1966</option>
                <option value="1965">1965</option>
                <option value="1964">1964</option>
                <option value="1963">1963</option>
                <option value="1962">1962</option>
                <option value="1961">1961</option>
                <option value="1960">1960</option>
                <option value="1959">1959</option>
                <option value="1958">1958</option>
                <option value="1957">1957</option>
                <option value="1956">1956</option>
                <option value="1955">1955</option>
                <option value="1954">1954</option>
                <option value="1953">1953</option>
                <option value="1952">1952</option>
                <option value="1951">1951</option>
                <option value="1950">1950</option>
                <option value="1949">1949</option>
                <option value="1948">1948</option>
                <option value="1947">1947</option>
                <option value="1946">1946</option>
                <option value="1945">1945</option>
                <option value="1944">1944</option>
                <option value="1943">1943</option>
                <option value="1942">1942</option>
                <option value="1941">1941</option>
                <option value="1940">1940</option>
                <option value="1939">1939</option>
                <option value="1938">1938</option>
                <option value="1937">1937</option>
                <option value="1936">1936</option>
                <option value="1935">1935</option>
                <option value="1934">1934</option>
                <option value="1933">1933</option>
                <option value="1932">1932</option>
                <option value="1931">1931</option>
                <option value="1930">1930</option>
                <option value="1929">1929</option>
                <option value="1928">1928</option>
                <option value="1927">1927</option>
                <option value="1926">1926</option>
                <option value="1925">1925</option>
                <option value="1924">1924</option>
                <option value="1923">1923</option>
                <option value="1922">1922</option>
                <option value="1921">1921</option>
                <option value="1920">1920</option>
                <option value="1919">1919</option>
                <option value="1918">1918</option>
                <option value="1917">1917</option>
                <option value="1916">1916</option>
                <option value="1915">1915</option>
                <option value="1914">1914</option>
                <option value="1913">1913</option>
                <option value="1912">1912</option>
                <option value="1911">1911</option>
                <option value="1910">1910</option>
                <option value="1909">1909</option>
                <option value="1908">1908</option>
                <option value="1907">1907</option>
                <option value="1906">1906</option>
                <option value="1905">1905</option>
                <option value="1904">1904</option>
                <option value="1903">1903</option>
                <option value="1902">1902</option>
                <option value="1901">1901</option>
                <option value="1900">1900</option>
              </select>
              <select name="bmonth" id="bmonth" class="selected" ref="bmonth">
                <option value="">월</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
              </select>
              <select name="bday" id="bday" class="selected" ref="bday">
                <option value="">일</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
                <option value="11">11</option>
                <option value="12">12</option>
                <option value="13">13</option>
                <option value="14">14</option>
                <option value="15">15</option>
                <option value="16">16</option>
                <option value="17">17</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
                <option value="31">31</option>
              </select>
              <br>
              <div class="text-type4" id="birth_alert" style="display:none;"></div>
            </div>
          </div>

        </dd>
      </dl>

      <dl>
        <dt class="top">휴대전화</dt>
        <dd>
          <div class="form-group v2">
            <div class="form-item">
              <select name="sel_hand_tel1" id="sel_hand_tel1" class="selected" title="휴대전화번호" ref="sel_hand_tel1">
                <option value="010" selected="">010</option>
                <option value="011">011</option>
                <option value="016">016</option>
                <option value="017">017</option>
                <option value="018">018</option>
                <option value="019">019</option>
              </select>
              <input type="text" name="hand_tel2" id="hand_tel2" maxlength="4" class="i_text"
                     v-on:blur="isNumeric" ref="hand_tel2" title="휴대전화번호">
              <input type="text" name="hand_tel3" id="hand_tel3" maxlength="4" class="i_text"
                     v-on:blur="isNumeric" ref="hand_tel3" title="휴대전화번호">
              <a href="javascript:void(0)" class="btn btn-dark">
                인증완료
              </a>
            </div> <!-- //form-item -->
            <div class="text-type4" id="tel_alert" style="display:none;"></div>
          </div>
        </dd>
      </dl>

      <dl>
        <dt class="center">이메일</dt>
        <dd>
          <div class="form-group v2">
            <div class="form-item e-mail">
              <input type="text" name="email1" id="email1" ref="email1">
              <span>@</span>
              <input type="text" name="email2" id="email2" ref="email2">
              <select name="email3" id="email3" v-on:change="setEmailHost" ref="email3">
                <option value="naver.com">네이버</option>
                <option value="hanmail.net">한메일</option>
                <option value="gmail.com">지메일</option>
                <option value="hotmail.com">핫메일</option>
                <option value="nate.com">네이트</option>
                <option value="" selected="">직접입력</option>
              </select>
              <a href="javaScript:doCheckEmail();" class="btn btn-dark">중복확인</a>
            </div>
            <div class="text-type4" id="email_alert" style="display:none;"></div>
          </div>
        </dd>
      </dl>

      <dl>
        <dt>개인정보 유효기간 선택</dt>
        <dd>
          <div class="chk-wrap">
            <div class="chk-box selected">
              <input type="radio" name="info_years" id="info_years1" value="1" checked="checked"
                     class="form-check-input" refs="info_years1" v-model="user.accntAvailPriodLimit">
              <label class="checkbox" for="info_years1"></label>
              <label for="info_years1">1년</label>
              <input type="radio" name="info_years" id="info_years3" value="3" class="form-check-input" v-model="user.accntAvailPriodLimit">
              <label class="checkbox" for="info_years3" ></label>
              <label for="info_years3">3년</label>
              <input type="radio" name="info_years" id="info_years5" value="5" class="form-check-input" v-model="user.accntAvailPriodLimit">
              <label class="checkbox" for="info_years5"></label>
              <label for="info_years5">5년</label>
            </div>
          </div>
          <div class="text-type">
            - 설정하신 기간동안 로그인/주문 등의 서비스 이용이 없을 시, 휴면계정으로 처리되어 각종 이벤트/쿠폰혜택을 받아보실 수 없습니다.
          </div>
        </dd>
      </dl>

      <dl>
        <dt class="center">성별(선택)</dt>
        <dd>
          <div class="form-group v2">
            <div class="form-item gender">
              <div class="chk-wrap">
                <div class="chk-box selected">
                  <input type="radio" name="sex" id="sex_n" value="N" checked="checked" class="form-check-input">
                  <label class="checkbox" for="sex_n"></label>
                  <label for="sex_n">정보제공 안함</label>
                  <input type="radio" name="sex" id="sex_m" value="M" class="form-check-input">
                  <label class="checkbox" for="sex_m"></label>
                  <label for="sex_m">남성</label>
                  <input type="radio" name="sex" id="sex_f" value="F" class="form-check-input">
                  <label class="checkbox" for="sex_f"></label>
                  <label for="sex_f">여성</label>
                </div>
              </div>
              <div class="text-type4" id="gender_alert" style="display:none;"></div>
            </div>
          </div>

        </dd>
      </dl>

      <dl>
        <dt class="top">추천인 아이디</dt>
        <dd>
          <div class="form-item name">
            <input type="text" name="frn_id" id="frn_id" maxlength="20">
            <a href="javascript:frnCheck($('#frn_id'));" class="btn btn-dark">등록확인</a>
          </div>
          <div class="text-type4" id="frn_alert" style="display:none;"></div>
          <div class="text-type">
            - 가입 이후, 수정이 불가합니다.<br>
            - 대소문자 및 띄어쓰기에 유의해주세요.
          </div>
        </dd>
      </dl>
      <dl>
        <dt>약관 및 광고성 정보 수신<br>전체 동의</dt>
        <dd>
          <div class="form agree">
            <div class="chk-box v4">
              <input type="checkbox" id="all3" name="agreeType3" class="all-check-agree form-check-input">
              <label class="checkbox" for="all3"></label>
              <label for="all3">전체 동의하기</label>
            </div>
          </div>
          <div class="text-type">
            - 위 항목에는 필수 및 선택정보에 대한 동의를 모두 포함하고 있으며, 개별적으로도 동의 여부를 선택하실 수 있습니다.<br>
            - 선택항목에 대한 동의를 거부하시는 경우에도 서비스 이용이 가능합니다.<br>
            <span style="color: rgb(255, 20, 60); --darkreader-inline-color:#bf4355;" data-darkreader-inline-color="">이메일, 문자(SMS 등) 모두 수신 동의 시 피자 방문포장 40% 할인 쿠폰을 드립니다.</span>
          </div>
        </dd>
      </dl>
      <dl>
        <dt>약관 전체동의</dt>
        <dd>
          <div class="form agree">
            <div class="chk-box v4">
              <input type="checkbox" id="agree_all" name="agree_chk" value="Y" class="all-check form-check-input" v-on:change="changeChkbox('agree_all')" ref="agree_all">
              <label class="checkbox" for="agree_all"></label>
              <label for="agree_all">전체 동의하기</label>
            </div>
            <ul>
              <li>
                <div class="chk-box v4">
                  <input type="checkbox" name="agree_2" id="agree_2" value="Y" class="form-check-input" ref="agree_2">
                  <label class="checkbox" for="agree_2"></label>
                  <label for="agree_2" class="text-muted">개인정보 수집 및 이용 동의(필수)</label>
                  <a href="javascript:UI.layerPopUp({selId:'#pop-terms-p2'})" class="btn-link text-dark">보기</a>
                </div>
              </li>
              <li>
                <div class="chk-box v4">
                  <input type="checkbox" name="agree_1" id="agree_1" value="Y" class="form-check-input" ref="agree_1">
                  <label class="checkbox" for="agree_1"></label>
                  <label for="agree_1" class="text-muted">이용약관 동의(필수)</label>
                  <a href="javascript:UI.layerPopUp({selId:'#pop-terms'})" class="btn-link text-dark">보기</a>
                </div>
              </li>
              <li>
                <div class="chk-box v4">
                  <input type="checkbox" id="location_yn" name="location_yn" value="Y" class="form-check-input" ref="location_yn">
                  <label class="checkbox" for="location_yn"></label>
                  <label for="location_yn" class="text-muted">위치기반 서비스 약관 동의(필수)</label>
                  <a href="javascript:UI.layerPopUp({selId:'#pop-terms-p4'})" class="btn-link text-dark">보기</a>
                </div>
              </li>
              <!-- <li>
<div class="chk-box v4">
<input type="checkbox" name="agree_3" id="agree_3" value="Y">
<label class="checkbox" for="agree_3"></label>
<label for="agree_3">개인정보 제3자 제공 동의(선택)</label>
<a href="javascript:UI.layerPopUp({selId:'#pop-terms-p3'})" class="btn-link">보기</a>
</div>
</li> -->
            </ul>
          </div>

        </dd>
      </dl>
      <dl>
        <dt>광고성 정보 수신 전체 동의</dt>
        <dd>
          <div class="form agree">
            <div class="chk-box v4">
              <input type="checkbox" id="agree_all2" name="agreeType1" class="all-check form-check-input" v-on:change="changeChkbox('agree_all2')" ref="agree_all2">
              <label class="checkbox" for="agree_all2"></label>
              <label for="agree_all2">전체 동의하기</label>
            </div>
            <ul>
              <li>
                <div class="chk-box v4">
                  <input type="checkbox" id="chk_ds_fl" name="chk_ds_fl" value="Y" class="form-check-input" ref="chk_ds_fl" v-model="this.user.userMarketing.sms">
                  <label class="checkbox" for="chk_ds_fl"></label>
                  <label for="chk_ds_fl" class="text-muted">문자메세지(선택)</label>
                </div>
              </li>
              <li>
                <div class="chk-box v4">
                  <input type="checkbox" id="chk_dm_fl" name="chk_dm_fl" value="Y" class="form-check-input" ref="chk_dm_fl" v-model="this.user.userMarketing.email">
                  <label class="checkbox" for="chk_dm_fl"></label>
                  <label for="chk_dm_fl" class="text-muted">이메일(선택)</label>
                </div>
              </li>
              <li>
                <div class="chk-box v4">
                  <input type="checkbox" id="chk_o_dm_fl" name="chk_o_dm_fl" value="Y" class="form-check-input" ref="chk_o_dm_fl" v-model="this.user.userMarketing.address">
                  <label class="checkbox" for="chk_o_dm_fl"></label>
                  <label for="chk_o_dm_fl" class="text-muted">DM 우편(최근 배달주소로 배송)(선택)</label>
                </div>
              </li>
            </ul>
          </div>

        </dd>
      </dl>
      <button type="submit" class="btn btn-danger btn-lg">
        가입하기
      </button>
    </form>
  </div>
</template>

<script>

import axios from 'axios'
import * as moment from 'moment/moment'
import _ from 'lodash'

export default {
  name: 'RegStep2',
  computed: {
    // loggedIn () {
    //   return this.$store.state.auth.status.loggedIn
    // }
  },
  data () {
    return {
      user: {
        'userId': '',
        'userEmail': '',
        'userPassword': '',
        'phoneNumber': '',
        'address': '',
        'zipCode': '',
        'accntCertiYn': '',
        'accntAvailPriod': '',
        'accntAvailPriodLimit': '1',
        'birthInfo': '',
        'agreeCllctPrivtInfoYn': '',
        'userLevel': '',
        'exPwd': null,
        'lastChgdDtm': null,
        'modId': null,
        'regId': null,
        'cashRcptYn': 'Y',
        'cashRcpt': null,
        'cashRcptInfo': null,
        'userMarketing': {
          'userId': '',
          'email': false,
          'sms': false,
          'address': false
        }
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
    isNumeric (e) {
      const n = e.target.value
      const isNum = !isNaN(parseFloat(n)) && isFinite(n)
      if (!isNum) {
        alert('숫자를 입력해주세요')
        e.target.value = ''
      }
    },
    setEmailHost () {
      this.$refs.email2.value = this.$refs.email3.value
      if (this.$refs.email2.value !== '') {
        this.$refs.email2.disabled = true
      } else {
        this.$refs.email2.disabled = false
      }
    },
    handleRegister () {
      this.message = ''
      this.submitted = true
      if (this.setData()) {
        this.saveData()
      }
    },
    changeChkbox (elName) {
      if (_.isEqual(elName, 'agree_all') && this.$refs.agree_all.checked) {
        this.$refs.agree_2.checked = true
        this.$refs.agree_1.checked = true
        this.$refs.location_yn.checked = true
      } else if (_.isEqual(elName, 'agree_all') && !this.$refs.agree_all.checked) {
        this.$refs.agree_2.checked = false
        this.$refs.agree_1.checked = false
        this.$refs.location_yn.checked = false
      } else if (_.isEqual(elName, 'agree_all2') && this.$refs.agree_all2.checked) {
        this.$refs.chk_ds_fl.checked = true
        this.$refs.chk_dm_fl.checked = true
        this.$refs.chk_o_dm_fl.checked = true
      } else if (_.isEqual(elName, 'agree_all2') && !this.$refs.agree_all2.checked) {
        this.$refs.chk_ds_fl.checked = false
        this.$refs.chk_dm_fl.checked = false
        this.$refs.chk_o_dm_fl.checked = false
      }
    },
    saveData () {
      axios.post(
        'http://localhost:8080/api/v1/join/insert'
        , this.user
      )
        .then(response => {
          this.resp = response
          console.log(response)
          alert('저장이 완료되었습니다.')
        })
        .catch(e => {
          console.error(e)
        })
    },
    setData () {
      if ((this.$refs.passwd.value === '' || this.$refs.passwd.value.length < 8) || this.$refs.passwd.value !== this.$refs.confirmpw.value) {
        alert('비밀번호를 다시 확인해주세요')
        this.$refs.passwd.focus()
        return false
      }
      if (this.$refs.email1.value === '' || this.$refs.email2.value === '') {
        alert('이메일 주소를 입력해주세요')
        return false
      }
      if (this.$refs.byear.value === '' || this.$refs.bmonth.value === '' || this.$refs.bday.value === '') {
        alert('생년월일을 입력해주세요')
        return false
      }
      if (this.$refs.sel_hand_tel1.value === '' || this.$refs.hand_tel2.value === '' || this.$refs.hand_tel3.value === '') {
        alert('휴대전화 번호를 입력해주세요')
        return false
      }
      this.user.phoneNumber = `${this.$refs.sel_hand_tel1.value}${this.$refs.hand_tel2.value}${this.$refs.hand_tel3.value}`
      this.user.userEmail = `${this.$refs.email1.value}@${this.$refs.email2.value}`
      this.user.accntAvailPriod = moment().add(this.user.accntAvailPriodLimit, 'years').toISOString()
      // moment().add(this.user.accntAvailPriodLimit, 'years').format('YYYY-MM-DDTHH:mm:ss.SSS')
      this.user.birthInfo = `${this.$refs.byear.value}-${this.$refs.bmonth.value}-${this.$refs.bday.value}`
      this.user.userMarketing.userId = this.user.userId
      return true
    }
  }
}
</script>

<style scoped>

* {
  vertical-align: baseline;
}

ul {
  list-style-type: none;
}

.myInfo {
  margin-top: 30px;
  margin-bottom: 30px;
}

.myInfo dl dt, .myInfo dl dd {
  display: inline-block;
  font-size: 16px;
  color: #111;
}

.myInfo dl dt {
  width: 250px;
  padding-left: 40px;
  font-weight: 600;
  vertical-align: middle;
  line-height: 1;
  margin-top: 3px;
  text-align: left;
}

.myInfo dl dt.center {
  vertical-align: middle;
  margin-top: 0;
}

input[type="text"], input[type="submit"], input[type="password"], input[type="search"], input[type="number"], input[type="reset"], input[type="email"], input[type="tel"], input[type="search"], input[type="file"], input[type="email"], input[type="tel"], textarea {
  border-radius: 0;
  -webkit-box-shadow: none;
  box-shadow: none;
  -webkit-appearance: none;
  border: 1px solid #ddd;
  height: 42px;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  padding: 0 20px;
  font-size: 15px;
  color: #111;
  letter-spacing: -0.2px;
  font-weight: 500;
  font-family: "Roboto", "Noto", sans-serif;
}

.myInfo dl dd {
  vertical-align: middle;
  width: calc(100% - 300px);
  display: inline-block;
  text-align: left;
}

.join-step2 .myInfo dl dd .form-item.name input, .join-step2 .myInfo dl dd .form-item.confirm input {
  width: 275px;
}

.form-item select, .form-item .type2 select, .company .sel_box select {
  height: 42px;
  padding-left: 20px;
  padding-right: 50px;
  border: 1px solid #ddd;
  color: #888888;
  font-size: 15px;
}
</style>
