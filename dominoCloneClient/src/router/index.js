import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'
import TestSY from '@/components/TestSY'
import TestDS from '@/components/TestDS'
import LoginView from '@/components/LoginView'

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
    }
  ]
})
