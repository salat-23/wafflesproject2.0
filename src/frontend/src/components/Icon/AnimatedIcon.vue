<template>
  <div
      ref="container"
  />
</template>

<script>
import lottie from 'lottie-web'

export default {
  name: "AnimatedIcon",
  props: ['jsonIcon'],
  mounted() {
    this.anim = lottie.loadAnimation(
        {
          container: this.$refs.container,
          renderer: 'svg',
          animationData: this.jsonIcon
        }
    )
  }
}
</script>

<style scoped>

div {
  position: fixed;
  resize: none;
  width: 50px;
  height: 50px;
}

</style>