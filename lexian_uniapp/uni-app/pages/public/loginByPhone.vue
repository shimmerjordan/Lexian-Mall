<template>
	<view class="container">
		<view class="left-bottom-sign"></view>
		<view class="back-btn yticon icon-zuojiantou-up" @click="navBack">
			<cu-custom :isBack="true"></cu-custom>
		</view>
		<view class="right-top-sign"></view>
		<!-- 设置白色背景防止软键盘把下部绝对定位元素顶上来盖住输入框等 -->
		<view class="wrapper">
			<view class="left-top-sign">LOGIN</view>
			<view class="welcome">
				欢迎回来！
			</view>
			<view class="input-content">
				<view class="input-item">
					<text class="tit">手机号码</text>
					<input type="number" :value="mobile" placeholder="请输入手机号码" maxlength="11" data-key="mobile"
					 @input="inputChange" @change="verifyPhoneFormat"/>
				</view>
				<move-verify @result='verifyResult' ref="verifyElement" :mobile="mobile"></move-verify>
				<view class="input-item">
					<text class="tit">验证码</text>
					<input type="number" value="" placeholder="请输入短信验证码" placeholder-class="input-empty" maxlength="20" data-key="verifyCode"
					 @input="inputChange" @confirm="toLogin" />
				</view>
			</view>
			<button class="confirm-btn" @click="toLogin" :disabled="logining">登录</button>
			<view class="forget-section-left">
				<text @click="toForgetPwd">忘记密码？</text>
			</view>
			<view class="login-by-name-right">
				<text @click="toLoginByName">账号登录</text>
			</view>
		</view>
		<view class="register-section">
			还没有账号?
			<text @click="toRegist">马上注册</text>
		</view>
	</view>
</template>

<script>
	import moveVerify from "@/components/moveVerify.vue"

	import {
		mapMutations
	} from 'vuex';

	export default {
		components: {
			"move-verify": moveVerify
		},

		data() {
			return {
				mobile: '',
				resultData: {},
				verifyCode: '',
				logining: false,
				phoneExistance: true
			}
		},
		onLoad() {
			console.log('login页面onLoad');
		},
		methods: {
			...mapMutations(['login']),
			/* 校验结果回调函数 */
			verifyResult(res) {
				this.checkPhoneExistance();
				console.log(res);
				this.resultData = res;
			},
			/* 校验插件重置 */
			verifyReset() {
				setTimeout(() => {
					this.$refs.verifyElement.reset();
				}, 100);

				/* 删除当前页面的数据 */
				this.resultData = {};
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
			toRegist() {
				this.$api.msg('去注册');
				uni.navigateTo({
					url: '/pages/public/register',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			toLoginByName() {
				uni.navigateTo({
					url: '/pages/public/loginByName',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			verifyPhoneFormat(){
				let valid_rule = /^(13[0-9]|14[5-9]|15[012356789]|166|17[0-8]|18[0-9]|19[8-9])[0-9]{8}$/;// 手机号码校验规则
				if ( !valid_rule.test(this.mobile)) {
					this.$api.msg('手机号码格式有误');
					return false;
				}else{
					return true;
				}
			},
			toForgetPwd() {
				uni.navigateTo({
					url: '/pages/public/forgetPwd',
					success: res => {},
					fail: () => {},
					complete: () => {}
				});
			},
			checkPhoneExistance(){
				uni.request({
					url: this.apiServer+'/customer/checkPhoneExistance',
					method: 'POST',
					dataType: "json",
					data: { 
					   "mobile": this.mobile,
					},
					success: (res) => {
						const result = res.data
						console.log(result)
						if(result == 0){
							this.phoneExistance = false;
							this.$api.msg("手机号有误或未注册")
							this.verifyReset();
						}else{
							this.phoneExistance = true;
							this.$api.msg("短信验证码已发送" + this.mobile);
						}
				    }
				});
			},
			checkExistance() {
				if (this.$refs.verifyElement.phoneExistance == true) {
					debugger
					this.$api.msg("短信验证码已发送" + this.mobile)
				} else {
					this.$api.msg("手机号有误或未注册")
					this.verifyReset();
					// this.verifyReset()
					// setTimeout(() => {
					// 	this.toRegist()
					// }, 3000)

				}
			},
			async toLogin() {
				
				
				const {
					mobile,
					verifyCode
				} = this;
				/* 数据验证模块 */
				uni.request({
					url: this.apiServer + '/customer/loginByPhone',
					method: 'POST',
					dataType: "json",
					data: {
						"mobile": this.mobile,
					},
					success: (res) => {
						const result = res.data
						console.log(result[0])
						//const result = await this.$api.json('userInfo');
						if(result.status == 500){
							this.$api.msg('网络错误');
						}
						if (result[0].phone == this.mobile) {
							this.login(result[0]);
							this.logining = true;
							uni.reLaunch({
								url: "/pages/user/user",
								success: res => {}
							});
						} 
						if(result == 0){
							this.$api.msg("手机号有误或未注册");
							this.logining = false;
						}
					},
					fail: () => {
						this.$api.msg('网络错误');
					},
				});

			}
		},

	}
</script>



<style lang='scss'>
	page {
		background: #fff;
	}

	.container {
		padding-top: 115px;
		position: relative;
		width: 100vw;
		height: 100vh;
		overflow: hidden;
		background: #fff;
	}

	.wrapper {
		position: relative;
		z-index: 90;
		background: #fff;
		padding-bottom: 40upx;
	}

	.back-btn {
		position: absolute;
		left: 40upx;
		z-index: 9999;
		padding-top: var(--status-bar-height);
		top: 40upx;
		font-size: 40upx;
		color: $font-color-dark;
	}

	.left-top-sign {
		font-size: 120upx;
		color: $page-color-base;
		position: relative;
		left: -16upx;
	}

	.right-top-sign {
		position: absolute;
		top: 80upx;
		right: -30upx;
		z-index: 95;

		&:before,
		&:after {
			display: block;
			content: "";
			width: 400upx;
			height: 80upx;
			background: #b4f3e2;
		}

		&:before {
			transform: rotate(50deg);
			border-radius: 0 50px 0 0;
		}

		&:after {
			position: absolute;
			right: -198upx;
			top: 0;
			transform: rotate(-50deg);
			border-radius: 50px 0 0 0;
			/* background: pink; */
		}
	}

	.left-bottom-sign {
		position: absolute;
		left: -270upx;
		bottom: -320upx;
		border: 100upx solid #d0d1fd;
		border-radius: 50%;
		padding: 180upx;
	}

	.welcome {
		position: relative;
		left: 50upx;
		top: -90upx;
		font-size: 46upx;
		color: #555;
		text-shadow: 1px 0px 1px rgba(0, 0, 0, .3);
	}

	.input-content {
		padding: 0 60upx;
	}

	.input-item {
		display: flex;
		flex-direction: column;
		align-items: flex-start;
		justify-content: center;
		padding: 0 30upx;
		background: $page-color-light;
		height: 120upx;
		border-radius: 4px;
		margin-bottom: 50upx;

		&:last-child {
			margin-bottom: 0;
		}

		.tit {
			height: 50upx;
			line-height: 56upx;
			font-size: $font-sm+2upx;
			color: $font-color-base;
		}

		input {
			height: 60upx;
			font-size: $font-base + 2upx;
			color: $font-color-dark;
			width: 100%;
		}
	}

	.confirm-btn {
		width: 630upx;
		height: 76upx;
		line-height: 76upx;
		border-radius: 50px;
		margin-top: 70upx;
		background: $uni-color-primary;
		color: #fff;
		font-size: $font-lg;

		&:after {
			border-radius: 100px;
		}
	}

	.forget-section-left {
		font-size: $font-sm+5upx;
		position: relative;
		color: $font-color-spec;
		left: 60upx;
		margin-top: 40upx;
		width: 200upx;
	}

	.login-by-name-right {
		font-size: $font-sm+5upx;
		color: $font-color-spec;
		position: relative;
		text-align: right;
		right: -485upx;
		margin-top: -40upx;
		width: 200upx;
	}

	.register-section {
		position: absolute;
		left: 0;
		bottom: 50upx;
		width: 100%;
		font-size: $font-sm+2upx;
		color: $font-color-base;
		text-align: center;

		text {
			color: $font-color-spec;
			margin-left: 10upx;
		}
	}
</style>
