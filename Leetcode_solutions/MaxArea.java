public class MaxArea {
    public int maxArea(int[] height) {
        if (height.length == 0 || height.length == 1)
            return 0;
        int area = (height.length - 1) * Math.min(height[0], height[height.length - 1]);
        int maxArea = area;
        int j = height.length - 1;
        int i = 0;
        while (i < j) {
            if (height[j] < height[i])
                j--;
            if (height[i] <= height[j])
                i++;
            area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(area, maxArea);

        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea x = new MaxArea();
        System.out.println(x.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

}
