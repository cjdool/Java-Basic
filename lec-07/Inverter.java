import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Inverter {
    public static void main(String[] args) {
        try {
            InputStream fis = new FileInputStream("/Users/jangjuhyeon/IdeaProjects/IoTest/src/input.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            ArrayList<String> arrayList = new ArrayList<>();
            String data;

            while ((data = br.readLine()) != null) {
                arrayList.add(data);
            }

            int filelength = arrayList.size();

            for (int i = 0; i <= filelength / 2 - 1; i++){
                data = arrayList.get(i);
                arrayList.set(i, arrayList.get(filelength - 1 -i));
                arrayList.set(filelength - 1 - i, data);
            }

            br.close();
            isr.close();
            fis.close();

            System.out.print(arrayList);

            OutputStream fos = new FileOutputStream("/Users/jangjuhyeon/IdeaProjects/IoTest/src/output.txt");
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            //arrayList.forEach(name -> System.out.print(name));

            /*for (String data2: arrayList){
                bw.write(data2);
                bw.newLine();
            }*/

            Iterator<String> iterator = arrayList.iterator();

            while (iterator.hasNext()){
                bw.write(iterator.next());
                bw.newLine();
            }

            bw.close();
            osw.close();
            fos.close();
        } catch (IOException e) {
            System.out.printf("Error: %s", e.getMessage());
        }
    }
}
