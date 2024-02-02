<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="/" class="logo">
                        <img src="/resources/assets/images/logo.png" alt="">
                    </a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Search End ***** -->
                    <div class="search-input">
                      <form id="search" action="#">
                        <input type="text" placeholder="Type Something" id='searchText' name="searchKeyword" onkeypress="handle" />
                        <i class="fa fa-search"></i>
                      </form>
                    </div>
                    <!-- ***** Search End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="/" id="Home">Home</a></li>
                        <li><a href="browse" id="Browse">Browse</a></li>
                        <li><a href="details.html" id="Details">Details</a></li>
                        <li><a href="/shop/list" id="Shop">Shop</a></li>
                        
                    </ul>   
                    <ul class="nav">
                   		 <c:if test="${member eq null }">
                    		<li><a href="/member/login">Login</a></li>
                    		<li><a href="/member/join">Join</a> </li>
                    	</c:if>
               			<c:if test="${not empty member}">	
               				<li><a href="/member/mypage">Mypage <img src="/resources/assets/images/profile-header.jpg" alt="" style = width:40px;></a></li>
                    		<li><a href="/member/logout">Logout</a>
                    	</c:if>
                    </ul>
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
  </header>