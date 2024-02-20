<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="ISO-8859-1">
  <title>Find Coupon</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f8f8f8;
      margin: 0;
      padding: 0;
      display: flex;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }

    form {
      max-width: 400px;
      width: 100%;
      padding: 20px;
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h1 {
      color: #3498db;
      text-align: center;
    }

    label {
      display: block;
      margin: 10px 0 5px;
      color: #555;
    }

    input[type="text"] {
      width: calc(100% - 12px);
      padding: 10px;
      margin: 5px 0 15px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 5px;
      transition: border-color 0.3s ease;
    }

    input[type="text"]:focus {
      border-color: #3498db;
    }

    input[type="submit"] {
      background-color: #3498db;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    input[type="submit"]:hover {
      background-color: #2071a7;
    }
  </style>
</head>
<body>
  <form action="CouponControll" method="post">
    <h1>Find Coupon</h1>
    
    <label for="code">Code:</label>
    <input type="text" id="code" name="couponcode" required>
    <input type="hidden"  name="action" value="find">

    <input type="submit" value="Submit">
  </form>
</body>
</html>
