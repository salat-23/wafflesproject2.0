<template>
  <nav>
    <div class="navbar">

    </div>
  </nav>
</template>

<script>
export default {
  name: "NavigationBar"
}
</script>

<style scoped lang="less">
@import "/src/assets/palette.less";
@import "/src/assets/adaptive-navbar.css";

.nav-bar {
  height: 140px;
  position: relative;
  background: @palette-second;
  border-bottom: 15px @palette-forth solid;
}

ul {

  width: 100%;
  position: absolute;
  list-style-type: none;
  bottom: 0;
}

li {
  float: left;
  margin-right: 20px;
}

@brs: 10px;
a {
  color: @palette-third;
  padding: 10px;
  font-size: @fs-big;
  background: @palette-forth;
  border-radius: @brs @brs 0 0;
}

</style>