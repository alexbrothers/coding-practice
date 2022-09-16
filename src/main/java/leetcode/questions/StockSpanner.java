package leetcode.questions;

import java.util.Stack;

public class StockSpanner {

    class StockSpan {
        int price;
        int numPricesLessThanOrEqual;

        StockSpan(int price, int numPricesLessThanOrEqual) {
            this.price = price;
            this.numPricesLessThanOrEqual = numPricesLessThanOrEqual;
        }
    }

    Stack<StockSpan> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        StockSpan stockSpan = new StockSpan(price, 1);
        while (!stack.isEmpty() && stack.peek().price <= stockSpan.price) {
            stockSpan.numPricesLessThanOrEqual += stack.pop().numPricesLessThanOrEqual;
        }
        stack.push(stockSpan);
        return stack.peek().numPricesLessThanOrEqual;
    }

}
