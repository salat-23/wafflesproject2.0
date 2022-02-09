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

      <div v-if="hasEpisodes" class="player_main_container">

        <div class="video_player_container">
          <div class="video_player">
            <iframe ref="player" src="https://video.sibnet.ru/shell.php?videoid=4521284"/>
          </div>
        </div>

        <div class="episode_selector">

          <RouterLink v-for="episode in episodes" :to="{ path: '/' + title + '/' + episode.number}"
                      class="episode_button" :class="{ 'active': (
                          (episode.number === 1 && this.$route.params.episode == null) ||
                          episode.number+'' === this.$route.params.episode) }">
            <p class="episode_button_text">{{ episode.number }}</p>
          </RouterLink>

        </div>
      </div>


      <div class="comments_block">
        <div class="your_comment">
          <img class="avatar" src="https://www.w3schools.com/howto/img_avatar.png">
          <h3 class="username">Your username</h3>
          <textarea ref="your_text" placeholder="Напишите свой комментарий.." @keydown="autosize" class="text">

          </textarea>
          <div class="button_container">
            <button>Отправить</button>
          </div>
        </div>
        <div class="comments">
          <div class="comments_item">
            <img class="avatar" src="https://assets.pokemon.com/assets/cms2/img/pokedex/full/149.png"/>
            <h3 class="username">Username loong ass</h3>
            <p class="text">So this is a sample text that i use to test out comments bro this is so hard front end is so
              fuckign loong to make bro i swear to god wbtw doctor stone is FUCKIGN AMAZING BRO GO WATCH IT</p>
          </div>
          <div class="comments_item">
            <img class="avatar" src="https://www.w3schools.com/w3images/avatar2.png"/>
            <h3 class="username">Username loong ass</h3>
            <p class="text">So this is a sample text that i use to test out comments bro this is so hard front end is so
              fuckign loong to make bro i swear to god wbtw doctor stone is FUCKIGN AMAZING BRO GO WATCH IT</p>
          </div>
          <div class="comments_item">
            <img class="avatar" src="https://www.w3schools.com/w3images/avatar2.png"/>
            <h3 class="username">Username loong ass</h3>
            <p class="text">So this is a sample text that i use to test out comments bro this is so hard front end is so
              fuckign loong to make bro i swear to god wbtw doctor stone is FUCKIGN AMAZING BRO GO WATCH IT</p>
          </div>

        </div>
      </div>


    </div>


  </div>

</template>

<script>
import router from "@/router";

export default {
  name: "Watch",
  data() {
    return {
      title: 'hello',
      hasEpisodes: true,
      episodes: [
        {
          number: 1,
          resource: 'https://video.sibnet.ru/shell.php?videoid=4521284'
        },
        {
          number: 2,
          resource: 'https://video.sibnet.ru/shell.php?videoid=4594744'
        }
      ]
    }
  },
  methods: {
    changeEpisode() {
      if (this.$route.params.episode !== null
          && Number(this.$route.params.episode) - 1 <= this.episodes.length
          && Number(this.$route.params.episode) > 0
          && this.episodes.length > 0) {
        //This will execute if you have an episode number in url
        let number = this.$route.params.episode
        this.$refs.player.src = this.episodes[number - 1].resource
        this.scrollTo(this.$refs.player)
        return
      }

      if (this.$route.params.episode == null) {

        if (this.episodes.length > 0) {
          //This will execute if you dont have an episode number in url
          //and have at least 1 episode

          this.$refs.player.src = this.episodes[0].resource
          return
        }

        //This will execute if you dont have any episodes
        this.hasEpisodes = false

        return
      }
      this.$router.push({path: '/' + this.title, force: true})
  },
  scrollTo(element) {
    element.scrollIntoView({
      behavior: 'smooth',
      block: "center"
    })
  },
  autosize(e) {
    let el = e.target
    setTimeout(() => {
      el.style.cssText = 'height:auto'
      el.style.cssText = 'height:' + el.scrollHeight + 'px'
    }, 0);
  },
  clearComment() {
    this.$refs.your_text.textContent = ''
  }
}
,
mounted()
{
  this.clearComment()
  this.changeEpisode()
}
,
updated()
{
  this.changeEpisode()
}
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

.player_main_container {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.video_player_container {
  width: 90%;
  height: 100%;
  border-bottom: 5px $border-color solid;

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

.episode_selector {

  margin-top: 30px;
  border-top: 5px $border-color solid;
  border-bottom: 5px $border-color solid;

  width: 90%;
  padding: 20px 0;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: flex-start;
  gap: 10px;

  .episode_button {
    display: inline-block;

    .episode_button_text {
      color: $epidose-button-text-color;
      font-weight: 600;
      -webkit-text-stroke: 0.35px $title-stroke;
      border-radius: 50%;
      text-align: center;
      text-justify: distribute;
      width: 50px;
      height: 50px;
      font-size: 2em;
      background: $main-twin;
    }

  }

  .episode_button.active {
    .episode_button_text {
      background: $tag-color;
    }
  }

  .episode_button:hover {
    .episode_button_text {
      background: $secondary-dark;
    }
  }

}

.comments_block {

  margin-top: 30px;
  display: flex;
  flex-direction: column;
  width: 90%;
  gap: 10px;

  .your_comment {
    margin-bottom: 30px;
    padding: 10px;
    gap: 10px;
    display: grid;
    grid-template-columns: min-content 1fr 1fr;
    grid-template-rows: fit-content(100%) fit-content(100%) 2em;
    grid-template-areas:
        "avatar username username"
        "avatar text     text"
        "button button   button";


    .avatar {
      border-radius: 50%;
      grid-area: avatar;
      object-fit: cover;
      width: 100px;
      height: 100px;
    }

    h3 {
      grid-area: username;
    }

    textarea {
      padding: 5px;
      background: $main-twin;
      color: $type-face;
      border-style: none;
      border-color: Transparent;
      border-radius: 5px;
      grid-area: text;
      outline: none;
      appearance: none;
      resize: none;
      height: auto;
      font-size: 1.1em;

      overflow: hidden;
    }

    .button_container {

      grid-area: button;
      display: flex;
      align-items: center;
      justify-content: center;
      width: 100%;
      height: 100%;

      button {
        background: $border-color;
        transition-duration: 0.1s;

        border: none;
        border-radius: 10px;
        width: 50%;
        height: 100%;

      }

      button:hover {
        background: $secondary-dark;
      }

      button:active {
        background: $type-face;
      }

    }


  }

  .comments {

    display: flex;
    flex-direction: column;
    gap: 10px;
    width: 100%;
    align-items: center;

    .comments_item {
      padding: 10px;
      gap: 10px;
      display: grid;
      grid-template-columns: min-content 1fr 1fr;
      grid-template-rows: 0.3fr 1fr;
      grid-template-areas:
        "avatar username username"
        "avatar text text";


      .avatar {
        border-radius: 50%;
        grid-area: avatar;
        object-fit: cover;
        width: 100px;
        height: 100px;
      }

      h3 {
        grid-area: username;
      }

      p {
        grid-area: text;
      }
    }
  }

}


</style>