import myrequest from '@/utils/myrequest'

export function insertActivityShop(data) {
  return myrequest({
    url: '/insertActivityShop',
    method: 'post',
    data
  })
}
