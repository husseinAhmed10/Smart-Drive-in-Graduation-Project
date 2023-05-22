<?php

$con = new mysqli("localhost","root","","driveweb");

$st=$con->prepare("SELECT Points FROM users WHERE name=?");
$st->bind_param("s",$_GET["name"]);
$st->execute();
echo "1";

?>