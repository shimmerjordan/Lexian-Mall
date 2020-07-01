import Layout from '@/layout'

const goodRouter = {
  path: '/goodManage',
  component: Layout,
  redirect: '/goodManager/goodList',
  name: 'goodManage',
  meta: {
    title: '商品管理',
    icon: 'table'
  },
  children: [
    {
      path: 'goodList',
      component: () => import('@/views/goodManage/goodList'),
      name: 'goodList',
      meta: { title: '商品列表' }
    },
    {
      path: 'goodAdd',
      component: () => import('@/views/goodManage/goodAdd'),
      name: 'goodAdd',
      meta: { title: '添加商品' }
    }
  ]
}
export default goodRouter
