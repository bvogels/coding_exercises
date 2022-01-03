public class Buckets {

    public int maxArea(int[] height) {
        int l = 0, lstart = 0;
        int r = height.length-1, rstart = height.length-1;
        int area;
        int max = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                /*while (height[l] < height[lstart] && l < r) {
                    l++;
                }*/
                lstart = l;
                if (height[l] >= height[r]) {
                    area = (r - l) * height[r];
                } else {
                    area = (r - l) * height[l];
                }
                if (area > max) {
                    max = area;
                };
                l++;
            } else {
                /*while (height[r] < height[rstart] && r > l) {
                    r--;
                }*/
                rstart = r;
                if (height[r] >= height[l]) {
                    area = (r - l) * height[l];
                } else {
                    area = (r - l) * height[r];
                }
                if (area > max) {
                    max = area;
                };
                r--;
            }
        }
        return max;
    }
}
