<template>
<div class="page">
    <Navbar/>
    <div class="landingImg">
        <landingImage/>
    </div>
    <div class="slides">
        <landingPhotoSlideshow/>
    </div>
</div>
</template>

<script>
import landingImage from "./landingImage"
import Navbar from "./Navbar"
import landingPhotoSlideshow from "./landingPhotoSlideshow"
export default {
    components: {
        landingImage,
        Navbar,
        landingPhotoSlideshow
    }

}
</script>

<style>
.page{
    grid-template-areas: 
    "landingImg"
    "Slides"
}
.landingImg{
    grid-area: landingImg;
    padding-bottom: 60vh;
}
.slides{
    grid-area: slides;
}
</style>