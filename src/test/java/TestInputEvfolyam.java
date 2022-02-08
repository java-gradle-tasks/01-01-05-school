import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

   public class TestInputEvfolyam {

      @Test
      public void testInput() {
         
         String newLine="";
         if (System.getProperty("os.name").startsWith("Windows")) {
            newLine="\r\n";
         } else {
            newLine="\n";
         }

         InputStream stdin = System.in;

         int evfolyam=9;
         char osztaly='c';

         String input=String.valueOf(evfolyam)+newLine+String.valueOf(osztaly);
         System.setIn(new ByteArrayInputStream(input.getBytes()));

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(byteArrayOutputStream);
         PrintStream stdout = System.out;
         System.setOut(ps);

         MySchool.main(new String[0]);

         System.setIn(stdin);
         System.setOut(stdout);

         String outStream="Osztaly adatok!"+newLine+"Adja meg melyik evfolyamra jar:"+"A "+String.valueOf(evfolyam)+". evfolyam melyik osztalyaba jar:A diak a "+evfolyam+". evfolyam "+osztaly+" osztalyaba jar!"+newLine;
         String expected=outStream;

         String actual=byteArrayOutputStream.toString();

         //String ans=actual.replace(expected,"");

         Assertions.assertEquals(expected,actual,"Hianyzik a masodik input a sorbol vagy a szoveget nem jol adta meg vagy az osszesito sor hibas!)");
      }

  }
