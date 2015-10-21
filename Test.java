
/**
 * @author roberson
 *
 */
public class Test {
	public static void main(String[] args) {
		Cipher c = new Cipher();

		c.setPublicKey(17);
		c.setPrivateKey(41);
		c.setWord("Roberson");
		c.DoCipher();

		System.out.println(c.getCipheredWord());
	}
}
