<template>
<div id="landing-content">
  <header id="landing-image">
      <h1>City Tours</h1>
      <p id="tagline">Find your next adventure</p>
      <a id="landing-button" v-if="user === null" href="/login">Start Your Tour</a>
      <a id="landing-button2" v-if="user != null" href="/">Start Your Tour</a>
  </header> 
  <section id="landing-details">
      <div id="body-container">
      <div class="section-even">
          <div class="section-even-text">
          <h3>What is City Tours?</h3>
          <p>City Tours is a trip itinerary planner that allows you to customize, edit and create your own trips. Backed by Bing's technology and enhanced with our own curated lists of locations, City Tours brings you the trip planning experience that you've been looking for.
              We currently support the cities: Columbus, Cleveland, Pittsburgh, Milwaukee, Indianapolis and Chicago.
          </p>
          </div>
          <div>
              <img class="section-even-img" src="../assets/slideshow/Columbus.jpg">
          </div>
      </div>
    <div class="section-odd">
          <div>
              <img class="section-odd-img" src="../assets/slideshow/MilwaukeeArt.jpg">
          </div>
          <div class="section-odd-text">
          <h3>How do I use City Tours?</h3>
          <p>City Tours begins by searching a city and selecting the radius that you are willing to travel from that city. City Tours will then display our curated locations for you to select from. Once chosen, name your adventure
              submit it and when you're ready to start your journey head over to the 'My Tours' feature and select it. From there you can generate your directions to ensure there are no surprises along the way!
          </p>
          </div>
    </div>

    <div class="section-even">
          <div class="section-even-text">
          <h3>What Technology was used?</h3>
          <p>This program was created in 2 weeks split into 2 day sprints, by 3 students at Tech Elevator. We used Vue.js, Bing's API for coordinate to map plotting, GeoCode for address to map coordinates, J2EE with SpringMVC, and PostgreSQL.
              We felt that this was the best way to deliver the experience that you needed. If you have any questions on specifics of our tech stack please contact us, our info is at the bottom of the page.
          </p>
          </div>
          <div>
              <img class="section-even-img" src="../assets/slideshow/Pittsburgh.jpg">
          </div>
      </div>
    <div class="section-odd">
        <div>
            <img class="section-odd-img" src="../assets/slideshow/Cleveland.jpg">
        </div>
          <div class="section-odd-text">
          <h3>Questions/Comments?</h3>
          <p>Feel free to contact us at the links provided below and we would love to answer them for you, thank you for having a look at our project!</p>
          </div>
    
  </div>
  <div id="contact-info">
        <div id="Joe">
            <h4>Joseph Ramirez</h4>
            <a href="mailto:joeyramirez.81@gmail.com" target="blank">Email Joseph</a>
        </div>
        <div id="Sean">
            <h4>Sean Griswold</h4>
            <a href="mailto:seagriswold@gmail.com" target="blank">Email Sean</a>
        </div>
        <div id="Austin">
            <h4>Austin McCulloch</h4>
            <a href="mailto:mcculloch.austin@yahoo.com" target="blank">Email Austin</a>
        </div>    
    </div> 
</div>
</section>
</div>
</template>

<script>
import auth from "../auth";

export default {
    name: 'landingContent',
    components:{

    },

    data(){
        return {
            user: auth.getUser()
        }
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
    ". landing-details .";
    background: radial-gradient(#2e2e2e, black);
    background-size: cover;
}
#landing-image{
    grid-area: landing-image;
    margin-top: 2.9em;
    background-image: url(../assets/landingImageSrc.jpg);
    background-size: cover;
    background-position: center; 
    position:initial;
    display:flex;
    height: 100vh;
    flex-direction: column;
    justify-content: center;
    align-items:center;
    padding-right: -25px;
    margin-top: 2.9em;
    z-index: 1;
}
#landing-details{
    display: grid;
    grid-area: landing-details;
}
#landing-image h1{
    font-size: 100px;
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
    margin-bottom: 50px;
}

#landing-button2{
    font-family: 'Roboto', sans-serif;
    font-size: 18px;
    color: white;
    text-decoration: none;
    padding: 10px 20px;
    border: 1px solid;
    border-radius: 10px;
    background-color:rgba(0, 92, 117, .4);
    background-blend-mode: darken;
    margin-bottom: 50px;
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
    color: white;
    text-shadow: 0 0 2px black, 0 0 2px black;
    text-align: center;
    background-color:rgba(0, 92, 117, .8);
    justify-content: center;
}
.section-even-text h3{
    font-family: 'Roboto', sans-serif;
    font-size: 20px;
}
.section-even-text p{
    font-family: 'Open Sans', sans-serif;
}
.section-even-img{
    max-width: 600px;
}
.section-odd{
    display: inline-flex;
    align-items: center;
    margin: 5px;
}
.section-odd-text{
     padding: 10px;
    color: white;
    text-shadow: 0 0 2px black, 0 0 2px black;
    text-align: center;
    background-color:rgba(0, 92, 117, .8);
    justify-content: center;
}
.section-odd-text h3{
    font-family: 'Roboto', sans-serif;
    font-size: 20px;
}
.section-odd-text p{
    font-family: 'Open Sans', sans-serif;
}
.section-odd-img{
    max-width: 600px;
}
.section-odd-img{
    max-width: 600px;
}
#contact-info{
    display: flex;
    justify-content: space-around;
    align-content: center;
}
#contact-info div h4{
    text-align: center;
    color:white;
    font-family: 'Roboto', sans-serif;
}
#contact-info div a{
    font-family: 'Roboto', sans-serif;
}
</style>>