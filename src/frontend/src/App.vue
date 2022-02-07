<template>
  <NavigationBar />
  <router-view/>
</template>

<script>
import NavigationBar from "@/components/SideBar/NavigationBar";
export default {
  components: {NavigationBar}
}
</script>
