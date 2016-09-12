/**
 * @author roberson
 *
 */
 
import java.math.BigInteger;

public class Cipher {
	private String cipheredWord = "";
	private String word;
	private Integer publicKey;
	private Integer privateKey;

	private static String dic(String a) {
		String b = "";
		for (int i = 0; i < a.length(); i++) {
			char c = a.charAt(i);
			b = b + (int) c + " ";
		}
		//System.out.println(b);
		return b;
	}

	/**************************
	 * Retornar o número N O número N é o tamanho do conjunto
	 * */
	private static Integer numeroN(Integer primo1, Integer primo2) {
		Integer conjunto;

		conjunto = primo1 * primo2;
		return conjunto;
	}

	/*************************
	 * Função Totiene de Euler Calcular o Coprimo anterior esta função diz a
	 * quantidade de co-primos de um numero que são menores que ele mesmo.
	 * */
	private static Integer totieneDeEuler(Integer primo1, Integer primo2) {
		// fi(x) = (p-1) * (q-1)
		Integer fi;
		fi = (primo1 - 1) * (primo2 - 1);

		return fi;
	}

	/***********************************
	 * Calcular a chave pública Devemos escolher um número e em que 1 < e <
	 * φ(n), de forma que e seja co-primo de φ(n). Em outras palavras, queremos
	 * um e onde o MDC(φ(n), e) = 1, sendo e > 1.
	 *
	 * @param e
	 *            recebe valor maior que 1
	 * */
	private static Integer calcularPK(Integer num) {
		int count = 0;
		for (int a = 1; a < num; a++) { // definition of totient: the amount of
										// numbers less than num coprime to it
			if (GDC(num, a) == 1) { // coprime
				count++;
			}
		}
		//return 13;
		return count;
	}

	/*******************
	 * Calcular o GDC
	 * */
	private static Integer GDC(int a, int b) {
		int temp;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		if (a % b == 0)
			return b;
		return GDC(a % b, b);
	}

	@SuppressWarnings("unused")
	private static Integer MDC(int a, int b) {
		int resto;

		while (b != 0) {
			resto = a % b;
			a = b;
			b = resto;
		}
		return a;
	}

	public void DoCipher() {
		String msg = dic(word);
		String arr[] = msg.split(" ");

		Integer fi = totieneDeEuler(publicKey, privateKey);
		Long tamConjunto = Long.valueOf(numeroN(publicKey, privateKey));

		for (String a : arr) {
			Integer chavePublica = calcularPK(fi);

			BigInteger exp = null;
			BigInteger m = new BigInteger(a);
			exp = m.pow(chavePublica);

			BigInteger resultado = exp.mod(BigInteger.valueOf(tamConjunto));

			cipheredWord = cipheredWord + resultado + " ";
		}
		//System.out.println("\n" + cipheredWord);
	}

	public String getCipheredWord() {
		return cipheredWord;
	}

	public void setCipheredWord(String cipheredWord) {
		this.cipheredWord = cipheredWord;
	}

	public Integer getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(Integer publicKey) {
		this.publicKey = publicKey;
	}

	public Integer getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(Integer privateKey) {
		this.privateKey = privateKey;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}
