import myrequest from '@/utils/myrequest'

export function getAllManager() {
  return myrequest({
    url: '/manager/all-role',
    method: 'get'
  })
}
