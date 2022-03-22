import UserApi from './UserApi';
import ProcessApi from './ProcessApi';

const apis = {
  userApi: UserApi,
  processApi: ProcessApi,
};
export default {
  get: (name) => apis[name],
};
