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
    method: 'get',
    params: { data }
  })
}
