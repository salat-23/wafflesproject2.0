<template>
  <div class="container">
    <slot class="content"></slot>
    <p  :class="isExpanded ? 'expanded' : ''">{{ title }}</p>
  </div>
</template>

<script>

export default {
  name: "SideBarElement",
  props: ['isExpanded', 'title'],
}
</script>

<style scoped lang="scss">
@import "@/assets/_global_style.scss";

* {
  resize: none;
}


  div.container {
    text-wrap: none;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    text-align: left;
    vertical-align: middle;
    align-items: center;
    width: 100%;
    height: 60px;
    overflow: hidden;

    * {
      display: block;
    }
    .content {
      display: inline-block;
      min-height: 60px;
      min-width: 60px;
      height: 60px;
      width: 60px;
    }
    p {
      font-size: 1.5em;
      font-weight: 650;
      padding: 10px;
      display: none;
    }
    p.expanded {
      display: inline-block;
    }

  }

</style>