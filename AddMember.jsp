<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>  
<head>
<meta charset="ISO-8859-1">
<title>AddMember file</title>
<style>
    body {
       
        background-color: #328f8a;
        background-image: linear-gradient(45deg, #328f8a, #08ac4b);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
    
    .container {
        width: 50%;
        padding: 100px;
        background-color: lightblue;
    }
    
    form {
        width: 75%;
        margin: 50px auto;
        padding: 100px;
    }
    
    input[type=text],
    input[type=password],
    textarea {
        width: 100%;
        padding: 15px;
        margin: 5px 0 22px 0;
        display: inline-block;
        border: none;
        background: #f1f1f1;
    }
    
    input[type=text]:focus,
    input[type=password]:focus {
        background-color: rgb(16, 90, 174);
        outline: none;
    }
    
    div {
        padding: 10px 0;
    }
    
    hr {
        border: 1px solid #f1f1f1;
        margin-bottom: 25px;
    }
    
    .registerbtn {
        background-color: #0ba334;
        color: rgb(18, 1, 1);
        padding: 16px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 100%;
        opacity: 0.9;
    }
    
    .registerbtn:hover {
        opacity: 1;
    }
</style>
</head>
<body>
		<h2>${message}</h2>
		<form action="AddMember.data" method="post" >
        <div class="container">
            <center>
                <h1> Vaccine Registeration Form</h1>
            </center>
            <hr>
            <label for="name"> Name </label>
            <input type="text" name="name" placeholder="name" size="15" required />
            <label for="dob"> DOB: </label>
            <input type="text" name="dob" placeholder="dob" size="15" required />

            <div>
                <label for="gender">
                Gender :
            </label><br>
                <input type="radio" value="Male" name="gender" checked> Male
                <input type="radio" value="Female" name="gender"> Female
                <input type="radio" value="Other" name="gender"> Other

            </div>
            <div>
                <label for="photoId"> 
                PHOTO_ID :  
            </label>

                <select name="photoId" id="photoId">  
            <option value="photoId">photoId</option>  
            <option value="AdharCard">AdharCard</option>  
            <option value="PANCard">PANCard</option>  
            <option value="VoterID">VoterID</option>  
            <option value="DrivingLicense">DrivingLicense</option>   
            </select>
            </div>
            
			<div>
            <label for="idNumber"> ID Number </label>
            <input type="text" name="idNumber" placeholder="idNumber" size="15" required />

            <div>
                <label for="vaccineType" > 
                Vaccine Type :  
            </label>

                <select name="vaccineType" id="vaccineType">  
                
            <option value="Covaxin">Covaxin</option>  
            <option value="CovidShild">CovidShild</option>  
            <option value="Sputnik">Sputnik</option>  
            <option value="Booster">Booster</option>   
            </select>
            </div>

            <div>
                <label for="dose"> 
                DOSE :  
            </label>

                <select name="dose" id="dose">    
            <option value="1">1</option>  
            <option value="2">2</option>  
            <option value="3">3</option> 
            </select>
            </div>

            <button type="submit" class="registerbtn">Save</button>
    </div>
    </form>
   
</body>
</html>

