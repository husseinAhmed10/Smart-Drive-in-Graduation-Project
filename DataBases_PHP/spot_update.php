<?php

$con = new mysqli("localhost","root","","driveweb");

$st=$con->prepare("UPDATE users SET Spot=?WHERE name =?");
//$st->bind_param("ss",$_GET["Spot"],$_GET["name"]);
$st->execute();
echo "1";

?>


