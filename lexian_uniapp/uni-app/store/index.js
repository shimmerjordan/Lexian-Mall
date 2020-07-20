import Vue from 'vue'
import Vuex from 'vuex'
import $mConstDataConfig from '@/store/constData.config';

Vue.use(Vuex)
const THEMECOLOR = uni.getStorageSync('themeColor') || { title: '官方', name: 'rf', color: '#fa436a' };
const store = new Vuex.Store({
	state: {
		hasLogin: false,
		userInfo: {},
		themeColor: THEMECOLOR
	},
	mutations: {
		login(state, provider) {

			state.hasLogin = true;
			state.userInfo = provider;
			uni.setStorage({//缓存用户登陆状态
			    key: 'userInfo',  
			    data: provider  
			}) 
			console.log(state.userInfo);
		},
		logout(state) {
			state.hasLogin = false;
			state.userInfo = {};
			uni.removeStorage({  
                key: 'userInfo'  
            })
		}
	},
	getters: {
		// 全局配置
		themeColor: state => {
			return state.themeColor;
		}
	},
	actions: {
	
	}
})

export default store
