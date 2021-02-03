function pay() {
	var name = document.getElementById("name").value
	var email = document.getElementById("email").value
	var tel = document.getElementById("tel").value
	
	var IMP = window.IMP; // 생략가능
	IMP.init('imp40532383'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용 (테스트용 식별코드 imp40532383)

	IMP.request_pay({
	    pg : 'kakao', // 결제 방식
	    /*
			html5_inicis(이니시스웹표준)
			inicis(이니시스ActiveX결제창)
			kcp(NHN KCP)
			kcp_billing(NHN KCP 정기결제)
			uplus(LGU+)
			nice(나이스페이)
			jtnet(JTNet)
			kakaopay(카카오페이)
			danal(다날휴대폰소액결제)
			danal_tpay(다날일반결제)
			mobilians(모빌리언스 휴대폰소액결제)
			settle(세틀뱅크)
			syrup(시럽페이)
			payco(페이코)
			paypal(페이팔)
			eximbay(엑심베이)
			naverco(주문형-네이버페이)
			naverpay(결제형-네이버페이)
			smilepay(스마일페이)
	     */
	    pay_method : 'trans',	// 결제 수단
	    /*
			card(신용카드)
			trans(실시간계좌이체)
			vbank(가상계좌)
			phone(휴대폰소액결제)
			samsung(삼성페이 / 이니시스, KCP 전용)
			kpay(KPay앱 직접호출 / 이니시스 전용)
			cultureland(문화상품권 / KG이니시스, KCP, LGU+ 지원)
			smartculture(스마트문상 / KG이니시스, KCP, LGU+ 지원)
			happymoney(해피머니 / KG이니시스, KCP지원)
			booknlife(도서문화상품권 / KG이니시스, KCP, LGU+지원)
	     */
	    
	    merchant_uid : 'merchant_' + new Date().getTime(),	// 가맹점에서 생성/관리하는 고유 주문번호(필수)
	    name : '주문명:결제테스트',				// 주문명(16자 이내, 선택)
	    amount : 14000,						// 결제할 금액(필수)
	    buyer_name : name,				// 주문자명(선택)
	    buyer_tel : tel,		// 주문자 연락처(필수)
	    buyer_email : email,	// 주문자 Email(선택)
	    
	    // 모바일 결제시, 결제가 끝나고 랜딩되는 URL
	    m_redirect_url : 'http://localhost:8095/Dev2_YalLockMalLock_User_Server/storage/resultPayment.do',
	    // WebView 결제시 필수. ISP/앱카드 앱에서 결제정보인증 후 원래 앱으로 복귀할 때 사용됨
	    app_scheme : 'http://localhost:8095/Dev2_YalLockMalLock_User_Server/storage/storageList.do'	
	});
}
