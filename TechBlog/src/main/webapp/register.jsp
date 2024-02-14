<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Blog app</title>

    <!-- Bootstrap & CSS -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="css/myStyle.css" type="text/css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
  </head>
  <body>
    <!-- Navbar -->
    <%@include file="navbar.jsp"%>

    <main class="p-5" style="height: 70vh">
      <div class="container">
        <div class="row">
          <div class="col-md-6 offset-md-3">
            <div class="card">
              <div
                class="card-header primary-background text-center text-white"
              >
                Register here
              </div>
              <div class="card-body">
                <form id="registrationForm" method="post">
                  <div class="form-group">
                    <label for="userName">User name</label>
                    <input
                      type="text"
                      name="userName"
                      class="form-control"
                      id="userName"
                      placeholder="Enter name"
                    />
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input
                      type="email"
                      name="userEmail"
                      class="form-control"
                      id="exampleInputEmail1"
                      aria-describedby="emailHelp"
                      placeholder="Enter email"
                    />
                    <small id="emailHelp" class="form-text text-muted"
                      >We'll never share your email with anyone else.</small
                    >
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input
                      type="password"
                      name="userPassword"
                      class="form-control"
                      id="exampleInputPassword1"
                      placeholder="Password"
                    />
                  </div>

                  <div class="form-group">
                    <label for="gender">Select gender</label> <br />
                    <input
                      type="radio"
                      id="gender"
                      name="userGender"
                      value="male"
                    />
                    Male
                    <input
                      type="radio"
                      id="female"
                      name="userGender"
                      value="female"
                    />
                    Female
                  </div>

                  <div class="form-group">
                    <textarea
                      name="userAbout"
                      class="form-control"
                      id=""
                      rows="5"
                      placeholder="Write something about yourself"
                    ></textarea>
                  </div>

                  <div class="form-check">
                    <input
                      type="checkbox"
                      name="userCheck"
                      class="form-check-input"
                      id="exampleCheck1"
                    />
                    <label class="form-check-label" for="exampleCheck1"
                      >Agree to terms and condition</label
                    >
                  </div>
                  <br />
                  <div
                    class="container text-center"
                    id="loader"
                    style="display: none"
                  >
                    <span class="fa fa-refresh fa-spin fa-4x"></span>
                    <h4>Please wait..</h4>
                  </div>
                  <button type="submit" id="submitBtn" class="btn btn-primary">
                    Submit
                  </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>

    <!-- Js -->
    <script
      src="https://code.jquery.com/jquery-3.7.1.min.js"
      integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

    <script>
      $(document).ready(() => {
        console.log("Form Ready....");

        $("#registrationForm").on("submit", (e) => {
          e.preventDefault();
          console.log("Submitting" + this);

          let data = new FormData(document.getElementById("registrationForm"));

          $("#loader").show();
          $("#submitBtn").hide();

          $.ajax({
            url: "Register",
            type: "POST",
            data: data,
            success: function (data, status, jqXHR) {
              $("#loader").hide();
              $("#submitBtn").show();
              if (data.trim() == "Success") {
                swal(
                  "Successfully registered.. Redirecting to the login page"
                ).then((value) => {
                  window.location = "login.jsp";
                });
              } else {
                swal(data);
              }
            },
            error: function (jqXHR, status, error) {
              $("#loader").hide();
              $("#submitBtn").show();
              swal("Something went worng..");
            },
            processData: false,
            contentType: false,
          });
        });
      });
    </script>
  </body>
</html>
