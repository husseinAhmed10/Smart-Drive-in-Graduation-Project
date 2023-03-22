<?php

$con = new mysqli("localhost","root","","driveweb");
$st_check=$con->prepare("select * from users where password=?");
$st_check->bind_param("s",$_GET["password"]);
$st_check->execute();
$rs=$st_check->get_result();
if($rs->num_rows==0)
{

$st = $con->prepare("insert into users values(?,?,?,?)");
$st ->bind_param("ssss",$_GET["name"],$_GET["email"],$_GET["phone"],$_GET["password"]);
$st->execute();
echo "1";
}
 else {
     echo "0";
}

?>