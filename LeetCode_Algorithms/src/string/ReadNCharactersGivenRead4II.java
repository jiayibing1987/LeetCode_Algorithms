package string;

public class ReadNCharactersGivenRead4II {

    int p = 4;
    char[] arr = new char[4];
    int len = 0;
    public int read(char[] buf, int n) {
        int i = 0;
        while(n > 0) {
            while(p < len) {
                if(n == 0)
                    return i;
                buf[i++] = arr[p++];
                n--;
            }
            //reset pointer and array
            p = 0;
            len = read4(arr);
            if(len == 0) break;
        }
        return i;
    }


     //The read4 API is defined in the parent class Reader4.
     public  int read4(char[] buf4) {return 0;}

}
