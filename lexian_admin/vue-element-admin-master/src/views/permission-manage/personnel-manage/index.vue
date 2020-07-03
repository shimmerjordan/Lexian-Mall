<template>
  <div class="app-container">
    <el-row>
      <el-col :span="20">
        <div style="margin:0 0 5px 20px;color: #1890FF;">
          点击显示角色对应成员
        </div>
      </el-col>
      <el-col :span="4">
        <el-button type="primary">添加新成员</el-button>
      </el-col>
    </el-row>
    <fixed-thead />
  </div>
</template>

<script>
import FixedThead from './components/FixedThead'

export default {
  name: 'DynamicTable',
  components: { FixedThead }
}
</script>
