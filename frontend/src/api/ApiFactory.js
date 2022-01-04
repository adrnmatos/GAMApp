import UserApi from './UserApi'

const apis = {
  user: UserApi
}
export default {
  get: (name) => apis[name]
}
