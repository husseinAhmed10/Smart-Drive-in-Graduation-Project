<?php

$con = new mysqli("localhost","root","","driveweb");

$st=$con->prepare("UPDATE `available` SET valid=2 WHERE slotnum=?");
$st->bind_param("s",$_GET["slotnum"]);
$st->execute();
echo "1";

?>


