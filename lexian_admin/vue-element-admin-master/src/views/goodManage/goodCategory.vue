<template>
  <div class="app-container" left="100px">
    <div align="center" style="font-size:24px;color:red">商品分类详情</div>
    <el-table :data="categoryList" style="width: 800px;margin-top:30px;margin-left:250px" border>
      <el-table-column align="center" label="类别编号" width="100px">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="类别名称" width="200px">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <!-- <el-table-column align="center" label="图片路径">
        <template slot-scope="scope">
          {{ scope.row.description }}
        </template>
      </el-table-column> -->
      <el-table-column align="center" label="级别" width="250px">
        <template slot-scope="scope">
          <el-tag v-if="scope.row.level==0" type="success">
            一级类别
          </el-tag>
          <el-tag v-if="scope.row.level==1" type="danger">
            二级类别
          </el-tag>
          <el-tag v-if="scope.row.level==2" type="info">
            三级类别
          </el-tag>
          <el-tag v-if="scope.row.level==3" type="warning">
            四级类别
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column align="center" label="操作" width="250px">
        <template slot-scope="scope">
          <el-button type="primary" size="small" @click="handleWatch(scope)">查看商品</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getAllCategory } from '@/api/shopGood'

const defaultRole = {
  key: '',
  name: '',
  description: '',
  routes: []
}

export default {
  data() {
    return {
      role: Object.assign({}, defaultRole),
      routes: [],
      categoryList: [],
      dialogVisible: false,
      dialogType: 'new',
      checkStrictly: false,
      defaultProps: {
        children: 'children',
        label: 'title'
      }
    }
  },
  computed: {
    routesData() {
      return this.routes
    }
  },
  created() {
    // 创建页面调用获取商品类别方法
    this.getCategory()
  },
  methods: {
    // 获取所有的数据库中的商品类别
    getCategory() {
      this.listLoading = true
      getAllCategory().then(response => {
        this.categoryList = response.data
        console.log(this.categoryList)
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
      this.listLoading = false
    },
    handleWatch() {
      this.$router.push('/goodManage/categoryGood')
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
