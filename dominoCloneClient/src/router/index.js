import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'
import TestSY from '@/components/TestSY'
import TestDS from '@/components/TestDS'
import LoginView from '@/components/LoginView'
import RegStep2 from "../components/RegStep2";

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
      path: '/accnt/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/member/regStep2',
      name: 'regStep2',
      component: RegStep2
    }
  ]
})
