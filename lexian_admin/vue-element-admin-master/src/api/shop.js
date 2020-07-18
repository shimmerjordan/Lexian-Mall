import myrequest from '@/utils/myrequest'

// 获取全部的店铺信息（如果输入数据为空），不为空则对数据进行查询
export function getAllShop(data) {
  return myrequest({
    url: '/getAllShop',
    method: 'post',
    data
  })
}

// 获取最大的店铺id
export function getMaxShopId() {
  return myrequest({
    url: '/getMaxShopId',
    method: 'get'
  })
}

// 更新店铺信息
export function updateShop(data) {
  return myrequest({
    url: '/updateShop',
    method: 'post',
    data
  })
}

// 删除店铺信息
export function deleteShop(data) {
  return myrequest({
    url: '/deleteShop',
    method: 'post',
    data
  })
}

// 插入店铺信息
export function insertShop(data) {
  return myrequest({
    url: '/insertShop',
    method: 'post',
    data
  })
}

// 批量更新店铺状态为正在营业
export function updateShopStatus0(data) {
  return myrequest({
    url: '/updateShopStatus0',
    method: 'post',
    data
  })
}

// 批量更新店铺状态为暂停营业
export function updateShopStatus1(data) {
  return myrequest({
    url: '/updateShopStatus1',
    method: 'post',
    data
  })
}

// 批量更新店铺状态为店铺关闭
export function updateShopStatus2(data) {
  return myrequest({
    url: '/updateShopStatus2',
    method: 'post',
    data
  })
}
