<?php


$con = new mysqli("localhost","root","","driveweb");
$st_check=$con->prepare("select * from users where name=? and password=?");
$st_check->bind_param("ss",$_GET["name"],$_GET["password"]);
$st_check->execute();
$rs=$st_check->get_result();
if($rs->num_rows==0)
{
    echo "0";
}
else
{
    echo "1";
}

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

