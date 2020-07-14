<template>
	<view class="container">
		<view class="left-bottom-sign"></view>
		<view class="back-btn yticon icon-zuojiantou-up" @click="navBack"></view>
		<view class="right-top-sign"></view>
		<!-- 设置白色背景防止软键盘把下部绝对定位元素顶上来盖住输入框等 -->
		<view class="wrapper">
			<view class="left-top-sign">LOGIN</view>
			<view class="welcome">
				实名注册验证
			</view>
			<view class="input-content">
				<view class="input-item">
					<text class="tit">真实姓名：</text>
					<input 
						type="text" 
						:value="name"
						placeholder="请输入真实姓名"
						maxlength="11"
						data-key="name"
						@input="inputChange"
					/>
				</view>
				<view class="input-item">
					<text class="tit">身份证号码：</text>
					<input 
						type="text"
						:value="certificationId"
						placeholder="请输入身份证号码"
						maxlength="18"
						data-key="certificationId"
						@input="inputChange"
					/>
				</view>
				
			</view>
			
			<view class="cu-bar bg-white margin-top">
				<view class="action">
					身份证头像面照片上传
				</view>
				<view class="action">
					{{imgList.length}}/1
				</view>
			</view>
			<view class="cu-form-group">
				<view class="grid col-1 grid-square flex-sub">
					<view class="bg-img" v-for="(item,index) in imgList" :key="index" @tap="ViewImage" :data-url="imgList[index]">
					 <image :src="imgList[index]" mode="aspectFill"></image>
						<view class="cu-tag bg-red" @tap.stop="DelImg" :data-index="index">
							<text class='cuIcon-close'></text>
						</view>
					</view>
					<view class="solids" @tap="ChooseImage" v-if="imgList.length<1">
						<text class='cuIcon-cameraadd'></text>
					</view>
				</view>
			</view>
		
		</view>
			
			<button class="confirm-btn" @click="certificate" >点击认证身份信息</button>
		
	</view>
</template>
 
<script>
	var that;
	import common from '@/store/common.js'
	// 这是一个用不了的插件，要付费
	// const card = uni.requireNativePlugin('DC-CardRecognize');
	export default{
		data() {
			return {
				title: 'input',
				focus: false,
				name: "",
				certificationId:"",
				src:"../../../../static/me/photo.png",
				httpUrl:"https://aip.baidubce.com/rest/2.0/ocr/v1/general?access_token=",
				imageBase64Str:"",
				access_token:"",
				imgList: [],
				modalName: null,
				index:-1,
				APIKey: 'iiZYcBEgl437fmYiC6ErYE4c',
				SecretKey: 'xDToNT5kg702YPvFC85tITLBb7sB4g8l'

			}
		},
		onLoad() {
			// var that=this;
			// token验证
			this.getAccess_token();
		},
		methods: {
			certificate() {
				console.log(common.getGlobalUserInfo().ID,this.name,this.certificationId);
				var flag = this.verifyData();
				if(flag){
					this.getIDCard();
					uni.request({
						url: this.apiServer + '/customer/setCertificationId',
						method: 'POST',
						dataType: "json",
						data: {
							"customerId": common.getGlobalUserInfo().ID,
							"name": this.name,
							"certificationId": this.certificationId
						},
						success: (res) => {
							const result = res.data
							console.log("后台返回数据",result)
							if(result.status == 500){
								this.$api.msg('网络错误');
							}
							if(result == false){
								this.$api.msg('操作失败，请刷新重试');
							}
							if(result == true){
								this.$api.msg('操作成功');
								uni.navigateTo({
									url: "/pages/user/user",
								});
							}
						},
						fail: res => {
							this.$api.msg("网络错误")
						}
					});
				}
			},
			inputChange(e) {
				const key = e.currentTarget.dataset.key;
				this[key] = e.detail.value;
			},
			navBack() {
				uni.navigateBack({
					delta: 1
				});
			},
			//选择图片
			ChooseImage() {
				
				uni.chooseImage({
					count: 1, //默认9
					sizeType: ['compressed'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['album','camera'], //从相册选择
					success: (res) => {
						if (res.tempFilePaths.length == 0) {
							this.imgList = res.tempFilePaths
							console.log('2')
							console.log("this.imgList.length", this.imgList.length)
						} else {
							this.imgList = this.imgList.concat(res.tempFilePaths)
							this.urlTobase64(res.tempFilePaths[0]);
							console.log('1')
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
			getAccess_token(){
				var that = this;
				var accessToken= that.cache("accessToken",null,null) || '';
				console.log(accessToken)
				if(!accessToken){
					uni.request({
						url: "https://aip.baidubce.com/oauth/2.0/token",
						method: 'POST',
						header: {
							'Content-Type': 'application/x-www-form-urlencoded'
						},
						data:{
							grant_type: "client_credentials",
							client_id: this.APIKey,
							client_secret: this.SecretKey
						},
						success: function(res) {
							console.log(res.data.access_token);
							uni.setStorageSync("Baidu",res.data);
							that.access_token=res.data.access_token;
							that.cache("accessToken",res.data.access_token,null) || '';
						}
					})
				}else{
					that.access_token=accessToken;
				}
 
			},
			//缓存,默认有效期28天
			cache:function(key, value, seconds) {
				var timestamp = Date.parse(new Date()) / 1000
				 console.log(timestamp+"==="+key)
				if (key && value === null) {
					//删除缓存
					//获取缓存
					var val = uni.getStorageSync(key);
					var tmp = val.split("|")
					if (!tmp[1] || timestamp >= tmp[1]) {
						console.log("key已失效")
						uni.removeStorageSync(key)
						return ""
					} else {
						console.log("key未失效")
						return tmp[0]
					}
				} else if (key && value) {
					//设置缓存
					if (!seconds) {
						var expire = timestamp + (3600 * 24 * 28)
					}else{
						var expire = timestamp + seconds
					}
					value = value + "|" + expire
					uni.setStorageSync(key, value);
				} else {
					console.log("key不能空")
				}
			},
			getIDCard() {
				var flag=this.verifyData();
				var that = this;
				if(flag){
					console.log("百度名片识别接口处理开始")
					//百度名片识别接口处理开始
					uni.showLoading({
						mask: true,
						title: "识别中，请等待"
					});
					uni.request({
						url: "https://aip.baidubce.com/rest/2.0/ocr/v1/idcard?access_token="+that.access_token,
						method: 'POST',
						header: {
							'Content-Type': 'application/x-www-form-urlencoded'
						},
						data: {
							image: that.imageBase64Str,
							id_card_side:"front"
						},
						success: function(res) {
							console.log(res);
							if(!res.data.error_code){
								var IdCard=res.data.words_result.公民身份号码.words;
								var userName=res.data.words_result.姓名.words;
								console.log(res.data.words_result.公民身份号码.words)
								if(IdCard==that.certificationId&&userName==that.name){
									console.log("身份验证成功");
									uni.showToast({
										icon: 'success',
										title: '身份验证成功'
									});
								}else{
									uni.showToast({
										icon: 'none',
										title: '身份信息有误请审核信息'
									});
								}
							}else{
								that.$api.msg('请求失败请稍后重试');
								// console.log(res);
							}
							
						},
						complete() { 
							uni.hideLoading();
						}
					})
				}
			
			},
			//校验输入的数据
			verifyData() {
				var flag = true;
				if (!this.name) {
					flag = false;
					uni.showToast({
						icon: 'none',
						title: '姓名不能为空'
					});
					return false;
				}
				if (!this.certificationId) {
					flag = false;
					uni.showToast({
						icon: 'none',
						title: '身份证号不能为空'
					});
					return false;
				}
				var re15 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
				var re18 = /^[1-9](\d{5})(19|20)(\d{2})((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)(\d{3})(\d|X|x)$/;
				var res = (re15.test(this.certificationId) || re18.test(this.certificationId));  
				if(res==false){
					flag = false;
				    uni.showToast({
				    	icon: 'none',
				    	title: '身份证号填写有误'
				    }); 
				    return false;  
				} 
				if(!this.imageBase64Str){
					flag = false;
					uni.showToast({
						icon: 'none',
						title: '请上传身份证照片含	头像面'
					}); 
					return false;  
				}
				return flag;
 
			}
		}
	}
</script>
 
<style lang='scss'>
	@import "/static/colorui/main.css";
	@import "/static/colorui/icon.css";
	@import "/static/colorui/animation.css";
	
	page{
		background: #fff;
	}
	.container{
		padding-top: 30px;
		position:relative;
		width: 100vw;
		height: 100vh;
		overflow: hidden;
		background: #fff;
	}
	.wrapper{
		position:relative;
		z-index: 60;
		background: #fff;
		padding-bottom: 40upx;
	}
	.back-btn{
		position:absolute;
		left: 40upx;
		z-index: 9999;
		padding-top: var(--status-bar-height);
		top: 40upx;
		font-size: 40upx;
		color: $font-color-dark;
	}
	.left-top-sign{
		font-size: 120upx;
		color: $page-color-base;
		position:relative;
		left: -16upx;
	}
	.right-top-sign{
		position:absolute;
		top: 80upx;
		right: -30upx;
		z-index: 95;
		&:before, &:after{
			display:block;
			content:"";
			width: 400upx;
			height: 80upx;
			background: #b4f3e2;
		}
		&:before{
			transform: rotate(50deg);
			border-radius: 0 50px 0 0;
		}
		&:after{
			position: absolute;
			right: -198upx;
			top: 0;
			transform: rotate(-50deg);
			border-radius: 50px 0 0 0;
			/* background: pink; */
		}
	}
	.left-bottom-sign{
		position:absolute;
		left: -270upx;
		bottom: -320upx;
		border: 100upx solid #d0d1fd;
		border-radius: 50%;
		padding: 180upx;
	}
	.welcome{
		position:relative;
		left: 50upx;
		top: -80upx;
		font-size: 46upx;
		color: #555;
		text-shadow: 1px 0px 1px rgba(0,0,0,.3);
	}
	.input-content{
		padding: 0 60upx;
	}
	.input-item{
		display:flex;
		flex-direction: column;
		align-items:flex-start;
		justify-content: center;
		padding: 0 30upx;
		background:$page-color-light;
		height: 120upx;
		border-radius: 4px;
		margin-bottom: 50upx;
		&:last-child{
			margin-bottom: 0;
		}
		.tit{
			height: 50upx;
			line-height: 56upx;
			font-size: $font-sm+2upx;
			color: $font-color-base;
		}
		input{
			height: 60upx;
			font-size: $font-base + 2upx;
			color: $font-color-dark;
			width: 100%;
		}	
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
	.forget-section-left{
		font-size: $font-sm+5upx;
		position:relative;
		color: $font-color-spec;
		left: 60upx;
		margin-top: 40upx;
		width: 200upx;
	}
	.login-by-name-right{
		font-size: $font-sm+5upx;
		color: $font-color-spec;
		position: relative;
		text-align:right;
		right: -485upx;
		margin-top: -40upx;
		width: 200upx;
	}
	.register-section{
		position:absolute;
		left: 0;
		bottom: 50upx;
		width: 100%;
		font-size: $font-sm+2upx;
		color: $font-color-base;
		text-align: center;
		text{
			color: $font-color-spec;
			margin-left: 10upx;
		}
	}
	.option{
		display: flex;
		margin-top: 4%;
		margin-left: 30upx;
		padding-bottom: 30upx;
		border-bottom: #333333 solid 0.5upx;
	}
	.msg-left {
		flex: 5;
		display: flex;
		justify-content: flex-start;
		align-items: center;
	}
	.msg-right {
		flex: 2;
		display: flex;
		justify-content: center;
		text-align: center;
		margin-right: 15upx;
		border-bottom: #000000 solid 0.5upx;
	}
	.img {
		display: flex;
		margin-top: 4%;
		margin-left: 30upx;
		padding-bottom: 30upx;
	}
	.img image {
		justify-content: center;
		margin-top: 8%;
		width: 300upx;
		height: 300upx;
	}
</style>
