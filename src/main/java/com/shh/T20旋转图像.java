//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像
//输入：matrix = {{1,2,3},{4,5,6},{7,8,9}}
//输出：[[7,4,1],[8,5,2],[9,6,3]]

//输入：matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

package com.shh;
import java.util.Arrays;

public class T20旋转图像 {
    public static void main(String[] args) {
      int[][] matrix=new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
      Solution20 st20=new Solution20();
      st20.rotate(matrix);
    }
}
//拥有规律,其实就是行列的互换(第一行和最后一列,第二行和倒数第二列...)
class Solution20{
    public void rotate(int[][] matrix) {
        int [][] new_matrix=new int[matrix.length][matrix.length];
        //旋转得到新的矩阵
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
               new_matrix[j][matrix.length-1-i]=matrix[i][j];
            }
        }
        //将新矩阵赋值回给旧矩阵
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                matrix[i][j]=new_matrix[i][j];
            }
        }
        for(int [] s:matrix)//打印处理好的矩阵
        {
            System.out.println(Arrays.toString(s));
        }
    }
}
/*只实现了对角的顺时针旋转
class Solution20 {
    public void rotate(int[][] matrix) {
        //n维的矩阵需要处理(3->1,4->2,5->2,6->3;可得规律n/2)
        int times=matrix.length/2;
        //每一层都先处理四个对角,剩下的就好处理了
        int temp1=0,temp2=0;
        //矩形的四个角的位置
        //zs------ys
        //|        |
        //|        |
        //zx------yx
        //int zs=matrix[0][0],ys=matrix[0][matrix[0].length-1];
        //int zx=matrix[matrix.length-1][0],yx=matrix[matrix[0].length-1][matrix.length-1];
        int m=0;
        int n=2;//每次减去2
        System.out.println(times);
        for(int i=times;i>0;i--)//需要对矩形进行times次操作
        {
           //对四个角进行操作
           temp1=matrix[0+m][matrix[0].length-1-m];//ys
           temp2=matrix[matrix.length-1-m][0+m];//zx
           matrix[0+m][matrix[0].length-1-m]=matrix[0+m][0+m];//ys=zs
           matrix[matrix.length-1-m][0+m]=matrix[matrix[0].length-1-m][matrix.length-1-m];//zx=yx
           matrix[matrix[0].length-1-m][matrix.length-1-m]=temp1;//yx=ys
           matrix[0+m][0+m]=temp2;//zs=zx
           m++;
        }
        for(int [] s:matrix)//打印处理好的矩阵
        {
            System.out.println(Arrays.toString(s));
        }
    }
}
*/
