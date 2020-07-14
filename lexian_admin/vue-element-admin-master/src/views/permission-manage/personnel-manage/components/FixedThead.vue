<template>
  <div class="app-container">
    <div class="filter-container">
      <el-row>
        <el-col :span="20">
          <el-checkbox-group v-model="checkboxVal">
            <el-checkbox v-for="role in formTheadOptions" :key="role" :label="role">{{ role }}</el-checkbox>
          </el-checkbox-group>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="handleCreate">添加新成员</el-button>
        </el-col>
      </el-row>

    </div>

    <el-table :key="key" :data="tableData" :cell-class-name="getCellIndex" border fit highlight-current-row style="width: 100%">
      <el-table-column prop="name" label="角色名称" width="180" />
      <el-table-column v-for="role in formThead" :key="role" :label="role">
        <template slot-scope="scope">
          <el-row v-if=" scope.row[role] !== '' ">
            <el-col :span="19">{{ scope.row[role] }}</el-col>
            <el-col :span="5">
              <el-row>
                <el-button type="primary" icon="el-icon-edit" circle size="mini" @click="handleUpdate(scope.row,scope.column)" />
                <el-button type="danger" icon="el-icon-delete" circle size="mini" />
              </el-row>
            </el-col>
          </el-row>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="成员详情" :rules="rules" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :model="temp" label-position="left" label-width="80px" style="width: 400px; margin-left:50px;">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="temp.name" />
        </el-form-item>
        <el-form-item label="昵称" prop="nickname">
          <el-input v-model="temp.nickname" />
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="temp.phone" />
        </el-form-item>
        <el-form-item label="角色" prop="role">
          <el-select v-model="temp.role" class="filter-item" placeholder="Please select">
            <el-option v-for="item in roleOptions" :key="item.key" :label="item.name" :value="item.key" />
          </el-select>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker
            v-model="temp.birthday"
            type="date"
            placeholder="选择日期"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
        <el-button type="primary" @click="dialogStatus==='create'?createData():updateData()">
          提交
        </el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
const defaultFormThead = ['admin', 'editor']

const roleOptions = [
  { key: 1, name: 'admin' },
  { key: 2, name: 'editor' },
  { key: 3, name: 'visitor' }
]

import { getAllManager, updateManager, addManager } from '@/api/manager'

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
      length: [],
      dialogFormVisible: false,
      temp: {},
      roleOptions,
      dialogStatus: '',
      rules: {
        name: [{ required: true, message: '请输入真实姓名', trigger: 'change' }],
        nickname: [{ required: true, message: '请输入昵称', trigger: 'change' }],
        phone: [{ required: true, message: '请输入电话', trigger: 'change' }],
        role: [{ required: true, message: '请输入对应角色', trigger: 'change' }]
      }
    }
  },
  watch: {
    checkboxVal(valArr) {
      this.formThead = this.formTheadOptions.filter(i => valArr.indexOf(i) >= 0)
      this.key = this.key + 1// 为了保证table 每次都会重渲 In order to ensure the table will be re-rendered each time
    }
  },
  mounted() {
    this.initTable()
  },
  methods: {
    initTable() {
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
    setTable() {
      var l = Math.max.apply(null, this.length)
      this.tableData = []
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
        this.tableData[i].admin = this.admins[i].nickname
      }
      for (let i = 0; i < this.editors.length; i++) {
        this.tableData[i].editor = this.editors[i].nickname
      }
      for (let i = 0; i < this.visitors.length; i++) {
        this.tableData[i].visitor = this.visitors[i].nickname
      }
    },
    getCellIndex: function({ row, column, rowIndex, columnIndex }) {
      row.index = rowIndex
      column.index = columnIndex
    },
    handleUpdate(row, column) {
      this.dialogFormVisible = true
      if (column.label === 'admin') {
        this.temp = this.admins[row.index]
      } else if (column.label === 'editor') {
        this.temp = this.editors[row.index]
      } else if (column.label === 'visitor') {
        this.temp = this.visitors[row.index]
      }
      this.dialogStatus = 'update'
      this.temp.birthday = new Date(this.temp.birthday)
      console.log(this.temp)
    },
    handleCreate() {
      this.temp = {}
      this.dialogFormVisible = true
      this.dialogStatus = 'create'
    },
    updateData() {
      var d = this.temp.birthday
      var datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
      this.temp.birthday = datetime
      console.log(this.temp)
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          updateManager(this.temp).then(response => {
            if (response.data) {
              this.$notify({
                title: 'Success',
                message: '成功修改订单',
                type: 'success',
                duration: 2000
              })
            } else {
              this.$notify({
                title: 'Fail',
                message: '订单修改失败',
                type: 'fail',
                duration: 2000
              })
            }
            this.dialogFormVisible = false
          })
        }
        this.initTable()
      })
    },
    createData() {
      var d = this.temp.birthday
      var datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
      this.temp.birthday = datetime
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          addManager(this.temp).then(response => {
            if (response.data) {
              this.$notify({
                title: 'Success',
                message: '成功修改订单',
                type: 'success',
                duration: 2000
              })
            } else {
              this.$notify({
                title: 'Fail',
                message: '订单修改失败',
                type: 'fail',
                duration: 2000
              })
            }
            this.dialogFormVisible = false
          })
        }
        this.initTable()
      })
    }
  }
}
</script>
