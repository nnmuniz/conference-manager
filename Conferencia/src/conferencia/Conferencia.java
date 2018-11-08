package conferencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat; 
import java.io.File;

/**
  * @nmuniz
 */

public class Conferencia {
    public static void main(String[] args) {
        String 
                arquivo, 
                linha,
                horas_str = "",
                periodo = "AM",
                minutosConvertidos = "",
                titulo,
                relampago,
                minutos;
        float 
                manha = (float) 09.0,
                hora = 0;
              
        DecimalFormat df = new DecimalFormat("0.##");
        try {
            
            arquivo = new File(".").getCanonicalPath() + "/src/conferencia/conferencia.txt";
            FileReader Arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(Arq);
 
            linha = lerArq.readLine();
            
            System.out.println("Track 1:");
            
            while (linha != null) {
               
              titulo = linha.substring(0, linha.lastIndexOf(" "));
              relampago = linha.substring(linha.lastIndexOf(" ") + 1);
              minutos = linha.replaceAll("\\D+", "");
              
              
              if("lightning".equals(relampago))
                {
                    minutos = "5";
                }
              
              hora = (Float.parseFloat(minutos)/60);                            
            
              minutosConvertidos = df.format((manha - (int) manha) *60);
                          
              if(Integer.parseInt(minutosConvertidos) < 10) { 
                minutosConvertidos = "0" + minutosConvertidos; 
              }
              
              if((int)manha < 10) {
                horas_str = "0" + ((int)manha);
              } else {
                horas_str = "" + ((int)manha);  
              }
              
              if((int)manha >12) {
                horas_str = "0" + ((int)manha - 12); 
              }
                    
              System.out.println(horas_str +":"+ minutosConvertidos + periodo + " " + titulo);  
              
              manha += hora;
                
              if(manha >= 12.0 && manha <= 13.0) {
                  System.out.println("12:00PM Lunch");
                  manha = (float) 13.0;
                  periodo = "PM";
              }
              if(manha >= 17.0) {
                  System.out.println("");
                  System.out.println("Track 2:");
                  manha = (float) 09.0;
                  periodo = "AM";
              }
              linha = lerArq.readLine();
            }
 
            Arq.close();
        } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
        }
        
    }
}


