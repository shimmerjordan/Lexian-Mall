<template>
  <div class="components-container">
    <div :span="12">
      <pan-thumb :image="user_image" />
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
      <el-form :data="user">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="user.name" />
        </el-form-item>
        <el-form-item label="登录名称" prop="login_name">
          <el-input v-model="user.login_name" />
        </el-form-item>
        <el-form-item label="登录密码" prop="pwd">
          <el-input v-model="user.pwd" :type="passw">
            <i slot="suffix" :class="icon" @click="showPass" />
          </el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="user.sex">
            <el-radio
              v-for="item in sexList"
              :key="item.label"
              :label="item.label"
              :value="item.label"
            >
              {{ item.label }}
            </el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="出生日期" prop="birthday">
          <el-date-picker
            v-model="user.birthday"
            type="date"
            unlink-panels
            :picker-options="pickerOptions"
          />
        </el-form-item>
        <el-form-item label="联系电话" prop="phone">
          <el-input v-model="user.phone" />
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
// import { mapGetters } from 'vuex'
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'
import { searchShopManager, updateShopManager, deleteShopManager } from '@/api/shopManager'

export default {
  name: 'Info',
  components: { ImageCropper, PanThumb },
  data() {
    return {
      // identity: '系统管理员',
      //  id: 1,
      passw: 'password',
      icon: 'el-icon-view',
      temp: { identity: '店铺管理员', id: 2 },
      user_image: 'https://wpimg.wallstcn.com/577965b9-bb9e-4e02-9f0c-095b41417191',
      sexList: [{ label: '男', value: 0 }, { label: '女', value: 1 }],
      imagecropperShow: false,
      imagecropperKey: 0,
      // image: 'https://wpimg.wallstcn.com/577965b9-bb9e-4e02-9f0c-095b41417191',
      user: {
        id: '',
        name: undefined,
        login_name: undefined,
        pwd: undefined,
        sex: '',
        birthday: undefined,
        phone: undefined
      },
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now() - 8.64e6
        }
      }
    }
  },
  computed: {
    // ...mapGetters([
    //   'name',
    //   'avatar',
    //   'roles'
    // ])
  },
  created() {
    this.getUser()
  },
  methods: {
    showPass() {
      if (this.passw === 'text') {
        this.passw = 'password'
        this.icon = 'el-icon-view'
      } else {
        this.passw = 'text'
        this.icon = 'el-icon-finished'
      }
    },
    cropSuccess(resData) {
      this.imagecropperShow = false
      this.imagecropperKey = this.imagecropperKey + 1
      this.image = resData.files.avatar
    },
    close() {
      this.imagecropperShow = false
    },
    getUser() {
      console.log(this.temp)
      searchShopManager(this.temp).then(response => {
        this.user = response.data[0]
        this.user_image = response.data[0].user_image
      })
      // this.user = {
      //   name: this.name,
      //   role: this.roles.join(' | '),
      //   email: 'admin@test.com',
      //   avatar: this.avatar
      // }
    },
    goBack() {
      this.$router.push('dashboard')
    },
    submit() {
      // this.$refs['dataForm'].validate((valid) => {
      //   if(valid) {
      this.user.id = this.temp.id
      console.log(this.user)
      updateShopManager(this.user).then(response => {
        alert('修改成功')
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
      // }
      //  })
      //  this.getUser()
    },
    del() {
      this.user.id = this.temp.id
      deleteShopManager(this.user).then(response => {
        alert('删除成功')
        this.$notify({
          title: 'Sucess',
          message: 'Delete Sucessfully',
          type: 'success',
          duration: 2000
        })
        setTimeout(() => {
          this.listLoading = false
        }, 1.5 * 1000)
      })
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

