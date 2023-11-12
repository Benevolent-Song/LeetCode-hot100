//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//示例 1：
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//先对每个数组按照数组的第一个元素进行排序
package com.shh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T14合并区间 {
    public static void main(String[] args) {
        int [][] res=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Solution14 st14=new Solution14();
        for(int [] i:st14.merge(res))//输出二维数组
        {
        System.out.println(Arrays.toString(i));
        }
    }
}
class Solution14{
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }//按照二维数组每行第一个元素的大小进行升序排序
        });
        List<int[]> merged = new ArrayList<int[]>();//已经排序好的数组
        for (int i = 0; i < intervals.length; ++i)//遍历数组的每一行
        {
            int L = intervals[i][0];//数组的左界
            int R = intervals[i][1];//数组的右界
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L)
            //左下标大于最大左界数组的右界,说明无相交,直接加入该数组
            {
                merged.add(new int[]{L, R});//直接加入该数组
            }
            else//如果可以合并
            {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);//更新最后一个数组，每次取右界的最大值
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
