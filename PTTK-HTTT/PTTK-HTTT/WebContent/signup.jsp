<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí Quản lý hệ thống xe bus</title>
 <style type="text/css">
 @import "flex";
.containerApp {
    margin-top: 100px;
    padding: 50px;
    width: 1200px;
    height: 700px;
    margin: auto;
    font-family: "Segoe UI";
    background: #ffff;
}
.containerApp .MainForm {
    background: #75b9e6;
    height: 500px;
    padding-top: 80px;
    border-radius: 0px 0px 10px 10px;
}
.containerApp .MainForm .NoiDungForm {
    background: #c3e4e4;
    width: 400px;
    height: 430px;
    margin: auto;
    border-radius: 10px;
}
.containerApp .overview {
    margin-top: 10px;
    display: space-around;
}
.containerApp .overview .GiaoDien {
    flex: 1 1 40%;
    border: 1px solid #badcf2;
}
.containerApp .overview .DinhForm {
    padding-top: 7px;
    background: #badcf2;
    height: 40px;
    border-radius: 10px 10px 0px 0px;
}
.containerApp .overview .DinhForm h3 {
    padding-left: 30px;
    font-style: italic;
    margin-top: -3px;
    font-size: 30px;
}
.containerApp .overview .DinhForm .fontPhu{
    text-align: right;
    padding-right: 30px;
    margin-top: -60px;
    font-size: 20px;
}
.containerApp .overview .DinhForm .fontPhu span {
    padding-left: 40px;
    
   
    
}
.containerApp .overview .DinhForm .fontPhu span.inDam {
    font-weight: bold;
    
}
.containerApp .MainForm .NoiDungForm .tenForm {
    padding-top: 20px;
    height: 50px;
}
.containerApp .MainForm .NoiDungForm .tenForm .textdangki {
    display: flex;
    justify-content: center;
    padding: auto;
    font-size:40px ;
    margin-top: 5px;
}
.containerApp .MainForm .NoiDungForm input[type="submit"] {
    background: #11605b;
    color: white;
    font-size: 1.2em;
    padding: 3px;
    margin-bottom: 20px;
    
}
.containerApp .MainForm .NoiDungForm .NoiDung {
    padding: 20px 20px 0px;
}
.containerApp .MainForm .NoiDungForm .NoiDung input[type="password"], .containerApp .MainForm .NoiDungForm .NoiDung input[type="text"] {
    outline: none;
    font-size: 1.2em;
    width: 100%;
    justify-content: center;
    color: #000;
}
.containerApp .MainForm .NoiDungForm .NDung {
    padding: 10px 20px 0px;
}
.containerApp .MainForm .NoiDungForm .NDung label {
    width: 40px;
}
.containerApp .MainForm .NoiDungForm .NDung input[type="text"], .containerApp .MainForm .NoiDungForm .NDung input[type="tel"], .containerApp .MainForm .NoiDungForm .NDung input[type="password"], .containerApp .MainForm .NoiDungForm .NDung input[type="email"] {
    outline: none;
    font-size: 1em;
    width: 70%;
    justify-content: center;
    color: #000;
    float: right;
}
.containerApp .MainForm .NoiDungForm .Ten {
    padding: 10px 20px 0px;
}
.containerApp .MainForm .NoiDungForm .Ten input[type="text"] {
    width: 40%;
    outline: none;
    font-size: 1em;
    justify-content: center;
    color: #000;
}
.containerApp .MainForm .NoiDungForm .Taikhoan {
    padding: 10px 20px 0px;
}
.containerApp .MainForm .NoiDungForm .Taikhoan label {
    font-size: 14px;
}
.containerApp .MainForm .NoiDungForm .Taikhoan input[type="text"], .containerApp .MainForm .NoiDungForm .Taikhoan input[type="tel"], .containerApp .MainForm .NoiDungForm .Taikhoan input[type="password"], .containerApp .MainForm .NoiDungForm .Taikhoan input[type="email"] {
    outline: none;
    font-size: 1em;
    width: 65%;
    justify-content: center;
    color: #000;
    float: right;
}
 
 </style>
</head>
<body>
<form action="SignUp" method="post">
    <div class="containerApp">
        <div class="overview flex">
             <div class="GiaoDien">
                 <div class="DinhForm flex j-between">
                     <h3>QUẢN LÝ XE BUS</h3>
            <div class="fontPhu">
                <a href="./login.jsp"><span>Đăng nhập</span></a>
                <span class="inDam">Đăng kí</span>
               
            </div>
        </div>
        <div class="MainForm">
            <div class="NoiDungForm dangky">
                <div class="tenForm "><h4 class="textdangki">ĐĂNG KÍ</h4></div>
                    <div class="Ten ">
                        <label for="taikhoan">HỌ: </label> 
                        <input name="lastName" type="text" id="dangki" style="width: 60px;" required="">
                        <label for="taikhoan" style="margin-left: 50px;">TÊN: </label> 
                        <input name="firstName" type="text" id="dangki" required="" style="float: right;">
                    </div>
                    <p class="NDung">
                        <label for="taikhoan">E-MAIL: </label> 
                        <input name="email" type="email" required="" id="dangki">
                    </p>
                    <p class="NDung">
                        <label for="taikhoan">SĐT: </label> 
                        <input name="phoneNumber" type="tel" id="dangki">
                    </p >
                    <p class="NDung">NGÀY SINH: </label> 
                        <input name="birthday" type="text" id="dangki">
                    </p>
                    <p class="Taikhoan">
                        <label >TÊN TÀI KHOẢN: </label> 
                        <input name="accountName" type="text" id="dangki">
                    </p>
                    <p class="Taikhoan">
                        <label >MẬT KHẨU: </label> 
                        <input name="password" type="password" required="" id="dangki">
                    </p>
                    <div style="margin-top: 5px;" class="submit NoiDung j-between">
                        <input type="submit" value=" Đăng kí ">
                    </div>
            </div>
        </div>
    </div>
</div>
</div>
    </form>
</body>
</html>