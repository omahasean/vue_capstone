<template>
<div>
  
  <ul class="nav">
      <li><a href="/">Home</a></li>
      <li><a href="/login">Login</a></li>
      <li><a href="/register">Register</a></li>
      <li class="Logo"><a href="/">City Tours</a></li>
  </ul>
  </div>
</template>

<script>
export default {
  name: 'Navbar',
}
</script>

<style>
.nav {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #2e2e2e ;
  position: fixed;
  top: 0;
  width: 100%;
  background-image: linear-gradient( to right, #2e2e2e, #2e2e2e, black)
}

.nav li {
  float: right;
  border-left: 1px solid #bbffb8;
  border-radius: 9px;
  font-family: 'Baloo Paaji 2', cursive;
}

.nav li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
.nav li a:hover {
  background-color: #005c75;
  
}
.nav .Logo{
  float: left;
  font-family: 'Lobster', cursive;
  border: none;
}

</style>