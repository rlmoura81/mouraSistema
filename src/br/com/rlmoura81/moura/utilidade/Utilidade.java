package br.com.rlmoura81.moura.utilidade;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Utilidade {
    
    //###DATA E CALENDARIO###
    //Data Formato
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    
    //Data Formato Campo
    public void formataDataCampo(Object o){
        try{
            MaskFormatter mascData = new MaskFormatter("##/##/####");
            mascData.install((JFormattedTextField) o);
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campo de Datas - " + ex.getMessage(),
                                          "Erro de sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Data Valida Formato Campo
    public boolean validaDataCampo(String campodata){
        if(campodata.equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data em branco.", "Data", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    //Calendario
    public Calendar recebeData(String data){                  
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(Utilidade.formatoData.parse(data));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Verifique ParseException ao receber Data - " + ex.getMessage(),
                                          "Erro de sistema", JOptionPane.ERROR_MESSAGE);
        }
        return cal;
    }

    //Concatenar Data
    public Object concatenaData(Object data){                  
        data = data+"/"+(Calendar.getInstance().get(Calendar.MONTH+2)+"/"+Calendar.getInstance().get(Calendar.YEAR));
        return data;
    }
    
    public Object recebePrimeiroDiaMes(Object data){
        data = (Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH))+
                "/"+(Calendar.getInstance().get(Calendar.MONTH+2)+
                "/"+Calendar.getInstance().get(Calendar.YEAR));
        return data;
    }
    
    public Object recebeUltimoDiaMes(Object data){
        data = (Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH))+
                "/"+(Calendar.getInstance().get(Calendar.MONTH+2)+
                "/"+Calendar.getInstance().get(Calendar.YEAR));
        return data;
    }
    
    //###VALOR MONETARIO E FORMATO DE VALORES###
    //Valor Monetario Formato
    public static DecimalFormat formatoValor = new DecimalFormat("###,###,##0.00");  
    //Valor Monetario Formato com tres casa decimais
    public static DecimalFormat formatoValorTres = new DecimalFormat("###,###,###0.000");  

    //Valor Formato Campo
    public static DefaultFormatterFactory formataValorCampo(Object o){
        DecimalFormat decimal = new DecimalFormat("###,###,##0.00");
        NumberFormatter numFormatado = new NumberFormatter(decimal);
        numFormatado.setFormat(decimal);
        numFormatado.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatado);
        return dfFactory;
    }
        
    //Valor Formato Campo com tres digitos
    public static DefaultFormatterFactory formataValorCampoTres(Object o){
        DecimalFormat decimal = new DecimalFormat("###,###,###0.000");
        NumberFormatter numFormatado = new NumberFormatter(decimal);
        numFormatado.setFormat(decimal);
        numFormatado.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatado);
        return dfFactory;
    }

    //Converte Numero Decimal
    public static BigDecimal converter(String numero){
        Double n;
        BigDecimal numeroReal = null;
        try{
            n = NumberFormat.getInstance().parse(numero).doubleValue();
            numeroReal = new BigDecimal(n);
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "Erro ao converter BigDecimal - " + ex.getMessage(),
                                          "Erro de sistema", JOptionPane.ERROR_MESSAGE);
        }
        return numeroReal;
    }

    //###DOCUMENTO - CPF/CNPJ###
    //Valor Formato Documento CPF/CNPJ
    public void formataDocumento(Object o, int num){
        if (num == 11){
            try {
                MaskFormatter mascDoc = new MaskFormatter("###.###.###-##");
                mascDoc.setPlaceholderCharacter(' ');
                mascDoc.install((JFormattedTextField) o);            
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campos de 'CPF/CNPJ' - " + ex.getMessage(),
                                              "Erro de sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(num == 14){
            try {
                MaskFormatter mascDoc = new MaskFormatter("##.###.###/####-##");
                mascDoc.setPlaceholderCharacter(' ');
                mascDoc.install((JFormattedTextField) o);            
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campos de 'CPF/CNPJ' - " + ex.getMessage(),
                                              "Erro de sistema", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }
    
    //Retorna o documento formatado.
    public static String retornaDocumentoFormatado(Object o, int num){
        String retornaDocumentoFormatado = (String) o;        
        if (num == 11){
            retornaDocumentoFormatado = retornaDocumentoFormatado.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        if(num == 14){
            retornaDocumentoFormatado = retornaDocumentoFormatado.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");         
        }
        return retornaDocumentoFormatado;
    }    
    
    //Documento - retira a mascara 
    public static String retiraMascaraDocumento(String numDoc){
        String numConv = numDoc.replace(".", "").replace("-", "").replace("/", "");
        return numConv;
    }
    
    //Documento Valida Formato Campo
    public boolean validaDocumentoCampo(String campodoc){
        if(campodoc.equals("   .   .   -  ")){
            JOptionPane.showMessageDialog(null, "CPF em branco.");
            return false;
        }
        if(campodoc.equals("  .   .   /    -  ")){
            JOptionPane.showMessageDialog(null, "CNPJ em branco.");
            return false;
        }
        return true;
    }
    
    //###TELEFONE###
    //Telefone Formato
    public void formataTelefone(Object o){
        try {
                MaskFormatter mascDoc = new MaskFormatter("(##)#####-####");
                mascDoc.install((JFormattedTextField) o);            
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campos de 'Telefone' - " + ex.getMessage(),
                                              "Erro de sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    //Telefone Converte - retira a mascara 
    public static String converterTelefone(String numTel){
        String numConv = numTel.replace("(", "").replace(")", "").replace("-", "");
        return numConv;
    }    
}