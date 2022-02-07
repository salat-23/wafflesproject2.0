<template>
  <div class="container">
    <img :src="icon">
  </div>
</template>

<script>
export default {
  name: "StaticIcon",
  props: ['icon'],
}
</script>

<style scoped lang="scss">
@import "@/assets/_global_style.scss";


div {
  position: fixed;
  resize: none;
  width: 50px;
  height: 50px;

  img {
    filter: brightness(0) saturate(100%);

    filter: invert(90%) sepia(8%) saturate(7483%) hue-rotate(286deg) brightness(102%) contrast(93%);
  }

}
</style>