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
        <el-button style="float: right: 40px;" type="success" :span="4" @click="submitForm()">新增</el-button>
        <el-button style="float: right: 40px;" type="warning" :span="4" @click="cancel()">取消</el-button>
      </sticky>
      <div
        class="createPost-main-container"
      >
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
          <aside>上传门店图片</aside>
          <div class="editor-container">
            <dropzone id="myVueDropzone" url="https://httpbin.org/post" @dropzone-removedFile="dropzoneR" @dropzone-success="dropzoneS" />
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
import Dropzone from '@/components/Dropzone'
import Sticky from '../../components/Sticky/index.vue'
import { getMaxShopId, insertShop } from '@/api/shop'

export default {
  name: 'AddShop',
  components: { Dropzone, Sticky },
  filters: {},
  data() {
    return {
      // 数据初始化
      dialogImageUrl: '',
      dialogVisible: false,
      max: 1, // 设置checkbox可选最大值
      postForm: {
        date: '',
        description: '',
        shopName: '',
        shopId: '',
        unitId: undefined,
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

