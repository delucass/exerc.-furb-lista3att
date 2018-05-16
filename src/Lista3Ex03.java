
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.ObjetoDoMundo;

/**
 *
 * @author gdelucas
 */
public class Lista3Ex03 extends Furbot {

    /**
     * método para deslocar objeto ate extremidade
     */
    private int andarobjeto(Direcao extremidade) {
        //variavel para pegar os passos
        int passos = 0;
        //pegar o ObjetoDoMundo para pegar qualquer objeto
        ObjetoDoMundo objeto = getObjeto(AQUIMESMO);
        //enquanto nao chegar extremidade
        while (!objeto.ehFim(extremidade)) {
            //verificar direção do objeto e anda na direção
            switch (extremidade) {
                case DIREITA : objeto.andarDireita(); break;
                case ESQUERDA : objeto.andarEsquerda(); break;
                case ACIMA : objeto.andarAcima(); break;
            }
            //contar os passo
            passos++;
        }
        diga ("Passos do objeto = " + passos);
        //retornar os passos
        return passos;
    }
    

    /**
     * Metodo para verificar o tipo de objeto do mapa
     */
    private int VerificarObjeto() {
        //variavel que recebe dados pelo objeto
        int passos = 0;
        //se é alien
        if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
            passos = andarobjeto(ESQUERDA);
        } else {
            if (ehObjetoDoMundoTipo("Numero", AQUIMESMO)) {
                passos = andarobjeto(DIREITA);
            } else {
                if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {
                    passos = andarobjeto(ACIMA);
                }
            }
        }
        //retornar os passos
        return passos;
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
        //contar total de passos
        int totalpassos = 0;
        //variavel para a direcao do robo
        Direcao direcao = DIREITA;
        //criar looping infinito
        while (true) {
            //ver se tem objeto one robo esta
            if (!ehVazio(AQUIMESMO)) {
                totalpassos += VerificarObjeto();
            }
            //andar com o robo ate o fim da direcao
            andar(direcao);
            if (ehFim(direcao)) {
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
        diga("total de passo dos objetos = " + totalpassos);
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex03.xml");
    }
}
