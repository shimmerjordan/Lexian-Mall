import myrequest from '@/utils/myrequest'

// 获取商品列表
export function getAllShopGoods() {
  return myrequest({
    url: '/api/shop/goodsInfo',
    method: 'get'
  })
}

// 更新商品请求
export function UpdateShopGood(data) {
  return myrequest({
    url: '/api/shop/updateGood',
    method: 'post',
    data
  })
}

// 删除店铺商品
export function DeleteShopGood(data) {
  return myrequest({
    url: '/api/shop/deleteGood',
    method: 'post',
    data
  })
}

// 添加新的商品
export function AddShopGood(data) {
  return myrequest({
    url: '/api/shop/addGood',
    method: 'post',
    data
  })
}

// 商品类别管理getAllCategory
export function getAllCategory() {
  return myrequest({
    url: '/api/shop/getAllCategory',
    method: 'post'
  })
}
