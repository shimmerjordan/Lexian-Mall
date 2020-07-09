import myrequest from '@/utils/myrequest'

export function getAllActivity() {
  return myrequest({
    url: '/getAllActivity',
    method: 'get'
  })
}

export function updateActivity(data) {
  return myrequest({
    url: '/updateActivity',
    method: 'post',
    data
  })
}

export function deleteActivity(data) {
  return myrequest({
    url: '/deleteActivity',
    method: 'post',
    data
  })
}

export function updateActivityStatus0(data) {
  return myrequest({
    url: '/updateActivityStatus0',
    method: 'post',
    data
  })
}

export function updateActivityStatus1(data) {
  return myrequest({
    url: '/updateActivityStatus1',
    method: 'post',
    data
  })
}

export function getMaxActivityId() {
  return myrequest({
    url: '/getMaxActivityId',
    method: 'get'
  })
}
