<template>
  <div class="app-container">
    <transition name="component-fade" mode="out-in">
      <div v-if="!selectShops.length" class="filter-container">
        <el-input v-model="listQuery.id" placeholder="店铺ID" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
        <el-input v-model="listQuery.importance" placeholder="店铺名称" style="width: 200px" class="filter-item" @keyup.enter.native="handleFilter" />
        <!-- <el-option v-for="item in importanceOptions" :key="item" :label="item" :value="item" /> -->
        <el-select v-model="listQuery.status" placeholder="店铺状态" clearable class="filter-item" style="width: 130px">
          <el-option v-for="item in statusOptions" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />
        </el-select>
        <el-select v-model="listQuery.sort" style="width: 140px" class="filter-item" @change="handleFilter">
          <el-option v-for="item in sortOptions" :key="item.key" :label="item.label" :value="item.key" />
        </el-select>
        <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
          查找
        </el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
          新增
        </el-button>
        <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">
          导出
        </el-button>
        <el-checkbox v-model="showReviewer" class="filter-item" style="margin-left:15px;" @change="tableKey=tableKey+1">
          操作员
        </el-checkbox>
      </div>
      <div v-else class="filter-container order-operation-meun">
        <el-row>
          <el-col :span="2">
            已选中<span style="color: #13c19f">{{ selectShops.length }}</span>项
          </el-col>
          <el-col :span="1">
            |
          </el-col>
          <!-- <el-col :span="2">
            <i class="fa fa-truck fa-lg"></i> 确认开店
          </el-col> -->
          <el-button :span="2" type="success">
            <i class="fa fa-trash fa-lg" /> 确认开店
          </el-button>
          <el-button :span="2" type="info">
            <i class="fa fa-trash fa-lg" /> 店铺休息
          </el-button>
          <el-button :span="2" type="danger">
            <i class="fa fa-trash fa-lg" /> 关闭店铺
          </el-button>
          <!-- <el-col :span="2">
            <i class="fa fa-trash fa-lg"></i> 店铺休息
          </el-col>
          <el-col :span="2">
            <i class="fa fa-trash fa-lg"></i> 关闭店铺
          </el-col> -->
        </el-row>
      </div>
    </transition>

    <el-table
      :key="tableKey"
      v-loading="listLoading"
      :data="list"
      border
      fit
      highlight-current-row
      style="width: 100%;"
      @sort-change="sortChange"
      @select="handleSelection"
      @select-all="handleSelectionAll"
    >
      <el-table-column
        align="center"
        type="selection"
        width="55"
      />
      <el-table-column label="ID" prop="id" sortable="custom" align="center" width="80" :class-name="getSortClass('id')">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
      <el-table-column label="店铺名称" width="110px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>
      <el-table-column label="店铺图片" width="150px" align="center">
        <template slot-scope="{row}">
          <img :src="row.img" width="150px" height="120px" align="center">
        </template>
      </el-table-column>
      <el-table-column label="开店日期" width="150px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.establishTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <el-table-column v-if="showReviewer" label="Reviewer" width="110px" align="center">
        <template slot-scope="{row}">
          <span style="color:red;">{{ row.reviewer }}</span>
        </template>
      </el-table-column>
      <el-table-column label="店铺类型" width="80px">
        <template slot-scope="{row}">
          <span>{{ row.kind }}</span>
        </template>
      </el-table-column>
      <el-table-column label="店铺标签" width="80px">
        <template slot-scope="{row}">
          <span>{{ row.tag }}</span>
        </template>
      </el-table-column>
      <el-table-column label="当前状态" class-name="status-col" width="100">
        <template slot-scope="{row}">
          <el-tag v-if="row.status == 0" type="success">
            正在营业
          </el-tag>
          <el-tag v-if="row.status == 1" type="info">
            暂停营业
          </el-tag>
          <el-tag v-if="row.status == 2" type="danger">
            店铺关闭
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            编辑
          </el-button>
          <el-button size="mini" type="danger" @click="handleDelete(row,$index)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="ID" prop="ID">
          <el-input v-model="temp.id" :disabled="true" />
        </el-form-item>
        <el-form-item label="开店日期" prop="establishTime">
          <span style="color:darkolivegreen;font-weight:bold">{{ temp.establishTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </el-form-item>
        <el-form-item label="店铺名称" prop="name">
          <el-input v-model="temp.name" />
        </el-form-item>
        <el-form-item label="店铺状态">
          <el-select v-model="temp.status" class="filter-item" placeholder="请选择店铺状态">
            <el-option v-for="item in statusOptions" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />
            <!-- <el-option v-for="item in statusOptions" :key="item" :label="item" :value="item" /> -->
          </el-select>
        </el-form-item>
        <el-form-item label="店铺类型">
          <el-select v-model="temp.kind" class="filter-item" placeholder="请选择店铺类型">
            <el-option v-for="item in kindOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="店铺标签">
          <el-select v-model="temp.tag" class="filter-item" placeholder="请选择店铺标签">
            <el-option v-for="item in tagOptions" :key="item" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="店铺图片">
          <img :src="temp.img" width="200px" height="200px" align="center">
        </el-form-item>
        <el-form-item label="店铺描述" prop="description">
          <el-input v-model="temp.description" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
        <el-button type="primary" @click="updateData()">
          提交
        </el-button>
      </div>
    </el-dialog>

    <el-dialog :visible.sync="dialogPvVisible" title="Reading statistics">
      <el-table :data="pvData" border fit highlight-current-row style="width: 100%">
        <el-table-column prop="key" label="Channel" />
        <el-table-column prop="pv" label="Pv" />
      </el-table>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="dialogPvVisible = false">Confirm</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { fetchPv, createArticle } from '@/api/article'
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination

import { getAllShop, updateShop } from '@/api/shop'

const statusOptions = [
  { key: '0', display_name: '正在营业' },
  { key: '1', display_name: '暂停营业' },
  { key: '2', display_name: '关闭店铺' }

]
// const calendarTypeOptions = [
//   { key: 'CN', display_name: 'China' },
//   { key: 'US', display_name: 'USA' },
//   { key: 'JP', display_name: 'Japan' },
//   { key: 'EU', display_name: 'Eurozone' }
// ]

// arr to obj, such as { CN : "China", US : "USA" }
const statusKeyValue = statusOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'ShopList',
  components: { Pagination },
  directives: { waves },
  filters: {
    typeFilter(type) {
      return statusKeyValue[type]
    }
  },
  data() {
    return {
      tableKey: 0,
      list: null,
      total: 0,
      listLoading: true,
      listQuery: {
        page: 1,
        limit: 20,
        importance: undefined,
        title: undefined,
        type: undefined,
        sort: '+id'
      },
      status: [{ label: '正在营业', key: '0' }, { label: '暂停营业', key: '1' }, { label: '店铺关闭', key: '2' }],
      statusOptions,
      sortOptions: [{ label: 'ID 递增排序', key: '+id' }, { label: 'ID 递减排序', key: '-id' }],
      // statusOptions: ['正在营业', '暂停营业', '关闭店铺'],
      kindOptions: ['旗舰店', '自营店', '普通店', '进口店'],
      tagOptions: ['服饰', '食品', '日常用品'],
      showReviewer: false,
      temp: {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        type: '',
        status: '0'
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑',
        create: 'Create'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        type: [{ required: true, message: 'type is required', trigger: 'change' }],
        timestamp: [{ type: 'date', required: true, message: 'timestamp is required', trigger: 'change' }],
        title: [{ required: true, message: 'title is required', trigger: 'blur' }]
      },
      downloadLoading: false,
      selectShops: []
    }
  },
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      getAllShop().then(response => {
        this.list = response.data
        this.total = 100
        console.log(this.list)
        // Just to simulate the time of the request
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
      this.listLoading = false
    },
    handleFilter() {
      this.listQuery.page = 1
      this.getList()
    },
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = '+id'
      } else {
        this.listQuery.sort = '-id'
      }
      this.handleFilter()
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        status: '0',
        type: ''
      }
    },
    handleCreate() {
      // this.resetTemp()
      // this.dialogStatus = 'create'
      // this.dialogFormVisible = true
      this.$nextTick(() => {
        // this.$refs['dataForm'].clearValidate()
        this.$router.push({ path: 'add-shop' })
        // this.jump({path: '/shop/add-shop'});
      })
    },
    createData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          this.temp.id = parseInt(Math.random() * 100) + 1024 // mock a id
          this.temp.author = 'vue-element-admin'
          createArticle(this.temp).then(() => {
            this.list.unshift(this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: 'Success',
              message: 'Created Successfully',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      // this.temp.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          // tempData.timestamp = +new Date(tempData.timestamp) // change Thu Nov 30 2017 16:41:05 GMT+0800 (CST) to 1512031311464
          updateShop(this.temp).then(response => {
            alert('修改成功')
            // const index = this.list.findIndex(v => v.id === this.temp.id)
            // this.list.splice(index, 1, this.temp)
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
          })
        }
      })
      this.getList()
    },
    handleDelete(row, index) {
      this.$notify({
        title: 'Success',
        message: 'Delete Successfully',
        type: 'success',
        duration: 2000
      })
      this.list.splice(index, 1)
    },
    handleFetchPv(pv) {
      fetchPv(pv).then(response => {
        this.pvData = response.data.pvData
        this.dialogPvVisible = true
      })
    },
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['timestamp', 'title', 'type', 'importance', 'status']
        const filterVal = ['timestamp', 'title', 'type', 'importance', 'status']
        const data = this.formatJson(filterVal)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: 'table-list'
        })
        this.downloadLoading = false
      })
    },
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        if (j === 'timestamp') {
          return parseTime(v[j])
        } else {
          return v[j]
        }
      }))
    },
    getSortClass: function(key) {
      const sort = this.listQuery.sort
      return sort === `+${key}` ? 'ascending' : 'descending'
    },
    handleSelection(selection, row) {
      this.selectShops = selection
    },
    handleSelectionAll(selection) {
      this.selectShops = selection
    }
  }
}
</script>
