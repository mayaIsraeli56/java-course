public class Girrafe {
    private int _height;
    
    public Girrafe(int height) {
        _height = height;
    }
    
    /* Write your code here */
    
    public int getHeight() {
        return _height;
    }
    
    public int compareTo(Object obj) {
        
        if(obj instanceof Girrafe) {
            
            //int otherHeigth = ((Girrafe)obj).getHeight();
            int otherHeigth = ((Girrafe)obj)._height;
            
            if(_height > otherHeigth)
                return 1;
            else if (_height == otherHeigth)
                return 0;
                
            return -1;
        }
        
        return -999;
    }
    
    public String toString() {
        return "height " + _height;
    }
}
