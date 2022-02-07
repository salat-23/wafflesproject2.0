<template>
  <nav>
    <div @mouseenter="isMouseOver = true" @mouseleave="isMouseOver = false" class="navbar" :class="isMouseOver ? 'hovered' : ''">
      <a>Hello</a>
      <a>Hello</a>
      <a>Hello</a>
      <a>Hello</a>
      <a>Hello</a>
      <a>Hello</a>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavigationBar",
  data() {
    return {
      isMouseOver: false
    }
  }
}
</script>


<style scoped lang="scss">
@import "@/assets/_global_style.scss";

.navbar {
  background: $palette-second;
  position: fixed;
  left: 0;
  top: 0;
  height: 100%;
  z-index: 1;
  display: flex;
  flex-direction: column;
  width: 50px;
  transition: 0.3s;
}

.hovered {
  width: 200px;
}

</style>