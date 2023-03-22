<?php

$con=new mysqli("localhost","root","","driveweb");
$st_check=$con->prepare("SELECT id,name,price,qty,phone FROM temp_order INNER JOIN items "
        . "ON items.id=temp_order.itemid WHERE phone=?");
$st_check->bind_param("s", $_GET["phone"]);
$st_check->execute();
$rs=$st_check->get_result();
$arr= array();
while($row=$rs->fetch_assoc())
{
    array_push($arr, $row);
}
echo json_encode($arr);
        