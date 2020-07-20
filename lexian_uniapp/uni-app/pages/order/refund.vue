<template>
	<view class="refund">
		<!-- 商品 -->
		<view class="row">
			<view
				class="carrier"
				@tap="navTo('/pages/product/product?id='+commodityID+'&uid='+common.getGlobalUserInfo().ID)"
			>
				<view class="left" >
					<image
						class="image"
						:src="orderImg"
					></image>
				</view>
				<view class="mid">
					<view class="title in2line">{{
						commodityName
					}}</view>
					<view class="data">
						{{ attr  || singleSkuText }}
					</view>
					<view class="bottom">
						<text class="price" :class="'text-' + themeColor.name">{{ moneySymbol }}{{ singlePrice	}} * {{ quantity }}</text>
					</view>
				</view>
			</view>
		</view>
		<view class="product-textarea">
			<form @submit="handleOrderRefundApply">
				<list-cell
					@eventClick="chooseRefundType"
					title="申诉类型"
					:tips="refund_type || '请选择'"
				></list-cell>
				<list-cell
					@eventClick="chooseRefundReasonType"
					title="售后原因"
					:tips="refund_reason || '请选择'"
				></list-cell>
				<textarea
					class="textarea"
					v-model="refund_explain"
					placeholder-style="color:#ccc; font-size: 26upx"
					placeholder="宝贝不满足您的期待吗？请填写一下您申请售后的理由吧"
				/>
				<view class="feedback-title">
					<text>订单金额</text>
					<text :class="'text-' + themeColor.name">{{ moneySymbol }}{{ singlePrice * quantity }}</text>
				</view>
				<view class="feedback-content">
					<text>提交工单后，该订单的金额会锁定在担保账户等待售后完毕进行处理</text>
				</view>
				
				<!-- 图片上传组件 -->
				<view class="cu-bar bg-white margin-top">
					<view class="action">
						凭证上传
					</view>
					<view class="action">
						{{imgList.length}}/3
					</view>
				</view>
				<view class="cu-form-group">
					<view class="grid col-3 grid-square flex-sub">
						<view class="bg-img" v-for="(item,index) in imgList" :key="index" @tap="ViewImage" :data-url="imgList[index]">
						 <image :src="imgList[index]" mode="aspectFill"></image>
							<view class="cu-tag bg-red" @tap.stop="DelImg" :data-index="index">
								<text class='cuIcon-close'></text>
							</view>
						</view>
						<view class="solids" @tap="ChooseImage" v-if="imgList.length<3">
							<text class='cuIcon-cameraadd'></text>
						</view>
					</view>
				</view>
				<button class="confirm-btn" @click="handleOrderRefundApply" >提交工单</button>
			</form>
		</view>
		
	</view>
</template>
<script>

import listCell from '@/components/rf-list-cell';
import common from '@/store/common.js';
import {
		mapState
	} from 'vuex';
	
export default {
	data() {
		return {
			imgList: [],
			attr: '',
			productInfo: {},
			orderID: 0,
			orderImg: '',
			singlePrice: 0,
			quantity: 0,
			commodityName: '',
			refund_type: '请选择工单类型',
			modify_type: 0,
			commodityID: 0,
			refund_reason: '',
			refund_explain: '',
			imageList: [],
			moneySymbol: this.moneySymbol,
			refundTypeArr: [
				{
					value: '1',
					name: '仅退款'
				},
				{
					value: '2',
					name: '退货退款'
				}
			],
			singleSkuText: this.singleSkuText,
			msgContents: [
				'商品信息描述不符',
				'退运费',
				'质量问题',
				'少件含缺少配件',
				'包装/商品损坏/污渍',
				'未按约定时间发货',
				'发票问题',
				'卖家发错货',
				'其他'
			],
			refundType: [
				'仅退款',
				'退货退款',
				'申请售后',
				'申诉'		
			]
		};
	},
	components: {
		listCell
	},
	computed: {
		...mapState(['hasLogin','userInfo']),
		wordLimit() {
			return 140 - this.refund_reason.length;
		}
	},
	onLoad(options) {
		this.initData(options);
		
	},
	methods: {
		// 数据初始化
		initData(options) {
			// this.productInfo = JSON.parse(options.data);
			// this.refundType = options.refundType;
			// let title = '仅退款';
			// if (parseInt(this.refundType, 10) === 1) {
			// 	title = '仅退款';
			// } else {
			// 	title = '仅退款/退货退款';
			// }
			// uni.setNavigationBarTitle({
			// 	title
			// });
			this.orderID = options.orderID;			this.orderImg = options.orderImg;			this.singlePrice = options.singlePrice;
			this.quantity = options.quantity;			this.commodityName = options.commodityName;
			this.attr = options.attr;
			this.commodityID = options.commodityID;
		},
		// 快速输入
		chooseRefundReasonType() {
			uni.showActionSheet({
				itemList: this.msgContents,
				success: res => {
					this.refund_reason = this.msgContents[res.tapIndex];
				}
			});
		},
		//选择图片
		ChooseImage() {
			
			uni.chooseImage({
				count: 3, //默认9
				sizeType: ['compressed'], //可以指定是原图还是压缩图，默认二者都有
				sourceType: ['album','camera'], //从	相册选择
				success: (res) => {
					if (res.tempFilePaths.length == 0) {
						this.imgList = res.tempFilePaths
						console.log("this.imgList.length", this.imgList.length)
					} else {
						this.imgList = this.imgList.concat(res.tempFilePaths)
						this.urlTobase64(res.tempFilePaths[0]);
					}
				}
			});
		},
		//转base64码
		urlTobase64(url) {
			uni.request({
				url: url,
				method: 'GET',
				responseType: 'arraybuffer',
				success: res => {
					let base64 = wx.arrayBufferToBase64(res.data); //把arraybuffer转成base64
					// this.imageBase64Str = base64 = 'data:image/jpeg;base64,' + base64; //不加上这串字符，在页面无法显示
					this.imageBase64Str = base64;
					// console.log(this.imageBase64Str);
				}
			});
		},
		//预览图片
		ViewImage(e) {
			uni.previewImage({
				urls: this.imgList,
				current: e.currentTarget.dataset.url
			});
		},
		//删除图片
		DelImg(e) {
			uni.showModal({
				title: '删除照片',
				content: '确定要删除这张照片吗？',
				cancelText: '取消',
				confirmText: '确定',
				success: res => {
					if (res.confirm) {
						this.imgList.splice(e.currentTarget.dataset.index, 1)
					}
				}
			})
		},
		handleRefundTypeChange(e) {
			this.refund_type = e.detail.value;
		},
		// 跳转页面
		navTo(route){
			
			uni.navigateTo({
				url: route,
				success: res => {
					
				},
				fail: () => {},
				complete: () => {}
			});
		},
		// 退货/退款
		async handleOrderRefundApply(e) {
			// const formData = e.detail.value;
			// if (parseInt(this.refundType, 10) === 1) {
			// 	formData.refund_type = this.refundType;
			// }
			// formData['refund_evidence'] = JSON.stringify(this.imageList);
			// formData['refund_explain'] = this.refund_explain;
			// formData['refund_reason'] = this.refund_reason;
			// if (this.refundType.toString() === '3') {
			// 	await this.handleOrderCustomerRefundApply(this.productInfo.id, formData);
			// } else {
			// 	await this.handleOrderRefundApplyOperation(this.productInfo.id, formData);
			// }
			
			//选择修改订单的类型（目标），根据refund_type
			if(this.refund_type == '仅退款' && this.refund_type == '退货退款' ){
				this.modify_type = 5
			}
			if(this.refund_type == '申请售后'){
				this.modify_type = 6
			}
			if(this.refund_type == '申诉'){
				this.modify_type = 7
			}
			console.log(this.modify_type)
			uni.request({
				url: this.apiServer + "/order/applyCustomerJiufenOrder",
				data:{
					"userID": common.getGlobalUserInfo().ID,
					"orderID": this.orderID,
					"reason": this.refund_reason + ' : ' + this.refund_explain,
					"orderState": this.modify_type
					},
				method: 'POST',
				success: (res) => {
					console.log(res.data);
					uni.navigateTo({
						url: `/pages/order/order?state=0&flag=${res.data}`
					})
				}
			});
			
			
		},
		chooseRefundType() {
			uni.showActionSheet({
				itemList: this.refundType,
				success: res => {
					this.refund_type = this.refundType[res.tapIndex];
				}
			});
		},
		async handleOrderCustomerRefundApply(id, formData) {
			
		}
	}
};
</script>
<style lang="scss">
	@import "/static/colorui/main.css";
	@import "/static/colorui/icon.css";
	@import "/static/colorui/animation.css";
	
page {
	background: $color-white;
}
.refund {
	background-color: $color-white;
	/*  #ifndef H5  */
	height: 100vh;
	/*  #endif  */
	.row {
		margin: 0 auto $spacing-lg;
		width: calc(94%);
		height: calc(22vw + 40upx);
		border-radius: 15upx;
		box-shadow: 0upx 5upx 20upx rgba(0, 0, 0, 0.1);
		display: flex;
		align-items: center;
		position: relative;
		overflow: hidden;
		z-index: 4;
		border: 0;
		.carrier {
			@keyframes showMenu {
				0% {
					transform: translateX(0);
				}
				100% {
					transform: translateX(-30%);
				}
			}
			@keyframes closeMenu {
				0% {
					transform: translateX(-30%);
				}
				100% {
					transform: translateX(0);
				}
			}
			&.open {
				animation: showMenu 0.25s linear both;
			}
			&.close {
				animation: closeMenu 0.15s linear both;
			}
			background-color: #fff;
			position: absolute;
			width: 100%;
			padding: 0 0;
			height: 100%;
			z-index: 3;
			display: flex;
			align-items: center;
			.left {
				width: 22vw;
				height: 22vw;
				margin-left: 20upx;
				margin-right: 10upx;
				.image {
					border-radius: 10upx;
					width: 22vw;
					height: 22vw;
				}
			}
			.mid {
				text-align: left;
				width: 100%;
				margin: 10upx 10upx 0;
				.title {
					color: $font-color-dark;
					height: 100upx;
					line-height: 1.15;
					font-size: $font-base;
				}
				.data {
					width: 100%;
					display: flex;
					align-items: center;
					margin: 8upx 1 5upx;
					font-size: $font-base;
					color: $font-color-base;
					.item {
						flex: 1;
					}
					.iconfont {
						color: $font-color-light;
						margin-right: 10upx;
					}
					.status {
						padding: 6upx 18upx;
						background-color: $base-color;
						opacity: 0.8;
						color: $color-white;
						font-size: $font-sm;
						border-radius: 4upx;
					}
				}
				.bottom {
					line-height: 1.15;
					width: 100%;
					display: flex;
					justify-content: space-between;
					align-items: center;
					font-size: $font-sm;
					color: $font-color-light;
					.price {
						font-size: 28upx;
					}
				}
			}
			.data {
				color: $font-color-light;
			}
		}
	}
	.product-textarea {
		margin: $spacing-base 0 0;
		.gender-item {
			.gender-item-radio {
				transform: scale(0.9);
			}
			.gender-item-text {
				margin: 0 $spacing-base 0 $spacing-sm;
			}
		}
		.refund-type {
			margin: $spacing-base $spacing-lg;
		}
		.textarea {
			width: 100%;
			height: 150upx;
			padding: 0 $spacing-lg;
		}
	}
	.confirm-btn {
		width: 630upx;
		height: 76upx;
		line-height: 76upx;
		border-radius: 50px;
		margin-top: 50upx;
		font-size: $font-lg;
		&:after {
			border-radius: 100px;
		}
	}
	/*问题反馈*/
	.feedback-title {
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
		padding: $spacing-base $spacing-lg;
		font-size: $font-base;
		border-bottom: 1upx solid rgba(0, 0, 0, 0.05);
	}
	.feedback-content {
		padding: $spacing-base $spacing-lg;
		color: $font-color-light;
		font-size: $font-base;
	}
	.confirm-btn{
		width: 630upx;
		height: 76upx;
		line-height: 76upx;
		border-radius: 50px;
		margin-top: 70upx;
		background: $uni-color-primary;
		color: #fff;
		font-size: $font-lg;
		&:after{
			border-radius: 100px;
		}
	}
	.feedback-body {
		background: $color-white;
		padding: $spacing-base $spacing-lg;
		.gender-item {
			margin-right: 20upx;

			.gender-item-text {
				padding-left: 10upx;
			}

			radio .wx-radio-input.wx-radio-input-checked {
				background: $uni-color-primary;
				border-color: $uni-color-primary;
			}
		}
	}
}
</style>
