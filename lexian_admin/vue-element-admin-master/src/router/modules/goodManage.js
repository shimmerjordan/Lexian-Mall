import Layout from '@/layout'

const goodRouter = {
  path: '/goodManage',
  component: Layout,
  redirect: '/goodManage/goodList',
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
    },
    {
      path: 'goodCategory',
      component: () => import('@/views/goodManage/goodCategory'),
      name: 'goodCategory',
      meta: { title: '商品分类' }
    },
    {
      path: 'categoryGood',
      component: () => import('@/views/goodManage/categoryGood'),
      name: 'categoryGood',
      meta: { title: '分类商品详情' },
      hidden: true
    }

  ]
}
export default goodRouter
