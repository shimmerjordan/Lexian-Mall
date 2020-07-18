<template>
  <div class="app-container">
    <div style="margin:0 0 5px 20px;color: #1890FF;">
      点击显示角色对应成员
    </div>
    <member-list />
  </div>
</template>

<script>
import MemberList from './components/memberList'

export default {
  name: 'DynamicTable',
  components: { MemberList }
}
</script>
