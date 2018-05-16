
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import static br.furb.furbot.ObjetoDoMundoAdapter.ABAIXO;
import static br.furb.furbot.ObjetoDoMundoAdapter.DIREITA;
import static br.furb.furbot.ObjetoDoMundoAdapter.ESQUERDA;

/**
 *
 * @author gdelucas
 */
public class Lista3Ex01 extends Furbot {
    /*metodo para somar numero do mapa com parametro
        */
    private int somar (int acumulador){
        //pegar o numero no mapa
        Numero numero = getObjeto(AQUIMESMO);
        //somar numero com acumulador
        acumulador += numero.getValor();
        //retornar a soma
        return acumulador;
    }
//metodo para o robo andar em uma direção
    private void andar(Direcao direcao) {
        //se nao é fim da direçao
        if (!ehFim(direcao)) {
            //testar a direcao
            if (direcao == DIREITA) {
                andarDireita();
            } else {
                andarEsquerda();
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
        //variavel para somar linha
        int soma = 0;
        //variavel para a direcao do robo
        Direcao direcao = DIREITA;
        //criar looping infinito
        while (true) {
            //ver se tem numero
            if(ehObjetoDoMundoTipo("Numero", AQUIMESMO)){
                soma= somar (soma);
            }
            //andar com o robo ate o fim da direcao
            andar(direcao);
            //verifica se e fim da direção
            if (ehFim(direcao)) {
                //mostrar soma da linha
                diga ("Soma da linha = " + soma);
                //zerar soma
                soma =0;
                if (!ehFim(ABAIXO)) {
                    //desce para a proxima linha
                    andarAbaixo();
                    //muda a direção
                    direcao = mudarDirecao(direcao);
                } else {
                    break;
                }
            }
        }
        diga("Cheguei ao fim do mapa!");
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex01.xml");
    }
}
