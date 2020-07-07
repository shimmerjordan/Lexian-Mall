import myrequest from '@/utils/myrequest'

export function getAllShopGoods() {
  return myrequest({
    url: '/api/shop/goodsInfo',
    method: 'get'
  })
}

export function UpdateShopGood(tempData) {
  return myrequest({
    url: '/api/shop/updateGood',
    method: 'get',
    params: { tempData }
  })
}
