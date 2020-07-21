<template>
  <!--添加新的商品页面-->
  <div class="createPost-container">
    <!--数据绑定在postForm 确认修改将该数据传给后端处理-->
    <el-form
      ref="postForm"
      class="form-container"
      :model="postForm"

      label-width="80px"
      label-position="right"
    >
      <!--一个插件 用于标题展示-->
      <sticky :class-name="'sub-navbar published'" :z-index="2" width="50px">
        <div align="center">新增商品</div>
      </sticky>
      <div
        class="createPost-main-container"
      >
        <h3>基础信息</h3>
        <!--商品名称输入框-->
        <el-row>
          <el-col :span="10">
            <el-form-item label="商品名称" prop="name">
              <el-input v-model="postForm.name" size="small" />
            </el-form-item>
          </el-col>
        </el-row>
        <!--操作时间 不可自选 船舰页面自动获取当前时间-->
        <el-row>
          <el-col :span="10">
            <el-form-item label="操作时间" prop="modify_time">
              <el-input v-model="postForm.modify_time" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <!--商品单价输入框-->
        <el-row>
          <el-col :span="10">
            <el-form-item label="商品单价" prop="price">
              <el-input v-model="postForm.price" size="small" />
            </el-form-item>
          </el-col>
        </el-row>
        <!--商品库存输入框-->
        <el-row>
          <el-col :span="10">
            <el-form-item label="商品库存" prop="storage">
              <el-input v-model="postForm.storage" size="small" />
            </el-form-item>
          </el-col>
        </el-row>
        <!--商品计量单位选择框-->
        <el-row>
          <el-col :span="12">
            <el-form-item label="计量单位" prop="specification">
              <el-select v-model="postForm.specification" clearable placeholder="请选择" size="small">
                <!--可选择内容保存在unitList中-->
                <el-option v-for="item in unitList" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <!--是否直接上架单选-->
        <el-row>
          <el-col :span="12">
            <el-form-item label="直接上架" prop="status">
              <el-radio-group v-model="postForm.status">
                <el-radio :label="1">是</el-radio>
                <el-radio :label="0">否</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>

        </el-row>

        <h3>商品介绍</h3>
        <div class="components-container">
          <!--店铺图片-->
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
              <img v-if="postForm.image" class="pic-box" :src="postForm.image" width="150px" height="150px">
            </div>
            <!--商品描述添加-->
            <div style="margin: 10px 0;">
              <aside>商品简介</aside>
              <el-input v-model="postForm.introduction" type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容" />
            </div>
            <div magin="10px 0">
              <!--新增按钮和取消按钮-->
              <el-row>
                <!--新增调用submitForm方法-->
                <el-button style="float: right: 40px;" type="success" @click="submitForm()">新增</el-button>
                <!--新增调用cancel方法-->
                <el-button style="float: right: 40px;" type="warning" @click="cancel()">取消</el-button>
              </el-row>
            </div>
          </div>
        </div>
      </div>
    </el-form>
  </div>
</template>

<script>

import Sticky from '../../components/Sticky/index.vue'
import { getMaxShopId } from '@/api/shop'
import { AddShopGood } from '@/api/shopGood'
import { genUpToken } from '../../utils/qiuToken'

export default {
  name: 'GoodAdd',
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
      textarea: '',
      date: '',
      // 添加的商品信息数据保存 确认后将该数据传给后端
      postForm: {
        name: '',
        modify_time: '',
        price: undefined,
        storage: undefined,
        specification: '',
        status: undefined,
        image: '',
        introduction: ''
      },
      loading: false,
      // 商品计量单位的下拉框选择项
      unitList: [{ label: '件', value: 0 }, { label: '条', value: 2 }, { label: '桶', value: 3 }, { label: '个', value: 4 }],
      // tags: [{ id: 1, name: '服饰' }, { id: 2, name: '食品' }, { id: 3, name: '日常用品' }, { id: 4, name: '电子产品' }],
      checkAllTag: true,
      isIndeterminateTag: true
    }
  },
  computed: {},
  created() {
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
  // 页面创建后 计算当前时间 并修改postForm中的modify_time
  mounted() {
    const yy = new Date().getFullYear()
    const mm = new Date().getMonth() + 1
    const dd = new Date().getDate()
    const hh = new Date().getHours()
    const mf = new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes()
    const ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds()
    this.postForm.modify_time = yy + '-' + mm + '-' + dd + ' ' + hh + ':' + mf + ':' + ss
  },
  methods: {
    getMaxId() {
      getMaxShopId().then(response => {
        this.shopId = response.data
        console.log(this.shopId)
        setTimeout(() => {
        }, 1.5 * 1000)
      })
    },
    // 提交添加的商品数据
    submitForm() {
      this.$refs['postForm'].validate((valid) => {
        if (valid) {
          // 调用api中的AddShopGood方法（参数是postForm）
          AddShopGood(this.postForm).then(response => {
            // 成功后弹窗提示添加成功
            alert('添加成功')
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
      // 回到首页
      this.$router.go(-1)
    },

    // 取消后回到首页
    cancel() {
      this.$router.go(-1)
    },

    handleRemove(file, fileList) {
      this.postForm.image = ''
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
      this.postForm.image = `${this.qiniuaddr}/${response.key}`
      console.log(this.postForm.image)
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
    // handleCheckAllTagChange(event) {
    //   const tags = []
    //   for (const tag of this.tags) {
    //     tags.push(tag.id)
    //   }
    //   this.postForm.tags = event.target.checked ? tags : []
    //   this.isIndeterminateTag = false
    // },
    // handleCheckedTagsChange(value) {
    //   const checkedCount = value.length
    //   this.checkAllTag = checkedCount === this.tags.length
    //   this.isIndeterminateTag = checkedCount > 0 && checkedCount < this.tags.length
    // }

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

