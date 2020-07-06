// .env.js 文件
// 不同环境访问不同的路径
import store from '@/common/store/index'
const ENV_API_URL = {
	development: '', //开发环境
	production: '', //生产环境
}
const ENV_BASE_URL = {
	development: '', //开发环境
	production: '', //生产环境
}

export const BASE_URL = ENV_BASE_URL[process.env.NODE_ENV || 'development']; //后台根域名
export const API_URL = ENV_API_URL[process.env.NODE_ENV || 'development']; //后台接口域名
