import myrequest from '@/utils/myrequest'

export function getAllManager() {
  return myrequest({
    url: '/manager/all-role',
    method: 'get'
  })
}

export function updateManager(data) {
  return myrequest({
    url: '/manager/update',
    method: 'post',
    data
  })
}

export function addManager(data) {
  return myrequest({
    url: '/manager/add',
    method: 'post',
    data
  })
}

export function deleteManager(index) {
  return myrequest({
    url: '/manager/delete',
    method: 'get',
    params: { index }
  })
}
