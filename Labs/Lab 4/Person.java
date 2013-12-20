public abstract class Person implements Comparable{
    private String name;
    private String email;

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }

    public String toString(){
        return name + ", " + email;
    }
    //have to add implement to this file as this implements Comparable
    public int compareTo(Object other){
        return name.compare( (Person)other.getName() );
    }
}