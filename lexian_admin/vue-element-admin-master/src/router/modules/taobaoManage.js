import Layout from '@/layout'

const taobaoRouter = {
  path: '/taobaoDuibi',
  component: Layout,
  redirect: '/taobaoDuibi/taobao',
  name: 'taobao',
  meta: {
    title: '货比三家',
    icon: 'table'
  },
  children: [
    {
      path: 'taobao',
      component: () => import('@/views/taobaoDuiBi/taobao'),
      name: 'taobaoData',
      meta: { title: '淘宝数据' }
    },
    {
      path: 'jingdong',
      component: () => import('@/views/taobaoDuiBi/taobao'),
      name: 'jingdongData',
      meta: { title: '京东数据' }
    }
  ]
}
export default taobaoRouter
