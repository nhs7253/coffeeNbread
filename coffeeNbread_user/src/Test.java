import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		String str = pass.encode("1111");
		System.out.println(str);
		
		String storeCategory = "abcd";
		String remverEndChar = storeCategory.substring(0, storeCategory.length()-1);
		System.out.println(remverEndChar);
	}
}
