<?php

$con = new mysqli("localhost","root","","driveweb");

$st=$con->prepare("UPDATE `users` SET Reserved=? WHERE name=?");
$st->bind_param("ss",$_GET["Reserved"],$_GET["name"]);
$st->execute();
echo "1";

?>