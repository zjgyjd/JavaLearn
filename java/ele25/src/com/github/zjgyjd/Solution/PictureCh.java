package com.github.zjgyjd.Solution;

import java.util.Vector;

public class PictureCh {
    public int[][] p = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor != newColor)
            DFS(image , sr , sc , newColor, oldColor);
        return image;
    }

    public void DFS(int[][] image, int sr, int sc, int newColor , int oldColor){
        if(image[sr][sc] == oldColor){
            image[sr][sc] = newColor;
        }else{
            return;
        }

        for(int i = 0 ; i < 4 ; i ++){
            int r = sr + p[i][0];
            int c = sc + p[i][1];
            if(r >= 0 && r < image.length
                    && c >= 0 && c < image[0].length){
                DFS(image, r, c,newColor,oldColor);
            }
        }
    }
}
