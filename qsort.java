import java.util.Arrays;
public class qsort{
  public static void printarr(int[] arr){
    System.out.printf("[ ");
    for(int i=0;i<arr.length-1;i++){
      System.out.printf("%d,",arr[i]);
    }
    System.out.printf("%d ]",arr[arr.length-1]);
  }
  public static void bsort(int[] arr){
    for(int i=0;i<arr.length;i++){
      for(int j=arr.length-1;j>i;j--){
        if(arr[j]<arr[j-1])
        {
          int temp=arr[j];
          arr[j]=arr[j-1];
          arr[j-1]=temp;
        }
      }
    }
  }
  public static void qsort(int[] arr,int leftboundary,int rightboundary){
    //System.out.println("hihi");
    if(rightboundary-leftboundary<1)
      return;
    int left=leftboundary;
    int right=rightboundary;
    //System.out.println("");
    //System.out.printf("left=%d\n",left);
    //System.out.printf("targetIndex=%d\n",targetIndex);
    //System.out.printf("right=%d\n",right);
    int target=arr[left];
    int targetIndex=left;
    int temp;

    while(left<right){
      while(arr[left]<=target && left<rightboundary){
        left++;
      }
      while(arr[right]>=target && right>leftboundary){
        right--;
      }
      if(right>left){
        temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
      }
    }
    if(left!=right )
    {
      temp=left;
      left=right;
      right=temp;
    }
    temp=arr[left];
    arr[left]=arr[targetIndex];
    arr[targetIndex]=temp;
    qsort(arr,right,rightboundary);
    qsort(arr,leftboundary,left);
  }
  public static void main(String args[]){
    //int[] arr={888, 92, 96, 33 , 96, 23};
    int[] arr=new int[1000000];
    for(int i=0;i<arr.length;i++){
      arr[i]=(int)(Math.random()*1000000);
    }
    long start=System.currentTimeMillis();
    //bsort(arr); //don't do that 
    //qsort(arr,0,arr.length-1);
    //Arrays.sort(arr);
    long end=System.currentTimeMillis();
    System.out.printf("runtime: %d second \n",end-start);
    //printarr(arr);
  }
}
