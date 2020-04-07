<template>
  <div class="container">
    <h2>Start Your Own Tour</h2>
      <form class="form">
            <input type="text" class="search" placeholder="Please Enter a City"/>
            <input type="submit" class="button" value="submit">

      </form>
      <hr id="line">
  </div>

</template>

<script>
export default {

}
</script>

<style>
  .content{
    padding-right: 30px;
  }
  .form{
    display: grid;
    grid-template-columns: 1fr, 6fr, 1fr;
    grid-template-rows: auto;
    grid-template-areas:
      ". search ."
      ". button ."
}
  .search{
    grid-area: search;
    justify-self: center;
    width: 100%;
    margin-bottom: 1em;
  }
  .button{
    grid-area: button;
    width: 100%;
    padding-bottom: 30px;
  }
  #line{
    margin-top: 1em;
    border-color: #99ff94;
    width: 15em;
    }
  h2{
    display: flex;
    justify-content: center;
    align-self: center;
    color:#99ff94
  }
</style>