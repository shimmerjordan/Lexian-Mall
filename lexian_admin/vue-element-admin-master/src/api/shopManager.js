import myrequest from '@/utils/myrequest'

// 查找店铺管理员信息
export function searchShopManager(data) {
  return myrequest({
    url: '/searchShopManager',
    method: 'post',
    data
  })
}

// 更新店铺管理员信息
export function updateShopManager(data) {
  return myrequest({
    url: '/updateShopManager',
    method: 'post',
    data
  })
}

// 删除店铺管理员信息
export function deleteShopManager(data) {
  return myrequest({
    url: '/deleteShopManager',
    method: 'post',
    data
  })
}
