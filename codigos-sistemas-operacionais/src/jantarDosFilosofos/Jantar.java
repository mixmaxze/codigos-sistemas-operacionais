package jantarDosFilosofos;


public class Jantar {

	public static void main(String[] args) throws Exception {

		Filosofo[] filosofos = new Filosofo[5];
		Object[] garfos = new Object[5];

		for (int i = 0; i < 5; i++) {
			garfos[i] = new Object();
		}

		for (int i = 0; i < 5; i++) {
			Object garfoEsquerdo = garfos[i];
			Object garfoDireito = garfos[(i + 1) % 5];

			// essas condições evitam um deadlock
			if (i == filosofos.length - 1) {
				filosofos[i] = new Filosofo(garfoDireito, garfoEsquerdo);

			} else {
				filosofos[i] = new Filosofo(garfoEsquerdo, garfoDireito);
			}

			Thread t = new Thread(filosofos[i], "Filósofo " + (i + 1));
			t.start();

		}

	}

}
