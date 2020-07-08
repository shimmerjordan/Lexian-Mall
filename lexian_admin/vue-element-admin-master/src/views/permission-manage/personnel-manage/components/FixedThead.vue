<template>
  <div class="app-container">
    <div class="filter-container">
      <el-checkbox-group v-model="checkboxVal">
        <el-checkbox v-for="role in formTheadOptions" :key="role" :label="role">{{ role }}</el-checkbox>
      </el-checkbox-group>
    </div>

    <el-table :key="key" :data="tableData" border fit highlight-current-row style="width: 100%">
      <el-table-column prop="name" label="角色名称" width="180" />
      <el-table-column v-for="role in formThead" :key="role" :label="role">
        <template slot-scope="scope">
          <el-row>
            <el-col :span="22">{{ scope.row[role] }}</el-col>
            <el-col :span="2"><el-button type="danger" icon="el-icon-delete" circle size="mini" /></el-col>
          </el-row>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
const defaultFormThead = ['管理者', '编辑者']
export default {
  data() {
    return {
      tableData: [
        {
          name: '人员姓名',
          '管理者': '小红',
          '编辑者': '小蓝',
          '访问者': '小绿'
        },
        {
          name: '',
          '管理者': '小白',
          '编辑者': '小青',
          '访问者': '小紫'
        }
      ],
      key: 1, // table key
      formTheadOptions: ['管理者', '编辑者', '访问者'],
      checkboxVal: defaultFormThead, // checkboxVal
      formThead: defaultFormThead // 默认表头 Default header
    }
  },
  watch: {
    checkboxVal(valArr) {
      this.formThead = this.formTheadOptions.filter(i => valArr.indexOf(i) >= 0)
      this.key = this.key + 1// 为了保证table 每次都会重渲 In order to ensure the table will be re-rendered each time
    }
  }
}
</script>
