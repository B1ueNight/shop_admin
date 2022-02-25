<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <%@include file="/WEB-INF/includes/header.jsp"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <script src="/assets/js/order.js"></script>
</head>
<body>
    <main>
        <h2>주문 관리</h2>
        <table>
            <thead>
                <td>
                    <th>주문번호</th>
                    <th>제품명</th>
                    <th>금액</th>
                    <th>수량</th>
                    <th>총 금액</th>
                    <th>수령인</th>
                    <th>배송지</th>
                    <th>연락처</th>
                    <th>요청사항</th>
                    <th>결제방법</th>
                    <th>주문상태</th>
                    <th>배송상태</th>
                    <th>송장번호</th>
                    <th>주문일</th>
                    <th>처리일</th>
                    <th></th>
                </td>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.oi_seq}</td>
                    <td>${item.pi_seq}</td>
                    <td>
                        
                    </td>
                    <td>${item.oi_price}</td>
                    <td>${item.oi_count}</td>
                    <td>
                        <fmt:formatNumber value="${item.order_amount}" pattern="###,###,###"/>
                    </td>
                    <td>${item.oi_shipping_name}</td>
                    <td>${item.oi_shiipping_address}</td>
                    <td>${item.oi_shiipping_phone}</td>
                    <td>${item.oi_shipping_request}</td>
                    <td>
                        <c:choose>
                            <c:when test="${item.oi_pay_type == 'account'}">계좌이체</c:when>
                            <c:when test="${item.oi_pay_type == 'card'}">신용카드</c:when>
                            <c:when test="${item.oi_pay_type == 'kakao'}">카카오페이</c:when>
                            <c:when test="${item.oi_pay_type == 'naver'}">네이버페이</c:when>
                            <c:when test="${item.oi_pay_type == 'toss'}">토스</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${item.oi_status == 0}">정상</c:when>
                            <c:when test="${item.oi_status == 1}">반품</c:when>
                            <c:when test="${item.oi_status == 2}">교환</c:when>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                        <c:when test="${item.oi_delivery_status == 0}">배송전</c:when>
                        <c:when test="${item.oi_delivery_status == 1}">배송중</c:when>
                        <c:when test="${item.oi_delivery_status == 2}">배송완료</c:when>
                        </c:choose>
                    </td>
                    <td>${item.di_name}</td>
                    <td>
                        <c:if test="${item.oi_delivery_number == null}">
                            <span>미입력</span>
                        </c:if>
                        <c:if test="${item.oi_delivery_number != null}">
                            ${item.oi_delivery_number}
                        </c:if>
                    </td>
                    <td>
                        <fmt:formatDate value="${item.oi_reg_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <td>
                        <fmt:formatDate value="${item.oi_mod_dt}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    </td>
                    <td>
                        <c:if test="${item.oi_delivery_status == 0}">
                            <button class="delivery_confirm" data-seq="${item.oi_seq}">송장입력</button>
                        </c:if>
                        <c:if test="${item.oi_delivery_status != 0}">
                            <button disabled>송장입력</button>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="pager_area">
            <c:forEach begin="1" end="${page}" var="i">
                <a href="/order/list?keyword=${keyword}&offset=${(i-1)*10}" class="pager">${i}</a>
            </c:forEach>
        </div>
        <div class="popup" style="display: none;">
            <div class="popup_wrap">
                <h2>송장입력</h2>
                <input type="text" id="delivery_number">
                <button id="save">확인</button>
                <button id="cancel">취소</button>
            </div>
        </div>
    </main>
</body>
</html>