<?php

$con=new mysqli("localhost", "root", "", "driveweb");
$st=$con->prepare("delete from temp_order where phone=?");
$st->bind_param("s", $_GET["phone"]);
$st->execute();


