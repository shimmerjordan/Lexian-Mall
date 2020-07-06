import myrequest from '@/utils/myrequest'

export function getAllShop() {
  return myrequest({
    url: '/getAllShop',
    method: 'get'
  })
}
