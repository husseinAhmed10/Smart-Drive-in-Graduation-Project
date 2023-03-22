<?php
$con=new mysqli("localhost","root","","driveweb");
$st=$con->prepare("select * from items where category=?");
$st->bind_param("s", $_GET["category"]);
$st->execute();   
$rs=$st->get_result();
$arr=array();
while ($row=$rs->fetch_assoc())
{
    array_push($arr,$row);
}
echo json_encode($arr);
/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Scripting/EmptyPHP.php to edit this template
 */

