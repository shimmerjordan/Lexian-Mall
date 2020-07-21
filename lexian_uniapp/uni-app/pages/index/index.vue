<template>
	<view class="container">
		<!-- 小程序适配 搜索栏-->
		<!-- #ifdef MP-->
		<view class="content">
			<uni-search :iconSrc="iconSrc" :inputAttr="inputAttr" v-model="searchName"  @confirm="searchCommodity()" >
		</uni-search>
		</view>
		<!-- #endif -->
		<!-- H5适配 搜索栏-->
		<!-- #ifdef H5-->
		 <view class="mp-search-box">
			<input  class="ser-input" type="text" placeholder="请输入商品数据"  v-model="searchName" @input="inputChange" @confirm="searchCommodity()" />				  
		</view> 
		<!-- #endif  -->
		
		
		<!-- 头部轮播 -->
		<view class="carousel-section">
			<!-- 标题栏和状态栏占位符 -->
			<view class="titleNview-placing"></view>
			<!-- 背景色区域 -->
			<view class="titleNview-background" :style="{backgroundColor:titleNViewBackground}"></view>
			<swiper class="carousel" circular @change="swiperChange">
				<swiper-item v-for="(item , index) in carouselList" :key="index" class="carousel-item" @click="navToActivity(item)">
					<image :src="item.img" mode:aspectFill />
				</swiper-item>
			</swiper>
			<!-- 自定义swiper指示器 -->
			<view class="swiper-dots">
				<text class="num">{{swiperCurrent+1}}</text>
				<text class="sign">/</text>
				<text class="num">{{swiperLength}}</text>
			</view>
		</view>
		<!-- 分类 -->
		<view class="cate-section">
			<view class="cate-item" >
				<image src="/static/temp/i7.png" @click="navTo()"></image>
				<text >手机数码</text>
			</view>
			<view class="cate-item" @click="navTo()">
				<image src="/static/temp/i5.png"></image>
				<text >男装女装</text>
			</view>
			<view class="cate-item" @click="navTo()">
				<image src="/static/temp/i4.png"></image>
				<text >儿童用品</text>
			</view>
			<view class="cate-item" @click="navTo()">
				<image src="/static/temp/i6.png"></image>
				<text >工艺摆件</text>
		     </view>
			<view class="cate-item" @click="navTo()">
				<image src="/static/temp/i8.png"></image>
				<text >零食水果</text>
			</view>	
		</view>
		<!-- 店铺活动宣传 -->
		<view class="ad-1" @click="navTo()">
			<image src="/static/temp/ad1.jpg" mode="scaleToFill"></image>
		<!-- 店铺活动宣传的页面跳转 -->	
		</view>
		
		<!-- 秒杀楼层 -->
		<!-- 动态刷新功能 -->
           <view class="seckill-section m-t">
           	<view class="s-header">
           		<image class="s-img" src="/static/temp/secskill-img.jpg" mode="widthFix"></image>
           		<text class="tip">{{date.slice(0, 10)}}</text>
				<view class="hour timer">{{countDownHour}}</view>
           		<view class="minute timer">{{countDownMinute}}</view>
				<view class="second timer">{{countDownSecond}}</view>
           		<text class="yticon icon-you"></text>
           	</view>
			<scroll-view class="floor-list" scroll-x>
				<view class="scoll-wrapper">
					<view 
						v-for="(item, index) in mGoodsList" :key="index"
						class="floor-item"
						@click="navToDetailPage(item)"
					>
						<image :src="item.image" mode="aspectFill"></image>
						<text class="title clamp">{{item.name}}</text>
						<text class="price">￥{{item.price}}</text>
					</view>
				</view>
			</scroll-view>
		</view>
		
		<!-- 折扣商品楼层 -->
		<view class="f-header m-t">
			<image src="/static/temp/i11.jpg"></image>
			<view class="tit-box">
				<text class="tit">精选折扣商品</text>
				<text class="tit2">Selected Discounted Products</text>
			</view>
			<text class="yticon icon-you"></text>
		</view>
		<view class="group-section">
			<swiper class="g-swiper" :duration="500">
				<swiper-item
					class="g-swiper-item"
					v-for="(item, index) in tGoodsList" :key="index"
			        v-if="index%2 === 0"
					@click="navToDetailPage(item)"
				>
					<view class="g-item left">
						<image :src="item.image" mode="aspectFit"></image>
						<view class="t-box">
							<text class="title clamp">{{item.name}}</text>
							<view class="price-box">
								<text class="price">￥{{item.price}}</text> 
								<text class="m-price">￥28</text> 
							</view>
							
							<view class="pro-box">
							  	<view class="progress-box">
							  		<progress percent="72" activeColor="#fa0919" active stroke-width="6" />
							  	</view>
								<text>6人成团</text>
							</view>
						</view>
						            
					</view>
					<view class="g-item right">
						<image :src="tGoodsList[index].image" mode="aspectFit"></image>
						<view class="t-box">
							<text class="title clamp">{{tGoodsList[index].name}}</text>
							<view class="price-box">
								<text class="price">￥{{tGoodsList[index].price}}</text> 
								<text class="m-price">￥39</text> 
							</view>
							<view class="pro-box">
							  	<view class="progress-box">
							  		<progress percent="72" activeColor="#fa436a" active stroke-width="6" />
							  	</view>
								<text>10人成团</text>
							</view>
						</view>
					</view>
				</swiper-item>

			</swiper>
		</view>
		
		
		
		<!-- 分类推荐楼层 -->
		<view class="f-header m-t">
			<image src="/static/temp/i10.jpg"></image>
			<view class="tit-box">
				<text class="tit">活动精选</text>
				<text class="tit2">Competitive Products For You</text>
			</view>
			<text class="yticon icon-you"></text>
		</view>
		<view class="hot-floor">
			<view class="floor-img-box">
				<image class="floor-img" src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1553409398864&di=4a12763adccf229133fb85193b7cc08f&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201703%2F19%2F20170319150032_MNwmn.jpeg" mode="scaleToFill"></image>
			</view>
			<scroll-view class="floor-list" scroll-x>
				<view class="scoll-wrapper">
					<view 
						v-for="(item, index) in hGoodsList" :key="index"
						class="floor-item"
						@click="navToDetailPage(item)"
					>
						<image :src="item.image" mode="aspectFill"></image>
						<text class="title clamp">{{item.name}}</text>
						<text class="price">￥{{item.price}}</text>
					</view>
					<view class="more">
						<text>查看更多</text>
						<text>More+</text>
					</view>
				</view>
			</scroll-view>
		</view>
		<view class="hot-floor">
			<view class="floor-img-box">
				<image class="floor-img" src="https://s1.ax1x.com/2020/07/19/URLhX6.jpg" mode="scaleToFill"></image>
			</view>
			<scroll-view class="floor-list" scroll-x>
				<view class="scoll-wrapper">
					<view 
						v-for="(item, index) in dGoodsList" :key="index"
						class="floor-item"
						@click="navToDetailPage(item)"
					>
						<image :src="item.image" mode="aspectFill"></image>
						<text class="title clamp">{{item.name}}</text>
						<text class="price">￥{{item.price}}</text>
					</view>
					<view class="more">
						<text>查看更多</text>
						<text>More+</text>
					</view>
				</view>
			</scroll-view>
		</view>
		<view class="hot-floor">
			<view class="floor-img-box">
				
				<image class="floor-img" src="https://s1.ax1x.com/2020/07/19/UROB8A.jpg" mode="scaleToFill"></image>
	
			</view>
			<scroll-view class="floor-list" scroll-x>
				<view class="scoll-wrapper">
					<view 
						v-for="(item, index) in sGoodsList" :key="index"
						class="floor-item"
						@click="navToDetailPage(item)"
					>
						<image :src="item.image" mode="aspectFill"></image>
						<text class="title clamp">{{item.name}}</text>
						<text class="price">￥{{item.price}}</text>
					</view>
					<view class="more">
						<text>查看更多</text>
						<text>More+</text>
					</view>
				</view>
			</scroll-view>
		</view>

		<!-- 猜你喜欢 -->
		<view class="f-header m-t">
			<image src="/static/temp/i9.jpg"></image>
			<view class="tit-box">
				<text class="tit">猜你喜欢</text>
				<text class="tit2">Guess Your Interests</text>
			</view>
			<text class="yticon icon-you"></text>
		</view>
		
		<view class="guess-section">
			<view 
				v-for="(item, index) in gGoodsList" :key="index"
				class="guess-item"
				@click="navToDetailPage(item)"
			>
				<view class="image-wrapper">
					<image :src="item.image" mode="aspectFill"></image>
				</view>
				<text class="title clamp">{{item.name}}</text>
				<text class="price">￥{{item.price}}</text>
			</view>
		</view>
		

	</view>
</template>

<script>
import uniSearch from '../../components/lee-search/lee-search.vue'
import common from '@/store/common.js'
import util from '@/store/utils.js'
import {  mapState } from 'vuex';
	export default {
		computed: {
			...mapState(['hasLogin'])
		},
		data() {
			return {
				searchName: '',
				countDownHour: 0, //倒计时 -时
				countDownMinute: 0,  //倒计时 -分
				countDownSecond: 0,  //倒计时-秒
				searchList: [],
				titleNViewBackground: '',
				swiperCurrent: 0,
				swiperLength: 0,
				carouselList: [],
				goodsList: [],
				mGoodsList: [],
				tGoodsList: [],
				hGoodsList: [],
				dGoodsList: [],
				sGoodsList: [],
				gGoodsList: [],
				salesItemList: [],
				date: new Date(+new Date(new Date().toJSON())+8*3600*1000).toISOString(),
				iconSrc: {
					logo: '../../static/lee-search/icon_search.png',
					voice: '../../static/lee-search/icon_voice.png',
					scan: '../../static/lee-search/icon_scan.png',
					clear:'../../static/lee-search/icon_clear.png'
				},
				inputAttr: {
					backgroundColor: '#ccc',
					placeholderText: '请输入内容'
				},
			};
		},
      components:{
		  uniSearch
      },
	  onShow(){
	  	this.$forceUpdate()
	  	setTimeout(()=>{
	  		this.getUser();
	  	}, 200)
		},
		onLoad() {
			setTimeout(()=>{
				this.getUser();
			}, 200)
			this.loadData();
			//设置倒计时时间，1s变换一次
			var interval = setInterval(function () {
				var d = new Date();   //获取系统日期和时间
				var nowHour = d.getHours(); //小时
				var nowMinutes = d.getMinutes(); //分
				var nowSeconds = d.getSeconds(); //秒

				// 显示在倒计时中的小时位
				var hour = 24 - nowHour;

				// 显示在倒计时中的分钟位
				var minutes = 60 - nowMinutes;
				// 显示在倒计时中的秒数
				var seconds = 60 - nowSeconds;
				//当小时、分钟、秒都为0时，活动结束，倒计时显示为00:00:00
				if (hour == 0 && minutes == 0 && seconds == 0) {

					clearInterval(interval);
					uni.showToast({
						title: '活动已结束',
					});
					console.log(totalSecond);
		                           
					this.countDownHour =  '00';
					this.countDownMinute = '00';
					this.countDownSecond= '00';
				}
				//当小时位、分钟位、秒位小于10时，用字符串拼接的方式显示，例如：06:08:02
				if (hour < 10) {
					hour = "0" + hour;
				}
				if (minutes < 10) {
					minutes = "0" + minutes;
				}
				if (seconds < 10) {
					seconds = "0" + seconds;
				}
				this.countDownHour = hour;
				this.countDownMinute = minutes;
				this.countDownSecond = seconds;
			}.bind(this), 1000);

		},
		computed: {
			...mapState(['hasLogin'])
		},
		methods: {
			getUser() { 
				if(this.hasLogin){
					let that = this;
					that.userInfo = common.getGlobalUserInfo();
					// console.log("本地UserInfo",this.userInfo)
					}
			},
			async loadData() {
				//获取活动数据
				uni.request({
					url: this.apiServer + "/uniIndex/getActivity",
					//url:'http://localhost:8080/getAllActivity"' ,
					method: 'GET',
					success: (res) => {
					let carouselList = res.data;
					this.carouselList = carouselList;
					this.titleNViewBackground = "rgb(205, 215, 218)";
					this.swiperLength = carouselList.length;
					}
				});
				//获取商品数据
				uni.request({
					url: this.apiServer + "/uniIndex/init",
					//url:'http://localhost:8080/uniIndex/init' ,
				    method: 'GET',
					success: (res) =>{
					let goodslist =res.data;
				    this.goodslist = goodslist;
					goodslist.forEach(item=>{
						if(item.index==1){
							this.mGoodsList.push(item);  //获取秒杀商品
						}else if(item.index==2){
							this.tGoodsList.push(item);  //获取团购商品
						}else if(item.index==3){
							this.hGoodsList.push(item);  //获取活动1商品
						}else if(item.index==4){
							this.dGoodsList.push(item);  //获取活动2商品
						}else if(item.index==5){
							this.sGoodsList.push(item);  //获取活动3商品
						}else if(item.index==6){
							this.gGoodsList.push(item); //猜你喜欢
						}else {
						}
					})
					}
				});
			},
			inputChange(e) {
			console.log(e.detail);
			const keyword = event.detail.value;
			this.searchName = keyword;
			console.log(this.searchName);
			},
			searchCommodity() {
				let searchName= this.searchName;
				console.log(searchName);
				uni.request({
					url: this.apiServer + "/uniIndex/indexSearch",
					data: {searchName: searchName
					},
					method: 'POST',
					success: (res) => {
					let searchList = res.data;
					this.searchList = searchList;
					},
				});
				let itemID = this.searchList[0].id;
				let userId ="";
				uni.getStorage({
				    key:"userInfo",
				 	success(e){
				  	userId = e.data.ID;//这就是你想要取的token
					// if(userId == undefined){
					// 	userId = e.data.ID;
					// }
				}
				});
				uni.navigateTo({
					 url: `/pages/product/product?id=${itemID}&uid=${userId}`
				});
				},
			//轮播图切换修改背景色
			swiperChange(e) {
				const index = e.detail.current;
				this.swiperCurrent = index;
				this.titleNViewBackground = this.carouselList[index].background;
			},
			//跳转到活动商品
			navToActivity(item) {
				let aID = item.id;
				uni.request({
					url: this.apiServer + "/uniIndex/getSalesItem",
					data: {aID: aID.toString()
					},
					method: 'POST',
					success: (res) => {
					let salesItemList = res.data;
					this.salesItemList = salesItemList;
					},
				});
				let itemID = this.salesItemList[0].id;
				let userId ="";
				uni.getStorage({
				    key:"userInfo",
				 	success(e){
				  	userId = e.data.ID;//这就是你想要取的token
					// if(userId == undefined){
					// 	userId = e.data.ID;
					// }
				}
				});
				uni.navigateTo({
					 url: `/pages/product/product?id=${itemID}&uid=${userId}`
				});
				},
			//详情页
			navToDetailPage(item) {		
				let itemID = item.id;
				let userId ="";
				uni.getStorage({
				    key:"userInfo",
				 	success(e){
				  	userId = e.data.ID;//这就是你想要取的token
					// if(userId == undefined){
					// 	userId = e.data.ID;
					// }
				}
				});
				uni.navigateTo({
					 url: `/pages/product/product?id=${itemID}&uid=${userId}`
				});
			},
			navTo() {
				uni.navigateTo({
					url: `pages/category/category`
				})
			},

		// #ifndef MP
		//点击导航栏 buttons 时触发
		onNavigationBarButtonTap(e) {
			const index = e.index;
			if (index === 0) {
				this.$api.msg('点击了扫描');
			} else if (index === 1) {
				// #ifdef  APP-PLUS
				const pages = getCurrentPages();
				const page = pages[pages.length - 1];
				const currentWebview = page.$getAppWebview();
				currentWebview.hideTitleNViewButtonRedDot({
					index
				});
				// #endif
				uni.navigateTo({
					url: '/pages/notice/notice'
				})
			}
		}
		// #endif
	},
}
</script>

<style lang="scss">
	.mp-search-box{
		position:absolute;
		left: 0;
		top: 17upx;
		z-index: 9999;
		width: 100%;
		padding: 0 80upx;
		display: inline-block;
		.ser-input{
			flex:1;
			height: 56upx;
			line-height: 56upx;
			text-align: center;
			font-size: 28upx;
			color:$font-color-base;
			border-radius: 20px;
			background: rgba(221, 230, 255, 0.6);
		}
		.content {
			text-align: center;
			height: 400upx;
			.icon-wrap{
				position:relative;
				height:60upx;
				top:0;
				box-sizing: border-box;
				.icon{
					width:60upx;
					height:60upx;
					padding:10upx;
					box-sizing: border-box;
				}
			}
		}
	
	}
	page{
		.cate-section{
			position:relative;
			z-index:5;
			border-radius:16upx 16upx 0 0;
			margin-top:-20upx;
		}
		.carousel-section{
			padding: 0;
			.titleNview-placing {
				padding-top: 0;
				height: 0;
			}
			.carousel{
				.carousel-item{
					padding: 0;
				}
			}
			.swiper-dots{
				left:45upx;
				bottom:40upx;
			}
		}
	}
	page {
		background: #f5f5f5;
	}
	.m-t{
		margin-top: 16upx;
	}
	/* 头部 轮播图 */
	.carousel-section {
		position: relative;
		padding-top: 10px;

		.titleNview-placing {
			height: var(--status-bar-height);
			padding-top: 44px;
			box-sizing: content-box;
		}

		.titleNview-background {
			position: absolute;
			top: 0;
			left: 0;
			width: 100%;
			height: 426upx;
			transition: .4s;
		}
	}
	.carousel {
		width: 100%;
		height: 350upx;

		.carousel-item {
			width: 100%;
			height: 100%;
			padding: 0 28upx;
			overflow: hidden;
		}

		image {
			width: 100%;
			height: 100%;
			border-radius: 10upx;
		}
	}
	.swiper-dots {
		display: flex;
		position: absolute;
		left: 60upx;
		bottom: 15upx;
		width: 72upx;
		height: 36upx;
		background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAABkCAYAAADDhn8LAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTMyIDc5LjE1OTI4NCwgMjAxNi8wNC8xOS0xMzoxMzo0MCAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6OTk4MzlBNjE0NjU1MTFFOUExNjRFQ0I3RTQ0NEExQjMiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6OTk4MzlBNjA0NjU1MTFFOUExNjRFQ0I3RTQ0NEExQjMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTcgKFdpbmRvd3MpIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6Q0E3RUNERkE0NjExMTFFOTg5NzI4MTM2Rjg0OUQwOEUiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6Q0E3RUNERkI0NjExMTFFOTg5NzI4MTM2Rjg0OUQwOEUiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz4Gh5BPAAACTUlEQVR42uzcQW7jQAwFUdN306l1uWwNww5kqdsmm6/2MwtVCp8CosQtP9vg/2+/gY+DRAMBgqnjIp2PaCxCLLldpPARRIiFj1yBbMV+cHZh9PURRLQNhY8kgWyL/WDtwujjI8hoE8rKLqb5CDJaRMJHokC6yKgSCR9JAukmokIknCQJpLOIrJFwMsBJELFcKHwM9BFkLBMKFxNcBCHlQ+FhoocgpVwwnv0Xn30QBJGMC0QcaBVJiAMiec/dcwKuL4j1QMsVCXFAJE4s4NQA3K/8Y6DzO4g40P7UcmIBJxbEesCKWBDg8wWxHrAiFgT4fEGsB/CwIhYE+AeBAAdPLOcV8HRmWRDAiQVcO7GcV8CLM8uCAE4sQCDAlHcQ7x+ABQEEAggEEAggEEAggEAAgQACASAQQCCAQACBAAIBBAIIBBAIIBBAIABe4e9iAe/xd7EAJxYgEGDeO4j3EODp/cOCAE4sYMyJ5cwCHs4rCwI4sYBxJ5YzC84rCwKcXxArAuthQYDzC2JF0H49LAhwYUGsCFqvx5EF2T07dMaJBetx4cRyaqFtHJ8EIhK0i8OJBQxcECuCVutxJhCRoE0cZwMRyRcFefa/ffZBVPogePihhyCnbBhcfMFFEFM+DD4m+ghSlgmDkwlOgpAl4+BkkJMgZdk4+EgaSCcpVX7bmY9kgXQQU+1TgE0c+QJZUUz1b2T4SBbIKmJW+3iMj2SBVBWz+leVfCQLpIqYbp8b85EskIxyfIOfK5Sf+wiCRJEsllQ+oqEkQfBxmD8BBgA5hVjXyrBNUQAAAABJRU5ErkJggg==);
		background-size: 100% 100%;

		.num {
			width: 36upx;
			height: 36upx;
			border-radius: 50px;
			font-size: 24upx;
			color: #fff;
			text-align: center;
			line-height: 36upx;
		}

		.sign {
			position: absolute;
			top: 0;
			left: 50%;
			line-height: 36upx;
			font-size: 12upx;
			color: #fff;
			transform: translateX(-50%);
		}
	}
	/* 分类 */
	.cate-section {
		display: flex;
		justify-content: space-around;
		align-items: center;
		flex-wrap:wrap;
		padding: 30upx 22upx; 
		background: #fff;
		.cate-item {
			display: flex;
			flex-direction: column;
			align-items: center;
			font-size: $font-sm + 2upx;
			color: $font-color-dark;
		}
		/* 原图标颜色太深,不想改图了,所以加了透明度 */
		image {
			width: 88upx;
			height: 88upx;
			margin-bottom: 14upx;
			border-radius: 50%;
			opacity: .7;
			box-shadow: 4upx 4upx 20upx rgba(250, 67, 106, 0.3);
		}
	}
	.ad-1{
		width: 100%;
		height: 210upx;
		padding: 10upx 0;
		background: #fff;
		image{
			width:100%;
			height: 100%; 
		}
	}
	/* 秒杀专区 */
	.seckill-section{
		padding: 4upx 30upx 24upx;
		background: #fff;
		.s-header{
			display:flex;
			align-items:center;
			height: 92upx;
			line-height: 1;
			.s-img{
				width: 140upx;
				height: 30upx;
			}
			.tip{
				font-size: $font-base;
				color: $font-color-light;
				margin: 0 20upx 0 40upx;
			}
			.timer{
				display:inline-block;
				width: 40upx;
				height: 36upx;
				text-align:center;
				line-height: 36upx;
				margin-right: 14upx;
				font-size: $font-sm+2upx;
				color: #fff;
				border-radius: 2px;
				background: rgba(0,0,0,.8);
			}
			.icon-you{
				font-size: $font-lg;
				color: $font-color-light;
				flex: 1;
				text-align: right;
			}
		}
		.floor-list{
			white-space: nowrap;
		}
		.scoll-wrapper{
			display:flex;
			align-items: flex-start;
		}
		.floor-item{
			width: 150upx;
			margin-right: 20upx;
			font-size: $font-sm+2upx;
			color: $font-color-dark;
			line-height: 1.8;
			image{
				width: 150upx;
				height: 150upx;
				border-radius: 6upx;
			}
			.price{
				color: $uni-color-primary;
			}
		}
	}
	
	.f-header{
		display:flex;
		align-items:center;
		height: 140upx;
		padding: 6upx 30upx 8upx;
		background: #fff;
		image{
			flex-shrink: 0;
			width: 80upx;
			height: 80upx;
			margin-right: 20upx;
		}
		.tit-box{
			flex: 1;
			display: flex;
			flex-direction: column;
		}
		.tit{
			font-size: $font-lg +2upx;
			color: #font-color-dark;
			line-height: 1.3;
		}
		.tit2{
			font-size: $font-sm;
			color: $font-color-light;
		}
		.icon-you{
			font-size: $font-lg +2upx;
			color: $font-color-light;
		}
	}
	/* 团购楼层 */
	.group-section{
		background: #fff;
		.g-swiper{
			height: 650upx;
			padding-bottom: 30upx;
		}
		.g-swiper-item{
			width: 100%;
			padding: 0 30upx;
			display:flex;
		}
		.image{
			width: 100%;
			height: 460upx;
			border-radius: 4px;
		}
		.g-item{
			display:flex;
			flex-direction: column;
			overflow:hidden;
		}
		.left{
			flex: 1.2;
			margin-right: 24upx;
			.t-box{
				padding-top: 20upx;
			}
		}
		.right{
			flex: 0.8;
			flex-direction: column-reverse;
			.t-box{
				padding-bottom: 20upx;
			}
		}
		.t-box{
			height: 160upx;
			font-size: $font-base+2upx;
			color: $font-color-dark;
			line-height: 1.6;
		}
		.price{
			color:$uni-color-primary;
		}
		.m-price{
			font-size: $font-sm+2upx;
			text-decoration: line-through;
			color: $font-color-light;
			margin-left: 8upx;
		}
		.pro-box{
			display:flex;
			align-items:center;
			margin-top: 10upx;
			font-size: $font-sm;
			color: $font-base;
			padding-right: 10upx;
		}
		.progress-box{
			flex: 1;
			border-radius: 10px;
			overflow: hidden;
			margin-right: 8upx;
		}
	}
	/* 分类推荐楼层 */
	.hot-floor{
		width: 100%;
		overflow: hidden;
		margin-bottom: 20upx;
		.floor-img-box{
			width: 100%;
			height:320upx;
			position:relative;
			&:after{
				content: '';
				position:absolute;
				left: 0;
				top: 0;
				width: 100%;
				height: 100%;
				background: linear-gradient(rgba(255,255,255,.06) 30%, #f8f8f8);
			}
		}
		.floor-img{
			width: 100%;
			height: 100%;
		}
		.floor-list{
			white-space: nowrap;
			padding: 20upx;
			padding-right: 50upx;
			border-radius: 6upx;
			margin-top:-140upx;
			margin-left: 30upx;
			background: #fff;
			box-shadow: 1px 1px 5px rgba(0,0,0,.2);
			position: relative;
			z-index: 1;
		}
		.scoll-wrapper{
			display:flex;
			align-items: flex-start;
		}
		.floor-item{
			width: 180upx;
			margin-right: 20upx;
			font-size: $font-sm+2upx;
			color: $font-color-dark;
			line-height: 1.8;
			image{
				width: 180upx;
				height: 180upx;
				border-radius: 6upx;
			}
			.price{
				color: $uni-color-primary;
			}
		}
		.more{
			display:flex;
			align-items: center;
			justify-content: center;
			flex-direction: column;
			flex-shrink: 0;
			width: 180upx;
			height: 180upx;
			border-radius: 6upx;
			background: #f3f3f3;
			font-size: $font-base;
			color: $font-color-light;
			text:first-child{
				margin-bottom: 4upx;
			}
		}
	}
	/* 猜你喜欢 */
	.guess-section{
		display:flex;
		flex-wrap:wrap;
		padding: 0 30upx;
		background: #fff;
		.guess-item{
			display:flex;
			flex-direction: column;
			width: 48%;
			padding-bottom: 40upx;
			&:nth-child(2n+1){
				margin-right: 4%;
			}
		}
		.image-wrapper{
			width: 100%;
			height: 330upx;
			border-radius: 3px;
			overflow: hidden;
			image{
				width: 100%;
				height: 100%;
				opacity: 1;
			}
		}
		.title{
			font-size: $font-lg;
			color: $font-color-dark;
			line-height: 80upx;
		}
		.price{
			font-size: $font-lg;
			color: $uni-color-primary;
			line-height: 1;
		}
	}
	

</style>
