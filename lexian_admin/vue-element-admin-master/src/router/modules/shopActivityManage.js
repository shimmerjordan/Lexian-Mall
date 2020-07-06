import Layout from '@/layout'

const shopActivityManage = {
  path: '/shopActivity',
  component: Layout,
  redirect: '/shopActivity/shopActivity-manage',
  alwaysShow: true,
  name: 'shopActivity',
  meta: {
    title: '店铺活动管理',
    icon: 'el-icon-s-opportunity'
  },
  children: [
    {
      path: 'shopActivity-manage',
      component: () => import('@/views/shopActivity-manage/shopActivitylist'),
      name: 'activityList',
      meta: {
        title: '门店活动列表展示',
        hidden: true
      }
    },
    {
      path: 'add-shopActivity',
      component: () => import('@/views/shopActivity-manage/addshopActivity'),
      name: 'addShopActivity',
      meta: {
        title: '新增门店活动信息',
        hidden: true
      }
    }
  ]
}
export default shopActivityManage
