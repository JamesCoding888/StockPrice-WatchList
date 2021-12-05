<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="symbols" required="true" rtexprvalue="true" %>
<meta http-equiv="refresh" content="5">
<table class="pure-table">          
    <thead>
        <tr>
            <th>#</th>            
            <th>Symbol</th>
            <th>Name</th>
            <th>Previous Close</th>
            <th>Price</th>
            <th>% Change</th>
            <th>Ask</th>
            <th>Bid</th>
            <th>Avg. Volume</th>
            <th>Volume</th>
            <th>Start Trading</th>
            
        </tr>
    </thead>
    <tbody>
        <!-- 使用核心標籤庫 "c:forEach" 去抓取 symbols 的股票代碼給 symbolFromsymbols 
             如此才能將每一筆xxx的股票代碼傳回 watchlistTagTest.jsp 頁面        
        -->
        <c:forEach varStatus="statusOfsymbolFromsymbols"  var = "symbolFromsymbols" items = "${fn:split(symbols, ',')}"> 
                <jsp:useBean class = "com.web.tagTest.MyStockTest" id ="myStockTest" />
                <jsp:setProperty name = "myStockTest" property = "symbol" value="${ symbolFromsymbols }" />               
                
            <tr ${ statusOfsymbolFromsymbols.index % 2 == 0 ? "class= \"pure-table-odd\"" :  ""}>
                <td>${ statusOfsymbolFromsymbols.index+1 } </td>
                <td>${ symbolFromsymbols }</td>
                <td>${ myStockTest.name }</td>
                <td>${ myStockTest.previousClose }</td>
                <td style="color: ${ myStockTest.color } ; background: ${ myStockTest.bgcolor }">${myStockTest.colorOfPriceLogo} ${ myStockTest.price }</td>
                <td style="color: ${ myStockTest.color } ; background: ${ myStockTest.bgcolor }">${ myStockTest.change  } % </td>                        
                <td>${ myStockTest.ask }</td>
                <td>${ myStockTest.bid }</td>      
                <td>${ myStockTest.avgVolume }</td>      
                <td>${ myStockTest.volume }</td>                   
                <td><a class="pure-button" href="#">Buy</a> <a class="pure-button" href="#">Sell</a></td>                                 
            </tr>             
        </c:forEach>            
    </tbody>
</table>
