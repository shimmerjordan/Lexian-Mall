import myrequest from '@/utils/myrequest'

export function getAllShop() {
  return myrequest({
    url: '/getAllShop',
    method: 'get'
  })
}

export function getMaxShopId() {
  return myrequest({
    url: '/getMaxShopID',
    method: 'get'
  })
}

export function updateShop(data) {
  return myrequest({
    url: '/updateShop',
    method: 'post',
    data
  })
}
