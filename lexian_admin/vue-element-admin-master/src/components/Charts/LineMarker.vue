<template>
  <el-container>
    <el-main>
      <el-row :gutter="20">
        <el-col :span="16">
          <el-date-picker
            v-model="dateRange"
            type="daterange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"
            @change="changeData"
          />
        </el-col>
        <el-col :span="8">
          <el-row type="flex" justify="end">
            <el-col :span="7"><el-tag type="success">订单总数：{{ total }}</el-tag></el-col>
            <el-col :span="17"><el-tag type="info">平均订单数：{{ average }}/天</el-tag></el-col>
          </el-row>
        </el-col>
      </el-row>
    </el-main>
    <el-footer><div :id="id" :class="className" :style="container" /></el-footer>
  </el-container>
</template>

<script>
import echarts from 'echarts'
import resize from './mixins/resize'
import { getDateRange } from '@/api/order'
import { initlist } from '@/utils/order_data'

export default {
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    id: {
      type: String,
      default: 'chart'
    }
  },
  data() {
    return {
      chart: null,
      container: {
        width: '',
        height: '601px'
      },
      dateRange: '',
      total: 0,
      average: 0,
      x: ['07.06', '07.07', '07.08', '07.09', '07.10', '07.11', '07.12', '07.13', '07.14'],
      point: [3, 0, 2, 1, 5, 2, 0, 0, 1]
    }
  },
  mounted() {
    this.initChart()
    this.container.width = document.body.clientWidth
    window.onresize = () => {
      return (() => {
        this.screenWidth = document.body.clientWidth
      })()
    }
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    getDateRangeData(start, end) {
      getDateRange(start, end).then(response => {
        this.point = response.data.orders
      })
    },
    changeData() {
      const sm = this.dateRange[0].getMonth() + 1
      let sd = this.dateRange[0].getDate()
      const em = this.dateRange[1].getMonth() + 1
      const ed = this.dateRange[1].getDate()
      const odd = [1, 3, 5, 7, 8, 10, 12]
      let maxDay
      let i = 1
      this.x = []
      this.point = []
      if (odd.indexOf(sm) !== -1) {
        maxDay = 31
      } else {
        maxDay = 30
      }
      if (em > sm) {
        while (sd <= maxDay) {
          this.x.push(sm + '.' + sd)
          sd += 1
        }
        while (i <= ed) {
          this.x.push(em + '.' + i)
          i += 1
        }
      } else {
        while (sd <= ed) {
          this.x.push(sm + '.' + sd)
          sd += 1
        }
      }
      for (let j = 0; j < this.x.length; j++) {
        this.point.push(parseInt(Math.random() * (6) + 1, 10))
      }
      this.point = initlist(this.x.length)
      this.getDateRangeData(this.x.length)
      this.initChart()
      this.total = 0
      for (let j = 0; j < this.point.length; j++) {
        this.total += this.point[j]
      }
      this.average = (this.total / this.x.length).toFixed(2)
    },
    initChart() {
      this.chart = echarts.init(document.getElementById(this.id))
      this.chart.setOption({
        backgroundColor: '#394056',
        title: {
          top: 20,
          text: '订单数量',
          textStyle: {
            fontWeight: 'normal',
            fontSize: 16,
            color: '#F1F1F3'
          },
          left: '1%'
        },
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            lineStyle: {
              color: '#57617B'
            }
          }
        },
        grid: {
          top: 100,
          left: '2%',
          right: '2%',
          bottom: '2%',
          containLabel: true
        },
        xAxis: [{
          type: 'category',
          boundaryGap: false,
          axisLine: {
            lineStyle: {
              color: '#57617B'
            }
          },
          data: this.x
        }],
        yAxis: [{
          type: 'value',
          name: '单',
          axisTick: {
            show: false
          },
          axisLine: {
            lineStyle: {
              color: '#57617B'
            }
          },
          axisLabel: {
            margin: 10,
            textStyle: {
              fontSize: 14
            }
          },
          splitLine: {
            lineStyle: {
              color: '#57617B'
            }
          }
        }],
        series: [{
          name: '订单',
          type: 'line',
          smooth: true,
          symbol: 'circle',
          symbolSize: 5,
          showSymbol: false,
          lineStyle: {
            normal: {
              width: 1
            }
          },
          areaStyle: {
            normal: {
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                offset: 0,
                color: 'rgba(137, 189, 27, 0.3)'
              }, {
                offset: 0.8,
                color: 'rgba(137, 189, 27, 0)'
              }], false),
              shadowColor: 'rgba(0, 0, 0, 0.1)',
              shadowBlur: 10
            }
          },
          itemStyle: {
            normal: {
              color: 'rgb(137,189,27)',
              borderColor: 'rgba(137,189,2,0.27)',
              borderWidth: 12

            }
          },
          data: this.point
        }]
      }, true)
    }
  }
}
</script>
