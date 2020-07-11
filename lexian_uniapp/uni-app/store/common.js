const common = {
	getGlobalUserInfo: function () {
		return uni.getStorageSync('userInfo');
	},
}
 
export default common;
