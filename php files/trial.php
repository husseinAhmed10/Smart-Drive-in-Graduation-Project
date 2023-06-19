<?php
$msg="";
//if upload button if pressed
if(isset($_POST['upload'])){
    //the path to store the uploaded image
    $target="items/" .basename($_FILES['image']['name']);
    //connect to the database
    $db= mysqli_connect("localhost","root","","driveweb");
    //get all the submitted data from the form
    $photo=$_FILES['image']['name'];
    $name=$_POST['name'];
    $id=$_POST['id'];
    $price=$_POST['price'];
    $category=$_POST['category'];
    
    $sql="INSERT INTO items (id,name,price,category,photo) VALUES ('$id','$name','$price','$category','$photo')";
    mysqli_query($db, $sql); //store the submitted data into the databse table:image
    
    //now lets move the uploaded image into the folder: images
    if(move_uploaded_file($_FILES['image']['tmp_name'], $target)){
        $msg="image uploaded successfully";
    }
    else{
        $msg="There was an error uploading image";
    }
             
    
}
?>

<!DOCTYPE html>
<html>
    <head>
        <title>Image Upload</title>            
    </head>
    <body>
        <div id="content">
            <form method="post" action="trial.php" enctype="multipart/form-data">
                <input type="hidden" name="size" value="100000"><!-- comment -->
                <div><!-- comment -->
                    <input type="file" name="image"><!-- comment -->
                </div>
                <div><!-- comment -->
                    <textarea name="id" cols="6" rows="1" placeholder="=write id"></textarea>
                </div>
                <div><!-- comment -->
                    <textarea name="name" cols="40" rows="4" placeholder="=write name"></textarea>
                </div>
                <div><!-- comment -->
                    <textarea name="price" cols=20 rows="1" placeholder="=write price"></textarea>
                </div>
                <div><!-- comment -->
                    <textarea name="category" cols="20" rows="1" placeholder="=write category"></textarea>
                </div>
                
                <div>
                    <input type="submit" name="upload" value="upload image"><!-- comment -->
                </div>
            </form>
        </div>
    </body>
</html>