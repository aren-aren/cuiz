<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <header class="header-area header-sticky">
    <!-- 
        {clikedId : Home}저장된걸 삭제
        {clikedId : Browse}이거 저장
        "{"clikedId" : "Browse"}"
        {loginId : ysy}이거 저장

        1. 클릭되면 e.preventDefault로 우선 이동을 막고
        2. 로컬스토리지에 현재 선택된 id값을 저장한다.
        3. 이동시킨다.
        4. 로드가 완료되면 LOCALSTORAGE로부터 ID가져와서 해당 DOM객체에 active클래스를 추가
        5. 이에 앞선 작업은 기존에 선택된 클래스를 날려야함 

     -->
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
                        <li><a href="/" class="active">Home</a></li>
                        <li><a href="/member/list">Member List</a></li>
                        <li><a href="/quiz/list">Quiz</a></li>
                        <li><a href="/shop/list">Shop</a></li>
                        <li><a href="/notice/list">Notice</a></li>
                        <li><a href="/qna/list">QnA</a></li>
                    	 <c:if test="${not empty member}">
                    		<li><a href="/member/logout">Logout</a></li>
                        <li><a href="/mypage/profile">${member.member_Nick} <img src="/resources/assets/images/profile-header.jpg" alt=""></a></li>
                    	</c:if>
                   		 <c:if test="${member eq null }">
                    		<li><a href="/member/login">Login<img src="/resources/assets/images/profile-header.jpg" alt=""></a></li>                    		
                    	</c:if>
                    </ul>   
                   <%--  <ul class="nav">
               			<c:if test="${not empty member}">	
               				<li><a href="/member/mypage">Mypage <img src="/resources/assets/images/profile-header.jpg" alt="" style = width:40px;></a></li>
                    	</c:if>
                    </ul> --%>
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
  </header>