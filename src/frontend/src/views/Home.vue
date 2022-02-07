<template>
  <div class="home">

    <div class="updates_container">

      <div class="item">
        <img class="cover" src="https://i.pinimg.com/originals/d7/00/f9/d700f9ad661cb3314eeecfb290fa095d.jpg">
        <h2 class="title">Очень длинное название аниме спасибо вам лайт новелы за то что пересказываете блять сюжет в
          заголовке</h2>
        <p class="description">
          18 век, Атлантический океан. Фена Хаутман отправилась с отцом в морское путешествие, но вскоре на их корабль
          нападают пираты. Фену сажают в шлюпку и ей удаётся спастить в одиночку. Прошло десять лет. Фена выросла
          красавицей с белоснежной кожей и отливающими серебром волосами. Когда Фену настигла погоня, её спасает юноша в
          красных доспехах и шлеме с оленьими рогами. Это был Юкимару, который обещал найти её. Их встреча разбудила
          спящие в Фене воспоминания. Вспомнив эти слова, Фена с Юкимару и его друзья отравляется в новое морское
          путешествие искать загадочный «Эдем».
        </p>

        <div class="tags">
          <RouterLink to="/">Драма</RouterLink>
          <RouterLink to="/">Экшн</RouterLink>
          <RouterLink to="/">Я плакал как телка</RouterLink>
          <RouterLink to="/">ПОЧЕМУ ТАКОЙ ДЛИННЫЙ ТЭГ</RouterLink>
          <RouterLink to="/">ААААААААААААААААААА</RouterLink>
        </div>

      </div>


    </div>


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
<style scoped lang="scss">
@import "@/assets/_global_style.scss";

.home {
  background: $secondary-light;
}

.updates_container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.item {
  border-bottom: 5px #95A3B3 solid;
  border-top: 5px #95A3B3 solid;
  margin-top: 30px;
  padding: 20px 0;
  gap: 10px;
  width: 900px;
  height: min-content;
  overflow: hidden;
  display: grid;
  grid-template-columns: 0.7fr 1.6fr 0.7fr;
  //grid-template-rows: 0.5fr 1.5fr 1.6fr;
  grid-template-rows: min-content min-content min-content;
  grid-template-areas:
        "img title title"
        "img desc desc"
        "tags tags tags";

  > * {
    border-radius: 10px;
    padding: 8px;
  }

  $mw: 480px;

  .cover {
    grid-area: img;
    object-fit: cover;
    width: 225px;
    height: 350px;
  }

  .title {
    color: #dad4d4;
    -webkit-text-stroke: 0.35px #0A122A;
    width: available;
    height: fit-content;
    grid-area: title;
  }

  .description {
    font-weight: 500;
    font-style: italic;
    -webkit-text-stroke: 0.35px #0A122A;
    color: #dad4d4;
    hyphens: manual;
    width: available;
    height: available;
    grid-area: desc;
  }

  .tags {
    width: available;
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    gap: 20px;
    margin-left: 10px;
    grid-area: tags;

    a {
      display: inline-block;
      height: 24px;
      line-height: 24px;
      position: relative;
      padding: 0 10px 0 12px;
      background: #C14953;
      -webkit-border-bottom-right-radius: 3px;
      border-bottom-right-radius: 3px;
      -webkit-border-top-right-radius: 3px;
      border-top-right-radius: 3px;
      -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
      box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
      color: #fff;
      font-size: 12px;
      text-decoration: none;
      text-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
      font-weight: bold;
      z-index: -0.1;
    }

    :before {
      content: "";
      position: absolute;
      top: 0;
      left: -12px;
      width: 0;
      height: 0;
      border-color: transparent #C14953 transparent transparent;
      border-style: solid;
      border-width: 12px 12px 12px 0;
    }

    :after {
      content: "";
      position: absolute;
      top: 10px;
      left: 1px;
      float: left;
      width: 5px;
      height: 5px;
      -webkit-border-radius: 50%;
      border-radius: 50%;
      background: #fff;
      -webkit-box-shadow: -1px -1px 2px rgba(0, 0, 0, 0.4);
      box-shadow: -1px -1px 2px rgba(0, 0, 0, 0.4);
    }
  }

}

</style>
