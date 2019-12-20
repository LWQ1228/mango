export default {
  state: {
    perms: [], //用户权限标识集合
  },
  getters: {},
  mutations: {
    //用户权限标识集合
    setPerms (state, perms) {
      state.perms = perms
    }
  }
}
