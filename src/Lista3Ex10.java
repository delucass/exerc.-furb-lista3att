
import br.furb.furbot.Direcao;
import br.furb.furbot.Furbot;
import br.furb.furbot.MundoVisual;
import br.furb.furbot.Numero;

public class Lista3Ex10 extends Furbot {

    public void fazTudo() {
        // variaveis que criam os numeros de 1 a 4
        Numero n1 = new Numero();
        n1.setValor(1);
        Numero n2 = new Numero();
        n2.setValor(2);
        Numero n3 = new Numero();
        n3.setValor(3);
        Numero n4 = new Numero();
        n4.setValor(4);
        //adicionam os numeros
        if (ehObjetoDoMundoTipo("Booleano", AQUIMESMO)) {
            if (ehVazio(ACIMA) && !ehFim(ACIMA)) {
                adicionarObjetoNoMundo(n1, ACIMA);
            } else {
                if (ehVazio(DIREITA) && !ehFim(DIREITA)) {
                    adicionarObjetoNoMundo(n1, DIREITA);
                } else {
                    if (ehVazio(ABAIXO) && !ehFim(ABAIXO)) {
                        adicionarObjetoNoMundo(n1, ABAIXO);
                    } else {
                        if (ehVazio(ESQUERDA) && !ehFim(ESQUERDA)) {
                            adicionarObjetoNoMundo(n1, ESQUERDA);
                        }
                    }
                }
            }
            if (ehVazio(DIREITA) && !ehFim(DIREITA)) {
                adicionarObjetoNoMundo(n2, DIREITA);
            } else {
                if (ehVazio(ABAIXO) && !ehFim(ABAIXO)) {
                    adicionarObjetoNoMundo(n2, ABAIXO);
                } else {
                    if (ehVazio(ESQUERDA) && !ehFim(ESQUERDA)) {
                        adicionarObjetoNoMundo(n2, ESQUERDA);
                    }
                }
            }
            if (ehVazio(ABAIXO) && !ehFim(ABAIXO)) {
                adicionarObjetoNoMundo(n3, ABAIXO);
            } else {
                if (ehVazio(ESQUERDA) && !ehFim(ESQUERDA)) {
                    adicionarObjetoNoMundo(n3, ESQUERDA);
                }
            }
            if (ehVazio(ESQUERDA) && !ehFim(ESQUERDA)) {
                adicionarObjetoNoMundo(n4, ESQUERDA);
            }
        }
    }

    @Override
    public void inteligencia() throws Exception {
        //faz o robô voltar a posição inicial
        while (!ehFim(ESQUERDA)) {
            andarEsquerda();
        }
        while (!ehFim(ACIMA)) {
            andarAcima();
        }
        //aplica a sub rotina para aplicar o numeros
        fazTudo();
        Direcao direcao = DIREITA;
        //faz o robor andar
        while (true) {
            andar(direcao);
            fazTudo();
            if (ehFim(direcao)) {
                if (!ehFim(ABAIXO)) {
                    andarAbaixo();
                    fazTudo();
                    direcao = mudarDirecao(direcao);
                } else {
                    break;
                }

            }
        }
        diga("Fim do mundo");
    }
    //subrotinas que fazem o robô andar
    private void andar(Direcao direcao) {
        if (!ehFim(direcao)) {
            if (direcao == DIREITA) {
                andarDireita();
            } else {
                andarEsquerda();
            }
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
        MundoVisual.iniciar("Lista3Ex10.xml");
    }
}
