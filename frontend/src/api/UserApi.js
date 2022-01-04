import Client from './services/axios'

const resource = '/api/user'

export default {
  get () {
    return Client.get(`${resource}`)
  },

  create (payload) {
    return Client.post(`${resource}`, payload)
  }
}
