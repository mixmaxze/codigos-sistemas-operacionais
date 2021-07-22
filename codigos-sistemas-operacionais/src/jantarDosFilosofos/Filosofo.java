package jantarDosFilosofos;

public class Filosofo implements Runnable {

	private Object garfoEsquerdo;
	private Object garfoDireito;

	public Filosofo(Object garfoEsquerdo, Object garfoDireito) {
		this.garfoEsquerdo = garfoEsquerdo;
		this.garfoDireito = garfoDireito;
	}

	private void realizaAcao(String acao) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + acao);
		Thread.sleep(((int) Math.random() * 1000));
	}

	// Utiliza monitores (notação synchronized)
	@Override
	public void run() {
		try {
			while (true) {
				realizaAcao(": PENSANDO.");

				synchronized (garfoEsquerdo) {
					realizaAcao(": Pegou o garfo esquerdo.");

					synchronized (garfoDireito) {
						realizaAcao(": Pegou o garfo direito. COMENDO.");
						realizaAcao(": Colocou o garfo direito de volta.");
					}

					realizaAcao(": Colocou o garfo esquerdo de volta. Voltou a pensar.");

				}
			}

		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return;
		}
	}

}
