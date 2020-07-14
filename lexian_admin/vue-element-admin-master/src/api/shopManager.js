import myrequest from '@/utils/myrequest'

export function searchShopManager(data) {
  return myrequest({
    url: '/searchShopManager',
    method: 'post',
    data
  })
}

export function updateShopManager(data) {
  return myrequest({
    url: '/updateShopManager',
    method: 'post',
    data
  })
}

export function deleteShopManager(data) {
  return myrequest({
    url: '/deleteShopManager',
    method: 'post',
    data
  })
}
