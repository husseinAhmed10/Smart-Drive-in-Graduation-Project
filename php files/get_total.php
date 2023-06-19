<?php
$con=new mysqli("localhost", "root", "", "driveweb");
$st=$con->prepare("SELECT price,qty from items INNER JOIN bill_det ON items.id=bill_det.itemid WHERE bill_det.bill_no=?");
$st->bind_param("i", $_GET["bill_no"]);
$st->execute();
$rs=$st->get_result();
$total=0;
while($row=$rs->fetch_assoc())
{
    $total=$total + ($row["price"]*$row["qty"]);
}
echo $total;
