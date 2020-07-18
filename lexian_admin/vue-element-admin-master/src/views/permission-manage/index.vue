<template>
  <div class="app-container">
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
          <!-- 获取角色具体信息，点击按钮时，弹唱显示 -->
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
          <!-- 利用cheeckbox展示角色的页面权限 -->
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
      // 角色对应的信息
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
  },
  created() {
    this.rolesList
  },
  methods: {
    // 展示对应角色下的权限详情
    lookInfo(scope) {
      this.dialogVisible = true
      this.role = scope.row
      this.routesData = scope.row.routes
      console.log(this.routesData)
    }
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
