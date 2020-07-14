import myrequest from '@/utils/myrequest'

export function getAllShop(data) {
  return myrequest({
    url: '/getAllShop',
    method: 'post',
    data
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
    method: 'post',
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

export function updateShopStatus0(data) {
  return myrequest({
    url: '/updateShopStatus0',
    method: 'post',
    data
  })
}

export function updateShopStatus1(data) {
  return myrequest({
    url: '/updateShopStatus1',
    method: 'post',
    data
  })
}

export function updateShopStatus2(data) {
  return myrequest({
    url: '/updateShopStatus2',
    method: 'post',
    data
  })
}
