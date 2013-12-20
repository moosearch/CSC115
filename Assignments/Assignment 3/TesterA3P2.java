public class TesterA3P2
{

  public static void main(String[] args)
  {   StringADT list = new StringADT();
      list.assign("abcd");
      System.out.println(list);
      StringADT list1 = new StringADT();
      list1.assign("new-york");
      System.out.println(list1);
      StringADT list2 = new StringADT();
      list2.copy(list1);
      System.out.println("copied list");
      System.out.println(list2);
      StringADT list3 = new   StringADT();
      list3.concat(list, list2);
      System.out.println("concatenated lists");
      System.out.println(list3);
      System.out.println("original first list");
      System.out.println(list);
      System.out.println("new second list");
      list2.assign("efgh");
      System.out.println(list2);
      System.out.println("original concatenated list");
      System.out.println(list3);
      StringADT list4 = new StringADT();
      list4.repeats(list1,4);
      System.out.println("Repeated Lists");
      System.out.println(list4);
      int n = list4.leng();
      System.out.println("length is "+n);
      list4.substring(list1,1,3);
      System.out.println("Substring from position 1 to 3 is ");
      System.out.println(list4);//*/
  }
}