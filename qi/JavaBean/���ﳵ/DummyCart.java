package sessions;
import java.util.Vector;
import java.util.Enumeration;
public class DummyCart
{
	Vector v = new Vector();
	String submit = null;
	String item = null;
	private void addItem(String name)
	{
		v.addElement(name);
	}
	private void removeItem(String name)
	{
		v.removeElement(name);
	}
	public void setItem(String name)
	{
		item = name;
	}
	public void setSubmit(String s)
	{
		submit = s;
	}
	public String[] getItems()
	{
		String[] s = new String[v.size()];
		v.copyInto(s);
		return s;
	}
	public void processRequest()
	{
		if(submit.equals("add"))
		{
			addItem(item);
		}
		else if(submit.equals("remove"))
		{
			removeItem(item);
		}
		reset();
	}
	private void reset()
	{
		submit =  null;
		item = null;
	}
}