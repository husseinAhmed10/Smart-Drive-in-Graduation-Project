<?php

$con = new mysqli("localhost","root","","driveweb");

$st=$con->prepare("UPDATE `users` SET points=? WHERE name=?");
$st->bind_param("ss",$_GET["points"],$_GET["name"]);
$st->execute();
echo "1";

?>