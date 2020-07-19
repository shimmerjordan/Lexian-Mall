<template>
  <div class="app-container">
    <div class="filter-container">
      <el-input v-model="listQuery.name" placeholder="商品" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <el-select v-model="listQuery.comment" placeholder="评价" clearable style="width: 90px" class="filter-item">
        <el-option v-for="item in importanceOptions" :key="item" :label="item" :value="item" />
      </el-select>
      <el-select v-model="listQuery.status" placeholder="状态" clearable class="filter-item" style="width: 130px">
        <el-option v-for="item in calendarTypeOptions" :key="item.key" :label="item.display_name" :value="item.key" />
      </el-select>
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        Search
      </el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
        Add
      </el-button>
      <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleDownload">
        导出
      </el-button>
    </div>

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
      <el-table-column label="序号" width="50" align="center">
        <template scope="scope">
          <span>{{ scope.$index + 1 }}</span>
        </template>
      </el-table-column>
      <el-table-column v-if="showID" label="ID" prop="id" sortable="custom" align="center" width="80">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="订单日期" width="150px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.date | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="订单描述" min-width="70px">
        <template slot-scope="{row}">
          <span>{{ row.description }}</span>
        </template>
      </el-table-column>
      <el-table-column label="商品名称" width="110px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>

      <el-table-column label="评价" width="80px">
        <template slot-scope="{row}">
          <svg-icon v-for="n in + row.comment" :key="n" icon-class="star" class="meta-item__icon" />
        </template>
      </el-table-column>
      <el-table-column label="价格" align="center" width="130">
        <template slot-scope="{row}">
          <el-row><el-tag type="info">单价：{{ row.price }}</el-tag></el-row>
          <el-row><el-tag type="info">数量：{{ row.quantity }}</el-tag></el-row>
        </template>
      </el-table-column>
      <el-table-column label="当前状态" class-name="status-col" width="130">
        <template slot-scope="{row}">
          <el-tag>
            {{ row.status | statusFilter }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="Actions" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <el-button type="primary" size="mini" @click="handleUpdate(row,$index)">
            编辑
          </el-button>
          <el-button v-if="row.status!='deleted'" size="mini" type="danger" @click="handleDelete(row,$index)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="80px" style="width: 400px; margin-left:50px;">
        <el-form-item label="商品ID" prop="commodity">
          <el-input v-model="temp.commodity" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-select v-model="temp.status" class="filter-item" placeholder="Please select">
            <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="数量" prop="quantity">
          <el-input v-model="temp.quantity" />
        </el-form-item>
        <el-form-item label="日期" prop="date">
          <el-date-picker v-model="temp.date" type="datetime" placeholder="Please pick a date" />
        </el-form-item>
        <el-form-item label="描述" prop="description">
          <el-input v-model="temp.description" />
        </el-form-item>
        <el-form-item label="评价">
          <el-rate v-model="temp.comment" :colors="['#99A9BF', '#F7BA2A', '#FF9900']" :max="3" style="margin-top:8px;" />
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
import { getAllOrder, createOrder, updateOrder, DeleteOrder } from '@/api/order'
import waves from '@/directive/waves' // waves directive
import Pagination from '@/components/Pagination' // secondary package based on el-pagination

const calendarTypeOptions = [
  { key: '1', display_name: '待付款' },
  { key: '2', display_name: '待收货' },
  { key: '3', display_name: '待评价' },
  { key: '4', display_name: '售后' },
  { key: '9', display_name: '已取消' }
]

// 发货状态选择
const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'ComplexTable',
  components: { Pagination },
  directives: { waves },
  // 用来映射搜索框的搜索条件
  filters: {
    statusFilter(status) {
      const statusMap = {
        '1': '待付款',
        '2': '待收货',
        '3': '待评价',
        '4': '售后',
        '9': '已取消'
      }
      return statusMap[status]
    },
    typeFilter(type) {
      return calendarTypeKeyValue[type]
    }
  },
  data() {
    return {
      tableKey: 0,
      // 表格数据
      list: null,
      total: 0,
      // 表示表格数据的加载状态
      listLoading: true,
      // 表格搜索条件
      listQuery: {
        page: 1,
        limit: 10,
        comment: undefined,
        name: undefined,
        status: undefined
      },
      importanceOptions: [1, 2, 3],
      calendarTypeOptions,
      statusOptions: [0, 1, 2, 3, 4],
      showReviewer: false,
      // 记录弹窗的数据
      temp: {
        id: '',
        commodity: undefined,
        comment: 1,
        timestamp: new Date(),
        description: '',
        status: 0,
        quantity: ''
      },
      // 控制弹窗可见
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑',
        create: '新建'
      },
      rules: {
        commodity: [{ required: true, message: '请输入商品ID', trigger: 'change' }],
        timestamp: [{ type: 'date', required: true, message: '请输入时间', trigger: 'change' }],
        status: [{ required: true, message: '请输入订单状态', trigger: 'blur' }],
        quantity: [{ required: true, message: '请输入数量', trigger: 'change' }]
      },
      downloadLoading: false,
      showID: false
    }
  },
  created() {
    this.getList()
  },
  methods: {
    // 根据条件搜索订单，如果无条件则相当于初始化表格
    getList() {
      this.listLoading = true
      getAllOrder(this.listQuery).then(response => {
        this.list = response.data.list
        this.total = response.data.total
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
      this.listLoading = false
    },
    // 根据条件搜索订单
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    // 表格排序
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    // 根据ID排序
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = '+id'
      } else {
        this.listQuery.sort = '-id'
      }
      this.handleFilter()
    },
    // 重置弹窗的数据
    resetTemp() {
      this.temp = {
        comment: 1,
        date: new Date(),
        status: ''
      }
    },
    // 处理Add按钮，新建一条订单数据
    handleCreate() {
      this.resetTemp()
      this.dialogStatus = 'create'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    // 根据弹窗的输入新建订单
    createData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          createOrder(this.temp).then(response => {
            if (response.data) {
              this.$notify({
                title: 'Success',
                message: '成功创建订单',
                type: 'success',
                duration: 2000
              })
            } else {
              this.$notify({
                title: 'Fail',
                message: '订单创建失败',
                type: 'fail',
                duration: 2000
              })
            }
            this.dialogFormVisible = false
            // 在数据库新增了一条订单记录后，重新获取数据，实现自动刷新
            this.getList()
          })
        }
      })
    },
    // 订单的更新请求
    handleUpdate(row, index) {
      this.temp = Object.assign({}, this.list[index])
      this.temp.date = new Date(this.temp.date)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    // 更新订单
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          updateOrder(this.temp).then(response => {
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
            this.getList()
          })
        }
      })
    },
    // 处理删除订单请求
    handleDelete(row, index) {
      console.log(row)
      DeleteOrder(row.id).then(response => {
        if (response.data) {
          this.$notify({
            title: 'Success',
            message: '订单删除成功',
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
      })
      this.list.splice(index, 1)
    },
    // 订单列表导出
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['date', 'description', 'name', 'comment', 'price', 'quantity']
        const filterVal = ['date', 'description', 'name', 'comment', 'price', 'quantity']
        const data = this.formatJson(filterVal)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: 'order-list'
        })
        this.downloadLoading = false
      })
    },
    // 将时间戳转化成时间格式
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        if (j === 'date') {
          return new Date(v[j])
        } else {
          return v[j]
        }
      }))
    }
  }
}
</script>
