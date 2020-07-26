import java.util.HashSet;
import java.util.Set;

public class EmailAddresses {

	public static void main(String[] args) {
		
		String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		
		Set<String> mails = new HashSet<>();
        for(String str : emails) {
            String[] parts = str.split("@");
            mails.add(parts[0].split("\\+")[0].replaceAll("\\.", "") + "@" + parts[1]);
        }
        
        System.out.println(mails.size());
	}
}
