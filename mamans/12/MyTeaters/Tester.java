public class Tester {

        /**
         * @param args
         */
        public static void main(String[] args) {

                //////////////////////// City /////////////////////////////

                City c1 = new City("Eilat", 31, 7, 19999, 6, 7, 7, 8, 600, 10);
                City c2 = new City("Gedera", 8, 9, 1984, 20, 40, 50, 60, 300, 50);
                City c3 = new City(c1);

                System.out.println("c1: " + "city=" + c1.getCityName()
                + " dateEst=" + c1.getDateEstablished()
                + " CityCenter=" + c1.getCityCenter()
                + " CentralStation=" + c1.getCentralStation()
                + " getNumOfResidents=" + c1.getNumOfResidents()
                + " getNumOfNeighborhoods=" + c1.getNumOfNeighborhoods());
                c2.setCityName("a");
                c2.setDateEstablished(c1.getDateEstablished());
                c2.setCityCenter(c1.getCityCenter());
                c2.setCentralStation(c1.getCentralStation());
                c2.setNumOfResidents(-10);

                c2.setNumOfNeighborhoods(-10);

                c2.setDateEstablished(new Date(10, 10, 2222));
                c2.setCityCenter(new Point(100, 100));
                c2.setCentralStation(new Point(100, 100));

                System.out.println("\n" + c1);
                System.out.println("\n" + c2);

                System.out.println("\nc1.equals(c2): " + c1.equals(c2));
                c2 = new City(c1);
                System.out.println("c1.equals(c2): " + c1.equals(c2));
                c2.setNumOfResidents(70);
                System.out.println("c1.equals(c2): " + c1.equals(c2));

                System.out.println("c2.addRsdnt: " + c2.getNumOfResidents() + " -> " +
                c2.addResidents(-75) + " "
                + c2.getNumOfResidents());

                System.out.print("c1 moveCentralStation: " + c1.getCentralStation());

                c1.moveCentralStation(-1, 9);
                System.out.print(" -> " + c1.getCentralStation());
                c1.getCentralStation().move(10, 10);
                c1.moveCentralStation(-1, 9);

                c1.setCentralStation(new Point(0, 6));
                System.out.print("\n c1 distanceBetweenCenterAndStation: " +
                c1.distanceBetweenCenterAndStation());

                City c4 = c1.newCity("c4", -7, 2);
                System.out.print("\n c1.newCity = c4: " + c4);

                c2 = new City("c2", 31, 12, 2021, 2, 3, 4, 5, 30, 50);

                System.out.println("c1 EstablishedBtwn "
                + c1.cityEstablishedBetweenDates(new Date(1, 1, 2000), new Date(1, 1,
                1990)));

                System.out.println("c1 c2 establishmentDateDiff " +
                c1.establishmentDateDiff(c2));
                System.out.println("c1 c3 establishmentDateDiff " +
                c1.establishmentDateDiff(c3));

                //////////////////////// Date /////////////////////////////

                Date d1 = new Date(1, 1, 2222);
                Date d2 = new Date(3, 2, 9329);
                Date d3 = new Date(d2);

                System.out.println("d1 = " + d1);
                System.out.println("d2 = " + d2);
                System.out.println("d3 = " + d3);

                System.out.println("\nd1 day = " + d1.getDay());
                System.out.println("d2 month = " + d2.getMonth());
                System.out.println("d3 year = " + d3.getYear());

                d1.setDay(3);
                d1.setDay(30);
                d1.setDay(0);

                d1.setMonth(4);
                d1.setMonth(2);
                d1.setMonth(3);

                d1.setYear(4);
                d1.setYear(1000);
                d1.setYear(2223);

                System.out.println("\n" + d2 + " equals " + d1 + " : " + d2.equals(d1));
                System.out.println("\n" + d2 + " equals " + d3 + " : " + d2.equals(d3));
                System.out.println(d3 + " before " + d1 + " : " + d3.before(d1));
                System.out.println(d2 + " before " + d1 + " : " + d2.before(d1));
                System.out.println(d3 + " after " + d1 + " : " + d3.after(d1));
                System.out.println(d2 + " after " + d1 + " : " + d2.after(d1));
                System.out.println(d1 + " after " + d2 + " : " + d1.after(d2));

                System.out.println("\n" + d3 + " difference " + d1 + " : " +
                d3.difference(d1));
                System.out.println(d2 + " difference " + d1 + " : " + d2.difference(d1));

                d2.setMonth(11);
                d2.setDay(31);
                d2.setYear(2019);

                System.out.println(d2 + " tomorrow: " + d2.tomorrow());

                //////////////////////// POINT /////////////////////////////
                Point q1 = new Point(6, -100);
                Point q2 = new Point(-1, 2);
                Point q3 = new Point(q1);
                Point q4 = new Point(q2);
                System.out.println(q4);

                q1.setY(3);
                q2.setY(-3);
                q3.setY(0);

                System.out.println("q1 x = " + q1.getX());
                System.out.println("q2 x = " + q2.getX());
                System.out.println("q3 x = " + q3.getX());

                System.out.println("\nq1 y = " + q1.getY());
                System.out.println("q2 y = " + q2.getY());
                System.out.println("q3 y = " + q3.getY());

                q3.setX(q1.getX());
                q3.setY(q1.getY());

                System.out.println("\nq1: " + q1 + " / " + "q2: " + q2 + " / " + "q3: " +
                                q3);

                System.out.println("\nq1.equals(q2): " + q1.equals(q2));
                System.out.println("q1.equals(q3): " + q1.equals(q3));

                System.out.println("\nq1.isAbove(q3): " + q1.isAbove(q3));
                System.out.println("q1.isAbove(q2): " + q1.isAbove(q2));

                System.out.println("\nq1.isUnder(q3): " + q1.isUnder(q3));
                System.out.println("q1.isUnder(q2): " + q1.isUnder(q2));
                System.out.println("q2.isUnder(q1): " + q2.isUnder(q1));

                System.out.println("\nq1.isLeft(q3): " + q1.isLeft(q3));
                System.out.println("q1.isLeft(q2): " + q1.isLeft(q2));
                System.out.println("q2.isLeft(q1): " + q2.isLeft(q1));

                System.out.println("\nq1.isRight(q3): " + q1.isRight(q3));
                System.out.println("q1.isRight(q2): " + q1.isRight(q2));
                System.out.println("q2.isRight(q1): " + q2.isRight(q1));

                q1.move(-5, 1);
                System.out.println("\nq1.move(-5,1): " + q1);
                q1.move(1, -5);
                System.out.println("q1.move(1,-5): " + q1);
                q1.move(1, 1);
                System.out.println("q1.move(1,1): " + q1);
                q2.move(-10, 1);
                System.out.println("q2.move(-10,1): " + q2);

                Point q5 = q1.middle(q3);
                System.out.println("q5 " + q5);

                System.out.println("\ndistance " + q1 + q2 + " : " + q1.distance(q2));
                System.out.println("distance " + q3 + q4 + " : " + q3.distance(q4));

                System.out.println("\n****************************END***************************");

        }
}
