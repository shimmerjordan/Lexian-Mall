<template>
	<view class="page_box">
		<view class="head_box x-bc" >
			<view class="count-box" v-if="!favoriteList.length">
				<text>空空如也</text>
				</view>
			<view class="count-box" v-if="favoriteList.length">
				共
				<text class="all-num">{{ total }}</text>
				件商品
			</view>
		<button class="cu-btn set-btn" v-if="favoriteList.length" @tap="onSet">{{ isSel ? '完成' : '编辑' }}</button>
				</view>
				<view class="content_box">
					<scroll-view scroll-y="true"  class="scroll-box">
						<checkbox-group @change="onSel" v-if="favoriteList.length">
							<view class="collect-list x-f" v-for="(item , index) in favoriteList" :key="index">
								<checkbox v-if="isSel" :value="item.id.toString()" :checked="item.checked" :class="{ checked: item.checked }" class="goods-radio round orange"></checkbox>
								<shopro-mini-card :detail="item" :type="'favorite'"></shopro-mini-card>
							</view>
						</checkbox-group>
						<!-- 缺省页 -->
						<view v-if="!favoriteList.length">
							<navigator class="navigator" v-if="hasLogin" url="../index/index" open-type="switchTab">随便逛逛></navigator>
						</view> 
						<!-- 更多 -->
						<view v-if="favoriteList.length" class="cu-load text-gray" :class="loadStatus"></view>
					</scroll-view>
				</view>
				<view class="foot_box ">
					<view class="tools-box x-bc" v-if="isSel && favoriteList.length">
						<label class="check-all" @tap="onAllSel"> 
							<radio :checked="allSel" :class="{ checked: allSel }" class="check-all-radio orange"></radio>
							<text>全选</text>
						</label>
						<button class="cu-btn close-btn" @tap="cancelFavorite" >取消收藏</button>
					</view>
				</view>
			</view>
		</template>
		
		<script>
		import shoproMiniCard from '@/components/mini-card/mini-card.vue';
		import common from '@/store/common.js'
		import {  mapState } from 'vuex';
		export default {
			components: {
				shoproMiniCard,
			},
			data() {
				return {
					isSel: false,
					allSel: false,
					selList: [],
					favoriteList: [],
					total: 0,
					loadStatus: '', //loading,over
					currentPage: 1,
					lastPage: 0
				};
			},
			computed: {
				...mapState(['hasLogin'])
			},
			onLoad() {
				this.init();
			},
			onShow() {
				this.init();
			},
			methods: {
				getUser() {
					         if(this.hasLogin){
								let that = this;
								that.userInfo = common.getGlobalUserInfo();
								// console.log("本地UserInfo",this.userInfo)
								}
							},
				init() {
				   this.loadStatus = 'loading';
				   this.getUser();
				   if(this.hasLogin){
					uni.request({
						url: this.apiServer + "/uniUser/getFavorites",
						//url:'http://localhost:8080/..."' ,
						data:{
							"userID": this.userInfo.ID.toString(),
							},
						method: 'POST',
						success: (res) => {
						let favoriteList = res.data;
						this.favoriteList = favoriteList;
						this.total = favoriteList.length;
						}
					});		
					};
				},
				navBack(){
					uni.navigateBack({					
					})
				},
				onSel(e) {
					let items = this.favoriteList,
						values = e.detail.value;
					this.selList = values;
					items.forEach(item => {
						if (values.includes(item.id.toString())) {
							this.$set(item, 'checked', true);
						} else {
							this.$set(item, 'checked', false);
						}
					});
					if (this.selList.length < items.length) {
						this.allSel = false;
					} else {
						this.allSel = true;
					}
				},
				onSet() {
					this.isSel = !this.isSel;
				},
				onAllSel() {	
					this.allSel = !this.allSel;
					this.selList = [];
					const { favoriteList } = this;
					favoriteList.forEach(item => {
						if (this.allSel) {
							this.$set(item, 'checked', true);
							this.selList.push(item.id);
						} else {
							this.$set(item, 'checked', false);
						}
					});
				},	
				//商品跳转
				navToDetailPage(item) { 
					let itemID = item.id;
					uni.navigateTo({
						 url: `/pages/product/product?id=${itemID}`
					});
				},	
				//取消收藏
				cancelFavorite() {
					this.getUser();
					let ids = this.selList;
					console.log(ids);
					ids.forEach(id => {
					uni.request({
						url: this.apiServer + "/uniUser/cancelFavorite",
						//url:'http://localhost:8080/..."' ,
						data:{
							"ID": id,
							"userID": this.userInfo.ID.toString(),
							},
						method: 'POST',
						success: (res) => {
						this.init();	
						}
					});	
						});
					uni.hideLoading();
				}					
		}
	}
	</script>

<style lang="scss">
.head_box {
	height: 70rpx;
	padding: 0 30rpx;
    .back-btn{
		position:absolute;
		top: 0upx;
	    left: 0;
		width: 120upx;
		height: 70upx;
		background: #ffffff;
		font-size: 26rpx;
		color: #000000;
	}
	.count-box {
		position:absolute;
		left: 20upx;
		font-size: 26rpx;
		color: #999;

		.all-num {
			color: #a8700d;
		}
	}

	.set-btn {
		position:absolute;
		top: 0;
		right: 20upx;
		width: 200upx;
		height: 70upx;
		background: none;
		font-size: 26rpx;
		color: #a8700d;
	}
}

.collect-list {
	padding: 30rpx 20rpx;
	background: #fff;
	margin-bottom: 20rpx;

	.goods-radio {
		transform: scale(0.7);
		margin-right: 20rpx;
	}
}

.tools-box {
	height: 100rpx;
	width: 750rpx;
	padding: 0 20rpx;
	background: #fff;

	.check-all {
		font-size: 26rpx;

		.check-all-radio {
			transform: scale(0.7);
		}
	}

	.close-btn {
		width: 200rpx;
		height: 70rpx;
		background: linear-gradient(90deg, rgba(233, 180, 97, 1), rgba(238, 204, 137, 1));
		box-shadow: 0px 7rpx 6rpx 0px rgba(229, 138, 0, 0.22);
		border-radius: 35rpx;
		padding: 0;
		color: rgba(#fff, 0.9);
		position:absolute;
		right: 40upx;
	}
}
</style>
