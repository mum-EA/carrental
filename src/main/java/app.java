import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.mum.cs544.abccarrental.aop.MethodName;

public class app {

	public static void main(String[] args) {
		List<String> lists = new ArrayList<String>();
		lists.add("ylulie4@gmail.com");
		lists.add("yishe5@gmail.com");
		System.out.println(StringUtils.join(lists, ','));
		System.out.println(new MethodName().homePage);
	}
}
