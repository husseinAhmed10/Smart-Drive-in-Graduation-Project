<?php

$con = new mysqli("localhost","root","","driveweb");

$st = $con->prepare("insert into available values(?,?)");
$st ->bind_param("ss",$_GET["slotnum"],$_GET["available"]);
$st->execute();
echo "1";

?>