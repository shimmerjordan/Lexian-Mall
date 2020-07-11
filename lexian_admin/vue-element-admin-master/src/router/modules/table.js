/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const tableRouter = {
  path: '/table',
  component: Layout,
  redirect: '/table/complex-table',
  name: 'Order',
  meta: {
    title: '订单管理',
    icon: 'list'
  },
  children: [
    {
      path: 'complex-table',
      component: () => import('@/views/order/complex-table'),
      name: 'ComplexTable',
      meta: { title: '订单列表' }
    },
    {
      path: 'jiufenOrder',
      component: () => import('@/views/order/jiufenOrder'),
      name: 'jiufenOrder',
      meta: { title: '纠纷订单' }
    },
    {
      path: 'line',
      component: () => import('@/views/order/line'),
      name: 'LineChart',
      meta: { title: '订单统计图表', noCache: true }
    }
  ]
}
export default tableRouter
