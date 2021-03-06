import Layout from '@/layout'

const permissionManage = {
  path: '/permission-manage',
  component: Layout,
  redirect: '/permission-manage',
  alwaysShow: true,
  meta: {
    title: '权限管理',
    icon: 'el-icon-user-solid'
    // affix: true
  },
  children: [
    {
      path: '/permission-manage',
      component: () => import('@/views/permission-manage/index'),
      name: 'permissionManage',
      meta: {
        title: '角色权限',
        hidden: true
      }
    },
    {
      path: '/personnel-manage',
      component: () => import('@/views/permission-manage/personnel-manage/index'),
      name: 'personnelManage',
      meta: {
        title: '人事管理',
        hidden: true
      }
    }
  ]
}
export default permissionManage
