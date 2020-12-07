<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Universal - All In 1 Template</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Google fonts - Roboto-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,700">
    <!-- Bootstrap Select-->
    <link rel="stylesheet" href="vendor/bootstrap-select/css/bootstrap-select.min.css">
    <!-- owl carousel-->
    <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.carousel.css">
    <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.theme.default.css">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.pink.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon and apple touch icons-->
    <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="img/apple-touch-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="img/apple-touch-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="img/apple-touch-icon-152x152.png">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <div id="all">
      <jsp:include page="top-nav.jsp"></jsp:include>
      <div id="heading-breadcrumbs">
        <div class="container">
          <div class="row d-flex align-items-center flex-wrap">
            <div class="col-md-7">
              <h1 class="h2">Buttons</h1>
            </div>
            <div class="col-md-5">
              <ul class="breadcrumb d-flex justify-content-end">
                <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                <li class="breadcrumb-item active">Buttons</li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      <div id="content">
        <div class="container features-buttons">
          <section class="bar">
            <div class="row">
              <div class="col-lg-3">
                <!-- MENUS AND WIDGETS -->
                <div class="panel panel-default sidebar-menu with-icons">
                  <div class="panel-heading">
                    <h3 class="h4 panel-title">Categories</h3>
                  </div>
                  <div class="panel-body">
                    <ul class="nav nav-pills flex-column text-sm">
                      <li class="nav-item"><a href="template-accordions.html" class="nav-link active">Accordions</a></li>
                      <li class="nav-item"><a href="template-alerts.html" class="nav-link">Alerts</a></li>
                      <li class="nav-item"><a href="template-buttons.html" class="nav-link">Buttons</a></li>
                      <li class="nav-item"><a href="template-content-boxes.html" class="nav-link">Content boxes</a></li>
                      <li class="nav-item"><a href="template-blocks.html" class="nav-link">Horizontal blocks</a></li>
                      <li class="nav-item"><a href="template-pagination.html" class="nav-link">Pagination</a></li>
                      <li class="nav-item"><a href="template-tabs.html" class="nav-link">Tabs</a></li>
                      <li class="nav-item"><a href="template-typography.html" class="nav-link">Typography</a></li>
                    </ul>
                  </div>
                </div>
              </div>
              <div class="col-lg-9">
                <div class="heading">
                  <h2>Template buttons</h2>
                </div>
                <!-- Buttons template main-->
                <button type="button" class="btn btn-lg btn-template-main">Main button</button><br>
                <button type="button" class="btn btn-template-main">Main  button</button><br>
                <button type="button" class="btn btn-sm btn-template-main">Main  button</button><br>
                <hr>
                <!-- Buttons template transparent-->
                <div class="bar pt-0 background-dark-gray margin-vertical">
                  <button type="button" class="btn btn-lg btn-outline-primary">Transparent with primary</button><br>
                  <button type="button" class="btn btn-outline-primary">Transparent with primary</button><br>
                  <button type="button" class="btn btn-sm btn-outline-primary">Transparent with primary</button><br>
                  <hr>
                  <div class="bg-primary bar padding-horizontal">
                    <button type="button" class="btn btn-lg btn-template-outlined-white">Transparent with white</button><br>
                    <button type="button" class="btn btn-template-outlined-white">Transparent with white</button><br>
                    <button type="button" class="btn btn-sm btn-template-outlined-white">Transparent with white</button>
                  </div>
                </div>
                <button type="button" class="btn btn-lg btn-outline-dark">Transparent with black</button><br>
                <button type="button" class="btn btn-outline-dark">Transparent with black</button><br>
                <button type="button" class="btn btn-sm btn-outline-dark">Transparent with black</button><br>
                <hr>
                <div class="heading">
                  <h2>Bootstrap buttons</h2>
                </div>
                <!-- Buttons style 1-->
                <button type="button" class="btn btn-lg btn-default">Button Default</button>
                <button type="button" class="btn btn-default">Button Default</button>
                <button type="button" class="btn btn-sm btn-default">Button Default</button>
                <hr>
                <!-- Buttons style 2-->
                <button type="button" class="btn btn-lg btn-primary">Button Primary</button>
                <button type="button" class="btn btn-primary">Button Primary</button>
                <button type="button" class="btn btn-sm btn-primary">Button Primary</button>
                <hr>
                <!-- Buttons style 3-->
                <button type="button" class="btn btn-lg btn-success">Button Success</button>
                <button type="button" class="btn btn-success">Button Success</button>
                <button type="button" class="btn btn-sm btn-success">Button Success</button>
                <hr>
                <!-- Buttons style 4-->
                <button type="button" class="btn btn-lg btn-info">Button Info</button>
                <button type="button" class="btn btn-info">Button Info</button>
                <button type="button" class="btn btn-sm btn-info">Button Info</button>
                <hr>
                <!-- Buttons style 5-->
                <button type="button" class="btn btn-lg btn-warning">Button Warning</button>
                <button type="button" class="btn btn-warning">Button Warning</button>
                <button type="button" class="btn btn-sm btn-warning">Button Warning</button>
                <hr>
                <!-- Buttons style 6-->
                <button type="button" class="btn btn-lg btn-danger">Button Danger</button>
                <button type="button" class="btn btn-danger">Button Danger</button>
                <button type="button" class="btn btn-sm btn-danger">Button Danger</button>
                <hr>
                <!-- Buttons style 7-->
                <button type="button" class="btn btn-lg btn-link">Button Link</button>
                <button type="button" class="btn btn-link">Button Link</button>
                <button type="button" class="btn btn-sm btn-link">Button Link</button>
              </div>
            </div>
          </section>
        </div>
      </div>
      <jsp:include page="getit-footer.jsp"></jsp:include>
    </div>
    <!-- Javascript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/waypoints/lib/jquery.waypoints.min.js"> </script>
    <script src="vendor/jquery.counterup/jquery.counterup.min.js"> </script>
    <script src="vendor/owl.carousel/owl.carousel.min.js"></script>
    <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
    <script src="js/jquery.parallax-1.1.3.js"></script>
    <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
    <script src="vendor/jquery.scrollto/jquery.scrollTo.min.js"></script>
    <script src="js/front.js"></script>
  </body> 
</html>