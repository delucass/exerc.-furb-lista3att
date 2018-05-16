
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;
import br.furb.furbot.ObjetoDoMundo;

public class Lista3Ex11 extends Furbot {

    private void andarAlien(int num) {
        if (ehObjetoDoMundoTipo("Alien", AQUIMESMO)) {
            ObjetoDoMundo objeto = getObjeto(AQUIMESMO);
            switch (num) {
                case 1:
                    while (!objeto.ehFim(ACIMA)) {
                        objeto.andarAcima();
                    }
                    break;

                case 2:
                    while (!objeto.ehFim(ABAIXO)) {
                        objeto.andarAbaixo();
                    }
                    break;
                case 3:
                    while (!objeto.ehFim(DIREITA)) {
                        objeto.andarDireita();
                    }
                    break;
                case 4:
                    while (!objeto.ehFim(ESQUERDA)) {
                        objeto.andarEsquerda();
                    }
                    break;
            }

        }

    }

    @Override
    public void inteligencia() throws Exception {
        Direcao direcao = DIREITA;
        andarDireita();
        Numero numero = getObjeto(AQUIMESMO);
        int n = numero.getValor();

        while (true) {
            andar(direcao);
            andarAlien(n);
            if (ehFim(direcao)) {
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                    andarAlien(n);
                    direcao = mudarDirecao(direcao);
                } else {
                    break;
                }
            }
        }
        diga("Fim dessa caralha");
    }

    private void andar(Direcao direcao) {
        if (direcao == DIREITA) {
            andarDireita();
        } else {
            andarEsquerda();
        }
    }

    private Direcao mudarDirecao(Direcao direcao) {
        if (direcao == DIREITA) {
            direcao = ESQUERDA;
        } else {
            direcao = DIREITA;
        }
        return direcao;
    }

    public static void main(String[] args) {
        MundoVisual.iniciar("Lista3Ex11.xml");
    }
}
