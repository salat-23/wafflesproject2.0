<template>
  <div class="home">

    <p>{{ msg }}</p>
  </div>
</template>

<script>


export default {
  name: 'Home',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch('/api/hello')
    .then(response => response.json())
    .then(data => this.msg = data.title)
  }
}
</script>
