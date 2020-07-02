import Layout from '@/layout'

const shopManage = {
  path: '/',
  component: Layout,
  redirect: '/shop/shop-manage',
  alwaysShow: true,
  meta: {
    title: '店铺管理',
    icon: 'el-icon-s-shop',
    affix: true
  },
  children: [
    {
      path: 'shop/shop-manager',
      component: () => import('@/views/shop-manage/shopList'),
      name: 'shopList',
      meta: {
        title: '门店列表展示',
        hidden: true
      }
    },
    {
      path: 'shop/add-shop',
      component: () => import('@/views/shop-manage/addShop'),
      name: 'addShop',
      meta: {
        title: '新增门店信息',
        hidden: true
      }
    }
  ]
}
export default shopManage
