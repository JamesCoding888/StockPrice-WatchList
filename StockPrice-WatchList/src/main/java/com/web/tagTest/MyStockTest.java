package com.web.tagTest;

import java.text.DecimalFormat;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class MyStockTest {
    private static final String RED = "#FF0000";
    private static final String GREEN = "#005100";
    private static final String BLACK = "#000000";
    private static final String WHITE = "#f8f8f8";    
    private String symbol;
    private String name;
    private Double price;
    private Double change; 
    private String color;
    private Double previousClose; 
    private String bgcolor;
    private String colorOfPriceLogo;
    private Double ask; 
    private Double bid; 
    private String avgVolume; 
    private String volume; 

    //格式化數字表示
    public static String formatString1(Integer data) {
        DecimalFormat df = new DecimalFormat("#,###"); 
        return df.format(data);
    }
    
    public MyStockTest(){
        
    }
    public MyStockTest(String symbol) {
        setSymbol(symbol);
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        
        try {            
            Stock stock = YahooFinance.get(symbol);
            System.out.println(stock); //測試 stock 物件是否不是 null                                    
//          System.out.println(stock.getQuote().getPreviousClose()); // 得到昨日股票收盤價
//          System.out.println(stock.getQuote()); // ask, bid, price, prev close
            this.previousClose = stock.getQuote().getPreviousClose().doubleValue();
            this.name = stock.getName();
            this.price = stock.getQuote().getPrice().doubleValue();
            this.change = stock.getQuote().getChangeInPercent().doubleValue();                
            this.avgVolume = stock.getQuote().getAvgVolume().toString();
            this.volume = stock.getQuote().getVolume().toString();            
            this.ask = stock.getQuote().getAsk().doubleValue();
            this.bid = stock.getQuote().getBid().doubleValue();
            this.bgcolor = (this.change) >= 9 ? "#FF0000" : (this.change) <= -9 ? "#005100" : "";
            this.colorOfPriceLogo = (this.change) >= 9 ? "▲" : (this.change) <= -9 ? "▼" : "";
            this.color = (this.change) > 0 && (this.change) >= 9 ? 
                         WHITE : (this.change) > 0 && (this.change) <9 ? 
                         RED : (this.change) < 0 && (this.change) <= -9 ? 
                         WHITE : (this.change) < 0 && (this.change) > -9 ? GREEN : BLACK;

        } catch (Exception e) {
        }        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Double getChange() {
        return change;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public String getAvgVolume() {        
        return formatString1(Integer.parseInt(avgVolume));        
    }

    public void setAvgVolume(String avgVolume) {        
        this.avgVolume = avgVolume;
    }

    public String getVolume() {  
        return formatString1(Integer.parseInt(volume));                
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
   
    public void setChange(Double change) {
        this.change = change;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBgcolor() {
        return bgcolor;
    }

    public void setBgcolor(String bgcolor) {
        this.bgcolor = bgcolor;
    }

    public String getColorOfPriceLogo() {
        return colorOfPriceLogo;
    }

    public void setColorOfPriceLogo(String colorOfPriceLogo) {
        this.colorOfPriceLogo = colorOfPriceLogo;
    }

    public Double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(Double previousClose) {
        this.previousClose = previousClose;
    }

    public static void main(String[] args) {
        // 測試用的     
        System.out.println(new MyStockTest("2330.TW").getAvgVolume());
        String number = "123131231";
        System.out.println(formatString1(Integer.parseInt(number)));
        
    }
}
