<template>
	<view class="container">
		<popup ref="mapState" protocolPath='/pages/public/guidance'  policyPath='/pages/public/agreement'  @popupState="popupState"></popup>
		<view class="left-bottom-sign"></view>
		<view class="back-btn yticon icon-zuojiantou-up" @click="navBack"></view>
		<view class="right-top-sign"></view>
		<!-- 设置白色背景防止软键盘把下部绝对定位元素顶上来盖住输入框等 -->
		<view class="wrapper">
			<view class="left-top-sign">LOGIN</view>
			<view class="welcome">
				欢迎注册！
			</view>
			<view class="input-content">
				<view class="input-item">
					<text class="tit">手机号码</text>
					<input 
						type="number" 
						:value="mobile" 
						placeholder="请输入手机号码"
						maxlength="11"
						data-key="mobile"
						@input="inputChange"
						@change="checkExistPhone"
						@confirm="checkExistPhone"
					/>
				</view>
				
				<move-verify @result='verifyResult' ref="verifyElement" :mobile="mobile"></move-verify>
				
				<view class="input-item">
					<text class="tit">验证码</text>
					<input 
						type="text" 
						value="" 
						placeholder="请输入短信验证码"
						placeholder-class="input-empty"
						maxlength="20"
						data-key="verifyCode"
						@input="inputChange"
					/>
				</view>
				<view class="input-item">
					<text class="tit">用户登录名</text>
					<input 
						type="text" 
						value="" 
						placeholder="用户登录名(唯一标识)"
						placeholder-class="input-empty"
						maxlength="20"
						data-key="loginName"
						@input="inputChange"
						@confirm="checkExistName"
						@change="checkExistName"
					/>
				</view>
				
				<view class="input-item">
					<text class="tit">用户登录名</text>
					<input 
						type="text" 
						value="" 
						placeholder="用户昵称"
						placeholder-class="input-empty"
						maxlength="20"
						data-key="nickName"
						@input="inputChange"
					/>
				</view>
				
				<view class="input-item">
					<text class="tit">密码</text>
					<input 
						type="password" 
						value="" 
						placeholder="8-18位不含特殊字符的数字、字母组合"
						placeholder-class="input-empty"
						maxlength="20"
						password 
						data-key="password"
						@input="inputChange"
					/>
				</view>
				
			</view>
			<button class="confirm-btn" @click="toRegister" :disabled="logining">注册</button>
			
		</view>
		<view class="register-section">
			出现问题?
			<text @click="toGuidance">查看帮助</text>
			<text @click="toAgreement">《用户协议》</text>
		</view>
	</view>
</template>

<script>
	import moveVerify from "@/components/moveVerify.vue"
	import popup from '@/components/popup.vue'
	import {  
        mapMutations  
    } from 'vuex';
	
	export default{
		components: {
		        "move-verify":moveVerify,
				"popup": popup  
		},
		data(){
			return {
				mobile: '',
				password: '',
				verifyCode:'',
				loginName: '',
				nickName: '',
				logining: false,
				phoneExistance: false,
				nameExistance: false
			}
		},
		onLoad(){
			console.log('login页面onLoad');
		},
		methods: {
			...mapMutations(['login']),
			/* 校验结果回调函数 */
			verifyResult(res){
				console.log(res);
				this.resultData = res;
			},
			/* 校验插件重置 */
			verifyReset(){
				this.$refs.verifyElement.reset();
			
				/* 删除当前页面的数据 */
				this.resultData = {};
			},
			
			/* 协议弹窗状态 */
			popupState(e){ //e->false取消 true确认
				
			},
			navBack(){
				uni.navigateBack({
					delta: 1
				});
			},
			inputChange(e){
				const key = e.currentTarget.dataset.key;
				this[key] = e.detail.value;
			},
			toGuidance(){
				uni.navigateTo({
					url: '/pages/public/guidance',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			toAgreement(){
				uni.navigateTo({
					url: '/pages/public/agreement',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			checkExistPhone(){
				if(this.$refs.verifyElement.phoneExistance == true){
					this.phoneExistance = true;
					this.$api.msg("该手机号已被注册");
				}else{
					this.$api.msg("验证码已发送");
					this.phoneExistance = false;
				}
			},
			checkExistName(){
				console.log(this.loginName);
				/* 这里判断数据库中是否存在该用户名 */
				uni.request({
					url: this.apiServer+'/customer/checkNameExistance',
					method: 'POST',
					dataType: "json",
					data: { 
					   "loginName": this.loginName,
					},
					success: (res) => {
						const result = res.data
						console.log(result)
						if(result != 0){
							this.nameExistance = true;
							this.$api.msg("该用户名已被占用")
						}else{
							this.nameExistance = false;
						}
				    }
				});
			},
			addCustomer(){
				if(this.nameExistance == false && this.phoneExistance == false){
					uni.request({
					   // url:'http://localhost:8888/api/getAll',
					   url: this.apiServer+'/customer/addNewCustomer',
					   method: 'POST',
					   dataType: "json",
					   data: { 
						 mobile: this.mobile,
						 password: this.password,
						 loginName: this.loginName,
						 nickName: this.nickName
					   },
					   success: (res) => {
							const result = res.data
							console.log(result)
					    }
					});
				}
			},
			async toRegister(){
				this.addCustomer();
				this.$api.msg("注册成功，即将跳转登录")
				setTimeout(() => {
					uni.navigateTo({
						url: '/pages/public/loginByPhone',
					});
				}, 3000)
				
			}
		},

	}
</script>



<style lang='scss'>
	page{
		background: #fff;
	}
	.container{
		padding-top: 115px;
		position:relative;
		width: 100vw;
		height: 100vh;
		overflow: hidden;
		background: #fff;
	}
	.wrapper{
		position:relative;
		z-index: 90;
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
		top: -90upx;
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
		margin-bottom: 35upx;
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
	.forget-section{
		font-size: $font-sm+2upx;
		color: $font-color-spec;
		text-align: center;
		margin-top: 40upx;
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
	.form-item {
	  position: relative;
	  background: #fff;
	  height: 96rpx;
	  border-bottom: 1px solid #d9d9d9;
	}
	
	.form-item .username, .form-item .password, .form-item .mobile, .form-item .code {
	  position: absolute;
	  top: 26rpx;
	  left: 0;
	  display: block;
	  width: 100%;
	  height: 44rpx;
	  background: #fff;
	  color: #333;
	  font-size: 30rpx;
	}
	
	.form-item-code {
	  margin-top: 32rpx;
	  height: auto;
	  overflow: hidden;
	  width: 100%;
	}
	
	.form-item-code .form-item {
	  float: left;
	  width: 350rpx;
	}
	
	.form-item-code .code-btn {
	  float: right;
	  padding: 20rpx 40rpx;
	  border: 1px solid #d9d9d9;
	  border-radius: 10rpx;
	  color: #fff;
	  background: green;
	}
	
	.form-item .clear {
	  position: absolute;
	  top: 32rpx;
	  right: 18rpx;
	  z-index: 2;
	  display: block;
	  background: #fff;
	}
	
</style>
