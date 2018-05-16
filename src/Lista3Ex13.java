
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoFurbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Texto;

/**
 *
 * @author gdelucas
 */
public class Lista3Ex13 extends Furbot {

    /**
     * pega o texto do pais
     */
    private String juntarTexto(String paises) {
        if (ehObjetoDoMundoTipo("Texto", AQUIMESMO)) {
            //pegar do mapa
            Texto texto = getObjeto(AQUIMESMO);
            //ver abreviação pais
            switch (texto.getTexto()) {
                case "AUS":
                    paises += "AUSTRALIA ";
                    break;
                case "BRA":
                    paises += "BRASIL ";
                    break;
                case "FRA":
                    paises += "FRANCA ";
                    break;
                case "VEN":
                    paises += "VENEZUELA ";
                    break;
            }
        }

        return paises;
    }

    /**
     * metodo para pegar nome dos paises
     */
    private String coletarNomePaises() {
        //variavel para juntar os nomes
        String paises = "";
        //enquanto nao chegar fim direita
        while (!ehFim(DIREITA)) {
            //ver se tem um txt
            paises = juntarTexto(paises);
            //passar p proxima casa
            andarDireita();
        }
        diga(paises);
        return paises;
    }

    @Override
    public void inteligencia() throws Exception {
        //ir para ultima linha
        mudarPosicao(0, getQtdeLinhas() - 1);
        //variavel para nome dos paises
        String paises = coletarNomePaises();
        //ir para o topo
        mudarPosicao(0, 0);
        //variavel p controlar a posicao do caracter no texto
        int pos = 0;
        //repetir para quatro linha
        while (getY() != 4) {
            //while nao achar um espaco
            while (paises.charAt(pos) != ' ') {
                //criar objeto
                Texto letra = new Texto();
                //adicionar valor, transformando-o em string
                letra.setValor(String.valueOf(paises.charAt(pos)));
                //colocar no mapa
                adicionarObjetoNoMundo(letra, AQUIMESMO);
                //passar para prox. caracter
                pos++;
                //verificar se nao terminou o mapa para ir p a direita
                if (!ehFim(DIREITA)) {
                    andarDireita();
                }
            }
            //descer
            andarAbaixo();
            //ir para inicio da linha
            mudarPosicao(0, getY());
            //passar para prox.caracter
            pos++;
        }
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex13.xml");
    }
}
