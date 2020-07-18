import myrequest from '@/utils/myrequest'

// 获取全部活动信息
export function getAllActivity(data) {
  return myrequest({
    url: '/getAllActivity',
    method: 'post',
    data
  })
}

// 更新活动信息
export function updateActivity(data) {
  return myrequest({
    url: '/updateActivity',
    method: 'post',
    data
  })
}

// 删除活动信息
export function deleteActivity(data) {
  return myrequest({
    url: '/deleteActivity',
    method: 'post',
    data
  })
}

// 更新活动状态为已发布
export function updateActivityStatus0(data) {
  return myrequest({
    url: '/updateActivityStatus0',
    method: 'post',
    data
  })
}

// 更新活动状态为是草稿
export function updateActivityStatus1(data) {
  return myrequest({
    url: '/updateActivityStatus1',
    method: 'post',
    data
  })
}

// 获取此时活动的最大id
export function getMaxActivityId() {
  return myrequest({
    url: '/getMaxActivityId',
    method: 'get'
  })
}

// 插入活动信息
export function insertActivity(data) {
  return myrequest({
    url: '/insertActivity',
    method: 'post',
    data
  })
}
