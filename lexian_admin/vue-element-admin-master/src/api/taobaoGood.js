import myrequest from '@/utils/myrequest'

// 此api目的是获取淘宝爬虫的所有数据 展示给管理员
export function getAlltaobaoGoods(data) {
  return myrequest({
    url: '/api/getAlltaobaoGoods',
    method: 'post',
    data
  })
}
