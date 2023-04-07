public class ForLoop {
    public static String what(String s)
{
	int[] c = new int [26];
	String res = "";

	for (int i=0; i<s.length(); i++)
	{
		int p = s.charAt(i) - 'a';
		c[p]++;
	}
	for (int i=0; i<c.length; i++)
	{
		if (c[i] != 0)
		{
			char ch = (char)('a'+ i);
			res += ch;
		}
	}
	return res;
}

public static boolean secret(String s1, String s2)
{
	return what(s1).equals(what(s2));
}
}
