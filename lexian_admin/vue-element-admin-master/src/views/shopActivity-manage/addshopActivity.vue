<template>
  <div class="createPost-container">
    <!-- 新增活动信息 -->
    <el-form
      ref="postForm"
      class="form-container"
      :model="postForm"
      label-width="80px"
      label-position="right"
    >
      <!-- sticky组件，使得此始终保持在顶部 -->
      <sticky :class-name="'sub-navbar published'" :z-index="2" width="100px">
        <div style="float: left;">新增门店活动信息</div>
        <el-button style="float: right: 40px;" type="success" :span="4" @click="submitForm()">新增</el-button>

        <el-button style="float: right: 40px;" type="warning" :span="4" @click="cancel()">取消</el-button>
      </sticky>
      <div
        class="createPost-main-container"
      >
        <h3>基础信息</h3>
        <el-form label-width="100px">
          <el-row>
            <el-col :span="12">
              <!-- 对应店铺全部列表，选择该活动所属门店 -->
              <el-form-item label="对应店铺" prop="activityShop" label-width="100px">
                <el-select v-model="postForm.activityShop" clearable placeholder="请选择该活动对应店铺" size="small">
                  <el-option v-for="item in activityShopList" :key="item.id" :value="item.id" :label="item.id +'-' + item.name" />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <!-- 活动编号由系统获取，不可更改 -->
              <el-form-item label="活动编号" prop="shopActivityId" label-width="100px">
                <el-input v-model="postForm.shopActivityId" disabled />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="活动名称" prop="shopActivityName" label-width="100px">
                <el-input v-model="postForm.shopActivityName" />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <!-- 创建时间有系统获取，不可更改 -->
              <el-form-item label="创建时间" prop="createTime">
                <el-input v-model="postForm.createTime" disabled />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="活动时间" prop="timeRange">
                <!-- <span class="demonstration">活动时间：</span> -->
                <el-date-picker
                  v-model="timeRange"
                  value-format="yyyy-MM-dd HH:mm:ss"
                  type="datetimerange"
                  align="right"
                  unlink-panels
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期"
                  :picker-options="pickerOptions"
                />
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="活动类型" prop="type" label-width="100px">
                <el-select v-model="postForm.type" clearable placeholder="请选择" size="small">
                  <el-option v-for="item in typeList" :key="item.value" :label="item.label" :value="item.label" />
                </el-select>
                <!-- <el-button icon="el-icon-plus" circle style="margin-left: 40px;" @click="addActivityType()" /> -->
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>

        <h3>门店活动简介<span style="font-size: 12px;color: darkgrey;">可以展示相关活动图片和对活动一定的描述</span></h3>
        <div class="components-container">
          <!--活动图片，使用dropzone组件进行图片上传-->
          <div class="editor-container">
            <div style="margin: 20px 0;">
              <aside>门店活动介绍</aside>
              <el-input v-model="postForm.description" type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容" />
            </div>
            <aside>上传门店活动图片</aside>
            <dropzone id="myVueDropzone" url="https://httpbin.org/post" @dropzone-removedFile="dropzoneR" @dropzone-success="dropzoneS" />
          </div>
        </div>
      </div>
    </el-form>

    <!-- <el-dialog :visible.sync="dialogFormVisible">
      <el-form ref="dataForm" :model="temp" label-position="left" label-width="70px" style="width: 400px; margin-left:50px;">
        <el-form-item label="活动类型" prop="type">
          <el-input v-model="temp.type" :autosize="{ minRows: 2, maxRows: 4}" type="textarea" placeholder="请输入新增的活动类型" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">
          取消
        </el-button>
        <el-button type="primary" @click="createData()">
          提交
        </el-button>
      </div>
    </el-dialog> -->
  </div>
</template>

<script>
import Dropzone from '@/components/Dropzone'
import Sticky from '../../components/Sticky/index.vue'
import { getMaxActivityId, insertActivity } from '@/api/activity'
import { getAllShop } from '@/api/shop'
import { insertActivityShop } from '@/api/activityShop'

export default {
  name: 'AddShopActivity',
  components: { Dropzone, Sticky },
  filters: {},
  data() {
    return {
      // 数据初始化
      shopList: {
        page: 1,
        limit: 20,
        id: null,
        name: null,
        status: null,
        beginTime: null,
        endTime: null,
        // img: null,
        sort: '+id'
      },
      activityShopList: [],
      timeRange: '',
      textarea: '',
      maxDate: null,
      minDate: null,
      postForm: {
        activityShop: '',
        shopActivityId: '',
        createTime: '',
        shopActivityName: '',
        beginTime: '',
        endTime: '',
        type: '',
        description: ''
      },
      loading: false,
      // 活动类型列表
      typeList: [{ label: '秒杀', value: 0 }, { label: '团购', value: 1 }, { label: '节日限定', value: 2 }],
      // checkAllTag: true,
      isIndeterminateTag: true,
      // 时间段操作，分隔成开始时间和结束时间
      pickerOptions: {
        onPick: ({ maxDate, minDate }) => {
          if (maxDate != null && minDate != null) {
            this.maxDate = maxDate
            this.minDate = minDate
            this.postForm.beginTime = minDate
            this.postForm.endTime = maxDate
            console.log(this.postForm.beginTime)
          }
        },
        shortcuts: [{
          text: '最近一周',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick(picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      },
      temp: {
        type: ''
      },
      dialogFormVisible: false,
      textMap: {
        update: 'Edit',
        create: 'Create'
      }
    }
  },
  computed: {},
  created() {
    this.getMaxActivity() // 页面加载时，获取最大活动id
    this.getActivityShopList() // 获取店铺列表
  },
  mounted() {
    // 获取当前系统时间，并转换好格式
    const yy = new Date().getFullYear()
    const mm = new Date().getMonth() + 1
    const dd = new Date().getDate()
    const hh = new Date().getHours()
    const mf = new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes()
    // const ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds()
    this.postForm.createTime = yy + '-' + mm + '-' + dd + ' ' + hh + ':' + mf
  },
  methods: {
    getActivityShopList() {
      // 获取店铺信息
      getAllShop(this.shopList).then(response => {
        this.activityShopList = response.data.list // 将获取的数据赋值给list
        console.log((this.activityShopList).length)
      })
    },
    getMaxActivity() {
      // 获取最大活动id
      getMaxActivityId().then(response => {
        this.postForm.shopActivityId = response.data + 1 // 获取后，加一赋值给此时的活动id
        // console.log(Object.keys($shopActivityId).length)
        setTimeout(() => {
        }, 1.5 * 1000)
      })
    },
    // dropzone组件，上传图片
    dropzoneS(file) {
      console.log(file)
      this.$message({ message: 'Upload success', type: 'success' })
    },
    // 移除上传的图片
    dropzoneR(file) {
      console.log(file)
      this.$message({ message: 'Delete success', type: 'success' })
    },
    submitForm() {
      // 提交新增的活动信息
      // this.$router.go(-1)
      this.$refs['postForm'].validate((valid) => {
        if (valid) {
          console.log(this.postForm)
          insertActivity(this.postForm).then(response => {
            alert('添加成功') // 操作成功，提示
            this.$notify({
              title: 'Success',
              message: '添加成功',
              type: 'success',
              duration: 2000
            })
            setTimeout(() => {
              // this.listLoading = false
            }, 1.5 * 1000)
          })
        }
      })
      this.$router.push({ path: '/shopActivity/shopActivity-manage' }) // 新增完成后，跳转到活动列表界面
      this.submitActivityShop()
    },
    submitActivityShop() {
      // 新增活动——店铺管理，同时新增
      this.$refs['postForm'].validate((valid) => {
        if (valid) {
          insertActivityShop(this.postForm).then(response => {
            this.$notify({
              title: 'Success',
              message: '关系表添加成功',
              type: 'success',
              duration: 2000
            })
            setTimeout(() => {
              // this.listLoading = false
            }, 1.5 * 1000)
          })
        }
      })
    },
    // 点击取消时，返回到活动列表
    cancel() {
      this.$router.push({ path: '/shopActivity/shopActivity-manage' })
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

