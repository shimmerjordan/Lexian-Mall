import myrequest from '@/utils/myrequest'

export function getAllOrder() {
  return myrequest({
    url: '/order/getAllOrder',
    method: 'get'
  })
}

export function getDateRange(start, end) {
  return myrequest({
    url: '/order/getDateRange',
    method: 'post',
    start, end
  })
}
