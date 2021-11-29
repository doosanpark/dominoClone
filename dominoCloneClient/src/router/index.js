import Vue from 'vue'
import Router from 'vue-router'

import HelloWorld from '@/components/HelloWorld'
import TestSY from '@/components/TestSY'
import TestDS from '@/components/TestDS'

Vue.use(Router)

export default new Router({
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
    }
  ]
})
