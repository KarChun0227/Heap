

import java.util.Objects;

public class Word implements Comparable<Word>
{
	String spanish,english;
	
	
	public String getSpanish() 
	{
		return spanish;
	}

	public void setSpanish(String spanish) 
	{
		this.spanish = spanish;
	}

	public String getEnglish() 
	{
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public Word()
	{
	}
	
	public Word(String spanish, String english)
	{
		this.spanish = spanish;
		this.english = english;
	}
	
	
	
	@Override
	public String toString() {
		return "Word [spanish=" + spanish + ", english=" + english + "]";
	}

	@Override
//	public String toString()
//	  {
//	    return toStringHelper(this).addValue(english)
//	                               .addValue(spanish)
//	                               .toString();
//	  }
	
	public boolean equals(final Object obj)
	 {
		if (obj instanceof Word)
	 {
	 final Word other = (Word) obj;
	 	return Objects.equals(english, other.english)
	 			&& Objects.equals(spanish, other.spanish);
	 }
	 else
	 {
		 return false;
	 }
	 }

	@Override
	public int compareTo(Word o) 
	{
		return this.getSpanish().compareTo(o.getSpanish());
	}
	
}
