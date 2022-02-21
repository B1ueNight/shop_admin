<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <%@include file="/WEB-INF/includes/header.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <main>
        <h1>주문 현황</h1>
        <div class="product_list">
            <div class="product">
                <h2>총 제품 수 : </h2>
                <p> 페이지 : </p>
            </div>
            <div class="search_area">
                <div class="search_box">
                    <input type="text" id="keyword" value="${keyword}">
                    <a href="#" id="search_btn">검색</a>
                </div>
                <div class="order_list">
                    <table>
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>상품 번호</td>
                                <td>주문자</td>
                                <td>가격</td>
                                <td>수량</td>
                                <td>받는 사람</td>
                                <td>주소</td>
                                <td>연락처</td>
                                <td>배송 메세지</td>
                                <td>결제수단</td>
                                <td>배송상태</td>
                                <td>송장번호</td>
                                <td>상태</td>
                                <td>등록일</td>
                                <td>업데이트</td>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="item">
                                <tr>
                                    <td>${item.oi_seq}</td>
                                    <td>${item.oi_pi_seq}</td>
                                    <td>
                                        <a href="" target="_blank"></a>
                                    </td>
                                    <td>${item.oi_mi_seq}</td>
                                    <td>${item.oi_price}</td>
                                    <td>${item.oi_count}</td>
                                    <td>${item.oi_shipping_name}</td>
                                    <td>${item.oi_shipping_address}</td>
                                    <td>${item.oi_shipping_phone}</td>
                                    <td>${item.oi_shipping_request}</td>
                                    <td>${item.oi_pay_type}</td>
                                    <c:if test="${item.oi_delivery_status == 0}"><span>배송전</span></c:if>
                                    <c:if test="${item.oi_delivery_status == 1}"><span>배송중</span></c:if>
                                    <td>${item.oi_delivery_number}</td>
                                    <c:if test="${item.oi_status == 0}"><span>정상</span></c:if>
                                    <c:if test="${item.oi_status == 1}"><span>반품</span></c:if>
                                    <c:if test="${item.oi_status == 2}"><span>교환</span></c:if>
                                    <fmt:formatDate value="${item.oi_reg_dt}" pattern="yyyy-MM-dd HH:mm:ss" />
                                    <fmt:formatDate value="${item.oi_mod_dt}" pattern="yyyy-MM-dd HH:mm:ss" />
                                </tr>
                                <biv class="btns">
                                    <button class="delivery_number">배송처리</button>
                                    <button id="update">수정</button>
                                    <button id="cancel">취소</button>
                                </biv>
                            </c:forEach>
                        </tbody>
                        <div class="pager_area">
                            <c:forEach begin="1" end="${page}" var="i">
                                <a href="/account/member?offset=${(i-1)*10}&keyword=${keyword}">${i}</a>
                            </c:forEach>
                        </div>
                    </table>
                </div>

                <div class="popup_wrap">
                    <div class="popup">
                        <h2>송장번호 추가</h2>
                        <div class="delivery_number_add">
                            <input type="text" id="di_name" placeholder="택배사">
                            <input type="text" id="oi_delivery_number" placeholder="송장번호">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    
</body>
</html>