<template>
  <div class="createPost-container">
    <el-form
      ref="postForm"
      class="form-container"
      :model="postForm"
      :rules="rules"
      label-width="80px"
      label-position="right"
    >
      <sticky :class-name="'sub-navbar published'" :z-index="2">
        <el-button v-loading="loading" style="margin-left: 10px;" type="success" @click="submitForm()">保存
        </el-button>
        <el-button type="warning" @click="cancel()">取消</el-button>
      </sticky>

      <div class="createPost-main-container">
        <!--基础信息-->
        <h3>基础信息</h3>
        <el-row>
          <el-col :span="12">
            <el-form-item label="商品名称" prop="name">
              <el-input v-model="postForm.name" size="small" />
            </el-form-item>
          </el-col>

          <el-col :span="10" :push="1">
            <el-form-item label="商品分类" prop="categoryId">
              <el-cascader
                v-model="postForm.categoryId"
                expand-trigger="hover"
                :options="data2"
                :show-all-levels="false"
                size="small"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="计量单位" prop="unitId">
              <el-select v-model="postForm.unitId" clearable placeholder="请选择" size="small">
                <el-option
                  v-for="item in unitList"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                />
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="商品标签" prop="tags">
              <el-checkbox
                v-model="checkAllTag"
                size="small"
                :indeterminate="isIndeterminateTag"
                @change="handleCheckAllTagChange"
              >全选
              </el-checkbox>
              <el-checkbox-group
                v-model="postForm.tags"
                style="display: inline-block;margin-left: 15px;"
                @change="handleCheckedTagsChange"
              >
                <el-checkbox v-for="tag in tags" :key="tag.id" size="small" :label="tag.id">{{ tag.name }}
                </el-checkbox>
              </el-checkbox-group>
            </el-form-item>
          </el-col>
        </el-row>

        <!--商品规格-->
        <h3>商品规格</h3>
        <div class="filter-container">
          <el-button size="small" type="success" icon="plus" @click="addSku">新增</el-button>
        </div>
        <el-table :data="postForm.skus" border fit highlight-current-row style="width: 100%">
          <el-table-column align="center" min-width="300px" label="规格名称">
            <template scope="scope">
              <el-input v-model="scope.row.name" size="small" />
            </template>
          </el-table-column>

          <el-table-column align="center" width="200px" label="价格">
            <template scope="scope">
              <el-input-number v-model="scope.row.price" :controls="false" size="small" :min="1" />
            </template>
          </el-table-column>

          <el-table-column align="center" width="300px" label="库存">
            <template scope="scope">
              <el-input-number v-model="scope.row.stock" size="small" :min="1" />
              <el-checkbox size="small">无限库存</el-checkbox>
            </template>
          </el-table-column>

          <el-table-column align="center" label="操作" width="120">
            <template>
              <el-button size="small" type="danger" icon="delete">删除</el-button>
            </template>
          </el-table-column>
        </el-table>

        <!--商品图片-->
        <h3>商品图片<span style="font-size: 12px;color: darkgrey;">最多20张，默认第一张图片作为主图，可以拖动图片调整</span></h3>
        <el-upload
          action="https://jsonplaceholder.typicode.com/posts/"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handlePictureRemove"
          :before-upload="beforeAvatarUpload"
          :on-success="handlePictureSuccess"
          multiple
        >
          <i class="el-icon-plus" />
        </el-upload>

        <el-dialog v-model="showImagePreview" size="tiny">
          <img width="100%" :src="previewImageUrl" alt="">
        </el-dialog>

        <!--商品详情-->
        <h3>商品详情</h3>
        <div id="editor">
          <p>请在此编辑商品详情</p>
        </div>
      </div>
    </el-form>

    <el-tooltip placement="top" content="回到顶部">
      <back-to-top transition-name="fade" :visibility-height="300" :back-position="50" />
    </el-tooltip>
  </div>
</template>

<script>
export default {
  name: 'GoodAdd'
}
</script>

<style>

</style>
