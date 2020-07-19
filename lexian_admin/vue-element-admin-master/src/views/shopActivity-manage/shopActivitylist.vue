<template>
  <div class="app-container">
    <!-- 店铺活动列表界面 -->
    <div class="filter-container">
      <!-- 页面查询信息 -->
      <el-row>
        <el-input v-model="listQuery.id" placeholder="ID" style="width: 200px;margin-right:20px" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        <el-input v-model="listQuery.name" placeholder="活动名称" style="width: 200px;margin-right:20px" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        <el-select v-model="listQuery.status" placeholder="活动状态" clearable class="filter-item" style="width: 130px;margin-right:20px">
          <el-option v-for="item in statusList" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />
        </el-select>
        <!-- <el-select v-model="listQuery.sort" style="width: 140px" class="filter-item" @change="handleFilter">
          <el-option v-for="item in sortOptions" :key="item.key" :label="item.label" :value="item.key" />
        </el-select> -->
        <el-date-picker
          v-model="timeRange"
          value-format="yyyy-MM-dd HH:mm:ss"
          type="datetimerange"
          align="right"
          unlink-panels
          range-separator="至"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
          :picker-options="pickerOptions"
          class="filter-item"
        />
      </el-row>
      <!-- 对输入的信息进行的操作 -->
      <el-row>
        <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
          搜索
        </el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
          新增
        </el-button>
        <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">
          导出
        </el-button>
        <el-checkbox v-model="showDescription" class="filter-item" style="margin-left:15px;" @change="tableKey=tableKey+1">
          活动描述
        </el-checkbox>
      </el-row>
    </div>
    <!-- 店铺活动列表 -->
    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row
      style="width: 100%;"
      @sort-change="sortChange"
    >
      <!-- id列，可根据id对表中数据进行正序倒序排列 -->
      <el-table-column label="ID" prop="id" sortable align="center" width="80" :class-name="getSortClass('id')">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动名称" width="110px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动类型" width="110px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.type }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动图片" width="150px" align="center">
        <template slot-scope="{row}">
          <img :src="row.img" width="150px" height="120px" align="center">
        </template>
      </el-table-column>
      <el-table-column label="创建时间" width="150px" align="center">
        <template slot-scope="{row}">
          <!-- 对从数据库中取出的时间格式进行转换 -->
          <span>{{ row.createTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="开始时间" width="150px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.beginTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" width="150px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.endTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <!-- 活动描述隐藏，当点击显示时，描述该列进行展示 -->
      <el-table-column v-if="showDescription" label="活动描述" width="110px" align="center">
        <template slot-scope="{row}">
          <span style="color:gray;">{{ row.description }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动状态" class-name="status-col" width="100">
        <template slot-scope="{row}">
          <!-- 对从数据库中取出的数据进行转换，当状态为1时，为已发布，为0，是草稿 -->
          <el-tag v-if="row.status==0" type="success">
            已发布
          </el-tag>
          <el-tag v-if="row.status == 1" type="info">
            是草稿
          </el-tag>
        </template>
      </el-table-column>
      <!-- 对活动进行的操作 -->
      <el-table-column label="操作" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            编辑
          </el-button>
          <el-button v-if="row.status!='0'" size="mini" type="success" @click="handleModifyStatus0(row,$index)">
            发布
          </el-button>
          <el-button v-if="row.status!='1'" size="mini" @click="handleModifyStatus1(row,$index)">
            草稿
          </el-button>
          <el-button size="mini" type="danger" @click="handleDelete(row,$index)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
    <!-- 当点击编辑按钮时，此显示 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="活动id" prop="id">
          <!-- 活动id不可更改 -->
          <el-input v-model="temp.id" disabled />
        </el-form-item>
        <el-form-item label="活动名称" prop="name">
          <el-input v-model="temp.name" />
        </el-form-item>
        <el-form-item label="创建时间" prop="createTime">
          <!-- 活动创建时间不可更改 -->
          <el-date-picker v-model="temp.createTime" type="datetime" disabled />
        </el-form-item>
        <el-form-item label="开始时间" prop="beginTime">
          <el-date-picker v-model="temp.beginTime" type="datetime" placeholder="请选择开始日期" />
        </el-form-item>
        <el-form-item label="结束时间" prop="endTime">
          <el-date-picker v-model="temp.endTime" type="datetime" placeholder="请选择结束日期" />
        </el-form-item>
        <el-form-item label="活动状态" prop="status">
          <el-select v-model="temp.status" class="filter-item" placeholder="请选择活动状态">
            <el-option v-for="item in statusOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="活动类型" prop="type">
          <el-select v-model="temp.type" placeholder="请选择活动类型">
            <el-option v-for="item in typeOptions" :key="item.key" :label="item.label" :value="item.label" />
          </el-select>
        </el-form-item>
        <el-form-item label="活动图片">
          <!-- 目前设定为活动的图片不可更改 -->
          <img :src="temp.img" width="200px" height="200px" align="center">
        </el-form-item>
        <el-form-item label="活动描述">
          <el-input v-model="temp.description" :autosize="{ minRows: 2, maxRows: 4}" type="textarea" placeholder="请输入关于活动的描述" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <!-- 对于编辑活动的操作 -->
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
        <el-button type="primary" @click="update()">
          提交
        </el-button>
      </div>
    </el-dialog>

    <!-- <el-dialog :visible.sync="dialogPvVisible" title="Reading statistics">
      <el-table :data="pvData" border fit highlight-current-row style="width: 100%">
        <el-table-column prop="key" label="Channel" />
        <el-table-column prop="pv" label="Pv" />
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogPvVisible = false">Confirm</el-button>
      </span>
    </el-dialog> -->
  </div>
</template>

<script>
// import { fetchPv, createArticle } from '@/api/article'
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination

import { getAllActivity, updateActivity, deleteActivity, updateActivityStatus0, updateActivityStatus1 } from '@/api/activity'

// 活动状态列表
const statusList = [
  { key: '0', display_name: '发布' },
  { key: '1', display_name: '草稿' }
]

// 赋值
const statusKeyValue = statusList.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'ShopActivity',
  components: { Pagination },
  directives: { waves },
  filters: {
    typeFilter(type) {
      return statusKeyValue[type]
    }
  },
  data() {
    return {
      // 数据初始化
      timeRange: '',
      tableKey: 0,
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 10,
        createTime: '',
        beginTime: '',
        endTime: '',
        id: '',
        name: '',
        status: '',
        sort: '+id'
      },
      statusList,
      typeOptions: [{ label: '秒杀', value: 0 }, { label: '团购', value: 1 }, { label: '节日限定', value: 2 }],
      statusOptions: [{ label: '发布', value: 0 }, { label: '草稿', value: 1 }],
      showDescription: false,
      temp: {
        id: '',
        createTime: '',
        beginTime: '',
        endTime: '',
        name: '',
        status: '',
        description: '',
        type: ''
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑'
        // create: 'Create'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        // type: [{ required: true, message: 'type is required', trigger: 'change' }],
        // timestamp: [{ type: 'date', required: true, message: 'timestamp is required', trigger: 'change' }],
        // title: [{ required: true, message: 'title is required', trigger: 'blur' }]
      },
      downloadLoading: false,
      // 时间选择限制，将获取的时间段分隔为开始时间和结束时间
      pickerOptions: {
        onPick: ({ maxDate, minDate }) => {
          if (maxDate != null && minDate != null) {
            this.maxDate = maxDate
            this.minDate = minDate
            this.listQuery.beginTime = minDate
            this.listQuery.endTime = maxDate
            console.log(this.listQuery.beginTime)
          }
        },
        // 时间选择时的快捷选项
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      }
    }
  },
  created() {
    this.getList() // 页面加载时，获取活动列表
  },
  methods: {
    // 获取活动列表，当查找框输入为空时，则获取全部活动信息；不为空时，则根据条件进行查询
    getList() {
      this.listLoading = true
      console.log(this.listQuery)
      getAllActivity(this.listQuery).then(response => {
        this.list = response.data.list // 将获取的数据进行赋值
        this.total = response.data.total
        console.log(this.list)
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
      this.listLoading = false
    },
    // 刷新
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    // 修改活动状态为已发布
    handleModifyStatus0(row, index) {
      updateActivityStatus0(row).then(response => {
        alert('发布成功') // 修改成功则弹出提示框
        this.$notify({
          title: 'Success',
          message: 'publish Successfully',
          type: 'success',
          duration: 2000
        })
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
        this.getList()
      })
    },
    // 修改活动状态为草稿
    handleModifyStatus1(row, index) {
      updateActivityStatus1(row).then(response => {
        alert('存为草稿')
        this.$notify({
          title: 'Success',
          message: 'draft Successfully',
          type: 'success',
          duration: 2000
        })
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
        this.getList()
      })
    },
    // handleModifyStatus(row, status) {
    //   this.$message({
    //     message: '操作Success',
    //     type: 'success'
    //   })
    //   row.status = status
    // },

    // 排序
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    // 根据id进行排序，正序倒序
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = '+id'
      } else {
        this.listQuery.sort = '-id'
      }
      this.handleFilter()
    },
    // resetTemp() {
    //   this.temp = {
    //     id: undefined,
    //     importance: 1,
    //     remark: '',
    //     timestamp: new Date(),
    //     title: '',
    //     status: 'published',
    //     type: ''
    //   }
    // },

    // 点击新增按钮，跳转到新增活动页面
    handleCreate() {
      this.$nextTick(() => {
        this.$router.push({ path: 'add-shopActivity' })
      })
    },
    // createData() {
    //   this.$refs['dataForm'].validate((valid) => {
    //     if (valid) {
    //       this.temp.id = parseInt(Math.random() * 100) + 1024 // mock a id
    //       this.temp.author = 'vue-element-admin'
    //       createArticle(this.temp).then(() => {
    //         this.list.unshift(this.temp)
    //         this.dialogFormVisible = false
    //         this.$notify({
    //           title: 'Success',
    //           message: 'Created Successfully',
    //           type: 'success',
    //           duration: 2000
    //         })
    //       })
    //     }
    //   })
    // },

    // 点击编辑按钮，获取该活动信息
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      // this.temp.timestamp = new Date(this.temp.timestupdateDataamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    // 审核提交的更新活动信息
    update() {
      // console.log(statusOptions[0])
      console.log(this.temp)
      const bt = this.temp.beginTime
      const et = this.temp.endTime
      const n = this.temp.name
      const des = this.temp.description
      if (bt === '' || et === '' || n === '' || des === '') {
        this.$message({
          message: '请填写完整的更新活动信息后，再次尝试提交',
          type: 'error'
        })
      } else {
        this.updateData()
      }
    },
    // 更新活动
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        console.log(this.temp.beginTime)
        // this.temp.beginTime
        if (valid) {
          console.log(this.temp)
          updateActivity(this.temp).then(response => {
            alert('修改成功') // 更新成功，提示
            this.dialogFormVisible = false
            this.$notify({
              title: 'Success',
              message: 'Update Successfully',
              type: 'success',
              duration: 2000
            })
            setTimeout(() => {
              this.listLoading = false
            }, 1.5 * 1000)
            this.getList()
          })
        }
      })
    },

    // 删除操作
    handleDelete(row, index) {
      deleteActivity(row).then(response => {
        alert('删除成功') // 操作成功，提示
        this.$notify({
          title: 'Success',
          message: 'Delete Successfully',
          type: 'success',
          duration: 2000
        })
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
        this.getList()
      })
      this.list.splice(index, 1)
    },
    // handleFetchPv(pv) {
    //   fetchPv(pv).then(response => {
    //     this.pvData = response.data.pvData
    //     this.dialogPvVisible = true
    //   })
    // },

    // 导出数据
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['ID', '活动名称', '活动类型', '活动图片', '创建时间', '开始时间', '结束时间', '活动状态']
        const filterVal = ['id', 'name', 'type', 'img', 'createTime', 'beginTime', 'endTime', 'status']
        const data = this.formatJson(filterVal)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: 'shopActivity-list'
        })
        this.downloadLoading = false
      })
    },
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        if (j === 'createTime') {
          return parseTime(v[j])
        } else if (j === 'beginTime') {
          return parseTime(v[j])
        } else if (j === 'endTime') {
          return parseTime(v[j])
        } else {
          return v[j]
        }
      }))
    },
    // 排序
    getSortClass: function(key) {
      const sort = this.listQuery.sort
      return sort === `+${key}` ? 'ascending' : 'descending'
    }
  }
}
</script>
