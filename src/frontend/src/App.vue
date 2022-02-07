<template>
  <Header class="sticky"/>
  <div class="container">
    <router-view/>
  </div>

</template>

<script>

import Header from "@/components/Header";

export default {
  components: {Header}
}
</script>

<style scoped lang="scss">
@import "@/assets/_global_style.scss";

.sticky {
  z-index: 2;
  position: sticky;
  top: 0;
}

.container {

  background: $main-twin;
  display: flex;
  justify-content: center;
  height: 200vh;

  >div {
    width: 1000px;
  }

}

</style>
