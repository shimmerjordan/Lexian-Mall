(global["webpackJsonp"] = global["webpackJsonp"] || []).push([["components/lee-search/lee-search"],{

/***/ 262:
/*!************************************************************************************!*\
  !*** E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue ***!
  \************************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./lee-search.vue?vue&type=template&id=31e0d465&scoped=true& */ 263);
/* harmony import */ var _lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./lee-search.vue?vue&type=script&lang=js& */ 265);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__[key]; }) }(__WEBPACK_IMPORT_KEY__));
/* harmony import */ var _lee_search_vue_vue_type_style_index_0_id_31e0d465_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./lee-search.vue?vue&type=style&index=0&id=31e0d465&lang=scss&scoped=true& */ 267);
/* harmony import */ var _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/runtime/componentNormalizer.js */ 12);

var renderjs





/* normalize component */

var component = Object(_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_3__["default"])(
  _lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__["render"],
  _lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
  false,
  null,
  "31e0d465",
  null,
  false,
  _lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__["components"],
  renderjs
)

component.options.__file = "E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ 263:
/*!*******************************************************************************************************************************!*\
  !*** E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue?vue&type=template&id=31e0d465&scoped=true& ***!
  \*******************************************************************************************************************************/
/*! exports provided: render, staticRenderFns, recyclableRender, components */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--16-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-uni-app-loader/page-meta.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./lee-search.vue?vue&type=template&id=31e0d465&scoped=true& */ 264);
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "recyclableRender", function() { return _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__["recyclableRender"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "components", function() { return _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_templateLoader_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_16_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_uni_app_loader_page_meta_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_template_id_31e0d465_scoped_true___WEBPACK_IMPORTED_MODULE_0__["components"]; });



/***/ }),

/***/ 264:
/*!*******************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/templateLoader.js??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--16-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-uni-app-loader/page-meta.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue?vue&type=template&id=31e0d465&scoped=true& ***!
  \*******************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render, staticRenderFns, recyclableRender, components */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "render", function() { return render; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return staticRenderFns; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "recyclableRender", function() { return recyclableRender; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "components", function() { return components; });
var components
var render = function() {
  var _vm = this
  var _h = _vm.$createElement
  var _c = _vm._self._c || _h
}
var recyclableRender = false
var staticRenderFns = []
render._withStripped = true



/***/ }),

/***/ 265:
/*!*************************************************************************************************************!*\
  !*** E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue?vue&type=script&lang=js& ***!
  \*************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!./node_modules/babel-loader/lib!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./lee-search.vue?vue&type=script&lang=js& */ 266);
/* harmony import */ var _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__[key]; }) }(__WEBPACK_IMPORT_KEY__));
 /* harmony default export */ __webpack_exports__["default"] = (_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default.a); 

/***/ }),

/***/ 266:
/*!********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/babel-loader/lib!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue?vue&type=script&lang=js& ***!
  \********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(uni) {Object.defineProperty(exports, "__esModule", { value: true });exports.default = void 0; //
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
var _default2 =
{
  data: function data() {
    return {
      keyWord: '',
      entering: false, // 判断是处于输入状态
      openVoice: false, // 打开语音功能
      manager: null,
      recording: false, // 正在录音
      recordStatus: 0 // 状态： 0 - 录音中 1- 翻译中 2 - 翻译完成/二次翻译
    };
  },
  props: {
    btnLinkInput: {
      type: Boolean,
      default: false //控制有btn时，按钮与input框是否相连
    },
    inputAttr: {
      type: Object,
      default: function _default() {
        return {};
      } },

    btnAttr: {
      type: Object,
      default: function _default() {
        return {};
      } },

    voiceAttr: {
      type: Object,
      default: function _default() {
        return {};
      } },

    iconAttr: {
      type: Object,
      default: function _default() {
        return {};
      } },

    iconSrc: {
      type: Object,
      default: function _default() {
        return {};
      } },

    type: {
      type: String,
      default: 'text' },

    password: {
      type: Boolean,
      default: false },

    disabled: {
      type: Boolean,
      default: false },

    maxLength: {
      type: Number,
      default: -1 },

    cursorSpacing: {
      type: Number,
      default: 0 },

    focus: {
      type: Boolean,
      default: false },

    confirmType: {
      type: String,
      default: '搜索' },

    confirmHold: {
      type: Boolean,
      default: false },

    cursor: {
      type: Number },

    selectionStart: {
      type: Number,
      default: -1 },

    selectionEnd: {
      type: Number,
      default: -1 },

    adjustPosition: {
      type: Boolean,
      default: true } },


  watch: {
    showVoiceIcon: function showVoiceIcon(val) {
      if (!val) {
        this.openVoice = false;
      }
    },
    keyWord: function keyWord(val) {
      if (val.length === 0) {
        this.entering = false;
      }
    } },

  computed: {
    showPlaceholderIcon: function showPlaceholderIcon() {
      return this.getPlaceholderText && this.watchToolIcon('placeholder');
    },
    showLogoIcon: function showLogoIcon() {
      return this.watchToolIcon('logo');
    },
    showVoiceIcon: function showVoiceIcon() {
      return this.watchToolIcon('voice') && !this.keyWord;
    },
    showScanIcon: function showScanIcon() {
      return this.watchToolIcon('scan') && !this.entering && !this.keyWord;
    },
    showClearIcon: function showClearIcon() {
      return this.watchToolIcon('clear') && this.keyWord;
    },
    showSearchIcon: function showSearchIcon() {
      return this.watchToolIcon('search') && this.keyWord;
    },
    getFontSize: function getFontSize() {
      return uni.upx2px(this.inputAttr.fontSize || 28) + 'px';
    },
    getHeight: function getHeight() {
      return uni.upx2px(this.inputAttr.height && this.inputAttr.height > 60 ? this.inputAttr.height : 60) + 'px';
    },
    getBorder: function getBorder() {
      return this.inputAttr.border || '1px solid #c8c7cc';
    },
    getBorderWidth: function getBorderWidth() {
      return uni.upx2px(this.inputAttr.borderWidth || 1) + 'px';
    },
    getBorderRadius: function getBorderRadius() {
      return uni.upx2px(this.inputAttr.borderRadius || 30) + 'px';
    },
    getColor: function getColor() {
      return this.inputAttr.color || '#333';
    },
    getBackgroundColor: function getBackgroundColor() {
      return this.inputAttr.backgroundColor || '#ffffff';
    },
    getPlaceholderPosition: function getPlaceholderPosition() {
      return this.inputAttr.placeholderPosition || 'left';
    },
    getPlaceholderColor: function getPlaceholderColor() {
      return this.inputAttr.placeholderColor || '#808080';
    },
    getPlaceholderText: function getPlaceholderText() {
      return this.inputAttr.placeholderText || ' ';
    },
    getPlaceholderPaddingLeft: function getPlaceholderPaddingLeft() {
      if (this.showLogoIcon && this.getPlaceholderPosition === 'left') {
        return uni.upx2px((this.iconAttr.width ? this.iconAttr.width : this.inputAttr.height || 60) + (this.inputAttr.paddingLeft ||
        0)) +
        'px';
      } else {
        return uni.upx2px(this.inputAttr.paddingLeft || 20) + 'px';
      }
    },
    getPaddingLeft: function getPaddingLeft() {
      if (this.showLogoIcon) {
        return uni.upx2px(this.inputAttr.paddingLeft || 0) + 'px';
      } else {
        return uni.upx2px(this.inputAttr.paddingLeft && this.inputAttr.paddingLeft > 20 ? this.inputAttr.paddingLeft :
        20) + 'px';
      }
    },
    getIconWidth: function getIconWidth() {
      return this.iconAttr.width ? uni.upx2px(this.iconAttr.width) + 'px' : this.getHeight;
    },
    getIconHeight: function getIconHeight() {
      return this.iconAttr.height ? uni.upx2px(this.iconAttr.height) + 'px' : this.getHeight;
    },
    getIconPadding: function getIconPadding() {
      return uni.upx2px(this.iconAttr.padding) + 'px';
    },

    getBtnEnable: function getBtnEnable() {
      return this.btnAttr.enable || false;
    },
    getBtnText: function getBtnText() {
      return this.btnAttr.text || '';
    },
    getBtnBackgroundColor: function getBtnBackgroundColor() {
      return this.btnAttr.backgroundColor || '#ffffff';
    },
    getBtnColor: function getBtnColor() {
      return this.btnAttr.color || '#333';
    },
    getBtnBorder: function getBtnBorder() {
      return this.btnAttr.border || 'none';
    },
    getBtnBackgroundImage: function getBtnBackgroundImage() {
      return 'url(' + this.btnAttr.backgroundImage + ')';
    },
    getBtnBackgroundPosition: function getBtnBackgroundPosition() {
      return this.btnAttr.backgroundPosition || 'center center';
    },
    getBtnbackgroundSize: function getBtnbackgroundSize() {
      return this.btnAttr.backgroundSize || 'contain';
    },
    getBtnBorderRadius: function getBtnBorderRadius() {
      return uni.upx2px(this.btnAttr.borderRadius || 30) + 'px';
    },
    getBtnFontSize: function getBtnFontSize() {
      return uni.upx2px(this.btnAttr.fontSize || 28) + 'px';
    },
    getBtnPaddingLeft: function getBtnPaddingLeft() {
      return uni.upx2px(this.btnAttr.paddingLeft || 10) + 'px';
    },
    getBtnPaddingRight: function getBtnPaddingRight() {
      return uni.upx2px(this.btnAttr.paddingRight || 0) + 'px';
    },
    getBtnBorderWidth: function getBtnBorderWidth() {
      return uni.upx2px(this.btnAttr.borderWidth || 1) + 'px';
    },

    getVoiceAttrBtnColor: function getVoiceAttrBtnColor() {
      return this.voiceAttr.btnColor || '#fff';
    },
    getVoiceAttrBtnActiveColor: function getVoiceAttrBtnActiveColor() {
      return this.voiceAttr.btnActiveColor || '#fff';
    },
    getVoiceAttrListenColor: function getVoiceAttrListenColor() {
      return this.voiceAttr.listenColor || '#fff';
    },
    getVoiceAttrBtnBackgroundColor: function getVoiceAttrBtnBackgroundColor() {
      return this.voiceAttr.BtnBackgroundColor || '#f1f1f1';
    },
    getVoiceAttrBtnBackgroundActiveColor: function getVoiceAttrBtnBackgroundActiveColor() {
      return this.voiceAttr.BtnBackgroundActiveColor || '#c8c7cc';
    },
    getVoiceAttrListenBackgroundColor: function getVoiceAttrListenBackgroundColor() {
      return this.voiceAttr.listenBackgroundColor || '#c8c7cc';
    },
    getVoiceAttrText: function getVoiceAttrText() {
      return this.voiceAttr.text || '按住 说活';
    },
    getVoiceAttrActiveText: function getVoiceAttrActiveText() {
      return this.voiceAttr.activeText || '松开 结束';
    } },


  methods: {
    watchToolIcon: function watchToolIcon(icon) {
      var flag = false;
      for (var _i = 0, _Object$keys = Object.keys(this.iconSrc); _i < _Object$keys.length; _i++) {var key = _Object$keys[_i];
        if (icon === key && this.iconSrc[key]) {
          flag = true;
        }
      }
      return flag;
    },
    inputFocus: function inputFocus() {
      this.$emit('focus');
    },
    blur: function blur() {
      if (!this.keyWord && this.watchToolIcon('scan')) {
        this.entering = false;
      }
      this.$emit('blur');
    },
    input: function input() {
      this.entering = true;
      this.$emit('input');
    },
    confirm: function confirm() {
      this.$emit('confirm');
    },
    clear: function clear() {
      this.keyWord = '';
      this.$emit('clear');
    },

    scan: function scan() {
      // 扫码
      uni.scanCode({
        success: function success(res) {
          this.$emit('scan', res);
        } });

    },
    search: function search() {
      // 搜索
      this.$emit('search');
    },

    btnClick: function btnClick() {
      // 按钮点击事件
      this.$emit('btnClick', this.btnAttr.text);

    },
    voice: function voice() {
      this.openVoice = true;
    },
    startHandel: function startHandel() {var _this = this;
      console.log('按下录音按钮');
      this.manager.start({
        lang: "zh_CN" });

      uni.vibrateShort({
        success: function success() {
          _this.recordStatus = 0;
          _this.recording = true;
        } });

    },
    endHandle: function endHandle() {
      // 防止重复触发stop函数
      if (!this.recording || this.recordStatus !== 0) {
        console.warn("has finished!");
        return;
      }
      console.log('松开了按钮');
      this.manager.stop();
      // this.listenManagerStop()
    },
    listenRecordLnit: function listenRecordLnit() {
      this.listenManagerStart();
      this.listenManagerStop();
      this.listenManagerRecognize();
      this.listenManagerError();
    },
    listenManagerStart: function listenManagerStart() {
      this.manager.onStart = function (res) {
        console.log('开始录音', res);
      };
    },
    listenManagerRecognize: function listenManagerRecognize() {
      this.manager.onRecognize = function (res) {
        console.log('识别了新内容', res);
      };
    },
    listenManagerError: function listenManagerError() {var _this2 = this;
      this.manager.onError = function (res) {
        console.log('识别错误事件', res);
        _this2.recording = false;

      };
    },
    listenManagerStop: function listenManagerStop() {var _this3 = this;
      // 识别结束事件
      this.manager.onStop = function (res) {
        console.log('识别结束事件', res);
        var text = res.result;

        if (text === '') {
          _this3.showRecordEmptyTip();
          return;
        }
        _this3.recordStatus = 0;
        _this3.keyWord = res.result.substr(0, res.result.length - 1);
        _this3.recording = false;
      };
    },

    showRecordEmptyTip: function showRecordEmptyTip() {
      this.recording = false;
      uni.showToast({
        title: '什么也没听到',
        icon: 'none',
        duration: 1000 });

    } },


  onReady: function onReady() {var _this4 = this;

    if (this.iconSrc.voice) {
      var plugin = requirePlugin("WechatSI");
      uni.authorize({
        scope: 'scope.record',
        success: function success() {
          _this4.manager = plugin.getRecordRecognitionManager();
          _this4.listenRecordLnit();
        } });

    }
  } };exports.default = _default2;
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./node_modules/@dcloudio/uni-mp-weixin/dist/index.js */ 1)["default"]))

/***/ }),

/***/ 267:
/*!**********************************************************************************************************************************************!*\
  !*** E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue?vue&type=style&index=0&id=31e0d465&lang=scss&scoped=true& ***!
  \**********************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_style_index_0_id_31e0d465_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!./node_modules/mini-css-extract-plugin/dist/loader.js??ref--8-oneOf-1-0!./node_modules/css-loader/dist/cjs.js??ref--8-oneOf-1-1!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/stylePostLoader.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-2!./node_modules/postcss-loader/src??ref--8-oneOf-1-3!./node_modules/sass-loader/dist/cjs.js??ref--8-oneOf-1-4!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-5!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./lee-search.vue?vue&type=style&index=0&id=31e0d465&lang=scss&scoped=true& */ 268);
/* harmony import */ var _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_style_index_0_id_31e0d465_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_style_index_0_id_31e0d465_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_style_index_0_id_31e0d465_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_style_index_0_id_31e0d465_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0__[key]; }) }(__WEBPACK_IMPORT_KEY__));
 /* harmony default export */ __webpack_exports__["default"] = (_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_mini_css_extract_plugin_dist_loader_js_ref_8_oneOf_1_0_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_css_loader_dist_cjs_js_ref_8_oneOf_1_1_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_loaders_stylePostLoader_js_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_2_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_postcss_loader_src_index_js_ref_8_oneOf_1_3_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_sass_loader_dist_cjs_js_ref_8_oneOf_1_4_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_8_oneOf_1_5_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_vue_loader_lib_index_js_vue_loader_options_F_HBuilderX_2_7_5_20200519_full_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_lee_search_vue_vue_type_style_index_0_id_31e0d465_lang_scss_scoped_true___WEBPACK_IMPORTED_MODULE_0___default.a); 

/***/ }),

/***/ 268:
/*!************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/mini-css-extract-plugin/dist/loader.js??ref--8-oneOf-1-0!./node_modules/css-loader/dist/cjs.js??ref--8-oneOf-1-1!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib/loaders/stylePostLoader.js!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-2!./node_modules/postcss-loader/src??ref--8-oneOf-1-3!./node_modules/sass-loader/dist/cjs.js??ref--8-oneOf-1-4!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--8-oneOf-1-5!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!E:/git/NEU_Lexian/lexian_uniapp/uni-app/components/lee-search/lee-search.vue?vue&type=style&index=0&id=31e0d465&lang=scss&scoped=true& ***!
  \************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

// extracted by mini-css-extract-plugin
    if(false) { var cssReload; }
  

/***/ })

}]);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/components/lee-search/lee-search.js.map
;(global["webpackJsonp"] = global["webpackJsonp"] || []).push([
    'components/lee-search/lee-search-create-component',
    {
        'components/lee-search/lee-search-create-component':(function(module, exports, __webpack_require__){
            __webpack_require__('1')['createComponent'](__webpack_require__(262))
        })
    },
    [['components/lee-search/lee-search-create-component']]
]);
