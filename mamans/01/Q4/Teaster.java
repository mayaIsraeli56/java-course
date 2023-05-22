public class Teaster {
    public static void main(String[] args) {
        
        C c = new C();
        c.f();
        c.f1(2);


    }
}

/* 
 * 
 * 1. V
 * 2. X יש גישה גם אם ציבורי
 * 3. X רק הראשונה נכונה
 * 4. X מחלקה יורשת ממחלקה אחרת גם את התכנות שהורשו לה
 * 5. X אין פקודה super.super
 * 6. X private 
 *  
 */