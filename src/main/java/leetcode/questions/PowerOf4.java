package leetcode.questions;

public class PowerOf4 {

    public boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        return isPowerOfFourHelper(n);
    }

    private boolean isPowerOfFourHelper(int n) {
        if (n == 4) {
            return true;
        }
        if (n % 4 != 0) {
            return false;
        }
        return isPowerOfFourHelper(n / 4);
    }

    /* Your Browser will be instantiated and called as such:
     * Browser browser = new Browser();
     * browser.visit("google.com");
     * browser.visit("amazon.com");
     * browser.visit("twitter.com");
     * String url1 = browser.back(1); // url1 = "amazon.com"
     * browser.visit("facebook.com");
     * String url2 = browser.back(1); // url2 = "amazon.com"
     * String url3 = browser.forward(1); // url3 = "facebook.com"
     */

}
