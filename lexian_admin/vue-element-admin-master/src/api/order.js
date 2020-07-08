import myrequest from '@/utils/myrequest'

export function getAllOrder() {
  return myrequest({
    url: '/order/getAllOrder',
    method: 'get'
  })
}

export function getDateRange(data) {
  return myrequest({
    url: '/order/getDateRange',
    method: 'post',
    data
  })
}

export function createOrder(data) {
  return myrequest({
    url: '/order/addOrder',
    method: 'post',
    data
  })
}

export function updateOrder(data) {
  return myrequest({
    url: '/order/updateOrder',
    method: 'post',
    data
  })
}
