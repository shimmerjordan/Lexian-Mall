import myrequest from '@/utils/myrequest'

export function getAllActivity() {
  return myrequest({
    url: '/getAllActivity',
    method: 'get'
  })
}
