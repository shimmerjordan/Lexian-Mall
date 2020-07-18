<template>
  <div class="app-container">
    <div style="margin:0 0 5px 20px;color: #1890FF;">
      点击显示角色对应成员
    </div>
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
