<?php

$con = new mysqli("localhost","root","","driveweb");

$st=$con->prepare("UPDATE `users` SET arrived=1 WHERE name=?");
$st->bind_param("s",$_GET["name"]);
$st->execute();
echo "1";

?>


