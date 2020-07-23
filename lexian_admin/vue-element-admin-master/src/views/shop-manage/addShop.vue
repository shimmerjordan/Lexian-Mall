<template>
  <div class="createPost-container">
    <!-- 新增店铺界面 -->
    <!-- 表单信息 -->
    <el-form
      ref="postForm"
      class="form-container"
      :model="postForm"
      label-width="80px"
      label-position="right"
    >
      <!-- sticky插件，使此内组件始终在界面上方 -->
      <sticky :class-name="'sub-navbar published'" :z-index="2" width="100px">
        <div style="float: left;">新增门店信息</div>
        <!-- 新增店铺操作 -->
        <el-button style="float: right: 40px;" type="success" :span="4" @click="submit()">新增</el-button>
        <el-button style="float: right: 40px;" type="warning" :span="4" @click="cancel()">取消</el-button>
      </sticky>
      <div class="createPost-main-container">
        <h3>基础信息</h3>
        <el-row>
          <el-col :span="12">
            <el-form-item label="店铺号" prop="shopId">
              <!-- 店铺id从数据库中取出最大的id+1得到，不可更改 -->
              <el-input v-model="postForm.shopId" disabled size="small" />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="店铺名称" prop="shopName">
              <el-input v-model="postForm.shopName" size="small" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="开店时间" prop="establishTime">
              <!-- 开店时间，自动获取系统此时的时间，写入，不可更改 -->
              <el-input v-model="postForm.date" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="店铺规格" prop="unitId">
              <!-- 店铺规格，提供下拉框进行选择 -->
              <el-select v-model="postForm.unitId" clearable placeholder="请选择" size="small">
                <el-option v-for="item in unitList" :key="item.label" :label="item.label" :value="item.label" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="店铺标签" prop="tag">
              <!-- 店铺标签，仅能选择一个作为该店铺的标签属性 -->
              <el-radio-group v-model="postForm.tag">
                <!-- 循环取出tagList的值 -->
                <el-radio
                  v-for="item in tagList"
                  :key="item.value"
                  :label="item.label"
                  :value="item.label"
                >{{ item.label }}
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
        </el-row>

        <h3>门店简介<span style="font-size: 12px;color: darkgrey;">展示店铺图片，不可更改</span></h3>
        <div class="components-container">
          <!--上传店铺图片，利用组件-->
          <aside width="{100}">商品图片</aside>
          <div class="editor-container" width="50px">
            <el-upload
              class="upload-pic"
              :action="domain"
              :data="QiniuData"
              :on-remove="handleRemove"
              :on-error="uploadError"
              :on-success="uploadSuccess"
              :before-remove="beforeRemove"
              :before-upload="beforeAvatarUpload"
              multiple
              :limit="1"
              :on-exceed="handleExceed"
              :file-list="fileList"
            >
              <el-button size="small" type="primary">点击上传图片</el-button>
              <div slot="tip" class="el-upload__tip" style="color:red">只能上传jpg/png文件，且不超过2MB</div>
            </el-upload>
            <div>
              <img v-if="postForm.img" class="pic-box" :src="postForm.img" width="150px" height="150px">
            </div>
            <div style="margin: 20px 0;">
              <aside>门店详情</aside>
              <el-input v-model="postForm.description" type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容" />
            </div>
          </div>
        </div>
        <!-- <div>
          <el-upload
            action="http:localhost:8080/uploadImg"
            list-type="picture-card"
            :on-preview="handlePictureCardPreview"
            :on-remove="handleRemove"
          >
            <i class="el-icon-plus" />
          </el-upload>
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </div> -->
      </div>
    </el-form>
  </div>
</template>

<script>
import Sticky from '../../components/Sticky/index.vue'
import { getMaxShopId, insertShop } from '@/api/shop'
import { genUpToken } from '../../utils/qiuToken'

export default {
  name: 'AddShop',
  components: { Sticky },
  filters: {},
  data() {
    return {
      QiniuData: {
        key: '', // 图片名字处理
        token: '' // token
      },
      domain: 'http://up-z1.qiniup.com', // 七牛云的上传地址（华南区）
      qiniuaddr: 'http://qdrwvmqsv.bkt.clouddn.com/', // 七牛云的图片外链地址 你的七牛云里配置有
      // uploadPicUrl: "", //提交到后台图片地址
      fileList: [],
      nowTime: '',
      fileExtension: '',
      // 数据初始化
      dialogImageUrl: '',
      dialogVisible: false,
      max: 1, // 设置checkbox可选最大值
      postForm: {
        date: '',
        description: '',
        shopName: '',
        img: '',
        shopId: '',
        unitId: '',
        tag: ''
      },
      loading: false,
      // 店铺类型列表
      unitList: [{ label: '普通店', value: 3 }, { label: '进口店', value: 2 }, { label: '旗舰店', value: 1 }, { label: '自营店', value: 0 }],
      // 店铺标签列表
      tagList: [{ value: 1, label: '服饰' }, { value: 2, label: '食品' }, { value: 3, label: '日常用品' }, { value: 4, label: '电子产品' }]
    }
  },
  computed: {},
  created() {
    this.getMaxId() // 页面加载时获取店铺id最大
    this.nowTime = this.getDate()
    console.log(this.nowTime)
    var token
    var policy = {}
    var bucketName = 'xinyi0919'// 你的七牛桶名称
    var AK = '2q1L4kfkKIJKqCWxhFs3e7BVhD-asgHXJJH2gbLY' // 你的七牛AK
    var SK = 'RcliijVOtUHBZ7uz3qPH_0ifMKVXv3Tzr-qMTNiw'// 你的七牛SK
    var deadline = Math.round(new Date().getTime() / 1000) + 360000
    policy.scope = bucketName
    policy.deadline = deadline
    token = genUpToken(AK, SK, policy)
    this.QiniuData.token = token
    console.log(this.QiniuData.token)
  },
  mounted() {
    // 获取当前系统时间，并整理好格式
    const yy = new Date().getFullYear()
    const mm = new Date().getMonth() + 1
    const dd = new Date().getDate()
    const hh = new Date().getHours()
    const mf = new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes()
    const ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds()
    this.postForm.date = yy + '-' + mm + '-' + dd + ' ' + hh + ':' + mf + ':' + ss
  },
  methods: {
    // handleRemove(file, fileList) {
    //   console.log(file, fileList)
    // },
    // handlePictureCardPreview(file) {
    //   this.dialogImageUrl = file.url
    //   this.dialogVisible = true
    // },

    // 获取店铺id最大值
    getMaxId() {
      getMaxShopId().then(response => {
        this.postForm.shopId = response.data + 1 // 获取最大值后加一赋值给此时的店铺id
        console.log(this.postForm.shopId)
        setTimeout(() => {
        }, 1.5 * 1000)
      })
    },
    // dropzone插件上传图片
    dropzoneS(file) {
      // console.log(file)
      this.$message({ message: 'Upload success', type: 'success' })
    },
    // 删除已经上传的图片
    dropzoneR(file) {
      // console.log(file)
      this.$message({ message: 'Delete success', type: 'success' })
    },
    // 审核提交的新增店铺信息是否符合要求
    submit() {
      console.log(this.postForm)
      const des = this.postForm.description
      const sname = this.postForm.shopName
      const uid = this.postForm.unitId
      const t = this.postForm.tag
      if (des === '' || sname === '' || uid === '' || t === '') {
        this.$message({
          message: '请将店铺信息填写完整后，再次尝试提交！',
          type: 'error'
        })
      } else {
        this.submitForm()
      }
    },
    // 点击新增按钮后，向后端传入店铺新增信息
    submitForm() {
      this.$refs['postForm'].validate((valid) => {
        console.log(this.postForm)

        if (valid) {
          insertShop(this.postForm).then(response => {
            alert('添加成功') // 操作成功后，弹出提示框
            this.$notify({
              title: 'Success',
              message: '添加成功',
              type: 'success',
              duration: 2000
            })
            setTimeout(() => {
              this.listLoading = false
            }, 1.5 * 1000)
          })
        }
      })
      this.$router.push({ path: '/shop/shop-manager' }) // 当新增成功后跳转到店铺列表界面
    },
    // 取消新增操作，当点击取消按钮后，返回店铺列表界面
    cancel() {
      this.$router.push({ path: '/shop/shop-manager' })
    },
    handleRemove(file, fileList) {
      this.postForm.img = ''
    },
    handleExceed(files, fileList) {
      this.$message.warning(
        `当前限制选择 1 张图片，如需更换，请删除上一张图片在重新选择！`
      )
    },
    beforeAvatarUpload(file) {
      const isPNG = file.type === 'image/png'
      const isJPEG = file.type === 'image/jpeg'
      const isJPG = file.type === 'image/jpg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isPNG && !isJPEG && !isJPG) {
        this.$message.error('上传头像图片只能是 jpg、png、jpeg 格式!')
        return false
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
        return false
      }
      // const isSize = new Promise(function(resolve, reject) {
      //   const width = 100
      //   const height = 100
      //   const _URL = window.URL || window.webkitURL
      //   const img = new Image()
      //   img.onload = function() {
      //             		// 在这里可以获取你上传图片的宽高size
      //     console.log(`img.width:${img.width} img.height:${img.height} img.size:${file.size}`)
      //     const valid = img.width >= width && img.height >= height
      //     valid ? resolve() : reject()
      //   }
      //   img.src = _URL.createObjectURL(file)
      // }).then(() => {
      //   return file
      // }, () => {
      //   this.$message.error('上传的icon必须是等于或大于100*100!')
      //   return Promise.reject()
      // })
      console.log(this.nowTime)
      console.log(this.nowTime)
      // 这个this.fileExtension是文件名的后缀
      this.fileExtension = file.name.split('.').pop()
      console.log(this.fileExtension)
      // 这里的key给加上了时间戳，目的是为了防止上传冲突
      this.QiniuData.key = `upload_pic_${this.nowTime}.${this.fileExtension}`
    },
    uploadSuccess(response, file, fileList) {
      console.log(fileList)
      this.postForm.img = `${this.qiniuaddr}/${response.key}`
      console.log(this.postForm.img)
      // 在这里你就可以获取到上传到七牛的外链URL了
    },
    uploadError(err, file, fileList) {
      if (err) {
        console.log(err)
      }
      this.$message({
        message: '上传出错，请重试！',
        type: 'error',
        center: true
      })
    },
    beforeRemove(file, fileList) {
      // return this.$confirm(`确定移除 ${ file.name }？`);
    },
    // 以下是时间戳函数
    getDate() {
      var myDate = new Date()
      // 获取当前年
      var year = myDate.getFullYear()
      // 获取当前月
      var month = myDate.getMonth() + 1
      // 获取当前日
      var date = myDate.getDate()
      var h = myDate.getHours() // 获取当前小时数(0-23)
      var m = myDate.getMinutes() // 获取当前分钟数(0-59)
      var s = myDate.getSeconds()
      // 获取当前时间
      var now = year + '_' + this.conver(month) + '_' + this.conver(date) + '_' + this.conver(h) + '_' + this.conver(m) + '_' + this.conver(s)
      return now
    },
    conver(s) {
      return s < 10 ? '0' + s : s
    }
  }
}

</script>

<style rel="stylesheet/scss" lang="scss">
  @import "../../assets/css/mixin.scss";
  .title-prompt {
    position: absolute;
    right: 0px;
    font-size: 12px;
    top: 10px;
    color: #ff4949;
  }

  .createPost-container {
    position: relative;
    .createPost-main-container {
      margin: 20px;
      .my-sortable-placeholder{
        height: 148px;
        display: inline-block;
        width: 148px;
        border: 1px dashed #ccc;
        margin: 0 8px 8px 0;
        border-radius: 6px;
      }

      h3 {
        color: #03b8cc;
        font-size: inherit;
        font-weight: 400;
        margin-bottom: 10px;
        margin-top: 30px;
      }
      .postInfo-container {
        position: relative;
        @include clearfix;
        margin-bottom: 10px;
        .postInfo-container-item {
          float: left;
        }
      }
      .editor-container {
        min-height: 500px;
        margin: 0 0 30px;
        .editor-upload-btn-container {
          text-align: right;
          margin-right: 10px;
          .editor-upload-btn {
            display: inline-block;
          }
        }
      }
    }
    .word-counter {
      width: 40px;
      position: absolute;
      right: -10px;
      top: 0px;
    }
  }
</style>

