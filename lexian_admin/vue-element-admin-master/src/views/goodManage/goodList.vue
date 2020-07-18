<template>
  <div class="app-container">

    <!--页面上方的两个功能按钮：搜索按钮、导出按钮-->
    <div class="filter-container">
      <el-input v-model="listQuery.name" placeholder="商品名称" style="width: 200px;" class="filter-item" @keyup.enter.native="handleFilter" />
      <el-button v-waves class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">
        搜索
      </el-button>
      <el-button v-waves :loading="downloadLoading" class="filter-item" type="primary" icon="el-icon-download" @click="handleDownload">
        导出
      </el-button>
      <!--商品描述是否展示-->
      <el-checkbox v-model="showReviewer" class="filter-item" style="margin-left:15px;" @change="tableKey=tableKey+1">
        商品描述
      </el-checkbox>
    </div>

    <!--
      类别对应的商品列表展示
      绑定的数据是list->根据api请求的response获取data
    -->
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
      <!--获取商品对应id的列-->
      <el-table-column label="ID" prop="ID" sortable="custom" align="center" width="80" :class-name="getSortClass('ID')">
        <template slot-scope="{row}">
          <span>{{ row.id }}</span>
        </template>
      </el-table-column>
      <!--商品的修改时间列-->
      <el-table-column label="商品修改日期" width="165px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.modify_time | parseTime('{y}-{m}-{d} {h}:{i}') }}</span>
        </template>
      </el-table-column>
      <!--商品的图片获取-->
      <el-table-column label="商品图片" width="170px" align="center">
        <template slot-scope="{row}">
          <img :src="row.image" width="80px" height="80px" align="center">
        </template>
        <!--商品名称展示-->
      </el-table-column>
      <el-table-column label="商品名称" width="180px" align="center">
        <template slot-scope="{row}">
          <span>{{ row.name }}</span>
        </template>
      </el-table-column>
      <!--商品描述展示-->
      <el-table-column v-if="showReviewer" label="商品描述" width="180px" align="center">
        <template slot-scope="{row}">
          <span style="color:red;">{{ row.introduction }}</span>
        </template>
      </el-table-column>
      <!--商品单价展示-->
      <el-table-column label="商品单价" align="center" width="100px">
        <template slot-scope="{row}">
          <span>{{ row.price }}</span>
        </template>
      </el-table-column>
      <!--商品库存展示-->
      <el-table-column label="库存" align="center" width="100px">
        <template slot-scope="{row}">
          <span style="color:red;">{{ row.storage }}</span>
        </template>
      </el-table-column>
      <!--商品规格展示-->
      <el-table-column label="规格" align="center" width="100px">
        <template slot-scope="{row}">
          <span>{{ row.specification }}</span>
        </template>
      </el-table-column>
      <!--商品状态展示-->
      <el-table-column label="当前状态" class-name="status-col" width="100">
        <template slot-scope="{row}">
          <!--用v-if来控制tag的type属性 如果status为1说明已上架状态 type为success-->
          <el-tag v-if="row.status==1" type="success">
            已上架
          </el-tag>
          <!--如果status为0 代表下架状态 type为danger-->
          <el-tag v-if="row.status==0" type="danger">
            已下架
          </el-tag>
        </template>
      </el-table-column>

      <!--最后一列添加两个按钮 编辑商品和删除商品-->
      <el-table-column label="操作" align="center" width="230" class-name="small-padding fixed-width">
        <template slot-scope="{row,$index}">
          <!--编辑按钮绑定handleUpdate方法 传的参数为当前行的商品数据内容-->
          <el-button type="primary" size="mini" @click="handleUpdate(row)">
            编辑
          </el-button>‘
          <!--删除按钮绑定handleDelete方法 传的参数是当前行的商品数据内容-->
          <el-button v-if="row.status!='deleted'" size="mini" type="danger" @click="handleDelete(row,$index)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!--
      用于分页的组件 绑定的是listQuery中的page,limit属性，并且绑定了getList方法
      当点击新的page或者limit发剩变化，调用getList方法重新从数据库获取数据
    -->
    <pagination v-show="total>0" :total="total" :page.sync="listQuery.page" :limit.sync="listQuery.limit" @pagination="getList" />

    <!--
      这里对应的是上面编辑按钮的弹窗
      编辑按钮调用handleUpdate方法，方法中将dialogFormVisible状态进行改变 弹窗就可弹出
    -->
    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible">
      <!--
        表格数据绑定temp 如果确认修改向后端传dataForm
        初始是编辑行的商品数据
      -->
      <el-form ref="dataForm" :rules="rules" :model="temp" label-position="left" label-width="80px" style="width: 400px; margin-left:50px;">
        <!--将要编辑的商品数据进行展示-->
        <el-form-item label="商品名称" prop="name">
          <el-input v-model="temp.name" />
        </el-form-item>
        <el-form-item label="修改时间" prop="modify_time">
          <el-date-picker v-model="temp.modify_time" type="datetime" placeholder="Please pick a date" />
        </el-form-item>
        <el-form-item label="商品库存" prop="storage">
          <el-input v-model="temp.storage" />
        </el-form-item>
        <el-form-item label="商品单价" prop="price">
          <el-input v-model="temp.price" class="filter-item" />
        </el-form-item>
        <el-form-item label="商品描述">
          <el-input v-model="temp.introduction" :autosize="{ minRows: 2, maxRows: 4}" type="textarea" placeholder="Please input" />
        </el-form-item>
      </el-form>
      <!--两个功能按钮 确认修改和取消修改-->
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          取消修改
        </el-button>
        <!--确认修改调用updateData方法-->
        <el-button type="primary" @click="updateData()">
          确认修改
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
import waves from '@/directive/waves' // waves directive
import { parseTime } from '@/utils'
import { getAllShopGoods, UpdateShopGood, DeleteShopGood } from '@/api/shopGood'
import Pagination from '@/components/Pagination'

// 商品的几种状态
const calendarTypeOptions = [
  { key: '已上架', display_name: '已上架' },
  { key: '已下架', display_name: '已下架' },
  { key: '无库存', display_name: '无库存' }
]

const calendarTypeKeyValue = calendarTypeOptions.reduce((acc, cur) => {
  acc[cur.key] = cur.display_name
  return acc
}, {})

export default {
  name: 'GoodList',
  components: { Pagination },
  directives: { waves },
  filters: {
    statusFilter(status) {
      const statusMap = {
        published: 'success',
        draft: 'info',
        deleted: 'danger'
      }
      return statusMap[status]
    },
    typeFilter(type) {
      return calendarTypeKeyValue[type]
    }
  },
  data() {
    return {
      tableKey: 1,
      list: null,
      // 后台返回的商品总数保存
      total: 0,
      listLoading: true,
      // listQuery保存当前页码、页面数据量限制、模糊查询的商品名字
      listQuery: {
        page: 1,
        limit: 10,
        name: '',
        importance: undefined,
        title: undefined,
        type: undefined,
        sort: '+id'
      },
      importanceOptions: [1, 2, 3],
      calendarTypeOptions,
      sortOptions: [{ label: 'ID 递增排序', key: '+id' }],
      statusOptions: ['published', 'draft', 'deleted'],
      showReviewer: false,
      // 弹窗的数据保存
      temp: {
        id: undefined,
        importance: 1,
        remark: '',
        timestamp: new Date(),
        title: '',
        type: '',
        status: 'published'
      },
      // 弹窗是否可见
      dialogFormVisible: false,
      dialogStatus: '',
      // 弹窗的文字内容
      textMap: {
        update: '商品编辑',
        create: '添加商品'
      },
      dialogPvVisible: false,
      pvData: [],
      rules: {
        type: [{ required: true, message: 'type is required', trigger: 'change' }],
        timestamp: [{ type: 'date', required: true, message: 'timestamp is required', trigger: 'change' }],
        title: [{ required: true, message: 'title is required', trigger: 'blur' }]
      },
      downloadLoading: false
    }
  },
  // 页面创建调用getList方法去数据库取商品数据
  created() {
    this.getList()
  },
  methods: {
    getList() {
      this.listLoading = true
      // 调用api中的getAllShopGoods（参数是listQuery-->包含页面、页面数量等信息方便分页）
      getAllShopGoods(this.listQuery).then(response => {
        // 返回数据保存在list中 商品数量保存在total中
        this.list = response.data.list
        this.total = response.data.total
        console.log(this.list)
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
    /*
      数据排序
    */
    sortChange(data) {
      const { prop, order } = data
      if (prop === 'ID') {
        this.sortByID(order)
      }
    },
    /*
      格局id进行排序
    */
    sortByID(order) {
      if (order === 'ascending') {
        this.listQuery.sort = '+id'
      } else {
        this.listQuery.sort = '-id'
      }
      this.handleFilter()
    },
    /*
      handleUpdate方法是用于商品信息编辑
      传的参数是当前行的商品信息
      将当前行的商品信息赋值给temp(弹窗绑定的数据)
      将弹窗的dialogFormVisible设为true即可弹出弹窗
    */
    handleUpdate(row) {
      this.temp = Object.assign({}, row)
      this.temp.timestamp = new Date(this.temp.timestamp)
      this.dialogStatus = 'update'
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
    },
    /*
      更新数据方法 点击确认修改后调用
      调用api下的UpdateShopGood方法（参数是当前弹窗中的temp数据 即修改后的商品数据）
      修改成功后 弹出修改成功 并将弹窗设为不可见即可
    */
    updateData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          UpdateShopGood(this.temp).then(response => {
            alert('修改成功')
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
      // 用于实时动态更新数据 修改数据后就调用getList从数据库中取到新的数据展示
      this.getList()
    },
    /*
      删除商品数据
      调用api中的DeleteShopGood方法（参数该行的商品数据）
    */
    handleDelete(row, index) {
      DeleteShopGood(row).then(response => {
        // 成功后弹窗提示成功
        alert('删除成功')
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
      this.list.splice(index, 1)
    },
    /*
      导出按钮功能实现
      数据导出为excel表格
    */
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
    }
  }
}
</script>
