<template>
	<view class="container">
		<view class="left-bottom-sign"></view>
		<view class="back-btn yticon icon-zuojiantou-up" @click="navBack"></view>
		<view class="right-top-sign"></view>
		<!-- 设置白色背景防止软键盘把下部绝对定位元素顶上来盖住输入框等 -->
		<view class="wrapper">
			<view class="left-top-sign">LOGIN</view>
			<view class="welcome">
				欢迎回来！
			</view>
			<view class="input-content">
				<view class="input-item">
					<text class="tit">登录名</text>
					<input 
						type="text" 
						:value="loginName" 
						placeholder="请输入登录名"
						maxlength="11"
						data-key="loginName"
						@input="inputChange"
					/>
				</view>
				<view class="input-item">
					<text class="tit">密码</text>
					<input 
						type="loginName" 
						value="" 
						placeholder="8-18位不含特殊字符的数字、字母组合"
						placeholder-class="input-empty"
						maxlength="20"
						password 
						data-key="password"
						v-model="loginPassword"
						@input="inputChange"
						@confirm="toLogin"
					/>
				</view>
			</view>
			<button class="confirm-btn" @click="toLogin" :disabled="logining">登录</button>
			<view class="forget-section-left">
				<text @click="toForgetPwd">忘记密码？</text>
			</view>
			<view class="login-by-name-right">
				<text @click="toLoginByPhone">手机号登录</text>
			</view>
		</view>
		<view class="register-section">
			还没有账号?
			<text @click="toRegist">马上注册</text>
		</view>
	</view>
</template>

<script>

	import {  
		mapState,
        mapMutations  
    } from 'vuex';
	
	export default{
		
		data(){
			return {
				loginName: '',
				password: '',
				loginPassword: '',
				resultData:{},
				result: '',
				logining: false
			}
		},
		onLoad(){
			console.log('login页面onLoad');
		},
		computed: {
			...mapState(['hasLogin','uerInfo'])
		},
		methods: {
			...mapMutations(['login']),
			inputChange(e){
				const key = e.currentTarget.dataset.key;
				this[key] = e.detail.value;
			},
			navBack(){
				uni.navigateBack({
					delta: 1
				});
			},
			toRegist(){
				this.$api.msg('去注册');
				uni.navigateTo({
					url: '/pages/public/register',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			toLoginByPhone(){
				uni.navigateTo({
					url: '/pages/public/loginByPhone',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			toForgetPwd(){
				uni.navigateTo({
					url: '/pages/public/forgetPwd',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			async toLogin(){
				this.logining = true;
				let loginPhone = this.loginPhone;
				let loginPassword = this.loginPassword;
				const {loginName, password} = this;
				
				uni.request({
				   // url:'http://localhost:8888/api/getAll',
				   url: this.apiServer+'/customer/loginByName',
				   method: 'POST',
				   dataType: "json",
				   data: { 
					   "loginName": this.loginName,
				   },
				   success: (res) => {
						this.result = res.data
						console.log(this.result)
						
				    }
				});
				if(this.result.length == 0){
					this.$api.msg("用户名或密码错误");
					this.logining = false;
				}else{
					 if(this.result[0].pwd == this.password){
						 this.login(this.result[0]);
						 uni.reLaunch({
						 	url: "/pages/user/user",
						 	success: res => {}
						 });
					 }
				}

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
</style>
