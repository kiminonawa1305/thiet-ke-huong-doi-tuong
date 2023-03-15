package model;

import java.util.*;

public interface OptionQuestion {
	public boolean answer(Set<String> listAnswer);
	
	public Map<String, Boolean> getListAnswer();
}
