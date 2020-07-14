import myrequest from '@/utils/myrequest'

export function getAllOrder(data) {
  return myrequest({
    url: '/order/getAllOrder',
    method: 'post',
    data
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

// 获取纠纷订单
export function jiufenOrder(data) {
  return myrequest({
    url: '/order/jiufenOrder',
    method: 'post',
    data
  })
}

// 纠纷订单删除
export function DeleteJiuFenOrder(data) {
  return myrequest({
    url: '/order/DeleteJiuFenOrder',
    method: 'post',
    data
  })
}

// 纠纷订单处理，更新订单状态
export function UpdateJiuFenOrder(data) {
  return myrequest({
    url: '/order/UpdateJiuFenOrder',
    method: 'post',
    data
  })
}

