<?php

$con = new mysqli("localhost","root","","driveweb");

$st=$con->prepare("UPDATE `users` SET Reserved=0 WHERE name=?");
$st->bind_param("s",$_GET["name"]);
$st->execute();
echo "1";

?>


