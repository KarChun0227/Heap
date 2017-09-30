import java.util.ArrayList;

public class Heap<T extends Comparable<T>>
{
	private ArrayList<T> items;
	
	public Heap()
	{
		items = new ArrayList<T>();
	}
	//@Override
	public void add(T newEntry1) 
	{
		items.add(newEntry1);
		swapUp();
	}

	//@Override
	public T removeMax() 
	{
		T hold;
		if(!items.isEmpty())
		{
			hold = items.get(0);
			items.remove(0);
			swapDown();
			return hold;
		}
		else
		{
		return null;
		}
		
	}

	//@Override
	public T getMax() 
	{
		if(items.size() >= 0)
		{
			return items.get(0);
		}
		else;	
		return null;
	}

	//@Override
	public boolean isEmpty() 
	{
		return items.isEmpty();
	}

	//@Override
	public int getSize() 
	{
		return items.size();
	}

	//@Override
	public void clear() 
	{
		items.removeAll(items);
	}
	
	public String toString()
	{
		return items.toString();
	}
	
	private void swapUp()
	{
		int k = items.size()-1;
		while (k > 0)
		{
			int p = (k-1)/2;
			T item = items.get(k);
			T parent = items.get(p);
			if(item.compareTo(parent) > 0)
			{
				items.set(k, parent);
				items.set(p, item);
				
				k = p;
			}
			else
			{
				break;
			}
		}
	}
	
	private void swapDown()
	{
		int k = 0;
		int l = 2*k+1;
		while(l < items.size())
		{
			int cl = l ; 
			int cr = cl + 1;
			if(cr < items.size())
			{
				if(items.get(cr).compareTo(items.get(l)) > 0)
				{
					cl ++;
				}	
				if(items.get(cl).compareTo(items.get(l)) < 0)
				{
					T tmp = items.get(k);
					items.set(k, items.get(cl));
					items.set(cl, tmp);
					k = cl;
					l = 2*k+1;
				}else{
					break;
				}
			}else
			{
				break;
			}
		}
	}
	
	public T wordSearch(CharSequence word)
	{
		T result = null;
		for(int i = 0; i < items.size(); )
		{
			int k = 0;
			int l = 2 * k + 1;
			int r = l + 1;
			int p = (k - 1) / 2;
			if(items.get(k).toString().contains(word))
			{
				result = items.get(k);
			}
			if(items.get(l).compareTo((T) word) > 0)
			{
				k =l;
			}
			if(items.get(l).compareTo((T)word) < 0 && items.get(r).compareTo((T) word) < 0)
			{
				k =p;
			}
			
			
		}
		return result;
	}
	
}
