<template>
  <div class="app-container">
    <!-- <el-button type="primary" icon="el-icon-plus" @click="handleAddRole">新增角色</el-button> -->
    <h3>角色权限信息展示</h3>
    <el-table :data="rolesList" style="width: 100%;margin-top:30px;" border>
      <el-table-column align="center" label="角色要点" width="220">
        <template slot-scope="scope">
          {{ scope.row.key }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="角色名称" width="220">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column align="header-center" label="角色描述">
        <template slot-scope="scope">
          {{ scope.row.description }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作">
        <template slot-scope="scope">
          <el-button type="primary" size="small" @click="lookInfo(scope)">查看详情</el-button>
          <!-- <el-button type="danger" size="small" @click="handleDelete(scope)">删除</el-button> -->
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="dialogVisible">
      <el-form :model="role" label-width="80px" label-position="left">
        <el-form-item label="角色名称">
          <el-input v-model="role.name" />
        </el-form-item>
        <el-form-item label="角色描述">
          <el-input
            v-model="role.description"
            :autosize="{ minRows: 2, maxRows: 4}"
            type="textarea"
          />
        </el-form-item>
        <el-form-item label="页面权限">
          <!-- <el-tree
            ref="tree"
            :check-strictly="checkStrictly"
            :data="routesData"
            :props="defaultProps"
            show-checkbox
            node-key="path"
            class="permission-tree"
          /> -->
          <el-checkbox-group v-model="routesData">
            <el-checkbox v-for="route in routesList" :key="route.key" :label="route.key" :value="route.key">
              {{ route.label }}
            </el-checkbox>
          </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div style="text-align:right;">
        <el-button type="danger" @click="dialogVisible=false">返回</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
// import path from 'path'
// import { deepClone } from '@/utils'
// import { getRoutes, getRoles, addRole, deleteRole, updateRole } from '@/api/role'

// const defaultRole = {
//   key: '',
//   name: '',
//   description: '',
//   routes: []
// }

export default {
  data() {
    return {
      routesData: [],
      // role: Object.assign({}, defaultRole),
      role: {},
      routesList: [
        { key: 0, label: '权限管理' },
        { key: 1, label: '订单管理' },
        { key: 2, label: '商品管理' },
        { key: 3, label: '店铺管理' },
        { key: 4, label: '活动管理' },
        { key: 5, label: '数据查看' }
      ],
      rolesList: [
        { key: 'SystemAdmin', name: 'SystemAdmin', description: '系统管理员，整体管理和维护系统信息及功能', routes: [0, 1, 2, 3, 4, 5] },
        { key: 'ShopAdmin', name: 'ShopAdmin', description: '店铺管理员，主要管理与自己相关的店铺和店铺活动订单等', routes: [0, 1, 2, 3, 4] }
      ],
      dialogVisible: false,
      dialogType: 'new',
      // checkStrictly: false,
      defaultProps: {
        children: 'children',
        label: 'title'
      }
    }
  },
  computed: {
    // routesData() {
    //   return this.routes
    // }
  },
  created() {
    // Mock: get all routes and roles list from server
    // this.getRoutes()
    // this.getRoles()
    this.rolesList
  },
  methods: {
    lookInfo(scope) {
      this.dialogVisible = true
      this.role = scope.row
      this.routesData = scope.row.routes
      console.log(this.routesData)
    }
    // handleDelete({ $index, row }) {
    //   this.$confirm('Confirm to remove the role?', 'Warning', {
    //     confirmButtonText: 'Confirm',
    //     cancelButtonText: 'Cancel',
    //     type: 'warning'
    //   })
    //     .then(async() => {
    //       await deleteRole(row.key)
    //       this.rolesList.splice($index, 1)
    //       this.$message({
    //         type: 'success',
    //         message: 'Delete succed!'
    //       })
    //     })
    //     .catch(err => { console.error(err) })
    // },
    // generateTree(routes, basePath = '/', checkedKeys) {
    //   const res = []

    //   for (const route of routes) {
    //     const routePath = path.resolve(basePath, route.path)

    //     // recursive child routes
    //     if (route.children) {
    //       route.children = this.generateTree(route.children, routePath, checkedKeys)
    //     }

    //     if (checkedKeys.includes(routePath) || (route.children && route.children.length >= 1)) {
    //       res.push(route)
    //     }
    //   }
    //   return res
    // },
    // async confirmRole() {
    //   const isEdit = this.dialogType === 'edit'

    //   const checkedKeys = this.$refs.tree.getCheckedKeys()
    //   this.role.routes = this.generateTree(deepClone(this.serviceRoutes), '/', checkedKeys)

    //   if (isEdit) {
    //     await updateRole(this.role.key, this.role)
    //     for (let index = 0; index < this.rolesList.length; index++) {
    //       if (this.rolesList[index].key === this.role.key) {
    //         this.rolesList.splice(index, 1, Object.assign({}, this.role))
    //         break
    //       }
    //     }
    //   } else {
    //     const { data } = await addRole(this.role)
    //     this.role.key = data.key
    //     this.rolesList.push(this.role)
    //   }

    //   const { description, key, name } = this.role
    //   this.dialogVisible = false
    //   this.$notify({
    //     title: 'Success',
    //     dangerouslyUseHTMLString: true,
    //     message: `
    //         <div>Role Key: ${key}</div>
    //         <div>Role Name: ${name}</div>
    //         <div>Description: ${description}</div>
    //       `,
    //     type: 'success'
    //   })
    // },
    // reference: src/view/layout/components/Sidebar/SidebarItem.vue
    // onlyOneShowingChild(children = [], parent) {
    //   let onlyOneChild = null
    //   const showingChildren = children.filter(item => !item.hidden)

    //   // When there is only one child route, the child route is displayed by default
    //   if (showingChildren.length === 1) {
    //     onlyOneChild = showingChildren[0]
    //     onlyOneChild.path = path.resolve(parent.path, onlyOneChild.path)
    //     return onlyOneChild
    //   }

    //   // Show parent if there are no child route to display
    //   if (showingChildren.length === 0) {
    //     onlyOneChild = { ... parent, path: '', noShowingChildren: true }
    //     return onlyOneChild
    //   }

    //   return false
    // }
  }
}
</script>

<style lang="scss" scoped>
.app-container {
  .roles-table {
    margin-top: 30px;
  }
  .permission-tree {
    margin-bottom: 30px;
  }
}
</style>
