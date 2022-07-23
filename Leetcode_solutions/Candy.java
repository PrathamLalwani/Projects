import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candyDist = new int[ratings.length];
        if (ratings.length == 0)
            return 0;
        if (ratings[0] > ratings[1])
            candyDist[0] = 2;
        else
            candyDist[0] = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                candyDist[i] = candyDist[i - 1] + 1;
            else if (i + 1 < ratings.length && ratings[i] > ratings[i + 1])
                candyDist[i] = 2;
            else
                candyDist[i] = 1;
        }
        
        return Arrays.stream(candyDist).sum();
    }
}
