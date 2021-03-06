package com.elearning.chapter4.interviewquestion20;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 面试题20：顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int start = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        while ((2*start<row)&&(2*start<col)){
            result.addAll(printMatrixByCircle(matrix,start));
            start++;
        }
        return result;
    }
    public ArrayList<Integer> printMatrixByCircle(int[][] matrix, int start){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int endX = matrix.length-1-start;
        int endY = matrix[0].length-1-start;
        int indexX = start;
        int indexY = start;
        //是一行
        if(endX==start){
            int i = start;
            while (i<=endY){
                result.add(matrix[start][i]);
                i++;
            }
        }
        //是一列
         else if(endY==start){
            int j = start;
            while (j<=endX){
                result.add(matrix[j][endY]);
                j++;
            }
        }
        else {
            //从左到右
            while (indexY<endY){
                result.add(matrix[indexX][indexY]);
                indexY++;
            }
            //从上到下
            while (indexX<endX){
                result.add(matrix[indexX][indexY]);
                indexX++;
            }
            // 从右到左
            while (indexY>start){
                result.add(matrix[indexX][indexY]);
                indexY--;
            }
            //从下到上
            while (indexX>start){
                result.add(matrix[indexX][indexY]);
                indexX--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       /* int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};*/
        int[][] matrix = {{1}};

        System.out.println(solution.printMatrix(matrix));
    }
}
