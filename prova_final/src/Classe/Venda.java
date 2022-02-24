package Classe;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.TimeZone;

public class Venda {
    private String dtVenda;
    private Produto pdtVend;
    private int qtddVend;

    //-------------------------------

    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        TimeZone tz = calendar.getTimeZone();
        ZoneId zid = tz == null ? ZoneId.systemDefault() : tz.toZoneId();
        return LocalDateTime.ofInstant(calendar.toInstant(), zid);
    }

    //-----------------------------------------------

    public String getDtVenda() {
        return dtVenda;
    }
    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }
    public Produto getPdtVend() {
        return pdtVend;
    }
    public void setPdtVend(Produto pdtVend) {
        this.pdtVend = pdtVend;
    }
    public int getQtddVend() {
        return qtddVend;
    }
    public void setQtddVend(int qtddVend) {
        this.qtddVend = qtddVend;
    }

    

    //construtor

    public Venda(int comp, Produto produto, int dtVenda2) {
    }
    public Venda(int itens, Produto produto) {
    }
}
    
    //----------------------------------------------------

   
