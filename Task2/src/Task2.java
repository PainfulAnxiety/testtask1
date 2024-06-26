import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args){
        int circle_x, circle_y, r, dot_x, dot_y;
        double length;
        String[] line;
        String str1;
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/file1.txt"));
                line = br.readLine().split(" ");
                circle_x= Integer.valueOf(line[0]);
                circle_y= Integer.valueOf(line[1]);
                r = Integer.valueOf(br.readLine().trim());
                br.close();
            BufferedReader br2 = new BufferedReader(new FileReader("src/file2.txt"));
            while ((str1 = br2.readLine())!=null) {
                line = str1.split(" ");
                dot_x=Integer.valueOf(line[0]);
                dot_y=Integer.valueOf(line[1]);
                length = Math.sqrt(Math.pow(dot_x-circle_x,2) + Math.pow(dot_y-circle_y,2));
                if (length > r) {
                    System.out.println(2);
                } else if (length == r) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            }
            br2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
}
