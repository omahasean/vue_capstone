<template>
<div id="landing-content">
  <header id="landing-image">
      <h1>City Tours</h1>
      <p id="tagline">Find your next adventure</p>
      <a id="landing-button" href="/">Start Your Tour</a>
  </header> 
  <section id="landing-details">
      <div id="body-container">
      <div class="section-even">
          <div class="section-even-text">
          <h3>What is City Tours?</h3>
          <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Animi, earum. Doloremque earum ex ipsam quibusdam! Nisi deserunt aperiam ipsam esse? Vitae quisquam ipsum provident quas dignissimos ducimus ab reprehenderit reiciendis.</p>
          </div>
          <div>
              <img class="section-even-img" src="../assets/slideshow/Columbus.jpg">
          </div>
      </div>
    <div class="section-odd">
          <div>
              <img class="section-odd-img" src="../assets/slideshow/Columbus.jpg">
          </div>
          <div class="section-odd-text">
          <h3>What is City Tours?</h3>
          <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Animi, earum. Doloremque earum ex ipsam quibusdam! Nisi deserunt aperiam ipsam esse? Vitae quisquam ipsum provident quas dignissimos ducimus ab reprehenderit reiciendis.</p>
          </div>

      </div>
    <div class="section-even">
          <div class="section-even-text">
          <h3>What is City Tours?</h3>
          <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Animi, earum. Doloremque earum ex ipsam quibusdam! Nisi deserunt aperiam ipsam esse? Vitae quisquam ipsum provident quas dignissimos ducimus ab reprehenderit reiciendis.</p>
          </div>
          <div>
              <img class="section-even-img" src="../assets/slideshow/Columbus.jpg">
          </div>
      </div>
    <div class="section-odd">
        <div>
            <img class="section-odd-img" src="../assets/slideshow/Columbus.jpg">
        </div>
          <div class="section-odd-text">
          <h3>What is City Tours?</h3>
          <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Animi, earum. Doloremque earum ex ipsam quibusdam! Nisi deserunt aperiam ipsam esse? Vitae quisquam ipsum provident quas dignissimos ducimus ab reprehenderit reiciendis.</p>
          </div>

      </div>
  </div> 
</section>
</div>
</template>

<script>

export default {
    name: 'landingContent',
    components:{

    }
}
</script>

<style>
#landing-content{
    display: grid;
    grid-template-columns: 1fr 12fr 1fr;
    grid-template-rows: 3fr, 1fr;
    grid-template-areas: 
    "landing-image landing-image landing-image"
    ". landing-details ."
}
#landing-image{
    grid-area: landing-image;
    margin-top: 2.9em;
    background-image: url(../assets/landingImageSrc.jpg);
    background-size: cover;
    background-position: center; 
    display:flex;
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
#landing-details{
    display: grid;
    grid-area: landing-details;
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
    background-color:rgba(0, 92, 117, .4);
    background-blend-mode: darken;
}
.landing-button:hover{
    background-color:rgba(0, 92, 117, .8);
}

.section-even{
    display: inline-flex;
    align-items: center;
    margin: 5px;
}
.section-even-text{
    padding: 10px;
    text-align: center;
    background-color:rgba(0, 92, 117, .8);
    justify-content: center;
}
.section-even-img{
    max-width: 400px;
}
.section-odd{
    display: inline-flex;
    align-items: center;
    margin: 5px;
}
.section-odd-text{
    padding: 10px;
    text-align: center;
    justify-content: center;
    background-color: rgba(153, 255, 148, .8);
    float:right;
}
.section-odd-img{
    max-width: 400px;
}

</style>>