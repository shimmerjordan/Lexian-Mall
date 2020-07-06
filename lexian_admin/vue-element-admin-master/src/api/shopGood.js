import myrequest from '@/utils/myrequest'

export function getAllShopGoods() {
  return myrequest({
    url: '/api/shop/goodsInfo',
    method: 'get'
  })
}
