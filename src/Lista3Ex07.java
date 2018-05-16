
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

/**
 *
 * @author gdelucas
 */
public class Lista3Ex07 extends Furbot {

    //atributo que armazena resultado das operações
    private int resultado = 0;

    /*
    * método para alterar o resultado dependendo do numero
     */
    private void verificarNumero() {
        //se é numero
        if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
            //pegar num
            Numero numero = getObjeto(AQUIMESMO);
            //escolha o numero
            switch (numero.getValor()) {
                case 1:
                    resultado += 10;
                    break;
                case 2:
                    resultado -= 2;
                    break;
                case 3:
                    resultado *= 2;
                    break;
                case 4:
                    //verificar se o resultado é par ou impar
                    if (resultado % 2 != 0) {
                        resultado += 2;
                    } else {
                        resultado -= 5;
                    }
            }
        }
    }

    /* Método para mudar a direção */
    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == DIREITA) {
            direcao = ESQUERDA;
        } else {
            direcao = DIREITA;
        }
        return direcao;
    }

    @Override
    public void inteligencia() throws Exception {
        while (!ehFim(DIREITA)) {
            andarDireita();
            verificarNumero();
        }
        diga ("O resultado dessa merda é " + resultado);
        resultado = 0;
        andarAbaixo();
        verificarNumero();
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
            verificarNumero();
        }
        diga ("O resultado dessa merda é " + resultado);
        resultado = 0;
        andarAbaixo();
        verificarNumero();
        while (!ehFim(DIREITA)) {
            andarDireita();
            verificarNumero();
        }
        diga ("O resultado dessa merda é " + resultado);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex07.xml");
    }
}
