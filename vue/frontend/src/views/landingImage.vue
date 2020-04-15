<template>
  <header id="landing-image">
      <h1>City Tours</h1>
      <p id="tagline">Find your next adventure</p>
      <a id="landing-button" href="/">Start Your Tour</a>
  </header>    
</template>

<script>
export default {

}
</script>

<style>
#landing-image{
    position: fixed;
    margin-top: 2.9em;
    background-image: url(../assets/landingImageSrc.jpg);
    background-size: cover;
    background-position: center; 
    display:flex;
    position:absolute;
    width: 100vw;
    flex-direction: column;
    justify-content: center;
    align-items:center;
    opacity: .95;
    padding-top: 10em;
    padding-right: 1em;
    padding-left: 1em;
    padding-bottom: 10em;
}
#landing-image h1{
    font-size: 105px;
     font-family: 'Lobster', cursive;
     color: white;
     line-height: .9;
     text-shadow: 0 0 10px #005c75, 0 0 10px #005c75; 
}
#tagline{
    font-family: 'Roboto', sans-serif;
    font-size: 30px;
    color: white;
}
#landing-button{
    font-family: 'Roboto', sans-serif;
    font-size: 18px;
    color: white;
    text-decoration: none;
    padding: 10px 20px;
    border: 1px solid;
    border-radius: 10px;
    background-color: #005c75;
    background-blend-mode: darken;
}
</style>>