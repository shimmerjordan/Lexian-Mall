import myrequest from '@/utils/myrequest'

// 插入活动——店铺信息
export function insertActivityShop(data) {
  return myrequest({
    url: '/insertActivityShop',
    method: 'post',
    data
  })
}
