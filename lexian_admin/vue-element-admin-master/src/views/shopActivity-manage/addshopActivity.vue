<template>
  <div class="createPost-container">
    <el-form
      ref="postForm"
      class="form-container"
      :model="postForm"

      label-width="80px"
      label-position="right"
    >
      <sticky :class-name="'sub-navbar published'" :z-index="2" width="100px">
        <div style="float: left;">新增门店活动信息</div>
        <el-button style="float: right: 40px;" type="success" :span="4" @click="submitForm()">新增</el-button>

        <el-button style="float: right: 40px;" type="warning" :span="4" @click="cancel()">取消</el-button>
      </sticky>
      <div
        class="createPost-main-container"
      >
        <h3>基础信息</h3>
        <el-row>
          <el-col :span="12">
            <el-form-item label="对应店铺" prop="activityShop" label-width="100px">
              <el-select v-model="postForm.activityShop" clearable placeholder="请选择该活动对应店铺" size="small">
                <el-option v-for="item in activityShopList" :key="item.value" :value="item.value" :label="item.id +'-' + item.name" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="活动编号" prop="shopActivityId" label-width="100px">
              <el-input v-model="postForm.shopActivityId" disabled />
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="活动名称" prop="shopActivityName" label-width="100px">
              <el-input v-model="postForm.shopActivityName" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="创建时间" prop="unitId">
              <el-input v-model="postForm.date" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="活动时间" prop="unitId">
              <!-- <span class="demonstration">活动时间：</span> -->
              <el-date-picker
                v-model="value2"
                value-format="yyyy-MM-dd HH:mm:ss"
                type="datetimerange"
                align="right"
                unlink-panels
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                :picker-options="pickerOptions"
              />
              <!-- <el-date-picker prop="beginTime" type="datetime" placeholder="请选择开始日期" />
               至
               <el-date-picker prop="endTime" type="datetime" placeholder="请选择结束日期" /> -->
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="12">
            <el-form-item label="活动类型" prop="type" label-width="100px">
              <el-select v-model="postForm.type" clearable placeholder="请选择" size="small">
                <el-option v-for="item in typeList" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
              <!-- <el-button icon="el-icon-plus" circle style="margin-left: 40px;" @click="addActivityType()" /> -->
            </el-form-item>
          </el-col>
        </el-row>

        <h3>门店活动简介<span style="font-size: 12px;color: darkgrey;">可以展示相关活动图片和对活动一定的描述</span></h3>
        <div class="components-container">
          <!--活动图片-->
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
import { createArticle } from '@/api/article'
import Dropzone from '@/components/Dropzone'
import Sticky from '../../components/Sticky/index.vue'
import { getMaxActivityId } from '@/api/activity'
import { getAllShop } from '@/api/shop'

export default {
  name: 'AddShopActivity',
  components: { Dropzone, Sticky },
  filters: {},
  data() {
    return {
      activityShopList: [],
      textarea: '',
      postForm: {
        shopActivityId: '',
        date: '',
        name: '',
        categoryId: undefined,
        unitId: undefined
      },
      loading: false,
      typeList: [{ label: '秒杀', value: 0 }, { label: '团购', value: 1 }, { label: '节日限定', value: 2 }],
      //   tags: [{ id: 1, name: '服饰' }, { id: 2, name: '食品' }, { id: 3, name: '日常用品' }],
      checkAllTag: true,
      isIndeterminateTag: true,
      pickerOptions: {
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
      value1: '',
      value2: '',
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
    this.getMaxActivity()
    this.getActivityShopList()
  },
  mounted() {
    const yy = new Date().getFullYear()
    const mm = new Date().getMonth() + 1
    const dd = new Date().getDate()
    const hh = new Date().getHours()
    const mf = new Date().getMinutes() < 10 ? '0' + new Date().getMinutes() : new Date().getMinutes()
    // const ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds()
    this.postForm.date = yy + '-' + mm + '-' + dd + ' ' + hh + ':' + mf
  },
  methods: {
    getActivityShopList() {
      getAllShop().then(response => {
        this.activityShopList = response.data
        console.log((this.activityShopList).length)
        //  for(let i = 0; i < (this.activityShopList).length; i++){
        //    this.activityShopList[i] = this.activityShopList[i].id +'--' +this.activityShopList[i].name
        //  }
        //  console.log(this.activityShopList)
      })
    },
    getMaxActivity() {
      getMaxActivityId().then(response => {
        this.postForm.shopActivityId = response.data + 1
        // console.log(Object.keys($shopActivityId).length)
        setTimeout(() => {
        }, 1.5 * 1000)
      })
    },
    dropzoneS(file) {
      console.log(file)
      this.$message({ message: 'Upload success', type: 'success' })
    },
    dropzoneR(file) {
      console.log(file)
      this.$message({ message: 'Delete success', type: 'success' })
    },
    submitForm() {
      this.$router.go(-1)
    },
    cancel() {
      this.$router.go(-1)
    },
    createData() {
      this.$refs['dataForm'].validate((valid) => {
        if (valid) {
          this.temp.id = parseInt(Math.random() * 100) + 1024 // mock a id
          this.temp.author = 'vue-element-admin'
          createArticle(this.temp).then(() => {
            this.list.unshift(this.temp)
            this.dialogFormVisible = false
            this.$notify({
              title: 'Success',
              message: 'Created Successfully',
              type: 'success',
              duration: 2000
            })
          })
        }
      })
    },
    resetTemp() {
      this.temp = {
        id: undefined,
        type: ''
      }
    },
    addActivityType() {
      this.resetTemp()
      this.dialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].clearValidate()
      })
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

