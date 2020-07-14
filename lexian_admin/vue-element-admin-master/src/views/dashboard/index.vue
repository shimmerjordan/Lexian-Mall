<template>
  <div class="homepage-hero-module">
    <div class="video-container">
      <!-- <div :style="fixStyle" class="filter"></div> -->
      <video :style="fixStyle" autoplay loop muted="autoplay" webkit-playsinline playsinline x5-playsinline @canplay="canplay">
        <source src="../../assets/dashboard/urban.mp4" type="video/mp4">
      </video>
      <div v-if="!vedioCanPlay" class="poster hidden">
        <img :style="fixStyle" src="../../assets/dashboard/loading.jpg" alt="">
      </div>
      <div class="others">
        <div style="margin-top: 490px;padding: 2rem;">
          <panel-group />
        </div>
        <div class="head">
          <el-row type="flex">
            <span class="title">乐鲜生活后台管理系统</span>
          </el-row>
          <el-row type="flex">
            <span class="title">助您管理更轻松!</span>
          </el-row>

        </div>
      </div>
    </div>

  </div>
</template>

<script>
import PanelGroup from './components/PanelGroup'

export default {
  name: 'DashBoard',
  components: {
    PanelGroup
  },
  data() {
    return {
      vedioCanPlay: false,
      fixStyle: ''
    }
  },
  mounted: function() {
    window.onresize = () => {
      var h = document.documentElement.scrollHeight || document.body.scrollHeight
      window.scrollTo(h, h)
      const windowWidth = document.body.clientWidth
      const windowHeight = document.body.clientHeight
      const windowAspectRatio = windowHeight / windowWidth
      let videoWidth
      let videoHeight
      if (windowAspectRatio < 0.5625) {
        videoWidth = windowWidth
        videoHeight = videoWidth * 0.5625
        this.fixStyle = {
          height: windowWidth * 0.5625 + 'px',
          width: windowWidth + 'px',
          'margin-bottom': (windowHeight - videoHeight) / 2 + 'px',
          'margin-left': 'initial'
        }
      } else {
        videoHeight = windowHeight
        videoWidth = videoHeight / 0.5625
        this.fixStyle = {
          height: windowHeight + 'px',
          width: windowHeight / 0.5625 + 'px',
          'margin-left': (windowWidth - videoWidth) / 2 + 'px',
          'margin-bottom': 'initial'
        }
      }
    }
    window.onresize()
  },
  methods: {
    canplay() {
      this.vedioCanPlay = true
    }
  }
}
</script>
<style lang="scss" scoped>
  .homepage-hero-module,
  .video-container {
    position: relative;
    height: 100vh;
    overflow: hidden;
  }
  .video-container .poster img,
  .video-container video {
    z-index: 0;
    position: absolute;
  }
  .filter {
    z-index: 1;
    position: absolute;
    background: rgba(0, 0, 0, 0.4);
  }
  .others {
    z-index: 2;
    width: 100%;
    position: absolute;
  }
  .head{
    margin-top: -488px;
    margin-left: 26px;
    text-align: right;
  }
  .title{
    color: #FFFFFF;
    display: block;
    margin: 10px 0;
    text-align: center;
    font-size: 80px;
    font-weight: 500;
  }
</style>
