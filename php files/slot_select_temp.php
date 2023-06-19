<?php

$con = new mysqli("localhost","root","","driveweb");

$st = $con->prepare("SELECT * FROM available WHERE valid = 2 and slotnum=?;");
$st ->bind_param("s",$_GET["slotnum"]);
$st->execute();
$rs=$st->get_result();
if($rs->num_rows==0)
{
    echo "0";
}
else
{
    echo "1";
}

?>