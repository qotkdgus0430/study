<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Navi Menu JSP Example</title>
    <link rel="stylesheet" href="navi.css">
    <style>
        body {
            padding: 0;
            margin: 0;
            text-align: center;
            font-family: "Lato", sans-serif;
        }
        
        @media screen and (max-width: 700px) {
            body {
                padding: 170px 0 0 0;
                width: 100%;
            }
        }
        
        a {
            color: inherit;
        }
        
        .menu-item,
        .menu-open-button {
            background: #EEEEEE;
            border-radius: 100%;
            width: 50px;
            height: 50px;
            margin-left: -25px; 
            line-height: 50px;
            position: absolute;
            color: #FFFFFF;
            text-align: center;
            transform: translate3d(0, 0, 0);
            transition: transform ease-out 200ms;
            z-index: 1;
        }
        
        .menu-open {
            display: none;
        }
        
        .lines {
            width: 25px;
            height: 3px;
            background: #596778;
            display: block;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -12.5px;
            margin-top: -1.5px;
            transition: transform 200ms;
        }
        
        .line-1 {
            transform: translate3d(0, -8px, 0);
        }
        
        .line-2 {
            transform: translate3d(0, 0, 0);
        }
        
        .line-3 {
            transform: translate3d(0, 8px, 0);
        }
        
        .menu-open:checked + .menu-open-button .line-1 {
            transform: translate3d(0, 0, 0) rotate(45deg);
        }
        
        .menu-open:checked + .menu-open-button .line-2 {
            transform: translate3d(0, 0, 0) scale(0.1, 1);
        }
        
        .menu-open:checked + .menu-open-button .line-3 {
            transform: translate3d(0, 0, 0) rotate(-45deg);
        }
        
        .menu {
            margin: auto;
            position: absolute;
            top: 10%; /* 상단 여백 */
            left: 8%; /* 좌측 여백 */
            text-align: center;
            box-sizing: border-box;
            font-size: 26px;
        }
        
        .menu-item:hover {
            background: #EEEEEE;
            color: #3290B1;
        }
        
        .menu-item:nth-child(3) {
            transition-duration: 180ms;
        }
        
        .menu-item:nth-child(4) {
            transition-duration: 180ms;
        }
        
        .menu-item:nth-child(5) {
            transition-duration: 180ms;
        }
        
        .menu-item:nth-child(6) {
            transition-duration: 180ms;
        }
        
        .menu-item:nth-child(7) {
            transition-duration: 180ms;
        }
        
        .menu-item:nth-child(8) {
            transition-duration: 180ms;
        }
        
        .menu-item:nth-child(9) {
            transition-duration: 180ms;
        }
        
        .menu-open-button {
            z-index: 2;
            transition-timing-function: cubic-bezier(0.175, 0.885, 0.32, 1.275);
            transition-duration: 400ms;
            transform: scale(1.1, 1.1);
            cursor: pointer;
            box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
        }
        
        .menu-open-button:hover {
            transform: scale(1.2, 1.2);
        }
        
        .menu-open:checked + .menu-open-button {
            transition-timing-function: linear;
            transition-duration: 200ms;
            transform: scale(0.8, 0.8);
        }
        
        .menu-open:checked ~ .menu-item {
            transition-timing-function: cubic-bezier(0.935, 0, 0.34, 1.33);
        }
        
        .menu-open:checked ~ .menu-item:nth-child(3) {
            transition-duration: 180ms;
            transform: translate3d(0.06271px, -78.74998px, 0);
        }
        
        .menu-open:checked ~ .menu-item:nth-child(4) {
            transition-duration: 280ms;
            transform: translate3d(68.20995px, -39.35690px, 0);
        }
        
        .menu-open:checked ~ .menu-item:nth-child(5) {
            transition-duration: 380ms;
            transform: translate3d(68.20995px, 39.35690px, 0);
        }
        
        .menu-open:checked ~ .menu-item:nth-child(6) {
            transition-duration: 480ms;
            transform: translate3d(0.06271px, 78.74998px, 0);
        }
        
        .menu-open:checked ~ .menu-item:nth-child(7) {
            transition-duration: 580ms;
            transform: translate3d(-68.14718px, 39.46548px, 0);
        }
        
        .menu-open:checked ~ .menu-item:nth-child(8) {
            transition-duration: 680ms;
            transform: translate3d(-68.27255px, -39.24821px, 0);
        }
        
        .menu-open:checked ~ .menu-item:nth-child(9) {
            transition-duration: 780ms;
            transform: translate3d(-0.18813px, -78.74977px, 0);
        }
        
        .menu-item.blue {
            background: url('https://cdn-icons-png.flaticon.com/128/2948/2948025.png') no-repeat center center;
            background-size: 60%;
            background-color: #669AE1;
            box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.12);
        }
        
        .menu-item.blue:hover {
            background-color: #ffffff;
            text-shadow: none;
        }
        
        .menu-item.green {
            background: url('https://cdn-icons-png.flaticon.com/128/5264/5264565.png') no-repeat center center;
            background-color: #70CC72;
            background-size: 60%;
            box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.12);
        }
        
        .menu-item.green:hover {
            background-color: #ffffff;
            text-shadow: none;
        }
        
        .red {
            background-color: #FE4365;
            box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.12);
        }
        
        .red:hover {
            color: #FE4365;
            text-shadow: none;
        }
        
        .purple {
            background-color: #C49CDE;
            box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.12);
        }
        
        .purple:hover {
            color: #C49CDE;
            text-shadow: none;
        }
        
        .orange {
            background-color: #FC913A;
            box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.12);
        }
        
        .orange:hover {
            color: #FC913A;
            text-shadow: none;
        }
        
        .lightblue {
            background-color: #62C2E4;
            box-shadow: 3px 3px 0 0 rgba(0, 0, 0, 0.14);
            text-shadow: 1px 1px 0 rgba(0, 0, 0, 0.12);
        }
        
        .lightblue:hover {
            color: #62C2E4;
            text-shadow: none;
        }
        
        .credit {
            margin: 24px 20px 120px 0;
            text-align: right;
            color: #EEEEEE;
        }
        
        .credit a {
            padding: 8px 0;
            color: #C49CDE;
            text-decoration: none;
            transition: all 0.3s ease 0s;
        }
        
        .credit a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <nav class="menu">
        <input type="checkbox" class="menu-open" name="menu-open" id="menu-open" />
        <label class="menu-open-button" for="menu-open">
            <span class="lines line-1"></span>
            <span class="lines line-2"></span>
            <span class="lines line-3"></span>
        </label>
        
        <a href="../main/Main_Page.html" class="menu-item blue"></a>
        <a href="../login/login.html" class="menu-item green"></a>
        <a href="../BSH1/index.html" class="menu-item red">배</a>
        <a href="../profile_01/profile_jihun.html" class="menu-item purple">김</a>
        <a href="#" class="menu-item orange">여</a>
        <a href="#" class="menu-item lightblue">이</a>
    </nav>
</body>
</html>
