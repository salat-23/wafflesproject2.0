<template>

  <div class="watch">
    <div class="player_container">


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

      <div class="details">
        <div class="details-first-col details-col">
          <h4>Режиссер</h4>
          <h4>Тип</h4>
          <h4>Эпизоды</h4>
          <h4>Статус</h4>
          <h4>Первоисточник</h4>
          <h4>Сезон</h4>
          <h4>Выпуск</h4>
          <h4>Студия</h4>
          <h4>Рейтинг MPAA</h4>
          <h4>Возрастные ограничения</h4>
          <h4>Длительность</h4>
        </div>
        <div class="details-second-col details-col">
          <p>Сатоши Микамуя</p>
          <p>ТВ Сериал</p>
          <p>5 / 12</p>
          <p> Онгоинг</p>
          <p> Манга</p>
          <p>Зима 2022</p>
          <p>с 10 января 2022 по 28 марта 2022</p>
          <p>MAPPA</p>
          <p>NC-17</p>
          <p>18+</p>
          <p>23 мин. ~ серия</p>
        </div>
      </div>

      <div class="video_player_container">
        <div class="video_player">
          <iframe src="https://video.sibnet.ru/shell.php?videoid=4521284"/>
        </div>
      </div>

      <div class="episode_selector">
        <div class="episode_selector_container">

        </div>
      </div>


    </div>


  </div>

</template>

<script>
export default {
  name: "Watch"
}
</script>

<style scoped lang="scss">
@import "@/assets/_global_style.scss";


.watch {
  background: $secondary-light;
}

.player_container {
  display: flex;
  align-items: center;
  flex-direction: column;
}


.item {
  border-bottom: 5px $border-color solid;
  border-top: 5px $border-color solid;
  margin-top: 30px;
  padding: 20px 0;
  gap: 10px;
  width: 90%;
  height: min-content;
  overflow: hidden;
  display: grid;
  grid-template-columns: 0.7fr 1.6fr 0.7fr;
  //grid-template-rows: 0.5fr 1.5fr 1.6fr;
  grid-template-rows: min-content fit-content(100%) min-content;
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
    color: $title-color;
    -webkit-text-stroke: 0.35px $title-stroke;
    width: available;
    height: fit-content;
    grid-area: title;
  }

  .description {
    font-weight: 500;
    font-style: italic;
    color: $title-color;
    -webkit-text-stroke: 0.35px $title-stroke;
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
      background: $tag-color;
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
      border-color: transparent $tag-color transparent transparent;
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

.details {

  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 90%;

  border-bottom: 5px #95A3B3 solid;

  .details-col {
    padding: 20px;
    width: 50%;
    gap: 10px;
    display: flex;
    flex-direction: column;
    align-items: stretch;
    justify-content: space-between;
  }

  .details-first-col {
    width: 30%;
  }

  .details-second-col {
    width: available;
  }


}

.video_player_container {
  width: 90%;
  height: 100%;
  .video_player {
    margin-top: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: stretch;
    position: relative;
    width: 100%;
    padding-bottom: 56.25%;
    float: left;
    height: 0;
    iframe {
      position: absolute;
      width: 100%;
      height: 100%;
    }
  }
}



</style>