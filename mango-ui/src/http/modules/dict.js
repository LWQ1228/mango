import axios from '../axios'

/*
 * 字典管理模块
 */

// 保存
export const save = (data) => {
  return axios({
    url: '/system/dict/save',
    method: 'post',
    data
  })
}
// 删除
export const batchDelete = (data) => {
  return axios({
    url: '/system/dict/delete',
    method: 'post',
    data
  })
}
// 分页查询
export const findPage = (data) => {
  return axios({
    url: '/system/dict/findPage',
    method: 'post',
    data
  })
}
