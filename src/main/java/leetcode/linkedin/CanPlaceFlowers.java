package leetcode.linkedin;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            boolean canPlantLeft = i == 0 || flowerbed[i - 1] == 0;
            boolean canPlantRight = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
            if (canPlantLeft && canPlantRight) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
