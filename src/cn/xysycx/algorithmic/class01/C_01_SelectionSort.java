package cn.xysycx.algorithmic.class01;

import java.util.Arrays;

/**
 * @Description TODO 选择排序 + 验证正确性 的对数器
 * @Author Fedeline
 * @Date 2020/11/23 下午10:49
 */
public class C_01_SelectionSort {
    /**
     * 选择排序 的排序方法
     * @param arr 待排序的原始样本数组
     */
    public static void selectionSort(int[] arr){
//        数组为空和数组容量为1 的 边界情况 直接结束
        if (arr == null || arr.length < 2){
            return;
        }
//
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j :minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    /**
     *
     * @param arr 样本数组
     * @param i   数组下标
     * @param j   数组下标
     */
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    /**
     * 使用工具类对数组进行生成正确排序结果
     * @param arr 数据样本
     */

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    /**
     *
     * @param maxSize 输入要随机生成的样本容量
     * @param maxValue　输入要随机生成的样本的最大值
     * @return
     */
    public static int[] generateRandomArray(int maxSize,int maxValue){
        int arr[] = new int[(int) ((maxSize + 1)*Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     *
     * @param arr 要拷贝的数据样本
     * @return  数据样本新副本
     */
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     *
     * @param arr1 待验证样本
     * @param arr2 正确的参考样本
     * @return
     */
    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }


    /**
     *
     * @param arr 需要打印的数据样本
     */
    public static void printArray(int[] arr){
        if (arr == null){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+"  ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int testTime = 50_0000;
        int maiSize = 100;
        int maxValue = 100;
        boolean succed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maiSize,maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)){
                succed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }

        System.out.println(succed ? "Nice": "Fucking fucked");

        int [] arr = generateRandomArray(maiSize,maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }



}
