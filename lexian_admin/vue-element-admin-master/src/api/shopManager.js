import myrequest from '@/utils/myrequest'

export function searchShopManager(data) {
  return myrequest({
    url: '/searchShopManager',
    method: 'get',
    data
  })
}
