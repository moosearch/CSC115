public class TesterA3P1
{

  public static void main(String[] args)
  { MyList list = new MyList();
    list.addHead('E');
    list.addHead('M');
    for(int i=0;i<10;i++){
        list.addHead('O');
    }
    list.addHead('C');
    System.out.println(list);
    System.out.println(list);
  }
}