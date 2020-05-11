package thirtydayschallenge;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        if(image[sr][sc] == newColor) return image;
        while(!q.isEmpty()) {
            int[] coordinate = q.poll();
            image[coordinate[0]][coordinate[1]] = newColor;
            //process connected pixel
            if(coordinate[0] - 1 >=0 && image[coordinate[0] - 1][coordinate[1]] == oldColor)
                q.add(new int[] {coordinate[0] - 1, coordinate[1]});
            if(coordinate[0] + 1 < m && image[coordinate[0] + 1][coordinate[1]] == oldColor)
                q.add(new int[] {coordinate[0] + 1, coordinate[1]});
            if(coordinate[1] - 1 >= 0 && image[coordinate[0]][coordinate[1] - 1] == oldColor)
                q.add(new int[] {coordinate[0], coordinate[1] - 1});
            if(coordinate[1] + 1 < n && image[coordinate[0]][coordinate[1] + 1] == oldColor)
                q.add(new int[] {coordinate[0], coordinate[1] + 1});
        }
        return image;
    }

}
