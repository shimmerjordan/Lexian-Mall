export function initlist(length) {
  var res = []
  for (let j = 0; j < length; j++) {
    res.push(parseInt(Math.random() * (6) + 1, 10))
  }
  return res
}
