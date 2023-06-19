<?php

$con = new mysqli("localhost","root","","driveweb");
$st_check=$con->prepare("select * from users where name=?");
$st_check->bind_param("s",$_GET["name"]);
$st_check->execute();
$rs=$st_check->get_result();
if($rs->num_rows==0)
{

$st = $con->prepare("insert into users values(?,?,?,?,?,?,?,?,?,?)");
$st ->bind_param("ssssiiiiis",$_GET["name"],$_GET["email"],$_GET["phone"],$_GET["password"],$_GET["Spot"],$_GET["points"],$_GET["Reserved"],$_GET["arrived"],$_GET["promocode"],$_GET["credit"]);
$st->execute();
echo "1";
}
 else {
     echo "0";
}

?>