public class Acounts {

    public static void main(String[] args) {
        Acount acount1 = new Acount("Maya", "Tpahot", 05345345, 435324.5);
        System.out.println("acount1: " + acount1);

        Acount acount2 = new Acount(acount1);
        System.out.println("acount2: " + acount2);

        // System.out.println("acount2: " + acount2.deposit(90.99));
        // System.out.println("acount2: " + acount2.deposit(10, 2));

        Acount acount3 = new Acount("M", "T", 045, 435);

        System.out.println("acount1.equals(acount2): " + acount1.equals(acount2));
        System.out.println("acount1==acount2: " + (acount1 == acount2));

        System.out.println("acount1.equals(acount3): " + acount1.equals(acount3));
        System.out.println("acount1==acount3: " + (acount1 == acount3));
    }

    public static class Acount {
        // constants declaration:
        int ID_DEF = 12345;

        // attributes declarations:
        private String _owner;
        private String _bank;
        private long _id;
        private double _balance;

        // constructors
        public Acount(String owner, String bank, long id, double balance) {
            _owner = owner;
            _bank = bank;

            if (String.valueOf(id).length() != 5) {
                id = ID_DEF;
            }

            _id = id;
            _balance = balance;
        }

        public Acount(Acount other) {
            _owner = other._owner;
            _bank = other._bank;
            _id = other._id;
            _balance = other._balance;
        }

        // methods
        public String toString() {
            // build and return the String of the object
            return _owner + ", " + _bank + ", " + _id + ", " + _balance;
        }

        public double deposit(double sum) {
            if (sum >= 0)
                _balance += sum;
            return _balance;
        }

        public double deposit(double sum, double fee) {
            if (sum - fee > 0)
                _balance += sum - fee;
            return _balance;
        }

        // getters
        public String getOwner() {
            return _owner;
        }

        public String getBank() {
            return _bank;
        }

        public long getId() {
            return _id;
        }

        public double getBalance() {
            return _balance;
        }

        // setters
        public void setId(long id) {
            if (!(10000 <= id && id < 100000)) {
                id = ID_DEF;
            }
            _id = id;
        }

        public void setOwner(String owner) {
            _owner = owner;
        }

        public void setBank(String bank) {
            _bank = bank;
        }

        public void setBalance(double balance) {
            _balance = balance;
        }

        public boolean equals(Acount other) {
            return _owner.equals(other._owner) && _bank.equals(other._bank) &&
                    _id == other._id && _balance == other._balance;
        }
    }
}
