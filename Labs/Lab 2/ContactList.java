public class ContactList{

    private Contact [] list;
    private int count;

    public ContactList(){
        list = new Contact[10];
        count = 0;
    }

    public ContactList(int size){
        list = new Contact[size];
        count = 0;
    }

    public void add(String name,String phone,String email){
        Contact c = new Contact(name,phone,email);
        list[count]=c;
        count++;
    }

    public void remove(String name){
        for(int i=0;i<count;i++){
            if(name.equals( list[i].getName() ) ){
                list[i] = list[count-1];
                count--;
                break;
            }
        }
    }

    public String toString(){
        String result="";
        for(int i=0;i<count;i++){
            result+=list[i]+"\n";
        }
        return result;
    }

}