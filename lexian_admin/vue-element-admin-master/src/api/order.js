import myrequest from '@/utils/myrequest'

export function getAllOrder() {
  return myrequest({
    url: '/getAllOrder',
    method: 'get'
  })
}
