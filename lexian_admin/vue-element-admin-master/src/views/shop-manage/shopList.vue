<template>
  <!-- 店铺列表展示 -->
  <div class="app-container">
    <!-- 当列表未有店铺被选中时，展示此 -->
    <div v-if="!selectShops.length" class="filter-container">
      <el-row>
        <!-- 页面搜索框 -->
        <el-input v-model="listQuery.id" placeholder="店铺ID" style="width: 200px; margin-right:20px" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        <el-input v-model="listQuery.name" placeholder="店铺名称" style="width: 200px; margin-right:20px" class="filter-item" clearable @keyup.enter.native="handleFilter" />
        <el-select v-model="listQuery.status" placeholder="店铺状态" class="filter-item" style="width: 130px; margin-right:20px" clearable>
          <el-option v-for="item in statusOptions" :key="item.key" :label="item.display_name+'('+item.key+')'" :value="item.key" />
        </el-select>
        <!-- 时间段内查询，获取在此时间段内开店的店铺 -->
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

      <el-row>
        <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
          查找
        </el-button>
        <el-button class="filter-item" style="margin-left: 10px;" type="primary" icon="el-icon-edit" @click="handleCreate">
          新增
        </el-button>
        <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">
          导出
        </el-button>
        <el-checkbox v-model="showDescription" class="filter-item" style="margin-left:15px;" @change="tableKey=tableKey+1">
          门店描述
        </el-checkbox>
      </el-row>
    </div>
    <!-- 当列表选中超过一个时，显示此 -->
    <div v-else class="filter-container order-operation-meun">
      <el-row>
        <!-- 展示此时被选中店铺的个数 -->
        <el-col :span="2">
          已选中<span style="color: #13c19f">{{ selectShops.length }}</span>项
        </el-col>
        <el-col :span="1">
          |
        </el-col>
        <el-button :span="2" type="success" @click="updateStatus0">
          <i class="fa fa-trash fa-lg" /> 确认开店
        </el-button>
        <el-button :span="2" type="info" @click="updateStatus1">
          <i class="fa fa-trash fa-lg" /> 店铺休息
        </el-button>
        <el-button :span="2" type="danger" @click="updateStatus2">
          <i class="fa fa-trash fa-lg" /> 关闭店铺
        </el-button>
      </el-row>
    </div>
    <!-- 店铺信息列表 -->
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
      <el-table-column label="ID" prop="id" sortable align="center" width="80" :class-name="getSortClass('id')">
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
          <!-- 对从数据库中取出的时间格式进行转换 -->
          <span>{{ row.establishTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <!-- 当点击显示门店描述时才可显示此列 -->
      <el-table-column v-if="showDescription" label="门店描述" width="110px" align="center">
        <template slot-scope="{row}">
          <span style="color:gray;">{{ row.description }}</span>
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
      <!-- 转换数据库中存储状态的值 -->
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
          <!-- 操作按钮设置 -->
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            编辑
          </el-button>
          <el-button size="mini" type="danger" @click="handleDelete(row,$index)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />
    <!-- 当点击编辑时弹出此弹框，对店铺信息进行编辑 -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="ID" prop="ID">
          <!-- 店铺id不可更改，设置为disabled -->
          <el-input v-model="temp.id" :disabled="true" />
        </el-form-item>
        <!-- 开店时间不可更改 -->
        <el-form-item label="开店日期" prop="establishTime">
          <span style="color:darkolivegreen;font-weight:bold">{{ temp.establishTime | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </el-form-item>
        <el-form-item label="店铺名称" prop="name">
          <el-input v-model="temp.name" />
        </el-form-item>
        <el-form-item label="店铺状态">
          <el-select v-model="temp.status" class="filter-item" placeholder="请选择店铺状态">
            <el-option v-for="item in statusList" :key="item.value" :label="item.label" :value="item.value" />
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
        <!-- 店铺图片不可更改 -->
        <el-form-item label="店铺图片">
          <img :src="temp.img" width="200px" height="200px" align="center">
        </el-form-item>
        <el-form-item label="店铺描述" prop="description">
          <el-input v-model="temp.description" />
        </el-form-item>
      </el-form>
      <!-- 店铺信息操作 -->
      <div slot="footer" class="dialog-footer">
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
// import { fetchPv } from '@/api/article'
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import Pagination from '@/components/Pagination' // 分页

import { getAllShop, updateShop, deleteShop, updateShopStatus0, updateShopStatus1, updateShopStatus2 } from '@/api/shop'

// 店铺状态
const statusOptions = [
  { key: '0', display_name: '正在营业' },
  { key: '1', display_name: '暂停营业' },
  { key: '2', display_name: '关闭店铺' }

]
// 转换成可展示
// const statusKeyValue = statusOptions.reduce((acc, cur) => {
//   acc[cur.key] = cur.display_name
//   return acc
// }, {})

export default {
  name: 'ShopList',
  components: { Pagination },
  directives: { waves },
  // filters: {
  //   typeFilter(type) {
  //     return statusKeyValue[type]
  //   }
  // },
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
        id: '',
        name: '',
        status: '',
        beginTime: '',
        endTime: '',
        // img: null,
        sort: '+id'
      },
      // 店铺营业状态
      statusList: [{ label: '正在营业', value: 0 }, { label: '暂停营业', value: 1 }, { label: '店铺关闭', value: 2 }],
      statusOptions,
      // 店铺类型
      kindOptions: ['旗舰店', '自营店', '普通店', '进口店'],
      // 店铺标签选择
      tagOptions: ['服饰', '食品', '日常用品', '电子产品'],
      showDescription: false,
      temp: {
        id: undefined,
        name: undefined,
        timestamp: new Date(),
        kind: '',
        img: '',
        status: '0',
        description: ''
      },
      dialogFormVisible: false,
      dialogStatus: '',
      textMap: {
        update: '编辑'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {},
      downloadLoading: false,
      selectShops: [],
      selectShopid: [],
      // 选择时间段，将开始时间与结束时间分开为两个参数后，写入查询数据中
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
        // 日期选择框配件
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
    this.getList()
  },
  methods: {
    // 获取店铺列表
    getList() {
      this.listLoading = true
      // try{
      getAllShop(this.listQuery).then(response => {
        console.log(this.listQuery)
        this.list = response.data.list // 获取取到的数据
        this.total = response.data.total
        console.log(this.list)
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
      this.listLoading = false
      //  if(this.listLoading){
      //    this.$message({
      //     message: '请求数据库错误',
      //     type:'error'
      //   })
      // }
      // }catch(e){
      //   this.$message({
      //     message: '请求数据库错误',
      //     type:'error'
      //   })
      // }
    },

    handleFilter() {
      // console.log(this.listQuery.sort)
      this.listQuery.page = 1
      this.getList()
    },
    // 获取排序的值
    sortChange(data) {
      const { prop, order } = data
      // console.log(prop)
      if (prop === 'id') {
        this.sortByID(order)
      }
    },
    // 根据id排序，+id正序，-id倒序
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = '+id'
      } else {
        this.listQuery.sort = '-id'
      }
      this.handleFilter()
    },
    // 点击新增时，跳转到新增店铺页面
    handleCreate() {
      this.$nextTick(() => {
        this.$router.push({ path: 'add-shop' })
        // this.jump({path: '/shop/add-shop'});
      })
    },
    // 点击编辑按钮时，弹出弹窗，并将信息展示出
    handleUpdate(row) {
      this.temp = Object.assign({}, row) // copy obj
      // this.temp.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    // 审核提交更新店铺信息
    update() {
      console.log(this.temp)
      const nam = this.temp.name
      const des = this.temp.description
      if (nam === '' || des === '') {
        this.$message({
          message: '请将更改店铺信息填写完整后，再次尝试提交',
          type: 'error'
        })
      } else {
        this.updateData()
      }
    },
    // 更新店铺信息
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          updateShop(this.temp).then(response => {
            alert('修改成功') // 修改信息成功后，弹出提示
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
            this.getList()// 更新完店铺信息后，对店铺列表进行刷新
          })
        }
      })
    },
    // 删除店铺信息
    handleDelete(row, index) {
      //  console.log(row)
      deleteShop(row).then(response => {
        alert('删除成功') // 操作成功后，弹出提示框
        this.$notify({
          title: 'Success',
          message: 'Delete Successfully',
          type: 'success',
          duration: 2000
        })
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
      this.list.splice(index, 1)// 在展示列表中删除这一行
    },

    // handleFetchPv(pv) {
    //   fetchPv(pv).then(response => {
    //     this.pvData = response.data.pvData
    //     this.dialogPvVisible = true
    //   })
    // },

    // 导出表格信息
    handleDownload() {
      this.downloadLoading = true
      import('@/vendor/Export2Excel').then(excel => {
        const tHeader = ['id', '店铺名称', '店铺图片', '开店日期', '店铺类型', '标签', '当前状态']
        const filterVal = ['id', 'name', 'img', 'establishTime', 'kind', 'tag', 'status']
        const data = this.formatJson(filterVal)
        excel.export_json_to_excel({
          header: tHeader,
          data,
          filename: 'shop-list'
        })
        this.downloadLoading = false
      })
    },
    formatJson(filterVal) {
      return this.list.map(v => filterVal.map(j => {
        if (j === 'establishTime') {
          return parseTime(v[j])
        } else {
          return v[j]
        }
      }))
    },
    // 排序
    getSortClass: function(key) {
      const sort = this.listQuery.sort
      // console.log('sort)
      return sort === `+${key}` ? 'ascending' : 'descending'
    },

    // 列表选择的数据
    handleSelection(selection, row) {
      this.selectShops = selection
      console.log(this.selectShops)
    },
    // 全选的数据
    handleSelectionAll(selection) {
      this.selectShops = selection
    },

    // 批量更新店铺状态为正在营业
    updateStatus0() {
      updateShopStatus0(this.selectShops).then(response => {
        alert('开店-修改成功') // 修改成功提示
        this.$notify({
          title: 'Success',
          message: 'Update Successfully',
          type: 'success',
          duration: 2000
        })
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
        this.getList() // 重新获取列表信息
      })
    },
    // 批量更新店铺状态为暂停营业
    updateStatus1() {
      updateShopStatus1(this.selectShops).then(response => {
        alert('暂停营业-修改成功') // 修改成功提示
        this.$notify({
          title: 'Success',
          message: 'Update Successfully',
          type: 'success',
          duration: 2000
        })
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
        this.getList() // 重新加载店铺信息
      })
    },
    // 批量更新店铺状态为店铺关闭
    updateStatus2() {
      updateShopStatus2(this.selectShops).then(response => {
        alert('关闭店铺-修改成功')
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
  }
}
</script>
