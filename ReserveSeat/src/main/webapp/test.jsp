<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>네이버 로그인 테스트</title>
  
</head>
<body>
<div id="naver_id_login"></div>

  <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
  
<script>
/* 02.10최종완료 - */
/* 네이버 아이콘 클릭 시 콜백되는 화면, 해당 화면에서 ApiLoginController의 Naver메서드들과 데이터를 주고받으며 가입처리 및 로그인 처리 */
	const naverLogin = new naver.LoginWithNaverId({
		clientId: "내 클라이언트ID",
		callbackUrl: "설정했던 콜백URL",
		isPopup: false, /* 팝업을 통한 연동처리 여부 */
	    callbackHandle: true
	});

	naverLogin.init();/* 설정정보를 초기화하고 연동을 준비 */

	window.addEventListener('load', function () {	
		naverLogin.getLoginStatus(function(status) {
			if (status) {
				const email = naverLogin.user.getEmail();
				const nickName = naverLogin.user.getNickName();
				
				console.log(naverLogin);
				
				$.ajax({
					type : 'post',
					url : 'naverSaved',
					data : {"email" : email, "nickname" : nickName, "id" : id},
					dataType : 'text',
					success: function(result) {
						/* success 1 : 가입해야 할 경우 */
		                if(result=='ok') {
		                    /* success 1-1 : 닉네임 입력받아 가입시키기 */
   		                    /* 닉네임 입력 시 가입, 미입력 시 주소 리턴 */
		                    var newNickname = prompt('사용하실 닉네임을 입력해주세요');
		                    if(newNickname != null){ /* 입력 시 데이터 전송으로 자동로그인 처리 및 메인 페이지 이동 */
			                    $.ajax({
			    					type : 'post',
			    					url : 'naverSignin',
			    					data : {"email" : email, "nickname" : newNickname, "id" : id}
			    				});			                    
		                    	alert(newNickname + "님 환영합니다");
			                    location.href = "/video/list";
		                    }		                    
		                    else { /* 가입 거절 시 로그인화면 리턴 */
		                    	location.href = "/user/signin"
		                    }
		                    
		    			/* success 2 : 기가입  */
		                } else if(result != null) {
		                    alert(result + "님 반갑습니다.")
		                    location.href = "/video/list"
		                }
		            },
		            error: function(result) {
		                console.log('오류 발생')
		            }
				})
		         
			} else alert("콜백 실패");
			
		});
	});
</script>

</body>
</html>
