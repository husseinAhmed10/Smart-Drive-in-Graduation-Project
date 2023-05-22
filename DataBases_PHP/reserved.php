<?php
$con=new mysqli("localhost","root","","driveweb");
$st=$con->prepare("select Reserved from users where name=?");
$st->bind_param("s", $_GET["name"]);
$st->execute();   
$rs=$st->get_result();
$arr=array();
while ($row=$rs->fetch_assoc())
{
    array_push($arr,$row);
}
echo json_encode($arr);
