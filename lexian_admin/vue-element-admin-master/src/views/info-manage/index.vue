<template>
  <div class="components-container">
    <div :span="12">
      <pan-thumb :image="user_image" />
      <!-- <pan-thumb >
        <image src="@/assets/test-images/test.jpg" width="100px">
      </pan-thumb> -->
      <!-- 个人中心界面  -->
      <el-button type="primary" icon="el-icon-upload" style="margin-left: 40px;" @click="imagecropperShow=true">
        更换头像
      </el-button>
      <el-button type="info" icon="el-icon-back" style="margin-left: 40px;" @click="goBack()">
        返回管理中心
      </el-button>

      <!-- 头像展示 -->
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
      <!-- 表单元素，展示对应id下的个人信息，并根据用户意愿对其信息进行更新注销等操作-->
      <el-form :data="user">
        <el-form-item label="" />
        <el-form-item label="用户姓名" prop="name">
          <el-input v-model="user.name" style="width:500px" />
        </el-form-item>
        <el-form-item label="登录名称" prop="login_name">
          <el-input v-model="user.login_name" style="width:500px" />
        </el-form-item>
        <el-form-item label="登录密码" prop="pwd">
          <el-input v-model="user.pwd" :type="passw" style="width:500px">
            <!-- 设置密码可见方法，使用户可以对自己的密码进行查看 -->
            <i slot="suffix" :class="icon" @click="showPass" />
          </el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex" style="150px">
          <!-- 单一选项 -->
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
            style="width:500px"
          />
        </el-form-item>
        <el-form-item label="联系电话" prop="phone">
          <el-input v-model="user.phone" style="width:500px" />
        </el-form-item>

      </el-form>
    </div>

    <div>
      <el-button type="success" plain @click="submit()">更新</el-button>
      <el-button type="primary" plain :span="4" @click="goBack()">取消</el-button>
      <el-button type="danger" plain :span="4" @click="del()">注销</el-button>
    </div>
  </div>
</template>

<script>
import ImageCropper from '@/components/ImageCropper'
import PanThumb from '@/components/PanThumb'
import { searchShopManager, updateShopManager, deleteShopManager } from '@/api/shopManager'

export default {
  name: 'Info',
  components: { ImageCropper, PanThumb },
  data() {
    return {
      // 数据初始化
      passw: 'password',
      icon: 'el-icon-view',
      temp: { identity: '店铺管理员', id: 1 },
      user_image: ' ',
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
      // 日期选择限制，用户更新的生日不可晚于系统当天
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
    // 根据用户选择对密码的可见进行展示，当密码输入框为text格式时，点击icon则对密码进行隐藏，否则点击icon时，密码格式则为text格式
    showPass() {
      if (this.passw === 'text') {
        this.passw = 'password'
        this.icon = 'el-icon-view'
      } else {
        this.passw = 'text'
        this.icon = 'el-icon-finished'
      }
    },
    // 头像上传
    cropSuccess(resData) {
      this.imagecropperShow = false
      this.imagecropperKey = this.imagecropperKey + 1
      this.image = resData.files.avatar
    },
    close() {
      this.imagecropperShow = false
    },
    // 获取该id对应下的管理员信息
    getUser() {
      console.log(this.temp)
      searchShopManager(this.temp).then(response => {
        this.user = response.data[0]
        this.user_image = response.data[0].user_image
      })
      // this.$message({
      //   message:'请求数据库错误',
      //   type:'error'
      // })
      // this.user = {
      //   name: this.name,
      //   role: this.roles.join(' | '),
      //   email: 'admin@test.com',
      //   avatar: this.avatar
      // }
    },
    // 返回主页
    goBack() {
      this.$router.push('dashboard')
    },
    // 审核提交的个人信息是否符合
    submit() {
      const un = this.user.name
      const pw = this.user.pwd
      const ph = this.user.phone
      const br = this.user.birthday
      if (un === '' || pw === '' || ph === '' || br === '') {
        this.$message({
          message: '请完整填写个人信息后，再次尝试提交',
          type: 'error'
        })
      } else {
        this.submitData()
      }
    },
    // 更新信息提交
    submitData() {
      this.user.id = this.temp.id
      console.log(this.user)
      updateShopManager(this.user).then(response => {
        alert('修改成功')// 修改成功则弹出提示弹窗
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
    // 注销管理员信息操作
    del() {
      this.user.id = this.temp.id
      deleteShopManager(this.user).then(response => {
        alert('删除成功')// 操作成功弹出提示弹窗
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
      this.logout()
    },
    async logout() {
      await this.$store.dispatch('user/logout')
      this.$router.push(`/login?redirect=${this.$route.fullPath}`)
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

