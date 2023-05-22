<?php

$con=new mysqli("localhost", "root", "", "driveweb");
$st=$con->prepare("select * from temp_order where phone=?");
$st->bind_param("s", $_GET["phone"]);
$st->execute();
$rs=$st->get_result();

$st2=$con->prepare("insert into bill(phone) values(?)");
$st2->bind_param("s", $_GET["phone"]);
$st2->execute();

$st4=$con->prepare("select max(bill_no) as bno from bill where phone=?");
$st4->bind_param("s", $_GET["phone"]);
$st4->execute();
$rs2=$st4->get_result();
$row_max=$rs2->fetch_assoc();

while($row=$rs->fetch_assoc())
{
    $st3=$con->prepare("insert into bill_det values(?,?,?)");
    $st3->bind_param("iii", $row_max["bno"], $row["itemid"], $row["qty"]);
    $st3->execute();
}

$st5=$con->prepare("delete from temp_order where phone=?");
$st5->bind_param("s", $_GET["phone"]);
$st5->execute();

echo $row_max["bno"];