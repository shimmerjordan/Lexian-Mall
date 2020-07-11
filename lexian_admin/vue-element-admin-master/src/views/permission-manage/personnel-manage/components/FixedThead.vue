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
          <el-row v-if=" scope.row[role] !== '' ">
            <el-col :span="22">{{ scope.row[role] }}</el-col>
            <el-col :span="2"><el-button type="danger" icon="el-icon-delete" circle size="mini" /></el-col>
          </el-row>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
const defaultFormThead = ['admin', 'editor']

import { getAllManager } from '@/api/manager'

export default {
  data() {
    return {
      tableData: [],
      key: 1, // table key
      formTheadOptions: ['admin', 'editor', 'visitor'],
      checkboxVal: defaultFormThead, // checkboxVal
      formThead: defaultFormThead, // 默认表头 Default header]
      admins: [],
      editors: [],
      visitors: [],
      length: []
    }
  },
  watch: {
    checkboxVal(valArr) {
      this.formThead = this.formTheadOptions.filter(i => valArr.indexOf(i) >= 0)
      this.key = this.key + 1// 为了保证table 每次都会重渲 In order to ensure the table will be re-rendered each time
    }
  },
  mounted() {
    getAllManager().then(response => {
      this.length = []
      this.admins = response.data[0]
      this.length.push(this.admins.length)
      this.editors = response.data[1]
      this.length.push(this.editors.length)
      this.visitors = response.data[2]
      this.length.push(this.visitors.length)
      this.setTable()
    })
  },
  methods: {
    setTable() {
      var l = Math.max.apply(null, this.length)
      for (let i = 0; i < l; i++) {
        var ob = {}
        ob.name = ''
        ob.admin = ''
        ob.editor = ''
        ob.visitor = ''
        this.tableData.push(ob)
      }
      this.tableData[0].name = '人员姓名'
      for (let i = 0; i < this.admins.length; i++) {
        this.tableData[i].admin = this.admins[i].name
      }
      for (let i = 0; i < this.editors.length; i++) {
        this.tableData[i].editor = this.editors[i].name
      }
      for (let i = 0; i < this.visitors.length; i++) {
        this.tableData[i].visitor = this.visitors[i].name
      }
    }
  }
}
</script>
