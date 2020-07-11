import myrequest from '@/utils/myrequest'

export function getAllShop() {
  return myrequest({
    url: '/getAllShop',
    method: 'get'
  })
}

export function getMaxShopId() {
  return myrequest({
    url: '/getMaxShopId',
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

export function deleteShop(data) {
  return myrequest({
    url: '/deleteShop',
    method: 'post',
    data
  })
}

export function searchShop(data) {
  return myrequest({
    url: '/searchShop',
    method: 'get',
    data
  })
}

export function insertShop(data) {
  return myrequest({
    url: '/insertShop',
    method: 'post',
    data
  })
}
