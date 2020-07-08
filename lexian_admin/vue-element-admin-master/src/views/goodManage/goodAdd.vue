<template>
  <div class="createPost-container">
    <el-form
      ref="postForm"
      class="form-container"
      :model="postForm"

      label-width="80px"
      label-position="right"
    >
      <sticky :class-name="'sub-navbar published'" :z-index="2" width="50px">
        <div align="center">新增商品</div>
      </sticky>
      <div
        class="createPost-main-container"
      >
        <h3>基础信息</h3>
        <el-row>
          <el-col :span="10">
            <el-form-item label="商品名称" prop="name">
              <el-input v-model="postForm.name" size="small" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="10">
            <el-form-item label="操作时间" prop="modify_time">
              <el-input v-model="postForm.modify_time" disabled />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="10">
            <el-form-item label="商品单价" prop="price">
              <el-input v-model="postForm.price" size="small" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="10">
            <el-form-item label="商品库存" prop="storage">
              <el-input v-model="postForm.storage" size="small" />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="计量单位" prop="specification">
              <el-select v-model="postForm.specification" clearable placeholder="请选择" size="small">
                <el-option v-for="item in unitList" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

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
            <dropzone id="myVueDropzone" url="https://httpbin.org/post" @dropzone-removedFile="dropzoneR" @dropzone-success="dropzoneS" />
            <div style="margin: 10px 0;">
              <aside>商品简介</aside>
              <el-input v-model="postForm.introduction" type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容" />
            </div>
            <div magin="10px 0">
              <el-row>
                <el-button style="float: right: 40px;" type="success" @click="submitForm()">新增</el-button>
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
import Dropzone from '@/components/Dropzone'
import Sticky from '../../components/Sticky/index.vue'
import { getMaxShopId } from '@/api/shop'
import { AddShopGood } from '@/api/shopGood'

export default {
  name: 'GoodAdd',
  components: { Dropzone, Sticky },
  filters: {},
  data() {
    return {
      textarea: '',
      date: '',
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
      unitList: [{ label: '件', value: 0 }, { label: '条', value: 2 }, { label: '桶', value: 3 }, { label: '个', value: 4 }],
      tags: [{ id: 1, name: '服饰' }, { id: 2, name: '食品' }, { id: 3, name: '日常用品' }, { id: 4, name: '电子产品' }],
      checkAllTag: true,
      isIndeterminateTag: true
    }
  },
  computed: {},
  created() {},
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
    dropzoneS(file) {
      console.log(file)
      this.$message({ message: 'Upload success', type: 'success' })
    },
    dropzoneR(file) {
      console.log(file)
      this.$message({ message: 'Delete success', type: 'success' })
    },

    submitForm() {
      this.$refs['postForm'].validate((valid) => {
        if (valid) {
          AddShopGood(this.postForm).then(response => {
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
      this.$router.go(-1)
    },

    cancel() {
      this.$router.go(-1)
    },
    handleCheckAllTagChange(event) {
      const tags = []
      for (const tag of this.tags) {
        tags.push(tag.id)
      }
      this.postForm.tags = event.target.checked ? tags : []
      this.isIndeterminateTag = false
    },
    handleCheckedTagsChange(value) {
      const checkedCount = value.length
      this.checkAllTag = checkedCount === this.tags.length
      this.isIndeterminateTag = checkedCount > 0 && checkedCount < this.tags.length
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

