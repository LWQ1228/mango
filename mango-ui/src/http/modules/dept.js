import axios from '../axios'

/*
 * 机构管理模块
 */

// 保存
export const save = (data) => {
  return axios({
    url: '/system/dept/save',
    method: 'post',
    data
  })
}
// 删除
export const batchDelete = (data) => {
  return axios({
    url: '/system/dept/delete',
    method: 'post',
    data
  })
}
// 查询机构树
export const findDeptTree = () => {
  return axios({
    url: '/system/dept/findTree',
    method: 'get'
  })
}
