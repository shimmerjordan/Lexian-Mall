<template>
	<view class="content">
		<view class="row b-b">
			<text class="tit">联系人</text>
			<input class="input" type="text" v-model="addressData.name" placeholder="收货人姓名" placeholder-class="placeholder" />
		</view>
		<view class="row b-b">
			<text class="tit">手机号</text>
			<input class="input" type="number" v-model="addressData.phone" placeholder="收货人手机号码" placeholder-class="placeholder" />
		</view>
		<view class="row b-b">
			<text class="tit">地址</text>
			<text @click="chooseLocation" class="input">
				{{addressData.addressName}}
			</text>
			<text class="yticon icon-shouhuodizhi"></text>
		</view>
		<view class="row b-b"> 
			<text class="tit">门牌号</text>
			<input class="input" type="text" v-model="addressData.location" placeholder="楼号、门牌" placeholder-class="placeholder" />
		</view>
		
		<view class="row default-row">
			<text class="tit">设为默认</text>
			<switch :checked="addressData.addressStatus == 0" color="#fa436a" @change="switchChange" />
		</view>
		<button class="add-btn" @click="confirm">提交</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				addressData: {
					name: '',
					phone: '',
					addressName: '在地图选择',
					location: '',
					area: '',
					city:'',
					province:'',
					addressStatus: 1,
					id:''
				},
				uid:0,
				manageType:''
			}
		},
		onLoad(option){
			let title = '新增收货地址';
			this.uid = option.uid;
			if(option.type==='edit'){
				let id = option.id;
				let status = option.status;
				let _this = this;
				title = '编辑收货地址'
				uni.request({
				    url: this.apiServer + "/api/address/getById?id="+id,
				    dataType: "JSON",
				    success: function(res) {
						const result = res.data;
						_this.addressData = result;
						_this.addressData.addressName = result.province + result.city + result.area;
						_this.addressData.addressStatus = status;
					},
				});
			}
			this.manageType = option.type;
			uni.setNavigationBarTitle({
				title
			})
		},
		methods: {
			switchChange(e){
				this.addressData.addressStatus = e.detail.value ? 0:1;
			},
			
			//地图选择地址
			chooseLocation(){
				var _this = this;
				uni.chooseLocation({
					success: (res)=> {
					    var regex = /^(北京市|天津市|重庆市|上海市|香港特别行政区|澳门特别行政区)/;  
						var REGION_PROVINCE=[];  
						var addressBean = {  
							  REGION_PROVINCE:null,  
							  REGION_COUNTRY:null,  
							  REGION_CITY:null,  
							  ADDRESS:null};  
							function regexAddressBean(address, addressBean){  
								regex = /^(.*?[市州]|.*?地区|.*?特别行政区)(.*?[市区县])(.*?)$/g;  
								var addxress = regex.exec(address);  
								addressBean.REGION_CITY=addxress[1];  
								addressBean.REGION_COUNTRY=addxress[2];  
								addressBean.ADDRESS=addxress[3]+"("+res.name+")";  
							}  
							if(!(REGION_PROVINCE = regex.exec(res.address))){  
							  regex = /^(.*?(省|自治区))(.*?)$/;  
							  REGION_PROVINCE = regex.exec(res.address);  
							  addressBean.REGION_PROVINCE= REGION_PROVINCE[1];  
							  regexAddressBean(REGION_PROVINCE[3],addressBean);  
							} else {  
							  addressBean.REGION_PROVINCE= REGION_PROVINCE[1];  
							  regexAddressBean(res.address, addressBean);  
							}  							
						  _this.addressData.province = addressBean.REGION_PROVINCE;
						  _this.addressData.city = addressBean.REGION_CITY;
						  _this.addressData.area = addressBean.REGION_COUNTRY;
						  _this.addressData.location = addressBean.ADDRESS;
						  _this.addressData.addressName =addressBean.REGION_PROVINCE + addressBean.REGION_CITY + addressBean.REGION_COUNTRY;
					}
				})
			},
			
			//提交
			confirm(){
				let data = this.addressData;
				if(!data.name){
					this.$api.msg('请填写收货人姓名');
					return;
				}
				 if(!/(^1[3|4|5|7|8][0-9]{9}$)/.test(data.phone)){
					this.$api.msg('请输入正确的手机号码');
					return;
				} 
				if(data.addressName == "在地图选择"){
					this.$api.msg('请在地图选择所在位置');
					return;
				}
				if(!data.location){
					this.$api.msg('请填写门牌号信息');
					return;
				}
				data.uid = this.uid;
				let _this = this;
				var url = this.apiServer+'/api/address/save';
				if(_this.manageType=='edit'){
					url = this.apiServer+'/api/address/update';
				}
				uni.request({
					url: url,
					method: 'POST',
					dataType: "json",
					data: data,
					success: (res) => {
						const result = res.data;
						if(result){
							let msg = _this.manageType=='edit' ? '修改': '添加';
							_this.$api.msg("地址"+msg+"成功");
						 	setTimeout(()=>{
/* 								uni.navigateTo({
									url: `/pages/address/address?uid=${_this.uid}`
								}) */
								setTimeout(()=>{
									uni.navigateBack()
								}, 800)
							}, 800);
						}
				    },
					fail: (res) => {
						this.$api.msg("网络错误");
					}
				});
			},
		}
	}
</script>

<style lang="scss">
	page{
		background: $page-color-base;
		padding-top: 16upx;
	}

	.row{
		display: flex;
		align-items: center;
		position: relative;
		padding:0 30upx;
		height: 110upx;
		background: #fff;
		
		.tit{
			flex-shrink: 0;
			width: 120upx;
			font-size: 30upx;
			color: $font-color-dark;
		}
		.input{
			flex: 1;
			font-size: 30upx;
			color: $font-color-dark;
		}
		.icon-shouhuodizhi{
			font-size: 36upx;
			color: $font-color-light;
		}
	}
	.default-row{
		margin-top: 16upx;
		.tit{
			flex: 1;
		}
		switch{
			transform: translateX(16upx) scale(.9);
		}
	}
	.add-btn{
		display: flex;
		align-items: center;
		justify-content: center;
		width: 690upx;
		height: 80upx;
		margin: 60upx auto;
		font-size: $font-lg;
		color: #fff;
		background-color: $base-color;
		border-radius: 10upx;
		box-shadow: 1px 2px 5px rgba(219, 63, 96, 0.4);
	}
</style>
