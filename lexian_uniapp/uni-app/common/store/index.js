import Vue from 'vue'
import Vuex from 'vuex'


Vue.use(Vuex)
import init from './modules/init.js'
import user from './modules/user.js'
import cart from './modules/cart.js'
import theme from './modules/theme.js'

const store = new Vuex.Store({
	modules: {
		init,
		user,
		cart,
		theme
	},
	state: {
		hasLogin: false,
		userInfo: {},
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
	actions: {
	
	}
})

export default store
