package FileBuffered;

import java.io.*;

public class AtivFileBuffered {
    public static void main(String[] args) {

        String path = "C:\\Users\\Gustavo\\Documents\\AtividadesGustavoJava\\JavaTarde_CTTI\\src\\main\\java\\src";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();

            String[] name = new String[4];
            Double[] price = new Double[4];
            Integer[] quantity = new Integer[4];
            Double[] total = new Double[4];
            String[] lines = new String[4];

            int i = 0;
            while (line != null) {
                String[] attributes = line.split(",");
                name[i] = attributes[0];
                price[i] = Double.parseDouble(attributes[1]);
                quantity[i] = Integer.parseInt(attributes[2]);
                total[i] = price[i] * quantity[i];

                lines[i] = name[i] + ", " + String.format("%.2f", total[i]);

                i++;
                line = br.readLine();
            }

            path = "C:\\Users\\Gustavo\\Documents\\AtividadesGustavoJava\\out\\summary.csv";

            File file = new File(path);
            file.getParentFile().mkdirs();

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

                for (String line1 : lines) {
                    bw.write(line1);
                    bw.newLine();
                }

            }catch(IOException e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}