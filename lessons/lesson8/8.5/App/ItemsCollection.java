public class ItemsCollection {
    Item[] collection;
    int _maxItems;
    int _noItems;

    public ItemsCollection() {
        _maxItems = 20;
        collection = new Item[_maxItems];
        _noItems = 0;
    }

    public boolean addItem(Item item) {
        if (_noItems == collection.length || item == null) {
            return false;
        }
        collection[_noItems] = item;
        _noItems++;
        return true;
    }

    public void playItem(int itemNumber) {
        if (itemNumber > _noItems - 1)
            System.out.println("Item no. " + itemNumber + "doesn’t exist in the collection.");
        else
            collection[itemNumber].play();
    }

    public int getNumberOfCDs() {
        int noCDs = 0;

        for (int i = 0; i < _noItems; i++)
            if (collection[i] instanceof CD)
                noCDs++;

        return noCDs;
    }

    public void oldiesButGoldies(int year) {
        String oldVideo = "";
        for (int i = 0; i < _noItems; i++) {
            Item tmp = collection[i];
            if (tmp instanceof Video && ((Video) tmp).isOlder(year)) {
                oldVideo += tmp.getTitle() + " ";
            }
        }
        System.out.println(oldVideo);
    }

    public String toString() {
        String str = "The items in the collection are:\n";

        for (int i = 0; i < _noItems; i++) {

        
            str += "\t" + collection[i].toString() + "\n";
        }

        return str;
    }
}
