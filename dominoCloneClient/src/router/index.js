import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'
import TestSY from '@/components/TestSY'
import TestDS from '@/components/TestDS'
import LoginView from '@/components/LoginView'
import SearchAccnt from '@/components/SearchAccnt'
import RegStep2 from '../components/RegStep2'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/TestSY',
      name: 'TestSY',
      component: TestSY
    },
    {
      path: '/TestDS',
      name: 'TestDS',
      component: TestDS
    },
    {
      path: '/global/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/member/findIdPw',
      name: 'srchid',
      component: SearchAccnt
    },
    {
      path: '/member/regStep2',
      name: 'regStep2',
      component: RegStep2
    }
  ]
})
