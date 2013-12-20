public class PartIII{

  public static void main(String [] args){

      int n = Integer.parseInt(args[0]);
      printSequence(n);
  }

  public static void printSequence(int n){

      if(n==1){
        System.out.print(1);
      }

      else{
        printSequence(n-1);
        System.out.print(" "+n+" ");
        printSequence(n-1);
      }

  }
}