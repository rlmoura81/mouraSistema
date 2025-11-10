package br.com.rlmoura81.moura.utilidade;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

public class Utilidade {
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *POSICIONA O CURSOR OU SELECIONA O CAMPO TODO DA JFTFFIELD NO ON FOCUS
    */
    
    public JFormattedTextField posicionaCursojFTFData(JFormattedTextField o){
        o.selectAll();
        //o.setCaretPosition(0);
        return o;
    }
    
    /**
     * <p><strong>EN:</strong> Default date format used in the system (dd/MM/yyyy).</p>
     * <p><strong>IT:</strong> Formato di data predefinito usato nel sistema (dd/MM/yyyy).</p>
     * <p><strong>PT-BR:</strong> Formato de data padrão usado no sistema (dd/MM/yyyy).</p>
     */
    public static SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    
    /**
     * <p><strong>EN:</strong> Applies a date mask (dd/MM/yyyy) to a formatted text field.</p>
     * <p><strong>IT:</strong> Applica una maschera data (dd/MM/yyyy) a un campo di testo formattato.</p>
     * <p><strong>PT-BR:</strong> Aplica uma máscara de data (dd/MM/yyyy) a um campo de texto formatado.</p>
     */
    public void formataDataCampo(Object o){
        try{
            MaskFormatter mascData = new MaskFormatter("##/##/####");
            mascData.install((JFormattedTextField) o);
        }catch(ParseException ex){
            JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campo de Datas - " + ex.getMessage(),
                                          "Erro de sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * <p><strong>EN:</strong> Validates if the date field is filled. Returns false if empty.</p>
     * <p><strong>IT:</strong> Verifica se il campo data è compilato. Restituisce false se vuoto.</p>
     * <p><strong>PT-BR:</strong> Valida se o campo de data está preenchido. Retorna falso se vazio.</p>
     */
    public boolean validaDataCampo(String campodata){
        if(campodata.equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "Data em branco.", "Data", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * <p><strong>EN:</strong> Converts a string in dd/MM/yyyy format to a Calendar object.</p>
     * <p><strong>IT:</strong> Converte una stringa in formato dd/MM/yyyy in un oggetto Calendar.</p>
     * <p><strong>PT-BR:</strong> Converte uma string no formato dd/MM/yyyy para um objeto Calendar.</p>
     */
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

    /**
     * <p><strong>EN:</strong> Concatenates a given day with the current month and year.</p>
     * <p><strong>IT:</strong> Concatena un giorno specificato con il mese e l’anno corrente.</p>
     * <p><strong>PT-BR:</strong> Concatena um dia informado com o mês e ano atuais.</p>
     */
    public Object concatenaData(Object data){                  
        data = data+"/"+(Calendar.getInstance().get(Calendar.MONTH+2)+"/"+Calendar.getInstance().get(Calendar.YEAR));
        return data;
    }
    
    /**
     * <p><strong>EN:</strong> Returns the first day of the current month as a string.</p>
     * <p><strong>IT:</strong> Restituisce il primo giorno del mese corrente come stringa.</p>
     * <p><strong>PT-BR:</strong> Retorna o primeiro dia do mês atual em formato string.</p>
     */
    public Object recebePrimeiroDiaMes(Object data){
        data = (Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH))+
                "/"+(Calendar.getInstance().get(Calendar.MONTH+2)+
                "/"+Calendar.getInstance().get(Calendar.YEAR));
        return data;
    }
    
    /**
     * <p><strong>EN:</strong> Returns the last day of the current month as a string.</p>
     * <p><strong>IT:</strong> Restituisce l’ultimo giorno del mese corrente come stringa.</p>
     * <p><strong>PT-BR:</strong> Retorna o último dia do mês atual em formato string.</p>
     */
    public Object recebeUltimoDiaMes(Object data){
        data = (Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH))+
                "/"+(Calendar.getInstance().get(Calendar.MONTH+2)+
                "/"+Calendar.getInstance().get(Calendar.YEAR));
        return data;
    }
    
    /**
     * <p><strong>EN:</strong> Default currency format with two decimal places.</p>
     * <p><strong>IT:</strong> Formato monetario predefinito con due cifre decimali.</p>
     * <p><strong>PT-BR:</strong> Formato monetário padrão com duas casas decimais.</p>
     */
    public static DecimalFormat formatoValor = new DecimalFormat("###,###,##0.00");  

    /**
     * <p><strong>EN:</strong> Currency format with three decimal places.</p>
     * <p><strong>IT:</strong> Formato monetario con tre cifre decimali.</p>
     * <p><strong>PT-BR:</strong> Formato monetário com três casas decimais.</p>
     */
    public static DecimalFormat formatoValorTres = new DecimalFormat("###,###,###0.000");  

    /**
     * <p><strong>EN:</strong> Creates a formatter for numeric fields with two decimal places.</p>
     * <p><strong>IT:</strong> Crea un formattatore per campi numerici con due cifre decimali.</p>
     * <p><strong>PT-BR:</strong> Cria um formatador para campos numéricos com duas casas decimais.</p>
     */
    public static DefaultFormatterFactory formataValorCampo(Object o){
        DecimalFormat decimal = new DecimalFormat("###,###,##0.00");
        NumberFormatter numFormatado = new NumberFormatter(decimal);
        numFormatado.setFormat(decimal);
        numFormatado.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatado);
        return dfFactory;
    }
        
    /**
     * <p><strong>EN:</strong> Creates a formatter for numeric fields with three decimal places.</p>
     * <p><strong>IT:</strong> Crea un formattatore per campi numerici con tre cifre decimali.</p>
     * <p><strong>PT-BR:</strong> Cria um formatador para campos numéricos com três casas decimais.</p>
     */
    public static DefaultFormatterFactory formataValorCampoTres(Object o){
        DecimalFormat decimal = new DecimalFormat("###,###,###0.000");
        NumberFormatter numFormatado = new NumberFormatter(decimal);
        numFormatado.setFormat(decimal);
        numFormatado.setAllowsInvalid(false);
        DefaultFormatterFactory dfFactory = new DefaultFormatterFactory(numFormatado);
        return dfFactory;
    }

    /**
     * <p><strong>EN:</strong> Converts a numeric string into a BigDecimal value.</p>
     * <p><strong>IT:</strong> Converte una stringa numerica in un valore BigDecimal.</p>
     * <p><strong>PT-BR:</strong> Converte uma string numérica em um valor BigDecimal.</p>
     */
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

    /**
     * <p><strong>EN:</strong> Applies a mask formatter for CPF (11 digits) or CNPJ (14 digits).</p>
     * <p><strong>IT:</strong> Applica un formattatore di maschere per CPF (11 cifre) o CNPJ (14 cifre).</p>
     * <p><strong>PT-BR:</strong> Aplica máscara de formatação para CPF (11 dígitos) ou CNPJ (14 dígitos).</p>
     */
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
    
    /*
    *EM TESTE - COLOCAR COMENTARIO
    *VALIDACAO DE CPF/CNPJ
    */    
    public boolean validaDocumento(String documento){
        if(documento.length() == 11){
            try {
                int soma = 0;
                for (int i = 0; i < 9; i++) {
                    soma += (documento.charAt(i) - '0') * (10 - i);
                }
                int digito1 = 11 - (soma % 11);
                digito1 = (digito1 > 9) ? 0 : digito1;

                soma = 0;
                for (int i = 0; i < 10; i++) {
                    soma += (documento.charAt(i) - '0') * (11 - i);
                }
                int digito2 = 11 - (soma % 11);
                digito2 = (digito2 > 9) ? 0 : digito2;

                return (documento.charAt(9) - '0') == digito1 && (documento.charAt(10) - '0') == digito2;
            }catch(Exception ex){
                return false;
            }
        }
        if(documento.length() == 14){
            try {
                int[] peso1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
                int[] peso2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

                int soma = 0;
                for (int i = 0; i < 12; i++) {
                    soma += (documento.charAt(i) - '0') * peso1[i];
                }
                int digito1 = soma % 11;
                digito1 = (digito1 < 2) ? 0 : 11 - digito1;

                soma = 0;
                for (int i = 0; i < 13; i++) {
                    soma += (documento.charAt(i) - '0') * peso2[i];
                }
                int digito2 = soma % 11;
                digito2 = (digito2 < 2) ? 0 : 11 - digito2;

                return (documento.charAt(12) - '0') == digito1 && (documento.charAt(13) - '0') == digito2;
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    } 
    
    /**
     * <p><strong>EN:</strong> Returns the CPF or CNPJ formatted as a string with punctuation.</p>
     * <p><strong>IT:</strong> Restituisce il CPF o CNPJ formattato come stringa con punteggiatura.</p>
     * <p><strong>PT-BR:</strong> Retorna o CPF ou CNPJ formatado como string com pontuação.</p>
     */
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
    
    /**
     * <p><strong>EN:</strong> Removes CPF or CNPJ mask (punctuation) and returns raw digits.</p>
     * <p><strong>IT:</strong> Rimuove la maschera del CPF o CNPJ (punteggiatura) e restituisce solo le cifre.</p>
     * <p><strong>PT-BR:</strong> Remove a máscara de CPF ou CNPJ (pontuação) e retorna apenas os dígitos.</p>
     */
    public static String retiraMascaraDocumento(String documento){
        //String documento = numDoc.replace(".", "").replace("-", "").replace("/", "");
        //documento = documento.replaceAll("\\D", "");
        return documento.replaceAll("\\D", "");
    }
    
    /**
     * <p><strong>EN:</strong> Validates if CPF or CNPJ field is not empty.</p>
     * <p><strong>IT:</strong> Verifica se i campi CPF o CNPJ non sono vuoti.</p>
     * <p><strong>PT-BR:</strong> Valida se os campos de CPF ou CNPJ não estão em branco.</p>
     */
    public boolean validaCampoDocumento(String campodoc){
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
    
    /**
     * <p><strong>EN:</strong> Applies a phone mask (format: (##)#####-####) to a text field.</p>
     * <p><strong>IT:</strong> Applica una maschera telefonica (formato: (##)#####-####) a un campo di testo.</p>
     * <p><strong>PT-BR:</strong> Aplica máscara de telefone (formato: (##)#####-####) em um campo de texto.</p>
     */
    public void formataTelefone(Object o){
        try {
                MaskFormatter mascDoc = new MaskFormatter("(##)#####-####");
                mascDoc.install((JFormattedTextField) o);            
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Verifique ParseException ao formatar campos de 'Telefone' - " + ex.getMessage(),
                                              "Erro de sistema", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    /**
     * <p><strong>EN:</strong> Removes the mask from a phone number string and returns only digits.</p>
     * <p><strong>IT:</strong> Rimuove la maschera da una stringa di numero di telefono e restituisce solo le cifre.</p>
     * <p><strong>PT-BR:</strong> Remove a máscara de um número de telefone e retorna apenas os dígitos.</p>
     */
    public static String converterTelefone(String numTel){
        String numConv = numTel.replace("(", "").replace(")", "").replace("-", "");
        return numConv;
    }    
}