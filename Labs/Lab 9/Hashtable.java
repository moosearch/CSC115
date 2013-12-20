public class HashTable{
    private KeyValuePair table[];
    private int tableSize; //size of table
    private int size; //current # of items in table
    private int collisionCount;

    //constructor
    public HashTable(int capacity){
        table = new KeyValuePair[capacity];
        tableSize = capacity;
        size = 0;
        collisionCount = 0;
    }

    public String toString(){
        String result = "HashTable with " + size + " item(s), a capacity of " + tableSize;
        result += " and load factor: "+(size+0.0)/tableSize + "\n";

        for (int i = 0; i < tableSize; i++){
            if (table[i] != null){
                result += "0Index " + i + " --- " + table[i].toString() + "\n";
            }
        }
        return result;
    }

    public int getCollisionCount(){
        return collisionCount;
    }

    /**
     * This is the hash function that simply mods the key by the size of the array.
     */
    private int hashFunction1( int key ){
        return key%tableSize;
    }

    /**
     * This is the hash function that appends the 8 bit binary representative for the value (0...9) of
     * each digit in the integer and then mods the array size.
     * Ignore this method as we did not talk much about it in the lab
     * In a nutshell, this hashFunction is more efficient than the original one we had
     */
    private int hashFunction2( int key ){
        String s = ((Integer)key).toString().toLowerCase();
        long total = 0;
        int charValue;
        char ch;
        for (int i=0; i<s.length(); i++) {
            ch = s.charAt(i);
            charValue = (ch - '0');
            total = (total << 5) + charValue;
            total %= tableSize;
        }
        return (int)total;
    }

    public boolean isFull(){
        // FILL IN THIS METHOD.
        // returns true if the hashtable is full, false otherwise.
        return(size == tableSize);
    }

    // Inserts the key and value pair into the table array.
    public void insert(int key, Object value){
        // FILL IN THIS METHOD
        // if the hashtable is not full
        //     hash the key to figure out the index in the table where the data should be added - start by using hashFunction1.
        //     if there is already data at that index, check the next one. Keep checking until you find an empty spot - remember that you might need to wrap
        //     around the array.
        //     Once you have found an empty spot, add the data in at that index.
        if(!isFull()){
            int index= hashFunction1(key);

            while(table[index] != null){
                //if index != size, index = index+1; otherwise, if index = size, then index = 0
                //it will loop around the array
                index = (index+1)%tableSize;
                collisionCount++;
            }

            table[index] = new KeyValuePair(key, value);
            size++;
        }
    }

    // Finds and return the item with the given key. If there is no item with the given key in the hashtable, return null.
    public Object find(int key){
        // FILL IN THIS METHOD
        // hash the key to figure out the index in the table where the data should appear.
        // check if data with the given key is stored in that index.
        // if not, keep checking the next spot in the array until you find the data with the specified key or an empty space.
        // if you found an empty space, it means the key is not in the hashtable.

        //my original method
        /*int index = hashFunction1(key);
        if(table[index].getKey() == key){
            return table[index].getValue();
        }else{
            int counter = 0;
            while(table[index]!=null&&counter!=tableSize){
                if(table[index].getKey()==key){
                    return table[index].getValue();
                }
                index = (index+1)%tableSize;
                counter++;
            }
            return null;
        }*/

        //TA's code implementation
        int index = hashFunction1(key);
        for(int i=0; i<table.length;i++){
            if(table[index] != null){ //if it is null, it would break out of forloop
                if(table[index].getKey() == key){
                    return table[index].getValue();
                }
            }else{
                break;
            }
            index = (index+1)%tableSize;
        }
        return null;
    }

    // Increases the capacity of the hashtable according to the parameter.
    public void increaseCapacity(int newCapacity){
        //WRONG CODE (My original implementation)
        /*
        KeyValuePair tempTable[] = table;
        HashTable newTable = new HashTable(newCapacity);

        for(int i = 0;i<tempTable.length;i++){
            if(tempTable[i]!=null){
                newTable.insert(tempTable[i].getKey(),tempTable[i].getValue());
            }
        }
        table = newTable;
        */

        //TA's code implementation
        KeyValuePair tempTable[] = table;

        table = new KeyValuePair[newCapacity];
        size = 0;
        tableSize = newCapacity;
        collisionCount = 0;

        for(int i = 0; i<tempTable.length;i++){
            if(tempTable[i]!=null){
                insert(tempTable[i].getKey(),tempTable[i].getValue());
            }
        }

        // FILL IN THE REST OF THIS METHOD
        // create a new table array with the new capacity.
        // reset the size, tableSize, and collision count for this new table.
        // grab each item out of the tempTable and insert them into the table array.


    }

    public static void main(String[] args){
        //make an array of KeyValuePair Objects, then insert a bunch of KeyValuePair objects
        HashTable hashtable = new HashTable(10);
        hashtable.insert(42, "Jeremy");
        hashtable.insert(55, "Gautam");
        hashtable.insert(38, "Donna");
        hashtable.insert(25, "Victoria");
        hashtable.insert(19, "Ali");
        hashtable.insert(23, "Bob");
        hashtable.insert(32, "Ackbar");
        hashtable.insert(12, "Tovak");
        hashtable.insert(23, "Minos");
        //hashtable.insert(23, "Milos");
        System.out.println(hashtable);


        // UNCOMMENT THIS TO TEST THE find METHOD
        System.out.println("Searching for key 32 (should be Ackbar): " + hashtable.find(32));
        System.out.println("Searching for key 9 (should be null): " + hashtable.find(9));
        //System.out.println("Searching for key 69 (should be null): " + hashtable.find(69));


        /*
         * switch between hashFunction1 and hashFunction2 to see the efficiencies of the
         * hash functions (the more efficient the hash function is, the less collisions there
         * will be).
         */

        // UNCOMMENT THIS TO TEST THE COLLISION COUNT.
        System.out.println("Number of Collisions: " + hashtable.getCollisionCount() + "\n");


        // UNCOMMENT THIS TO TEST THE increaseCapacity method.
        hashtable.increaseCapacity(20);
        System.out.println(hashtable);
        System.out.println("Number of Collisions: " + hashtable.getCollisionCount() + " \n");

    }
}