import java.util.Scanner;
import java.util.Arrays;

 public class main {
    public static void main(String[] args) {
       
       Scanner input = new Scanner(System.in);

       final int SIZE = 10;
       int sum = 0 ;
       int arr[] =new int[SIZE];
       
       System.out.print("0부터 100사이의 정수값 10개를 입력하세요 : ");
       
       for(int i=0;i<SIZE;i++) {
          
          arr[i]=input.nextInt();
          sum += arr[i];
          if(arr[i]>100 || arr[i]<0)
             continue;
          
       }
       Arrays.sort(arr);
       printSort(arr,sum/SIZE);
  }
    public static void printSort(int array[],int average) {
        System.out.print("정렬된 배열 : ");
        for(int e : array)
           System.out.print(e+" ");
        System.out.println();
        System.out.print("평균은 : " + average) ;
    }
}
