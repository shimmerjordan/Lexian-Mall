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
        <div style="float: left;">新增店铺信息</div>
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
              <el-input v-model="shopId" disabled size="small" />
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
            <el-form-item label="开店时间" prop="unitId">
              <el-input v-model="date" disabled />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="店铺规格" prop="unitId">
              <el-select v-model="postForm.unitId" clearable placeholder="请选择" size="small">
                <el-option v-for="item in unitList" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="店铺标签" prop="tags">
              <el-checkbox v-model="checkAllTag" size="small" :indeterminate="isIndeterminateTag" @change="handleCheckAllTagChange">全选</el-checkbox>
              <el-checkbox-group v-model="postForm.tags" style="display: inline-block;margin-left: 15px;" @change="handleCheckedTagsChange">
                <el-checkbox v-for="tag in tags" :key="tag.id" size="small" :label="tag.id">{{ tag.name }}</el-checkbox>
              </el-checkbox-group>
            </el-form-item>
          </el-col>
        </el-row>

        <h3>店铺简介<span style="font-size: 12px;color: darkgrey;">可以展示店铺的营业执照等。最多20张，默认第一张图片作为主图，可以拖动图片调整</span></h3>
        <div class="components-container">
          <!--店铺图片-->
          <aside>上传店铺图片</aside>
          <div class="editor-container">
            <dropzone id="myVueDropzone" url="https://httpbin.org/post" @dropzone-removedFile="dropzoneR" @dropzone-success="dropzoneS" />
          </div>
          <!--店铺详情-->
          <aside>店铺详情</aside>
          <div style="margin: 20px 0;">
            <el-input v-model="textarea" type="textarea" :autosize="{ minRows: 2, maxRows: 4}" placeholder="请输入内容" />
          </div>
        </div>
      </div>
    </el-form>
  </div>
</template>

<script>
import Dropzone from '@/components/Dropzone'
import Sticky from '../../components/Sticky/index.vue'
export default {
  name: 'AddShop',
  components: { Dropzone, Sticky },
  filters: {},
  data() {
    return {
      textarea: '',
      date: '',
      shopId: 19,
      postForm: {
        name: '',
        categoryId: undefined,
        unitId: undefined,
        tags: []
      },
      loading: false,
      unitList: [{ label: '普通店', value: 3 }, { label: '进口店', value: 2 }, { label: '旗舰店', value: 1 }, { label: '自营店', value: 0 }],
      tags: [{ id: 1, name: '服饰' }, { id: 2, name: '食品' }, { id: 3, name: '日常用品' }],
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
    // const ss = new Date().getSeconds() < 10 ? '0' + new Date().getSeconds() : new Date().getSeconds()
    this.date = yy + '-' + mm + '-' + dd + ' ' + hh + ':' + mf
  },
  methods: {
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

