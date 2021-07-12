<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập Quản lý hệ thống xe bus</title>
    <style>
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
    height: 350px;
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
.containerApp .MainForm .NoiDungForm input[type="submit"] {
    background: #11605b;
    color: white;
    font-size: 1.2em;
    padding: 2px;
    margin-bottom: 20px;
}
.containerApp .MainForm .NoiDungForm .tenForm {
    padding-top: 20px;
    height: 50px;
}
.containerApp .MainForm .NoiDungForm .tenForm .textdangnhap {
    display: flex;
    justify-content: center;
    padding: auto;
    font-size:40px ;
    margin-top: 5px;
}
.containerApp .MainForm .NoiDungForm .NoiDung {
    padding: 1px 30px 0px;
}
/* .containerApp .MainForm .NoiDungForm .NoiDung .nguoidung {
    padding: 15px 80px 0px;
    margin-top: -12px;   
}
.containerApp .MainForm .NoiDungForm .NoiDung .pass {
    padding: 15px 80px 0px;
    margin-top: -12px;
    
} */
.containerApp .MainForm .NoiDungForm .NoiDung input[type="password"], .containerApp .MainForm .NoiDungForm .NoiDung input[type="text"] {
    outline: none;
    font-size: 1.2em;
    width: 100%;
    justify-content: center;
    color: #000;
    margin-top: -5px;
}

 
    </style>
</head>
<body>
	<form action="Login View" method="post">
    <div class="containerApp">
        <div class="overview flex">
            <div class="GiaoDien">
                <div class="DinhForm flex j-between">
                    <h3>QUẢN LÝ XE BUS</h3>
                    <div class="fontPhu">
                        <span class="inDam">Đăng nhập</span>
                      <a href="./signup.jsp">  <span>Đăng kí</span></a>
                    </div>
                </div>
                <div class="MainForm">
                    <div class="NoiDungForm">
                        <div class="tenForm"><h4 class="textdangnhap">ĐĂNG NHẬP</h4></div>
                            <div class="NoiDung">
                                <p for="taikhoan">TÊN TÀI KHOẢN</p>
                                <input name="userName" class="nguoidung" type="text" required="">
                            </div>
                            <div class="NoiDung">
                                <p class="matkhau" for="taikhoan">MẬT KHẨU</p>
                                <input  name="Password" class="pass" type="password" required="">
                            </div>
                            <div style="margin-top: 30px;" class="submit NoiDung j-between">
                                <input type="submit" value="Đăng nhập">
                            </div>
                    </div>
                    </div>
                </div>
            </div>
            </div>
    </form>
</body>
</html>