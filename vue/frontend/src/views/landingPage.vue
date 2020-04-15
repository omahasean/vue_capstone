<template>
<div class="page">
    <Navbar/>
    <div class="landingContent">
        <landingContent/>
    </div>
</div>
</template>

<script>
import landingContent from "./landingContent"
import Navbar from "./Navbar"
export default {
    components: {
        landingContent,
        Navbar,

    }

}
</script>

<style>


</style>