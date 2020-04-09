<template>
  <ul>
      <li><a href="default.asp">Home</a></li>
      <li><a href="/login">Login</a></li>
      <li><a href="/register">Register</a></li>
  </ul>
</template>

<script>
export default {
  name: 'Navbar',
}
</script>

<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #2e2e2e ;
  position: fixed;
  top: 0;
  width: 100%;
}

li {
  float: right;
  border-left: 1px solid #bbffb8;
  border-radius: 9px;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #005c75;
}
</style>