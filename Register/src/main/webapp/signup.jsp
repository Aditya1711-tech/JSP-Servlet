<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h2>Register here!</h2>
    <h5 id="lable">Aditya</h5>
    <form id="myForm" method="POST">
      <table>
        <tr>
          <td>Name:</td>
          <td>
            <input type="text" name="userName" placeholder="Enter name here" />
          </td>
        </tr>
        <tr>
          <td>Password:</td>
          <td>
            <input
              type="password"
              name="userPassword"
              placeholder="Enter password here"
            />
          </td>
        </tr>
        <tr>
          <td>Email:</td>
          <td>
            <input
              type="text"
              name="userEmail"
              placeholder="Enter email here"
            />
          </td>
        </tr>
        <tr>
          <td>Profile pic:</td>
          <td>
            <input
              type="file"
              name="userImage"
              placeholder="Enter email here"
            />
          </td>
        </tr>
        <tr>
          <td></td>
          <td><button type="submit">Register</button></td>
        </tr>
      </table>
    </form>
    <div style="color: green; display: none">
      <h3>Loading....</h3>
    </div>

    <script
      src="https://code.jquery.com/jquery-3.7.1.min.js"
      integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
      crossorigin="anonymous"
    ></script>

    <script type="text/javascript">
      $(document).ready(() => {
        console.log("Page is ready....");

        $("#myForm").on("submit", (e) => {
          e.preventDefault();

          let f = new FormData("#myForm");
          /* var f = $("#myForm").serialize(); */
          console.log(f);
/* 
		  $.ajax({
            url: "RegisterUser",
            data: f,
            type: "POST",

            success: (data, textStatus, jqXHR) => {
              console.log(data);
              $("#lable").html("Success");
            },

            error: (JQueryXHR, textStatus, error) => {
              console.log(data);
              $("#lable").html("Failure..");
            },
          }); */
        });
      });
    </script>
  </body>
</html>
