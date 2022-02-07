<template>
  <nav>
    <div @mouseenter="isMouseOver = true" @mouseleave="isMouseOver = false" class="navbar"
         :class="isMouseOver ? 'hovered' : ''">

      <RouterLink v-for="item in items" :to="item.routerLink">
        <SideBarElement :is-expanded="isMouseOver" :title="item.title">
          <img :src="item.icon">
        </SideBarElement>
      </RouterLink>

      <div class="line"></div>

    </div>
  </nav>
</template>

<script>
import SideBarElement from "@/components/SideBar/SideBarElement";
import sidebarItems from "@/assets/sidebar-items";

export default {
  name: "NavigationBar",
  components: {SideBarElement},
  data() {
    return {
      isMouseOver: false,
      items: sidebarItems.col
    }
  }
}
</script>


<style scoped lang="scss">
@import "@/assets/_global_style.scss";

.navbar {
  background: $main-color;
  position: fixed;
  left: 0;
  top: 0;
  height: 100%;
  z-index: 1;
  display: flex;
  flex-direction: column;
  width: 64px;
  transition: 0.3s;
  overflow: hidden;
  white-space: nowrap;
  &.navbar {
    :visited {
      color: $secondary-light;
    }

    color: $secondary-light;
    text-shadow: $main-twin 2px 2px, $secondary-dark -2px -2px;


    img {
      filter: brightness(0) saturate(100);
      filter: invert(87%) sepia(3%) saturate(4121%) hue-rotate(174deg) brightness(108%) contrast(85%);
    }

    :hover {
      background: $secondary-light;
      color: $main-color;
      text-shadow: none;
      img {
        filter: brightness(0) saturate(100);
        filter: invert(18%) sepia(10%) saturate(1813%) hue-rotate(183deg) brightness(91%) contrast(92%);
      }
    }


  }

  .line {
    position: absolute;
    right: 0;
    top: 0;
    width: 10px;
    background: $secondary-light;
    height: 100%;
  }

}

.hovered {
  width: 300px;
}

</style>