<template>
  <div class="components-container">
    <div :span="12">
      <pan-thumb :image="user.avatar" />
      <!-- <pan-thumb >
        <image src="@/assets/test-images/test.jpg" width="100px">
      </pan-thumb> -->

      <el-button type="primary" icon="el-icon-upload" style="margin-left: 40px;" @click="imagecropperShow=true">
        更换头像
      </el-button>
      <el-button type="info" icon="el-icon-back" style="margin-left: 40px;" @click="goBack()">
        返回管理中心
      </el-button>

      <image-cropper
        v-show="imagecropperShow"
        :key="imagecropperKey"
        :width="300"
        :height="300"
        url="https://httpbin.org/post"
        lang-type="en"
        @close="close"
        @crop-upload-success="cropSuccess"
      />
    </div>
    <div>
      <el-form>
        <el-form-item label="Name">
          <el-input v-model.trim="user.name" />
        </el-form-item>
        <el-form-item label="Email">
          <el-input v-model.trim="user.email" />
        </el-form-item>
      </el-form>
    </div>

    <div>
      <el-button type="success" plain :span="4" @click="submit()">更新</el-button>
      <el-button type="primary" plain :span="4" @click="goBack()">取消</el-button>
      <el-button type="danger" plain :span="4" @click="del()">注销</el-button>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'

export default {
  name: 'Info',
  components: { ImageCropper, PanThumb },
  data() {
    return {
      imagecropperShow: false,
      imagecropperKey: 0,
      // image: 'https://wpimg.wallstcn.com/577965b9-bb9e-4e02-9f0c-095b41417191',
      user: {}
    }
  },
  computed: {
    ...mapGetters([
      'name',
      'avatar',
      'roles'
    ])
  },
  created() {
    this.getUser()
  },
  methods: {
    cropSuccess(resData) {
      this.imagecropperShow = false
      this.imagecropperKey = this.imagecropperKey + 1
      this.image = resData.files.avatar
    },
    close() {
      this.imagecropperShow = false
    },
    getUser() {
      this.user = {
        name: this.name,
        role: this.roles.join(' | '),
        email: 'admin@test.com',
        avatar: this.avatar
      }
    },
    goBack() {
      this.$router.push('dashboard')
    },
    submit() {

    },
    del() {

    }
  }
}
</script>

<style scoped>
  .avatar{
    width: 200px;
    height: 200px;
    border-radius: 50%;
  }
</style>

