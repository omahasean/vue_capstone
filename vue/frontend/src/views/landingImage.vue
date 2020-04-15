<template>
  <header id="landing-image">
      <h1>City Tours</h1>
      <p>Find your next adventure</p>
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
    height: 50vh;
    width: 100vw;
    display:flex;
    flex-direction: column;
    justify-content: center;
    align-items:center;
    opacity: .95;
    padding-right: 1em;
    padding-left: 1em;
}
#landing-image h1{
    font-size: 105px;
     font-family: 'Lobster', cursive;
     color: white;
     text-shadow: 0 0 10px #005c75, 0 0 10px #005c75; 
}
p{
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