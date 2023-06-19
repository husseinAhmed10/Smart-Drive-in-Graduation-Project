<?php

$con=new mysqli("localhost","root","","driveweb");
$st_check = $con->prepare("UPDATE users SET promocode=? WHERE name=?");
$st_check->bind_param("is", $_GET["promocode"], $_GET["name"]);
$st_check->execute();