   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.ByteArrayInputStream;
   import java.io.ByteArrayOutputStream;
   import java.io.InputStream;
   import java.io.PrintStream;

   public class TestInputOsztaly {

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

         String outStream="Osztaly adatok!"+newLine+"Adja meg melyik evfolyamra jar:";
         String expected=outStream;

         String actual=byteArrayOutputStream.toString();

         boolean found=actual.contains(expected);

         Assertions.assertTrue(found,"Hianyzik az elso input a kodbol vagy a szoveg nem megfelelo!");
      }
   }
